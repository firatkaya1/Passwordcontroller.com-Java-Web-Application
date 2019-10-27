package model;

public class SocialMediaTable {
	private int id;
	private String username;
	private String useremailadress;
	private String socialMediaType;
	private String socialMediaEmail;
	private String socialMediaUsername;
	private String socialMediaPassword;
	private String socialMediaExplanation;
	
	public SocialMediaTable() {
		
	}
	public SocialMediaTable(String username,String useremailadress,String socialMediaType,String socialMediaEmail,String socialMediaUsername,String socialMediaPassword,String socialMediaExplanation) {
		this.username = username;
		this.useremailadress = useremailadress;
		this.socialMediaType = socialMediaType;
		this.socialMediaEmail = socialMediaEmail;
		this.socialMediaUsername = socialMediaUsername;
		this.socialMediaPassword = socialMediaPassword;
		this.socialMediaExplanation = socialMediaExplanation;
		
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
	
	
	
}
