package com.ccanoprojects.aldeas.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	private static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	private Properties mailProps;
	private Authenticator mailAuth;

	@Value("${mail.usr}")
	private String mailUsr;
	@Value("${mail.psw}")
	private String mailPsw;

	public EmailServiceImpl(Properties mailProps, String user, String encodedPassword) {
		this.mailProps = mailProps;
		this.mailUsr = user;
		this.mailPsw = encodedPassword;
		this.mailAuth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, encodedPassword);
			}
		};
	}

	public EmailServiceImpl() {
		mailProps = new Properties();
		mailProps.put("mail.smtp.host", "smtp.ionos.es");
		mailProps.put("mail.smtp.port", "587");
		mailProps.put("mail.smtp.auth", "true");
		mailProps.put("mail.smtp.starttls.enable", "true");

		mailAuth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailUsr, mailPsw);
			}
		};
	}

	@Override
	public void sendSimpleMessage(String clientEmail, String name, String body) {
		log.info(String.format("Sending mail from '%s'", clientEmail));
		try {
			MimeMessage msg = new MimeMessage(Session.getInstance(mailProps, mailAuth));
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(clientEmail, name));
			msg.setSubject(String.format("%s quiere ser voluntario!", name), "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.mailUsr, false));

			Transport.send(msg);

			log.info("Mail sent successfully :)");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
