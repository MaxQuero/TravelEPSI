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
        controller: 'PackageIndexController',
        resolve: {
          packages: ['$stateParams', 'packageData', function($stateParams, packageData) {
            return packageData.getIndex();
          }]
        }
      });
  }]);
