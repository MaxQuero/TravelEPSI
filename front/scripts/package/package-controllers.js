angular.module('app.packageModule')
  .controller(
    'PackageIndexController',
    [
      '$log',
      '$scope',
      '$state',
      'packageData',

      function(
        $log,
        $scope,
        $state,
        packageData
      ) {
        $scope.package = {};

        $scope.save = function(form) {
          if (form.$valid) {
            packageData.saveOne($scope.package).then(
              function(data) {
                $state.go('packages.show', { id: data.id });
              }
            );
          }
        };
      }
    ]
  )

  .controller(
    'PackageShowController',
    [
      '$log',
      '$rootScope',
      '$scope',
      'orders',
      'package',

      function(
        $log,
        $rootScope,
        $scope,
        orders,
        package
      ) {
        $rootScope.newOrder = false;

        $scope.orders   = orders;
        $scope.package  = package;
      }
    ]
  );
