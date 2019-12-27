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
import database.InsertDB;
import model.BasicTable;


public class BasicTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		BasicTable basicTable;
		
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<BasicTable> tableBasicList = userLoginDB.getTable(session.getAttribute("email").toString());
		
		switch(type) {
		
		case "REFRESH":
			
			tableBasicList = userLoginDB.getTable(session.getAttribute("email").toString());
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		case "SAVE":
			
			InsertDB insert = new InsertDB();	
			
			basicTable = new BasicTable(
				session.getAttribute("email").toString(),
				request.getParameter("type"),
				request.getParameter("emailadress"),
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("description"),
					"none");		//request.getParameter("typeofmyencrypt1")
			
				insert.insertToBasicTable(basicTable);
			
				tableBasicList = userLoginDB.getTable(basicTable.getUseremail());
			
				request.setAttribute("tableBasicList",tableBasicList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			 
			break;
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			basicTable = new BasicTable(
					tableBasicList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB(),		
					Integer.valueOf(request.getParameter("userid")),
					session.getAttribute("email").toString(),			 
					request.getParameter("type"),		
					request.getParameter("emailadress"),		
					request.getParameter("username"),		
					request.getParameter("password"),		
					request.getParameter("description"),		
					"none");		//request.getParameter("typeofmyencrypt1")
			
			
			update.updateToBasicTable(basicTable);		//update database
			
			tableBasicList = userLoginDB.getTable(basicTable.getUseremail());		
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromBasicTable(tableBasicList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB());
			
			tableBasicList = userLoginDB.getTable(session.getAttribute("email").toString());
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		default:
			System.out.println("Unexpected Error.");
			
			break;
			
		}
		
	}

}
