package model;

import java.util.ArrayList;

public class Check {
	

	private CheckEmail ce;
	private CheckUsername cun;
	private CheckPassword cp;
	private CheckPhoneNumber cpn;
	private CheckPrivacyPoliticy cpp;
	
	 ArrayList<String> errorList = new ArrayList<String>();
	
	public Check(String userAdminName,String userAdminPassword, String userAdminPassword2, String userAdminPhone,String userAdminEmail,String userPrivacyPoliticy) {
		
		ce = new CheckEmail(userAdminEmail);
		cp = new CheckPassword(userAdminPassword, userAdminPassword2);
		cpn = new CheckPhoneNumber(userAdminPhone);
		cun = new CheckUsername(userAdminName);
		cpp = new CheckPrivacyPoliticy(userPrivacyPoliticy);
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
