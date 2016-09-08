import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @category Utilities
 * @author kambiz
 * @version 0.1
 * {@link https://www.kth.se/profile/ghoorian/}
 * Simple Email Notification: is an email sender that I often use as a notifier in my code,
 * especially in crawlers and long-time algorithms when I need frequent notifications of the status of the system.
 * You can specify a notification format using @StringBuilder to create your arbitrary messages.
 * In addition, you can wrap the class in a timer to indicate the frequency of the messages. 
 * 
 * This application is open source created using javax.mail package.
 * Please remember to cite our URL {@link https://www.kth.se/profile/ghoorian/} when use it. 
 */
public class SendEmail {
	Properties properties = System.getProperties();
	Session session;

	public SendEmail(String host) {
		properties.setProperty("mail.smtp.host", host);
		session = Session.getDefaultInstance(properties);
	}

	public static void main(String[] args) {
		switch (args.length){
		case 0:
			System.out.println("Host address is not specified.\t e.g: smpt.host_address");
			System.exit(0);
			break;
		case 1:
			System.out.println("Sender email address not spedified. \t sender@senderdomain");
			System.exit(0);
			break;
		case 2:
			System.out.println("Receiver email address not specified. \t seceive@receiverdomain");
			System.exit(0);
			break;
		case 3:
			System.out.println("Subject not specified.");
			System.exit(0);
			break;
		case 4:
			System.out.println("Email message not specified.");
			System.exit(0);
			break;
		}

		String host = args[0];
		String from = args[1];
		String to = args[2];
		String subject = args[3];
		String text = args[4];
		
		SendEmail sm = new SendEmail(host);
		boolean res = sm.sendMailTo(from, to, subject, text);
		if (res)
			System.out.println("Send Mail to:\t" + to + "\t Successed.");
		else
			System.out.println("Send Mail to:\t" + to + "\t Failed.");
	}

	private boolean sendMailTo(String from, String to, String subject, String text) {
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(text);

			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		return true;
	}
}