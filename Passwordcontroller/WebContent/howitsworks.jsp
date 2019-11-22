<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <title>How Its Work ?</title>
    <link rel="stylesheet" href="mainpage.css">
    <link rel="stylesheet" href="howitsworks.css">
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/e54f0b343c.js"></script>


</head>

<body>
    <div class="topmenu">
        <ul>
            <li><a href="howitsworks.html" id="here">How Its Work ?</a></li>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="mainpage.jsp">Manage</a>
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
            <li><a>Premium</a></li>
            <li id="exit"><a href="login.jsp">Exit</a></li>
        </ul>
    </div>

    <div class="container">
        <div class="header"><br><br><br><br>
            <h2>save your informations in passwordcontroller.com</h2><br><br>
            <h3>ONLY 5 STEP !</h3><br>
        </div>
        <div class="steps">
            <div class="eachstep">

                <h4>Step 1</h4>

                <p>Choice A Table</p><br><br>
                <p>There are a lot of table types but if you dont have idea which table better your choice, you can choice basic table easily.</p>
                <img src="img/step1.png">
            </div>
            <div class="eachstep">

                <h4>Step 2</h4>

                <p>Add Your Informations to Basic Table</p><br><br>
                <p>Click Add Button</p>
                <img src="img/step2.png">
            </div>
            <div class="eachstep">

                <h4>Step 3</h4>

                <p>Please fill in the blanks.</p><br>
                <p>1 --> You can't write here.</p><br>
                <p>2 --> Write your type, it can be blank.</p><br>
                <p>3 --> Write any email adress.</p><br>
                <p>4 --> Write any username</p><br>
                <p>5 --> Write any password</p><br>
                <p>6 --> Choose your encrypt algorithm. </p><br>
                <p>Remember, İf you are choose no-encrypt algorithm, you cant see your individual password.</p><br>
                <p>Also you can see which types are can't see on <a href="#">details</a> page.</p><br>
                <img src="img/step3.png">
            </div>
            <div class="eachstep">

                <h4>Step 4</h4>

                <p>Click Refresh button.</p><br><br>
                <img src="img/step4.png">
                <p>İf you want to learn other things you can <a href="#">download</a> pdf. </p><br><br>
                <p>Also you can see all code. Visit my github profile <a href="#">link.</a></p>
                <p>Do you have an idea or bug or wondering something ? You can send me mail. <a href="#">See my email adress.</a></p>
            </div>
        </div>

    </div>



</body>

</html>