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
		UserLoginDB uld = new UserLoginDB();
		İnsertDB insert = new İnsertDB();
		DeleteDB delete = new DeleteDB();
		UpdateDB update = new UpdateDB();
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		String username=session.getAttribute("username").toString();
		String email=session.getAttribute("email").toString();
		
		
		ArrayList<EmailTable> emailList = uld.getEmailTable(username,email);
		
		
		switch(type) {
		case "REFRESH":
			emailList = uld.getEmailTable(username, email);
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			type = "";
			break;
		case "SAVE":
			String emailServices = request.getParameter("emailServices");
			String emailServicesAdress = request.getParameter("emailAdress");
			String emailPassword= request.getParameter("password");
			String explanations = request.getParameter("explanations");
			String typeEncrypt = request.getParameter("typeofmyencrypttext");
			
			if(!emailServices.isEmpty() && !emailServicesAdress.isEmpty() && !emailPassword.isEmpty()) 
			{
				EmailTable et = new EmailTable(username,email,emailServices,emailServicesAdress,emailPassword,explanations,typeEncrypt);
			
				insert.insertToEmailTable(username,email, et);
			
				emailList = uld.getEmailTable(username, email);
			
				request.setAttribute("emailList",emailList);
				request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			} else {
				request.setAttribute("emailList",emailList);
				request.getRequestDispatcher("/basictable.jsp").forward(request, response);
			}
			type = "";
			break;
			
		case "UPDATE":
			int identifyofDB = emailList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB();
			emailServices = request.getParameter("emailServicesUpdate");
			emailServicesAdress = request.getParameter("emailAdressUpdate");
			emailPassword = request.getParameter("passwordUpdate");
			explanations = request.getParameter("explanationsUpdate");
			
			EmailTable et = new EmailTable(identifyofDB,username,email,emailServices,emailServicesAdress,emailPassword,explanations);
			
			update.updateToEmailTable(username, email, et);
			
			emailList = uld.getEmailTable(username, email);
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			type = "";
			break;
			
		case "DELETE":
			identifyofDB = emailList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB();
			
			delete.deleteFromEmailTable(identifyofDB);
			
			emailList = uld.getEmailTable(username, email);
			
			request.setAttribute("emailList",emailList);
			request.getRequestDispatcher("/emailservices.jsp").forward(request, response);
			
			type = "";
			break;
			
		default:
			System.out.println("Error");
			type = "";
			break;
			
		}
		
		
	}

}
