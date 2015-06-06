angular.module('app.periodModule')
  .service(
    'periodData',
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

          Restangular.all('periods').getList().then(
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

          Restangular.one('periods', id).get().then(
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
            Restangular.all('periods').customPUT(model).then(
              function(data) {
                deferred.resolve(data);
              },
              function() {
                deferred.reject();
              }
            );
          } else {
            Restangular.all('periods').post(model).then(
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
