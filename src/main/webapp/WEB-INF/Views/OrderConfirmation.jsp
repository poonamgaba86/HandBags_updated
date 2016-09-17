<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<%@include file="CommonHeader.jsp" %>

<script>
  var prod = ${cart};
  angular.module('repeatSample', []).controller('repeatController',['$scope', function($scope)
   {
                 $scope.products=prod;
                 $scope.value=1;
                 $scope.change=function(value)
                 {
                	 $scope.products.qty=Number($scope.value);
                 };
               
              
    }]);
</script>


 <div class="container">
 <form:form class="form-horizontal" method="post" action=""	commandName="CartDetail" enctype="multipart/form-data">
 <div ng-app="repeatSample" ng-controller="repeatController" >

<table class="table table-bordered table-hover table-striped">
<tr>
<th>Image</th>
<th>Item</th>
<th>Quantity</th>
<th>Price</th>
<th>Subtotal</th>
</tr>
<tr  ng-repeat="product in products">
                 <td><a href="">
					<img src="./Resources/img/{{product.pid}}.jpg" height="100px" width="100px"/>
				</a>
				 </td> 
            <td> {{product.pname}}  </td>
            <td><form:label path="qty"/>{{value}}</td>
                
                <td>{{product.price}}</td>
                <td><form:label path="total">{{value*product.price}}</form:label></td>
                
                  
</tr>
</table>
</div> 
    <div class="col-md-10 ">
  <div class="pull-right">
  <a href="AddToCartgoback">Edit</a></div>  
      </div>
<br><br>
<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6"> 
								<div class="form-group">
									<form:label path="">Address</form:label>
									
										${useraddr}
								</div>
						</div> 
						</div>
</form:form> 
<div class="pull-right">
<a href="PaymentConfirmed"><img src="Resources/img/pay.png"></img></a>
</div>
</div>

<%@include file="CommonFooter.jsp" %>