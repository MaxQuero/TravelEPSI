angular.module('app.serviceModule')
  .controller(
    'ServiceIndexController',
    [
      '$log',
      '$scope',
      'services',
      'serviceData',

      function(
        $log,
        $scope,
        services,
        serviceData
      ) {
        $scope.services  = services;
        $scope.service   = {};

        $scope.save = function(form) {
          if (form.$valid) {
            serviceData.saveOne($scope.service).then(
              function(data) {
                $scope.services.push(data);
                $scope.service = {};
                form.$setPristine();
              }
            );
          }
        };
      }
    ]
  );
