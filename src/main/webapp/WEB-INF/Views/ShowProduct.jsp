<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<%@include file="CommonHeader.jsp" %>

<!-- <table border="1">
<s:forEach var="user" items="${list}">
<tr>
<td> ${user.productid}</td>
<td> ${user.name}</td>
<td> ${user.description}</td>
<td> ${user.supplierid}</td>
<td> ${user.price}</td>
<td> ${user.quantity}</td>


</tr>
</s:forEach>
</table> -->

<!--<script>
  var prod = ${proddt};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.products=prod;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>
 -->
<!-- <div ng-app="repeatSample" ng-controller="repeatController">
search:<input type="text" placeholder="search product" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
<tr class="success" ng-repeat="product in products|filter:searchprd">
              <!--   <td><a href="ProductDescription?pid={{product.pid}}"></a></td> -->
    <!--           <td> {{product.productid}}</td>
                <td>{{product.name}}</td>
                <td>{{product.description}}</td>
                <td>{{product.supplierid}}</td>
                <td>{{product.price}}</td>
                 <td><img src="./Resources/img/{{product.img}}.jpg" height="50px" width="50px"/></td>  
</tr>
</table>
</div> -->

<script>
  var prod = ${dat};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.products=prod;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>
<div ng-app="repeatSample" ng-controller="repeatController">
	<div class="container" ng-model="searchprd">
		<div class="row " ng-repeat="product in products|filter:searchprd" >
			<div class="col-md-6">
			<!-- 	<div style="background-color:#E8E8E8;border-style:dotted solid double dashed;" > -->
 				 <a href="ShwPrdtInDetail?adpid={{product.aproductId}}">
					<img src="./Resources/img/{{product.aproductId}}.jpg" height="200px" width="200px"/>
				</a> 
	<!-- 	</div> -->	
		</div>	
			<div class="col-md-6">
			<!-- <h4>Productid:{{product.aproductId}}</h4> -->
			<h4>Product name: {{product.aprodName}}</h4> 
		<!-- 	<h4>Product description:{{product.adesciption}} </h4> -->
				</div>
		

		
	</div>
</div>
</div>

 

<%@include file="CommonFooter.jsp" %>