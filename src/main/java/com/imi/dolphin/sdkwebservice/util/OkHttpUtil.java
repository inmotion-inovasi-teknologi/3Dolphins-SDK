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

package com.imi.dolphin.sdkwebservice.util;

import java.security.cert.CertificateException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imi.dolphin.sdkwebservice.property.AppProperties;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 
 * @author reja
 *
 */
@Component
public class OkHttpUtil {
	private static final Logger log = LoggerFactory.getLogger(OkHttpUtil.class);
	private static final String SSL = "SSL";
	
	private OkHttpClient client;

	@Autowired
	AppProperties appProperties;
	
	public static final String POST="POST";
	public static final String PUT="PUT";
	public static final String GET="GET";
	
	private static final String CONSTANT_TOKEN = "token";
	private static final String CONSTANT_AUTH = "Authorization";
	
	public OkHttpClient getClient() {
		return client;
	}

	/**
	 * init configuration to ignore certificate
	 * 
	 * @param ignoreCertificate
	 */
	public void init(boolean ignoreCertificate) {
		log.debug("Initialising httpUtil with default configuration ignoreCertificate: {}", ignoreCertificate);

		int connectTimeout = 15;
		int readTimeout = 15;

		String connectTimeoutText = appProperties.getSdkConnectTimeout();
		String readTimeoutText = appProperties.getSdkReadTimeout();
		if (StringUtils.isNumeric(connectTimeoutText)) {
			connectTimeout = Integer.parseInt(connectTimeoutText);
		}
		if (StringUtils.isNumeric(readTimeoutText)) {
			readTimeout = Integer.parseInt(readTimeoutText);
		}
		OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.SECONDS)
				.readTimeout(readTimeout, TimeUnit.SECONDS);
		if (ignoreCertificate) {
			configureToIgnoreCertificate(builder);
		}
		client = builder.build();
	}

	/**
	 * ignore certificate configuration
	 * 
	 * @param builder
	 * @return
	 */
	private OkHttpClient.Builder configureToIgnoreCertificate(OkHttpClient.Builder builder) {
		log.debug("configureToIgnoreCertificate Builder: {}", builder);
		try {
			final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
					log.debug("checkClientTrusted chain: {} authType: {}", chain, authType);
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
					log.debug("checkServerTrusted chain: {} authType: {}", chain, authType);
				}

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					log.debug("getAcceptedIssuers builder: {}", builder);
					return new java.security.cert.X509Certificate[] {};
				}
			} };

			final SSLContext sslContext = SSLContext.getInstance(SSL);
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
		} catch (Exception e) {
			log.debug("configureToIgnoreCertificate {} {}", e.getMessage(), e);
		}
		return builder;
	}

	/**
	 * Get the Request Builder
	 * 
	 * @return
	 */
	public Request.Builder getBuilder() {
		return new Request.Builder();
	}

	/**
	 * Add headers into Request Builder
	 * 
	 * @param builder
	 * @param headers
	 */
	public void addHeaders(Request.Builder builder, Map<String, String> headers) {
		log.debug("addHeaders() builder: {} headers: {}", builder, headers);
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> map : headers.entrySet()) {
				if(map.getKey().equalsIgnoreCase(CONSTANT_TOKEN)) {
					builder.addHeader(CONSTANT_AUTH, map.getValue());
				}else {
					builder.addHeader(map.getKey(), map.getValue());
				}
			}
		}
	}
	
}
