<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Premium</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/premium.png">
    <link rel="stylesheet" href="mainpage.css">
    <link rel="stylesheet" href="premium.css">
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/e54f0b343c.js"></script>


</head>

<body>
<div class="topmenu">
        <ul>
            <li><a href="howitsworks.jsp" >How Its Work ?</a></li>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="mainpage.jsp">Manage</a>
                <ul class="dropdown">
                    <li><a href="basictable.jsp">Basic Table</a></li>
                    <li><a href="emailservices.jsp">Email Services</a></li>
                    <li><a href="socialmediaservices.jsp">Social Media Services</a></li>
                    <li><a href="bankservices.jsp" id="here">Bank Services</a></li>
                    <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
                </ul>
            </li>
            <li><a>Profile</a>
                <ul class="dropdown">
                    <li><a href="useractivities.jsp">User Activities</a></li>
                    <li><a href="useractivities.jsp">User Settings</a></li>
                </ul>
            </li>
            <li><a href="premium.html" id="here">Premium<div class="premiumicon"></div></a></li>
            <li id="exit"><a href="login.jsp">Exit</a></li>
        </ul>
    </div>

    <div class="container">

        <div class="columns">
            <ul class="price">
                <li class="header">Small</li>
                <li class="headerdown">$ 2.99/YEAR</li>
                <li>+20 Basic Table Rows</li>
                <li>+20 Email Services Table Rows</li>
                <li>+20 Social Media Table Rows</li>
                <li>+20 Bank Service Table Rows</li>
                <li>+20 Telephone Directory Table Rows</li>
                <li class="headerdown"><button class="buybutton">BUY</button></li>
            </ul>
        </div>
        <div class="columns">
            <ul class="price">
                <li class="header">Medium</li>
                <li class="headerdown">$ 5.99/YEAR</li>
                <li>+50 Basic Table Rows</li>
                <li>+50 Email Services Table Rows</li>
                <li>+50 Social Media Table Rows</li>
                <li>+50 Bank Service Table Rows</li>
                <li>+50 Telephone Directory Table Rows</li>
                <li class="headerdown"><button class="buybutton" id="buythis">BUY</button></li>
            </ul>
        </div>
        <div class="columns">
            <ul class="price">
                <li class="header">PRO</li>
                <li class="headerdown">$ 9.99/YEAR</li>
                <li>+120 Basic Table Rows</li>
                <li>+120 Email Services Table Rows</li>
                <li>+120 Social Media Table Rows</li>
                <li>+120 Bank Service Table Rows</li>
                <li>+120 Telephone Directory Table Rows</li>
                <li class="headerdown"><button class="buybutton">BUY</button></li>
            </ul>
        </div>


    </div>




</body>

</html>