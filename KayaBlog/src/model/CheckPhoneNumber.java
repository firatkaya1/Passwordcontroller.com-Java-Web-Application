package model;

import java.util.ArrayList;
import java.util.List;

public class CheckPhoneNumber {
	
	private String phoneNumber;
	private ArrayList<String> errorList = new ArrayList<String>();
	
	public CheckPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
	}
	
	public boolean controll() {
		boolean controll = true;
		
		
		if(!isNull()) return false;
		if(!isOnlyNumber()) return false;
		if(!phoneNumberLenght()) return false;
		
		
		
		return controll;
	}
	
	public boolean isNull() {
		if(phoneNumber.isEmpty()) {
			errorList.add("Phone number can not be null.");
			return false;
		}
		return true;
	}
	
	public boolean isOnlyNumber() {
		for(int i=0;i<phoneNumber.length();i++) {
			if(!Character.isDigit(phoneNumber.charAt(i))) {
				errorList.add("*Phone numbers must contains only number.");
				return false;
			}
				
		}
		return true;
		
	}

	public boolean phoneNumberLenght() {

		
		if(phoneNumber.length()>10 && phoneNumber.length()<12) 
			return true;
			
		errorList.add("*Phone number must be 11 character.");
		return false;
		
	}
	
	public List<String> errorList(){
		return errorList;
	}
}
