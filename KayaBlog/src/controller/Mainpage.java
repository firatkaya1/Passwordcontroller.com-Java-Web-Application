package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mainpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String submitType =request.getParameter("Submit");
		if(submitType.equals("Edit")) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		out.close();
		
		
		
		
		
	}

}
