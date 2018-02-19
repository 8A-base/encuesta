app.controller('preguntaController', ['$scope', '$rootScope', '$http',
function ($scope, $rootScope, $http) {
    $scope.preguntas = [];
    $scope.pregunta = {};
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
            url: 'http://localhost:9090/pregunta/api/' + $scope.pregunta.id,
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.pregunta = answer.data;
        });
    };

    this.getAll = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/pregunta/getAll',
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.preguntas = answer.data;
        });
    };

    this.save = function () {
        $http({
            method: 'post',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.respuesta,
            url: 'http://localhost:9090/api/pregunta/pregunta/'
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
            url: 'http://localhost:9090/api/respuesta/update'
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
            url: 'http://localhost:9090/api/pregunta/delete/' + id
        }).then(
            function (answer) {
                console.log("eliminado")
                outScope.getAll();
        });
    };

    this.edit = function (pregunta){
        $scope.pregunta = pregunta;
        $scope.save = false;
    };

    this.getAll();
}
]);