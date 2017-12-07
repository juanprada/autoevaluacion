angular.module("myApp")
.service("autoevaluacionServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarAutoevaluacion = function (autoevaluacion){
		return $http.post('/autoevaluacion/guardar', autoevaluacion);
	}
	
	dataService.guardarDetalleAutoevaluacion = function (autoevaluacionDetalle){
		return $http.post('/autoevaluacion/guardarAutoevaluacionDetalle', autoevaluacionDetalle);
	}
	
	dataService.buscarAutoevaluacion = function (autoevaluacion){
		return $http.post('/autoevaluacion/buscar', autoevaluacion);
	}
	
	dataService.buscarAutoevaluacionID = function (autoevaluacionID){
		return $http.get('/autoevaluacion/buscar/' + autoevaluacionID);
	}
	
	dataService.buscarDetalleAutoevaluacion = function (autoevaluacionID){
		return $http.get('/autoevaluacion/buscarDetalle/' + autoevaluacionID);
	}
	
	
	
	return dataService;
}]);