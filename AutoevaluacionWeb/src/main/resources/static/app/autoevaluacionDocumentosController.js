angular.module("myApp")
.controller('autoevaluacionDocumentosController',['$scope', 'autoevaluacionDocumentosServices', 'autoevaluacionServices', '$routeParams', '$location', function($scope, autoevaluacionDocumentosServices, autoevaluacionServices, $routeParams, $location){
	
	$scope.listarDocumentos = function(){
		$scope.cargarAutoevaluacion();
		autoevaluacionDocumentosServices.listarDocumentos($routeParams.autoevaluacionID).then(function (response){
			$scope.mostrarDocumentos = true;
			$scope.documentos = response.data;
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
	
	$scope.cargarArchivo = function(){
		autoevaluacionDocumentosServices.cargarDocumento($scope.archivo, 11).then(function (response){
			alert("archivo cargado");
			$scope.listarDocumentos();
		}, function (error){
			alert("error cargando archivo");
		});
	}
	
	$scope.uploadedFile = function (element){
		$scope.$apply(function($scope) {
			   $scope.archivo = element.files;       
		});
	}
	
	$scope.eliminarDocumento = function (documento){
		autoevaluacionDocumentosServices.eliminarDocumento(documento.autoevaluacionDocumentoID).then(function (response){
			$scope.listarDocumentos();
		}, function (error){
			
		});
	}
	
	$scope.regresarProcesoAutoevaluacion = function(){
		$location.url('/procesoAutoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}
	
	$scope.listarDocumentos();
}]);