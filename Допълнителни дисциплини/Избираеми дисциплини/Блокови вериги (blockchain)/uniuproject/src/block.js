var util = require('../lib/util');

var Block = function(transaction) {

    // meta information
    this._id                    = util.generateBlockId();
    //this.prevBlockReference     = reference;
    // this.nextBlockreference = null;
    this.blockGenerationIterator = 1;

    // transaction information
    this.from       = transaction.from;
    this.to         = transaction.to;
    this.amount     = transaction.amount;
    this.hash       = this.calculateHash();
};

Block.prototype.calculateHash = function() {
    return util.hashBlockContent(`${this._id} ${this.from} ${this.to} ${this.amount} ${this.blockGenerationIterator}`);
};

// get 
Block.prototype.getId = function() {
    return this._id;
}

Block.prototype.getHash = function() {
    return this.hash;
}

Block.prototype.setPrevBlockReference = function(hash) {
    this.prevBlockReference = hash;
}

Block.prototype.mineBlock = function(complexity) {

    var blockInprint    = new Array(complexity + 1);
    var blockImprintString = blockInprint.join('0'); 

    while(this.hash.substring(0, complexity) != blockImprintString) {

        this.hash = this.calculateHash();
        this.blockGenerationIterator++;
    }

    return true;
};

Block.prototype.getInfo = function() {

    console.log("*** BLOCK INFO ***");
    console.log(`ID: ${this._id}`);
    console.log("HASH:" + this.hash);
};

module.exports = Block;