angular.module('app.userModule')
  .controller(
    'UserLogoutController',
    [
      '$log',
      '$scope',
      '$state',
      'localStorageService',

      function(
        $log,
        $scope,
        $state,
        localStorageService
      ) {
        localStorageService.clearAll();
        $state.go('home');
      }
    ]
  )

  .controller(
    'UserIndexController',
    [
      '$log',
      '$scope',
      'users',

      function(
        $log,
        $scope,
        users
      ) {
        $scope.users = users;
      }
    ]
  );
