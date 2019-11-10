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
import model.BankTable;

public class BankServices extends HttpServlet {
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
		String values = request.getParameter("valueofid");
		String username= session.getAttribute("username").toString();
		String email = session.getAttribute("email").toString();
		
		ArrayList<BankTable> tableBankList = uld.getBankTable(username, email);
		
		switch(type) {
		case "REFRESH":
			tableBankList = uld.getBankTable(username, email);
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			type = "";
			break;
			
		case "SAVE":
			String bankName = request.getParameter("bankName");
			String bankcardname = request.getParameter("bankcardname");
			String bankcardnumber= request.getParameter("bankcardnumber");
			String lastdate = request.getParameter("bankcardlastdate");
			String expirationdate = request.getParameter("bankcardexpirationdate");
			String typeofmyencrypt = request.getParameter("typeofmyencrypt");
			String explanations = request.getParameter("explain");
			
			
			if(!bankcardname.isEmpty() && !bankcardnumber.isEmpty() && !lastdate.isEmpty()) 
			{
				BankTable bt = new BankTable(0,0,username,email,bankName,bankcardname,bankcardnumber,lastdate,expirationdate,explanations,typeofmyencrypt);
			
				insert.insertToBankTable(bt);
			
				tableBankList = uld.getBankTable(username, email);
			
				request.setAttribute("tableBankList",tableBankList);
				request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			} else {
				request.setAttribute("tableBankList",tableBankList);
				request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			}
			type = "";
			break;
			
		case "UPDATE":
			int identifyofDB = tableBankList.get(Integer.valueOf(request.getParameter("useridUpdate"))-1).getIdentifyofDB();
			int id = Integer.valueOf(request.getParameter("useridUpdate"));
			bankName = request.getParameter("bankNameUpdate");
			bankcardname = request.getParameter("bankcardnameUpdate");
			bankcardnumber= request.getParameter("bankcardnumberUpdate");
			lastdate = request.getParameter("bankcardlastdateUpdate");
			expirationdate = request.getParameter("bankcardexpirationdateUpdate");
			typeofmyencrypt = "None";
			explanations = request.getParameter("explainUpdate");
			
			BankTable bt = new BankTable(identifyofDB,id,username,email,bankName,bankcardname,bankcardnumber,lastdate,expirationdate,explanations,typeofmyencrypt);
			// update database
			update.updateToBankTable(bt);
			// refresh BasicTable values
			tableBankList = uld.getBankTable(username, email);
			
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			type = "";
			break;
			
		case "DELETE":
			id = Integer.valueOf(request.getParameter("userid"));
			delete.deleteFromBankTable(id);
			tableBankList = uld.getBankTable(username, email);
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			type = "";
			break;
			
		default:
			System.out.println("Unexpected Error.");
			break;
		}
	}

}
