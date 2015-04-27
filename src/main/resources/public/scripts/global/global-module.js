angular.module('app.module', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: '/views/home.html',
        controller: [
          '$log',
          '$scope',

          function(
            $log,
            $scope
          ) {}
        ]
      });
  }]);
