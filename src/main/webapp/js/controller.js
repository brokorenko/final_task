app.controller('repairStationsController', function($scope, $http) {
    $http.get("/repairStations")
        .then(function(response) {
            //First function handles success
            $scope.headingTitle = "Show Projects";
            $scope.project = response.data;
        }, function(response) {
            //Second function handles error
            $scope.project = "Something went wrong";
            $scope.headingTitle = "Error";
        });
});

app.controller('carWashStationsController', function($scope, $http) {
    $http.get("/carWashStations")
        .then(function(response) {
            //First function handles success
            $scope.headingTitle = "Show Projects";
            $scope.project = response.data;
        }, function(response) {
            //Second function handles error
            $scope.project = "Something went wrong";
            $scope.headingTitle = "Error";
        });
});