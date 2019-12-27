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
    <title>Home</title>
    <link rel="stylesheet" href="mainpage.css">
    <link rel="shortcut icon" href="img/logo.png">
    <script src="https://use.fontawesome.com/e54f0b343c.js"></script>

</head>

<body>
<div class="topmenu">
        <ul>
            <li><a href="howitsworks.jsp" >How Its Work ?</a></li>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="mainpage.jsp" id="here">Manage</a>
                <ul class="dropdown">
                    <li><a href="basictable.jsp">Basic Table</a></li>
                    <li><a href="emailservices.jsp">Email Services</a></li>
                    <li><a href="socialmediaservices.jsp">Social Media Services</a></li>
                    <li><a href="bankservices.jsp">Bank Services</a></li>
                    <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
                </ul>
            </li>
            <li><a>Profile</a>
                <ul class="dropdown">
                    <li><a href="useractivities.jsp">User Activities</a></li>
                    <li><a href="useractivities.jsp">User Settings</a></li>
                </ul>
            </li>
            <li><a href="premium.jsp">Premium<div class="premiumicon"></div></a></li>
            <li id="exit"><a href="login.jsp">Exit</a></li>
        </ul>
    </div>
    
   
    
</body>

</html>