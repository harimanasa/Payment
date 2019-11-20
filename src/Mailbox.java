 import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Properties;

 
@SuppressWarnings("serial")
public class Mailbox {
    protected void checkout(String email, String plan) {
//    }
//    
//    public static void main(String [] args) 
//    {	 

    	// email ID of Sender. 
    	String sender = "harimanasa17@gmail.com"; 

    	// using host as localhost 
    	String host = "localhost"; 

    	// Getting system properties 
    	Properties properties = System.getProperties(); 

    	// Setting up mail server 
    	properties.setProperty("mail.smtp.host", host); 
    	properties.setProperty("mail.smtp.port", "8081"); 

    	// creating session object to get properties 
    	Session session = Session.getDefaultInstance(properties); 

    	try
    	{ 
    		// MimeMessage object. 
    		MimeMessage message = new MimeMessage(session); 

    		// Set From Field: adding senders email to from field. 
    		message.setFrom(new InternetAddress(sender)); 

    		// Set To Field: adding recipient's email to from field. 
    		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 

    		// Set Subject: subject of the email 
    		message.setSubject("The selected plan is: "+plan); 

    		// set body of the email. 
    		message.setText("This is a billing mail"); 

    		// Send email. 
    		Transport.send(message); 
    		System.out.println("Mail successfully sent"); 
    	} 
    	catch (MessagingException mex) 
    	{ 
    		mex.printStackTrace(); 
    	} 
    	
  
      }
    
    public static void main(String [] args) {
  	// email ID of Sender. 
  	String sender = "harimanasa17@gmail.com"; 

  	// using host as localhost 
  	String host = "localhost"; 

  	// Getting system properties 
  	Properties properties = System.getProperties(); 

  	// Setting up mail server 
  	properties.setProperty("mail.smtp.host", host); 
  	properties.setProperty("mail.smtp.port", "8081"); 

  	// creating session object to get properties 
  	Session session = Session.getDefaultInstance(properties); 

  	try
  	{ 
  		// MimeMessage object. 
  		MimeMessage message = new MimeMessage(session); 

  		// Set From Field: adding senders email to from field. 
  		message.setFrom(new InternetAddress(sender)); 

  		// Set To Field: adding recipient's email to from field. 
  		message.addRecipient(Message.RecipientType.TO, new InternetAddress("manasa.hari@sjsu.edu")); 

  		// Set Subject: subject of the email 
  		message.setSubject("The selected plan is: basic "); 

  		// set body of the email. 
  		message.setText("This is a billing mail"); 

  		// Send email. 
  		Transport.send(message); 
  		System.out.println("Mail box is on now"); 
  	} 
  	catch (MessagingException mex) 
  	{ 
  		mex.printStackTrace(); 
  	} 
  	

    }
}