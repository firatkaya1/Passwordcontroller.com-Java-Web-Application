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
    <title>Password Controller - Billing</title>

    <link rel="icon" type="image/png" href="img/favicon.png">
    <link href="css/style-billing.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="css/style-profile.css" rel="stylesheet" media="all">
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
                                <a href="home.jsp">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a class="active" href="home.jsp">Home </a></li>
                                        <li><a href="howitsworks.jsp">How Its Work ? </a></li>
                                        <li><a href="mainpage.jsp">Manage <i class="ti-angle-down"></i></a>
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
                                                    <img src="img/icon/avatar-big.jpg" alt="" />
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="account.jsp"><%=name%></a>
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
                                            <a href="index.jsp">
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
                <div class="account-image">
                    <h2 class="form-title">Billing</h2>
                    <div class="col-lg-9" style="max-width: 100%">
                        <div class="table-responsive table--no-card m-b-40">
                            <table class="table table-borderless table-striped table-earning">
                                <thead>
                                <tr>
                                    <th>Payment Date</th>
                                    <th>Card Number</th>
                                    <th class="text-right">Package Type</th>
                                    <th class="text-right">Price</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="text-left">2019-11-29 16:27</td>
                                    <td class="text-left">1234-5678-9101-1121</td>
                                    <td class="text-right">Medium</td>
                                    <td class="text-right">$ 5.99</td>
                                </tr>
                                <tr>
                                    <td class="text-left">2019-12-16 13:42</td>
                                    <td class="text-left">4016-4586-1594-4835</td>
                                    <td class="text-right">Large</td>
                                    <td class="text-right">$ 9.99</td>
                                </tr>
                                <tr>
                                    <td>2019-12-18 12:32</td>
                                    <td>1111-1111-2222-3333</td>
                                    <td class="text-right">Small</td>
                                    <td class="text-right">$ 2.99</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="form-container">
                        <div id="card-front">
                            <div id="image-container">
                                <span id="amount">Paying: <strong>$9.99</strong></span>
                                <span id="card-image"></span>
                            </div>
                            <label for="card-number">
                                Card Number
                            </label>
                            <input type="text" id="card-number" style="font-size: 12px;" value="1234 5678 9101 1112" length="16" readonly="readonly">
                            <div id="cardholder-container">
                                <label for="card-holder">Card Holder
                                </label>
                                <input type="text" id="card-holder" style="font-size: 12px;" value="Fırat KAYA" readonly="readonly" />
                            </div>
                            <div id="exp-container">
                                <label for="card-exp">
                                    Expiration
                                </label>
                                <input id="card-month" type="text" style="font-size: 12px;" value="12" length="2" readonly="readonly">
                                <input id="card-year" type="text" style="font-size: 12px;" value="22" length="2" readonly="readonly">
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" style="float: right;height: auto;" value="View All"/>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="vendor/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="vendor/circle-progress/circle-progress.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="js/profile-main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<script src="js/profile-billing.js"></script>
</body>
</html>
