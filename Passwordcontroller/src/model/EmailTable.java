package model;

public class EmailTable {
	private int IdentifyofDB;
	private int id;
	private String username;
	private String useremailadress;
	private String userEmailType;
	private String userEmailServicesAdress;
	private String userEmailServicesPass;
	private String userEmailServicesExplana;
	private String typeofencrypt;
	
	
	
	public EmailTable() {
		
		
	}
	public EmailTable(String username,String useremailadress,String userEmailType,String userEmailServicesAdress,String userEmailServicesPass,String userEmailServicesExplana,String typeofencrypt) {                         
		this.username = username;
		this.useremailadress = useremailadress;
		this.userEmailType = userEmailType;
		this.userEmailServicesAdress = userEmailServicesAdress;
		this.userEmailServicesPass = userEmailServicesPass;
		this.userEmailServicesExplana = userEmailServicesExplana;
		this.typeofencrypt = typeofencrypt;
		
	}
	public EmailTable(int IdentifyofDB,String username,String useremailadress,String userEmailType,String userEmailServicesAdress,String userEmailServicesPass,String userEmailServicesExplana) {                         
		this.IdentifyofDB = IdentifyofDB;
		this.username = username;
		this.useremailadress = useremailadress;
		this.userEmailType = userEmailType;
		this.userEmailServicesAdress = userEmailServicesAdress;
		this.userEmailServicesPass = userEmailServicesPass;
		this.userEmailServicesExplana = userEmailServicesExplana;
		
	}
	public int getIdentifyofDB() {
		return IdentifyofDB;
	}
	public void setIdentifyofDB(int identifyofDB) {
		IdentifyofDB = identifyofDB;
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
	public String getUserEmailType() {
		return userEmailType;
	}
	public void setUserEmailType(String userEmailType) {
		this.userEmailType = userEmailType;
	}
	public String getUserEmailServicesAdress() {
		return userEmailServicesAdress;
	}
	public void setUserEmailServicesAdress(String userEmailServicesAdress) {
		this.userEmailServicesAdress = userEmailServicesAdress;
	}
	public String getUserEmailServicesPass() {
		return userEmailServicesPass;
	}
	public void setUserEmailServicesPass(String userEmailServicesPass) {
		this.userEmailServicesPass = userEmailServicesPass;
	}
	public String getUserEmailServicesExplana() {
		return userEmailServicesExplana;
	}
	public void setUserEmailServicesExplana(String userEmailServicesExplana) {
		this.userEmailServicesExplana = userEmailServicesExplana;
	}
	public String getTypeofencrypt() {
		return typeofencrypt;
	}
	public void setTypeofencrypt(String typeofencrypt) {
		this.typeofencrypt = typeofencrypt;
	}
	
	
}
