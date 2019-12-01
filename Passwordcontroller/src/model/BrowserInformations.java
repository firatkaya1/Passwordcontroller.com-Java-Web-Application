package model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BrowserInformations {
	private String browsername;
	private String OperatingSystem;
	private String userAgent;
	private String userIpAdress;
	
	public BrowserInformations(String userAgent) {
		userIpAdress = "0.0.0.0.0";
		this.userAgent = userAgent.toLowerCase();
	}

	public String getBrowsername() {
		String[] browsers = {"firefox","opera","safari","opr","chrome","edge","chromium","FIREFOX","Firefox"};
		
		String userag = getUserAgent();
		
		for(int i=0;i<browsers.length;i++) {
			if(userag.contains(browsers[i])) {
				browsername=browsers[i];
				browsername = browsername.substring(0, 1).toUpperCase()+ browsername.substring(1);
				
			}
			
		}
	
		return browsername;
	}

	public String getOperatingSystem() {
		String[] os = {"unix","windows","android","iphone","mac","linux"};
		
		String userag = getUserAgent();
		
		for(int i=0;i<os.length;i++) {
			if(userag.contains(os[i])) {
				OperatingSystem=os[i];
				OperatingSystem = OperatingSystem.substring(0, 1).toUpperCase()+ OperatingSystem.substring(1);
			}
			else {
				OperatingSystem = "UNKNOWN";
			}
		}
		
		return OperatingSystem;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getUserIp() throws UnknownHostException, SocketException {
		
		try(final DatagramSocket socket = new DatagramSocket()){
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			userIpAdress= socket.getLocalAddress().getHostAddress();
		}
		  return userIpAdress;
		
	}
	public String getDate() {
		return new SimpleDateFormat("yyyy/MM/dd | HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	

}
