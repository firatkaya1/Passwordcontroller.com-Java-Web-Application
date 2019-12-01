package controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	public String template;
	public String receipent;
	
	private static String myAccountEmail =	 "noreply@passwordcontroller.com";
	private static String password = "9S1DEVLXKBiX";
	
	public SendMail(String receipent,String template) {
		this.receipent = receipent;
		this.template = template;
		
	}
	
	public  void sendMail() throws Exception {
		
		System.out.println("Preparing to send 	email");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "mail.passwordcontroller.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session);	
		
		Transport.send(message);
		System.out.println("Message sent succesfully");
	}
	
	private   Message prepareMessage(Session session) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipent));
			message.setSubject("Reset Password");
			message.setText("Reset Password");
			message.setContent(template,"text/html");
			
			
			return 	message;
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
