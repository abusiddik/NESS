<%-- 
    Document   : party
    Created on : May 3, 2017, 9:42:41 AM
    Author     : Maruf
--%>

<div class="row" ng-controller="PartyController as partyCtrl" style="margin-top: 80px;">
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><msg key="signin"></msg></h3>
            </div>
            <div class="panel-body">
                
                  <form name="partyForm" method="POST" class="form form-horizontal">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="partyCtrl.flag !== 'edit'">
                                <h3> Add New Party </h3> 
                            </div>
                            <div ng-if="partyCtrl.flag === 'edit'">
                                <h3> Update Party for ID: {{ partyCtrl.party.partyId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td> Name : </td> <td><input type="text" class="form-control" name="username" ng-model="partyCtrl.party.partyName" required/> 
                            <span ng-show="partyForm.username.$error.required" class="msg-val">Party Name is required.</span> </td>
                    </tr>
             
           
                    <tr>
                        <td colspan="2"> <span ng-if="partyCtrl.flag === 'created'" class="msg-success">Party successfully added.</span>
                            <span ng-if="partyCtrl.flag === 'failed'" class="msg-val">Party already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="partyCtrl.flag !== 'edit'">
                                <input  type="submit" ng-click="partyCtrl.addParty()" value="Add Party" class="btn btn-lg btn-primary"/> 
                                <input type="button" ng-click="partyCtrl.reset()" value="Reset" class="btn btn-lg btn-primary"/>
                            </div>
                            <div ng-if="partyCtrl.flag === 'edit'">
                                <input  type="submit" ng-click="partyCtrl.updatePartyDetail()" value="Update Party" class="btn btn-lg btn-primary"/> 	
                                <input type="button" ng-click="partyCtrl.cancelUpdate()" value="Cancel" class="btn btn-lg btn-primary"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="partyCtrl.flag === 'deleted'" class="msg-success">Party successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            </div>
        </div>
    </div>
    <div class="col-md-6">
    	<div class="well-lg bg-info">
    		            <h1> Party Panel</h1>

            <table class="table table-bordered table-hover">
                <tr><th>ID </th> <th>Party Name</th> <th>Password</th></tr>
                <tr ng-repeat="row in partyCtrl.partys">
                    <td><span ng-bind="row.partyId"></span></td>
                    <td><span ng-bind="row.partyName"></span></td>
               
                   
                    <td colspan="2">

                        <input type="button" ng-click="partyCtrl.deleteParty(row.partyId)" value="Delete" class="btn btn-lg btn-primary"/>
                        <input type="button" ng-click="partyCtrl.editParty(row.partyId)" value="Edit" class="btn btn-lg btn-primary"/>
                        <span ng-if="partyCtrl.flag === 'updated' && row.partyId === partyCtrl.updatedId" class="msg-success">Party successfully updated.</span> 
                    </td> 
                </tr>	
            </table>
    	</div>
    </div>
</div>


