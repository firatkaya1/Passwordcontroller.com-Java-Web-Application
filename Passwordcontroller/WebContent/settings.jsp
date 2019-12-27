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
    <title>Password Controller - Settings</title>

    <link rel="icon" type="image/png" href="img/favicon.png">
    <link href="css/style-settings.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
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
                                                    <img src="img/icon/avatar.jpg" alt="" />
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
        <div style="max-width: 80%;" class="container">
            <div class="account-content">
                <div class="account-form">
                    <h2 class="form-title">Settings</h2>
                    <div class="form-group">
                        <ul class="tg-list">
                            <li class="tg-list-item">
                                <input class="tgl tgl-flip" id="cb5" type="checkbox"/>
                                <label class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah!" for="cb5"></label>
                            </li>
                            <label class="label-agree-mail" style="margin-bottom: 20px;margin-left: 10px;"><span><span></span></span>I want to receive emails.</label>
                        </ul>
                    </div>
                    <div class="col-lg-9" style="max-width: 100%">
                        <div class="table-responsive table--no-card m-b-40">
                        	<form action = "settings" method = "post" >
	                            <table class="table table-borderless table-striped table-earning">    	
	                            	<input type="Submit" name="Submit" value="REFRESH"/>
	                                <thead>
	                                <tr>
	                                    <th><input id="box" type="checkbox" onclick="return false;" /><label for="box" style="color: #ffffff;"></label></th>
	                                    <th>Date</th>
	                                    <th>Browser</th>
	                                    <th>Explanation</th>
	                                    <th>Service</th>
	                                </tr>
	                                </thead>
	                                <tbody>
		                                <c:forEach items="${userLogsList}" var="UserLogs">
										       	<tr>
										       		<td><input id="box3" type="checkbox" /><label for="box3"></label></td>
										       		<td><c:out value="${UserLogs.userLogDate}"/></td>
										           	<td><c:out value="${UserLogs.userBrowser}"/></td> 
										           	<td><c:out value="${UserLogs.userlogtype}"/></td>  
										           	<td>SERVİCE</td>
										       	</tr>
							    		</c:forEach>
	                                </tbody>
	                            </table>
	                    	</form>        
                        </div>
                    </div>
                    <div class="form-group form-button">
                        <input type="submit" name="save" id="save" class="form-submit" style="float: right;" value="Save"/>
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
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="js/profile-settings.js"></script>

</body>
</html>