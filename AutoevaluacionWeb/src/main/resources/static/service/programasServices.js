angular.module("myApp")
.service("programasServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarPrograma = function (programa){
		return $http.post('/programas/guardar', programa);
	}
	
	dataService.listarProgramas = function (){
		return $http.get('/programas/listar');
	}
	
	dataService.eliminarPrograma = function (programaID){
		return $http.delete('/programas/eliminar/' + programaID);
	}
	
	dataService.actualizarFactor = function(factor){
		$http.put('/programas/actualizar', factor);
	}
	
	return dataService;
}]);