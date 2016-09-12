<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="CommonHeader.jsp" %>
<SCRIPT type="text/javascript"> 

function validatePassword(){
	var password = document.getElementById("password");
	var confirm_password = document.getElementById("password_confirmation");

if(password.value != confirm_password.value) {
	
  confirm_password.setCustomValidity("Passwords Don't Match");
  confirm_password.reportValidity();
  //alert('sorry');
  //return false;
}
//return true;


else {
 confirm_password.setCustomValidity('');
}
}
password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</SCRIPT> 

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Please sign up for Registration</h3>
			 			</div>
				<div class="panel-body">
					<form:form method="post" commandName="RegisterUser"	action="Registerview">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="firstName">First Name</form:label>
									<form:input path="firstName" class="form-control input-sm"
										placeholder="First Name" required="required"></form:input>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="lastName">Last Name</form:label>
									<form:input path="lastName" name="last_name" id="last_name"
										class="form-control input-sm" placeholder="Last Name"
										required="required"></form:input>
								</div>
							</div>
						</div>

						<div class="form-group">
							<form:label path="emailId">Email Id</form:label>
							<form:input path="emailId" name="email" id="email"
								class="form-control input-sm" placeholder="Email Address"
								required="required"></form:input>
						</div>


						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="userName">User Name</form:label>
									<form:input path="userName" class="form-control input-sm"
										placeholder="User Name" required="required"></form:input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="password">Password</form:label>
									<form:password path="password" name="password" id="password"
										class="form-control input-sm" placeholder="Password"
										onchange="validatePassword()"></form:password>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="conPassword">Confirm Password</form:label>
									<form:password path="conPassword" name="password_confirmation"
										id="password_confirmation" class="form-control input-sm"
										placeholder="Confirm Password" onkeyup="validatePassword()"></form:password>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="mobileNo">Mobile No</form:label>
									<form:input path="mobileNo" class="form-control input-sm"
										placeholder="Mobile No" required="required"></form:input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:label path="Address">Address</form:label>
									<form:textarea class="form-control" placeholder="Address"
										path="Address" cols="18"></form:textarea>

								</div>
							</div>
						</div>
				
				<input type="submit" value="Register" class="btn btn-info btn-block"
					onclick="validatePassword()">

				</form:form>
				</div>
				
			</div>
	    		</div>
    		</div>
    	</div>

<%@include file="CommonFooter.jsp" %>