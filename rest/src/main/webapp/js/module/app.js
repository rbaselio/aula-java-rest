angular.module('appModule', [
 	'clienteModule',
 	'ngRoute'
 ]).config(function($routeProvider) {
     
 	$routeProvider
 	.when('/cliente', {
 		templateUrl: '../../rest/clienteA.html',
 		controller: 'clienteCtrl'
     }).otherwise({
     	redirectTo: 'http://www.pudim.com.br'
     });
 	
 });