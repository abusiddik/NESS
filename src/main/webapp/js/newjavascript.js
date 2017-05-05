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