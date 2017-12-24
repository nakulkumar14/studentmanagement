var myApp = angular.module("myApp",[]);
myApp.controller("StudentController",function ($scope,$http) {
    console.log("loaded student.js");
    $scope.getAllStudents = function () {
        $http.get("/admin/getAllStudents").success(function (response) {
            console.log(response);
        })
    };
});