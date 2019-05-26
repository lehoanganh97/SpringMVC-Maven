<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- contact -->
	<div class="w3ls-section contact" id="contact">
		<div class="container">
			<div class="w3-heading-all contact-head">
		<h3>Contact us</h3>
		<span  class="w3-heading-icon">
		</span>
		</div>
			<div class="contact-form">
				<div class="col-md-5 contact-left">
					<div class="address">
						<h5>Address:</h5>
						<p><i class="glyphicon glyphicon-home"></i> ${datawebs.get(1).WDCContent }</p>
					</div>
					<div class="address address-mdl">
						<h5>phone:</h5>
						<p><i class="glyphicon glyphicon-earphone"></i> ${datawebs.get(2).WDCContent }</p>
						<p><i class="glyphicon glyphicon-phone"></i> ${datawebs.get(2).WDCContent }</p>
					</div>
					<div class="address">
						<h5>Email:</h5>
						<p><i class="glyphicon glyphicon-envelope"></i> <a href="mailto:>${datawebs.get(3).WDCContent }">${datawebs.get(3).WDCContent }</a></p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-7 contact-right">
					<h5>send us a note</h5>
					<form action="#" class="form_w3layouts" method="post">
						<input type="text" placeholder="Name" required>
						<input class="email" type="email" placeholder="Email" required>
						<textarea placeholder="Message" required></textarea>
						<input type="submit" value="SUBMIT">
						<input type="reset" value="CLEAR">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
        <!--
		<div class="w3-contact-pos">
		<h3>get in touch to get latest designs</h3>
		<p>for free demo ask our team to get dream design</p>
		</div>
        -->
	</div>
	
	<!-- //contact -->

	<!-- footer -->
	<div class="footer w3layouts">
		<div class="container">
			<div class="footer-agileinfo">
				<div class="col-md-3 col-sm-6 footer-grid">
					<h3>Our Designs</h3>
					<p>Lorem Ipsum was popularised In sit amet sapien eros Integer dolore magna .</p> 
				</div> 
				<div class="col-md-3 col-sm-6 footer-grid footer-tags">
					<h3>Navigation</h3>
					<ul>
						<li><a href="#"><i class="fa fa-angle-right"></i> Home</a></li>
						<li><a href="#"><i class="fa fa-angle-right"></i> Information</a></li> 
						<li><a href="#"><i class="fa fa-angle-right"></i> Gallery</a></li>
                        <li><a href="#"><i class="fa fa-angle-right"></i> Blog</a></li>
						<li><a href="#"><i class="fa fa-angle-right"></i> About Us</a></li>
                        <li><a href="#"><i class="fa fa-angle-right"></i> Partner</a></li>
                        
					</ul>
				</div>
				<div class="col-md-4 col-sm-6 footer-grid footer-review">
					<h3>Newsletter</h3>
					<p>Input your Email to receive our news</p> 
					<form action="#" method="post">
						<input type="email" name="Email" placeholder="Your Email" required="required">
						<input type="submit" value="Subscribe"> 
						<div class="clearfix"> </div>
					</form>  
				</div>
				<div class="col-md-2 col-sm-6 footer-grid w3social">
					<h3>Media</h3>
					<ul>
						<li><a href="#"><i class="fa fa-google-plus"></i>Google-plus</a></li>
						<li><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
						<li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i>Dribbble</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div> 
		</div>
	</div>
	<div class="copy-right wthree"> 
		<div class="container">
			<p>© 2018 Portal Service. All rights reserved | Design by <a href="http://w3layouts.com"> W3layouts </a>| Develop by team Desgin.</p>
		</div>
	</div>  
	<!-- //footer -->

</body>
</html>