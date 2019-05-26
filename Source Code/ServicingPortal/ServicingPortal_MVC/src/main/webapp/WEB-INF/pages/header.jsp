<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
                <li><i class="fa fa-envelope" aria-hidden="true"></i><a href="mailto:${datawebs.get(0).DWContent }">${datawebs.get(0).DWContent }</a></li>
                <li><i class="fa fa-phone" aria-hidden="true"></i>${datawebs.get(1).DWContent }</li>
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
                    <a id="id011" href="#Login" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a>
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
                    <a id="id011" href="#">Sign Up</a>
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



</body>
</html>