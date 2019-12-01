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
import model.TelephoneDirectoryTable;

public class Telephonedirectoryservices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		
		TelephoneDirectoryTable directoryTable;
		
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<TelephoneDirectoryTable> tableTelephoneDirectoryList = userLoginDB.getTelephoneDirectoryTable(session.getAttribute("email").toString());
		
		switch(type) {
		case "REFRESH":
			
			tableTelephoneDirectoryList = userLoginDB.getTelephoneDirectoryTable(session.getAttribute("email").toString());
			
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			type = "";
			
			break;
			
		case "SAVE":
			
			InsertDB insert = new InsertDB();
			
			directoryTable = new TelephoneDirectoryTable(0,0,
					session.getAttribute("email").toString(),
					request.getParameter("phonenumbertype"),
					request.getParameter("phoneownername"),
					request.getParameter("phonenumber"),
					request.getParameter("phoneexplain"),
					request.getParameter("typeofmyencrypt"));
			
			insert.insertToPhoneTable(directoryTable);
		
			tableTelephoneDirectoryList = userLoginDB.getTelephoneDirectoryTable( session.getAttribute("email").toString());
		
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			
			type = "";
		
			break;
			
		case "UPDATE":
		
			UpdateDB update = new UpdateDB();
			
			directoryTable = new TelephoneDirectoryTable(
					tableTelephoneDirectoryList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB(),
					Integer.valueOf(request.getParameter("useridUpdate")),
					session.getAttribute("email").toString(),
					request.getParameter("phonenumbertypeUpdate"),
					request.getParameter("phoneownernameUpdate"),
					request.getParameter("phonenumberUpdate"),
					request.getParameter("phoneexplainUpdate"),
					"None");
			
			update.updateToPhoneTable(directoryTable);
			
			tableTelephoneDirectoryList = userLoginDB.getTelephoneDirectoryTable(session.getAttribute("email").toString());
			
			request.setAttribute("tableTelephoneDirectoryList",tableTelephoneDirectoryList);
			request.getRequestDispatcher("/telephonedirectory.jsp").forward(request, response);
			
			type = "";
			
			break;
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromTelephoneDirectoryTable(tableTelephoneDirectoryList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB());
			
			tableTelephoneDirectoryList = userLoginDB.getTelephoneDirectoryTable(session.getAttribute("email").toString());
			
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
