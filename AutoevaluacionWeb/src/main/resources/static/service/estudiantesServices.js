angular.module("myApp")
.service("estudiantesServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarEstudiante = function (factor){
		return $http.post('/estudiantes/guardar', factor);
	}
	
	dataService.listarEstudiantes = function (programaID){
		return $http.get('/estudiantes/listar/' + programaID);
	}
	
	dataService.eliminarEstudiante = function (factorID){
		return $http.delete('/estudiantes/eliminar/' + factorID);
	}
	
	return dataService;
}]);