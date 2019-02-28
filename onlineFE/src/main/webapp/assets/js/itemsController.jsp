var app = angular.module('ShoppingApp', []);

app.controller('ItemController', function($http) {
	
	var me = this;
		
	me.mvItems = [];
	me.mpItems = [];
	
	me.fetchItems = function() {
		
		
		$http.get('/onlineFE/json/data/mv/items')
			.then(function(response) {
				me.mvItems = response.data;
		});
			
			
		$http.get('/onlineFE/json/data/mp/items')
		.then(function(response) {
			me.mpItems = response.data;
		});
				
	}
	
});