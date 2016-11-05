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