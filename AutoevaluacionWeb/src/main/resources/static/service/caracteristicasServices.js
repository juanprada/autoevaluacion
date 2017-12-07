angular.module("myApp")
.service("caracteristicasServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarCaracteristica = function (caracteristica){
		return $http.post('/caracteristicas/guardar', caracteristica);
	}
	
	dataService.listarCaracteristicas = function (){
		return $http.get('/caracteristicas/listar');
	}
	
	dataService.eliminarCaracteristica = function (caracteristicaID){
		return $http.delete('/caracteristicas/eliminar/' + caracteristicaID);
	}
	
	dataService.actualizarFactor = function(factor){
		$http.put('/factores/actualizar', factor);
	}
	
	return dataService;
}]);