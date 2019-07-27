package com.imi.dolphin.sdkwebservice.param;

import java.text.SimpleDateFormat;

public class ParamSdk {
	public static final String SPLIT_CHAT = "&split&";
	public static final String CONSTANT_EMPTY = "";
	
	public static final String SAMPLE_TITLE = "This is title";
	public static final String SAMPLE_SUBTITLE = "This is subtitle";	
	public static final String SAMPLE_IMAGE_PATH = "https://i.ibb.co/yRHSXLh/inmotion-logo.png";
	public static final String SAMPLE_LABEL = "Label";
	public static final String SAMPLE_PAYLOAD = "Payload";
	
	// 3Dolphins API Parameter
	public static final String SDK_USERNAME = "username";
	public static final String SDK_PSWD = "password";
	public static final String SDK_AUTHORIZATION = "Authorization";
	public static final okhttp3.MediaType JSON = okhttp3.MediaType.parse("application/json; charset=utf-8");
	public static final String CONSTANT_TOKEN = "token";
	public static final String CONSTANT_EXPIRED = "expireAt";
	public static final SimpleDateFormat TOKEN_TIMEZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
}
