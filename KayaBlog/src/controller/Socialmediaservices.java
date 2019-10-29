package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SocialMediaTable;

public class Socialmediaservices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDB uld = new UserLoginDB();
		String type = request.getParameter("submit");
		HttpSession session = request.getSession();
		ArrayList<SocialMediaTable> socialMediaList = uld.getSocialMedia(session.getAttribute("username").toString(), session.getAttribute("email").toString());
		
		if(type.equals("REFRESH")) {
			request.setAttribute("socialMediaList",socialMediaList);
			request.getRequestDispatcher("/socialmediaservices.jsp").forward(request, response);
		}
		if(type.equals("exit")) {
			response.sendRedirect("login.jsp");
			
		}
	}

}
