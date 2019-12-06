<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Password Controller - Sign Up</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/style-login.css">
</head>
<body>

<div class="main">

    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>
                    <form action = "register" method = "post" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="name" id="name" minlength="3" placeholder="Your Name"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" pattern="[^ @]*@[^ @]*" minlength="4" maxlength="50" placeholder="Your Email"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="pass" placeholder="Password"/>
                        </div>
                        <div class="form-group">
                            <label for="repass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="repassword" id="re_pass" placeholder="Repeat your password"/>
                        </div>
                        <div class="form-group">
                            <label for="phone"><i class="zmdi zmdi-phone"></i></label>
                            <input type="text" name="phonenumber" id="phone" minlength="4" maxlength="11" pattern="^\+?\d{0,11}" placeholder="Phone Number"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#Terms" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-mail" id="agree-mail" class="agree-term" />
                            <label for="agree-mail" class="label-agree-mail"><span><span></span></span>I want to receive emails.</label>
                        </div>
                        <div class="form-group form-button">
                            <input type="Submit" name="Submit" id="signup" class="form-submit" value="Register"/>
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="img/registerpic.svg" alt="sing up image"></figure>
                    <a href="login.jsp" class="signup-image-link">I am already member</a>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>