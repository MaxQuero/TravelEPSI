angular.module('app.packageModule')
  .controller(
    'PackageIndexController',
    [
      '$log',
      '$scope',
      'packages',
      'packageData',

      function(
        $log,
        $scope,
        packages,
        packageData
      ) {
        $scope.packages  = packages;
        $scope.package   = {};

        $scope.save = function(form) {
          if (form.$valid) {
            packageData.saveOne($scope.package).then(
              function(data) {
                $scope.packages.push(data);
                $scope.package = {};
                form.$setPristine();
              }
            );
          }
        };
      }
    ]
  );
