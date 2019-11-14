package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserLoginDB;
import database.DeleteDB;
import database.UpdateDB;
import database.İnsertDB;
import model.BasicTable;


public class BasicTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB uld = new UserLoginDB();
		
		
		
		
		HttpSession session = request.getSession();
		String type = request.getParameter("Submit");
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
			
			İnsertDB insert = new İnsertDB();	
			
			BasicTable bt = new BasicTable(
				session.getAttribute("username").toString(),
				session.getAttribute("email").toString(),
				request.getParameter("typeEmail"),
				request.getParameter("email"),
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("explanations"),
				request.getParameter("typeofmyencrypt"));
			
				insert.insertToBasicTable(bt);
			
				tableBasicList = uld.getTable(bt.getUsername(), bt.getUseremail());
			
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			 
			
			break;
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			BasicTable basicTable = new BasicTable(
					tableBasicList.get(Integer.valueOf(request.getParameter("userid1"))-1).getIdentifyofDB(),   		//identifyofDb
					Integer.valueOf(request.getParameter("userid1")),										    		//id
					session.getAttribute("username").toString(),											    		//username 		
					session.getAttribute("email").toString(),												    		//email 	 
					request.getParameter("emailType1"),														    		//emailtype	
					request.getParameter("emailAdress1"),																//email on table
					request.getParameter("username1"),																	//username on table
					request.getParameter("password1"),																	//password on table
					request.getParameter("explanations1"),																//explain on table
					request.getParameter("typeofmyencrypt1"));															//encrypt type
			
			
			update.updateToBasicTable(basicTable);																		//update database
			
			tableBasicList = uld.getTable(basicTable.getUsername(),basicTable.getUseremail());							//refresh BasicTable values
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromBasicTable(tableBasicList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB());
			
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
