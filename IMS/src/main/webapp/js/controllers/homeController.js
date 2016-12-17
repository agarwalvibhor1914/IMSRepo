app.controller('homeController', function($scope,loginService) {
	$scope.init = function (){
		//$scope.person= loginService.getPersonDetails();
	};
});

$(document).ready(function() {
    $('#Carousel').carousel({
        interval: 5000
    })
})