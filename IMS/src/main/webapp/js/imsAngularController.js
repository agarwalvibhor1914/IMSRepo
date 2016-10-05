
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

app.controller('loginController', function($scope, $http, $location) {
	$scope.getDataFromServer = function() {
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
			$location.path('/home');			
		}).error(function(data, status, headers, config) {
			$scope.person = null;
			$scope.error = data;
		});

	};
});



app.controller('homeController', function($scope) {
	$scope=data;
});

