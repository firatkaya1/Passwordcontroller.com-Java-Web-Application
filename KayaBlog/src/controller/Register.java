package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Check;
import model.User;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRegisterDB uar = new UserRegisterDB();
		String userAdminName = request.getParameter("username");
		String userAdminPassword = request.getParameter("password");
		String userAdminRePassword = request.getParameter("password2");
		String userAdminEmail = request.getParameter("email");
		String userAdminPhone = request.getParameter("phonenumber");
		String userPrivacyPoliticy = request.getParameter("privacypolitic");
		String userAccesSendMail = request.getParameter("newsletter");
		String userAdminCreateDate = new SimpleDateFormat("(yyyy-MM-dd)-(HH:mm:ss)").format(Calendar.getInstance().getTime());
		String submitType =request.getParameter("Submit");
		

		Check check = new Check(userAdminName,userAdminPassword,userAdminRePassword,userAdminPhone,userAdminEmail,userPrivacyPoliticy);
		
		if(submitType.equals("Register")) {
			if(check.controll()) {
				if(uar.verify(userAdminEmail, userAdminName)) {
					User uas = new User(userAdminEmail,userAdminName,userAdminPassword,userAdminPhone,userAdminCreateDate,userAccesSendMail);				
					uar.insertUser(uas);	
				
					request.setAttribute("message", "Register is succesfull");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				} else {
					// uar.verify yanlış ise yap.
					request.setAttribute("message3", "Emaill adress or username has taken.");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}
			} else {
				//check control yanlış ise yap.
				request.setAttribute("errorList", check.errorListAll());
				request.getRequestDispatcher("/register.jsp").forward(request, response);				
			}
		}else {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		
	}

}
