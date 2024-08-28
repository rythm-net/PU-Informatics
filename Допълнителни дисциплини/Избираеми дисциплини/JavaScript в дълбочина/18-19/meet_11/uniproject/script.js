const http = require('http');
const fs   = require('fs');
const PORT = 3000;


// count variable
var count = 1;
const server = http.createServer(function(request, response) {

    if(request.url == '/home') {
        response.write('<h1>HOME PAGE</h1>');    
    }

    if(request.url == '/sell') {
        response.write('<h1>SELL TICKET</h1>');
    }

    if(request.url == '/count') {

        response.write(`<h1>Current count is : ${count}</h1>`);
        fs.writeFileSync(`count__${count}`, count);
        count++;        
    }

    // console.log(request);
    // console.log(response);

    // response.writeHead(404, {
    //     'content-type' : 'text/plain'
    // })
    //response.write('<h1>Hello World</h1>');
    response.end();

    // create new file with name count__{count}
    //fs.writeFileSync(`count__${count}`, count);
    //count++;
});

server.listen(PORT);
console.log(`Server started on port numbered : ${PORT}`);