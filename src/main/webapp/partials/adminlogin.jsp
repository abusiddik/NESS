<%-- 
    Document   : adminlogin
    Created on : Apr 27, 2017, 9:39:06 PM
    Author     : Maruf
--%>


<div class="row" ng-controller="AdminController as adminCtrl" style="margin-top: 80px;">
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><msg key="signin"></msg></h3>
            </div>
            <div class="panel-body">
                
                  <form name="adminForm" method="POST" class="form form-horizontal">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="adminCtrl.flag !== 'edit'">
                                <h3> Add New Admin </h3> 
                            </div>
                            <div ng-if="adminCtrl.flag === 'edit'">
                                <h3> Update Admin for ID: {{ adminCtrl.admin.adminId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Admin Name : </td> <td><input type="text" class="form-control" name="username" ng-model="adminCtrl.admin.username" required/> 
                            <span ng-show="adminForm.username.$error.required" class="msg-val">Admin Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Password : </td> <td> <input type="text" class="form-control" name="password" ng-model="adminCtrl.admin.password" required/> 
                            <span ng-show="adminForm.password.$error.required" class="msg-val">Password is required.</span> </td>
                    </tr>
           
                    <tr>
                        <td colspan="2"> <span ng-if="adminCtrl.flag === 'created'" class="msg-success">Admin successfully added.</span>
                            <span ng-if="adminCtrl.flag === 'failed'" class="msg-val">Admin already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="adminCtrl.flag !== 'edit'">
                                <input  type="submit" ng-click="adminCtrl.addAdmin()" value="Add Admin" class="btn btn-lg btn-primary"/> 
                                <input type="button" ng-click="adminCtrl.reset()" value="Reset" class="btn btn-lg btn-primary"/>
                            </div>
                            <div ng-if="adminCtrl.flag === 'edit'">
                                <input  type="submit" ng-click="adminCtrl.updateAdminDetail()" value="Update Admin" class="btn btn-lg btn-primary"/> 	
                                <input type="button" ng-click="adminCtrl.cancelUpdate()" value="Cancel" class="btn btn-lg btn-primary"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="adminCtrl.flag === 'deleted'" class="msg-success">Admin successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            </div>
        </div>
    </div>
    <div class="col-md-6">
    	<div class="well-lg bg-info">
    		            <h1> Admin Panel</h1>

            <table class="table table-bordered table-hover">
                <tr><th>ID </th> <th>Admin Name</th> <th>Password</th></tr>
                <tr ng-repeat="row in adminCtrl.admins">
                    <td><span ng-bind="row.adminId"></span></td>
                    <td><span ng-bind="row.username"></span></td>
                    <td><span ng-bind="row.password"></span></td>
                   
                    <td colspan="2">

                        <input type="button" ng-click="adminCtrl.deleteAdmin(row.adminId)" value="Delete" class="btn btn-lg btn-primary"/>
                        <input type="button" ng-click="adminCtrl.editAdmin(row.adminId)" value="Edit" class="btn btn-lg btn-primary"/>
                        <span ng-if="adminCtrl.flag === 'updated' && row.adminId === adminCtrl.updatedId" class="msg-success">Admin successfully updated.</span> 
                    </td> 
                </tr>	
            </table>
    	</div>
    </div>
</div>

