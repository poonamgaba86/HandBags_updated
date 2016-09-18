<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="CommonHeader.jsp" %>
<form:form class="col-md-12 well" commandName="Contact" action="ContactUs">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <form:input path="name" class="form-control"  placeholder="Enter Name" method="post"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <form:input path="email" class="form-control"  placeholder="Enter email"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <form:input path="phone" class="form-control" name="phone" placeholder="Enter phone"></form:input>
                            </div>
                         <!--    <div class="form-group">
                                <label for="subject">Subject</label>
                                <select class="form-control" name="subject">
                                    <option selected value="na">Choose One:</option>               
                                    <option value="inquiry">General Inquiry</option>               
                                    <option value="suggestions">Suggestions</option>              
                                    <option value="other">Other</option>
                                </select>
                            </div>  -->                       
                        </div>
                
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="message">Message</label>
                                <form:textarea class="form-control" path="msz" rows="11" placeholder="Enter Message"></form:textarea>
                            </div>
                            <div class="form-group">
                               <input type="submit" class="btn btn-primary pull-right" value="submit" onClick="alert('Thanku for contacting us!! Revert you AS SOON AS POSSIBLE ')">
                            </div>
                        </div>
                    </div>
				</form:form>
<%@include file="CommonFooter.jsp" %>