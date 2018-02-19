var app = angular.module("moncas", ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    //note that this line does the magic ;)
    $locationProvider.hashPrefix('');
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : '../fragments/home.html',
        })

        // route for the candies page
        .when("/candy", {
            templateUrl : "../fragments/candy.html",
            controller  : "candyController",
            controllerAs: "cCtrl"
        })

        // route for the sales page
        .when('/sale', {
            templateUrl : '../fragments/sale.html',
            controller  : 'saleController',
            controllerAs: 'sCtrl'
        })

        // route for the details page
        .when('/detail', {
            templateUrl : '../fragments/detail.html',
            controller  : 'detailController',
            controllerAs: 'dCtrl'
        })

        // predefined route
        .otherwise({
            redirectTo : '/'
        });
});