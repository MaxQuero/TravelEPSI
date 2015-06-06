angular.module('app.periodModule')
  .controller(
    'PeriodIndexController',
    [
      '$log',
      '$scope',
      'periods',
      'periodData',

      function(
        $log,
        $scope,
        periods,
        periodData
      ) {
        $scope.periods  = periods;
        $scope.period   = {};

        $scope.save = function(form) {
          if (form.$valid) {
            periodData.saveOne($scope.period).then(
              function(data) {
                $scope.periods.push(data);
                $scope.period = {};
                form.$setPristine();
              }
            );
          }
        };
      }
    ]
  );
