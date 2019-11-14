package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserRegisterDB;
import model.Check;
import model.User;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String submitType =request.getParameter("Submit");
		
		
	switch(submitType) {
		case "Register":
			Check check = new Check(
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("repassword"),
					request.getParameter("phonenumber"),
					request.getParameter("email"),
					request.getParameter("privacypolitic"));
			
				if(check.verify()) {
					
					UserRegisterDB userRegisterDB = new UserRegisterDB();
					
					User user = new User(
							request.getParameter("email"),
							request.getParameter("username"),
							request.getParameter("password"),
							request.getParameter("phonenumber"),
							new SimpleDateFormat("yyyy/MM/dd | HH:mm:ss").format(Calendar.getInstance().getTime()),
							request.getParameter("newsletter"));				
					
					userRegisterDB.insertUser(user);
					
					request.setAttribute("message", "Register is succesfull");
					
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				} else {
					
					request.setAttribute("errorList", check.errorListAll());
					
					request.getRequestDispatcher("/register.jsp").forward(request, response);				
				}
		break;
		
		default:
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
			break;
	}
		
		
		
	}

}
