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

package com.imi.dolphin.sdkwebservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author reja
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.imi.dolphin.sdkwebservice"})
public class SdkWebserviceApplication {
	private static final Logger log = LogManager.getLogger(SdkWebserviceApplication.class);

	public static void main(String[] args) {
		log.debug("SdkWebserviceApplication started...");
		SpringApplication.run(SdkWebserviceApplication.class, args);
	}
}
