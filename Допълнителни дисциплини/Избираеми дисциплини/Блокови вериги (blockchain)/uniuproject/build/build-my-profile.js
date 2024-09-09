var crypto = require('crypto-js');
var fs     = require('fs');
var util   = require('../lib/util');

var _salt = 'dkfhdsjcfdhgfdhgfghsgcfdsgc';
var hashProfile      = {
    wallet_id : crypto.SHA256((new Date()).getTime() + _salt).toString(),
    ammount   : util.generateAmmount()
};

var buildProfileString = JSON.stringify(hashProfile);
fs.writeFileSync('../__tmp/wallet/my-wallet.json', buildProfileString);