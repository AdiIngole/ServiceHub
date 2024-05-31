package com.adi.ServiceHub.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dto.EmailGenerate;
import com.adi.ServiceHub.service.EmailGenerateService;

@Service
public class EmailGenerateServiceImpl implements EmailGenerateService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * @Override public void sendEmail(EmailGenerate e) { final String userName =
	 * "servicehub78410@gmail.com"; final String password = "Servicehub78410@";
	 * 
	 * Properties prop = new Properties(); prop.put("mail.smtp.host",
	 * "smtp.gmail.com"); prop.put("mail.smtp.port", "465");
	 * prop.put("mail.smtp.auth", "true"); prop.put("mail.smtp.socketFactory.port",
	 * "465"); prop.put("mail.smtp.socketFactory.class",
	 * "javax.net.ssl.SSLSocketFactory");
	 * 
	 * 
	 * Properties prop = new Properties(); prop.put("mail.smtp.host",
	 * "smtp.gmail.com"); prop.put("mail.smtp.port", "587");
	 * prop.put("mail.smtp.auth", "true"); prop.put("mail.smtp.starttls.enable",
	 * "true"); //TLS
	 * 
	 * Session session = Session.getInstance(prop, new Authenticator() { protected
	 * javax.mail.PasswordAuthentication getPasswordAuthentication() { return new
	 * javax.mail.PasswordAuthentication(userName, password); }
	 * 
	 * }); try { Message message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress(userName)); message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse(e.getReciption()));
	 * 
	 * message.setSubject(e.getSubject()); message.setText(e.getMessage());
	 * 
	 * Transport.send(message);
	 * 
	 * } catch (AddressException a) {
	 * 
	 * a.printStackTrace(); } catch (MessagingException a) { a.printStackTrace(); }
	 * }
	 */
	@Override
	public void sendEmail(EmailGenerate e) {
		System.out.println("Sending Email");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(e.getReciption());
		msg.setSubject(e.getSubject());
		msg.setText(e.getMessage());
		javaMailSender.send(msg);
		System.out.println("Mail Sent");
	}

}
