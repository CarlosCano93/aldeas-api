package com.ccanoprojects.aldeas.service;

import javax.mail.MessagingException;

public interface EmailService {

	/**
	 * To send email
	 * 
	 * @param to      Email to send
	 * @param subject Subject to send in email
	 * @param text    Text to send in email
	 * @throws MessagingException 
	 */
	public void sendSimpleMessage(String to, String subject, String text);
}
