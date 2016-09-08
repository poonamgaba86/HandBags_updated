<%@include file="CommonHeader.jsp" %>
<form class="col-md-12 well">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" placeholder="Enter Name">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" placeholder="Enter email">
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="tel" class="form-control" name="phone" placeholder="Enter phone">
                            </div>
                            <div class="form-group">
                                <label for="subject">Subject</label>
                                <select class="form-control" name="subject">
                                    <option selected value="na">Choose One:</option>               
                                    <option value="inquiry">General Inquiry</option>               
                                    <option value="suggestions">Suggestions</option>              
                                    <option value="other">Other</option>
                                </select>
                            </div>                        
                        </div>
                
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="message">Message</label>
                                <textarea class="form-control" name="message" rows="11" placeholder="Enter Message"></textarea>
                            </div>
                            <div class="form-group">
                               <button class="btn btn-primary pull-right" type="submit">Send</button>
                            </div>
                        </div>
                    </div>
				</form>
<%@include file="CommonFooter.jsp" %>