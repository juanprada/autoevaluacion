angular.module("myApp")
.controller("indicadoresController", ['$scope', 'caracteristicasServices', 'indicadoresServices', '$uibModal', function($scope, caracteristicasServices, indicadoresServices, $uibModal){
	
	$scope.paginaIndicadores = true;
	
	$scope.guardarIndicador = function(){
		indicadoresServices.guardarIndicador($scope.indicador).then( function(response){
			alert('Indicador guardando correctamente');
			$scope.listarIndicadores();
			$scope.limpiar();
		}, function(response){
			alert('Error guardando indicador');
		});	
	}
	
	$scope.listarIndicadores = function(){
		indicadoresServices.listarIndicadores().then(function (response){
			$scope.indicadores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.listarCaracteristicas = function(){
		caracteristicasServices.listarCaracteristicas().then(function (response){
			$scope.caracteristicas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.eliminarIndicador = function(indicadorID){
		indicadoresServices.eliminarIndicador(indicadorID).then(function (response){
			alert("Indicador eliminado correctamente");
			$scope.listarIndicadores();
		}, function (response){
			alert("Error eliminando indicador");
		});
	}
	
	$scope.adminDocumentos = function () {
		var modalInstance = $uibModal.open({
		      ariaLabelledBy: 'modal-title',
		      ariaDescribedBy: 'modal-body',
		      templateUrl: 'modalDocuments.html',
		      size:'lg',
		      controller: 'ModalDocumentsController',
		      scope:$scope
		    });
		    
		    modalInstance.result.then(function (selectedItem) {
		    	console.log("then modal");
		     }, function () {
		        console.log('Modal dismissed at: ' + new Date());
		     }); 
	}
	
	$scope.editarIndicador = function(indicador){
		$scope.indicador = angular.copy(indicador);
	}
	
	$scope.limpiar = function(){
		$scope.indicador = {};
		$scope.habilitaObservaciones = false;
	}
	
	$scope.listarCaracteristicas();
	$scope.listarIndicadores();
}])
.controller('ModalDocumentsController',['$scope', 'indicadoresServices', function($scope, indicadoresServices){
	
	$scope.listarDocumentos = function(){
		if ($scope.paginaIndicadores){
			indicadoresServices.listarDocumentos($scope.indicador.indicadorID).then(function (response){
				$scope.documentos = response.data;
			}, function (response){
				
			});
		}else{
			indicadoresServices.listarDocumentosAutoevaluacion($scope.indicador.autoevaluacionDetalleID).then(function (response){
				$scope.documentos = response.data;
			}, function (response){
				
			});
		}
	}
	
	$scope.cargarArchivo = function(){
		indicadoresServices.cargarDocumento($scope.archivo, $scope.indicador.indicadorID).then(function (response){
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
	
	$scope.sePuedeEliminar = function(documento){
		return true;
	}
	
	$scope.eliminarDocumento = function (documento){
		indicadoresServices.eliminarDocumento(documento.documentosIndicadoresID).then(function (response){
			$scope.listarDocumentos();
		}, function (error){
			
		});
	}
	
	$scope.listarDocumentos();
}]);