app.controller('productDetailsController',function($scope, $http, productService) {
	var person;
	$scope.getproductDetails = function() {
		productService.getproductDetails().success(function(user) {
			$scope.person = user;
			
			});
	};
	
});

