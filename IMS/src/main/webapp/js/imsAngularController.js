
var app = angular.module('myApp', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
	
	.state("home", {
		url			: "/",
		templateUrl : "parts/home/home.html",
		controller  : "homeController"
	})
	
	.state("login", {
		url			: "/login",
		templateUrl : "parts/home/login.html",
		controller  : "loginController"
	})
	
	.state("userDetails", {
		url			: "/userDetails",
		templateUrl : "parts/home/userDetails.html",
		controller  : "userDetailsController"
	})
	.state("productDetails", {
		url			: "/productDetails",
		templateUrl : "parts/product/productDetails.html",
		controller  : "productDetailsController"
	})

});