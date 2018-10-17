/**
 * Copyright (c) 2014 InMotion Innovation Technology. All Rights Reserved. <BR>
 * <BR>
 * This software contains confidential and proprietary information of
 * InMotion Innovation Technology. ("Confidential Information").<BR>
 * <BR>
 * Such Confidential Information shall not be disclosed and it shall
 * only be used in accordance with the terms of the license agreement
 * entered into with IMI; other than in accordance with the written
 * permission of IMI. <BR>
 * 
 **/
package com.imi.dolphin.sdkwebservice.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author reja
 *
 */
@Component
public class AppProperties {

	@Value("${server.port}")
	String servicePort;

	@Value("${app.form.id}")
	String formId;
	
	@Value("${mail.username}")
	String mailUsername;
	
	@Value("${mail.password}")
	String mailPassword;
	
	@Value("${mail.smtp.auth}")
	String mailStmpAuth;
	
	@Value("${mail.smtp.starttls.enable}")
	String mailSmtpTls;
	
	@Value("${mail.smtp.host}")
	String mailSmtpHost;
	
	@Value("${mail.smtp.port}")
	String mailSmtpPort;

	
	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getMailUsername() {
		return mailUsername;
	}

	public void setMailUsername(String mailUsername) {
		this.mailUsername = mailUsername;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getMailStmpAuth() {
		return mailStmpAuth;
	}

	public void setMailStmpAuth(String mailStmpAuth) {
		this.mailStmpAuth = mailStmpAuth;
	}

	public String getMailSmtpTls() {
		return mailSmtpTls;
	}

	public void setMailSmtpTls(String mailSmtpTls) {
		this.mailSmtpTls = mailSmtpTls;
	}

	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}

	public String getMailSmtpPort() {
		return mailSmtpPort;
	}

	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}

}
