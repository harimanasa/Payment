 import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
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
import java.util.HashMap;
import java.util.Properties;

 
public class PaymentServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {
        	if(email.equals("manasa@123.com") && pass.equals("manasa")) {
                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
            } 
        	else if(email!=null && null==pass) {
        		HashMap<String, Integer> priceMap = new  HashMap<String, Integer>();
        		priceMap.put("basic", 10);
        		priceMap.put("premium", 12);
        		priceMap.put("pro", 15);
        		String plan = request.getParameter("plan");
        		System.out.println(plan);
        		   response.setContentType("text/html");
        		    PrintWriter out = response.getWriter();
        		    out.println("<h2> The selected plan is: " + plan + " </h2>"
        		    		+ "The payment details sent to: "+ email +
        		    		"</br> Total amount paid is : " + priceMap.get(plan) + "$.");
        		    out.close();
        	    	String sender = "CMPE273Project@sjsu.com"; 
        	    	String host = "localhost"; 
        	    	Properties properties = System.getProperties(); 
        	    	properties.setProperty("mail.smtp.host", host); 
        	    	properties.setProperty("mail.smtp.port", "8081");
        	    	Session session = Session.getDefaultInstance(properties); 
            		MimeMessage message = new MimeMessage(session); 
            		message.setFrom(new InternetAddress(sender)); 
            		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
            		message.setSubject("The selected plan is: "+request.getParameter("plan")); 
            		message.setText("This is a billing mail"); 
            		Transport.send(message); 
            		System.out.println("Mail successfully sent"); 

            }
        	else {

                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher("/invalidLogin.jsp");
                requestDispatcher.forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            }
        }
	
}