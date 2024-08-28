// Note : hack for short paths
const translate = require('../../utils/translate');

var ApiRefernce = (app, db) => {

    /**
     * 
     */
    app.get('/books', (req, res) => {
        
        //var limit = req.query.limit || 2;
        var bookCollection = db.select('books', null, {
            limit   : req.filterdata.limit,
            skip    : req.filterdata.skip
        });
        
        res.status(200).send({
            message     : 'Success fetch',
            collection  : bookCollection
        });
    });

    /**
     * 
     */
    app.post('/books', (req, res) => {
        
        if(!req.body.title) {
            return res.status(405).send({
                message : translate(req.metadata.lang, 'ERROR')
            })
        }

        if(req.body.isbn.length > 15) {

            return res.status(405).send({
                message : translate(req.metadata.lang, 'ERROR')
            })
        }

        var record = db.insert('books', req.body);

        res.status(200).send({
            message     : translate(req.metadata.lang, 'SUCCESS'),
            collection  : [record]
        })
    });


    app.get('/books/:id', (req, res) => {

        // get language
        // var lang = req.header('lang');

        // URL parameter object
        console.log(req.params);
        var id = req.params.id;

        var collection = db.select('books', {
            '__id' : id
        });

        if(collection.length == 1) {

            return res.status(200).send({
                message     : translate(req.metadata.lang, 'API_BOOKS_FETCH_SUCCESSS'),
                collection  : collection
            })
        }

        return res.status(404).send({
            message : translate(req.metadata.lang, 'API_BOOKS_FETCH_ERROR')
        })
    });
}

module.exports = ApiRefernce; 