var Ajax = {

    ajax : null,
 
    init() {
 
        if(!this.ajax) {
            this.ajax = new XMLHttpRequest();  
        }
 
        return this.ajax;
    },
 
    get(url, callback) {
 
        var request = this.init();
        request.open("GET", url)
        request.send();
        request.onload = () => {
            console.log(request.statusCode);
            callback(JSON.parse(request.responseText));
        };
    },
 
    post(url, data, callback) {
 
        var request = this.init();
        request.open("POST", url);
        request.send(data);
        request.onload = () => {
            callback(JSON.parse(request.responseText));
        };
 
    }
 };
 
 Ajax.get("https://reqres.in/api/users", (data) => {
    console.log(data);
 });
 
 var objectRequestData = {
    "name": "morpheus",
    "job": "leader"
 };
 
 Ajax.post("https://reqres.in/api/users", objectRequestData, (data) => {
    console.log(data);
 });
 
 
 // var ajax = new XMLHttpRequest();
 // // open : GET / POST / PUT / DELETE / PATCH / OPTION
 // ajax.open("GET","https://reqres.in/api/users");
 
 // // send : data
 // ajax.send();
 
 // // execution : response
 // ajax.onload = () => {
 
 //     console.log("Yes we send data");
 //     console.log(ajax.responseText)
 //     console.log(JSON.parse(ajax.responseText));
 
 //     var collection      = JSON.parse(ajax.responseText);
 //     var userCollection  = collection.data;
 //     var user            = userCollection[0];
   
 //     ajax.open("GET", `https://reqres.in/api/users/${user.id}`);
 
 //     ajax.onload = () => {
       
 //         console.log("Internal transaction");
 //         console.log(JSON.parse(ajax.responseText));
 //     };
 
 //     ajax.send();
 // };
 
 
 