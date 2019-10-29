package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BasicTable;


public class BasicTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB uld = new UserLoginDB();
		
		String type = request.getParameter("submit");
		HttpSession session = request.getSession();
		ArrayList<BasicTable> tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());


		if(type.equals("REFRESH")) {
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
		}
		else if(type.equals("exit")) {
			response.sendRedirect("login.jsp");
		}
		else if(type.equals("save")) {
			response.sendRedirect("login.jsp");
			
		}
		else {
			System.out.println("hata");
		}
	
		
	}

}
