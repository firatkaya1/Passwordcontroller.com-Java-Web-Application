package model;

public class BasicTable {
	private int userid;
	private String username;
	private String useremail;
	private String userShowtype;
	private String userShowEmail;
	private String userShowpassword;
	private String userShowExplanation;
	
	public BasicTable() {}

	public BasicTable(int userid,String username,String useremail,String userShowtype,String userShowEmail,String userShowpassword,String userShowExplanation) {
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userShowtype = userShowtype;
		this.userShowEmail = userShowEmail;
		this.userShowpassword = userShowpassword;
		this.userShowExplanation = userShowExplanation;
		
	}

	public String getUserShowtype() {
		return userShowtype;
	}


	public void setUserShowtype(String userShowtype) {
		this.userShowtype = userShowtype;
	}


	public String getUserShowEmail() {
		return userShowEmail;
	}


	public void setUserShowEmail(String userShowEmail) {
		this.userShowEmail = userShowEmail;
	}


	public String getUserShowpassword() {
		return userShowpassword;
	}


	public void setUserShowpassword(String userShowpassword) {
		this.userShowpassword = userShowpassword;
	}


	public String getUserShowExplanation() {
		return userShowExplanation;
	}


	public void setUserShowExplanation(String userShowExplanation) {
		this.userShowExplanation = userShowExplanation;
	}
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
