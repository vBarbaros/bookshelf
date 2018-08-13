var cartApp = angular.module('cartApp', []);
 
cartApp.controller('cartCtrl',  function ($scope, $http) {
	
	$scope.refreshCart = function(cartId) {
		$http.get('/bookshelf/rest/cart/' + $scope.cartId).then(function(promise){
			$scope.cart = promise.data;
		});
	};
		  					
	$scope.clearCart = function() {
		$http.delete('/bookshelf/rest/cart/'+$scope.cartId)
			.then(function(promise){
				$scope.refreshCart($scope.cartId);
		});
	};
	  					  
	$scope.initCartId = function(cartId) {
		$scope.cartId=cartId;
		$scope.refreshCart($scope.cartId);
	};
	  						
	$scope.addToCart = function(bookId) {
		$http.put('/bookshelf/rest/cart/add/'+bookId)
		  	.then(function(data) {
		  		$scope.refreshCart($http.get('/bookshelf/rest/cart/'+$scope.cartId));
		  		alert("Book Successfully added to the Cart!");
		  	}, function(data, status) {
		  		alert('Repos error', status, data);
		  	});
	};
	  
	$scope.removeFromCart = function(bookId) {
		$http.put('/bookshelf/rest/cart/remove/'+bookId)
			.then(function(data) {
				$scope.refreshCart($http.get('/bookshelf/rest/cart/get/'+$scope.cartId));
		});
	};
});