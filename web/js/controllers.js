/*angular.module('myApp.genericpages', ['ngRoute'])
.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/home', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })

            // route for the about page
            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });

    // create the controller and inject Angular's $scope
    scotchApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });

    scotchApp.controller('aboutController', function($scope) {
        $scope.message = 'Look! I am an about page.';
    });

    scotchApp.controller('contactController', function($scope) {
        $scope.message = 'Contact us! JK. This is just a demo.';
      });*/
var logout = angular.module('myApp.logout', ['ngRoute']);
var about = angular.module('myApp.About', ['ngRoute']);
var contact = angular.module('myApp.Contact', ['ngRoute']);
var usertable = angular.module('myApp.user.table', ['ngTable']);
var httpget  = angular.module('ionicApp', []);
var regular = angular.module("regularservice", []);
var lectpage = angular.module("lecturerpage",['ngRoute']);
var chart = angular.module('chart', ['angularCharts']);

logout.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/logout', {
    templateUrl: 'partials/logout.html',
    controller: 'logoutCtrl'
  });
}]);

about.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/about', {
    templateUrl: 'partials/about.html',
    controller: 'aboutCtrl'
  });
}]);


contact.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/contact', {
    templateUrl: 'partials/contact.html',
    controller: 'contactCtrl'
  });
}]);

//lecturer partials
lectpage.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/lectpage1', {
    templateUrl: 'partials/lectpage1.html',
    controller: 'lectpage1Ctrl'
  });
}]);
lectpage.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/lectpage2', {
    templateUrl: 'partials/lectpage2.html',
    controller: 'lectpage2Ctrl'
  });
}]);
lectpage.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/lectpage3', {
    templateUrl: 'partials/lectpage3.html',
    controller: 'lectpage3Ctrl'
  });
}]);


lectpage.controller('lectpage1Ctrl', function($scope) {
  $scope.message = 'this is the students page, this should have a talbe of students and then a button to bring the lecturer to the students individual quiz results';
});
lectpage.controller('lectpage2Ctrl', function($scope) {
  $scope.message = 'this is the quizzes page, this should be used for editing quizzes and being able to create more, the quizzes should be shown below the table with all the quizzes and there names, a div should change dynamically based on the quiz and selected at that point ';
});
lectpage.controller('lectpage3Ctrl', function($scope) {
  $scope.message = 'this is the lecturer results page this page should show the results of all student and then be able to filter the results to one student if a the context button is not on';
});
lectpage.controller('QuizformCtrl',function($scope) {
  $scope.update = angular.copy.person;
});



/*format{
    "email": "42themeaning@gmail.com",
    "fname": "Joe",
    "lname": "Blogs",
    "password": "stuff",
    "username": "Joebloggs",
    "userrole": "STUDENT"
  }*/
  lectpage.controller('UserformCtrl',function($scope, $http) {
    $scope.master={};
    
    $scope.sendPostUser = function () {
      $scope.userrole = "STUDENT";
      var dataObj = {
        fname : $scope.fname,
        lname : $scope.lname,
        password : $scope.password,
        username : $scope.username,
        userrole : $scope.userrole,
        email : $scope.email
      }; 
      var res = $http.post('http://localhost:8080/BackendDITproj/webresources/user', dataObj);
      res.success(function(data, status, headers, config) {
        $scope.master = data;
      });
      res.error(function(data, status, headers, config) {
        alert( "failure message: " + JSON.stringify({data: data}));
      }); 
      $scope.fname = "";
      $scope.lname = "";  
      $scope.password = "";
      $scope.username = "";
      $scope.email = "";
    }
  });
/*
lectpage.controller('UserformCtrl', ['$scope', function($scope) {
$scope.master = {"userrole":"STUDENT",};



 $scope.sendPostUser = function(user) { 
        $scope.master = angular.copy(user);
      };
}]);

*/


about.controller('aboutCtrl', function($scope) {
  $scope.message = 'this is the about page';
});

