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

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.param.ParamSdk;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.util.OkHttpUtil;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * @author reja
 *
 */
@Service
public class AuthServiceImp implements AuthService {
	private static final Logger log = LogManager.getLogger(AuthServiceImp.class);

	@Autowired
	AppProperties appProperties;
	
	@Autowired
	OkHttpUtil okHttpUtil;
	
	/* (non-Javadoc)
	 * @see com.imi.dolphin.sdkwebservice.service.AuthService#isValidUserToken()
	 */
	@Override
	public boolean isValidAuthToken(ExtensionRequest extensionRequest) {
		log.debug("isValidUserToken() extensionRequest: {}", extensionRequest);
		try {
			String botToken = extensionRequest.getIntent().getBotToken();
			if (botToken == null) {
				return true;
			}
			Map<String, String> tokenMap = new HashMap<>();
			JSONObject jObject = new JSONObject(botToken);
			tokenMap.put(ParamSdk.SDK_AUTHORIZATION, "Bearer " + jObject.getString(ParamSdk.CONSTANT_TOKEN));

			okHttpUtil.init(true);
			Request.Builder builder = okHttpUtil.getBuilder();
			okHttpUtil.addHeaders(builder, tokenMap);
			RequestBody body = RequestBody.create(null, new byte[] {});
			Request request = builder.url(appProperties.getSdkDolphinBaseUrl() + appProperties.getSdkDolphinGraphAuthToken())
					.post(body).build();
			Response response = okHttpUtil.getClient().newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonData);
			if (jsonObject.getJSONObject("data") != null) {
				return true;
			}
		} catch (Exception e) {
			log.debug("isValidAuthToken() {}", e.getMessage(), e);
		}
		return false;
	}

}
