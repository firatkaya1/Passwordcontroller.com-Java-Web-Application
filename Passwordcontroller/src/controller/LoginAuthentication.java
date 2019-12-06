package controller;


public class LoginAuthentication {
	
	private String useremail;
	private String password;
	private String type;
	private String useragent;
	
	
	UserLoginDB userAdminLoginDB;
	
	public LoginAuthentication(String useremail, String password,String useragent) {
		this.useremail = useremail;
		this.password = password;
		this.type = "Login";
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
		
		if(useremail.isEmpty()) {
			return false;
		}
		if(password.isEmpty()) {
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
		return userAdminLoginDB.verify(useremail,password, type, useragent);
	}


}
