<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
  var catgry = ${data};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.products=catgry;
   
          
              
    });
</script>
<%@include file="AdminHeader.jsp" %>

<c:set var="income" scope="session" value="${check}"/>  
<c:choose>
<c:when test="${check}">


<div class="container">
    <h1 class="well">Add Category</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="AddCategory" commandName="Category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input  path="categoryid" placeholder="" class="form-control" readonly="true" value="${catid+1}"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category Name</label>
								<form:input type="text" path="categorynm" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Description</label>
							<form:textarea path="categorydesc" placeholder="" rows="3" class="form-control"></form:textarea>
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
 <tr><th>Category Id</th>
<th>Category name</th>
<th>Category Desc</th>
<th>Edit</th>
<th>Delete</th>
</tr> 
<tr class="success" ng-repeat="product in products|filter:searchprd">
                <td>{{product.categoryid}}</a></td> 
         <!--  <td> {{product.categoryid}}</td> -->
                <td>{{product.categorynm}}</td>
                <td>{{product.categorydesc}}</td>
            <td><a href="UpdateCategory?categoryid={{product.categoryid}}">Edit</a></td>
                <td><a href="DeleteCategory?categoryid={{product.categoryid}}">Delete</a></td>
               <!--   <td><img src="./Resources/img/{{product.img}}.jpg" height="50px" width="50px"/></td> -->  
</tr>
</table>
</div> 


</c:when>
 
<c:otherwise >
	<div class="container">
    <h1 class="well">Update Category</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="UpdateCategory" commandName="Category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input  path="categoryid" placeholder="" class="form-control" readonly="true"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category Name</label>
								<form:input type="text" path="categorynm" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Description</label>
							<form:textarea path="categorydesc" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
					
					<input type="submit" class="btn btn-lg btn-info" value="Update" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
	



</c:otherwise>

</c:choose>



	



		

	
	
	<%@include file="AdminFooter.jsp" %>
