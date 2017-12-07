angular.module("myApp")
.service("parametrosServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarParametro = function (parametro){
		return $http.post('/parametros/guardar', parametro);
	}
	
	dataService.listarParametros = function (){
		return $http.get('/parametros/listar');
	}
	
	return dataService;
}]);