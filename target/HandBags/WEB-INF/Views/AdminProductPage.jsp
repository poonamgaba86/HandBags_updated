<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="AdminHeader.jsp" %>

<div class="container">
	<div class="row">
		<form:form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Request Details</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="requestName">Product Id</label>  
  <div class="col-md-4">
  <form:input id="requestName"  class="form-control input-md" required="" path="productId"></form:input>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="company_name">Product Name</label>  
  <div class="col-md-5">
  <form:input  placeholder="Company Name" class="form-control input-md" required="" path="prodName"></form:input>
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="comments">Product Description</label>
  <div class="col-md-4">                     
    <form:textarea class="form-control" path="desciption"/>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="declineType">Supplier ID</label>
  <div class="col-md-6">
    <form:select id="declineType" name="declineType" class="form-control"path="supplierId">
      <form:option value="Exponential">Exponential (Conventional)</form:option>
      <form:option value="Hyperbolic">Hyperbolic (Unconventional)</form:option>
    </form:select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="declineType">Category ID</label>
  <div class="col-md-6">
    <form:select id="declineType" name="declineType" class="form-control" path="categoryId">
      <form:option value="Exponential">Exponential (Conventional)</form:option>
      <form:option value="Hyperbolic">Hyperbolic (Unconventional)</form:option>
    </form:select>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>  
  <div class="col-md-5">
  <form:input id="econLimOil" name="econLimOil" placeholder="company specific range" class="form-control input-md" type="text"path="stock"></form:input>
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="econLimOil">Price</label>  
  <div class="col-md-5">
  <form:input id="econLimOil" name="econLimOil" placeholder="" class="form-control input-md" type="text" path="price"></form:input>
    
  </div>
</div>







<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-default">Submit</button>
  </div>
</div>

</fieldset>
</form:form>

	</div>
</div>	<%@include file="AdminFooter.jsp" %>