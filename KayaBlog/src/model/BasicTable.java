package model;

public class BasicTable {
	private int identifyofDB;
	private int userid;
	private String username;
	private String useremail;
	private String userShowtype;
	private String userShowEmail;
	private String userShowUsername;
	private String userShowpassword;
	private String userShowExplanation;
	private String typeofencrypt;
	public BasicTable() {}

	public BasicTable(int userid,String username,String useremail,String userShowtype,String userShowEmail,String userShowUsername,String userShowpassword,String userShowExplanation) {
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userShowtype = userShowtype;
		this.userShowEmail = userShowEmail;
		this.userShowUsername = userShowUsername;
		this.userShowpassword = userShowpassword;
		this.userShowExplanation = userShowExplanation;
		
	}
	public BasicTable(int identifyofDB,int userid,String username,String useremail,String userShowtype,String userShowEmail,String userShowUsername,String userShowpassword,String userShowExplanation,String typeofencrypt) {
		this.identifyofDB = identifyofDB;
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userShowtype = userShowtype;
		this.userShowEmail = userShowEmail;
		this.userShowUsername = userShowUsername;
		this.userShowpassword = userShowpassword;
		this.userShowExplanation = userShowExplanation;
		this.typeofencrypt = typeofencrypt;
		
	}

	public int getIdentifyofDB() {
		return identifyofDB;
	}

	public void setIdentifyofDB(int identifyofDB) {
		this.identifyofDB = identifyofDB;
	}

	public String getTypeofencrypt() {
		return typeofencrypt;
	}

	public void setTypeofencrypt(String typeofencrypt) {
		this.typeofencrypt = typeofencrypt;
	}

	public String getUserShowUsername() {
		return userShowUsername;
	}

	public void setUserShowUsername(String userShowUsername) {
		this.userShowUsername = userShowUsername;
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
