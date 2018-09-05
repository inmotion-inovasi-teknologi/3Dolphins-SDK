package com.imi.dolphin.sdkwebservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imi.dolphin.sdkwebservice.builder.ButtonBuilder;
import com.imi.dolphin.sdkwebservice.builder.FormBuilder;
import com.imi.dolphin.sdkwebservice.builder.QuickReplyBuilder;
import com.imi.dolphin.sdkwebservice.model.ButtonTemplate;
import com.imi.dolphin.sdkwebservice.model.EasyMap;
import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.model.ExtensionResult;
import com.imi.dolphin.sdkwebservice.param.ParamSdk;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.util.OkHttpUtil;

import okhttp3.Request;
import okhttp3.Response;

@Service
public class ServiceImp implements IService {
	public static final String OUTPUT = "output";
	private static final String SAMPLE_IMAGE_PATH = "https://image.ibb.co/fRYz5T/photo6154476178988181548.jpg";
	
	@Autowired
	AppProperties appProperties;

	/**
	 * Get parameter value from request body parameter
	 * 
	 * @param extensionRequest
	 * @param name
	 * @return
	 */
	private String getEasyMapValueByName(ExtensionRequest extensionRequest, String name) {
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
		String account = getEasyMapValueByName(extensionRequest, "account");
		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();
		if (account.substring(0, 1).equals("1")) {
			respBuilder.append("Ticket Number : " + extensionRequest.getIntent().getTicket().getTicketNumber() + "\n");
			respBuilder.append(" Data Customer Account " + account + "\n");
			respBuilder.append("Nama: Reja\n");
			respBuilder.append("Setoran tiap bulan : Rp. 500,000\n");
			respBuilder.append("Jatuh tempo berikutnya : 15 Agustus 2018");
		} else {
			respBuilder.append("Ticket Number : " + extensionRequest.getIntent().getTicket().getTicketNumber() + "\n");
			respBuilder.append(appProperties.getFormId() + " Data Customer Account " + account + "\n");
			respBuilder.append("Nama: Budi\n");
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
		Map<String, String> output = new HashMap<>();
		StringBuilder respBuilder = new StringBuilder();

		try {
			OkHttpUtil okHttpUtil = new OkHttpUtil();
			okHttpUtil.init(true);
			Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/comments").get().build();
			Response response = okHttpUtil.getClient().newCall(request).execute();

			JSONArray jsonArray = new JSONArray(response.body().string());

			JSONObject jsonObject = jsonArray.getJSONObject(0);
			String message = jsonObject.getString("body");
			respBuilder.append(message);
		} catch (Exception e) {

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
		Map<String, String> output = new HashMap<>();
		QuickReplyBuilder quickReplyBuilder = new QuickReplyBuilder.Builder("Hello").add("Hello World", "hello world")
				.add("Hello Java", "hello java").build();
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
		Map<String, String> output = new HashMap<>();
		FormBuilder formBuilder = new FormBuilder("FORM ID");

		ButtonTemplate button = new ButtonTemplate();
		button.setTitle("Title is here");
		button.setSubTitle("Subtitle is here");
		button.setPictureLink("Picture link");
		button.setPicturePath("Picture path");
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
		Map<String, String> output = new HashMap<>();

		ButtonTemplate button = new ButtonTemplate();
		button.setTitle("This is title");
		button.setSubTitle("This is subtitle");
		button.setPictureLink(SAMPLE_IMAGE_PATH);
		button.setPicturePath(SAMPLE_IMAGE_PATH);
		List<EasyMap> actions = new ArrayList<>();
		EasyMap bookAction = new EasyMap();
		bookAction.setName("Label");
		bookAction.setValue("Payload");
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
	 * 
	 * 
	 * (non-Javadoc)
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getSplitConversation(com.imi.dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getSplitConversation(ExtensionRequest extensionRequest) {
		String firstLine= "Terima kasih {customer_name}";
		String secondLine = "Data telah kami terima dan agent kami akan proses terlebih dahulu ya kak";
		Map<String, String> output = new HashMap<>();
		output.put(OUTPUT, firstLine + ParamSdk.SPLIT_CHAT+ secondLine);

		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		extensionResult.setValue(output);
		return extensionResult;
	}

}
