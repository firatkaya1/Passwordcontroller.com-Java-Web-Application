<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
		 <link rel="stylesheet" href="login.css">
         <link rel="shortcut icon" href="image/logo.png" >
        
</head>
<body>
        
        <div class="loginlog-background">
        <h1>Register</h1>
        <img src="img/logo.png" alt="loginpictures" >
        <div class ="loginlog-form">
            <form action = "register" method="post">
                <br>
                <c:forEach items="${errorList}" var = "item"><i style="color: red;font-size: 12px;"> ${item} <br/></i></c:forEach>
            	<i style = "color:red;font-size: 12px;">${message3}</i>
       	 
                <br>
                <input type="email" name="email" placeholder="Email adress"><br><br>
                <input type="text" name="username" placeholder="Username"><br><br>
                <input type="password" name="password" placeholder="Password"><br><br>
                <input type="password" name="repassword" placeholder="Re-Password Again"><br><br>
                <input type="tel" name="phonenumber" placeholder="Phone Number"><br><br>
                <input type="checkbox" name="privacypolitic" /><i class="myitalic"> I accept <a href="termofuse">Term Of Use.</a></i> <br><br>
                <input type="checkbox" name="newsletter" value = "true" /><i class="myitalic">I want to receive emails.</i><br><br>
                <span>
                
                <a href=login.jsp class = "btn">Sign in</a> 
                <input type="Submit" name="Submit" value="Register" class = "btn" />
                </span>
            </form>
        </div>
    </div>
        
    
    </body>
</html>