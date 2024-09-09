var crypto = require('crypto-js');
var fs     = require('fs');
var util   = require('../lib/util');

var hashProfile      = []; 
var _salt            = 'kjfhjhgfdsfgdkcgfdcfsdyfe';

for(let i = 0; i < 100; i++) {

    // Examples
    // var getTime = (new Date()).getTime();
    // var stringId = 'ygdfghfgdgdhgfdfdfdfdf';
    // var newHashId = (getTime + stringId).toString();
    // var newHashId2 = (stringId + getTime);
    // var templateHash = `${stringId} ${getTime}`;
    
    
    // console.log((new Date()).getTime());
    // console.log(newHashId);
    // console.log(crypto.SHA256(newHashId));
    // console.log(crypto.SHA256(newHashId2));
    // console.log(crypto.SHA256(templateHash).toString());

    //console.log((new Date()).getTime())
    // console.log(crypto.SHA256((new Date()).getTime() + _salt).toString())
    hashProfile.push({
        wallet_id   : crypto.SHA256((new Date()).getTime() + _salt).toString(),
        ammount     : util.generateAmmount()
    });
}

//console.log(hashProfile);
var buildProfileString = JSON.stringify(hashProfile);
fs.writeFileSync('../__tmp/profile/profile-all.json', buildProfileString);