angular.module("myApp")
.controller("procesoAutoevaluacionController", ['$scope', 'autoevaluacionServices', 'programasServices', '$location', '$routeParams', function($scope, autoevaluacionServices, programasServices, $location, $routeParams){
	
	$scope.crearProceso = function(){
		$scope.autoevaluacion.periodo = $scope.anio + "" + $scope.semestre;
		autoevaluacionServices.guardarAutoevaluacion($scope.autoevaluacion).then(function (response){
			$scope.autoevaluacionValida = true;
			alert("Autoevaluacion creada correctamente");
		}, function (response) {
			alert("Ya existe un proceso para este periodo y programa");
		});
	}
	
	$scope.buscarAutoevaluacion = function(){
		$scope.autoevaluacion.periodo = $scope.anio + "" + $scope.semestre;
		autoevaluacionServices.buscarAutoevaluacion($scope.autoevaluacion).then(function (response){
			if (response.data != ""){
				$scope.autoevaluacionValida = true;
				$scope.autoevaluacion = response.data;
			}else{
				alert("No existe autoevaluacion para ese periodo");
			}
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.listarProgramas = function(){
		programasServices.listarProgramas().then(function (response){
			$scope.programas = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.irAutoevaluacion = function(){
		$location.url('/autoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}
	
	$scope.cargarProceso = function(){
		if ($routeParams.procesoAutoevaluacionID != -1){
			autoevaluacionServices.buscarAutoevaluacionID($routeParams.procesoAutoevaluacionID).then(function (response){
				if (response.data){
					$scope.autoevaluacionValida = true;
					$scope.autoevaluacion = response.data;
					$scope.anio = $scope.autoevaluacion.periodo.substring(0,4);
					$scope.semestre = $scope.autoevaluacion.periodo.substring(4,6);
				}
			}, function (response){
				$scope.autoevaluacionValida = false;
			});
		}
	}
	
	$scope.irDocumentacion = function(){
		$location.url('/documentosAutoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}
	
	$scope.irInformes = function(){
		$location.url('/informesAutoevaluacion/' + $scope.autoevaluacion.autoevaluacionID);
	}
	
	$scope.listarProgramas();
	$scope.cargarProceso();
}]);