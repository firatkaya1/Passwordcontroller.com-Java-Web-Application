package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.BankTable;
import model.BasicTable;
import model.EmailTable;
import model.SocialMediaTable;
import model.TelephoneDirectoryTable;
import model.UserLogs;

public class InsertDB {
	
	static Connection conn;
	static PreparedStatement ps;
	
	public int insertLog(UserLogs ul) {
		int status = 0;
		 
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userDate` (`userEmail`, `userLogType`,`userOS`,`userBrowser`,`useripAdress`,`userLogDate`,`userService`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1,ul.getUseremailadress());
			ps.setString(2,ul.getUserlogtype());
			ps.setString(3,ul.getUserOs());
			ps.setString(4,ul.getUserBrowser());
			ps.setString(5,ul.getUserIpAdress());
			ps.setString(6,ul.getUserLogDate());
			ps.setString(7, ul.getUserService());
			status = ps.executeUpdate();
			// close connections
			conn.close();
			ps.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int insertToBasicTable(BasicTable bt) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userBasicTable` (`useremail`, `userShowType`,`userShowEmail`,`userShowUsername`,`userShowPassword`,`userShowExplanation`,`userTypeOfEncrypt`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, bt.getUseremail());
			ps.setString(2, bt.getUserShowtype());
			ps.setString(3, bt.getUserShowEmail());
			ps.setString(4, bt.getUserShowUsername());
			ps.setString(5, bt.getUserShowpassword());
			ps.setString(6, bt.getUserShowExplanation());
			ps.setString(7, bt.getTypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int insertToEmailTable(EmailTable et) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userEmailServices` (`useremailadress`, `userEmailType`,`userEmailServicesAdress`,`userEmailServicesPassword`,`userEmailServicesExplanations`,`userTypeOfEncrypt`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, et.getUseremailadress());
			ps.setString(2, et.getUserEmailType());
			ps.setString(3, et.getUserEmailServicesAdress());
			ps.setString(4, et.getUserEmailServicesPass() );
			ps.setString(5, et.getUserEmailServicesExplana());
			ps.setString(6, et.getTypeofencrypt());
			
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
			ps=conn.prepareStatement("INSERT INTO `userSocialMedia` (`useremailadress`, `userSocialMediaType`,`userSocialMediasEmail`,`userSocialMediaUsername`,`userSocialMediaPassword`,`userSocialMediaExplanations`,`userSocialMediaTypeEncrypt`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, smt.getUseremailadress());
			ps.setString(2, smt.getSocialMediaType());
			ps.setString(3, smt.getSocialMediaEmail());
			ps.setString(4, smt.getSocialMediaUsername());
			ps.setString(5, smt.getSocialMediaPassword());
			ps.setString(6, smt.getSocialMediaExplanation());
			ps.setString(7, smt.getTypeofencrypt());
			
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
			ps=conn.prepareStatement("INSERT INTO `userBankServices` (`useremail`, `userBankName`,`userBankCardNumber`,`userBankCardName`,`userBankExpirationDate`,`userBankExplain`,`usertypeofencrypt`) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, bt.getUseremail());
			ps.setString(2, bt.getBankname());
			ps.setString(3, bt.getBankcardnumber());
			ps.setString(4, bt.getBankcardname());
			ps.setString(5, bt.getBankexpirationdate());
			ps.setString(6, bt.getBankexplain());
			ps.setString(7, bt.getUsertypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	
	public int insertToPhoneTable(TelephoneDirectoryTable tdt) {
		int status = 0;
		try {
			conn =ConnectionHelper.getConn();
			ps=conn.prepareStatement("INSERT INTO `userPhoneDirectory` (`useremail`, `userPhoneType`,`userPhoneOwnerName`,`userPhoneNumber`,`userPhoneExplain`,`usertypeofencrypt`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, tdt.getUseremail());
			ps.setString(2, tdt.getPhonenumbertype());
			ps.setString(3, tdt.getPhoneownername());
			ps.setString(4, tdt.getPhonenumber());
			ps.setString(5, tdt.getPhonexplain());
			ps.setString(6, tdt.getTypeofencrypt());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	
	
}
