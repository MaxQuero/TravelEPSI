angular.module('app.services', [])
  .factory(
    'AuthService',
    [
      '$log',
      '$q',
      '$state',
      '$location',
      'localStorageService',
      'Restangular',
      'md5',

      function(
        $log,
        $q,
        $state,
        $location,
        localStorageService,
        Restangular,
        md5
      ) {
        return {
          currentUser: function() {
            return localStorageService.get('user') || {};
          },
          isLoggedIn: function() {
            if (localStorageService.get('user')) {
              return true;
            } else {
              return false;
            }
          },
          login: function(model) {
            var deferred  = $q.defer();
            var modelCp   = angular.copy(model);

            modelCp.password = md5.createHash(modelCp.password);

            Restangular.all('users/login').post(modelCp).then(
              function(data) {
                var user = data.plain();

                localStorageService.set('user', user);
                deferred.resolve(user);
              },
              function() {
                deferred.reject();
              }
            );

            return deferred.promise;
          },
          signup: function(model) {
            var deferred      = $q.defer();
            var modelCp       = angular.copy(model);
            modelCp.password  = md5.createHash(modelCp.password);

            Restangular.all('users').post(modelCp).then(
              function(data) {
                var user = data.plain();

                localStorageService.set('user', user);
                deferred.resolve(user);
              },
              function() {
                deferred.reject();
              }
            );

            return deferred.promise;
          }
        };
      }
    ]
  )

  .factory(
    'errorHttpInterceptor',
    [
      '$log',
      '$q',
      '$rootScope',

      function(
        $log,
        $q,
        $rootScope
      ) {
        return {
          response: function(response) {
            return response;
          },

          responseError: function(response) {
            var message;

            $log.info(response);

            switch (response.status) {
              case 400:
                message = 'not_created';
                break;

              case 401:
              case 0:
                message = 'not_authorized';
                break;

              case 403:
                message = 'forbidden';
                break;

              case 404:
                message = 'not_found';
                break;
            }

            $rootScope.$broadcast(message);

            return $q.reject(response);
          }
        };
      }
    ]
  );
