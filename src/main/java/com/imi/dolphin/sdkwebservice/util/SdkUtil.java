package com.imi.dolphin.sdkwebservice.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.imi.dolphin.sdkwebservice.model.EasyMap;
import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.param.ParamSdk;

@Component
public class SdkUtil {
	private static final Logger log = LogManager.getLogger(SdkUtil.class);

	/**
	 * Get parameter value from request body parameter
	 * 
	 * @param extensionRequest
	 * @param name
	 * @return
	 */
	public String getEasyMapValueByName(ExtensionRequest extensionRequest, String name) {
		log.debug("getEasyMapValueByName() extension request: {} name: {}", extensionRequest, name);
		EasyMap easyMap = extensionRequest.getParameters().stream().filter(x -> x.getName().equals(name)).findAny()
				.orElse(null);
		if (easyMap != null) {
			return easyMap.getValue();
		}
		return ParamSdk.CONSTANT_EMPTY;
	}
	
}
