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
			    		<form:form method="post" commandName="register">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <form:input type="text" path="first_name" id="first_name" class="form-control input-sm" placeholder="First Name" required="required"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="text" path="last_name" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name" required="required"></form:input>
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<form:input type="email" path="email_id" name="email" id="email" class="form-control input-sm" placeholder="Email Address" required="required"></form:input>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" path="password" name="password" id="password" class="form-control input-sm" placeholder="Password" onchange ="validatePassword()"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" path="password_confirmation" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password" onkeyup="validatePassword()" ></form:input>
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block" onclick="validatePassword()">
			    		
			    		</form:form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
<%@include file="CommonFooter.jsp" %>