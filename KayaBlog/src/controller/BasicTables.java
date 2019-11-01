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
		//String type2 = request.getParameter("Submit2");
		HttpSession session = request.getSession();
		ArrayList<BasicTable> tableBasicList = uld.getTable(session.getAttribute("username").toString(), session.getAttribute("email").toString());
	
		
		if(type.equals("REFRESH")) {
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
		}
		if(type.equals("EDIT")) {
		/*	String typeEmail = tableBasicList.get(Integer.parseInt(type2)).getUserShowtype();
			String userShowemail = tableBasicList.get(Integer.parseInt(type2)).getUserShowEmail();
			String userShowusername = tableBasicList.get(Integer.parseInt(type2)).getUserShowUsername();
			String userShowpassword = tableBasicList.get(Integer.parseInt(type2)).getUserShowpassword();
			String explanations = tableBasicList.get(Integer.parseInt(type2)).getUserShowExplanation();
		*/
		}
	
		if(type.equals("SAVE")) {
			String typeEmail = request.getParameter("typeEmail");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String explanations = request.getParameter("explanations");
			int id=tableBasicList.get(tableBasicList.size()-1).getUserid();
			id=id+1;
			if(!typeEmail.isEmpty() && !email.isEmpty() && !username.isEmpty()  && !password.isEmpty()) 
			{
			BasicTable bt = new BasicTable(id,session.getAttribute("username").toString(),session.getAttribute("email").toString(),typeEmail,email,username,password,explanations);
			uld.insertBasicTable(session.getAttribute("username").toString(),session.getAttribute("email").toString(), bt);
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			} else {
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			}
			
		} 
		
		
	}

}
