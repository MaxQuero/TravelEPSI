angular.module('app.serviceModule')
  .service(
    'serviceData',
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

          Restangular.all('services').getList().then(
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

          Restangular.one('services', id).get().then(
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
            Restangular.all('services').customPUT(model).then(
              function(data) {
                deferred.resolve(data);
              },
              function() {
                deferred.reject();
              }
            );
          } else {
            Restangular.all('services').post(model).then(
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
