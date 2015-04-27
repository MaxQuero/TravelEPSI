angular.module('app')
  .controller(
    'AppController',
    [
      '$log',
      '$rootScope',
      '$scope',
      'AuthService',

      function(
        $log,
        $rootScope,
        $scope,
        AuthService
      ) {
        $scope.$watch(AuthService.currentUser, function(currentUser) {
          $rootScope.isLoggedIn   = AuthService.isLoggedIn();
          $rootScope.currentUser  = currentUser;
        }, true);
      }
    ]
  );
