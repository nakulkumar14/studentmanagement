myApp.controller("StudentController",function ($scope,$http) {
    console.log("loaded student.js");
    $scope.getAllStudents = function () {
        $http.get("/admin/getAllStudents").success(function (response) {
            console.log(response);
        })
    };

    $scope.searchStudent = function (data) {
        console.log("firstname"+ data.firstname);
        console.log("lastname"+ data.lastname);
        console.log("mobile"+ data.mobile);
        console.log("dob"+ data.dob);
        console.log("phone"+ data.phone);
        console.log("gender" + data.gender);

        var student = {
            'firstName' : data.firstname,
            'lastName' : data.lastname,
            'mobile' : data.mobile,
            'phone' : data.phone,
            'dob' : data.dob,
            'gender' : data.gender
        }

        $http({
            url: '/admin/student',
            method: "POST",
            data: student,
            headers : { 'Content-Type': 'application/json' }
        }).then(function (response) {
            console.log('success' + JSON.stringify(response));
                    // success
        },
        function (response) { // optional
            console.log('error' + response);
            // failed
        });
    };
});