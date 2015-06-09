angular.module('app.orderModule')
  .service(
    'orderData',
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

          Restangular.all('orders').getList().then(
            function(data) {
              deferred.resolve(data);
            },
            function() {
              deferred.reject();
            }
          );

          return deferred.promise;
        };

        this.getIndexWithPackage = function(idPackage) {
          var deferred = $q.defer();

          Restangular.one('packages', idPackage).all('orders').getList().then(
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

          Restangular.one('orders', id).get().then(
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
            Restangular.all('orders').customPUT(model).then(
              function(data) {
                deferred.resolve(data);
              },
              function() {
                deferred.reject();
              }
            );
          } else {
            Restangular.all('orders').post(model).then(
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
