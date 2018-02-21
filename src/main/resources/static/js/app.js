var app = angular.module("encuesta", ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    //note that this line does the magic ;)
    $locationProvider.hashPrefix('');
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : '../fragments/encuesta.html',
        })

        // route for the candies page
        .when("/encuestas", {
            templateUrl : "../fragments/encuesta.html",
            controller  : "encuestaController",
            controllerAs: "eCtrl"
        })

        // route for the sales page
        .when('/usuarios', {
            templateUrl : '../fragments/usuario.html',
            controller  : 'usuarioController',
            controllerAs: 'uCtrl'
        })

        // route for the details page
        .when('/estadisticas', {
            templateUrl : '../fragments/estadistica.html',
            controller  : 'estadisticaController',
            controllerAs: 'sCtrl'
        })

        // predefined route
        .otherwise({
            redirectTo : '/'
        });
});