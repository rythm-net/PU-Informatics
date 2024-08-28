const fs        = require('fs');
const cp        = require('child_process');

const github    = require('./githib/script');

// indexOf


// github.getAllGithubRepositoryCollection('mihail-petrov', (data) => {

//     for(var element in data) {
//         console.log(data[element]);
//         //fs.mkdirSync(`projects/${data[element].name}`, { recursive : true });
//     }
// });

github.getAllGithubRepositoryCollectionFromFile('mihail-petrov', (data) => {

    // parse input data from the command line interface
    const inArgumentIndex = process.argv.indexOf('-in');
    var inArgumentContent = '__system_download__';
    if(inArgumentIndex != '-1') {
        inArgumentContent = process.argv[inArgumentIndex + 1];
    }


    // global NODEJS object for allot of tasks
    var folder = process.argv[2];

    for(var element in data) {
        // fs.mkdirSync(`projects/${data[element].name}`, { recursive : true });
        // git clone https://github.com/blackmiaool/angular-schema-form
        cp.exec(`git clone ${data[element].html_url} ${inArgumentContent}/${data[element].name}`);
    }
});




// * get all repository from endpoint
// * execute git clone 
// * create dyrectrory
// * store all directories