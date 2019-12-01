package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDB {
	static Connection conn;
	static PreparedStatement ps;
	
	public boolean deleteFromBasicTable(int id) {
		boolean status = false;
		
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("DELETE  FROM newsdata.userBasicTable where id = ?");
			
			ps.setInt(1,id);
			ps.execute();
			
			conn.close();
			ps.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public boolean deleteFromEmailTable(int id) {
		boolean status = false;
		
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("DELETE  FROM newsdata.userEmailServices where id = ?");
			
			ps.setInt(1, id);
			
			status = ps.execute();
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println();
		}
		
		return status;
	}
	public boolean deleteFromSocialMediaTable(int id) {
		boolean status = false;
		
		try {
			conn = ConnectionHelper.getConn();
			ps = conn.prepareStatement("DELETE  FROM newsdata.userSocialMedia where id = ?");
			
			ps.setInt(1, id);
			
			status = ps.execute();
			
			conn.close();
			ps.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public boolean deleteFromBankTable(int id) {
		boolean status = false;
		
		try {
			conn = ConnectionHelper.getConn();
			ps = conn.prepareStatement("DELETE  FROM newsdata.userBankServices where id = ?");
			
			ps.setInt(1, id);
			
			status = ps.execute();
			
			conn.close();
			ps.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	//
	public boolean deleteFromTelephoneDirectoryTable(int id) {
		boolean status = false;
		
		try {
			conn = ConnectionHelper.getConn();
			ps = conn.prepareStatement("DELETE  FROM newsdata.userPhoneDirectory where id = ?");
			
			ps.setInt(1, id);
			
			status = ps.execute();
			
			conn.close();
			ps.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
}
