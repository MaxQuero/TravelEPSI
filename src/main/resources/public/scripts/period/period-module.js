angular.module('app.periodModule', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('periods', {
        abstract: true,
        url: '/periods',
        template: '<div ui-view></div>',
        protected: true
      })

      .state('periods.index', {
        url: '',
        templateUrl: '/views/period/index.html',
        controller: 'PeriodIndexController',
        resolve: {
          periods: ['$stateParams', 'periodData', function($stateParams, periodData) {
            return periodData.getIndex();
          }]
        }
      });
  }]);
