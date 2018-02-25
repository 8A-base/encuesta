app.controller('encuestaController', ['$scope', '$rootScope', '$http',
function ($scope, $rootScope, $http) {
    $scope.polls = [];
    $scope.poll = {};
    $scope.questions = [];
    $scope.question = {};
    $scope.question.idType = [];
    $scope.types = [];
    $scope.type = {};
    $scope.answers = [];
    $scope.answer = {};
    var outScope = this;

    this.Eaction = function () {
        if($scope.saveE === true){
            outScope.saveE();
        }else{
            outScope.updateE();
        }
    };

    this.Paction = function () {
        if($scope.saveP === true){
            outScope.saveP();
        }else{
            outScope.updateP();
        }
    };

    this.Raction = function () {
        if($scope.saveR === true){
            outScope.saveR();
        }else{
            outScope.updateR();
        }
    };

    this.getOne = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/poll/' + $scope.poll.id,
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.poll = answer.data;
        });
    };

    this.getAllEncuestas = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/poll/getAll',
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.polls = answer.data;
        });
    };

    this.getAllTipos = function () {
        $http({
            method: 'get',
            url: 'http://localhost:9090/api/question/getAllT',
            contentType: "application/x-www-form-urlencoded"
        }).then(
            function (answer) {
                $scope.types = answer.data;
        });
    };

    this.saveE = function () {
        alert("ssssssssss");
        $scope.questions.push($scope.question);
        $scope.poll.questionList = $scope.questions;
        console.log($scope.poll);
        $http({
            method: 'post',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.poll,
            url: 'http://localhost:9090/api/poll/poll/'
        }).then(
            function (answer) {
                alert("El código de tu encuesta es: " + answer);
                outScope.getAllEncuestas();
        });
    };

    this.saveP = function () {
        $scope.question.pollList = [];
        $scope.question.pollList.push($scope.poll);
        $http({
            method: 'post',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.question,
            url: 'http://localhost:9090/api/question/question/'
        }).then(
            function (answer) {
                //outScope.updateQ();
        });
    };

    this.updateE = function () {
        alert($scope.poll.questionList);
        $http({
            method: 'patch',
            headers: new Headers({
                contentType: 'application/json'
            }),
            data: $scope.poll,
            url: 'http://localhost:9090/api/poll/update'
        }).then(
            function (answer) {
                //$scope.candies.push(answer.data);
                $scope.save = true;
                console.log($scope.save);
                outScope.getAllEncuestas();
        });
    };

    this.deleteE = function (id) {
        $http({
            method: 'delete',
            headers: new Headers({
                contentType: 'application/json'
            }),
            url: 'http://localhost:9090/api/poll/delete/' + id
        }).then(
            function (answer) {
                console.log("eliminado")
                outScope.getAllEncuestas();
        });
    };

    this.deleteP = function (id) {
        $http({
            method: 'delete',
            headers: new Headers({
                contentType: 'application/json'
            }),
            url: 'http://localhost:9090/api/question/delete/' + id
        }).then(
            function (answer) {
                console.log("eliminado")
                outScope.getAllEncuestas();
        });
    };

    this.Eedit = function (poll){
        $scope.poll = poll;
        $scope.saveE = false;
    };

    this.Pedit = function (question){
        $scope.question = question;
        $scope.saveP = false;
    };

    this.Redit = function (answer){
        $scope.answer = answer;
        $scope.saveR = false;
    };

    this.getAllEncuestas();
    this.getAllTipos();
}
]);