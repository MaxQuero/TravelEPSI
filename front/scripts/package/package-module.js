angular.module('app.packageModule', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('packages', {
        abstract: true,
        url: '/packages',
        template: '<div ui-view></div>',
        protected: true
      })

      .state('packages.index', {
        url: '',
        templateUrl: '/views/package/index.html',
        controller: 'PackageIndexController'
      })

      .state('packages.show', {
        url: '/:id',
        templateUrl: '/views/package/show.html',
        controller: 'PackageShowController',
        resolve: {
          orders: ['$stateParams', 'orderData', function($stateParams, orderData) {
            return orderData.getIndexWithPackage($stateParams.id);
          }],

          package: ['$stateParams', 'packageData', function($stateParams, packageData) {
            return packageData.getOne($stateParams.id);
          }]
        }
      });
  }]);
