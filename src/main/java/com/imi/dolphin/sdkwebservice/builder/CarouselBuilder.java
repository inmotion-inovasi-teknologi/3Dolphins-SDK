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

package com.imi.dolphin.sdkwebservice.builder;

/**
 * 
 * @author reja
 *
 */
public class CarouselBuilder {
	private String buttonBuilders;
	private StringBuilder stringBuilder;
	private static final String CONSTANT_SPLIT_SYNTAX = "&split&";
	
	/**
	 * 
	 * @param buttonTemplateEntities
	 */
	public CarouselBuilder(String... buttonBuilders) {
		for(String buttonBuilder: buttonBuilders) {
			if(stringBuilder==null) {
				stringBuilder = new StringBuilder();
			}
			stringBuilder.append(buttonBuilder).append(CONSTANT_SPLIT_SYNTAX);
		}
		this.buttonBuilders = stringBuilder.toString();
	}
	
	/**
	 * 
	 * @return button string
	 */
	public String build() {
		return getButtonBuilders();
	}

	public String getButtonBuilders() {
		return buttonBuilders;
	}

	public void setButtonBuilders(String buttonBuilders) {
		this.buttonBuilders = buttonBuilders;
	}

	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}

}
