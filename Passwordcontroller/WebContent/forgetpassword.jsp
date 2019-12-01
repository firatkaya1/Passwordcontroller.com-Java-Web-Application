<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Our Memorise</title>
    <link rel="stylesheet" href="forgetpassword.css">
    <link rel="shortcut icon" href="img/logo.png">
</head>

<body>
    <div class="loginlog-background">
        <h2>Forget Password ?</h2>
        <img src="img/logo.png" alt="loginpictures">
        <div class="loginlog-form">
            
                <p>Please fill in the field below. </p><br>
                <form action="login" method = "post">
                <input type="email" name="email" placeholder="Email adress"><br><br>
                <span>
                	<a href="forgetpasswordsend.jsp">
                	<input type="Submit"  name="Submit" value="Next" class="btn">
                	</a>
                </span>
                </form>
            



        </div>
    </div>
</body>

</html>