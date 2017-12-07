angular.module("myApp")
.controller("caracteristicasController", ['$scope', 'factoresServices', 'caracteristicasServices', function($scope, factoresServices, caracteristicasServices){
	
	$scope.guardarCaracteristica = function(){
		caracteristicasServices.guardarCaracteristica($scope.caracteristica).then(function(response){
			alert("Caracteristica guardada correctamente");
			$scope.listarCaracteristicas();
			$scope.limpiar();
		}, function (response){
			alert("Error guardando");
		});	
	}
	
	$scope.listarCaracteristicas = function(){
		caracteristicasServices.listarCaracteristicas().then(function (response){
			$scope.caracteristicas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.listarFactores = function(){
		factoresServices.listarFactores().then(function (response){
			$scope.factores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarCaracteristica = function(caracteristicaID){
		caracteristicasServices.eliminarCaracteristica(caracteristicaID).then(function (response){
			alert("Caracteristica eliminada correctamente");
			$scope.listarCaracteristicas();
		}, function (response){
			if (response.data.exception.includes("DataIntegrityViolationException")){
				alert("La caracteristica esta asociada a un indicador");
			}else{
				alert("Error eliminando");
			}
		});
	}
	
	$scope.editarCaracteristica = function(caracteristica){
		$scope.caracteristica = angular.copy(caracteristica);
	}
	
	$scope.limpiar = function(){
		$scope.caracteristica = {};
	}
	
	$scope.listarFactores();
	$scope.listarCaracteristicas();
}]);