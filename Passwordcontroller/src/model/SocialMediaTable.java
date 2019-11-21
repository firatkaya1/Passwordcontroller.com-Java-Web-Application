package model;

public class SocialMediaTable {
	private int identifyofDB;
	private int id;
	private String username;
	private String useremailadress;
	private String socialMediaType;
	private String socialMediaEmail;
	private String socialMediaUsername;
	private String socialMediaPassword;
	private String socialMediaExplanation;
	private String typeofencrypt;
	
	public SocialMediaTable() {
		
	}
	public SocialMediaTable(String username,String useremailadress,String socialMediaType,String socialMediaEmail,String socialMediaUsername,String socialMediaPassword,String socialMediaExplanation,String typeofencrypt) {
		this.username = username;
		this.useremailadress = useremailadress;
		this.socialMediaType = socialMediaType;
		this.socialMediaEmail = socialMediaEmail;
		this.socialMediaUsername = socialMediaUsername;
		this.socialMediaPassword = socialMediaPassword;
		this.socialMediaExplanation = socialMediaExplanation;
		this.typeofencrypt = typeofencrypt;
		
	}
	public SocialMediaTable(int identifyofDB,int id,String username,String useremailadress,String socialMediaType,String socialMediaEmail,String socialMediaUsername,String socialMediaPassword,String socialMediaExplanation,String typeofencrypt) {
		this.identifyofDB = identifyofDB;
		this.id = id;
		this.username = username;
		this.useremailadress = useremailadress;
		this.socialMediaType = socialMediaType;
		this.socialMediaEmail = socialMediaEmail;
		this.socialMediaUsername = socialMediaUsername;
		this.socialMediaPassword = socialMediaPassword;
		this.socialMediaExplanation = socialMediaExplanation;
		this.typeofencrypt = typeofencrypt;
		
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
	public String getUseremailadress() {
		return useremailadress;
	}
	public void setUseremailadress(String useremailadress) {
		this.useremailadress = useremailadress;
	}
	public String getSocialMediaType() {
		return socialMediaType;
	}
	public void setSocialMediaType(String socialMediaType) {
		this.socialMediaType = socialMediaType;
	}
	public String getSocialMediaEmail() {
		return socialMediaEmail;
	}
	public void setSocialMediaEmail(String socialMediaEmail) {
		this.socialMediaEmail = socialMediaEmail;
	}
	public String getSocialMediaUsername() {
		return socialMediaUsername;
	}
	public void setSocialMediaUsername(String socialMediaUsername) {
		this.socialMediaUsername = socialMediaUsername;
	}
	public String getSocialMediaPassword() {
		return socialMediaPassword;
	}
	public void setSocialMediaPassword(String socialMediaPassword) {
		this.socialMediaPassword = socialMediaPassword;
	}
	public String getSocialMediaExplanation() {
		return socialMediaExplanation;
	}
	public void setSocialMediaExplanation(String socialMediaExplanation) {
		this.socialMediaExplanation = socialMediaExplanation;
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
	
	
	
}
