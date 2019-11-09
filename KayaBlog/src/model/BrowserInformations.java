package model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class BrowserInformations {
	private String browsername;
	private String OperatingSystem;
	private String userAgent;
	private String userİpAdress;
	
	public BrowserInformations(String userAgent) {
		userİpAdress = "0.0.0.0.0";
		this.userAgent = userAgent.toLowerCase();
	}

	public String getBrowsername() {
		String[] browsers = {"firefox","opera","safari","opr","chrome","edge","chromium","FIREFOX","Firefox"};
		
		String userag = getUserAgent();
		
		for(int i=0;i<browsers.length;i++) {
			if(userag.contains(browsers[i])) {
				browsername=browsers[i];
				browsername = browsername.substring(0, 1).toUpperCase()+ browsername.substring(1);
				System.out.println("Browser name : "+browsername);
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

	public String getUserİp() throws UnknownHostException, SocketException {
		
		try(final DatagramSocket socket = new DatagramSocket()){
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			userİpAdress= socket.getLocalAddress().getHostAddress();
		}
		  return userİpAdress;
		
	}
	

}
