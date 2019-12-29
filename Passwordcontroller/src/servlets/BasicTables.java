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
import model.BrowserInformations;
import model.UserLogs;


public class BasicTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		BasicTable basicTable;
		UserLogs ul;
		InsertDB insert = new InsertDB();
		BrowserInformations browser = new BrowserInformations(request.getHeader("User-Agent"));
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
			
				
			
			basicTable = new BasicTable(
				session.getAttribute("email").toString(),
				request.getParameter("type"),
				request.getParameter("emailadress"),
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("description"),
					"none");		//request.getParameter("typeofmyencrypt1")
			
				insert.insertToBasicTable(basicTable);
				
				
				ul = new UserLogs(
						session.getAttribute("email").toString(),
						"ADD",
						browser,
						"BASIC TABLE");
				insert.insertLog(ul);
			
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
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"UPDATE",
					browser,
					"BASIC TABLE");
			insert.insertLog(ul);
			
			tableBasicList = userLoginDB.getTable(basicTable.getUseremail());		
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromBasicTable(tableBasicList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB());
			
			tableBasicList = userLoginDB.getTable(session.getAttribute("email").toString());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"DELETE",
					browser,
					"BASIC TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("tableBasicList",tableBasicList);
			request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			
			break;
			
		default:
			System.out.println("Unexpected Error.");
			
			break;
			
		}
		
	}

}
