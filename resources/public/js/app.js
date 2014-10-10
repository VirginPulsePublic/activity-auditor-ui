// Declare app level module which depends on filters, and services
angular.module('activityAuditorUI', ['ngResource', 'ngRoute', 'ngSanitize', 'ui.bootstrap', 'ui.date', 'ui.utils'])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home/home.html',
        controller: 'HomeController'})
      .otherwise({redirectTo: '/'});
  }]);
