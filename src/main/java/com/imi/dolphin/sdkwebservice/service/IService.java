package com.imi.dolphin.sdkwebservice.service;

import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.model.ExtensionResult;

public interface IService {
	
	ExtensionResult getSrnResult(ExtensionRequest extensionRequest);
	
	ExtensionResult getCustomerInfo(ExtensionRequest extensionRequest);
	
	ExtensionResult modifyCustomerName(ExtensionRequest extensionRequest);
	
	ExtensionResult getProductInfo(ExtensionRequest extensionRequest);
	
	ExtensionResult getMessageBody(ExtensionRequest extensionRequest);
	
	ExtensionResult getQuickReplies(ExtensionRequest extensionRequest);
	
	ExtensionResult getForms(ExtensionRequest extensionRequest);
	
	ExtensionResult getButtons(ExtensionRequest extensionRequest);
	
	ExtensionResult getCarousel(ExtensionRequest extensionRequest);
	
	ExtensionResult doTransferToAgent(ExtensionRequest extensionRequest);

	ExtensionResult doSendLocation(ExtensionRequest extensionRequest);

	ExtensionResult getImage(ExtensionRequest extensionRequest);
	
	ExtensionResult getSplitConversation(ExtensionRequest extensionRequest);
}
