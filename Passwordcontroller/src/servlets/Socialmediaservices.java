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
import model.SocialMediaTable;
import model.UserLogs;

public class Socialmediaservices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		
		SocialMediaTable socialMediaTable;
		UserLogs ul;
		InsertDB insert = new InsertDB();
		BrowserInformations browser = new BrowserInformations(request.getHeader("User-Agent"));
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<SocialMediaTable> socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("email").toString());
		
		
		switch(type) {
		case "REFRESH":
			socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("email").toString());
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			
			break;
			
		case "SAVE":
			
			insert = new InsertDB();
			
			socialMediaTable = new SocialMediaTable(
					session.getAttribute("email").toString(),
					request.getParameter("type"),
					request.getParameter("email"),
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("description"),
					"none");
		
			insert.insertToSocialMediaTable(socialMediaTable);
		
			socialMediaList = userLoginDB.getSocialMedia(socialMediaTable.getUseremailadress());
		
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"ADD",
					browser,
					"SOCIAL MEDIA TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			 
			break;	
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			socialMediaTable = new SocialMediaTable(
					socialMediaList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB(),
					Integer.valueOf(request.getParameter("userid")),
					session.getAttribute("email").toString(),
					request.getParameter("type"),
					request.getParameter("email"),
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("description"),
					"none");
			
			update.updateToSocialMediaTable(socialMediaTable);
			
			socialMediaList = userLoginDB.getSocialMedia(socialMediaTable.getUseremailadress());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"UPDATE",
					browser,
					"SOCIAL MEDIA TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
			break;		
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromSocialMediaTable(socialMediaList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB());
			socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("email").toString());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"DELETE",
					browser,
					"SOCIAL MEDIA TABLE");
			insert.insertLog(ul);
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
		
			break;
		}
		
	}

}