contact.controller('contactCtrl', function($scope) {
  $scope.message = 'this is the contact page';
});

logout.controller('logoutCtrl', function($scope) {
  $scope.message = 'this is the logout page incase you didnt realize';
});


//this is not used now 
usertable.controller('UserCtrl' ,function($scope, $http){



 $http.get('http://localhost:8080/BackendDITproj/webresources/user')

 .success(function(data) {$scope.users = data;



 })
 .error(function(data) {console.log('Error '+data);
});
});





//this is used to control the input of data for users
var userrestServices = angular.module('userrestServices', ['ngResource']);

userrestServices.factory("User", function($resource) {
  return $resource("http://localhost:8080/BackendDITproj/webresources/user/:id");
});


userrestServices.controller("restUserCtrl", function($scope, User) {
  $scope.chosen1 = 3;
  User.query(function(data) {
    $scope.users = data;
  });
  User.get({id: $scope.chosen1},function(data) {
    $scope.singleuser = data;
  });
});
//end of userrestservices


var quizServices = angular.module('quizServices', ['ngResource']);

quizServices.factory("Quiz", function($resource) {
  return $resource("http://localhost:8080/BackendDITproj/webresources/quizzes/:id");
});

quizServices.factory("Question", function($resource) {
  return $resource("http://localhost:8080/BackendDITproj/webresources/questions/:id");
});
quizServices.factory("Resultscount",function($resource){
  return $resource("http://localhost:8080/BackendDITproj/webresources/results/qq/:id/Count/");
})


quizServices.controller("selectQuizCtrl", function($scope,Question,Resultscount) {

  Question.query(function(data) {
    $scope.questioncollection = data;
    
  });

  $scope.resultscollection = Resultscount.get({id: 1},function(data){
    return data.result;
  });

$scope.config = {
    title: 'Algebra quiz Results',
    tooltips: true,
    labels: false,
    mouseover: function() {},
    mouseout: function() {},
    click: function() {},
    legend: {
      display: true,
      //could be 'left, right'
      position: 'left'
    }
  };

$scope.data = {

    series: ['A','B','C','D'],
    data: [{
      x: "Q1",
      y: [1, 2, 1, 5],
    },{
      x: "Q2",
      y: [3, 2, 1, 1],
    },{
      x: "Q3",
      y: [0, 0, 0, 0],
    },{
      x: "Q4",
      y: [0, 0, 0, 0],
    },{
      x: "Q5",
      y: [0, 0, 0, 0],
    },{
      x: "Q6",
      y: [0, 0, 0, 0],
    },{
      x: "Q7",
      y: [0, 0, 0, 0],
    },{
      x: "Q8",
      y: [0, 0, 0, 0],
    },{
      x: "Q9",
      y: [0, 0, 0, 0],
    },{
      x: "Q10",
      y: [0, 0, 0, 0],
    },{
      x: "Q11",
      y: [0, 0, 0, 0],
    },{
      x: "Q12",
      y: [1, 5, 1, 2],
    }
    ]
  };



});








/*angular chart*/
chart.controller('ChartCtrl',function ($scope) {
/*  

*/

  $scope.config = {
    title: '',
    tooltips: true,
    labels: false,
    mouseover: function() {},
    mouseout: function() {},
    click: function() {},
    legend: {
      display: true,
      //could be 'left, right'
      position: 'left'
    }
  };

  $scope.data = {

    series: ['A','B','C','D'],
    data: [{
      x: "Question1",
      y: [1, 5, 1, 2],
    }]
  };


});

/*all the thing relating to the quiz view*/



/*

quizServices.controller("selectQuizCtrl", function($scope, Quiz) {
});



quizpage.factory("Quiz", function($resource) {
  return $resource("http://localhost:8080/BackendDITproj/webresources/quizzes/:id");
});

quizpage.controller("selectQuizCtrl", function($scope, Quiz) {
  Quiz.query(function(data) {
    $scope.quizcollection = data;
  });
  $scope.currentquiz = $scope.quizcollection;
});
*/