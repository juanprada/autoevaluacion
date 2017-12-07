angular.module("myApp")
.controller("parametrosController", ['$scope', 'parametrosServices', function($scope, parametrosServices){
	
	$scope.actualizarParametro = function(parametro){
		parametrosServices.guardarParametro(parametro).then(function(response){
			$scope.listarParametros();
			alert('Parametro actualizado correctamente');
		}, function (response){
			alert('Error actualizando parametro');
		});
	}
	
	$scope.listarParametros = function(){
		parametrosServices.listarParametros().then(function (response){
			$scope.parametros = response.data;
		}, function (response) {
			alert("Error listando");
		});
	}
	
	$scope.listarParametros();
}]);