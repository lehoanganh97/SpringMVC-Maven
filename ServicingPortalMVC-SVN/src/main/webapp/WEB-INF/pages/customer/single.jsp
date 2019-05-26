<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
   <title>Portal Service | Home</title>
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
   <div class="header">
      <div class="col-sm-8 header-left">
         <div class="logo">
            <a href="index.html"><img src="customer/images/logo.png" alt=""/></a>
         </div>
         <div class="menu">
             <a class="toggleMenu" href="#"><img src="customer/images/nav.png" alt="" /></a>
             <ul class="nav" id="nav">
               <li class="active"><a href="index.html">Home</a></li>
               <li><a href="rooms.html">Rooms</a></li>
               <li><a href="news.html">News</a></li>
               <li><a href="gallery.html">Gallery</a></li>
               <li><a href="404.html">Blog</a></li>
               <div class="clearfix"></div>
             </ul>
            <script type="text/javascript" src="customer/js/responsive-nav.js"></script>
         </div>  
      <!-- start search-->
         <div class="search-box">
            <div id="sb-search" class="sb-search">
               <form>
                  <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                  <input class="sb-search-submit" type="submit" value="">
                  <span class="sb-icon-search"> </span>
               </form>
            </div>
         </div>
         <!----search-scripts---->
         <script src="customer/js/classie.js"></script>
         <script src="customer/js/uisearch.js"></script>
         <script>
            new UISearch( document.getElementById( 'sb-search' ) );
         </script>
         <!----//search-scripts---->                  
         <div class="clearfix"></div>
      </div>
      <div class="col-sm-4 header_right">
         <div id="loginContainer"><a href="#" id="loginButton"><img src="customer/images/login.png"><span>Login</span></a>
           <div id="loginBox">                
             <form id="loginForm">
                 <fieldset id="body">
                     <fieldset>
                         <label for="email">Email</label>
                         <input type="text" name="email" id="email">
                     </fieldset>
                     <fieldset>
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password">
                     </fieldset>
                    <input type="submit" id="login" value="Sign in">
                    <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
                  </fieldset>
               <span><a href="#">Forgot your password?</a></span>
             </form>
            </div>
         </div>
         <div class="clearfix"></div>
      </div>
      <div class="clearfix"></div>
   </div>
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
        Content Here
      </div>
   </div>
   <div class="footer">
      <div class="container">
        <div class="footer_top">
         <h3>Subscribe to our newsletter</h3>
         <form>
            <span>
               <i><img src="customer/images/mail.png" alt=""></i>
               <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
               <label class="btn1 btn2 btn-2 btn-2g"> <input name="submit" type="submit" id="submit" value="Subscribe"> </label>
               <div class="clearfix"> </div>
            </span>               
         </form>
        </div>
         <div class="footer_grids">
        
         <div class="clearfix"> </div>
      </div>
     </div>
   </div>
</body>
</html>     