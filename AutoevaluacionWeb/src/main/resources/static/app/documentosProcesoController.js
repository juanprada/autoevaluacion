angular.module("myApp")
.controller("documentosProcesoController", ['$scope', 'factoresServices', 'autoevaluacionServices', '$uibModal', function($scope, factoresServices, autoevaluacionServices, $uibModal){
	
	$scope.buscarDocumentos = function(){
		$scope.mostrarDocumentos = true;
		$scope.mostrarAutoevaluacion = false;
	}
}]);