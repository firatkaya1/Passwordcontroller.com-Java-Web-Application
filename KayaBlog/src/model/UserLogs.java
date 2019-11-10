package model;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserLogs {
	private int id;
	private String username;
	private String useremailadress;
	private String userlogtype;
	private String userOs;
	private String userBrowser;
	private String userİpAdress;
	private String userLogDate;

	BrowserInformations browser;
	
	public UserLogs() {
		
	}
	
	public UserLogs(String username,String useremailadress,String userlogtype,BrowserInformations browser) throws UnknownHostException, SocketException {
		this.browser = browser;
		this.username = username;
		this.useremailadress = useremailadress;
		this.userlogtype = userlogtype;
		this.userOs = browser.getOperatingSystem();
		this.userBrowser = browser.getBrowsername();
		this.userİpAdress = browser.getUserİp();
		this.userLogDate = new SimpleDateFormat("yyyy/MM/dd | HH:mm:ss").format(Calendar.getInstance().getTime());
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
	public String getUserlogtype() {
		return userlogtype;
	}
	public void setUserlogtype(String userlogtype) {
		this.userlogtype = userlogtype;
	}
	public String getUserOs() {
		return userOs;
	}
	public void setUserOs(String userOs) {
		this.userOs = userOs;
	}
	public String getUserİpAdress() {
		return  userİpAdress;
	}
	public void setUserİpAdress(String userİpAdress) {
		this.userİpAdress = userİpAdress;
	}
	public String getUserLogDate() {
		return userLogDate;
	}
	public void setUserLogDate(String userLogDate) {
		this.userLogDate = userLogDate;
	}
	public String getUserBrowser() {
		return userBrowser;
	}
	public void setUserBrowser(String userBrowser) {
		this.userBrowser = userBrowser;
	}
	
	
	

}
