package util;
import java.util.*;
import java.math.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSend {

	public static void gmailSend(String email, String hash) {
		String user = ""; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		String password = ""; // 패스워드

		// SMTP 서버 정보를 설정한다.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		String host = "http://localhost:9999/TeamProject_Portfolio/";

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));

			// 수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Subject
			message.setSubject("[비밀번호 인증 메일]GOOING"); // 메일 제목을 입력

			// Text
			message.setContent("비밀번호 재 설정을 위한 인증 링크입니다. 링크를 클릭하여 이메일을 인증하고 비밀번호를 재설정해주세요. " + "<a href = '" + host +"auth_email?code=" + hash +"'>이메일 인증하기!</a>","text/html;charset=UTF8"); // 메일 내용을 입력

			// send the message
			Transport.send(message); //// 전송
			System.out.println("message sent successfully...");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String gmailAuthSend(String email) {
		String user = "allsetsimon@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		String password = "Qkrtnqls1996"; // 패스워드

		// SMTP 서버 정보를 설정한다.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		String host = "http://localhost:9999/GooDee_TeamProject/";
		int randNum = 0;

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			randNum = (int)(Math.random()* 500000 + 100000);
			

			// 수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Subject
			message.setSubject("[본인인증코드]GOOING"); // 메일 제목을 입력

			// Text
			message.setContent("본인인증을 위한 코드 전송메일입니다. 고객님의 인증코드는 " + randNum + "입니다.","text/html;charset=UTF8"); // 메일 내용을 입력

			// send the message
			Transport.send(message); //// 전송
			System.out.println("message sent successfully...");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(randNum);
	}
	
	
}
