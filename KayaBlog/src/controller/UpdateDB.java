package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.BasicTable;
import model.EmailTable;

public class UpdateDB {
	static Connection conn;
	static PreparedStatement ps;
	
	
	public int updateToBasicTable(String username,String email,BasicTable bt) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userBasicTable set id=?, username=?, useremail=?, userShowType=?, userShowEmail=?, userShowUsername=?, userShowPassword=?, userShowExplanation=? where id="+bt.getIdentifyofDB());                     
			
			ps.setInt(1,bt.getIdentifyofDB());
			ps.setString(2,username);
			ps.setString(3,email);
			ps.setString(4,bt.getUserShowtype());
			ps.setString(5,bt.getUserShowEmail());
			ps.setString(6,bt.getUserShowUsername());
			ps.setString(7,bt.getUserShowpassword());
			ps.setString(8,bt.getUserShowExplanation());
			
			status = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public int updateToEmailTable(String username,String email,EmailTable et) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userEmailServices set id=?, username=?, useremailadress=?, userEmailType=?, userEmailServicesAdress=?, userEmailServicesPassword=?, userEmailServicesExplanations=? where id="+et.getIdentifyofDB());                     
			
			ps.setInt(1, et.getIdentifyofDB());
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, et.getUserEmailType());
			ps.setString(5, et.getUserEmailServicesAdress());
			ps.setString(6, et.getUserEmailServicesPass());
			ps.setString(7, et.getUserEmailServicesExplana());
			
			status = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}


}
