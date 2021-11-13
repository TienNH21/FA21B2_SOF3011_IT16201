package servlets;

import java.io.IOException;

import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/DemoMailServlet")
public class DemoMailServlet extends HttpServlet {
    public DemoMailServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		// Hiệu năng khi gửi mail
		// Send mail
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.host", "smtp.mailtrap.io");
		props.setProperty("mail.smtp.port", "25");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "f8286cf3ed9052", password = "43daf4d254caf9";
				return new PasswordAuthentication(username, password);
			}
		};

		Session session = Session.getInstance(props, auth);
		try {
			MimeMessage mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress("tiennh21@fe.edu.vn"));
			mail.setRecipients(Message.RecipientType.TO, "tiennh21@fpt.edu.vn");
			mail.setSubject("Tiêu đề mail: DemoMail");
			mail.setText("Nội dung mail: Demo Mail");
			mail.setReplyTo(mail.getFrom());
			
			Transport.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.getWriter().append("Đã gửi mail thành công");
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		doGet(request, response);
	}

}
