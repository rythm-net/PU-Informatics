// Note : hack for short paths

const jwt       = require('jsonwebtoken');
const translate = require('../../utils/translate');

var ApiRefernce = (app, db) => {

    app.post('/auth', (req, res) => {

        // input
        var username = req.body.username;
        var password = req.body.password;

        // 
        if(username == 'admin' && password == 'password') {

            var tokken = jwt.sign({ role : 'admin'}, 'tainamaina', {
                "expiresIn" : 120
            });

            return res.status(200).send({
                message: 'Success authentication',
                tokken : tokken
            })
        }

        return res.status(403).send({
            message : 'Permition not granted, wrong username or password'
        })
    });
}

module.exports = ApiRefernce; 