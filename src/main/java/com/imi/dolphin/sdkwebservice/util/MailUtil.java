package com.imi.dolphin.sdkwebservice.util;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imi.dolphin.sdkwebservice.property.AppProperties;

@Component
public class MailUtil {
	private static final Logger log = LoggerFactory.getLogger(MailUtil.class);
	
	Session mailSession;
	
	@Autowired
	AppProperties appProperties;
	
	public Session getMailSession() {
		log.debug("getMailSession() {}", "initialize mail session");
		Properties props = new Properties();
		props.put("mail.smtp.auth", appProperties.getMailStmpAuth());
		props.put("mail.smtp.starttls.enable", appProperties.getMailSmtpTls());
		props.put("mail.smtp.host", appProperties.getMailSmtpHost());
		props.put("mail.smtp.port", appProperties.getMailSmtpPort());
		
		mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(appProperties.getMailUsername(), appProperties.getMailPassword());
			}
		});
		return mailSession;
	}

	public void setMailSession(Session mailSession) {
		this.mailSession = mailSession;
	}
	
}
