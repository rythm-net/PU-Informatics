Musaka.component('home', {

    template    : 'components/home/template.html',
    controller  : () => {
        console.log("Hello from HOME controller");
        // window.location.href
        console.log(window.location.href);

        window.onhashchange = () => {
            var urlCollection = (window.location.href).split('#/');
            var url = null;

            if(urlCollection && urlCollection.length >= 2) {
                url = urlCollection[1];
                console.log(`Component : ${url}`);
            }
        };
    }
})