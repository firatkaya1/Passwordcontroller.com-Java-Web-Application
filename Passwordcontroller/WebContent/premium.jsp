<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">

	<%
		if(session.getAttribute("email").toString() == null){
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	%>

<head>
<meta charset="UTF-8">
<title>Password Controller - Premium Page</title>
<link href="fonts/open/OpenSans-Regular.ttf" rel='stylesheet'
	type='text/css'>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style-premium.css">
</head>

<body>
	<div class="main">
		<header>
			<div class="header-area ">
				<div id="sticky-header" class="main-header-area">
					<div class="container-fluid p-0">
						<div class="row align-items-center no-gutters">
							<div class="col-xl-2 col-lg-2">
								<div class="logo-img">
									<a href="index.jsp"> <img src="img/logo.png" alt="">
									</a>
								</div>
							</div>
							<div class="col-xl-7 col-lg-7">
								<div class="main-menu  d-none d-lg-block">
									<nav>
										<ul id="navigation">
											<li><a href="home.jsp">Home </a></li>
											<li><a href="#">How Its Work ? </a></li>
											<li><a href="#">Manage <i class="ti-angle-down"></i></a>
												<ul class="submenu">
                                                        <li><a href="basictable.jsp">Basic Table</a></li>
                                                        <li><a href="emailservices.jsp">Email Services</a></li>
                                                        <li><a href="socialmediaservices.jsp">Social Media Services</a></li>
                                                        <li><a href="bankservices.jsp">Bank Services</a></li>
                                                        <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
                                                        <li><a href="#">Date Services</a></li>
                                                    </ul></li>
											<li><a class="active" href="premium.jsp">Premium</a></li>
										</ul>
									</nav>
								</div>
							</div>
							<div class="col-xl-3 col-lg-3 d-none d-lg-block">
								<div class="log_chat_area d-flex align-items-center">
									<div class="live_chat_btn">
										<a class="boxed_btn_orange" href="login.jsp"> <span
											class="falogins">Login</span>
										</a>
									</div>
								</div>
							</div>
							<div class="col-12">
								<div class="mobile_menu d-block d-lg-none"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<div class="pricing-container">
			<ul class="pricing-list bounce-invert">
				<li>
					<ul class="pricing-wrapper">
						<li data-type="monthly" class="is-visible"><header
								class="pricing-header">
								<h2>Small</h2>
								<div class="price">
									<span class="currency">$</span> <span class="value">2.99</span>
									<span class="duration">Year</span>
								</div>
							</header>
							<div class="pricing-body">
								<ul class="pricing-features">
									<li><em>20</em> Database Table Rows</li>
									<li><em>5</em> Email Account Services</li>
									<li><em>3</em> Encryption Algorithm</li>
									<li><em>40</em> Different Products Integration</li>
									<li><em>20</em> Download PDF Format</li>
									<li><em>24/7</em> Support</li>
								</ul>
							</div> <footer class="pricing-footer">
								<a class="select" href="payment.jsp">Select Plan</a>
							</footer></li>
					</ul>
				</li>
				<li>
					<ul class="pricing-wrapper">
						<li data-type="monthly" class="is-visible"><header
								class="pricing-header">
								<h2>Medium</h2>
								<div class="price">
									<span class="currency">$</span> <span class="value">5.99</span>
									<span class="duration">Year</span>
								</div>
							</header>
							<div class="pricing-body">
								<ul class="pricing-features">
									<li><em>50</em> Database Table Rows</li>
									<li><em>10</em> Email Account Services</li>
									<li><em>5</em> Encryption Algorithm</li>
									<li><em>60</em> Different Products Integration</li>
									<li><em>80</em> Download PDF Format</li>
									<li><em>24/7</em> Support</li>
								</ul>
							</div> <footer class="pricing-footer">
								<a class="select" href="payment.jsp">Select Plan</a>
							</footer></li>
					</ul>
				</li>
				<li>
					<ul class="pricing-wrapper">
						<li data-type="monthly" class="is-visible"><header
								class="pricing-header">
								<h2>Large</h2>
								<div class="price">
									<span class="currency">$</span> <span class="value">9.99</span>
									<span class="duration">Year</span>
								</div>
							</header>
							<div class="pricing-body">
								<ul class="pricing-features">
									<li><em>120</em> Database Table Rows</li>
									<li><em>15</em> Email Account Services</li>
									<li><em>10</em> Encryption Algorithm</li>
									<li><em>100</em> Different Products Integration</li>
									<li><em>Unlimited</em> Download PDF Format</li>
									<li><em>24/7</em> Support</li>
								</ul>
							</div> <footer class="pricing-footer">
								<a class="select" href="payment.jsp">Select Plan</a>
							</footer></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<!-- JS Dosyaları -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js'></script>
	<script src="js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<script src="js/scrollIt.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/nice-select.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/gijgo.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>

	<script src="js/main.js"></script>

</body>

</html>