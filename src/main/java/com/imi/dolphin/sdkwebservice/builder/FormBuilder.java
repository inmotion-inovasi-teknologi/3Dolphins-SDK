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
 * Form Template
 * ex : {form:formID}
 * 
 * @author reja
 *
 */
public class FormBuilder {
	private static final String FORM_SYNTAX = "{form:";
	private static final String FORM_SYNTAX_SUFFIX = "}";
	
	private String formId;
	
	/**
	 * 
	 * @param formId
	 */
	public FormBuilder(String formId) {
		this.formId = formId;
	}
	
	/**
	 * 
	 * @return form string
	 */
	public String build() {
		StringBuilder form = new StringBuilder();
		form.append(FORM_SYNTAX).append(formId).append(FORM_SYNTAX_SUFFIX);
		return form.toString();
	}
}
