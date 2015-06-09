angular.module('app.packageModule')
  .service(
    'packageData',
    [
      '$log',
      '$q',
      'Restangular',

      function(
        $log,
        $q,
        Restangular
      ) {
        this.getIndex = function() {
          var deferred = $q.defer();

          Restangular.all('packages').getList().then(
            function(data) {
              deferred.resolve(data);
            },
            function() {
              deferred.reject();
            }
          );

          return deferred.promise;
        };


        this.getOne = function(id) {
          var deferred = $q.defer();

          Restangular.one('packages', id).get().then(
            function(data) {
              deferred.resolve(data);
            },
            function() {
              deferred.reject();
            }
          );

          return deferred.promise;
        };

        this.saveOne = function(model) {
          var deferred = $q.defer();

          if (typeof model.id === 'number') {
            Restangular.all('packages').customPUT(model).then(
              function(data) {
                deferred.resolve(data);
              },
              function() {
                deferred.reject();
              }
            );
          } else {
            Restangular.all('packages').post(model).then(
              function(data) {
                deferred.resolve(data);
              },
              function() {
                deferred.reject();
              }
            );
          }

          return deferred.promise;
        };
      }
    ]
  );
