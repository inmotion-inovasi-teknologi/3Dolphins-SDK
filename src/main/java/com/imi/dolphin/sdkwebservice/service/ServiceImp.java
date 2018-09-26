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
import com.imi.dolphin.sdkwebservice.builder.CarouselBuilder;
import com.imi.dolphin.sdkwebservice.builder.FormBuilder;
import com.imi.dolphin.sdkwebservice.builder.ImageBuilder;
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
	 * @see com.imi.dolphin.sdkwebservice.service.IService#clearCustomerName(com.imi.dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult modifyCustomerName(ExtensionRequest extensionRequest) {
		ExtensionResult extensionResult = new ExtensionResult();
		extensionResult.setAgent(false);
		extensionResult.setRepeat(false);
		extensionResult.setSuccess(true);
		extensionResult.setNext(true);
		
		Map<String, String> clearEntities = new HashMap<>();
		String name = getEasyMapValueByName(extensionRequest, "name");
		if(name.equalsIgnoreCase("reja")) {
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
				.add("Hello Java", "B0F63CE1-F16F-4761-8881-F44C95D2792F").build();
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

		ButtonTemplate button2 = new ButtonTemplate();
		button2.setTitle("This is title 2");
		button2.setSubTitle("This is subtitle 2");
		button2.setPictureLink(SAMPLE_IMAGE_PATH);
		button2.setPicturePath(SAMPLE_IMAGE_PATH);
		List<EasyMap> actions2 = new ArrayList<>();
		EasyMap bookAction2 = new EasyMap();
		bookAction2.setName("Label 2");
		bookAction2.setValue("Payload 2");
		actions2.add(bookAction2);
		button2.setButtonValues(actions2);
		ButtonBuilder buttonBuilder2 = new ButtonBuilder(button2);

		ButtonTemplate button3 = new ButtonTemplate();
		button3.setTitle("This is title 2");
		button3.setSubTitle("This is subtitle 2");
		button3.setPictureLink(SAMPLE_IMAGE_PATH);
		button3.setPicturePath(SAMPLE_IMAGE_PATH);
		button3.setButtonValues(actions2);
		ButtonBuilder buttonBuilder3 = new ButtonBuilder(button3);
		
		ButtonTemplate button4 = new ButtonTemplate();
		button4.setTitle("This is title 2");
		button4.setSubTitle("This is subtitle 2");
		button4.setPictureLink(SAMPLE_IMAGE_PATH);
		button4.setPicturePath(SAMPLE_IMAGE_PATH);
		button4.setButtonValues(actions2);
		ButtonBuilder buttonBuilder4 = new ButtonBuilder(button4);
		
		ButtonTemplate button5 = new ButtonTemplate();
		button5.setTitle("This is title 2");
		button5.setSubTitle("This is subtitle 2");
		button5.setPictureLink(SAMPLE_IMAGE_PATH);
		button5.setPicturePath(SAMPLE_IMAGE_PATH);
		button5.setButtonValues(actions2);
		ButtonBuilder buttonBuilder5 = new ButtonBuilder(button5);
		
		ButtonTemplate button6 = new ButtonTemplate();
		button6.setTitle("This is title 2");
		button6.setSubTitle("This is subtitle 2");
		button6.setPictureLink(SAMPLE_IMAGE_PATH);
		button6.setPicturePath(SAMPLE_IMAGE_PATH);
		button6.setButtonValues(actions2);
		ButtonBuilder buttonBuilder6 = new ButtonBuilder(button3);
		
		ButtonTemplate button7 = new ButtonTemplate();
		button7.setTitle("This is title 2");
		button7.setSubTitle("This is subtitle 2");
		button7.setPictureLink(SAMPLE_IMAGE_PATH);
		button7.setPicturePath(SAMPLE_IMAGE_PATH);
		button7.setButtonValues(actions2);
		ButtonBuilder buttonBuilder7 = new ButtonBuilder(button7);
		
		ButtonTemplate button8 = new ButtonTemplate();
		button8.setTitle("This is title 2");
		button8.setSubTitle("This is subtitle 2");
		button8.setPictureLink(SAMPLE_IMAGE_PATH);
		button8.setPicturePath(SAMPLE_IMAGE_PATH);
		button8.setButtonValues(actions2);
		ButtonBuilder buttonBuilder8 = new ButtonBuilder(button8);
		
		ButtonTemplate button9 = new ButtonTemplate();
		button9.setTitle("This is title 2");
		button9.setSubTitle("This is subtitle 2");
		button9.setPictureLink(SAMPLE_IMAGE_PATH);
		button9.setPicturePath(SAMPLE_IMAGE_PATH);
		button9.setButtonValues(actions2);
		ButtonBuilder buttonBuilder9 = new ButtonBuilder(button9);
		
		ButtonTemplate button10 = new ButtonTemplate();
		button10.setTitle("This is title 2");
		button10.setSubTitle("This is subtitle 2");
		button10.setPictureLink(SAMPLE_IMAGE_PATH);
		button10.setPicturePath(SAMPLE_IMAGE_PATH);
		button10.setButtonValues(actions2);
		ButtonBuilder buttonBuilder10 = new ButtonBuilder(button10);
		
		ButtonTemplate button11 = new ButtonTemplate();
		button11.setTitle("This is title 11");
		button11.setSubTitle("This is subtitle 11");
		button11.setPictureLink(SAMPLE_IMAGE_PATH);
		button11.setPicturePath(SAMPLE_IMAGE_PATH);
		button11.setButtonValues(actions2);
		ButtonBuilder buttonBuilder11 = new ButtonBuilder(button11);
		
		ButtonTemplate button12 = new ButtonTemplate();
		button12.setTitle("This is title 12");
		button12.setSubTitle("This is subtitle 12");
		button12.setPictureLink(SAMPLE_IMAGE_PATH);
		button12.setPicturePath(SAMPLE_IMAGE_PATH);
		button12.setButtonValues(actions2);
		ButtonBuilder buttonBuilder12 = new ButtonBuilder(button12);
		
		ButtonTemplate button13 = new ButtonTemplate();
		button13.setTitle("This is title 11");
		button13.setSubTitle("This is subtitle 11");
		button13.setPictureLink(SAMPLE_IMAGE_PATH);
		button13.setPicturePath(SAMPLE_IMAGE_PATH);
		button13.setButtonValues(actions2);
		ButtonBuilder buttonBuilder13 = new ButtonBuilder(button13);
		
		ButtonTemplate button14 = new ButtonTemplate();
		button14.setTitle("This is title 12");
		button14.setSubTitle("This is subtitle 12");
		button14.setPictureLink(SAMPLE_IMAGE_PATH);
		button14.setPicturePath(SAMPLE_IMAGE_PATH);
		button14.setButtonValues(actions2);
		ButtonBuilder buttonBuilder14 = new ButtonBuilder(button14);
		
		ButtonTemplate button15 = new ButtonTemplate();
		button15.setTitle("This is title 11");
		button15.setSubTitle("This is subtitle 11");
		button15.setPictureLink(SAMPLE_IMAGE_PATH);
		button15.setPicturePath(SAMPLE_IMAGE_PATH);
		button15.setButtonValues(actions2);
		ButtonBuilder buttonBuilder15 = new ButtonBuilder(button15);
		
		ButtonTemplate button16 = new ButtonTemplate();
		button16.setTitle("This is title 12");
		button16.setSubTitle("This is subtitle 12");
		button16.setPictureLink(SAMPLE_IMAGE_PATH);
		button16.setPicturePath(SAMPLE_IMAGE_PATH);
		button16.setButtonValues(actions2);
		ButtonBuilder buttonBuilder16 = new ButtonBuilder(button16);
		
		ButtonTemplate button17 = new ButtonTemplate();
		button17.setTitle("This is title 11");
		button17.setSubTitle("This is subtitle 11");
		button17.setPictureLink(SAMPLE_IMAGE_PATH);
		button17.setPicturePath(SAMPLE_IMAGE_PATH);
		button17.setButtonValues(actions2);
		ButtonBuilder buttonBuilder17 = new ButtonBuilder(button17);
		
		ButtonTemplate button18 = new ButtonTemplate();
		button18.setTitle("This is title 12");
		button18.setSubTitle("This is subtitle 12");
		button18.setPictureLink(SAMPLE_IMAGE_PATH);
		button18.setPicturePath(SAMPLE_IMAGE_PATH);
		button18.setButtonValues(actions2);
		ButtonBuilder buttonBuilder18 = new ButtonBuilder(button18);
		
		ButtonTemplate button19 = new ButtonTemplate();
		button19.setTitle("This is title 11");
		button19.setSubTitle("This is subtitle 11");
		button19.setPictureLink(SAMPLE_IMAGE_PATH);
		button19.setPicturePath(SAMPLE_IMAGE_PATH);
		button19.setButtonValues(actions2);
		ButtonBuilder buttonBuilder19 = new ButtonBuilder(button19);
		
		ButtonTemplate button20 = new ButtonTemplate();
		button20.setTitle("This is title 12");
		button20.setSubTitle("This is subtitle 12");
		button20.setPictureLink(SAMPLE_IMAGE_PATH);
		button20.setPicturePath(SAMPLE_IMAGE_PATH);
		button20.setButtonValues(actions2);
		ButtonBuilder buttonBuilder20 = new ButtonBuilder(button20);
		
		ButtonTemplate button21 = new ButtonTemplate();
		button21.setTitle("This is title 21");
		button21.setSubTitle("This is subtitle 21");
		button21.setPictureLink(SAMPLE_IMAGE_PATH);
		button21.setPicturePath(SAMPLE_IMAGE_PATH);
		button21.setButtonValues(actions2);
		ButtonBuilder buttonBuilder21 = new ButtonBuilder(button21);
		
		ButtonTemplate button22 = new ButtonTemplate();
		button22.setTitle("This is title 22");
		button22.setSubTitle("This is subtitle 22");
		button22.setPictureLink(SAMPLE_IMAGE_PATH);
		button22.setPicturePath(SAMPLE_IMAGE_PATH);
		button22.setButtonValues(actions2);
		ButtonBuilder buttonBuilder22 = new ButtonBuilder(button22);
		
		CarouselBuilder carouselBuilder = new CarouselBuilder(buttonBuilder.build(), buttonBuilder2.build(),buttonBuilder3.build(), buttonBuilder4.build(), buttonBuilder5.build(), buttonBuilder6.build(),
				buttonBuilder7.build(), buttonBuilder8.build(), buttonBuilder9.build(), buttonBuilder10.build(),buttonBuilder11.build(),buttonBuilder12.build(),
				buttonBuilder13.build(),buttonBuilder14.build(),buttonBuilder15.build(),buttonBuilder16.build(),buttonBuilder17.build(),buttonBuilder18.build(),
				buttonBuilder19.build(),buttonBuilder20.build(),buttonBuilder21.build(),buttonBuilder22.build());
		
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
	 * Generate Image
	 * 
	 * (non-Javadoc)
	 * @see com.imi.dolphin.sdkwebservice.service.IService#getImage(com.imi.dolphin.sdkwebservice.model.ExtensionRequest)
	 */
	@Override
	public ExtensionResult getImage(ExtensionRequest extensionRequest) {
		Map<String, String> output = new HashMap<>();

		ButtonTemplate image = new ButtonTemplate();
		image.setPictureLink(SAMPLE_IMAGE_PATH);
		image.setPicturePath(SAMPLE_IMAGE_PATH);

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

}
