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
	
	public List<String> errorList(){
		return errorList;
	}
}
