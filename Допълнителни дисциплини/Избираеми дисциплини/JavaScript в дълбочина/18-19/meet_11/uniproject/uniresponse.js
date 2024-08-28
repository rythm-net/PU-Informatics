const Response = function(resp) {
    this.responseObject = resp;
};

Response.prototype.html = function(string) {

    this.responseObject.write(string);
    this.responseObject.end();
};



module.exports = Response;