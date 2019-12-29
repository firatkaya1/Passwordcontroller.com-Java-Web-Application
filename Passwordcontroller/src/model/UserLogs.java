package model;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserLogs {
	private int id;
	private String useremailadress;
	private String userlogtype;
	private String userOs;
	private String userBrowser;
	private String userIpAdress;
	private String userLogDate;
	private String userService;

	BrowserInformations browser;
	
	public UserLogs() {
		
	}

	
	public UserLogs(String useremailadress,String userlogtype,BrowserInformations browser,String userService) throws UnknownHostException, SocketException {
		this.browser = browser;
		this.useremailadress = useremailadress;
		this.userlogtype = userlogtype;
		this.userOs = browser.getOperatingSystem();
		this.userBrowser = browser.getBrowsername();
		this.userIpAdress = browser.getUserIp();
		this.userLogDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
		this.userService  = userService;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getUserIpAdress() {
		return  userIpAdress;
	}
	public void setUserIpAdress(String userİpAdress) {
		this.userIpAdress = userİpAdress;
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
	public String getUserService() {
		return userService;
	}
	public void setUserService(String userService) {
		this.userService = userService;
	}
	
	
	

}
