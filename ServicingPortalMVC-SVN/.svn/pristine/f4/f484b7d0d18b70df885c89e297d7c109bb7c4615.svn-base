<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
   <link href="customer/css/bootstrap.css" rel='stylesheet' type='text/css' />
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <!-- Custom Theme files -->
   <link href="customer/css/style.css" rel='stylesheet' type='text/css' />
   <!-- Custom Theme files -->
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
   <!--webfont-->
   <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
   <script type="text/javascript" src="customer/js/jquery-1.11.1.min.js"></script>
   <script type="text/javascript" src="customer/js/login.js"></script>
   <script src="customer/js/jquery.easydropdown.js"></script>
   <!--Animation-->
   <script src="customer/js/wow.min.js"></script>
   <link href="customer/css/animate.css" rel='stylesheet' type='text/css' />
   <script>
      new WOW().init();
   </script>
</head>
<body>
<div class="banner">
      <div class="container_wrap">            
         <div class="clearfix"></div>
      </div>
   </div>
   <div class="content_top">
    <div class="container">
      <div class="col-md-4 filter_grid">
         <ul class="filter">
            <li><a href=""> <i class="icon1"> </i> </a></li>
            <li><a href=""> <i class="icon2"> </i> </a></li>
            <li><a href=""> <i class="icon3"> </i> </a></li>
            <li><a href=""> <i class="icon4"> </i> </a></li>
            <li><a href=""> <i class="icon5"> </i> </a></li>
         </ul>
      </div>
    </div>
   </div>
   <div class="content_middle">
      <div class="container">
          <div class="title">Home & Clearn</div>
          <div class="content_middle_box">
            <div class="col-md-3 index-grids">
              <div class="grid1">
              
                <div class="view view-first">
                <a href="SuaChua">
                  <div class="index_img"><img src="customer/images/pic1.jpg" class="img-responsive" alt=""/></div>
                  <div class="sale">$2.980</div>
                  <div class="mask">
                      <div class="info"><i class="search"> </i> Show More</div>
                  </div>
                </div> 
                <div class="inner_wrap">
                  <h3>Sửa chữa nước</h3>
                </div>
                </a>
              </div>
            </div>
            <div class="col-md-3 index-grids">
              <div class="grid1">
                <div class="view view-first">
                  <div class="index_img"><img src="customer/images/pic1.jpg" class="img-responsive" alt=""/></div>
                  <div class="sale">$2.980</div>
                  <div class="mask">
                      <div class="info"><a href=""> <i class="search"></i></a> Show More</div>
                  </div>
                </div> 
                <div class="inner_wrap">
                  <h3>Sửa chữa điện</h3>
                </div>
              </div>
            </div>
          </div>
      </div>
   </div>
   <div class="container">
    	<c:forEach var="field" items="${fields}">
        <h1 id="h1-first">${field.fserviceName}</h1>
        <!--  <a href="https://github.com/rtpHarry/Bootstrap3-ShowManySlideOneCarousel">this code sample</a>   -->
        <div class="row">
            <div class="col-md-10">
                <div class="carousel carousel-showmanymoveone slide" id="${field.fserviceId}" data-interval="false">
                    <div class="carousel-inner">
                    	<%int i = 0;%>
         				<c:forEach var="ser" items="${field.services}">
         					<%if(i++ == 0) {%>
         						 <div class="item active">
                            		<div class="col-xs-11 col-sm-6 col-md-4">
                                		<a href="${ser.serviceID}"><img src="images/${ser.fserviceImage}" class="img-responsive">
                                    		<h3 id="center">${ser.serviceName}</h3>
                                		</a>
                            		</div>
                        		</div>
         					<%} else {%>
         						<div class="item">
                            		<div class="col-xs-11 col-sm-6 col-md-4">
                                		<a href="${ser.serviceID}"><img src="images/${ser.image}" class="img-responsive">
                                    		<h3 id="center">${ser.serviceName}</h3>
                                		</a>
                            		</div>
                        		</div>
         					<%} %>
         				</c:forEach>
                    </div>
                    <div>
                        <a class="left carousel-control" href="#${field.fieldID}" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
                        <a class="right carousel-control" href="#${field.fieldID}" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        </c:forEach> 
    </div>
</body>
</html>
