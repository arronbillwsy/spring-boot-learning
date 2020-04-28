angular.module('demo', [])
    .controller('Hello', function($scope, $http) {
        $http.get('http://localhost:8080/api/actual/get/all').
        then(function(response) {
            $scope.actualData = response.data;
        });
    });
