<%@page import="com.mysql.jdbc.PreparedStatement.ParseInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="tr">
	<%
	String email="";
	String name="";
	if(null == session.getAttribute("email")) {
		response.sendRedirect(request.getContextPath()+"/error.jsp");
	} else {
		 email = session.getAttribute("email").toString();
		 name = email.substring(0,email.indexOf("@"));
	}
		
	%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Password Controller - Account</title>

    <link rel="icon" type="image/png" href="img/favicon.png">
    <link href="css/style-account.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="css/style-profile.css" rel="stylesheet" media="all">
    <link href="css/slicknav.css" rel="stylesheet" media="all">
</head>
<body>

<div class="main">
    <header>
        <div class="header-area">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid p-0">
                    <div class="row align-items-center no-gutters">
                        <div class="col-xl-2 col-lg-2">
                            <div class="logo-img">
                                <a href="index.jsp">
                                    <img src="img/logo.png" alt="logo">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="home.jsp">Home </a></li>
                                        <li><a href="howitsworks.jsp">How Its Work ? </a></li>
                                        <li><a href="manage.jsp">Manage <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="basictable.jsp">Basic Table</a></li>
                                                <li><a href="emailservices.jsp">Email Services</a></li>
                                                <li><a href="socialmediaservices.jsp">Social Media Services</a></li>
                                                <li><a href="bankservices.jsp">Bank Services</a></li>
                                                <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
                                                <li><a href="#">Date Services</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="premium.jsp">Premium</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                            <div class="log_chat_area d-flex align-items-center" style="justify-content: flex-end">
                                <div class="noti-wrap">
                                    <div class="noti__item js-item-menu">
                                        <i class="zmdi zmdi-notifications"></i>
                                        <span class="quantity">2</span>
                                        <div class="notifi-dropdown js-dropdown">
                                            <div class="notifi__title">
                                                <p>You have 2 Notifications</p>
                                            </div>
                                            <div class="notifi__item">
                                                <div class="bg-c1 img-cir img-40">
                                                    <i class="zmdi zmdi-email-open"></i>
                                                </div>
                                                <div class="content">
                                                    <p>You got a email notification</p>
                                                    <span class="date">April 12, 2018 06:50</span>
                                                </div>
                                            </div>
                                            <div class="notifi__item">
                                                <div class="bg-c2 img-cir img-40">
                                                    <i class="zmdi zmdi-account-box-mail"></i>
                                                </div>
                                                <div class="content">
                                                    <p>Your account has been blocked</p>
                                                    <span class="date">April 12, 2018 06:50</span>
                                                </div>
                                            </div>
                                            <div class="notifi__footer">
                                                <a href="#">All notifications</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="img/icon/avatar.jpg" alt="John Doe" />
                                    </div>
                                    <div class="content" style="float: right;margin: 10px">
                                        <a class="js-acc-btn" href="account.jsp"><c:out value="${email}" /></a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="account.jsp">
                                                    <img src="img/icon/avatar.jpg" alt="Fırat Kaya" />
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="account.jsp"><%=name %></a>
                                                </h5>
                                                                                           
                                                <span class="email"><c:out value="${email}" /></span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="account.jsp">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="settings.jsp">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="billing.jsp">
                                                    <i class="zmdi zmdi-money-box"></i>Billing</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="logout.jsp">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
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

    <section class="account">
        <div class="container">
            <div class="account-content">
                <div class="account-form">
                    <h2 class="form-title">Account</h2>
                    <form method="POST" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="name" id="name" minlength="3" placeholder="Name" value="<%=name%>"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" minlength="4" maxlength="50" placeholder="Email Address" value="<%=email%>"/>                                 
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="reemail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" minlength="4" maxlength="50" placeholder="Confirm Email Address"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password" value="1234567890"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="repass" placeholder="Repeat Password"/>
                        </div>
                        <div class="form-group">
                            <label for="phone"><i class="zmdi zmdi-phone"></i></label>
                            <input type="text" name="phone" id="phone" minlength="4" maxlength="11" pattern="^\+?\d{0,11}" placeholder="Phone Number"/>
                        </div>

                    </form>
                </div>
                <div class="account-image">

                    <div class="containerImage">
                        <h1 style="font-size: 20px;float: right;margin-top: 50px;">Profile Image</h1>
                        <div class="avatar-upload">
                            <div class="avatar-edit">
                                <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg" />
                                <label for="imageUpload"></label>
                            </div>
                            <div class="avatar-preview">
                                <div id="imagePreview" style="background-image: url(./img/logo.png);">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class='pricing animated swing'>
                        <div class='thumbnail animated pulse infinite'>
                            <div class='fa fa-money'></div>
                        </div>
                        <div class='title'>Show Purchased</div>
                        <div class='content'>
                            <div class='sub-title'>$9.99 Per Year</div>
                            <ul>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>120 Database Table Rows</li>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>15 Email Account Services</li>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>10 Encryption Algorithm</li>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>100 Different Products Integration</li>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>Unlimited Download PDF Format</li>
                                <li><div class='fa fa-check-square' style="color: #00D363;"></div>24/7 Support</li>
                            </ul>
                            <a href='premium.jsp'>Change Plan</a>
                        </div>
                    </div>


                    <div class="form-group form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" style="float: right;" value="Register"/>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="vendor/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<script src="vendor/slick/slick.min.js"></script>
<script src="vendor/wow/wow.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="vendor/counter-up/jquery.counterup.min.js"></script>
<script src="vendor/circle-progress/circle-progress.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="vendor/chartjs/Chart.bundle.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="js/profile-main.js"></script>
<script src="js/profile-image.js"></script>
<script src="js/profile-repeat-control.js"></script>
</body>
</html>