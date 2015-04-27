angular.module('app.userModule')
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
