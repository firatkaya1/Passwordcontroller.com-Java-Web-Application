package model;

import java.util.ArrayList;

import controller.UserRegisterDB;

public class Check {
	
	private String email;
	
	private CheckEmail ce;
	private CheckPassword cp;
	private CheckPhoneNumber cpn;
	private CheckPrivacyPoliticy cpp;
	
	UserRegisterDB userRegisterDB;
	
	ArrayList<String> errorList = new ArrayList<String>();
	
	public Check(String email,String password, String repassword, String phonenumber,String privacypolitic) {
		this.email = email;
		
		userRegisterDB = new UserRegisterDB();
		ce = new CheckEmail(email);
		cp = new CheckPassword(password, repassword);
		cpn = new CheckPhoneNumber(phonenumber);
		cpp = new CheckPrivacyPoliticy(privacypolitic);
	}
	
	public boolean verify() {
		if(controll() && !userRegisterDB.verify(email)) {
			return true;
		} else if(userRegisterDB.verify(email)){
			errorList.add("Email  has already taken.");
			return false;
		} else {
			return false;
		}
	}
	
	public boolean controll() {
		boolean controll = true;
		
		if(!ce.controll())  {
			errorList.addAll(ce.errorList());
			System.out.println("controll  : "+cp.controll());
			controll = false;
		}
		if(!cp.controll()) {
			errorList.addAll(cp.errorList());
			System.out.println("controll password : "+!cp.controll());
			controll = false;
		}
		if(!cpn.controll()) {
			errorList.addAll(cpn.errorList());
			System.out.println("cpn  : "+!cp.controll());
			controll = false;
		}
		if(!cpp.controll())  {
			errorList.addAll(cpp.errorList());
			System.out.println("cpp  : "+!cpp.controll());
			controll = false;
		}
		
		return controll;
	}
	
	public ArrayList<String> errorListAll() {
		
		return errorList;
	}

}
