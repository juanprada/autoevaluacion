angular.module("myApp")
.controller("programasController", ['$scope', 'programasServices', function($scope, programasServices){
	
	$scope.guardarPrograma = function(){
		programasServices.guardarPrograma($scope.programa).then(function(response){
			alert('Programa guardado correctamente');
			$scope.listarProgramas();
			$scope.limpiar();
		}, function(response){
			alert('Error guardado programa');
		});
		
	}
	
	$scope.listarProgramas = function(){
		programasServices.listarProgramas().then(function (response){
			$scope.programas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarPrograma = function(programaID){
		programasServices.eliminarPrograma(programaID).then(function(response){
			alert('Programa eliminado correctamente');
			$scope.listarProgramas();
		}, function(response){
			alert('Error eliminado programa');
		});
	}
	
	$scope.editarPrograma = function(programa){
		$scope.programa = angular.copy(programa);
	}
	
	$scope.limpiar = function(){
		$scope.programa = {};
	}
	
	$scope.listarProgramas();
	
}]);