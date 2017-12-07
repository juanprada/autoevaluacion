angular.module("myApp")
.service("profesoresServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarProfesor = function (factor){
		return $http.post('/profesores/guardar', factor);
	}
	
	dataService.listarProfesores = function (programaID){
		return $http.get('/profesores/listar/' + programaID);
	}
	
	dataService.eliminarProfesor = function (factorID){
		return $http.delete('/profesores/eliminar/' + factorID);
	}
	
	dataService.actualizarProfesores = function(factor){
		$http.put('/profesores/actualizar', factor);
	}
	
	return dataService;
}]);