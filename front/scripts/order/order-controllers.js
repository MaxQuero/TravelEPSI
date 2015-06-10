angular.module('app.orderModule')
  .controller(
    'OrderNewController',
    [
      '$log',
      '$rootScope',
      '$scope',
      'services',
      'orderData',

      function(
        $log,
        $rootScope,
        $scope,
        services,
        orderData
      ) {
        $rootScope.newOrder = true;

        $scope.services = services;
        $scope.order    = {
          package_id: $scope.package.id,
          period: {}
        };

        $scope.save = function() {
          orderData.saveOne($scope.order).then(function(data) {
            $scope.order = {
              package_id: $scope.package.id,
              period: {}
            };

            $scope.orders.push(data);
          });
        };
      }
    ]
  );
