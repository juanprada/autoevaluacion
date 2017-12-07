angular.module("myApp")
.controller("estudiantesController", ['$scope', 'estudiantesServices', 'programasServices', '$routeParams', '$location', function($scope, estudiantesServices, programasServices, $routeParams, $location){
	
	var nuevoEstudiante = {
			 periodo : '',
		     inscritos :0,
		     matriculados: 0,
		     primiparos:0,
		     egresados:0,
		     graduados:0,
		     admitidos:0,
		     retirados:0,
		     tasaDesercion:0,
		     porcentajeCulminan:0,
		     nroEstudiantesOtrasIESNales:0,
		     nroEstudiantesOtrasIESInternales:0,
		     nroEstudiantesVisitaNales:0,
		     nroEstudiantesVisitaInternales:0,
		     programa:'' 
		 };
	
	$scope.guardarEstudiante = function(estudiante){
		estudiante.programa = {programasID : $routeParams.programaID};
		estudiantesServices.guardarEstudiante(estudiante).then(function(response){
			$scope.listarEstudiantes();
			alert('Estudiante guardado correctamente');
		}, function (response){
			alert('Error guardando estudiante');
		});
		$scope.limpiar();
	}
	
	$scope.listarEstudiantes = function(){
		estudiantesServices.listarEstudiantes($routeParams.programaID).then(function (response){
			$scope.estudiantes = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarEstudiante = function(estudianteID){
		estudiantesServices.eliminarEstudiante(estudianteID).then(function(response){
			$scope.listarEstudiantes();
			alert('Estudiante eliminado correctamente');
		}, function(response){
			if (response.data.exception.includes("DataIntegrityViolationException")){
				alert("El factor esta asociado a una caracteristica");
			}else{
				alert("Error eliminando estudiante");
			}
		});
		$scope.listarEstudiantes();
	}
	
	$scope.listarProgramas = function(){
		programasServices.listarProgramas().then(function (response){
			$scope.programas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.editar = function(estudiante){
		$scope.estudiante = angular.copy(estudiante);
	}
	
	$scope.limpiar = function(){
		$scope.estudiante = {};
	}
	
	$scope.adicionarEstudiante = function(){
		$scope.estudiantes.push($scope.nuevoEstudiante);
	}
	
	$scope.irMaestrosProgramas = function(){
		$location.url('/maestrosProgramas/' + $routeParams.programaID);
	}
	
	$scope.listarEstudiantes();
	$scope.listarProgramas();
}]);