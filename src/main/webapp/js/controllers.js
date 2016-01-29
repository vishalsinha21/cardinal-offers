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

offerControllers.controller('WeatherCtrl', ['$scope', '$http', 'geolocation', function ($scope, $http, geolocation) {

  geolocation.getLocation().then(function(data){
    $scope.coords = {lat:data.coords.latitude, long:data.coords.longitude};

    var url = "http://api.openweathermap.org/data/2.5/weather?lat=" + $scope.coords.lat + "&lon=" + $scope.coords.long + "&units=metric&appid=44db6a862fba0b067b1930da0d769e98";
    
    $http({
      url: url,
      method: "GET"
    }).success(function (data) {
      $scope.weather = data;
      console.log($scope.weather);
    });
  });

}]);

offerControllers.controller('RestaurantDetailsCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

    $http({
      url: 'brew/restaurant/'+$routeParams.id,
      method: "GET"
    }).success(function (data) {
      $scope.restaurant = data.result;
      console.log($scope.restaurant);
    });

}]);