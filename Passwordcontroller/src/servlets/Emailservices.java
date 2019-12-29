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
import model.BrowserInformations;
import model.EmailTable;
import model.UserLogs;

public class Emailservices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		
		EmailTable emailTable;
		UserLogs ul;
		InsertDB insert = new InsertDB();
		BrowserInformations browser = new BrowserInformations(request.getHeader("User-Agent"));
		
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<EmailTable> emailList = userLoginDB.getEmailTable(session.getAttribute("email").toString());
		
		
	switch(type) {
		case "REFRESH":
			emailList = userLoginDB.getEmailTable(session.getAttribute("email").toString());
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "SAVE":
			
			 insert = new InsertDB();
			
			emailTable = new EmailTable(
					session.getAttribute("email").toString(),
					request.getParameter("type"),
					request.getParameter("email"),
					request.getParameter("password"),
					request.getParameter("description"),
					"none");  //request.getParameter("typeofmyencrypttext")
		
			insert.insertToEmailTable(emailTable);
		
			emailList = userLoginDB.getEmailTable(emailTable.getUseremailadress());
		
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"ADD",
					browser,
					"EMAIL TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			emailTable = new EmailTable(
					emailList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB(),
					session.getAttribute("email").toString(),
					request.getParameter("type"),
					request.getParameter("email"),
					request.getParameter("password"),
					request.getParameter("description"));
			
			update.updateToEmailTable(emailTable);
			
			emailList = userLoginDB.getEmailTable(session.getAttribute("email").toString());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"UPDATE",
					browser,
					"EMAIL TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromEmailTable(emailList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB());
			
			emailList = userLoginDB.getEmailTable(session.getAttribute("email").toString());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"DELETE",
					browser,
					"EMAIL TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		default:
			System.out.println("Error");
			
			break;
			
		}
	}
}
