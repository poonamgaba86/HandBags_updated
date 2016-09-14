<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<tr class="success">
                 <td><a href="">
					<img src="./Resources/img/{{products.pid}}.jpg" height="100px" width="100px"/>
				</a>
				 </td> 
            <td> {{products.pname}} <br><br><a href="RemoveFromCart?ctpid={{products.cartId}}">Remove</a>   </td>
            <td><form:input path="qty" ng-model="value"  ng-change="change(value)"/></td>
                
                <td>{{products.price}}</td>
                <td><form:label path="total">{{products.qty*products.price}}</form:label></td>
                
                  
</tr>
</table>
</div> 

</form:form> 
</div>
<%@include file="CommonFooter.jsp" %>