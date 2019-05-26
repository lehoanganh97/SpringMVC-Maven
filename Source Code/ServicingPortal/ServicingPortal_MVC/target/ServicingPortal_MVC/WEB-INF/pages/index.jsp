<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Portal Services | Home</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Design Lab Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //for-mobile-apps -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />

    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/mystyle.css" rel="stylesheet" type="text/css" media="all" />
    <!--fonts-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,700i,900,900i" rel="stylesheet">
    <!--//fonts-->
</head>


<body>
<!-- ................................................................................................................................... -->
	
	<!-- Header -->

<div class="banner-top">
        <!--  <div class="social-bnr-agileits">
            <ul class="social-icons3">
                <li>
                    <a href="#" class="fa fa-facebook icon-border facebook"> </a>
                </li>
                <li>
                    <a href="#" class="fa fa-twitter icon-border twitter"> </a>
                </li>
                <li>
                    <a href="#" class="fa fa-google-plus icon-border googleplus"> </a>
                </li>
                <li>
                    <a href="#" class="fa fa-rss icon-border rss"> </a>
                </li>
            </ul>
        </div> -->
        <h1><a class="navbar-brand" href="index.html"> PORTAL SERVICE </a></h1>
        <div class="contact-bnr-w3-agile">
            <ul>
                <li class="menu__item"><a href="#" class="menu__link">Information</a></li>
                <li class="menu__item"><a href="#" class="menu__link">Blog</a></li>
                <li class="menu__item"><a href="#" class="menu__link">Partner</a></li>
                <!-- Hiện khi đã đăng nhập-->
                <!--   <li>
                    	<div class="dropdown">
                        	<img src="images/account.png" alt="">
                       		<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="normal"> Hello,... <b class="caret"></b></a>
                            <ul class="dropdown-menu">
      							<li><a href="#" id="normal">Personal information</a></li>
      							<li><a href="#" id="normal">Cart information</a></li>
      							<li><a href="#" id="normal">Sign out</a></li>
    						</ul>
                        </div>
                    </li> -->
                <!-- End// -->
                <!-- Hiện khi chưa đăng nhập -- đã đăng nhập rồi sẽ ẩn -->
                <li>
                    <a href="#Login" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a>
                    <div id="id01" class="modallogin">
                        <form class="modallogin-content animate" action="">
                            <div class="imgcontainerlogin">
                                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                                <img src="images/36958469-welcome-typography.jpg" alt="Avatar" class="avatar">
                            </div>
                            <div class="containerlogin">
                                <label for="uname"><b>Username</b></label>
                                <input type="text" placeholder="Enter Username" name="uname" required>

                                <label for="psw"><b>Password</b></label>
                                <input type="password" placeholder="Enter Password" name="psw" required>

                                <button type="submit">Login</button>
                                <label>
						        <input type="checkbox" checked="checked" name="remember"> Remember me
						      </label>
                            </div>
                            <div class="containerlogin" style="background-color:#f1f1f1">
                                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                                <span class="psw">Forgot <a href="#">password?</a></span>
                            </div>
                        </form>
                    </div>


                </li>
                <li>
                    <a href="#">Sign Up</a>
                </li>
                <!-- End// -->
                <li>
                    <a href="#"><img src="images/vn.png" alt=""></a>&nbsp;
                    <a href="#"><img src="images/usa.png" alt=""></a>
                </li>
            </ul>
        </div>

        <div class="clearfix"></div>

    </div>

	<!-- //Header -->
<!-- ................................................................................................................................... -->
	<!-- Banner -->

	<div class="w3ls-banner">
        <!-- banner-text -->
        <!-- <div class="slider">
            <div class="callbacks_container"> -->
        <div class="w3layouts-banner-top" style="background-image: url(images/11.jpg);">

            <div class="container">
                <div class="agileits-banner-info">
                    <h4>PROVIDE SERVICE FOR YOU</h4>

                </div>
            </div>
        </div>
        <!-- </div> -->
        <div class="clearfix"> </div>
        <!-- //banner-text -->
        <!-- </div> -->
        <div class="main-agileits">
            <!--form-stars-here-->
            <div class="book-form">
                <form action="#" method="post">
                    <div class="w3ls-field1">
                        <select>
   							<option>Ho Chi Minh</option>
    						<option>Ha Noi</option>
    						<option>Da Nang</option>
  						</select>
                    </div>
                    <div class="w3ls-field2">
                        <input type="search" name="Search" placeholder="Search..." />
                    </div>

                    <div class="clearfix"> </div>
                </form>
            </div>
            <!--//form-ends-here-->
            <div class="clear"></div>
        </div>
    </div>

	<!-- //Banner -->
