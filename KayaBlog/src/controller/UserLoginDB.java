package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
				insertLog(ul);
			}
			ps.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return controll;
	}
	
	
	public int insertLog(UserLogs ul) {
		int status = 0;
		 // 
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userDate` (`username`, `userEmail`, `userLogType`,`userOS`,`userBrowser`,`useripAdress`,`userLogDate`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, ul.getUsername());
			ps.setString(2,ul.getUseremailadress());
			ps.setString(3,ul.getUserlogtype());
			ps.setString(4,ul.getUserOs());
			ps.setString(5,ul.getUserBrowser());
			ps.setString(6,ul.getUserİpAdress());
			ps.setString(7,ul.getUserLogDate());
			status = ps.executeUpdate();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
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
				ul.setId(++id);
				ul.setUsername(rs.getString("username"));
				ul.setUseremailadress(rs.getString("userEmail"));
				ul.setUserlogtype(rs.getString("userLogType"));
				ul.setUserOs(rs.getString("userOS"));
				ul.setUserBrowser(rs.getString("userBrowser"));
				ul.setUserİpAdress(rs.getString("useripAdress"));
				ul.setUserLogDate(rs.getString("userLogDate"));
				
				if(ul.getUsername().equals(username) && ul.getUseremailadress().equals(email)) {
					arrayList.add(ul);
				}
				
			}
			
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
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
	}
	
	public int insertBasicTable(String username,String email,BasicTable bt) {
		int status = 0;
		 // 
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userBasicTable` (`username`, `userEmail`, `userShowType`,`userShowEmail`,`userShowUsername`,`userShowPassword`,`userShowExplanation`,`userTypeOfEncrypt`) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, bt.getUserShowtype());
			ps.setString(4, bt.getUserShowEmail());
			ps.setString(5, bt.getUserShowUsername());
			ps.setString(6, bt.getUserShowpassword());
			ps.setString(7, bt.getUserShowExplanation());
			ps.setString(8, bt.getTypeofencrypt());
			
			status = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public  void deleteBasicTable(int id) {
		
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("DELETE  FROM newsdata.userBasicTable where id = ?");
			ps.setInt(1,id);
			ps.execute();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
