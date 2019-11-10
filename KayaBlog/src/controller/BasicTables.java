package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DeleteDB;
import database.UpdateDB;
import database.İnsertDB;
import model.BasicTable;


public class BasicTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB uld = new UserLoginDB();
		İnsertDB insert = new İnsertDB();
		DeleteDB delete = new DeleteDB();
		UpdateDB update = new UpdateDB();
		
		HttpSession session = request.getSession();
		String type = request.getParameter("Submit");
		String values = request.getParameter("valueofid");
		String username= session.getAttribute("username").toString();
		String email = session.getAttribute("email").toString();
		
		ArrayList<BasicTable> tableBasicList = uld.getTable(username, email);
		
		switch(type) {
		case "REFRESH":
			tableBasicList = uld.getTable(username, email);
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			break;
			
		case "SAVE":
			String typeEmail = request.getParameter("typeEmail");
			String ShowEmail = request.getParameter("email");
			String ShowUsername = request.getParameter("username");
			String ShowPassword = request.getParameter("password");
			String typeEncrypt = request.getParameter("typeofmyencrypt");
			String explanations = request.getParameter("explanations");
			
			
			if(!typeEmail.isEmpty() && !ShowEmail.isEmpty() && !ShowUsername.isEmpty()  && !ShowPassword.isEmpty()) 
			{
				BasicTable bt = new BasicTable(username,email,typeEmail,ShowEmail,ShowUsername,ShowPassword,explanations,typeEncrypt);
			
				insert.insertToBasicTable(username,email, bt);
			
				tableBasicList = uld.getTable(username, email);
			
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			} else {
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			}
			
			break;
			
		case "UPDATE":
			int identifyofDB = tableBasicList.get(Integer.valueOf(request.getParameter("userid1"))-1).getIdentifyofDB();
			int id = Integer.valueOf(request.getParameter("userid1"));
			typeEmail = request.getParameter("emailType1");
			ShowEmail = request.getParameter("emailAdress1");
			ShowUsername = request.getParameter("username1");
			ShowPassword = request.getParameter("password1");
			typeEncrypt = request.getParameter("typeofmyencrypt1");
			explanations = request.getParameter("explanations1");
			
			BasicTable bt = new BasicTable(identifyofDB,id,username,email,typeEmail,ShowEmail,ShowUsername,ShowPassword,explanations,typeEncrypt);
			// update database
			update.updateToBasicTable(username,email, bt);
			// refresh BasicTable values
			tableBasicList = uld.getTable(username, email);
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			id = tableBasicList.get(Integer.valueOf(values)-1).getIdentifyofDB();
			delete.deleteFromBasicTable(id);
			tableBasicList = uld.getTable(username, email);
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			break;
			
		default:
			System.out.println("Unexpected Error.");
			break;
		}
		
	}

}
