angular.module('app.orderModule', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('packages.show.new-order', {
        url: '/new-order',
        templateUrl: '/views/order/new.html',
        controller: 'OrderNewController',
        resolve: {
          services: ['$stateParams', 'serviceData', function($stateParams, serviceData) {
            return serviceData.getIndex();
          }]
        }
      })
  }]);
