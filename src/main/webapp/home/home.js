'use strict';

myApp
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeController'
  });
}])

.controller('HomeController', ['$scope', '$http', function($scope, $http) {
	console.log("[HomeController]");
	
	$http({
		  method: 'GET',
		  url: '/backend/users'
		}).then(function successCallback(response) {
			console.log("[HomeController] responseee");
			console.log(response);
			$scope.users = response.data;
		  }, function errorCallback(response) {
			console.log("[HomeController] errorCallback list");
		  });
	
	  $scope.deleteUser = function(id) {
				$http({
					  method: 'DELETE',
					  url: '/backend/users/' + id
					}).then(function successCallback(response) {
						console.log("[HomeController] successCallback delete");
						for(var i = $scope.users.length - 1; i >= 0; i--) {
						    if($scope.users[i].id == id) {
						    	$scope.users.splice(i, 1);
						    }
						}						
					  }, function errorCallback(response) {
						console.log("[HomeController] errorCallback delete");
					  });	
			  };
	
			  $('#kk').on('keypress', function (e) {
			         if(e.which === 13){
			            $scope.insertUser($(this).val());
			         }
			   });				  
			  
			  $scope.insertUser = function(name) {
					$http({
						  //method: 'POST',
						  //url: 'backend/SEndpoint?action=insert&name=' + $('#kk').val()
						    method: 'POST',
						    url: '/backend/users',
						    data: '{"name": "' + $('#kk').val() + '"}',
						    headers: {'Content-Type': 'application/json; charset=UTF-8'}
						}).then(function successCallback(response) {
							console.log("[HomeController] successCallback insert");
							$scope.users.push(response.data);
						  }, function errorCallback(response) {
							console.log("[HomeController] errorCallback insert");
						  });	
				  };			  
	
}]);



