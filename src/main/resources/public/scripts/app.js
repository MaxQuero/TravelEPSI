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

  'app.packageModule',
  'app.periodModule',
  'app.serviceModule',
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

        $urlRouterProvider.otherwise('/dashboard');

        localStorageServiceProvider.setPrefix('travelepsi');

        RestangularProvider.setBaseUrl('/api');
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
      'AuthService',

      function(
        $log,
        $rootScope,
        $window,
        $state,
        toaster,
        AuthService
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

        $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
          var bodyClass = '', state, tmpState;

          state = toState.name.split('.');

          for (var i = 1; i <= state.length; i++) {
            tmpState = state.slice(0, i).join('.');

            if ($state.get(tmpState)) {
              if ($state.get(tmpState).bodyClass) {
                bodyClass += ' ' + $state.get(tmpState).bodyClass;
              }

              if ($state.get(tmpState).protected && !AuthService.isLoggedIn()) {
                event.preventDefault();
                $state.go('home');
              }
            }
          }

          $rootScope.bodyClass = bodyClass;

          $window.scrollTo(0, 0);
        });
      }
    ]
  );
