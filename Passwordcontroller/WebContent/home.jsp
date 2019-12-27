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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Profile">
    <meta name="author" content="Furkan AYDIN">
    <title>Password Controller- Profile</title>

    <link rel="icon" type="image/png" href="img/logo.png">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
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

<body class="animsition">
    <div class="page-wrapper">
        <div class="page-container">
            <header>
                <div class="header-area ">
                    <div id="sticky-header" class="main-header-area">
                        <div class="container-fluid p-0">
                            <div class="row align-items-center no-gutters">
                                <div class="col-xl-2 col-lg-2">
                                    <div class="logo-img">
                                        <a href="index.jsp">
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
                                                              <img src="img/icon/avatar.jpg" alt="Fırat Kaya" />
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
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="overview-wrap">
                                    <h2 class="title-1">Overview</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row m-t-25">
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c1">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-shield-security"></i>
                                            </div>
                                            <div class="text">
                                                <h2>18</h2>
                                                <span>Password Encrypted</span>
                                            </div>
                                        </div>
                                        <div class="overview-chart">
                                            <canvas id="widgetChart1"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c2">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-tab"></i>
                                            </div>
                                            <div class="text">
                                                <h2>28</h2>
                                                <span>Table Used</span>
                                            </div>
                                        </div>
                                        <div class="overview-chart">
                                            <canvas id="widgetChart2"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c3">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-smartphone-setup"></i>
                                            </div>
                                            <div class="text">
                                                <h2>16</h2>
                                                <span>Services Used</span>
                                            </div>
                                        </div>
                                        <div class="overview-chart">
                                            <canvas id="widgetChart3"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c4">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-email"></i>
                                            </div>
                                            <div class="text">
                                                <h2>186</h2>
                                                <span>Mail Sent</span>
                                            </div>
                                        </div>
                                        <div class="overview-chart">
                                            <canvas id="widgetChart4"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-9">
                                <h2 class="title-1 m-b-25">Encrypted User Information</h2>
                                <div class="table-responsive table--no-card m-b-40">
                                <form action ="mainpage" method = "post" >
                                <input type="submit" value="REFRESH" name="submit" class="butons">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                <th>date</th>
                                                <th>ID</th>
                                                <th>Browser</th>
                                                <th>Explanation</th>
                                                <th>Service</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                           <c:forEach items="${userLogsList}" var="UserLogs">
									       	<tr>
									       		<td><c:out value="${UserLogs.userLogDate}"/></td>
									           	<td><c:out value="${UserLogs.id}"/></td>
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
                            <div class="col-lg-3">
                                <h2 class="title-1 m-b-25">OS Information</h2>
                                <div class="au-card au-card--bg-blue au-card-top-countries m-b-40">
                                    <div class="au-card-inner">
                                        <div class="table-responsive">
                                            <table class="table table-top-countries">
                                                <tbody>
                                                	 <c:forEach items="${userLogsList}" var="UserLogs">
												       	<tr>
												       		<td><c:out value="${UserLogs.userOs}"/></td>
												       		<td><c:out value="${UserLogs.userIpAdress}"/></td>
												       	</tr>
							    					</c:forEach>                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div style="flex: 0 0 100%; max-width: 100%" class="col-lg-6">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                    <div class="au-card-title" style="background-image:url('img/bgtime.png');background-size: cover;">
                                        <div class="bg-overlay"></div>
                                        <h3>
                                            <i class="zmdi zmdi-account-calendar"></i>December 11, 2019</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
</body>

</html>