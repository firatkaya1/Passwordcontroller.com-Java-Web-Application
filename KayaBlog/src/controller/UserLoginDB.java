package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.ConnectionHelper;
import database.İnsertDB;
import model.BankTable;
import model.BasicTable;
import model.BrowserInformations;
import model.EmailTable;
import model.SocialMediaTable;
import model.User;
import model.UserLogs;

public class UserLoginDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public boolean verify(String username,String userpassword,String useremail,String type,String useragent) {
		boolean controll = false;
		
		try {
			conn = ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userAdmins` WHERE `userAdminName` = ? AND `userAdminPassword` = ? AND `userAdminEmail` = ?");
			ps.setString(1,username);
			ps.setString(2,userpassword);
			ps.setString(3,useremail);
			
			ResultSet rs = ps.executeQuery();
			controll = rs.next();			
			if(controll == true) {
				BrowserInformations bI = new BrowserInformations(useragent);
				UserLogs ul = new UserLogs(username,useremail,type,bI);
				İnsertDB insert = new İnsertDB();
				insert.insertLog(ul);
			}
			ps.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return controll;
	}
	
	
	
	
	public User getUser(String username, String userpassword,String useremail) {
		User ur = new User();
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userAdmins` WHERE  `userAdminName` = ? AND `userAdminPassword` = ? AND `userAdminEmail` = ? ");		
			ps.setString(1, username);
			ps.setString(2, userpassword);
			ps.setString(3, useremail);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					ur.setUserAdminName(rs.getString("userAdminName"));
					ur.setUserAdminPassword(rs.getString("userAdminPassword"));			
					ur.setEmailAdress(rs.getString("userAdminEmail"));			
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return ur;
	}
	
	public ArrayList<BasicTable> getTable(String username,String email) {
		ArrayList<BasicTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userBasicTable");
			ResultSet rs = ps.executeQuery();
			int id=0;
			while(rs.next()) {
				BasicTable bt = new BasicTable();
				bt.setIdentifyofDB(rs.getInt(1));
				bt.setUsername(rs.getString("username"));
				bt.setUseremail(rs.getString("useremail"));
				bt.setUserShowtype(rs.getString("userShowType"));
				bt.setUserShowEmail(rs.getString("userShowEmail"));
				bt.setUserShowUsername(rs.getString("userShowUsername"));
				bt.setUserShowpassword(rs.getString("userShowPassword"));
				bt.setUserShowExplanation(rs.getString("userShowExplanation"));
				bt.setTypeofencrypt(rs.getString("userTypeOfEncrypt"));
				
				if(bt.getUsername().equals(username) && bt.getUseremail().equals(email)) {
					bt.setUserid(++id);
					arrayList.add(bt);
					
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
		
	}
	public ArrayList<UserLogs> getUserLogs(String username,String email){
		ArrayList<UserLogs> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userDate");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				UserLogs ul = new UserLogs();
				
				ul.setUsername(rs.getString("username"));
				ul.setUseremailadress(rs.getString("userEmail"));
				ul.setUserlogtype(rs.getString("userLogType"));
				ul.setUserOs(rs.getString("userOS"));
				ul.setUserBrowser(rs.getString("userBrowser"));
				ul.setUserİpAdress(rs.getString("useripAdress"));
				ul.setUserLogDate(rs.getString("userLogDate"));
				
				if(ul.getUsername().equals(username) && ul.getUseremailadress().equals(email)) {
					ul.setId(++id);
					arrayList.add(ul);
				}
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return arrayList;
	}
	public ArrayList<SocialMediaTable> getSocialMedia(String username,String email){
		ArrayList<SocialMediaTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userSocialMedia");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				SocialMediaTable smt = new SocialMediaTable();
				smt.setIdentifyofDB(rs.getInt(1));
				smt.setId(++id);
				smt.setUsername(rs.getString("username"));
				smt.setUseremailadress(rs.getString("useremailadress"));
				smt.setSocialMediaType(rs.getString("userSocialMediaType"));
				smt.setSocialMediaEmail(rs.getString("userSocialMediasEmail"));
				smt.setSocialMediaUsername(rs.getString("userSocialMediaUsername"));
				smt.setSocialMediaPassword(rs.getString("userSocialMediaPassword"));
				smt.setSocialMediaExplanation(rs.getString("userSocialMediaExplanations"));
				
				
				if(smt.getUsername().equals(username) && smt.getUseremailadress().equals(email)) {
					arrayList.add(smt);
				}
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
	}
	
	public ArrayList<EmailTable> getEmailTable(String username,String email){
		ArrayList<EmailTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userEmailServices");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				EmailTable et = new EmailTable();
				et.setIdentifyofDB(rs.getInt(1));
				et.setId(++id);
				et.setUsername(rs.getString("username"));
				et.setUseremailadress(rs.getString("useremailadress"));
				et.setUserEmailType(rs.getString("userEmailType"));
				et.setUserEmailServicesAdress(rs.getString("userEmailServicesAdress"));
				et.setUserEmailServicesPass(rs.getString("userEmailServicesPassword"));
				et.setUserEmailServicesExplana(rs.getString("userEmailServicesExplanations"));
				
				if(et.getUsername().equals(username) && et.getUseremailadress().equals(email)) {
					arrayList.add(et);
				}
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
	}
	
	public ArrayList<BankTable> getBankTable(String username,String email){
		ArrayList<BankTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userBankServices");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				BankTable bt = new BankTable();
				bt.setIdentifyofDB(rs.getInt(1));
				bt.setId(++id);
				bt.setUsername(rs.getString("username"));
				bt.setUseremail(rs.getString("useremail"));
				bt.setBankname(rs.getString("userBankName"));
				bt.setBankcardnumber(rs.getString("userBankCardNumber"));
				bt.setBankcardname(rs.getString("userBankCardName"));
				bt.setBanklastdate(rs.getString("userBankLastDate"));
				bt.setBankexpirationdate(rs.getString("userBankExpirationDate"));
				bt.setBankexplain(rs.getString("userBankExplain"));
				bt.setUsertypeofencrypt(rs.getString("usertypeofencrypt"));
				
				if(bt.getUsername().equals(username) && bt.getUseremail().equals(email)) {
					arrayList.add(bt);
				}
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
		
	}
	
	

	

	
}
