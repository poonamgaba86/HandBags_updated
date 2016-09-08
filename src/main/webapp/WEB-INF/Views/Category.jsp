<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="CommonHeader.jsp" %>

<div class="container">
    <h1 class="well">Add Category</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" commandName="category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input type="text" path="categoryid" placeholder="" class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category Name</label>
								<form:input type="text" path="categorynm" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Description</label>
							<form:textarea path="categorydesc" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
					
					<button type="button" class="btn btn-lg btn-info">Add</button>					
					</div>
					
				</form:form> 
				</div>
	</div>
	</div>
<%@include file="CommonFooter.jsp" %>