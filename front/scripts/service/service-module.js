angular.module('app.serviceModule', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('services', {
        abstract: true,
        url: '/services',
        template: '<div ui-view></div>',
        protected: true
      })

      .state('services.index', {
        url: '',
        templateUrl: '/views/service/index.html',
        controller: 'ServiceIndexController',
        resolve: {
          services: ['$stateParams', 'serviceData', function($stateParams, serviceData) {
            return serviceData.getIndex();
          }]
        }
      });
  }]);
