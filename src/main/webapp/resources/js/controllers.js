var cartApp = angular.module('cartApp', []);
 
cartApp.controller('cartCtrl',  function ($scope, $http) {
	
	$scope.refreshCart = function(cartId) {
		$http.get('/bookshelf/rest/cart/'+$scope.cartId)
		  	.success(function(data) {
		  		$scope.cart = data;
		});
	};
		  					
	$scope.clearCart = function() {
		$http.delete('/bookshelf/rest/cart/'+$scope.cartId)
			.success($scope.refreshCart($scope.cartId));					
	};
	  					  
	$scope.initCartId = function(cartId) {
		$scope.cartId=cartId;
		$scope.refreshCart($scope.cartId);
	};
	  						
	$scope.addToCart = function(bookId) {
		$http.put('/bookshelf/rest/cart/add/'+bookId)
		  	.success(function(data) {
		  		$scope.refreshCart($http.get('/bookshelf/rest/cart/get/cartId'));
		  		alert("Book Successfully added to the Cart!");
		  	})
		  	.error(function(data, status) {
		  		alert('Repos error', status, data);
		  	});
	};
	  
	$scope.removeFromCart = function(bookId) {
		$http.put('/bookshelf/rest/cart/remove/'+bookId)
			.success(function(data) {
				$scope.refreshCart($http.get('/bookshelf/rest/cart/get/cartId'));
		});
	};
});