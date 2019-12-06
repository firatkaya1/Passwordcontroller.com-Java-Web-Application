<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>

<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Password Controller</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

    <!-- CSS BaslangÄ±c TanÄ±mlamalarÄ± -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!--[Internet Explorer 9 Versiyonu KullanÄ±yorsa]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
    <![IE]-->

    <!-- Header Bolum BaslangÄ±cÄ±-->
    <header>
        <div class="header-area ">
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
                                        <li><a class="active" href="index.html">Home </a></li>
                                        <li><a href="#">How Its Work ? </a></li>
                                        <li><a href="#">Manage <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="#">Basic Table</a></li>
                                                <li><a href="#">Email Services</a></li>
                                                <li><a href="#">Social Media Services</a></li>
                                                <li><a href="#">Bank Services</a></li>
                                                <li><a href="#">Telephone Directory</a></li>
                                                <li><a href="#">Date Services</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Profile</a>
                                            <ul class="submenu">
                                                <li><a href="#">User Activities</a></li>
                                                <li><a href="#">User Settings</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Premium</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                            <div class="log_chat_area d-flex align-items-center">
                                <div class="live_chat_btn">
                                    <a class="boxed_btn_orange" href="login.jsp">
                                        <span class="falogins">Login</span>
                                    </a>
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
    <!-- Header Bolum Sonu -->

    <!-- Slider Alan BaslangÄ±cÄ± -->
    <div class="slider_area ">
        <div class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-xl-6 col-md-6">
                        <div class="illastrator_png">
                            <img src="img/banner/mainpic.svg" alt="Main Page Index Picture">
                        </div>
                    </div>
                    <div class="col-xl-6 col-md-6">
                        <div class="slider_info">
                            <h3>Strong Access <br> All The Password<br> Easy Auth</h3>
                            <a href="login.jsp" class="boxed_btn falogins">Let's Do This</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Slider Alan Sonu -->

    <!-- HakkÄ±nda Alan BaslangÄ±cÄ± -->
    <div class="about_area">
        <div class="container">
            <div class="row">
                <div class="col-xl-5 col-lg-6">
                    <div class="single_about_info">
                        <h3>
                            100+ Encryption Algorithms
                            <br> from 15 Services</h3>
                        <p>We are happy to develop a system that will help you protect your password quickly and securely. You can encrypt your passwords as you like. 1000 or more iterations to achieve a sufficiently good security level.</p>
                    </div>
                </div>
                <div class="col-xl-6 offset-xl-1 col-lg-6">
                    <div class="about_tutorials">
                        <div class="courses">
                            <div class="inner_courses">
                                <div class="text_info">
                                    <span>15+</span>
                                    <p style="font-family: sans-serif"> Services</p>
                                </div>
                            </div>
                        </div>
                        <div class="courses-blue">
                            <div class="inner_courses">
                                <div class="text_info">
                                    <span>968+</span>
                                    <p style="font-family: sans-serif"> Iterations</p>
                                </div>

                            </div>
                        </div>
                        <div class="courses-sky">
                            <div class="inner_courses">
                                <div class="text_info">
                                    <span>100+</span>
                                    <p style="font-family: sans-serif"> Algorithms</p>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hakkinda Alan Sonu -->

    <!-- Kurs YorumlarÄ± BaslangÄ±cÄ± -->
    <div class="testimonial_area testimonial_bg_1 overlay">
        <div class="testmonial_active owl-carousel">
            <div class="single_testmoial">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="testmonial_text text-center">
                                <div class="author_img">
                                    <img src="img/testmonial/author_one.png" alt="">
                                </div>
                                <p>
                                    The action page will require different code depending on what exactly you need to do.<br> For example, you might want to implement security measures to check that the mail doesn't look like spam.

                                </p>
                                <span>- Firat Kaya</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_testmoial">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="testmonial_text text-center">
                                <div class="author_img">
                                    <img src="img/testmonial/author_two.png" alt="">
                                </div>
                                <p>
                                    So pack up everyone because we are going back to the original map from 30,000 years ago.<br> Everyone back to Turkey...and we will live in trees. Or wait. Everyone back to the oceans!

                                </p>
                                <span>- Furkan Aydin</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Kurs YorumlarÄ± Sonu -->

    <!-- Kurs PlanlarÄ± BaslangÄ±cÄ± -->
    <div class="our_courses">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title text-center mb-100">
                        <h3>Password Controller</h3>
                        <p>Always use a unique password for each account you create. The danger with reusing passwords is that as soon as one site has a security issue, <br> itâs very easy for hackers to try the same username and password combination on
                            other websites.
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-3 col-md-6 col-lg-6">
                    <div class="single_course text-center">
                        <div class="icon">
                            <i class="">
                                <img src="img/personally.png">
                            </i>
                        </div>
                        <h3>Don’t Use Identifiable</h3>
                        <p>
                            Don’t use any personally identifiable information in your passwords. Names, birthdays, and street addresses may be easy to remember
                        </p>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-6">
                    <div class="single_course text-center">
                        <div class="icon blue">
                            <i class="">
                                <img src="img/hard.png">
                            </i>
                        </div>
                        <h3>Hard To Find</h3>
                        <p>
                            Make sure your passwords are at least 12 characters long and contain, Some people prefer to generate passwords which are 14 or 20 characters in length.
                        </p>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-6">
                    <div class="single_course text-center">
                        <div class="icon">
                            <i class="">
                                <img src="img/secure.png">
                            </i>
                        </div>
                        <h3>Not To Same</h3>
                        <p>
                            Avoid using similar passwords that change only a single word or character. This practice weakens your account security across multiple sites.
                        </p>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-6">
                    <div class="single_course text-center">
                        <div class="icon gradient">
                            <i class="">
                                <img src="img/password.png">
                            </i>
                        </div>
                        <h3>Something You Like</h3>
                        <p>
                            If you are creating a master password that you will need to remember, try using phrases or lyrics from your favorite movie or song.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Kurs PlanlarÄ± Sonu -->

    <!-- Footer BaslangÄ±cÄ± -->
    <footer class="footer footer_bg_1">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-md-6 col-lg-4">
                        <div class="footer_widget">
                            <div class="footer_logo">
                                <a href="#">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Sonu -->

    <!-- JS DosyalarÄ± -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>

    <script src="js/main.js"></script>
</body>

</html>