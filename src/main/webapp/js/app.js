var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/repairStations',{
            templateUrl: 'html/projects.html',
            controller: 'repairStationsController'
        })
        .when('/carWashStations',{
            templateUrl: 'html/createProject.html',
            controller: 'carWashStationsController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

