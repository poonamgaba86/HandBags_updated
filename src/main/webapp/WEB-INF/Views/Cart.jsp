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
            <td> {{product.pname}} <br><br><a href="RemoveFromCart?pid={{product.pid}}">Remove</a>   </td>
            <td><form:input path="qty" ng-model="value"  ng-change="change(value)"/></td>
                
                <td>{{product.price}}</td>
                <td><form:label path="total">{{value*product.price}}</form:label></td>
                
                  
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>


<td>Grand Total:</td></tr>
</table>
</div> 

</form:form> 
</div>
<div class="container">
  
  <a href="ShowProduct"><img src="Resources/img/Continue-Shopping.png"></a>
  <a href="OrderConfirmation"><img src="Resources/img/place.jpg"></a>
  
</div>
<%@include file="CommonFooter.jsp" %>