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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imi.dolphin.sdkwebservice.builder.ButtonBuilder;
import com.imi.dolphin.sdkwebservice.builder.CarouselBuilder;
import com.imi.dolphin.sdkwebservice.builder.FormBuilder;
import com.imi.dolphin.sdkwebservice.builder.ImageBuilder;
import com.imi.dolphin.sdkwebservice.builder.QuickReplyBuilder;
import com.imi.dolphin.sdkwebservice.model.ButtonTemplate;
import com.imi.dolphin.sdkwebservice.model.Contact;
import com.imi.dolphin.sdkwebservice.model.EasyMap;
import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.model.ExtensionResult;
import com.imi.dolphin.sdkwebservice.model.MailModel;
import com.imi.dolphin.sdkwebservice.model.UserToken;
import com.imi.dolphin.sdkwebservice.param.ParamSdk;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.util.OkHttpUtil;

import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * @author reja
 *
 */
@Service
public class ServiceImp implements IService {
	private static final Logger log = LogManager.getLogger(ServiceImp.class);

	public static final String OUTPUT = "output";
	private UserToken userToken;
	
	@Autowired
	AppProperties appProperties;

	@Autowired
	IMailService svcMailService;
	
	@Autowired
	IDolphinService svcDolphinService;

	@Autowired
	OkHttpUtil okHttpUtil;
	
	/**
	 * Get parameter value from request body parameter
	 * 
	 * @param extensionRequest
	 * @param name
	 * @return
	 */
	private String getEasyMapValueByName(ExtensionRequest extensionRequest, String name) {
		log.debug("getEasyMapValueByName() extension request: {} name: {}", extensionRequest, name);
		EasyMap easyMap = extensionRequest.getParameters().stream().filter(x -> x.getName().equals(name)).findAny()
				.orElse(null);
		if (easyMap != null) {
			return easyMap.getValue();
		}
		return "";
	}

