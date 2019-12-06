package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserLoginDB;
import model.UserLogs;


public class UserActivities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserActivities() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDB uld = new UserLoginDB();
		String type = request.getParameter("submit");
		HttpSession session = request.getSession();
		
		
		ArrayList<UserLogs> userLogs = uld.getUserLogs(session.getAttribute("email").toString());
		
		if(type.equals("REFRESH")) {
			request.setAttribute("userLogsList",userLogs);
			request.getRequestDispatcher("/useractivities.jsp").forward(request, response);
		}
		if(type.equals("exit")) {
			response.sendRedirect("login.jsp");
			
		}
	}

}
