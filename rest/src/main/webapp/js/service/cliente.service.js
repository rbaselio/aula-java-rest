angular
		.module('clienteModule')

		.service(
				'clienteService',
					['$http',
						function clienteService($http) {

							clienteService.response = {};
							clienteService.erro = {};
							clienteService.status;

							var callBackSuccess = function(data, status) {
								clienteService.response = data;
								clienteService.status = status;
							};

							var callBackError = function(data, status) {
								clienteService.error = data;
								clienteService.status = status;

							};

							clienteService.getAllProducts = function() {
								return $http
										.get(
												'http://localhost:8080/rest/rest/cliente/findAll')
										.success(callBackSuccess).error(
												callBackError);
							}

							clienteService.create = function(client) {
								return $http(
										{
											url : 'http://localhost:8080/rest/rest/cliente/create',
											data : client,
											method : 'POST'

										}).success(callBackSuccess).error(
										callBackError);

							}

							return clienteService;
						} ]);