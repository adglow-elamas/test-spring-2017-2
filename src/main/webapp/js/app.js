var myApp = angular.module('citestweb1', ['ngRoute']).

	config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
	  $locationProvider.hashPrefix('!');

	  $routeProvider.otherwise({redirectTo: '/home'});
	}]);


myApp.controller('Citestweb1Controller', ['$scope', '$location', function($scope, $location) {
	console.log("[Citestweb1Controller]");
}]);

