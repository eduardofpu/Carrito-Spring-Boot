'use strict';

angular.module('carrito')
  .controller('LoginCtrl', function($scope, LoginLogoutSrv) {

    $scope.login = function(email, password) {
      LoginLogoutSrv.login(email, password);
    };

  });
