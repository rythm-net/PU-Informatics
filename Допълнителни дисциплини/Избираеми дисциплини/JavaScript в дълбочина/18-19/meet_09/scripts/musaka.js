var Musaka = {

    componentCollection: {},

    component(name, componentMetaData) {
        this.componentCollection[name] = componentMetaData;
    },

    load(name, placeholder) {

        // get DOM element 

        // execute innerHTML 

        // execute controller functionality
        var componentElement = this.componentCollection[name];
        if(componentElement && componentElement.controller) {
            componentElement.controller();
        }

        // if(this.componentCollection[name]) {

        //     var componentElement = this.componentCollection[name];
        //     if(componentElement.controller) {
        //         componentElement.controller();
        //     }
        // }
    },

    router(placeholder, routeCollection) {

        var routeComponentLoadingProcess = () => {

            var urlCollection = (window.location.href).split('#/');
            var url = null;
    
            if(urlCollection && urlCollection.length >= 2) {
    
                url             = urlCollection[1];
                var component   = routeCollection[url];
    
                // load component
                Musaka.load(component.component, placeholder);
            }
        };
        
        routeComponentLoadingProcess();

        // window.onhashchange = () => {
        //     routeComponentLoadingProcess();
        // };

        // window.onhashchange = () => 
        //     routeComponentLoadingProcess();

        window.onhashchange = routeComponentLoadingProcess;
    }
};