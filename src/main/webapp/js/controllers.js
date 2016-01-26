'use strict';

/* Controllers */

var brewControllers = angular.module('brewControllers', ['geolocation']);

brewControllers.controller('TopBrewListCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

  $http.get('brew/best').success(function (data) {
    $scope.brews = data;
    $scope.brew = $scope.brews[$routeParams.id];
  });

}]);

brewControllers.controller('CategoryListCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

  $http.get('brew/categories').success(function (data) {
    $scope.categories = data;
  });

}]);

brewControllers.controller('GeoCtrl', ['$scope', '$http', 'geolocation', function ($scope, $http, geolocation) {

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