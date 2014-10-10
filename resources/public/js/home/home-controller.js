angular.module('activityAuditorUI')
  .controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.search = function(query) {
      $scope.results = null;

      if(query === '' || query === undefined) {
        $scope.error = "Query Required.";
        return;
      } else {
        $scope.error = null;
      }

      $scope.loading = true;
      $http.post('/search', {query: query}).then(function(resp) {
        $scope.results = resp.data;
        $scope.loading = false;
      });
    };
  }]);
