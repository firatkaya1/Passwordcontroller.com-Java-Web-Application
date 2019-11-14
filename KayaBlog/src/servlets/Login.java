package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginAuthentication;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("Submit"); 
		
		LoginAuthentication loginAuthentication = new LoginAuthentication(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"),type, request.getHeader("User-Agent"));
		
		switch(type) {
		case "Login":
			
			if(loginAuthentication.verify()) {
				
				HttpSession session = request.getSession(true);	
				
				session.setAttribute("username", request.getParameter("username"));
				session.setAttribute("email", request.getParameter("email"));
				
				request.getRequestDispatcher("/mainpage.jsp").forward(request, response);
				
			}  else {
				
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			type =null;
			
			break;
			
		case "Register":
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
			type =null;
			
			break;
			
		case "Git":
			
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			
			type =null;
			
			break;

		default:
			break;
		}
		
		
		
		
	}
}