const http      = require('http');
const Request   = require('./unirequest');
const Response  = require('./uniresponse');

const uniserver = function() {
    this.endpointCollection = {};
};

uniserver.prototype.get = function(path, callback) {
    this.endpointCollection[path] = callback;
};

uniserver.prototype.run = function(port, callback) {

    this.serverInstance = http.createServer((req, res) => {

        var path        = req.url;
        var collection  = path.split('/');
        collection.shift();
        var basePath    = collection.join('/')

        var requestReference  = new Request(req);
        var responceReference = new Response(res);

        this.endpointCollection[basePath](requestReference, responceReference);
    });

    this.serverInstance.listen(port);
    callback();
};

// module 
module.exports = uniserver;