app.controller('saleController', ['$scope', '$rootScope', '$http',
    function ($scope, $rootScope, $http) {
        $scope.sales = [];
        $scope.sale = {};
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
                url: 'http://localhost:9090/api/sale/' + $scope.sale.id,
                contentType: "application/x-www-form-urlencoded"
            }).then(
                function (answer) {
                    $scope.sale = answer.data;
            });
        };

        this.getAll = function () {
            $http({
                method: 'get',
                url: 'http://localhost:9090/api/sale/getAll',
                contentType: "application/x-www-form-urlencoded"
            }).then(
                function (answer) {
                    $scope.sales = answer.data;
            });
        };

        this.save = function () {
            $http({
                method: 'post',
                headers: new Headers({
                    contentType: 'application/json'
                }),
                data: $scope.sale,
                url: 'http://localhost:9090/api/sale/sale/'
            }).then(
                function (answer) {
                    console.log($scope.sale);
                    outScope.getAll();
                    $scope.sale = [];
            });
        };

        this.update = function () {
            $scope.sale.candyId.saleList = undefined;
            $scope.sale.detailSaleList = undefined;
            $http({
                method: 'patch',
                headers: new Headers({
                    contentType: 'application/json'
                }),
                data: $scope.sale,
                url: 'http://localhost:9090/api/sale/update/'
            }).then(
                function (answer) {
                    //$scope.candies.push(answer.data);
                    $scope.save = true;
                    outScope.getAll();
            });
        };

        this.delete = function (id) {
            $http({
                method: 'delete',
                headers: new Headers({
                    contentType: 'application/json'
                }),
                url: 'http://localhost:9090/api/sale/delete/' + id
            }).then(
                function (answer) {
                    console.log("eliminado")
                    outScope.getAll();
            });
        };

        this.getAllCandies = function () {
            $http({
                method: 'get',
                url: 'http://localhost:9090/api/candy/getAll',
                contentType: "application/x-www-form-urlencoded"
            }).then(
                function (answer) {
                    $scope.candies = answer.data;
            });
        };

        this.edit = function (sale){
            $scope.sale = sale;
            $scope.save = false;
        };

        this.getAll();
        this.getAllCandies();
    }
]);