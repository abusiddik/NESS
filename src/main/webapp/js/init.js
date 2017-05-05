
(function () {

    var message,
            as = angular.module('myApp', ['ngRoute', 'ngResource', 'ngCookies', 'ui.bootstrap', 'ngMessages', 'myApp.i18n', 'myApp.services', 'myApp.controllers', 'myApp.filters']);

    as.config(function ($routeProvider, $httpProvider) {

        $routeProvider
                .when('/',
                        {templateUrl: 'partials/home.jsp',
                            publicAccess: true})

                .when('/home',
                        {templateUrl: 'partials/home.jsp',
                            publicAccess: true})
                .when('/party',
                        {templateUrl: 'partials/admin/party.jsp',
                            publicAccess: true})
                        
                          .when('/adminlogin',
                        {controller: 'AdminController',
                            templateUrl: 'partials/admin.jsp',
                            publicAccess: true})
                .when('/admin',
                        {controller: 'AdminController',
                      
                            publicAccess: true});


        $httpProvider.interceptors.push(function ($q) {
            var setMessage = function (response) {
                if (response.data.text && response.data.type) {
                    message = {
                        text: response.data.text,
                        type: response.data.type,
                        show: true
                    };
                }
            };

            return {
                'response': function (response) {
                    setMessage(response);
                    return response || $q.when(response);
                },

                'responseError': function (response) {
                    setMessage(response);
                    return $q.reject(response);
                }

            };
        });

    });



}());