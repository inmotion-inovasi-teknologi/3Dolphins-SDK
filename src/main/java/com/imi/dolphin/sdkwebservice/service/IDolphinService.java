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

import com.imi.dolphin.sdkwebservice.model.Contact;
import com.imi.dolphin.sdkwebservice.model.UserToken;

/**
 * 
 * @author reja
 *
 */
public interface IDolphinService {
	public boolean isTokenExistAndNotExpired(UserToken userToken);
	
	public UserToken getUserToken(UserToken userToken);
	
	public Contact getCustomer(UserToken userToken, String contactId);
	
	public Contact updateCustomer(UserToken userToken, Contact contact);
}
