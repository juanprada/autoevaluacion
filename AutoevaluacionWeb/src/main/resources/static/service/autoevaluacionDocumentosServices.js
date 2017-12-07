angular.module("myApp")
.service("autoevaluacionDocumentosServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.cargarDocumento = function (file, indicadorID){
		var formData = new FormData();
		formData.append("documento", file[0]);
		formData.append("evaluacionID", indicadorID);
		return $http.post("autoevaluacionDocumentos/cargarDocumento", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity});
	}
	
	dataService.listarDocumentos = function (indicadorID){
		return $http.get('/autoevaluacionDocumentos/listarDocumentosAutoevaluacion/' + indicadorID);
	}
	
	dataService.eliminarDocumento = function (indicadorID){
		return $http.delete('/autoevaluacionDocumentos/eliminar/' + indicadorID);
	}
	
	return dataService;
}]);