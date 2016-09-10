<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
  var catgry = ${data};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.products=catgry;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>
<%@include file="AdminHeader.jsp" %>

<c:set var="income" scope="session" value="${check}"/>  
<c:choose>
<c:when test="${check}">
<c:out value="something"/>

</c:when>
 
<c:otherwise >
<c:out value="somethingnot "/>
</c:otherwise>

</c:choose>
<c:out value="${income}"/> 
welcome 2 add

<div class="container">
    <h1 class="well">Add Category</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="AddCategory" commandName="Category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input  path="categoryid" placeholder="" class="form-control"></form:input>
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
					<input type="submit" class="btn btn-lg btn-info" value="Update"  ></input>						
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>



		
	<div ng-app="repeatSample" ng-controller="repeatController">
search:<input type="text" placeholder="search product" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Category Id</th>
<th>Category name</th>
<th>Category Desc</th>
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
	
	
	<%@include file="AdminFooter.jsp" %>
