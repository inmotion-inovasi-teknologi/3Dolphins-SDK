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
package com.imi.dolphin.sdkwebservice.model;

import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author reja
 *
 */
public class UserToken {

	@SerializedName("token")
	@Expose
	private String token;
	@SerializedName("expireAt")
	@Expose
	private String expireAt;
	private Map<String, String> auth;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the expireAt
	 */
	public String getExpireAt() {
		return expireAt;
	}
	/**
	 * @param expireAt the expireAt to set
	 */
	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}
	/**
	 * @return the auth
	 */
	public Map<String, String> getAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(Map<String, String> auth) {
		this.auth = auth;
	}
	
	
}