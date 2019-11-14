package model;

import java.util.ArrayList;

import controller.UserRegisterDB;

public class Check {
	
	private String username;
	private String email;
	
	private CheckEmail ce;
	private CheckUsername cun;
	private CheckPassword cp;
	private CheckPhoneNumber cpn;
	private CheckPrivacyPoliticy cpp;
	
	UserRegisterDB userRegisterDB;
	
	ArrayList<String> errorList = new ArrayList<String>();
	
	public Check(String username,String password, String repassword, String phonenumber,String email,String privacypolitic) {
		this.username = username;
		this.email = email;
		
		userRegisterDB = new UserRegisterDB();
		ce = new CheckEmail(email);
		cp = new CheckPassword(password, repassword);
		cpn = new CheckPhoneNumber(phonenumber);
		cun = new CheckUsername(username);
		cpp = new CheckPrivacyPoliticy(privacypolitic);
	}
	
	public boolean verify() {
		
		if(controll() && userRegisterDB.verify(email, username)) {
			return true;
		}
		errorList.add("Email or username has already taken.");
		
		
		return false;
	}
	
	public boolean controll() {
		boolean controll = true;
		
		if(!ce.controll()) return false;
		if(!cp.controll()) return false;
		if(!cpn.controll()) return false;
		if(!cun.controll()) return false;
		if(!cpp.controll()) return false;
		
		return controll;
	}
	
	public ArrayList<String> errorListAll() {
		
		errorList.addAll(ce.errorList());
		errorList.addAll(cun.errorList());
		errorList.addAll(cpn.errorList());
		errorList.addAll(cp.errorList());
		errorList.addAll(cpp.errorList());
		
		
		return errorList;
	}

}
