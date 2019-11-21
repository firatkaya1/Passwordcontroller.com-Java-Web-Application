package model;

import java.util.ArrayList;
import java.util.List;

public class CheckUsername {
	private String username;
	private ArrayList<String> errorList = new ArrayList<String>();
	
	public CheckUsername(String username) {
		this.username = username;
		
	}
	public boolean controll() {
		boolean controll = true;
		
		
		if(!isNull()) return false;
		if(!usernameLenght()) return false;
		if(!usernameUppercase()) return false;
		if(!usernameLowercase()) return false;
		
		
		return controll;
	}
	//username check null
	public boolean isNull() {
		if(username.isEmpty()) {
			errorList.add("*Username cant be null.");
			return false;
		}
		return true;
	}	
	
	// Username's length has to longer than 8.
	public boolean usernameLenght() {
		if(username.length()<8) {
			errorList.add("*Username lenght must have alleast 8 character.");
			return false;
		}
		
		return true;
	}
	
	//Username has to be one or more uppercase character.
	public boolean usernameUppercase() {
		for(int i=0;i<username.length();i++) {
			if(Character.isUpperCase(username.charAt(i))) 
				return true;
			
		}
		errorList.add("*Username must have at least one uppercase character.");
		return false;
	}
	
	//Username has to be one or more lowercase character.
	public boolean usernameLowercase() {

		for(int i=0;i<username.length();i++) {
			if(Character.isLowerCase(username.charAt(i))) 
				return true;
		}
		
		errorList.add("*Username must have at least one lowercase character.");
		return false;
		
	}	

	public List<String> errorList(){
		return errorList;
	}
}
