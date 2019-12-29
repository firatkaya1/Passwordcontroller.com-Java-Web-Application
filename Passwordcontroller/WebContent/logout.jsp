<%@page import="model.UserLogs"%>
<%@page import="database.InsertDB"%>
<%@page import="model.BrowserInformations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">
	<%
	String email="";
	String name="";
	if(null != session.getAttribute("email")) {
		response.sendRedirect(request.getContextPath()+"/logout.jsp");
		UserLogs ul;
		InsertDB insert = new InsertDB();
		BrowserInformations browser = new BrowserInformations(request.getHeader("User-Agent"));
		ul = new UserLogs(
				session.getAttribute("email").toString(),
				"LOGOUT",
				browser,
				"LOGOUT");
		insert.insertLog(ul);
		
		session.setAttribute("email", null);
	}
	
	
	
	%>


<head>
    <title>Password Controller Say Goodbye To You</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="img/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style-logout.css">

</head>
<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
<div class="site-wrap">
    <div class="site-blocks-cover">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12" style="position: relative;" data-aos="fade-up">
                    <img src="img/logout.png" alt="Logout Image" style="max-width: 60% !important;" class="img-fluid img-absolute">
                    <div class="row mb-4">
                        <div class="col-lg-4 mr-auto">
                            <h1>You Have Been Logged Out</h1>
                            <p class="mb-5">Thank you for using our website.</p>
                            <div>
                                <a href="login.jsp" class="btn btn-primary mr-2 mb-2">Please click here to login back to our site</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer py-5 border-top text-center">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <p class="mb-0">
                        <a>Copyright &copy;2019 | All rights reserved</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>