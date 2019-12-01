package model;

public class BankTable {
	private int identifyofDB;
	private int id;
	private String useremail;
	private String bankname;
	private String bankcardnumber;
	private String bankcardname;
	private String banklastdate;
	private String bankexpirationdate;
	private String bankexplain;
	private String usertypeofencrypt;
	
	public BankTable() {}
	
	public BankTable(int identifyofDB,int id,String useremail,String bankname,String bankcardnumber,String bankcardname,String banklastdate,String bankexpirationdate,String bankexplain,String usertypeofencrypt) {
		this.identifyofDB = identifyofDB;
		this.id = id;
		this.useremail = useremail;
		this.bankname = bankname;
		this.bankcardnumber = bankcardnumber;
		this.bankcardname = bankcardname;
		this.banklastdate = banklastdate;
		this.bankexpirationdate = bankexpirationdate;
		this.bankexplain = bankexplain;
		this.usertypeofencrypt = usertypeofencrypt;
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
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankcardnumber() {
		return bankcardnumber;
	}
	public void setBankcardnumber(String bankcardnumber) {
		this.bankcardnumber = bankcardnumber;
	}
	public String getBankcardname() {
		return bankcardname;
	}
	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}
	public String getBanklastdate() {
		return banklastdate;
	}
	public void setBanklastdate(String banklastdate) {
		this.banklastdate = banklastdate;
	}
	public String getBankexpirationdate() {
		return bankexpirationdate;
	}
	public void setBankexpirationdate(String bankexpirationdate) {
		this.bankexpirationdate = bankexpirationdate;
	}
	public String getBankexplain() {
		return bankexplain;
	}
	public void setBankexplain(String bankexplain) {
		this.bankexplain = bankexplain;
	}
	public String getUsertypeofencrypt() {
		return usertypeofencrypt;
	}
	public void setUsertypeofencrypt(String usertypeofencrypt) {
		this.usertypeofencrypt = usertypeofencrypt;
	}
	
	
	
	
}
