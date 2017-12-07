angular.module("myApp", ['ngRoute','ui.bootstrap','ngAnimate','ngSanitize'])
.config(['$routeProvider',
	   function($routeProvider) {
	      $routeProvider.
	         when('/factores', {
	            templateUrl: 'factores.html',
	            controller: 'factoresController'
	         }).
	         when('/caracteristicas', {
	            templateUrl: 'caracteristicas.html',
	            controller: 'caracteristicasController'
	         }).
	         when('/indicadores', {
	            templateUrl: 'indicadores.html',
	            controller: 'indicadoresController'
		     }).
	         when('/programas', {
	            templateUrl: 'programas.html',
	            controller: 'programasController'
	         }).
	         when('/procesoAutoevaluacion/:procesoAutoevaluacionID', {
		            templateUrl: 'procesoAutoevaluacion.html',
		            controller: 'procesoAutoevaluacionController'
		     }).
		     when('/autoevaluacion/:autoevaluacionID', {
		         templateUrl: 'autoevaluacion.html',
		         controller: 'autoevaluacionController'
		     }).
		     when('/documentosAutoevaluacion/:autoevaluacionID', {
		         templateUrl: 'documentosAutoevaluacion.html',
		         controller: 'autoevaluacionDocumentosController'
		     }).
		     when('/informesAutoevaluacion/:autoevaluacionID', {
		         templateUrl: 'informesAutoevaluacion.html',
		         controller: 'informesAutoevaluacionController'
		     }).
		     when('/profesores/:programaID', {
		         templateUrl: 'profesores.html',
		         controller: 'profesoresController'
		     }).
		     when('/estudiantes/:programaID', {
		         templateUrl: 'estudiantes.html',
		         controller: 'estudiantesController'
		     }).
		     when('/parametros', {
		         templateUrl: 'parametros.html',
		         controller: 'parametrosController'
		     }).
		     when('/maestrosProgramas/:programaID', {
		         templateUrl: 'maestrosProgramas.html',
		         controller: 'maestrosProgramasController'
		     });

	   }]);