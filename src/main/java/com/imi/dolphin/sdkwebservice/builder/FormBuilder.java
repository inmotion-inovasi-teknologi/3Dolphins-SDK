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
