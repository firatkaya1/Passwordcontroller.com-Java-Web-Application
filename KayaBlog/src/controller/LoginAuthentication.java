package controller;


public class LoginAuthentication {
	
	private String username;
	private String password;
	private String email;
	private String type;
	private String useragent;
	
	
	UserLoginDB userAdminLoginDB;
	
	public LoginAuthentication(String username, String password,String email,String type,String useragent) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.useragent = useragent;
	}
	
	public boolean verify() {
		boolean controll= false;
		
		if(isEmpty() && verifyInformations()) {
			controll = true;
		}
		
		return controll;
	}
	
	public boolean isEmpty() {
		
		if(username.isEmpty()) {
			return false;
		}
		if(password.isEmpty()) {
			return false;
		}
		if(email.isEmpty()) {
			return false;
		}
		if(type.isEmpty()) {
			return false;
		}
		if(!type.equals("Login")) {
			return false;
		}
		
		return true;
	}
	
	public boolean verifyInformations() {
		userAdminLoginDB = new UserLoginDB();
		return userAdminLoginDB.verify(username, password, email, type, useragent);
	}


}
