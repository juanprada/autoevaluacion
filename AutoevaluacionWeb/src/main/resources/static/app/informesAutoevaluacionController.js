angular.module("myApp")
.controller('informesAutoevaluacionController',['$scope', 'informesAutoevaluacionServices', 'factoresServices', 'autoevaluacionServices', '$routeParams', '$location', function($scope, informesAutoevaluacionServices, factoresServices, autoevaluacionServices, $routeParams, $location){
	
	$scope.informeFactoresGenerado = false;
	$scope.habilitaCaracteristicas = false;
	
	$scope.generarInformeFactores = function(){
		informesAutoevaluacionServices.generarInformeFactores($routeParams.autoevaluacionID).then(function (response){
			$scope.informeFactoresGenerado = true;
			$scope.habilitaCaracteristicas = false;
			var buttonFactor = angular.element( document.querySelector( '#buttonFactores' ) );
			buttonFactor.addClass('btn-success');
			var buttonCaracateristicas = angular.element( document.querySelector( '#buttonCaracteristicas' ) );
			buttonCaracateristicas.removeClass('btn-success');
		}, function (response){
			
		});
	}
	
	$scope.cargarAutoevaluacion = function(){
		autoevaluacionServices.buscarAutoevaluacionID($routeParams.autoevaluacionID).then(function (response){
			if (response.data){
				$scope.autoevaluacion = response.data;
			}
		}, function (response){
		});
	}
	
	$scope.informeCaracteristicas = function(){
		$scope.informeFactoresGenerado = false;
		$scope.habilitaCaracteristicas = true;
		var buttonFactor = angular.element( document.querySelector( '#buttonFactores' ) );
		buttonFactor.removeClass('btn-success');
		var buttonCaracateristicas = angular.element( document.querySelector( '#buttonCaracteristicas' ) );
		buttonCaracateristicas.addClass('btn-success');
	}
	
	$scope.generarInformeCaracteristicas = function(){
		informesAutoevaluacionServices.generarInformeCaracteristicas($routeParams.autoevaluacionID, $scope.factor.factorID).then(function (response){
			$scope.informeCaracteristicasGenerado = true;
		}, function (response){
			
		});
	}
	
	$scope.listarFactores = function(){
		factoresServices.listarFactores().then(function (response){
			$scope.factores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.regresarProcesoAutoevaluacion = function(){
		$location.url('/procesoAutoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}
	
	$scope.cargarAutoevaluacion();
	$scope.listarFactores();
}]);