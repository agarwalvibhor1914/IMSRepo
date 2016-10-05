
var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
	
	.when("/", {
		templateUrl : "parts/login.html",
		controller  : "loginController"
	})
	
	.when("/home", {
		templateUrl : "parts/home.html",
		controller  : "homeController"
	})

});

app.controller('loginController', function($scope, $http) {
	$scope.getDataFromServer = function($location) {
		$scope.id = {};
		$http({
			method : 'POST',
			url : 'rest/userService/varify',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : $scope.userDetails
		}).success(function(data, status, headers, config) {
			$scope.person = data;
			$scope.error=null;
			//$location.path('/HomePage');
		}).error(function(data, status, headers, config) {
			$scope.person = null;
			$scope.error = data;
		});

	};
});
