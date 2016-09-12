<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<%@include file="AdminHeader.jsp" %>
<script>
  var catgry = ${data};
  var supp = ${data2};
  var adprod = ${data3};
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.category=catgry;
                 $scope.supplier=supp;
                 $scope.adproduct=adprod;
 
                 
               
    });
</script>
<c:out value="${check}"></c:out>
<div class="container" ng-app="repeatSample" >
<c:choose>
<c:when test="${check}">
	<div class="row">
		<form:form class="form-horizontal" method="post" action="AdminProducts"	commandName="AdminProduct" enctype="multipart/form-data">
			<fieldset>

				<!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Product
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="aproductId" readonly="true" value="${adpid+1}"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Product
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="aprodName"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="adesciption" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="asupplierId" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.suppId}}">{{sup.suppName}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="acategoryId" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.categoryid}}">{{cat.categorynm}}</form:option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="astock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="aprice"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Image</label>
					<div class="col-md-5">
						 <form:input type="file" path="pimage"/>

					</div>
				</div>
				
			
				
			

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>
	
</c:when>
<c:otherwise >

	<div class="row">
		<form:form class="form-horizontal" method="post" action="UpdateAdmprod"	commandName="AdminProduct">
			<fieldset>

				<!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Product
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="aproductId" readonly="true" ></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Product
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="aprodName"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="adesciption" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="asupplierId" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.suppId}}">{{sup.suppName}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="acategoryId" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.categoryid}}">{{cat.categorynm}}</form:option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="astock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="aprice"></form:input>

					</div>
				</div>


				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>


</c:otherwise>

</c:choose>
<div  ng-controller="repeatController" >
	<div>
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Product Id</th>
<th>Product name</th>
<th>Supplier Id</th>
<th>Category Id</th>
<th>Stock</th>
<th>Price</th>
<th>Edit</th>
<th>Delete</th>
<th>Image</th>
</tr> 
<tr class="success" ng-repeat="ad in adproduct|filter:searchprd">
                <td>{{ad.aproductId}}</a></td> 
                 <td>{{ad.aprodName}}</td>
                <td>{{ad.asupplierId}}</td>
                <td> {{ad.acategoryId}}</td>
                <td> {{ad.astock}}</td>
                <td> {{ad.aprice}}</td>
                     <td><a href="UpdateAdmprod?adpid={{ad.aproductId}}">Edit</a></td>
                <td><a href="deladprod?adpid={{ad.aproductId}}">Delete</a></td>
                <td><img src="./Resources/img/{{ad.aproductId}}.jpg" height="50px" width="50px"/></td> 
</tr>
</table>
</div>
	</div>

</div>
<%@include file="AdminFooter.jsp" %>