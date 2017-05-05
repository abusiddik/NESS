(function () {
    var as = angular.module('myApp.controllers', []);

    as.controller('MainController', function ($q, $scope, $rootScope, $http, i18n, $location) {
        var load = function () {
        };

        load();

        $scope.language = function () {
            return i18n.language;
        };
        $scope.setLanguage = function (lang) {
            i18n.setLanguage(lang);
        };
        $scope.path = function () {
            return $location.url();
        };

    });


as.factory('Admin', ['$resource', function ($resource) {
        return $resource('http://localhost:8084/ness/admin/:adminId', {adminId: '@adminId'},
                {
                    updateAdmin: {method: 'PUT'}
                }
        );
    }]);

as.controller('AdminController', ['$scope', 'Admin', function ($scope, Admin) {
        var obj = this;
        obj.admins = [];
        obj.admin = new Admin();
        obj.fetchAllAdmins = function () {
            obj.admins = Admin.query();
        };
        obj.fetchAllAdmins();
        obj.addAdmin = function () {
            console.log('Inside save');
            if ($scope.adminForm.$valid) {
                obj.admin.$save(function (admin) {
                    console.log(admin);
                    obj.flag = 'created';
                    obj.reset();
                    obj.fetchAllAdmins();
                },
                        function (err) {
                            console.log(err.status);
                            obj.flag = 'failed';
                        }
                );
            }
        };
        obj.editAdmin = function (id) {
            console.log('Inside edit');
            obj.admin = Admin.get({adminId: id}, function () {
                obj.flag = 'edit';
            });
        };
        obj.updateAdminDetail = function () {
            console.log('Inside update');
            if ($scope.adminForm.$valid) {
                obj.admin.$updateAdmin(function (admin) {
                    console.log(admin);
                    obj.updatedId = admin.id;
                    obj.reset();
                    obj.flag = 'updated';
                    obj.fetchAllAdmins();
                });
            }
        };
        obj.deleteAdmin = function (id) {
            console.log('Inside delete');
            obj.admin = Admin.delete({adminId: id}, function () {
                obj.reset();
                obj.flag = 'deleted';
                obj.fetchAllAdmins();
            });
        };
        obj.reset = function () {
            obj.admin = new Admin();
            $scope.adminForm.$setPristine();
        };
        obj.cancelUpdate = function (id) {
            obj.admin = new Admin();
            obj.flag = '';
            obj.fetchAllAdmins();
        };
    }]);

    as.factory('Party', ['$resource', function ($resource) {
        return $resource('http://localhost:8084/ness/party/:partyId', {partyId: '@partyId'},
                {
                    updateParty: {method: 'PUT'}
                }
        );
    }]);

as.controller('PartyController', ['$scope', 'Party', function ($scope, Party) {
        var obj = this;
        obj.partys = [];
        obj.party = new Party();
        obj.fetchAllPartys = function () {
            obj.partys = Party.query();
        };
        obj.fetchAllPartys();
        obj.addParty = function () {
            console.log('Inside save');
            if ($scope.partyForm.$valid) {
                obj.party.$save(function (party) {
                    console.log(party);
                    obj.flag = 'created';
                    obj.reset();
                    obj.fetchAllPartys();
                },
                        function (err) {
                            console.log(err.status);
                            obj.flag = 'failed';
                        }
                );
            }
        };
        obj.editParty = function (id) {
            console.log('Inside edit');
            obj.party = Party.get({partyId: id}, function () {
                obj.flag = 'edit';
            });
        };
        obj.updatePartyDetail = function () {
            console.log('Inside update');
            if ($scope.partyForm.$valid) {
                obj.party.$updateParty(function (party) {
                    console.log(party);
                    obj.updatedId = party.id;
                    obj.reset();
                    obj.flag = 'updated';
                    obj.fetchAllPartys();
                });
            }
        };
        obj.deleteParty = function (id) {
            console.log('Inside delete');
            obj.party = Party.delete({partyId: id}, function () {
                obj.reset();
                obj.flag = 'deleted';
                obj.fetchAllPartys();
            });
        };
        obj.reset = function () {
            obj.party = new Party();
            $scope.partyForm.$setPristine();
        };
        obj.cancelUpdate = function (id) {
            obj.party = new Party();
            obj.flag = '';
            obj.fetchAllPartys();
        };
    }]);

}());