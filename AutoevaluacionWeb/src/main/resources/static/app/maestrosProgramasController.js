angular.module("myApp")
.controller('maestrosProgramasController',['$scope', 'programasServices', '$routeParams', '$location', function($scope, programasServices, $routeParams, $location){
	
	$scope.programa = {programasID : ''};
	
	$scope.listarProgramas = function(){
		programasServices.listarProgramas().then(function (response){
			$scope.programas = response.data;
			$scope.cargarPrograma();
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.mostrarOpcion = function(){
		$scope.programasValida = true;
	}
	
	$scope.irProfesores = function(){
		$location.url('/profesores/' + $scope.programa.programasID);
	}
	
	$scope.irEstudiantes = function(){
		$location.url('/estudiantes/' + $scope.programa.programasID);
	}
	
	$scope.cargarPrograma = function(){
		if ($routeParams.programaID != -1){
			$scope.programa.programasID = $routeParams.programaID;
		}
	}
	
	$scope.listarProgramas();
}]);