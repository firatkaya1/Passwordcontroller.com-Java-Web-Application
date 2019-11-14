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
import model.EmailTable;

public class Emailservices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<EmailTable> emailList = userLoginDB.getEmailTable(session.getAttribute("username").toString(),session.getAttribute("email").toString());
		
		
		switch(type) {
		case "REFRESH":
			emailList = userLoginDB.getEmailTable(session.getAttribute("username").toString(),session.getAttribute("email").toString());
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "SAVE":
			
			İnsertDB insert = new İnsertDB();
			
			EmailTable emailTable = new EmailTable(
					session.getAttribute("username").toString(),
					session.getAttribute("email").toString(),
					request.getParameter("emailServices"),
					request.getParameter("emailAdress"),
					request.getParameter("password"),
					request.getParameter("explanations"),
					request.getParameter("typeofmyencrypttext"));
		
			insert.insertToEmailTable(emailTable);
		
			emailList = userLoginDB.getEmailTable(emailTable.getUsername(), emailTable.getUseremailadress());
		
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			EmailTable table = new EmailTable(emailList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB(),
					session.getAttribute("username").toString(),
					session.getAttribute("email").toString(),
					request.getParameter("emailServicesUpdate"),
					request.getParameter("emailAdressUpdate"),
					request.getParameter("passwordUpdate"),
					request.getParameter("explanationsUpdate"));
			
			update.updateToEmailTable(table);
			
			emailList = userLoginDB.getEmailTable(session.getAttribute("username").toString(),session.getAttribute("email").toString());
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromEmailTable(emailList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB());
			
			emailList = userLoginDB.getEmailTable(session.getAttribute("username").toString(),session.getAttribute("email").toString());
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			break;
			
		default:
			System.out.println("Error");
			
			break;
			
		}
	}
}
