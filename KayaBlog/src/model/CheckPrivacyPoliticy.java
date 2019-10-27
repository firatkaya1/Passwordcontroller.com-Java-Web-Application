package model;

import java.util.ArrayList;

public class CheckPrivacyPoliticy {
	
	private String privacy;
	private ArrayList<String> errorList = new ArrayList<String>();
	
	public CheckPrivacyPoliticy(String privacy) {
		this.privacy = privacy;
		
	}
	public boolean controll() {
		boolean controll = true;
		
		if(!isNull()) return false;
		
		return controll;
	}
	public boolean isNull() {
		if(privacy == null) {
			errorList.add("You have to accept to Term of Use.");
			return false;
		}
	return true;
		
	}
	
	public ArrayList<String> errorList() {
		return errorList;
		
	}
	
}
