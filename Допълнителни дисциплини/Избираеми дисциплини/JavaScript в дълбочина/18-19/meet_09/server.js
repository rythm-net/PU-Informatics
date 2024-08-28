const http = require('http');
const fs = require('fs');
const port = 3000;
const app = http.createServer((req,res) => {
    res.writeHead(200);
    console.log(__dirname)
    res.end(fs.readFileSync(__dirname + req.url));
});

app.listen(port);