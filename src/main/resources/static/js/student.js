myApp.controller("StudentController",function ($scope,$http) {
    console.log("loaded student.js");

    $scope.statuses = ['ACTIVE', 'INACTIVE'];

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
            // console.log('success' + JSON.stringify(response));
            $scope.persons = response.data;
                // console.log('data : ' + JSON.stringify(response.data));
            $("[id=personTable]").show();
                // success
        },
        function (response) { // optional
            console.log('error' + response);
            // failed
        });
    };

    $scope.addStudent = function (data) {
        console.log("add : " + JSON.stringify(data));
        $http({
            url: '/admin/addStudent',
            method: 'POST',
            data: data
        }).then(function (response) {
                console.log('added data : ' + JSON.stringify(response));
        },
        function (response) { // optional
            console.log('error' + response);
        });
    };

    $scope.removeStudent = function(data) {
      console.log("Deleting student with id : " + data);
      if (confirm('Are you sure you want to delete this student record?')){
          console.log('yes sure');

          $http({
              url : '/admin/student/' + data,
              method : 'GET'
          }.then(function (response) {
              console.log("removeStudent : " + response);
          }), function (response) {
              console.log('error : ' + response);
          });

      }else{
          console.log('not sure');
      }
    };
});