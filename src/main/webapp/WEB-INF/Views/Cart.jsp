<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<%@include file="CommonHeader.jsp"%>

<script>
	var prod = ${cart};
	angular.module('repeatSample', []).controller('repeatController',
			[ '$scope', function($scope) 
			  {
				$scope.products = prod;
				$scope.value;
				$scope.change = function(value) 
				{
					$scope.products.qty = Number($scope.value);
				};

			} ]);
</script>


<div class="container">
	<c:choose>
		<c:when test="${empty count}">
List is empty
</c:when>

		<c:otherwise>


				<form:form class="form-horizontal" method="get" action="updateqty">
				<div ng-app="repeatSample" ng-controller="repeatController">

					<table class="table table-bordered table-hover table-striped">
						<tr>
							<th>Image</th>
							<th>Item</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
						</tr>
						<c:forEach items="${cartitm}" var="product">
						<form action="updateqty" method="get">
						<tr >
							
							<td><img src="Resources/img/${product.pid}.jpg" height="50" width="50"/></td>
							<td>${product.pname}</td>
							<td><input type="text" name="qty" value="${product.qty}" /><input type="hidden" name="pid" value="${product.pid}"/>&nbsp;&nbsp;&nbsp; <input type="submit" value="update"></td>
							<td>${product.price}</td>
							<td>${product.qty*product.price}<br>
							<br>
							<a href="RemoveFromCart?pid=${product.pid}">Remove</a></td>
							
						</tr>
						</form>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>


							<td>Grand Total:${sessionScope.grandtotal}</td>
						</tr>
						
					</table>
				</div>
				</form:form>
			
</div>
</c:otherwise>

</c:choose>
<div class="container">

	<a href="ShowProduct"><img
		src="Resources/img/Continue-Shopping.png"></a> <a
		href="OrderPlaced"><img src="Resources/img/place.jpg"></a>

</div>
<%@include file="CommonFooter.jsp"%>