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

import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;

/**
 * 
 * @author reja
 *
 */
public interface AuthService {

	public boolean isValidAuthToken(ExtensionRequest extensionRequest);

}
