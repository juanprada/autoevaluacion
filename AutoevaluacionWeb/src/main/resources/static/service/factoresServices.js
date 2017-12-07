angular.module("myApp")
.service("factoresServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarFactor = function (factor){
		return $http.post('/factores/guardar', factor);
	}
	
	dataService.listarFactores = function (){
		return $http.get('/factores/listar');
	}
	
	dataService.eliminarFactor = function (factorID){
		return $http.delete('/factores/eliminar/' + factorID);
	}
	
	dataService.actualizarFactor = function(factor){
		$http.put('/factores/actualizar', factor);
	}
	
	return dataService;
}]);