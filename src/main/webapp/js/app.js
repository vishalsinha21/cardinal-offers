'use strict';

/* App Module */

var cardinalApp = angular.module('cardinalApp', [
  'ngRoute',
  'offerControllers'
]);

cardinalApp.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.
        when('/restaurants', {
          templateUrl: 'restaurants.html',
          controller: 'RestaurantCtrl'
        }).
        when('/offers', {
          templateUrl: 'offers.html',
          controller: 'GeoCtrl'
        }).
        when('/weather', {
          templateUrl: 'weather.html',
          controller: 'WeatherCtrl'
        }).
        otherwise({
          redirectTo: '/restaurants'
        });
  }]);
