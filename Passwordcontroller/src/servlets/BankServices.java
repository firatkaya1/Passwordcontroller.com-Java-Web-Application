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
import model.BankTable;
import model.BrowserInformations;
import model.UserLogs;

public class BankServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDB userLoginDB = new UserLoginDB();
		BankTable bankTable;
		UserLogs ul;
		InsertDB insert = new InsertDB();
		BrowserInformations browser = new BrowserInformations(request.getHeader("User-Agent"));
		HttpSession session = request.getSession();
		
		String type = request.getParameter("Submit");
		
		ArrayList<BankTable> tableBankList = userLoginDB.getBankTable(session.getAttribute("email").toString());
		
		switch(type) {
		case "REFRESH":
			
			tableBankList = userLoginDB.getBankTable(session.getAttribute("email").toString());
			
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			type = "";
			
			break;
			
		case "SAVE":
			
			insert = new InsertDB();
			
			bankTable = new BankTable(0,0,
					session.getAttribute("email").toString(),
					request.getParameter("bankName"),
					request.getParameter("bankcardname"),
					request.getParameter("bankcardnumber"),
					request.getParameter("bankcardexpirationdate"),
					request.getParameter("description"),
					"none");
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"ADD",
					browser,
					"BANK TABLE");
			insert.insertLog(ul);
		
			insert.insertToBankTable(bankTable);
		
			tableBankList = userLoginDB.getBankTable(session.getAttribute("email").toString());
		
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			
			type = "";
			
			break;
			
		case "UPDATE":
		
			UpdateDB update = new UpdateDB();
			
			bankTable = new BankTable(
					tableBankList.get(Integer.valueOf(request.getParameter("userid"))-1).getIdentifyofDB(),
					Integer.valueOf(request.getParameter("userid")),
					session.getAttribute("email").toString(),
					request.getParameter("bankName"),
					request.getParameter("bankcardname"),
					request.getParameter("bankcardnumber"),
					request.getParameter("bankcardexpirationdate"),
					request.getParameter("description"),
					"None");
			
			update.updateToBankTable(bankTable);
			
			tableBankList = userLoginDB.getBankTable(session.getAttribute("email").toString());
			
			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"UPDATE",
					browser,
					"BANK TABLE");
			
			request.setAttribute("tableBankList",tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);
			
			type = "";
			
			break;
			
		case "DELETE":

			DeleteDB delete = new DeleteDB();

			delete.deleteFromBankTable(
					tableBankList.get(Integer.valueOf(request.getParameter("userid")) - 1).getIdentifyofDB());

			tableBankList = userLoginDB.getBankTable(session.getAttribute("email").toString());

			request.setAttribute("tableBankList", tableBankList);
			request.getRequestDispatcher("/bankservices.jsp").forward(request, response);

			ul = new UserLogs(
					session.getAttribute("email").toString(),
					"DELETE",
					browser,
					"BANK TABLE");
			
			type = "";

			break;

		default:
			System.out.println("Unexpected Error.");
			break;
		}
	}

}
