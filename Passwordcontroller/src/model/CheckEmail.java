package model;

import java.util.ArrayList;

public class CheckEmail {

	private String email;
	private ArrayList<String> errorList = new ArrayList<String>();
	
	public CheckEmail(String email) {
		this.email = email;
	}
	public boolean controll() {
		boolean controll = true;
		
		if(!isNull()) return false;
		
		return controll;
	}
	
	public boolean isNull() {
		if(email.isEmpty()) {
			errorList.add("*Email can not be blank.");
			return false;
		}
		return true;
	}
	
	public ArrayList<String> errorList() {
		return errorList;
	}
	
	
	
}
