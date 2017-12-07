angular.module("myApp")
.controller("autoevaluacionController", ['$scope', 'factoresServices', 'autoevaluacionServices', '$uibModal', '$routeParams', '$location', function($scope, factoresServices, autoevaluacionServices, $uibModal, $routeParams, $location){
	
	$scope.listarFactores = function(){
		factoresServices.listarFactores().then(function (response){
			$scope.factores = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.guardarEvaluacion = function(){
		var resultadoEvaluacion = [];
		$scope.factores.forEach(function (factor, index){
			factor.caracteristicas.forEach(function (caracteristica, index){
				caracteristica.indicadores.forEach(function (indicador, index){
					
					resultadoIndicador = {
						indicador : indicador,
						autoevaluacion : $scope.autoevaluacion,
						calificacion : indicador.calificacion,
						autoevaluacionDetalleID : indicador.autoevaluacionDetalleID,
						observaciones : indicador.observaciones
					}
					
					resultadoEvaluacion.push(resultadoIndicador)
				});
			});
		});
		
		autoevaluacionServices.guardarDetalleAutoevaluacion(resultadoEvaluacion).then(function (response){
			alert("Exito autoevaluando");
		}, function (response) {
			alert("Error autoevaluando");
		});
	}
	
	$scope.buscarEvaluacion = function(){
		
		autoevaluacionServices.buscarDetalleAutoevaluacion($routeParams.autoevaluacionID).then(function (response){
			$scope.autoevaluacion = response.data[0].autoevaluacion;
			response.data.forEach(function (detalleAutoevaluacion, index){
				$scope.factores.forEach(function (factor, index){
					factor.caracteristicas.forEach(function (caracteristica, index){
						caracteristica.indicadores.forEach(function (indicador, index){
							if (detalleAutoevaluacion.indicador.indicadorID == indicador.indicadorID){
								indicador.calificacion = detalleAutoevaluacion.calificacion;
								indicador.autoevaluacionDetalleID = detalleAutoevaluacion.autoevaluacionDetalleID;
								indicador.observaciones = detalleAutoevaluacion.observaciones;
							}
						});
					});
				});
			});
			$scope.mostrarAutoevaluacion = true;
		}, function (response) {
			alert("Error consultando detalle autoevaluacion");
		});
		
	}
	
	$scope.promedioCaracteristica = function(indicadores){
		var suma = 0;
		var cont = 0;
		indicadores.forEach(function (indicador, index){
			if (indicador.calificacion != -1){
				cont++;
				suma += indicador.calificacion;
			}
		});
		return suma/cont;
	}
	
	$scope.promedioFactor = function(caracteristicas){
		var suma = 0;
		var cont = 0;
		caracteristicas.forEach(function (caracteristica, index){
			caracteristica.indicadores.forEach(function (indicador, index){
				if (indicador.calificacion != -1){
					cont++;
					suma += indicador.calificacion;
				}
			});
		});
		console.log("suma: " + suma + "contador: " + cont);
		return suma/cont;
	}
	
	$scope.adminDocumentos = function (indicador) {
		$scope.indicador = indicador;
		var modalInstance = $uibModal.open({
		      ariaLabelledBy: 'modal-title',
		      ariaDescribedBy: 'modal-body',
		      templateUrl: 'modalDocuments.html',
		      size:'lg',
		      controller: 'AutoevaluacionModalDocumentsController',
		      scope:$scope
		    });
		    
		    modalInstance.result.then(function (selectedItem) {
		    	console.log("then modal");
		     }, function () {
		        console.log('Modal dismissed at: ' + new Date());
		     }); 
	}
	
	$scope.abrirObservaciones = function (indicador) {
		$scope.indicador = indicador;
		var modalInstance = $uibModal.open({
		      ariaLabelledBy: 'modal-title',
		      ariaDescribedBy: 'modal-body',
		      templateUrl: 'modalObservaciones.html',
		      controller: 'AutoevaluacionModalObservacionesController',
		      scope: $scope
		    });
		    
		    modalInstance.result.then(function (observacion) {
		    	$scope.indicador.observaciones = observacion;
		     }, function () {
		        console.log('Modal dismissed at: ' + new Date());
		     }); 
	}
	
	$scope.regresarProcesoAutoevaluacion = function(){
		$location.url('/procesoAutoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}

	$scope.listarFactores();
	$scope.buscarEvaluacion();
}])
.controller('AutoevaluacionModalDocumentsController',['$scope', 'indicadoresServices', function($scope, indicadoresServices){
	
	$scope.listarDocumentos = function(){
		indicadoresServices.listarDocumentosAutoevaluacion($scope.indicador.autoevaluacionDetalleID).then(function (response){
			$scope.documentos = response.data;
		}, function (response){
			
		});
	}
	
	$scope.cargarArchivo = function(){
		indicadoresServices.cargarDocumentoAutoevaluacion($scope.archivo, $scope.indicador.autoevaluacionDetalleID).then(function (response){
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
		return documento.autoevaluacionDetalle != null;
	}
	
	$scope.eliminarDocumento = function (documento){
		indicadoresServices.eliminarDocumento(documento.documentosIndicadoresID).then(function (response){
			$scope.listarDocumentos();
		}, function (error){
			
		});
	}
	
	$scope.listarDocumentos();
}])
.controller('AutoevaluacionModalObservacionesController',['$scope', '$uibModalInstance' , function($scope, $uibModalInstance){
	
	$scope.guardarObservaciones = function () {
		$uibModalInstance.close($scope.indicador.observaciones);
	}
}]);;;