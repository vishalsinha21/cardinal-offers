'use strict';

/* Controllers */

var offerControllers = angular.module('offerControllers', ['geolocation']);

offerControllers.controller('GeoCtrl', ['$scope', '$http', 'geolocation', function ($scope, $http, geolocation) {

  geolocation.getLocation().then(function(data){
    $scope.coords = {lat:data.coords.latitude, long:data.coords.longitude};

    $http({
      url: 'brew/offers',
      method: "GET",
      params: {lat: $scope.coords.lat, long: $scope.coords.long}
    }).success(function (data) {
      $scope.offers = data;
      console.log($scope.offers);
    });
  });
  
}]);

offerControllers.controller('RestaurantCtrl', ['$scope', '$http', 'geolocation', function ($scope, $http, geolocation) {

  geolocation.getLocation().then(function(data){
    $scope.coords = {lat:data.coords.latitude, long:data.coords.longitude};

    $http({
      url: 'brew/restaurants',
      method: "GET",
      params: {lat: $scope.coords.lat, long: $scope.coords.long}
    }).success(function (data) {
      $scope.offers = data;
      console.log($scope.offers);
    });
  });
  
}]);