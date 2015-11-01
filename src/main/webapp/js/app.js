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
        otherwise({
          redirectTo: '/brews'
        });
  }]);
