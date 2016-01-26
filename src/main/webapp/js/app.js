'use strict';

/* App Module */

var cardinalApp = angular.module('cardinalApp', [
  'ngRoute',
  'offerControllers'
]);

cardinalApp.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.
        when('/offers', {
          templateUrl: 'offers.html',
          controller: 'GeoCtrl'
        }).
        when('/restaurants', {
          templateUrl: 'restaurants.html',
          controller: 'RestaurantCtrl'
        }).
        otherwise({
          redirectTo: '/restaurants'
        });
  }]);
