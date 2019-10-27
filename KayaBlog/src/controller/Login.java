package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDB userAdminLoginDB = new UserLoginDB();
		String userAdminName = request.getParameter("username");
		String userAdminPassword = request.getParameter("password");
		String userAdminEmail = request.getParameter("email");
		String submitType =request.getParameter("Submit"); 
		String useragent = request.getHeader("User-Agent");	
			
			if(submitType.equals("Login")) {
				if(userAdminName!="" && userAdminName!=null) {
					if(userAdminLoginDB.verify(userAdminName, userAdminPassword,userAdminEmail,"Login",useragent)) {
						HttpSession session = request.getSession(true);		
						session.setAttribute("username", request.getParameter("username"));
						session.setAttribute("email", request.getParameter("email"));
						request.getRequestDispatcher("/mainpage.jsp").forward(request, response);
					}else {
						request.setAttribute("message2", "Email or username  is incorrect.");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("message2", "Email or username or can not be blank.");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}

			}else if(submitType.equals("Register")){
				//request.getRequestDispatcher("/register.jsp").forward(request, response);
		        String  browserDetails  =   request.getHeader("User-Agent");
		        System.out.println("Bu:	"+browserDetails);
				
			} else if(submitType.equals("Git")){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		
		
		
		
		
		
		
	}
}
