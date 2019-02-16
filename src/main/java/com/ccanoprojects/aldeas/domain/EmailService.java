package com.ccanoprojects.aldeas.domain;

import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailService {
    private static Logger log = LoggerFactory.getLogger(EmailService.class);

    private Properties mailProps;
    private Authenticator mailAuth;

    @Value("${mail.user}")
    private String mailUsername;
    @Value("${mail.password}")
    private String mailPassword;

    public EmailService(Properties mailProps, String user, String encodedPassword) {
        this.mailProps = mailProps;
        this.mailUsername = user;
        this.mailPassword = encodedPassword;
        this.mailAuth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, encodedPassword);
            }
        };
    }

    public EmailService() {
        mailProps = new Properties();
        mailProps.put("mail.smtp.host", "smtp.ionos.es");
        mailProps.put("mail.smtp.port", "587");
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");

        mailAuth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailUsername, mailPassword);
            }
        };
    }

    public void sendMailToHearthOfSouthAmericaFrom(Customer customer) {
        log.info("Sending mail from " + customer.getName());
        try {
            MimeMessage message = new MimeMessage(Session.getInstance(mailProps, mailAuth));
            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.addHeader("format", "flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");

            InternetAddress addressFrom = new InternetAddress(customer.getEmail(), customer.getName());
            message.setFrom(addressFrom);
            message.setSubject(customer.getName() + " quiere ser voluntario!");
            message.setText(customer.getMessage(), "UTF-8");
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.mailUsername, false));

            Transport.send(message);

            log.info("Mail sent successfully :)");
        } catch (Exception e) {
            log.error("Error sending mail: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
