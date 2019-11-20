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
import java.util.Properties;

 
public class LoginServlet extends HttpServlet {
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