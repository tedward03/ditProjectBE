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





//this is not supposed to be here it should be in services.js
var userrestServices = angular.module('userrestServices', ['ngResource']);

userrestServices.factory("User", function($resource) {
  return $resource("http://localhost:8080/BackendDITproj/webresources/user/:id");
});


userrestServices.controller("restUserCtrl", function($scope, User) {
  User.query(function(data) {
    $scope.users = data;
  });
});





var app = angular.module('ngdemo.controllers', []);

app.controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory', '$location',
    function ($scope, UsersFactory, UserFactory, $location) {

        // callback for ng-click 'editUser':
        $scope.editUser = function (userId) {
            $location.path('/user-detail/' + userId);
        };

        // callback for ng-click 'deleteUser':
        $scope.deleteUser = function (userId) {
            UserFactory.delete({ id: userId });
            $scope.users = UsersFactory.query();
        };

        // callback for ng-click 'createUser':
        $scope.createNewUser = function () {
            $location.path('/user-creation');
        };

        $scope.users = UsersFactory.query();
    }]);
  /* ... */
