<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<%@include file="CommonHeader.jsp" %>

<script>
  var prod = ${detail};
 <!-- var img = ${imgpath};-->
  
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
		<div class="row "  >
			<div class="col-md-6">
			<!-- 	<div style="background-color:#E8E8E8;border-style:dotted solid double dashed;" > -->
 				 <a href="">
					<img src="./Resources/img/{{products.aproductId}}.jpg" height="600px" width="600px"/>
				</a> 
	<!-- 	</div> -->	
		</div>	
			<div class="col-md-6">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<h4>Productid:{{products.aproductId}}</h4>
			<h4>Product name: {{products.aprodName}}</h4> 
			<h4>Product description:{{products.adesciption}} </h4>
			<h4>Product Price:{{products.aprice}} </h4>
			<button >ADD TO CART</button>
				</div>
		
			
		
	</div>
	
</div>
</div>

 

<%@include file="CommonFooter.jsp" %>