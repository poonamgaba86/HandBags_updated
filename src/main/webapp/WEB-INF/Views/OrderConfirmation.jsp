<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<%@include file="CommonHeader.jsp"%>

<script>
	var prod = ${cart};
	angular.module('repeatSample', []).controller('repeatController',
			[ '$scope', function($scope) {
				$scope.products = prod;
				$scope.change = function(value) {
					$scope.products.qty = Number($scope.value);
				};

			} ]);
</script>


<div class="container">
	<form:form class="form-horizontal" method="post" action=""
		commandName="CartDetail" enctype="multipart/form-data">
		<div ng-app="repeatSample" ng-controller="repeatController">

			<table class="table table-bordered table-hover table-striped">
				<tr>
					<th>Image</th>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Subtotal</th>
				</tr>
				
				<tr ng-repeat="product in products">
					<td><a href=""> <img src="./Resources/img/{{product.pid}}.jpg" height="100px" width="100px" />
					</a></td>
					<td>{{product.pname}}</td>
					<td><form:label path="qty" />{{product.qty}}</td>
					<td>{{product.price}}</td>
					<td><form:label path="total">{{product.qty*product.price}}</form:label></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Grand Total:${sessionScope.grandtotal}</td>
				</tr>
			
			</table>
		</div>
		<div class="col-md-10 ">
			<div class="pull-right">
				<a href="AddToCartgoback">Edit</a>
			</div>
		</div>
		
		<br>
		<br>
		<br>
	<b>	Customer Information</b>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<div class="form-group">
					<table  class="table table-bordered">
						<tr>
							<td>First Name :</td>
							<td>${info.firstName}</td>
						</tr>
						<br>
						<br>
						<tr>
							<td>Last Name :</td>
							<td>${info.lastName}</td>
						</tr>
						<br>
						<br>
						<tr>
							<td>Email-id :</td>
							<td>${info.emailId}</td>
						</tr>
						<br>
						<br>
						<tr>
							<td>Mobile no :</td>
							<td>${info.mobileNo}</td>
						</tr>
						<br>
						<br>
						<tr>
							<td>Address :</td>
							<td>${useraddr}</td>
						</tr>
					</table>

				</div>
			</div>
		</div>
	</form:form>
	<div class="pull-right">
		<a href="OrderConfirmed"><img src="Resources/img/confirm.jpg"></img></a>
	</div>
</div>

<%@include file="CommonFooter.jsp"%>