angular.module("myApp")
.controller("factoresController", ['$scope', 'factoresServices', function($scope, factoresServices){
	
	$scope.guardarFactor = function(){
		factoresServices.guardarFactor($scope.factor).then(function(response){
			$scope.listarFactores();
			alert('Factor guardado correctamente');
		}, function (response){
			alert('Error guardando factor');
		});
		$scope.limpiar();
	}
	
	$scope.listarFactores = function(){
		factoresServices.listarFactores().then(function (response){
			$scope.factores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarFactor = function(factorID){
		factoresServices.eliminarFactor(factorID).then(function(response){
			$scope.listarFactores();
			alert('Factor eliminado correctamente');
		}, function(response){
			if (response.data.exception.includes("DataIntegrityViolationException")){
				alert("El factor esta asociado a una caracteristica");
			}else{
				alert("Error eliminando factor");
			}
		});
		$scope.listarFactores();
	}
	
	$scope.cargarArchivo = function(){
		
	}
	
	$scope.uploadedFile = function (element){
		$scope.$apply(function($scope) {
			   $scope.archivo = element.files;         
		});
	}
	
	$scope.editar = function(factor){
		$scope.factor = angular.copy(factor);
	}
	
	$scope.limpiar = function(){
		$scope.factor = {};
	}
	
	$scope.listarFactores();
}]);