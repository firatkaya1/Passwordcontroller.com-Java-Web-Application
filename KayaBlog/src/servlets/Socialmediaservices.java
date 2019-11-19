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
import model.SocialMediaTable;

public class Socialmediaservices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLoginDB userLoginDB = new UserLoginDB();
		
		SocialMediaTable socialMediaTable;
		
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<SocialMediaTable> socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("username").toString(),session.getAttribute("email").toString());
		
		
		switch(type) {
		case "REFRESH":
			socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("username").toString(), session.getAttribute("email").toString());
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			
			break;
			
		case "SAVE":
			
			İnsertDB insert = new İnsertDB();
			
			socialMediaTable = new SocialMediaTable(
					session.getAttribute("username").toString(),
					session.getAttribute("email").toString(),
					request.getParameter("socialmediaType"),
					request.getParameter("socialmediaEmail"),
					request.getParameter("socialmediausername"),
					request.getParameter("socialmediapassword"),
					request.getParameter("socialmediaexp"),
					request.getParameter("typeofmyencrypt"));
		
			insert.insertToSocialMediaTable(socialMediaTable);
		
			socialMediaList = userLoginDB.getSocialMedia(socialMediaTable.getUsername(), socialMediaTable.getUseremailadress());
		
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			 
			break;	
			
		case "UPDATE":
			
			UpdateDB update = new UpdateDB();
			
			socialMediaTable = new SocialMediaTable(
					socialMediaList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB(),
					Integer.valueOf(request.getParameter("useridUpdate")),
					session.getAttribute("username").toString(),
					session.getAttribute("email").toString(),
					request.getParameter("socialmediaTypeUpdate"),
					request.getParameter("socialmediaEmailUpdate"),
					request.getParameter("socialmediausernameUpdate"),
					request.getParameter("socialmediapasswordUpdate"),
					request.getParameter("socialmediaexpUpdate"),
					request.getParameter("typeofmyencrypt"));
			
			update.updateToSocialMediaTable(socialMediaTable);
			
			socialMediaList = userLoginDB.getSocialMedia(socialMediaTable.getUsername(), socialMediaTable.getUseremailadress());
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
			break;		
			
		case "DELETE":
			
			DeleteDB delete = new DeleteDB();
			
			delete.deleteFromSocialMediaTable(socialMediaList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB());
			socialMediaList = userLoginDB.getSocialMedia(session.getAttribute("username").toString(), session.getAttribute("email").toString());
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
		
			break;
		}
		
	}

}
