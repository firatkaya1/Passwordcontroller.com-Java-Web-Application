package model;

import java.util.ArrayList;
import java.util.List;

public class CheckPassword{

	private String password;
	private String password2;
	private ArrayList<String> errorList = new ArrayList<String>();
	
	// This class check the ınformation from register.jsf
	// İf you want to create a password, You have to obey some password rules.
	// rule 1 : Password can't null.
	// rule 2 : Password can't shorter than 8.
	// rule 3 : password1 and password2 have to equals.
	// rule 4 : The password must contain one or more uppercase letters.
	// rule 5 : The password must contain one or more lowercase letters.
	// rule 6 : The password must contain one or more number.
	
	public CheckPassword(String password,String password2) {
		this.password = password;
		this.password2 = password2;
		
	}
	
	public boolean controll() {
		boolean controll = true;
		
		if(!isNull()) return false;
		if(!compareTwoPassword()) return false;
		if(!passwordLenght()) return  false;
		if(!passwordUppercase()) return false;
		if(!passwordLowercase()) return false;
		if(!passwordHasAnumber()) return false;
		
	
		
		return controll;
	}
	
	//password check null
	public boolean isNull() {
		if(password.isEmpty()) {
			errorList.add("Passwords cant be null.");
			return false;
		}
		return true;
	}
	
	// password1 and password2 has to be equal.
	public boolean compareTwoPassword() {
		if(password.equals(password2)) {
			return true;
		}
		errorList.add("Password and Re-Password does not match");
		return false;
	}
	
	// Password's length has to longer than 8.
	public boolean passwordLenght() {
		
		if(password.length()>=8) {
			return true;
		} else {
			errorList.add("*Password lenght must have at least 8 character");	
			return false;
		}
		
	}
	
	//Password has to be one or more uppercase character.
	public boolean passwordUppercase() {
		for(int i=0;i<password.length();i++) {
			if(Character.isUpperCase(password.charAt(i))) 
				return true;
			
		}
		errorList.add("*Password must have at least one uppercase character.");
		return false;
	}
	
	//Password has to be one or more lowercase character.
	public boolean passwordLowercase() {

		for(int i=0;i<password.length();i++) {
			if(Character.isLowerCase(password.charAt(i))) 
				return true;
		}
		errorList.add("*Password must have at least one lowercase character.");
		return false;
		
	}
	
	//Password has to be one or more number character.
	public boolean passwordHasAnumber() {
		
		for(int i=0;i<password.length();i++) {
			if(Character.isDigit(password.charAt(i))) 
				return true;
		}
		errorList.add("*Password must have at least one number.");
		return false;
	}
	
	public List<String> errorList(){
		return errorList;
	}
	
	
	
}
