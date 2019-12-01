package model;

import java.util.Properties;

public class MailModels {
	public  String resetpassword;
	public  String register;
	public  String premium;
	
	Properties property = new Properties();
	
	public MailModels(String email,String username,String password,String browsername,String operatingSystem,String ipadress,String date) {
		resetpassword = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <style>\n" + 
				"        * {\n" + 
				"            margin: 0;\n" + 
				"            padding: 0;\n" + 
				"            box-sizing: border-box;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .container {\n" + 
				"            display: block;\n" + 
				"            position: absolute;\n" + 
				"            width: 500px;\n" + 
				"            height: 500px;\n" + 
				"            top: 0;\n" + 
				"            bottom: 0;\n" + 
				"            left: 0;\n" + 
				"            right: 0;\n" + 
				"            margin: auto;\n" + 
				"            border: 2px solid #20C20E;\n" + 
				"            font-size: 15px;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .container-header {\n" + 
				"            background-color: #000;\n" + 
				"            border: 1px solid #20C20E;\n" + 
				"            height: 15%;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .container-header h2 {\n" + 
				"            color: #fff;\n" + 
				"            display: inline-block;\n" + 
				"            padding: 25px;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .container-header .image {\n" + 
				"            background-image: url(\"https://i.ibb.co/vx39921/logo.png\");\n" + 
				"            background-size: cover;\n" + 
				"            float: right;\n" + 
				"            display: block;\n" + 
				"            width: 75px;\n" + 
				"            height: 75px;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .container-body {\n" + 
				"            background-color: #1a1a1a;\n" + 
				"            padding: 25px;\n" + 
				"            color: #fff;\n" + 
				"            height: 70%;\n" + 
				"            font-size:12px" +
				"        }\n" + 
				"        \n" + 
				"        .container-footer {\n" + 
				"            display: block;\n" + 
				"            color: grey;\n" + 
				"            background-color: rgb(71, 71, 71);\n" + 
				"            padding: 20px;\n" + 
				"            position: absolute;\n" + 
				"            height: 15%;\n" + 
				"            font-size: 12px;\n" + 
				"            text-align: center;\n" + 
				"            border-top: 1px solid #20C20E;\n" + 
				"        }\n" + 
				"        \n" + 
				"        .mybutton {\n" + 
				"            position: absolute;\n" + 
				"            padding: 10px;\n" + 
				"            border: none;\n" + 
				"            display: block;\n" + 
				"            top: 70%;\n" + 
				"            left: 30%;\n" + 
				"            right: 30%;\n" + 
				"            font-size: 15px;\n" + 
				"            background-color: #eee;\n" + 
				"            text-align: center;\n" + 
				"            border: 1px solid #20C20E;\n" + 
				"            color: black;\n" + 
				"            cursor: pointer;\n" + 
				"        }\n" + 
				"    </style>\n" + 
				"\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>\n" + 
				"\n" + 
				"    <div class=\"container\">\n" + 
				"        <div class=\"container-header\">\n" + 
				"            <h2>Forgot Password ?</h2>\n" + 
				"            <div class=\"image\"></div>\n" + 
				"\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"container-body\">\n" + 
				"            <p>Dear "+username+", </p>\n" + 
				"            <p>We received a password reminder request for your account on passwordcontroller.com</p><br>\n" + 
				"            <p>Your new password : "+password+" </p><br>\n" + 
				"            <p>Ip Adress : "+ipadress+" </p>\n" + 
				"            <p>Operating System :"+operatingSystem+" </p>\n" + 
				"            <p>Browser :"+browsername+" </p>\n" + 
				"            <p>Time : "+date+" </p><br>\n" + 
				"            <p><b>passwordcontroll.com</b> Team</p>\n" + 
				"            <a class=\"mybutton\"><b>Login Page</b></a>\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"\n" + 
				"        <div class=\"container-footer\">\n" + 
				"            <p>This message was sent to "+email+" You are receiving this email because you requested it. No automatic follow-ups to this will be sent. </p>\n" + 
				"\n" + 
				"\n" + 
				"        </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		
	}
	
	
	public String getResetpassword() {
		return resetpassword;
	}
	public String getRegister() {
		return register;
	}
	public String getPremium() {
		return premium;
	}
	
	

}
