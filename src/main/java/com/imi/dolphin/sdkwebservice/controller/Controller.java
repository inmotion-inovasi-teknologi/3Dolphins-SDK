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
package com.imi.dolphin.sdkwebservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.model.ExtensionResult;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.service.IMailService;
import com.imi.dolphin.sdkwebservice.service.IService;

/**
 * 
 * @author reja
 * 
 */
@RestController
public class Controller {
	private static final Logger log = LogManager.getLogger(Controller.class);

	@Autowired
	private AppProperties appProperties;

	@Autowired
	IService svcService;
	
	@Autowired
	IMailService svcMailService;

	@RequestMapping("/ping")
	@PostMapping
	public ExtensionResult doPingRequest(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getDolphinResponse(extensionRequest);
	}
	
	@RequestMapping("/pingAuth")
	@PostMapping
	public ExtensionResult doPingAuthRequest(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getPingResponse(extensionRequest);
	}
	
	@RequestMapping("/forms")
	public String getStarted() {
		log.debug("getStarted() service port: {}", appProperties.getServicePort());
		return "Hello Form, service port: " + appProperties.getServicePort() + ", " + appProperties.getFormId();
	}

	@RequestMapping("/status/")
	@PostMapping
	public ExtensionResult doGetSrnResult(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getSrnResult(extensionRequest);
	}

	@RequestMapping("/customers")
	@PostMapping
	public ExtensionResult doQueryCustomerInfo(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getCustomerInfo(extensionRequest);
	}

	@RequestMapping("/modifycustomername")
	@PostMapping
	public ExtensionResult doClearCustomerName(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.modifyCustomerName(extensionRequest);
	}
	
	@RequestMapping("/productinfo")
	@PostMapping
	public ExtensionResult doQueryProductInfo(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getProductInfo(extensionRequest);
	}

	@RequestMapping("/messages")
	@PostMapping
	public ExtensionResult doGetMessages(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getMessageBody(extensionRequest);
	}

	@RequestMapping("/quickreplies")
	@PostMapping
	public ExtensionResult doBuildQuickReplies(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getQuickReplies(extensionRequest);
	}

	@RequestMapping("/form")
	@PostMapping
	public ExtensionResult doBuildForm(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getForms(extensionRequest);
	}

	@RequestMapping("/button")
	@PostMapping
	public ExtensionResult doBuildButton(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getButtons(extensionRequest);
	}

	@RequestMapping("/carousel")
	@PostMapping
	public ExtensionResult doBuildCarousel(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getCarousel(extensionRequest);
	}
	
	@RequestMapping("/transferAgent")
	@PostMapping
	public ExtensionResult doTransferToAgent(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.doTransferToAgent(extensionRequest);
	}
	
	@RequestMapping("/sendLocation")
	@PostMapping
	public ExtensionResult doBuildSendLocation(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.doSendLocation(extensionRequest);
	}
	
	@RequestMapping("/image")
	@PostMapping
	public ExtensionResult doBuildImage(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getImage(extensionRequest);
	}
	
	@RequestMapping("/sendMail")
	@PostMapping
	public ExtensionResult doSendMail(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.doSendMail(extensionRequest);
	}

}
