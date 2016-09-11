<%@include file="AdminHeader.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
  var supp = ${data};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.supplier=supp;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>

  <<c:out value="{check}"></c:out>
<c:choose>
<c:when test="${check}">

<div class="container">
    <h1 class="well">Add Supplier</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="SupplierView" commandName="Supplier">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Supplier Id</label>
								<form:input  path="suppId" placeholder="" class="form-control" readonly="true" value="${supid+1}"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Supplier Name</label>
								<form:input type="text" path="suppName" placeholder="" class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Contact No</label>
								<form:input type="text" path="contactNo" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Supplier Address</label>
							<form:textarea path="suppAdd" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
		<div ng-app="repeatSample" ng-controller="repeatController">
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Supplier Id</th>
<th>Supplier name</th>
<th>Contact No</th>
<th>Address</th>
<th>Edit</th>
<th>Delete</th>
</tr> 
<tr class="success" ng-repeat="s in supplier|filter:searchprd">
                <td>{{s.suppId}}</a></td> 
                 <td>{{s.suppName}}</td>
                <td>{{s.contactNo}}</td>
                <td> {{s.suppAdd}}</td>
            <td><a href="UpdateSupplier?suppId={{s.suppId}}">Edit</a></td>
                <td><a href="delsupplier?suppId={{s.suppId}}">Delete</a></td>
               <!--   <td><img src="./Resources/img/{{product.img}}.jpg" height="50px" width="50px"/></td> -->  
</tr>
</table>
</div>  
</c:when>
<c:otherwise >
<div class="container">
    <h1 class="well">Update Supplier</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="UpdateSupplier" commandName="Supplier">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Supplier Id</label>
								<form:input  path="suppId" placeholder="" class="form-control" readonly="true"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Supplier Name</label>
								<form:input type="text" path="suppName" placeholder="" class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Contact No</label>
								<form:input type="text" path="contactNo" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Supplier Address</label>
							<form:textarea path="suppAdd" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
	</c:otherwise>

</c:choose>

	<%@include file="AdminFooter.jsp" %>