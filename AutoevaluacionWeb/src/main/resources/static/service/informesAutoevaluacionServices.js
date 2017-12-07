angular.module("myApp")
.service("informesAutoevaluacionServices" , ["$http", function($http){
	var dataService = {};
	
	dataService.generarInformeFactores = function (autoevaluacionID){
		return $http.get('/informes/factores/' + autoevaluacionID);
	}
	
	dataService.generarInformeCaracteristicas = function (autoevaluacionID, factorID){
		return $http.get('/informes/caracteristicas/' + autoevaluacionID + "/" + factorID);
	}
	
	return dataService;
}]);