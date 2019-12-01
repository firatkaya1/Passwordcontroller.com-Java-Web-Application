package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionHelper;
import model.*;;

public class UserRegisterDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public int insertUser(User uar) {
		int status = 0;
		try {
			conn=ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userAdmins` (`userAdminName`, `userAdminPassword`, `userAdminEmail`, `userAdminPhone`, `userAdminCreateDate`) VALUES (?,?,?,?,?)");
			ps.setString(1,uar.getUserAdminName());
			ps.setString(2,uar.getUserAdminPassword());	
			ps.setString(3,uar.getEmailAdress());
			ps.setString(4,uar.getUserAdminPhone());
			ps.setString(5,uar.getUserAdminCreateDate());
			status = ps.executeUpdate();
			ps.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	

	
	public boolean verify(String email,String username) {
		boolean controll = false;
		
		try {
			conn =ConnectionHelper.getConn();
			ps = conn.prepareStatement("SELECT * FROM `userAdmins` WHERE  `userAdminEmail` = ? AND `userAdminName` = ?");		
			ps.setString(1, email);
			ps.setString(2, username);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(!email.equals(rs.getString("userAdminEmail")) ||  !username.equals(rs.getString("userAdminName"))) 
				controll = true;
			}
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return controll;
	}

	
}
