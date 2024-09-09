var fs                      = require('fs');
var cp                      = require('child_process');

var repositoryCollection    = require('./mocks/repositories.json');



var parseObjectBlockCollection = function(blockRepository) {

    var currentRepository = null;
    for(var i = 0; i < blockRepository.length; i++) {
        currentRepository = blockRepository[i];
        console.log(currentRepository.html_url);
        cp.exec('git clone ' + currentRepository.html_url + ' test_block/' +  currentRepository.name);
        //  git clone 
    }
};

// execute
parseObjectBlockCollection(repositoryCollection);


//console.log(repositoryCollection[0].node_id);


var template = function(dirName) {
    return '__tmp/' + dirName // __tmp/dir_name
};

var templateCollection = function() {
    // console.log(arguments);
    // TODO : 
    //var path = arguments[0] + "/";

    // Version on 1
    // var path = "";
    // for(var i = 0; i < arguments.length; i++) {

        
    //     // 0 - a
    //     // 1 - b
    //     // 2 - c
    //     // a/b/c
    //     // path = arguments[i] + "/";

    //     // end of loop
    //     // path = arguments[i];

    //     // if(i == (arguments.length - 1)) {
    //     //     path = arguments[i];    
    //     // }
    //     // else {
    //     //     path = arguments[i] + "/";    
    //     // }


    //     // if(i == arguments.length) {
    //     //     path += (arguments[i]);    
    //     // }
    //     // else {
    //     //     path += (arguments[i] + "/");
    //     // }
    // }

    
    // Version on 1
    if(arguments.length == 0) {
        return "";
    }

    // 0 -> a
    // a

    var path = arguments[0];
    for(var i = 1; i < arguments.length; i++) {
        path = path + '/' + arguments[i];
    }

    return path;
};

var path = templateCollection('__tmp', 'wallet', 'my_wallet.txt');
// console.log(path);
// __tmp/wallet/my_wallet.txt



// fs.mkdirSync('bootsrap');
// fs.mkdirSync('profile');

// fs.mkdirSync(templateCollection('__tmp'));
// fs.mkdirSync(templateCollection('__tmp', 'bootstrap'));
// fs.mkdirSync(templateCollection('__tmp','profile'));
// fs.mkdirSync(templateCollection('__tmp','wallet'));

// fs.writeFileSync(templateCollection('__tmp', 'wallet', 'my_wallet.txt'), 'Hello world \n', {
//     flag: 'a'
// });

// fs.writeFileSync(templateCollection('__tmp', 'wallet', 'my_wallet.txt'), 'Mihail Petrov \n', {
//     flag: 'a'
// });
