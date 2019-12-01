<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our Memorise</title>
	 <link rel="stylesheet" href="login.css">
     <link rel="shortcut icon" href="img/logo.png" >
</head>
<body>
    <div class="loginlog-background">
        <h1>OUR MEMORİSE</h1>
        <img src="img/logo.png" alt="loginpictures">
        <div class ="loginlog-form">
            <form action="login" method = "post">
                <br>
                <i style = "color:green;font-size: 12px;">${message}</i>
                <i style = "color:red;font-size: 12px;">${message2}</i>
                <br>
                <input type="text" name="email" placeholder="Email adress"><br><br>
                <input type="password" name="password" placeholder="Password"><br>
                <a  href="forgetpassword.jsp" class="forgetpassword">Forget password ? </a>
                <br>
                <span>
             	
             	 <input type="Submit" name="Submit" value="Register" class = "btn" />
               	 <input type="Submit" name="Submit" value="Login" class = "btn" />
                
                </span>
             </form>
             
            
              
        </div>
    </div>
</body>
</html>