package model;

public class TelephoneDirectoryTable {
	private int identifyofDB;
	private int id;
	private String username;
	private String useremail;
	private String phonenumbertype;
	private String phoneownername;
	private String phonenumber;
	private String phonexplain;
	private String typeofencrypt;
	
	public TelephoneDirectoryTable() {}
	
	public TelephoneDirectoryTable(int identifyofDB,int id,String username,String useremail,String phonenumbertype,String phoneownername,String phonenumber,String phonexplain,String typeofencrypt) {
		this.identifyofDB = identifyofDB;
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.phonenumbertype = phonenumbertype;
		this.phoneownername = phoneownername;
		this.phonenumber = phonenumber;
		this.phonexplain = phonexplain;
		this.typeofencrypt = typeofencrypt;
	}
	
	
	public int getIdentifyofDB() {
		return identifyofDB;
	}
	public void setIdentifyofDB(int identifyofDB) {
		this.identifyofDB = identifyofDB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhonenumbertype() {
		return phonenumbertype;
	}
	public void setPhonenumbertype(String phonenumbertype) {
		this.phonenumbertype = phonenumbertype;
	}
	public String getPhoneownername() {
		return phoneownername;
	}
	public void setPhoneownername(String phoneownername) {
		this.phoneownername = phoneownername;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPhonexplain() {
		return phonexplain;
	}
	public void setPhonexplain(String phonexplain) {
		this.phonexplain = phonexplain;
	}
	public String getTypeofencrypt() {
		return typeofencrypt;
	}
	public void setTypeofencrypt(String typeofencrypt) {
		this.typeofencrypt = typeofencrypt;
	}
	
	

}
