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
package com.imi.dolphin.sdkwebservice.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.imi.dolphin.sdkwebservice.model.Contact;
import com.imi.dolphin.sdkwebservice.model.UserToken;
import com.imi.dolphin.sdkwebservice.param.ParamSdk;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.util.OkHttpUtil;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 3Dolphins API Integration
 * 
 * @author reja
 *
 */
@Service
public class DolphinServiceImp implements IDolphinService {
	private static final Logger log = LogManager.getLogger(DolphinServiceImp.class);

	@Autowired
	AppProperties appProperties;

	@Autowired
	OkHttpUtil okHttpUtil;

	/**
	 * Check token is still exist (not expired)
	 * 
	 * @return
	 */
	public boolean isTokenExistAndNotExpired(UserToken userToken) {
		log.debug("isTokenExistAndNotExpired() userToken: {}", userToken);
		if (userToken == null) {
			return false;
		} else {
			try {
				Date expireAtDate = ParamSdk.TOKEN_TIMEZONE.parse(userToken.getExpireAt());
				LocalDateTime expireAtDateTime = expireAtDate.toInstant().atZone(ZoneId.systemDefault())
						.toLocalDateTime();
				LocalDateTime now = LocalDateTime.now();
				log.debug("isTokenExistAndNotExpired() expireDate: {} now: {}", expireAtDateTime, now);
				if (expireAtDateTime.isBefore(now)) {
					return false;
				}
			} catch (Exception e) {
				log.error("isTokenExistAndNotExpired() {}", e.getMessage());
				return false;
			}
		}
		return true;
	}

	/**
	 * Refresh User Token
	 */
	@Override
	public UserToken getUserToken(UserToken userToken) {
		log.debug("getUserToken() userToken: {}", userToken);
		try {
			if (!isTokenExistAndNotExpired(userToken)) {
				Map<String, String> message = new HashMap<>();
				message.put(ParamSdk.SDK_USERNAME, appProperties.getSdkDolphinUsername());
				message.put(ParamSdk.SDK_PSWD, appProperties.getSdkDolphinPassword());
				String jsonBody = new Gson().toJson(message);

				okHttpUtil.init(true);
				Request.Builder builder = okHttpUtil.getBuilder();
				okhttp3.RequestBody body = okhttp3.RequestBody.create(ParamSdk.JSON, jsonBody);
				Request request = builder
						.url(appProperties.getSdkDolphinBaseUrl() + appProperties.getSdkDolphinGraphAuth()).post(body)
						.build();
				Response response = okHttpUtil.getClient().newCall(request).execute();
				String jsonData = response.body().string();
				JSONObject jObject = new JSONObject(jsonData);
				
				userToken = new UserToken();
				userToken.setToken("Bearer " + jObject.getString(ParamSdk.CONSTANT_TOKEN));
				userToken.setExpireAt(jObject.getString(ParamSdk.CONSTANT_EXPIRED));
				
				Map<String, String> auth = new HashMap<>();
				auth.put(ParamSdk.SDK_AUTHORIZATION, userToken.getToken());
				userToken.setAuth(auth);
			}
			return userToken;
		} catch (Exception e) {
			log.debug("getUserToken() error: {}", e.getMessage());
		}
		return userToken;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imi.dolphin.sdkwebservice.service.IDolphinService#getCustomer()
	 */
	@Override
	public Contact getCustomer(UserToken userToken, String contactId) {
		log.debug("getCustomer() userToken: {} contactid: {}", userToken, contactId);
		try {
			okHttpUtil.init(true);

			HttpUrl.Builder urlBuilder = HttpUrl
					.parse(appProperties.getSdkDolphinBaseUrl() + appProperties.getSdkDolphinGraphContacts())
					.newBuilder();
			urlBuilder.addQueryParameter("contactId", contactId);

			Request.Builder builder = okHttpUtil.getBuilder();
			okHttpUtil.addHeaders(builder, userToken.getAuth());
			Request request = builder.url(urlBuilder.build().toString()).build();
			Response response = okHttpUtil.getClient().newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonData);
			JSONObject data = jsonObject.getJSONObject("data");

			return new Gson().fromJson(data.toString(), Contact.class);
		} catch (Exception e) {
			log.debug("getCustomer() error: {}", e.getMessage(), e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imi.dolphin.sdkwebservice.service.IDolphinService#updateCustomer()
	 */
	@Override
	public Contact updateCustomer(UserToken userToken, Contact contact) {
		log.debug("updateCustomer() userToken: {} contact: {}", userToken, contact);
		try {
			getCustomer(userToken, contact.getId());
			String jsonBody = new Gson().toJson(contact);
			
			Request.Builder builder = okHttpUtil.getBuilder();
			okHttpUtil.addHeaders(builder, userToken.getAuth());
			okhttp3.RequestBody body = okhttp3.RequestBody.create(ParamSdk.JSON, jsonBody);
			Request request = builder.url(appProperties.getSdkDolphinBaseUrl()
					+ appProperties.getSdkDolphinGraphContactsUpdate() + "/" + contact.getId()).put(body).build();
			Response response = okHttpUtil.getClient().newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonData);
			JSONObject data = jsonObject.getJSONObject("data");
			
			return new Gson().fromJson(data.toString(), Contact.class);
		} catch (Exception e) {
			log.debug("getCustomer() error: {}", e.getMessage(), e);
		}
		return null;
	}

}
