
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

app.service('loginService', function($http) {
	var personDetails;
	  this.varifyUser = function varifyUser(loginInfo) {
		  return $http({
				method : 'POST',
				url : 'api/userService/varify',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : loginInfo
			});
	  };
	  this.getPersonDetails = function () {                
          return this.personDetails;
       }
});

app.controller('loginController', function($scope, $http, $location, loginService) {
	var person;
	$scope.getDataFromServer = function() {
		loginService.varifyUser($scope.userDetails).success(function(user) {
			$scope.person = user;
			loginService.personDetails=user;
			$location.path('/home');
			});
	};
});



app.controller('homeController', function($scope,loginService) {
	$scope.init = function (){
		$scope.person= loginService.getPersonDetails();
	};
});

