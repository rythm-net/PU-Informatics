var Block = require('./block');

var Blockchain = function(title) {

    this.blockCollection    = [];
    this.initDate           = new Date(); 
    this.title              = title;

    // create genesis blockl
    this.initGenesisBlock();
};

Blockchain.prototype.getLastBlock = function() {
    
    var lastBlockIndex = this.blockCollection.length - 1;
    return this.blockCollection[lastBlockIndex];
};

Blockchain.prototype.initGenesisBlock = function() {
    this.addBlock(new Block({ from: '', to: '', ammount: ''}))
};

Blockchain.prototype.addBlock = function(block) {
    this.blockCollection.push(block);
};

Blockchain.prototype.mainNewBlock = function(transactionObject) {
    
    var newBlock      = new Block(transactionObject);
    console.log("Mine id : " + newBlock.getId());

    // if transaction length 5 -> 2
    // if transaction length 10 -> 3
    // if transaction length 10 -> 3 
    var transactionComplexity = this.getTransactionComplexity();

    if(newBlock.mineBlock(transactionComplexity)) {
        
        var lastBlockchainBlock = this.getLastBlock();

        // gte the hash from last block
        var lastBlockchainHash  = lastBlockchainBlock.getHash();
        newBlock.setPrevBlockReference(lastBlockchainHash);
        
        // add to blockchain network
        this.addBlock(newBlock);
    }

    console.log("Transaction id: " + newBlock.getHash());
    console.log("**")
    console.log("**")
    console.log("Number of success transactions " + this.blockCollection.length);
};

Blockchain.prototype.isBlockchainValid = function() {
    // TODO: development
};


Blockchain.prototype.getTransactionComplexity = function() {
    
    if(this.blockCollection.length > 25 ) {
        return 6;
    }

    if(this.blockCollection.length > 20 ) {
        return 5;
    }

    if(this.blockCollection.length > 15 ) {
        return 4;
    }

    if(this.blockCollection.length > 10 ) {
        return 3;
    }

    if(this.blockCollection.length > 5 ) {
        return 2;
    }

    return 1;
};

Blockchain.prototype.getInfo = function() {
    return "Blockchain : " + this.title + " created on " + this.initDate;
}


module.exports = Blockchain;