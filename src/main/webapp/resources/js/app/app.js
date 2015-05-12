/*
 *
 */

'use strict';

angular.module('kadal', ['ngRoute', 'kalkulator.controller']).config(['$routeProvider',
function($routeProvider) {
	$routeProvider.when('/calc', {
		templateUrl : 'view/kalkulator.html',
		controller : 'KalkulatorController'
	});
}]);
