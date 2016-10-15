
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

app.service('loginService', function() {
	  var userDetails = this;

	  var addProduct = function(newObj) {
	      productList.push(newObj);
	  };

	  var getProducts = function(){
	      return productList;
	  };

	  return {
	    addProduct: addProduct,
	    getProducts: getProducts
	  };

	});

app.controller('loginController', function($scope, $http, $location) {
	$scope.getDataFromServer = function() {
		$scope.id = {};
		$http({
			method : 'POST',
			url : 'api/userService/varify',
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

