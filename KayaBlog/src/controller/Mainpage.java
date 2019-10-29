package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mainpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Mainpage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submitType =request.getParameter("Submit");
		
		if(submitType.equals("exit")) {
			response.sendRedirect("login.jsp");
			
		}
		
	}

}
