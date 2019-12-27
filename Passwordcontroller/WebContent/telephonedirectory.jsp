<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>
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
    <title>Password Controller - Basic Table</title>

    <link rel="icon" type="image/png" href="img/favicon.png">
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link href="css/basic-table.css" rel="stylesheet" media="all">
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
                                <a href="index.html">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="index.html">Home </a></li>
                                        <li><a href="#">How Its Work ? </a></li>
                                        <li><a class="active" href="#">Manage <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="basic-table.html">Basic Table</a></li>
                                                <li><a href="email-table.html">Email Services</a></li>
                                                <li><a href="social-table.html">Social Media Services</a></li>
                                                <li><a href="bank-table.html">Bank Services</a></li>
                                                <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Profile</a>
                                            <ul class="submenu">
                                                <li><a href="#">User Activities</a></li>
                                                <li><a href="#">User Settings</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="premium.html">Premium</a></li>
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
                                        <img src="img/icon/avatar.jpg" alt="John Doe">
                                    </div>
                                    <div class="content" style="float: right;margin: 10px">
                                        <a class="js-acc-btn" href="#">Fırat Kaya</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="img/icon/avatar-big.jpg" alt="Fırat Kaya">
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">Fırat Kaya</a>
                                                </h5>
                                                <span class="email">firatkaya@passwordcontroller.com</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="account.html">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="settings.html">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="billing.html">
                                                    <i class="zmdi zmdi-money-box"></i>Billing</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="#">
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
        <div style="max-width: 94%;" class="container">
            <div class="account-content">
                <div class="pop-up" id="pop-up">
                    <div class="contentx">
                        <div class="containerx">
                            <div class="dots">
                                <div class="dot"></div>
                                <div class="dot"></div>
                                <div class="dot"></div>
                            </div>
                            <span id="closex" class="closex">Close</span>
                            <div class="title">
                                <h1>Telephone Service</h1>
                            </div>
                            <div class="subscribe">
                                <h1>* All field can not be blank</h1>
                                <form  action ="telephonedirectory" method = "post">
                                    <input type="number" name="userid" minlength="1" maxlength="10" placeholder="Id" id="userid">
                                    <input type="text" name="type" placeholder="Phone Number Type" id="type">
                                    <input type="text" name="owner" placeholder="Phone Owner Type*" id="owner">
                                    <input type="number" name="phonenumber" placeholder="Phone Number*" id="phonenumber" >
                                    <input type="text" name="description" placeholder="Description" id="description" >
                                    <input type="Submit" name="Submit" id="modalButton" placeholder="Send">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="account-form">
                    <h2 class="form-title">Telephone Service</h2>
                    <div class="form-group">
                        <button id="btn-add" class="btn-add" onclick="openModal()"><span>Add New</span></button>
                        <form action ="telephonedirectory" method = "post">
                        	<input type="Submit" name="Submit" value="REFRESH" id="btn-refresh" class="btn-refresh">
                        </form>
                    </div>
                    <div class="col-lg-9" style="max-width: 100%">
                        <div class="table-responsive table--no-card m-b-40">
                            <table class="table table-borderless table-striped table-earning" id="table">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Phone Number Type</th>
                                    <th>Phone Owner Name</th>
                                    <th>Phone Number</th>
                                    <th>Explanation</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tableTelephoneDirectoryList}" var="TelephoneDirectoryTable">
						       		<tr>
						           	 	<td><c:out value="${TelephoneDirectoryTable.id}"/></td>
						           	 	<td><c:out value="${TelephoneDirectoryTable.phonenumbertype}" /></td>  
						           	 	<td><c:out value="${TelephoneDirectoryTable.phoneownername}" /></td>
						                <td><c:out value="${TelephoneDirectoryTable.phonenumber}" /></td> 
						           	 	<td><c:out value="${TelephoneDirectoryTable.phonexplain}"/></td>
						          	  	<td class="text-right actions-td">
                                        <span title="Edit"><i class="zmdi zmdi-edit actions-edit" id="${TelephoneDirectoryTable.id}"></i></span>
                                        <span title="Delete"><i class="zmdi zmdi-delete actions-delete"></i></span>
                                    	</td> 
						        	</tr>
						    	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="vendor/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<script src="js/vendor/modernizr-3.5.0.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="js/profile-settings.js"></script>
<script src="js/telephonetable.js"></script>

</body>
</html>