angular.module('app.module', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: '/views/home.html',
        controller: [
          '$log',
          '$scope',
          '$state',
          'AuthService',

          function(
            $log,
            $scope,
            $state,
            AuthService
          ) {
            $scope.login = function(form) {
              if (form.$valid) {
                AuthService.login($scope.user).then(
                  function() {
                    $state.go('dashboard');
                  }
                );
              }
            };

            $scope.signup = function(form) {
              if (form.$valid) {
                AuthService.signup($scope.user).then(
                  function() {
                    $state.go('dashboard');
                  }
                );
              }
            };
          }
        ]
      })

      .state('dashboard', {
        url: '/dashboard',
        templateUrl: '/views/dashboard.html',
        protected: true
      });
  }]);
