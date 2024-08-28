const uniserver = require('./uniserver');
const PORT      = 3000;

var server = new uniserver();

server.get('/', function(req, res) {
    res.html('This is home page');
});

server.get('api/home', function(req, res) {
    res.html('This is home page');
});

server.get('api/sell', function(req, res) {
    res.html('Sell me some tikkets baby')
});

server.run(PORT, function() {
    console.log(`Server already sterted on port ${PORT}`)
});