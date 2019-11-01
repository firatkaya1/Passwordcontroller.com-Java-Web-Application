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
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB uld = new UserLoginDB();
		String type = request.getParameter("Submit");
		String values = request.getParameter("valueofid");
		HttpSession session = request.getSession();
		ArrayList<BasicTable> tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());
	
		
		if(type.equals("REFRESH")) {
			tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
		}
		if(type.equals("DELETE")) {
		
			int id = tableBasicList.get(Integer.valueOf(values)-1).getIdentifyofDB();
			uld.deleteBasicTable(id);
			tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
		}
	
		if(type.equals("SAVE")) {
			String typeEmail = request.getParameter("typeEmail");
			String ShowEmail = request.getParameter("email");
			String ShowUsername = request.getParameter("username");
			String ShowPassword = request.getParameter("password");
			String typeEncrypt = request.getParameter("typeofmyencrypt");
			String explanations = request.getParameter("explanations");
			int id=tableBasicList.get(tableBasicList.size()-1).getUserid();
			id = id + 1;
			if(!typeEmail.isEmpty() && !ShowEmail.isEmpty() && !ShowUsername.isEmpty()  && !ShowPassword.isEmpty()) 
			{
			BasicTable bt = new BasicTable(id,session.getAttribute("username").toString(),session.getAttribute("email").toString(),typeEmail,ShowEmail,ShowUsername,ShowPassword,explanations,typeEncrypt);
			uld.insertBasicTable(session.getAttribute("username").toString(),session.getAttribute("email").toString(), bt);
			tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			} else {
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			}
			
		} 
		
		
	}

}
