const http  = require('https');
const fs    = require('fs');

const githubEndpoint = 'https://api.github.com';

// Refernse helper 
// In order not to change the function names on more than one place
var ModuleReference = {};

ModuleReference.getAllGithubRepositoryCollectionFromHTTP = function(githubHandler, callback) {
    
    var requestEndpoint = `${githubEndpoint}/users/${githubHandler}/repos`;

    const requestParameterCollection = {
        headers : {
            'User-Agent' : 'Test User Agent'
        }
    };

    var requestStreamCollection = [];
    var responseObject          = null;

    // 11.+
    http.get(requestEndpoint, requestParameterCollection,  function(res) {
        
        res.on('data', function(chunk) {
            requestStreamCollection.push(chunk);
        });
        
        res.on('end', function() {

            responseObject = JSON.parse(requestStreamCollection.join(''));
            callback(responseObject);
        });
    });
};


ModuleReference.getAllGithubRepositoryCollectionFromFile = (handler, callback) => {
    
    // short hand
    // var responseObject  = JSON.parse((fs.readFileSync('./mock/api.json')).toString());
    
    // long hand
    var fileBuffer      = fs.readFileSync('./mock/api.json');
    var fileString      = fileBuffer.toString();
    var responseObject  = JSON.parse(fileString)

    callback(responseObject);
};


module.exports = ModuleReference;