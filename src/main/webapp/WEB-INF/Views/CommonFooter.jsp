
<link href="Resources/css/footer.css" rel="stylesheet">
 
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<center><h3>FIND US ON</h3></center>
	<footer class="footer" style="background-color:#00FFFF;">
    <div class="container text-center">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
        <a href="#"><i class="fa fa-google-plus"></i></a>
        <a href="#"><i class="fa fa-skype"></i></a>
    </div><!--End container-->
</footer><!--End footer 2-->
    		
<%
    Integer hitsCount =(Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 )
    {
       /* First visit */
       out.println("Welcome to NuLookWomen.com!");
       hitsCount = 1;
    }
    else
    {
       /* return visit */
       out.println("Welcome to NuLookWomen.com!");
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<center><p>Total number of visits: <%= hitsCount%></p></center>

	
		<center>
		<p>	Copyright Style Icon © 2009 - 2016<br>
				Website by Poonam Gaba
			</p>
			</center>
			
		


	
				
				</div>
				
</body>
</html>