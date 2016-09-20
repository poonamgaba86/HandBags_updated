
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>
<%@include file="CommonHeader.jsp" %>

<script>


var order = ${data};
angular.module('myApp', []).controller('myCtrl',
			function($scope) {
				$scope.pro = order;
               
				
			});
</script>



<div class="Container" ng-app='myApp'>
<!--  display data code -->

			
			
			
	
	<div class="row thumbnail">
			<div class="col-12">

				<div ng-app="repeatSample" ng-controller="myCtrl">

					<table class="table table-hover">
						<thead>
							<tr>

								<!--  <th>Phon</th> -->
								<th>Order No -</th>
								<th>{{pro.orderId}}</th>
							</tr>
							<tr>
								<th>Order Status</th>
								<th>{{pro.orderStatus}}</th>
							</tr>

							<tr>
								<th>Order Date</th>
								<th>{{pro.orderDate}}</th>
							</tr>
							<tr>
								<th>Customer  ID</th>
								<th>{{pro.userId}}</th>
							</tr>
                                  <tr>
								<th>Amount Payable</th>
								<th>{{pro.grandTotal}}</th>
							</tr>
							  <tr>
								<th>Payment Method</th>
								<th>{{pro.paymentMode}}</th>
							</tr>
							  <tr>
								<th>Delivery Address</th>
								<th>{{pro.address}}</th>
							</tr>
						</thead>

					</table>






				</div>

	
			
				</div>
			</div>
				
		</div>	

<%@include file="CommonFooter.jsp" %>
