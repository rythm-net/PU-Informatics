// Musaka.load("home");


Musaka.router('application-root', {
    'home' : {
        component   : 'home',
        isDefault   : true,
        interceptor : () => {
            // TODO process interceptor
        }
    },
    'students' : {
        component : 'student'
    },

    'aboutus'   : {
        component : 'aboutus'
    }
});