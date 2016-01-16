angular.module('clienteModule')
	.controller('clienteCtrl', [
		'$scope',
		'clienteService',
		function($scope, clienteService){
			
			$scope.client = {};
			
			var error = function(){
				console.log("Fudeu");
			}
			
			clienteService.getAllProducts().then(
					function (){
						console.log(clienteService.response);
					},
					error
			);
			
			$scope.create = function(){
				clienteService.create($scope.client).then(
						function(){
							console.log('sucesso');
						},
						error
				);
			}
			
		}
	]);