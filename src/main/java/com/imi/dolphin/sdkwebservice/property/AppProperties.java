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

	@Value("${sdk.connectTimeout}")
	String sdkConnectTimeout;
	
	@Value("${sdk.readTimeout}")
	String sdkReadTimeout;
	
	@Value("${sdk.username}")
	String sdkDolphinUsername;
	
	@Value("${sdk.password}")
	String sdkDolphinPassword;
	
	@Value("${sdk.dolphin.base.url}")
	String sdkDolphinBaseUrl;

	@Value("${sdk.dolphin.graph.ping}")
	String sdkDolphinGraphPing;
	
	@Value("${sdk.dolphin.graph.auth}")
	String sdkDolphinGraphAuth;
	
	@Value("${sdk.dolphin.graph.auth.token}")
	String sdkDolphinGraphAuthToken;
	
	@Value("${sdk.dolphin.graph.contacts}")
	String sdkDolphinGraphContacts;
	
	@Value("${sdk.dolphin.graph.contacts.update}")
	String sdkDolphinGraphContactsUpdate;
	
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

	/**
	 * @return the sdkConnectTimeout
	 */
	public String getSdkConnectTimeout() {
		return sdkConnectTimeout;
	}

	/**
	 * @param sdkConnectTimeout the sdkConnectTimeout to set
	 */
	public void setSdkConnectTimeout(String sdkConnectTimeout) {
		this.sdkConnectTimeout = sdkConnectTimeout;
	}

	/**
	 * @return the sdkReadTimeout
	 */
	public String getSdkReadTimeout() {
		return sdkReadTimeout;
	}

	/**
	 * @param sdkReadTimeout the sdkReadTimeout to set
	 */
	public void setSdkReadTimeout(String sdkReadTimeout) {
		this.sdkReadTimeout = sdkReadTimeout;
	}

	/**
	 * @return the sdkDolphinUsername
	 */
	public String getSdkDolphinUsername() {
		return sdkDolphinUsername;
	}

	/**
	 * @param sdkDolphinUsername the sdkDolphinUsername to set
	 */
	public void setSdkDolphinUsername(String sdkDolphinUsername) {
		this.sdkDolphinUsername = sdkDolphinUsername;
	}

	/**
	 * @return the sdkDolphinPassword
	 */
	public String getSdkDolphinPassword() {
		return sdkDolphinPassword;
	}

	/**
	 * @param sdkDolphinPassword the sdkDolphinPassword to set
	 */
	public void setSdkDolphinPassword(String sdkDolphinPassword) {
		this.sdkDolphinPassword = sdkDolphinPassword;
	}

	/**
	 * @return the sdkDolphinBaseUrl
	 */
	public String getSdkDolphinBaseUrl() {
		return sdkDolphinBaseUrl;
	}

	/**
	 * @param sdkDolphinBaseUrl the sdkDolphinBaseUrl to set
	 */
	public void setSdkDolphinBaseUrl(String sdkDolphinBaseUrl) {
		this.sdkDolphinBaseUrl = sdkDolphinBaseUrl;
	}

	/**
	 * @return the sdkDolphinGraphPing
	 */
	public String getSdkDolphinGraphPing() {
		return sdkDolphinGraphPing;
	}

	/**
	 * @param sdkDolphinGraphPing the sdkDolphinGraphPing to set
	 */
	public void setSdkDolphinGraphPing(String sdkDolphinGraphPing) {
		this.sdkDolphinGraphPing = sdkDolphinGraphPing;
	}

	/**
	 * @return the sdkDolphinGraphAuth
	 */
	public String getSdkDolphinGraphAuth() {
		return sdkDolphinGraphAuth;
	}

	/**
	 * @param sdkDolphinGraphAuth the sdkDolphinGraphAuth to set
	 */
	public void setSdkDolphinGraphAuth(String sdkDolphinGraphAuth) {
		this.sdkDolphinGraphAuth = sdkDolphinGraphAuth;
	}

	/**
	 * @return the sdkDolphinGraphAuthToken
	 */
	public String getSdkDolphinGraphAuthToken() {
		return sdkDolphinGraphAuthToken;
	}

	/**
	 * @param sdkDolphinGraphAuthToken the sdkDolphinGraphAuthToken to set
	 */
	public void setSdkDolphinGraphAuthToken(String sdkDolphinGraphAuthToken) {
		this.sdkDolphinGraphAuthToken = sdkDolphinGraphAuthToken;
	}

	/**
	 * @return the sdkDolphinGraphContacts
	 */
	public String getSdkDolphinGraphContacts() {
		return sdkDolphinGraphContacts;
	}

	/**
	 * @param sdkDolphinGraphContacts the sdkDolphinGraphContacts to set
	 */
	public void setSdkDolphinGraphContacts(String sdkDolphinGraphContacts) {
		this.sdkDolphinGraphContacts = sdkDolphinGraphContacts;
	}

	/**
	 * @return the sdkDolphinGraphContactsUpdate
	 */
	public String getSdkDolphinGraphContactsUpdate() {
		return sdkDolphinGraphContactsUpdate;
	}

	/**
	 * @param sdkDolphinGraphContactsUpdate the sdkDolphinGraphContactsUpdate to set
	 */
	public void setSdkDolphinGraphContactsUpdate(String sdkDolphinGraphContactsUpdate) {
		this.sdkDolphinGraphContactsUpdate = sdkDolphinGraphContactsUpdate;
	}

}
