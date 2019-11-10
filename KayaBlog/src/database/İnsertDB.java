package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.BankTable;
import model.BasicTable;
import model.EmailTable;
import model.SocialMediaTable;
import model.UserLogs;

public class İnsertDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public int insertLog(UserLogs ul) {
		int status = 0;
		 
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
			// close connections
			conn.close();
			ps.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int insertToBasicTable(String username,String email,BasicTable bt) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userBasicTable` (`username`, `useremail`, `userShowType`,`userShowEmail`,`userShowUsername`,`userShowPassword`,`userShowExplanation`,`userTypeOfEncrypt`) VALUES (?,?,?,?,?,?,?,?)");
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
	
	public int insertToEmailTable(String username,String email,EmailTable et) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userEmailServices` (`username`, `useremailadress`, `userEmailType`,`userEmailServicesAdress`,`userEmailServicesPassword`,`userEmailServicesExplanations`,`userTypeOfEncrypt`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, et.getUserEmailType());
			ps.setString(4, et.getUserEmailServicesAdress());
			ps.setString(5, et.getUserEmailServicesPass() );
			ps.setString(6, et.getUserEmailServicesExplana());
			ps.setString(7, et.getTypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int insertToSocialMediaTable(SocialMediaTable smt) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userSocialMedia` (`username`, `useremailadress`, `userSocialMediaType`,`userSocialMediasEmail`,`userSocialMediaUsername`,`userSocialMediaPassword`,`userSocialMediaExplanations`,`userSocialMediaTypeEncrypt`) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, smt.getUsername());
			ps.setString(2, smt.getUseremailadress());
			ps.setString(3, smt.getSocialMediaType());
			ps.setString(4, smt.getSocialMediaEmail());
			ps.setString(5, smt.getSocialMediaUsername());
			ps.setString(6, smt.getSocialMediaPassword());
			ps.setString(7, smt.getSocialMediaExplanation());
			ps.setString(8, smt.getTypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	public int insertToBankTable(BankTable bt) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userBankServices` (`username`, `useremail`, `userBankName`,`userBankCardNumber`,`userBankCardName`,`userBankLastDate`,`userBankExpirationDate`,`userBankExplain`,`usertypeofencrypt`) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, bt.getUsername());
			ps.setString(2, bt.getUseremail());
			ps.setString(3, bt.getBankname());
			ps.setString(4, bt.getBankcardnumber());
			ps.setString(5, bt.getBankcardname());
			ps.setString(6, bt.getBanklastdate());
			ps.setString(7, bt.getBankexpirationdate());
			ps.setString(8, bt.getBankexplain());
			ps.setString(9, bt.getUsertypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	
	
	
}
