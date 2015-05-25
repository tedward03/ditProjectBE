'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.logout',
  'myApp.About',
  'myApp.Contact',
  'myApp.view1',
  'myApp.view2',
  'myApp.version',
  'angularCharts',
  'ionicApp',
  'lecturerpage',
  'userrestServices',
  'quizServices',
  'myApp.user.table',
  'chart'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);

