
var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
	
	.when("/login", {
		templateUrl : "parts/home/login.html",
		controller  : "loginController"
	})
	
	.when("/home", {
		templateUrl : "parts/home/home.html",
		controller  : "homeController"
	})
	
	.when("/userDetails", {
		templateUrl : "parts/home/userDetails.html",
		controller  : "userDetailsController"
	})

});