package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.SendMail;
import model.BankTable;
import model.BasicTable;
import model.BrowserInformations;
import model.EmailTable;
import model.MailModels;
import model.SocialMediaTable;
import model.TelephoneDirectoryTable;

public class UpdateDB {
	static Connection conn;
	static PreparedStatement ps;
	
	
	public int updateToBasicTable(BasicTable bt) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userBasicTable set id=?, useremail=?, userShowType=?, userShowEmail=?, userShowUsername=?, userShowPassword=?, userShowExplanation=? where id="+bt.getIdentifyofDB());                     
			
			ps.setInt(1,bt.getIdentifyofDB());
			ps.setString(2,bt.getUseremail());
			ps.setString(3,bt.getUserShowtype());
			ps.setString(4,bt.getUserShowEmail());
			ps.setString(5,bt.getUserShowUsername());
			ps.setString(6,bt.getUserShowpassword());
			ps.setString(7,bt.getUserShowExplanation());
			
			status = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public int updateToEmailTable(EmailTable et) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userEmailServices set id=?, useremailadress=?, userEmailType=?, userEmailServicesAdress=?, userEmailServicesPassword=?, userEmailServicesExplanations=? where id="+et.getIdentifyofDB());                     
			
			ps.setInt(1, et.getIdentifyofDB());
			ps.setString(2, et.getUseremailadress());
			ps.setString(3, et.getUserEmailType());
			ps.setString(4, et.getUserEmailServicesAdress());
			ps.setString(5, et.getUserEmailServicesPass());
			ps.setString(6, et.getUserEmailServicesExplana());
			
			status = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public int updateToSocialMediaTable(SocialMediaTable smt) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userSocialMedia set id=?, useremailadress=?, userSocialMediaType=?, userSocialMediasEmail=?, userSocialMediaUsername=?, userSocialMediaPassword=?, userSocialMediaExplanations=? where id="+smt.getIdentifyofDB());                     
			
			ps.setInt(1,smt.getIdentifyofDB());
			ps.setString(2,smt.getUseremailadress());
			ps.setString(3,smt.getSocialMediaType());
			ps.setString(4,smt.getSocialMediaEmail());
			ps.setString(5,smt.getSocialMediaUsername());
			ps.setString(6,smt.getSocialMediaPassword());
			ps.setString(7,smt.getSocialMediaExplanation());
			
			status = ps.executeUpdate();
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
		
	}
	
	public int updateToBankTable(BankTable bt) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn(); 
			ps = conn.prepareStatement("Update newsdata.userBankServices set id=?, useremail=?, userBankName=?, userBankCardNumber=?, userBankCardName=?, userBankExpirationDate=?,userBankExplain=? where id="+bt.getIdentifyofDB());                     
			
			ps.setInt(1, bt.getIdentifyofDB());
			ps.setString(2, bt.getUseremail());
			ps.setString(3, bt.getBankname());
			ps.setString(4, bt.getBankcardnumber());
			ps.setString(5, bt.getBankcardname());
			ps.setString(6, bt.getBankexpirationdate());
			ps.setString(7, bt.getBankexplain());
			
			status = ps.executeUpdate();
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
		
	}
	
	public int updateToPhoneTable(TelephoneDirectoryTable tdt) {
		int status = 0;
		
		try {
			conn =ConnectionHelper.getConn();   //`username`, `useremail`, `userPhoneType`,`userPhoneOwnerName`,`userPhoneNumber`,`userPhoneExplain`,`usertypeofencrypt`
			ps = conn.prepareStatement("Update newsdata.userPhoneDirectory set id=?, useremail=?, userPhoneType=?, userPhoneOwnerName=?, userPhoneNumber=?, userPhoneExplain=? where id="+tdt.getIdentifyofDB());                     
			ps.setInt(1, tdt.getIdentifyofDB());
			ps.setString(2, tdt.getUseremail());
			ps.setString(3, tdt.getPhonenumbertype());
			ps.setString(4, tdt.getPhoneownername());
			ps.setString(5, tdt.getPhonenumber());
			ps.setString(6, tdt.getPhonexplain());
			
			status = ps.executeUpdate();
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
		
	}
	public int updatePassword(String email,String password,String userAgent) {
		int status = 0;
		
		try {
			System.out.println("Update Fonksiyonu çalışti.");
			conn =ConnectionHelper.getConn();  
			ps = conn.prepareStatement("Update newsdata.userInformation set userAdminPassword=? where userAdminEmail='"+email+"' ");     
			ps.setString(1, password);
			
			status = ps.executeUpdate();
			if(status == 1) {
				// update is succesfull, SEND MAİL 
				
				
				ps = conn.prepareStatement("SELECT * FROM `userInformation` where `userAdminEmail` = ?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("userAdminEmail"));
					if(email.equals(rs.getString("userAdminEmail"))) {
						System.out.println(rs.getString("userAdminName"));
						String username = rs.getString("userAdminName");
						BrowserInformations b = new BrowserInformations(userAgent);
						
						MailModels mm = new MailModels(email,username,password,b.getBrowsername(),b.getOperatingSystem(),b.getUserIp(),b.getDate());
						String template = mm.getResetpassword();
						
						SendMail sm = new SendMail(email,template);
						sm.sendMail();
					}
				}
			}
			
			
			conn.close();
			ps.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		return status;
	}
	
}
