angular.module('app', [
  'ngAnimate',
  'ui.bootstrap',
  'LocalStorageModule',
  'restangular',
  'ui.router',
  'angular-md5',
  'toaster',

  'app.module',
  'app.directives',
  'app.services',

  'app.userModule'
])
  .config(
    [
      '$httpProvider',
      '$urlRouterProvider',
      'localStorageServiceProvider',
      'RestangularProvider',

      function(
        $httpProvider,
        $urlRouterProvider,
        localStorageServiceProvider,
        RestangularProvider
      ) {
        $httpProvider.interceptors.push('errorHttpInterceptor');

        $urlRouterProvider.otherwise('/');

        localStorageServiceProvider.setPrefix('travelepsi');

        RestangularProvider.setBaseUrl('/');
      }
    ]
  )

  .run(
    [
      '$log',
      '$rootScope',
      '$window',
      '$state',
      'toaster',

      function(
        $log,
        $rootScope,
        $window,
        $state,
        toaster
      ) {
        $rootScope.$on('not_created', function(e, data) {
          toaster.pop('warning', '', "Ca n'a pas été créé");
        });

        $rootScope.$on('not_authorized', function(e, data) {
          toaster.pop('error', '', 'Cette page vous est interdite');
        });

        $rootScope.$on('forbidden', function(e, data) {
          toaster.pop('error', '', 'Interdit de faire ça');
        });

        $rootScope.$on('not_found', function(e, data) {
          toaster.pop('error', '', 'Pas trouvé');
        });

        $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
          $window.scrollTo(0, 0);
        });
      }
    ]
  );
