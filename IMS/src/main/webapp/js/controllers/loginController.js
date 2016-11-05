app.controller('loginController', function($scope, $http, $location, loginService) {
	var person;
	$scope.getDataFromServer = function() {
		loginService.varifyUser($scope.userDetails).success(function(user) {
			$scope.person = user;
			loginService.personDetails=user;
			$location.path('/userDetails');
			});
	};
});
