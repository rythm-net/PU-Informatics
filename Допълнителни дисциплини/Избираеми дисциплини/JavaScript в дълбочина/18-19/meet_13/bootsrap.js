const express = require('express');
const bodyParser = require('body-parser');

const app     = express();
const PORT    = 3012;
const db      = require('./db/mydb');
const jwt     = require('jsonwebtoken'); 

const api     = {
    base  : require('./api/base/script'),
    books : require('./api/books/script')
}

const isRequestPermitable = (path, role) => {

    var ROUTE_PERMITION_MAP = {

        '/'             : ['backoffice'],
        '/auth'         : ['*']
    }

    var pathPermitionCollection = ROUTE_PERMITION_MAP[path];
    if(!pathPermitionCollection) {
        return false;
    }

    for(var i = 0; i < pathPermitionCollection.length; i++) {
        
        if(pathPermitionCollection[i] == '*') {
            return true;
        }

        // succkess 
        if(role == pathPermitionCollection[i]) {
            return true;
        }
    }

    return false;
};


// Use Middleware
app.use(bodyParser.json());

// 
app.use((req, res, next) => {

    req.metadata = {
        lang : (req.header('lang') || 'en')
    };

    next();
});

//  
app.use((req, res, next) => {

    req.filterdata = {
        limit   : req.query.limit || 10,
        skip    : req.query.skip  || 0
    };

    next();
});


// Authentication token middleware
app.use((req, res, next) => {

    if(req.path == '/auth' && req.method == 'POST') {
        return next();
    }

    var tokken  = req.header('x-authenticated');
    if(tokken) {

        try {

            var tokkenRequest = jwt.verify(tokken, 'tainamaina');
            req.role = tokkenRequest.role;
            return next();
        }
        catch(error) {

            return res.status(400).send({
                message : 'Invalid tokken request'
            });
        }

        return next();
    }

    return res.status(400).send({
        message : 'No authentication token provided'
    });
});


app.use((req, res, next) => {

    if(isRequestPermitable(req.path, req.role)) {
        return next();
    }

    return res.status(403).send({
        message : 'No permitions for accessing this route'
    });

})


// db.insert('books', {
//     title   : 'Test',
//     author  : 'Mihail'
// });

// var collection = db.select('books');
// console.log(collection);

// var whereCollection = db.select('books', {
//     'author' : 'Todor'
// });

// console.log(whereCollection);


/**
 * @endpoint : /
 * @method   : GET
 * @description : Get the main information
 */
app.get('/', (req, res) => {
    res.status(200).send('Hello world');
});

/**
 * @endpoint : /base
 * @method   : POST | GET
 * @description : All base api references
 */
api.base(app, db);

/**
 * @endpoint : /books
 * @method   : GET
 * @description : Get the books collection data
 */
api.books(app, db);

app.listen(PORT, () => {
    console.log(`Application server running on ... ${PORT}`);
});