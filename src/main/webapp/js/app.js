'use strict';

/* App Module */

var brewApp = angular.module('brewApp', [
  'ngRoute',
  'brewControllers'
]);

brewApp.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.
        when('/brews', {
          templateUrl: 'main.html',
          controller: 'TopBrewListCtrl'
        }).
        when('/brews/:id', {
          templateUrl: 'brew-details.html',
          controller: 'TopBrewListCtrl'
        }).
        when('/category', {
          templateUrl: 'categories.html',
          controller: 'CategoryListCtrl'
        }).
        when('/review', {
          templateUrl: 'review.html',
          controller: 'CategoryListCtrl'
        }).
        when('/offers', {
          templateUrl: 'offers.html',
          controller: 'GeoCtrl'
        }).
        otherwise({
          redirectTo: '/brews'
        });
  }]);
