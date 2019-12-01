package model;

public class User {
	private int userid;
	private String emailAdress;
	private String userAdminPassword;
	private String userAdminPhone;
	private String userAdminCreateDate;
	private String userAccesMail;
	private String userpremiumid;
	
	
	public User() {
		
	}
	
	public User(String emailAdress, String userAdminPassword, String userAdminPhone,String userAdminCreateDate, String userAccesMail) {	
		this.emailAdress = emailAdress;
		this.userAdminPassword = userAdminPassword;
		this.userAdminPhone = userAdminPhone;
		this.userAdminCreateDate = userAdminCreateDate;
		this.userAccesMail = "123456";
	}
	public User(int userid,String emailAdress, String userAdminPassword, String userAdminPhone,String userAdminCreateDate, String userAccesMail) {	
		this.userid = userid;
		this.emailAdress = emailAdress;
		this.userAdminPassword = userAdminPassword;
		this.userAdminPhone = userAdminPhone;
		this.userAdminCreateDate = userAdminCreateDate;
		this.userAccesMail = userAccesMail;
		this.userpremiumid = "123456";
	}

	

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getUserAdminPassword() {
		return userAdminPassword;
	}

	public void setUserAdminPassword(String userAdminPassword) {
		this.userAdminPassword = userAdminPassword;
	}

	public String getUserAdminPhone() {
		return userAdminPhone;
	}

	public void setUserAdminPhone(String userAdminPhone) {
		this.userAdminPhone = userAdminPhone;
	}

	public String getUserAdminCreateDate() {
		return userAdminCreateDate;
	}

	public void setUserAdminCreateDate(String userAdminCreateDate) {
		this.userAdminCreateDate = userAdminCreateDate;
	}

	public String getUserAccesMail() {
		return userAccesMail;
	}

	public void setUserAccesMail(String userAccesMail) {
		this.userAccesMail = userAccesMail;
	}
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserpremiumid() {
		return userpremiumid;
	}

	public void setUserpremiumid(String userpremiumid) {
		this.userpremiumid = userpremiumid;
	}
	
	

}
