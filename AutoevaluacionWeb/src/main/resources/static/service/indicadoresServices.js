angular.module("myApp")
.service("indicadoresServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.guardarIndicador = function (indicador){
		return $http.post('/indicadores/guardar', indicador);
	}
	
	dataService.listarIndicadores = function (){
		return $http.get('/indicadores/listar');
	}
	
	dataService.eliminarIndicador = function (indicadorID){
		return $http.delete('/indicadores/eliminar/' + indicadorID);
	}
	
	dataService.actualizarIndicador = function(indicador){
		$http.put('/indicadores/actualizar', indicador);
	}
	
	dataService.cargarDocumento = function (file, indicadorID){
		var formData = new FormData();
		formData.append("documento", file[0]);
		formData.append("indicadorID", indicadorID);
		return $http.post("documentosIndicadores/cargarDocumento", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity});
	}
	
	dataService.listarDocumentos = function (indicadorID){
		return $http.get('/documentosIndicadores/listarDocumentosIndicador/' + indicadorID);
	}
	
	dataService.cargarDocumentoAutoevaluacion = function (file, autoevaluacionDocumentoID){
		var formData = new FormData();
		formData.append("documento", file[0]);
		formData.append("autoevaluacionDocumentoID", autoevaluacionDocumentoID);
		return $http.post("documentosIndicadores/cargarDocumentoAutoevaluacion", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity});
	}
	
	dataService.listarDocumentosAutoevaluacion = function (detalleAutoevaluacionID){
		return $http.get('/documentosIndicadores/listarDocumentosDetalleAutoevaluacion/' + detalleAutoevaluacionID);
	}
	
	dataService.eliminarDocumento = function (indicadorID){
		return $http.delete('/documentosIndicadores/eliminar/' + indicadorID);
	}
	
	dataService.validaIndicadorAutoevaluacion = function(indicadorID){
		return $http.get('/autoevaluacion/buscarIndicadorAutoevaluacion/' + indicadorID);
	}
	
	return dataService;
}]);