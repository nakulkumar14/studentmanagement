var myApp = angular.module("myApp",['ui.router']);

myApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider
    // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/',
            templateUrl: 'index.html'
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('student_add', {
            // we'll get to this in a bit
            url: '/student_add',
            views: {
                // the main template will be placed here (relatively named)
                '': { templateUrl: 'views/student_add.html' }
            }
        })
        .state('student_search', {
        // we'll get to this in a bit
        url: '/student_search',
        views: {
            // the main template will be placed here (relatively named)
            '': { templateUrl: 'views/student_form.html' }
        }
        });

});