<!-- ................................................................................................................................... -->
	<!-- Field Choose -->

	<div class="services" id="services">
        <div class="container" align="center">
            <div class="w3-heading-all">
                <h3>Gallery Services</h3>
            </div>
            <!--Loc update 3/04/2018-->
            <div class="col-md-12">
            	<c:forEach var="field" items="${fields}">
            		<div class="col-sm-4 col-md-4 services-icons">
                    	<a href="${field.FServiceHref}"><i aria-hidden="true" style="text-align: center;"><img src="${field.FServiceImage}"> <h5>${field.FServiceName}</h5></i></a>
                	</div>
            	</c:forEach>
                <div class="clearfix"></div>
                <!--End update-->
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

	<!-- //Field Choose -->
<!-- ................................................................................................................................... -->
	<!-- Carousel Service -->

	<div class="clearfix"></div>
    <div class="container">

    	<c:forEach var="field" items="${fields}">
        <h1 id="h1-first">${field.FServiceName}</h1>
        <!--  <a href="https://github.com/rtpHarry/Bootstrap3-ShowManySlideOneCarousel">this code sample</a>   -->
        <div class="row">
            <div class="col-md-10">
                <div class="carousel carousel-showmanymoveone slide" id="${field.FServiceID}" data-interval="false">
                    <div class="carousel-inner">
                    	<%int i = 0;%>
         				<c:forEach var="ser" items="${field.fieldservices}">
         					<%if(i++ == 0) {%>
         						 <div class="item active">
                            		<div class="col-xs-11 col-sm-6 col-md-4">
                                		<a href="${ser.FServiceID}"><img src="images/${ser.FServiceImage}" class="img-responsive">
                                    		<h3 id="center">${ser.FServiceName}</h3>
                                		</a>
                            		</div>
                        		</div>
         					<%} else {%>
         						<div class="item">
                            		<div class="col-xs-11 col-sm-6 col-md-4">
                                		<a href="${ser.FServiceID}"><img src="images/${ser.FServiceImage}" class="img-responsive">
                                    		<h3 id="center">${ser.FServiceName}</h3>
                                		</a>
                            		</div>
                        		</div>
         					<%} %>
         				</c:forEach>
                    </div>
                    <div>
                        <a class="left carousel-control" href="#${field.FServiceID}" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
                        <a class="right carousel-control" href="#${field.FServiceID}" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        </c:forEach> 
    </div>

	<!-- //Carousel Service -->
<!-- ................................................................................................................................... -->

	<br/>
    <br/>

<!-- ................................................................................................................................... -->
	<!-- Contact, Footer -->

	 <jsp:include page="footer.jsp" />

	<!-- //Contact, Footer -->
<!-- ................................................................................................................................... -->
	<!-- Script -->

	<!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <script src="js/responsiveslides.min.js"></script>
    <script>
        // You can also use "$(window).load(function() {"
        $(function() {
            // Slideshow 4
            $("#slider4").responsiveSlides({
                auto: true,
                pager: true,
                nav: false,
                speed: 500,
                namespace: "callbacks",
                before: function() {
                    $('.events').append("<li>before event fired.</li>");
                },
                after: function() {
                    $('.events').append("<li>after event fired.</li>");
                }
            });

        });
    </script>
    <!-- clients js file-->
    <script src="js/jquery.wmuSlider.js"></script>
    <script>
        $('.example1').wmuSlider();
    </script>
    <!-- //clients js file -->

    <!--ssssssss-->
    <script type="text/javascript">
        (function() {
            $('.carousel-showmanymoveone .item').each(function() {
                var itemToClone = $(this);

                for (var i = 1; i < 3; i++) {
                    itemToClone = itemToClone.next();

                    // wrap around if at end of item collection
                    if (!itemToClone.length) {
                        itemToClone = $(this).siblings(':first');
                    }

                    // grab item, clone, add marker class, add to collection
                    itemToClone.children(':first-child').clone()
                        .addClass("cloneditem-" + (i))
                        .appendTo($(this));
                }
            });
        }());
    </script>
    <!--/ssssssss-->

    <!-- smooth scrolling -->
    <script type="text/javascript">
        $(document).ready(function() {
            /*
            	var defaults = {
            	containerID: 'toTop', // fading element id
            	containerHoverID: 'toTopHover', // fading element hover id
            	scrollSpeed: 1200,
            	easingType: 'linear' 
            	};
            */
            $().UItoTop({
                easingType: 'easeOutQuart'
            });
        });
    </script>
    <div class="arr-w3ls">
        <a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
    </div>
    <script>
        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
    <!-- //smooth scrolling -->
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

	<!-- //Script -->
<!-- ................................................................................................................................... -->
</body>

</html>