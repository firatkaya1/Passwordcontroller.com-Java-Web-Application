<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Controller - Reset Passsword</title>
    <link rel="stylesheet" href="css/style-forgot.css" media="screen" type="text/css" />
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <h2 class="active"> Reset Password </h2>

        <div class="fadeIn first">
            <img src="img/forgot.svg" id="icon" alt="Forgot Password" />
        </div>
        <form action="login" method = "post">
            <input type="email" id="login" class="fadeIn second" name="email" pattern="[^ @]*@[^ @]*" minlength="4" maxlength="50" placeholder="Mail Address" required>
            <input type="Submit" name="Submit"  class="fadeIn fourth" value="Reset My Password">
        </form>
    </div>
</div>

</body>

</html>