	/*
	 * Sample Srn status with static result
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getSrnResult(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getSrnResult(ExtensionRequest extensionRequest) {
		log.debug("getSrnResult() extension request: {}", extensionRequest);
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();
		respBuilder.append(
				"20-July-2018 16:10:32 Ahmad Mahatir Ridwan - PIC sudah onsite cek problem(printer nyala-mati)\n");
		respBuilder.append("PIC troubleshoot. restart printer(NOK), ganti kabel power(NOK)\n");
		respBuilder.append("PIC akan eskalasi ke vendor terkait.");
		output.put(OUTPUT, respBuilder.toString());
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Sample Customer Info with static result
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getCustomerInfo(com.imi.
	 * dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getCustomerInfo(ExtensionRequest extensionRequest) {
		log.debug("getCustomerInfo() extension request: {}", extensionRequest);
		String account = getEasyMapValueByName(extensionRequest, "akun");
		String name = getEasyMapValueByName(extensionRequest, "name");
		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();
		if (account.substring(0, 1).equals("1")) {
			respBuilder.append("Ticket Number : " + extensionRequest.getIntent().getTicket().getTicketNumber() + "\n");
			respBuilder.append(" Data Customer Account " + account + "\n");
			respBuilder.append("Nama: " + name + "\n");
			respBuilder.append("Setoran tiap bulan : Rp. 500,000\n");
			respBuilder.append("Jatuh tempo berikutnya : 15 Agustus 2018");
		} else {
			respBuilder.append("Ticket Number : " + extensionRequest.getIntent().getTicket().getTicketNumber() + "\n");
			respBuilder.append(appProperties.getFormId() + " Data Customer Account " + account + "\n");
			respBuilder.append("Nama: " + name + "\n");
			respBuilder.append("Setoran tiap bulan : Rp. 1,000,000\n");
			respBuilder.append("Jatuh tempo berikutnya : 27 Agustus 2018");
		}
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);

		output.put(OUTPUT, respBuilder.toString());
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Modify Customer Name Entity
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#clearCustomerName(com.imi.
	 * dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult modifyCustomerName(ExtensionRequest extensionRequest) {
		log.debug("modifyCustomerName() extension request: {}", extensionRequest);
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);

		Map<String, String> clearEntities = new HashMap<>();
		String name = getEasyMapValueByName(extensionRequest, "name");
		if (name.equalsIgnoreCase("reja")) {
			clearEntities.put("name", "budi");
			extensionResult.setEntities(clearEntities);
		}
		return extensionResult;
	}

	/*
	 * Sample Product info with static value
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getProductInfo(com.imi.dolphin
	 * .sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getProductInfo(ExtensionRequest extensionRequest) {
		log.debug("getProductInfo() extension request: {}", extensionRequest);
		String model = getEasyMapValueByName(extensionRequest, "model");
		String type = getEasyMapValueByName(extensionRequest, "type");

		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();

		respBuilder.append("Untuk harga mobil " + model + " tipe " + type + " adalah 800,000,000\n");
		respBuilder.append("Jika kak {customer_name} tertarik, bisa klik tombol dibawah ini. \n");
		respBuilder.append("Maka nanti live agent kami akan menghubungi kakak ;)");

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);

		output.put(OUTPUT, respBuilder.toString());
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Get messages from third party service
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getMessageBody(com.imi.dolphin
	 * .sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getMessageBody(ExtensionRequest extensionRequest) {
		log.debug("getMessageBody() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();

		try {
			okHttpUtil.init(true);
			Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/comments").get().build();
			Response response = okHttpUtil.getClient().newCall(request).execute();

			JSONArray jsonArray = new JSONArray(response.body().string());

			JSONObject jsonObject = jsonArray.getJSONObject(0);
			String message = jsonObject.getString("body");
			respBuilder.append(message);
		} catch (Exception e) {
			log.debug("getMessageBody() {}", e.getMessage());
		}

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);

		output.put(OUTPUT, respBuilder.toString());
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Generate quick replies output
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IFormService#getQuickReplies(com.imi.
	 * dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getQuickReplies(ExtensionRequest extensionRequest) {
		log.debug("getQuickReplies() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();
		Map<String, String> map = new HashMap<>();
		map.put("Hello", "World");
		map.put("Java", "Coffee");

		QuickReplyBuilder quickReplyBuilder = new QuickReplyBuilder.Builder("Hello").addAll(map).build();
		output.put(OUTPUT, quickReplyBuilder.string());
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Generate Forms
	 *
	 * (non-Javadoc)
	 * 
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getForms(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getForms(ExtensionRequest extensionRequest) {
		log.debug("getForms() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();
		FormBuilder formBuilder = new FormBuilder(appProperties.getFormId());

		ButtonTemplate button = new ButtonTemplate();
		button.setTitle("Title is here");
		button.setSubTitle("Subtitle is here");
		button.setPictureLink(ParamSdk.SAMPLE_IMAGE_PATH);
		button.setPicturePath(ParamSdk.SAMPLE_IMAGE_PATH);
		List<EasyMap> actions = new ArrayList<>();
		EasyMap bookAction = new EasyMap();
		bookAction.setName("Label here");
		bookAction.setValue(formBuilder.build());
		actions.add(bookAction);
		button.setButtonValues(actions);
		ButtonBuilder buttonBuilder = new ButtonBuilder(button);

		output.put(OUTPUT, buttonBuilder.build());
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Generate buttons output
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getButtons(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getButtons(ExtensionRequest extensionRequest) {
		log.debug("getButtons() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();

		ButtonTemplate button = new ButtonTemplate();
		button.setTitle(ParamSdk.SAMPLE_TITLE);
		button.setSubTitle(ParamSdk.SAMPLE_SUBTITLE);
		button.setPictureLink(ParamSdk.SAMPLE_IMAGE_PATH);
		button.setPicturePath(ParamSdk.SAMPLE_IMAGE_PATH);
		List<EasyMap> actions = new ArrayList<>();
		EasyMap bookAction = new EasyMap();
		bookAction.setName(ParamSdk.SAMPLE_LABEL);
		bookAction.setValue(ParamSdk.SAMPLE_PAYLOAD);
		actions.add(bookAction);
		button.setButtonValues(actions);

		ButtonBuilder buttonBuilder = new ButtonBuilder(button);
		output.put(OUTPUT, buttonBuilder.build());

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Generate Carousel
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getCarousel(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getCarousel(ExtensionRequest extensionRequest) {
		log.debug("getCarousel() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();

		List<String> buttonList = new ArrayList<>();
		ButtonTemplate button;
		ButtonBuilder buttonBuilder;
		for (int i = 0; i < 6; i++) {
			button = new ButtonTemplate();
			button.setPictureLink(ParamSdk.SAMPLE_IMAGE_PATH);
			button.setPicturePath(ParamSdk.SAMPLE_IMAGE_PATH);
			button.setTitle(ParamSdk.SAMPLE_TITLE.concat(String.valueOf(i)));
			button.setSubTitle(ParamSdk.SAMPLE_SUBTITLE.concat(String.valueOf(i)));
			List<EasyMap> actions = new ArrayList<>();
			EasyMap bookAction = new EasyMap();
			bookAction.setName(ParamSdk.SAMPLE_LABEL);
			bookAction.setValue(ParamSdk.SAMPLE_PAYLOAD);
			actions.add(bookAction);
			button.setButtonValues(actions);
			buttonBuilder = new ButtonBuilder(button);
			buttonList.add(buttonBuilder.build());
		}
		CarouselBuilder carouselBuilder = new CarouselBuilder(buttonList);
		output.put(OUTPUT, carouselBuilder.build());

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Transfer ticket to agent
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#doTransferToAgent(com.imi.
	 * dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult doTransferToAgent(ExtensionRequest extensionRequest) {
		log.debug("doTransferToAgent() extension request: {}", extensionRequest);
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(true);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(false);
		return extensionResult;
	}

	/*
	 * Send Location
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#doSendLocation(com.imi.dolphin
	 * .sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult doSendLocation(ExtensionRequest extensionRequest) {
		log.debug("doSendLocation() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();
		QuickReplyBuilder quickReplyBuilder = new QuickReplyBuilder.Builder("Kirim lokasi kakak ya")
				.add("Location", "location").build();
		output.put(OUTPUT, quickReplyBuilder.string());
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Generate Image
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getImage(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getImage(ExtensionRequest extensionRequest) {
		log.debug("getImage() extension request: {}", extensionRequest);
		Map<String, String> output = new HashMap<>();

		ButtonTemplate image = new ButtonTemplate();
		image.setPictureLink(ParamSdk.SAMPLE_IMAGE_PATH);
		image.setPicturePath(ParamSdk.SAMPLE_IMAGE_PATH);

		ImageBuilder imageBuilder = new ImageBuilder(image);
		output.put(OUTPUT, imageBuilder.build());

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Split bubble chat conversation
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#getSplitConversation(com.imi.
	 * dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getSplitConversation(ExtensionRequest extensionRequest) {
		log.debug("getSplitConversation() extension request: {}", extensionRequest);
		String firstLine = "Terima kasih {customer_name}";
		String secondLine = "Data telah kami terima dan agent kami akan proses terlebih dahulu ya kak";
		Map<String, String> output = new HashMap<>();
		output.put(OUTPUT, firstLine + ParamSdk.SPLIT_CHAT + secondLine);

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/*
	 * Send mail configuration on application.properties file
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imi.dolphin.sdkwebservice.service.IService#doSendMail(com.imi.dolphin.
	 * sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult doSendMail(ExtensionRequest extensionRequest) {
		log.debug("doSendMail() extension request: {}", extensionRequest);
		String recipient = getEasyMapValueByName(extensionRequest, "recipient");
		MailModel mailModel = new MailModel(recipient, "3Dolphins SDK Mail Subject", "3Dolphins SDK mail content");
		String sendMailResult = svcMailService.sendMail(mailModel);

		Map<String, String> output = new HashMap<>();
		output.put(OUTPUT, sendMailResult);
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

	/* (non-Javadoc)
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getDolphinResponse(com.imi.dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getDolphinResponse(ExtensionRequest extensionRequest) {
		userToken = svcDolphinService.getUserToken(userToken);
		log.debug("getDolphinResponse() extension request: {} user token: {}", extensionRequest, userToken);
		String contactId =extensionRequest.getIntent().getTicket().getContactId();
		Contact contact = svcDolphinService.getCustomer(userToken, contactId);
		contact.setContactFirstName("YOUR NAME");
		contact = svcDolphinService.updateCustomer(userToken, contact);
		
		Map<String, String> output = new HashMap<>();
		output.put(OUTPUT, "PING " + contact.getContactFirstName());
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

}
