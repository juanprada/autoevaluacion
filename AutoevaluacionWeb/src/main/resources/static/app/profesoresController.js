angular.module("myApp")
.controller("profesoresController", ['$scope', 'profesoresServices', 'programasServices', '$routeParams', '$location', function($scope, profesoresServices, programasServices, $routeParams, $location){
	
	var nuevoProfesor = {
		   nombres : '',
		   apellidos : '',
		   tipoIdentificacion : '',
		   cedula : '',
		   nivelAcademico : '',
		   areaConocimiento : '',
		   titulo : '',
		   institucion : '',
		   dedicacion : '',
		   numeroHoras : 0,
		   horasDedicacionDocencia : 0,
		   horasInvestigacion : 0,
		   horasExtension : 0,
		   formaContratacion : '',
		   programa: ''
	}
	
	
	$scope.guardarProfesor = function(profesor){
		profesor.programa = {programasID : $routeParams.programaID};
		profesoresServices.guardarProfesor(profesor).then(function(response){
			$scope.listarProfesores();
			alert('Profesor guardado correctamente');
		}, function (response){
			alert('Error guardando profesor');
		});
		$scope.limpiar();
	}
	
	$scope.listarProfesores = function(){
		profesoresServices.listarProfesores($routeParams.programaID).then(function (response){
			$scope.profesores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarProfesor = function(profesorID){
		profesoresServices.eliminarProfesor(profesorID).then(function(response){
			$scope.listarProfesores();
			alert('Profesor eliminado correctamente');
		}, function(response){
			if (response.data.exception.includes("DataIntegrityViolationException")){
				alert("El factor esta asociado a una caracteristica");
			}else{
				alert("Error eliminando profesor");
			}
		});
		$scope.listarProfesores();
	}
	
	$scope.listarProgramas = function(){
		programasServices.listarProgramas().then(function (response){
			$scope.programas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.editar = function(profesor){
		$scope.profesor = angular.copy(profesor);
	}
	
	$scope.limpiar = function(){
		$scope.profesor = {};
	}
	
	$scope.adicionarProfesor = function(){
		$scope.profesores.push($scope.nuevoProfesor);
	}
	
	$scope.irMaestrosProgramas = function(){
		$location.url('/maestrosProgramas/' + $routeParams.programaID);
	}
	
	$scope.listarProfesores();
	$scope.listarProgramas();
}]);