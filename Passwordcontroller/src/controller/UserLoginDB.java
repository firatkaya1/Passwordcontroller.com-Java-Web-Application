package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import database.ConnectionHelper;
import database.InsertDB;
import model.BankTable;
import model.BasicTable;
import model.BrowserInformations;
import model.EmailTable;
import model.SocialMediaTable;
import model.TelephoneDirectoryTable;
import model.User;
import model.UserLogs;

public class UserLoginDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public boolean verify(String useremail,String userpassword,String type,String useragent) {
		boolean controll = false;
		
		try {
			conn = ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userInformation` WHERE `useremail` = ? AND `userpassword` = ? ");
			ps.setString(1,useremail);
			ps.setString(2,userpassword);
			
			ResultSet rs = ps.executeQuery();
			controll = rs.next();			
			if(controll == true) {
				BrowserInformations bI = new BrowserInformations(useragent);
				UserLogs ul = new UserLogs(useremail,type,bI);
				InsertDB insert = new InsertDB();
				insert.insertLog(ul);
			}
			ps.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return controll;
	}
	
	
	public User getUser(String useremail, String userpassword) {
		User ur = new User();
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userInformation` WHERE  `useremail` = ? AND `userpassword` = ? ");		
			ps.setString(1, useremail);
			ps.setString(2, userpassword);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {		
					ur.setEmailAdress(rs.getString("useremail"));
					ur.setUserAdminPassword(rs.getString("userpassword"));	
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return ur;
	}
	
	public ArrayList<BasicTable> getTable(String email) {
		ArrayList<BasicTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userBasicTable");
			ResultSet rs = ps.executeQuery();
			int id=0;
			while(rs.next()) {
				BasicTable bt = new BasicTable();
				bt.setIdentifyofDB(rs.getInt(1));
				bt.setUseremail(rs.getString("useremail"));
				bt.setUserShowtype(rs.getString("userShowType"));
				bt.setUserShowEmail(rs.getString("userShowEmail"));
				bt.setUserShowUsername(rs.getString("userShowUsername"));
				bt.setUserShowpassword(rs.getString("userShowPassword"));
				bt.setUserShowExplanation(rs.getString("userShowExplanation"));
				bt.setTypeofencrypt(rs.getString("userTypeOfEncrypt"));
				
				if(bt.getUseremail().equals(email)) {
					bt.setUserid(++id);
					arrayList.add(bt);
					
				}
				
			}
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
		
	}
	public ArrayList<UserLogs> getUserLogs(String email){
		ArrayList<UserLogs> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userDate");
			ResultSet rs = ps.executeQuery();
			int id = 100;
			while(rs.next()) {
				UserLogs ul = new UserLogs();
				
				ul.setUseremailadress(rs.getString("userEmail"));
				ul.setUserlogtype(rs.getString("userLogType"));
				ul.setUserOs(rs.getString("userOS"));
				ul.setUserBrowser(rs.getString("userBrowser"));
				ul.setUserIpAdress(rs.getString("useripAdress"));
				ul.setUserLogDate(rs.getString("userLogDate"));
				
				if(ul.getUseremailadress().equals(email)) {
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
		
		Collections.reverse(arrayList);
		return arrayList;
	}
	public ArrayList<SocialMediaTable> getSocialMedia(String email){
		ArrayList<SocialMediaTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userSocialMedia");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				SocialMediaTable smt = new SocialMediaTable();
				smt.setIdentifyofDB(rs.getInt(1));
				
				smt.setUseremailadress(rs.getString("useremailadress"));
				smt.setSocialMediaType(rs.getString("userSocialMediaType"));
				smt.setSocialMediaEmail(rs.getString("userSocialMediasEmail"));
				smt.setSocialMediaUsername(rs.getString("userSocialMediaUsername"));
				smt.setSocialMediaPassword(rs.getString("userSocialMediaPassword"));
				smt.setSocialMediaExplanation(rs.getString("userSocialMediaExplanations"));
				
				
				if(smt.getUseremailadress().equals(email)) {
					smt.setId(++id);
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
	
	public ArrayList<EmailTable> getEmailTable(String email){
		ArrayList<EmailTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userEmailServices");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				EmailTable et = new EmailTable();
				et.setIdentifyofDB(rs.getInt(1));
				et.setUseremailadress(rs.getString("useremailadress"));
				et.setUserEmailType(rs.getString("userEmailType"));
				et.setUserEmailServicesAdress(rs.getString("userEmailServicesAdress"));
				et.setUserEmailServicesPass(rs.getString("userEmailServicesPassword"));
				et.setUserEmailServicesExplana(rs.getString("userEmailServicesExplanations"));
				
				if(et.getUseremailadress().equals(email)) {
					et.setId(++id);
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
	
	public ArrayList<BankTable> getBankTable(String email){
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
				bt.setUseremail(rs.getString("useremail"));
				bt.setBankname(rs.getString("userBankName"));
				bt.setBankcardnumber(rs.getString("userBankCardNumber"));
				bt.setBankcardname(rs.getString("userBankCardName"));
				bt.setBankexpirationdate(rs.getString("userBankExpirationDate"));
				bt.setBankexplain(rs.getString("userBankExplain"));
				bt.setUsertypeofencrypt(rs.getString("usertypeofencrypt"));
				
				if(bt.getUseremail().equals(email)) {
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
	
	public ArrayList<TelephoneDirectoryTable> getTelephoneDirectoryTable(String email){
		ArrayList<TelephoneDirectoryTable> arrayList = new ArrayList<>();
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM newsdata.userPhoneDirectory");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				TelephoneDirectoryTable tdt = new TelephoneDirectoryTable();
				tdt.setIdentifyofDB(rs.getInt(1));
				tdt.setId(++id);
				tdt.setUseremail(rs.getString("useremail"));
				tdt.setPhonenumbertype(rs.getString("userPhoneType"));
				tdt.setPhoneownername(rs.getString("userPhoneOwnerName"));
				tdt.setPhonenumber(rs.getString("userPhoneNumber"));
				tdt.setPhonexplain(rs.getString("userPhoneExplain"));
				tdt.setTypeofencrypt(rs.getString("usertypeofencrypt"));
				
				if(tdt.getUseremail().equals(email)) {
					arrayList.add(tdt);
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
