app.service('productService', function($http) {
	var productDetails;
	  this.getproductDetails = function getproductDetails() {
		  return $http({
				method : 'POST',
				url : 'api/productService/productDetails',
				headers : {
					'Content-Type' : 'application/json'
				}
			});
	  };
	  this.productDetails = function () {                
          return this.productDetails;
       }
});