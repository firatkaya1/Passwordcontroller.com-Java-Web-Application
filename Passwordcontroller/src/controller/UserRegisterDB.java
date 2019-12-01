package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionHelper;
import model.*;;

public class UserRegisterDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public int insertUser(User user) {
		int status = 0;
		try {
			conn=ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userInformation` (`useremail`, `userpassword`, `userphone`, `usercreatedate`,`userpremiumid`) VALUES (?,?,?,?,?)");
			ps.setString(1,user.getEmailAdress());
			ps.setString(2,user.getUserAdminPassword());	
			ps.setString(3,user.getUserAdminPhone());
			ps.setString(4,user.getUserAdminCreateDate());
			ps.setString(5, "123456");
			status = ps.executeUpdate();
			ps.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	

	
	public boolean verify(String email) {
		boolean controll = true;
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userInformation` WHERE  `useremail` = ? ");		
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			controll = rs.next();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return controll;
	}

	
}
