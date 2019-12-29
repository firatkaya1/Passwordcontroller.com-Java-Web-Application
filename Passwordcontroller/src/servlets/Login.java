package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginAuthentication;
import database.UpdateDB;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("Submit"); 
		
		LoginAuthentication loginAuthentication = new LoginAuthentication(request.getParameter("email"), request.getParameter("password"), request.getHeader("User-Agent"));
		
		switch(type) {
		case "Log in":
			if(loginAuthentication.verify()) {
				HttpSession session = request.getSession(true);	
				
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("password", request.getParameter("password"));
				
				
				request.getRequestDispatcher("/home.jsp").forward(request, response);
				
			}  else {
				request.setAttribute("invalid","Email address or password invalid.");
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
		case "Reset My Password":
			System.out.println("BUTONA tıklandi.");
			String yenisifre = "a12345678";
			UpdateDB update = new UpdateDB();
			System.out.println("email adresi:"+request.getParameter("email"));
			update.updatePassword(request.getParameter("email"), yenisifre,request.getHeader("User-Agent"));
			
			response.sendRedirect(request.getContextPath()+"/forgetpasswordsend.jsp");
			break;
		default:
			break;
		}
		
		
		
		
	}
}
