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
import model.TelephoneDirectoryTable;

public class Telephonedirectoryservices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDB uld = new UserLoginDB();
		İnsertDB insert = new İnsertDB();
		DeleteDB delete = new DeleteDB();
		UpdateDB update = new UpdateDB();
		
		HttpSession session = request.getSession();
		String type = request.getParameter("Submit");
		String username= session.getAttribute("username").toString();
		String email = session.getAttribute("email").toString();
		
		ArrayList<TelephoneDirectoryTable> tableTelephoneDirectoryList = uld.getTelephoneDirectoryTable(username, email);
		
		switch(type) {
		case "REFRESH":
			tableTelephoneDirectoryList = uld.getTelephoneDirectoryTable(username, email);
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			type = "";
			break;
			
		case "SAVE":
			String phonenumbertype = request.getParameter("phonenumbertype");
			String phoneownername = request.getParameter("phoneownername");
			String phonenumber= request.getParameter("phonenumber");
			String phoneexplain = request.getParameter("phoneexplain");
			String typeofmyencrypt = request.getParameter("typeofmyencrypt");
			
			
			if(!phonenumbertype.isEmpty() && !phoneownername.isEmpty() && !phonenumber.isEmpty()) 
			{
				TelephoneDirectoryTable tdt = new TelephoneDirectoryTable(0,0,username,email,phonenumbertype,phoneownername,phonenumber,phoneexplain,typeofmyencrypt);
				
				insert.insertToPhoneTable(tdt);
			
				tableTelephoneDirectoryList = uld.getTelephoneDirectoryTable(username, email);
			
				request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
				request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			} else {
				request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
				request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			}
			type = "";
			break;
			
		case "UPDATE":
			int identifyofDB = tableTelephoneDirectoryList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB();
			int id = Integer.valueOf(request.getParameter("useridUpdate"));
			phonenumbertype = request.getParameter("phonenumbertypeUpdate");
			phoneownername = request.getParameter("phoneownernameUpdate");
			phonenumber= request.getParameter("phonenumberUpdate");
			phoneexplain = request.getParameter("phoneexplainUpdate");
			typeofmyencrypt = "None";
			
			TelephoneDirectoryTable tdt = new TelephoneDirectoryTable(identifyofDB,id,username,email,phonenumbertype,phoneownername,phonenumber,phoneexplain,typeofmyencrypt);
			// update database
			update.updateToPhoneTable(tdt);
			// refresh BasicTable values
			tableTelephoneDirectoryList = uld.getTelephoneDirectoryTable(username, email);
			
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			type = "";
			break;
			
		case "DELETE":
			id = Integer.valueOf(request.getParameter("userid"));
			delete.deleteFromTelephoneDirectoryTable(id);
			tableTelephoneDirectoryList = uld.getTelephoneDirectoryTable(username, email);
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			type = "";
			break;
			
		default:
			System.out.println("Unexpected Error.");
			break;
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
