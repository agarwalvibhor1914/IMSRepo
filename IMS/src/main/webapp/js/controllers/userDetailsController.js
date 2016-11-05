
app.controller('userDetailsController', function($scope,loginService) {
	$scope.init = function (){
		$scope.person= loginService.getPersonDetails();
	};
});

