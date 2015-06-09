angular.module('app.userModule', ['ui.router'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('logout', {
        url: '/logout',
        controller: 'UserLogoutController'
      })

      .state('users', {
        abstract: true,
        url: '/users',
        template: '<div ui-view></div>',
        protected: true
      })

      .state('users.index', {
        url: '',
        templateUrl: '/views/user/index.html',
        controller: 'UserIndexController',
        resolve: {
          users: ['$stateParams', 'userData', function($stateParams, userData) {
            return userData.getIndex();
          }]
        }
      });
  }]);
