app.controller('encuestaController', ['$scope', '$rootScope', '$http',
function ($scope, $rootScope, $http) {
    $scope.encuestas = [];
    $scope.encuesta = {};
    var outScope = this;

    this.action = function () {
        if($scope.save === true){
            outScope.save();
        }else{
            outScope.update();
        }
    };

    this.getOne = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/poll/' + $scope.encuesta.id,
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.encuesta = answer.data;
        });
    };

    this.getAllEncuestas = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/poll/getAll',
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.encuestas = answer.data;
        });
    };

    this.getAllTipos = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/type/getAll',
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.encuestas = answer.data;
        });
    };

    this.save = function () {
        $http({
            method: 'post',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.respuesta,
            url: 'http://localhost:9090/api/poll/poll/'
        }).then(
            function (answer) {
                outScope.getAll();
        });
    };

    this.update = function () {
        $http({
            method: 'patch',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.respuesta,
            url: 'http://localhost:9090/api/poll/update'
        }).then(
            function (answer) {
                //$scope.candies.push(answer.data);
                $scope.save = true;
                console.log($scope.save);
                outScope.getAll();
        });
    };

    this.delete = function (id) {
        $http({
            method: 'delete',
            headers: new Headers({
                contentType: 'application/json'
            }),
            url: 'http://localhost:9090/api/poll/delete/' + id
        }).then(
            function (answer) {
                console.log("eliminado")
                outScope.getAll();
        });
    };

    this.edit = function (encuesta){
        $scope.encuesta = encuesta;
        $scope.save = false;
    };

    this.getAllEncuestas();
}
]);