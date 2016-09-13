<%@include file="WEB-INF/Views/CommonHeader.jsp" %>


<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="Resources/img/icon.jpg" alt="Chania">
        <div class="carousel-caption">
          <h3>HandBags</h3>
          <p>Chhavi Pink PU Casual Plain Handbag</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/img/pink1.jpg" alt="Chania" width="100" height="100">
        <div class="carousel-caption">
          <h3>HandBags</h3>
          <p>Indian Style Pinkcolor PU Casual Plain Handbag.</p>
        </div>
      </div>
    
      <div class="item">
        <img src="Resources/img/pink2.jpg" alt="Flower" width="200" height="200">
        <div class="carousel-caption">
          <h3>HandBags</h3>
          <p>Brompton.</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/img/pink3.jpg" alt="Flower" width="200" height="200">
        <div class="carousel-caption">
          <h3>Handbags</h3>
          <p>Covo Pink Handbags</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<%@include file="WEB-INF/Views/CommonFooter.jsp" %>