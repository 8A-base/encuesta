app.controller('detailController', ['$scope', '$rootScope', '$http',
    function ($scope, $rootScope, $http) {
        $scope.detailSales = [];
        $scope.detailSale = {};
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
                url: 'http://localhost:9090/api/detailSale/' + $scope.detailSale.id,
                contentType: "application/x-www-form-urlencoded"
            }).then(
                function (answer) {
                    $scope.detailSale = answer.data;
            });
        };

        this.getAll = function () {
            $http({
                method: 'get',
                url: 'http://localhost:9090/api/detailSale/getAll',
                contentType: "application/x-www-form-urlencoded"
            }).then(
                function (answer) {
                    $scope.detailSale = answer.data;
            });
        };

        this.save = function () {
            $http({
                method: 'post',
                headers: new Headers({
                    contentType: 'application/json'
                }),
                data: $scope.detailSale,
                url: 'http://localhost:9090/api/detailSale/detailSale/'
            }).then(
                function (answer) {
                    console.log($scope.detailSale);
                    //$scope.candies.push(answer.data);
                    outScope.getAll();
            });
        };

        this.update = function () {
            $http({
                method: 'patch',
                headers: new Headers({
                    contentType: 'application/json'
                }),
                data: $scope.detailSale,
                url: 'http://localhost:9090/api/detailSale/update'
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
                url: 'http://localhost:9090/api/detailSale/delete/' + id
            }).then(
                function (answer) {
                    console.log("eliminado")
                    outScope.getAll();
            });
        };

        this.edit = function (detailSale){
            $scope.detailSale = detailSale;
            $scope.save = false;
        };

        this.getAll();
    }
]);