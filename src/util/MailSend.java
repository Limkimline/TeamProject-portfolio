package util;
import java.util.*;
import java.math.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSend {

	public static void gmailSend(String email, String hash) {
		String user = ""; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
		String password = ""; // �н�����

		// SMTP ���� ������ �����Ѵ�.
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

			// �����ڸ����ּ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Subject
			message.setSubject("[��й�ȣ ���� ����]GOOING"); // ���� ������ �Է�

			// Text
			message.setContent("��й�ȣ �� ������ ���� ���� ��ũ�Դϴ�. ��ũ�� Ŭ���Ͽ� �̸����� �����ϰ� ��й�ȣ�� �缳�����ּ���. " + "<a href = '" + host +"auth_email?code=" + hash +"'>�̸��� �����ϱ�!</a>","text/html;charset=UTF8"); // ���� ������ �Է�

			// send the message
			Transport.send(message); //// ����
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
		String user = "allsetsimon@gmail.com"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
		String password = "Qkrtnqls1996"; // �н�����

		// SMTP ���� ������ �����Ѵ�.
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
			

			// �����ڸ����ּ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Subject
			message.setSubject("[���������ڵ�]GOOING"); // ���� ������ �Է�

			// Text
			message.setContent("���������� ���� �ڵ� ���۸����Դϴ�. ������ �����ڵ�� " + randNum + "�Դϴ�.","text/html;charset=UTF8"); // ���� ������ �Է�

			// send the message
			Transport.send(message); //// ����
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
