package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		UserLoginDB uld = new UserLoginDB();
		İnsertDB insert = new İnsertDB();
		DeleteDB delete = new DeleteDB();
		UpdateDB update = new UpdateDB();
		
		HttpSession session = request.getSession();
		String type = request.getParameter("Submit");
		String username = session.getAttribute("username").toString();
		String email = session.getAttribute("email").toString();
		
		ArrayList<SocialMediaTable> socialMediaList = uld.getSocialMedia(username,email);
		
		
		switch(type) {
		case "REFRESH":
			socialMediaList = uld.getSocialMedia(username, email);
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
			break;
		case "SAVE":
			String socialmediaType = request.getParameter("socialmediaType");
			String socialmediaEmail = request.getParameter("socialmediaEmail");
			String socialmediausername = request.getParameter("socialmediausername");
			String socialmediapassword = request.getParameter("socialmediapassword");
			String typeofmyencrypt = request.getParameter("typeofmyencrypt");
			String socialmediaexp = request.getParameter("socialmediaexp");
			
			
			if(!socialmediaType.isEmpty() && !socialmediaEmail.isEmpty() && !socialmediapassword.isEmpty()  && !typeofmyencrypt.isEmpty()) 
			{
				SocialMediaTable smt = new SocialMediaTable(username,email,socialmediaType,socialmediaEmail,socialmediausername,socialmediapassword,socialmediaexp,typeofmyencrypt);
			
				insert.insertToSocialMediaTable(smt);
			
				socialMediaList = uld.getSocialMedia(username, email);
			
				request.setAttribute("socialMediaList",socialMediaList);
				request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			} else {
				request.setAttribute("socialMediaList",socialMediaList);
				request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			}
			type = "";
			break;	
			
		case "UPDATE":
			int identifyofDB = socialMediaList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB();
			int id = Integer.valueOf(request.getParameter("useridUpdate"));
			socialmediaType = request.getParameter("socialmediaTypeUpdate");
			socialmediaEmail = request.getParameter("socialmediaEmailUpdate");
			socialmediausername = request.getParameter("socialmediausernameUpdate");
			socialmediapassword = request.getParameter("socialmediapasswordUpdate");
			typeofmyencrypt = request.getParameter("typeofmyencrypt");
			socialmediaexp = request.getParameter("socialmediaexpUpdate");
			
			SocialMediaTable smt = new SocialMediaTable(identifyofDB,id,username,email,socialmediaType,socialmediaEmail,socialmediausername,socialmediapassword,socialmediaexp,typeofmyencrypt);
			// update database
			update.updateToSocialMediaTable(smt);
			// refresh BasicTable values
			socialMediaList = uld.getSocialMedia(username, email);
			
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
			break;		
			
		case "DELETE":
			id = socialMediaList.get(Integer.valueOf(request.getParameter("valueofid"))-1).getIdentifyofDB();
			delete.deleteFromSocialMediaTable(id);
			socialMediaList = uld.getSocialMedia(username, email);
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
			type = "";
		break;
		}
		
	}

}
