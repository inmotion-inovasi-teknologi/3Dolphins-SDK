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
 * Creator: Sonny Hastomo
 * Information : [IMI ui]
 * 
 */
package com.imi.dolphin.sdkwebservice.model;

import java.io.Serializable;

/**
 * Provide function as name value map information holder 
 * 
 * @author Sonny Hastomo
 * 
 */
public class EasyMap implements Serializable {
	private static final long serialVersionUID = 2688060147811229470L;
	private String name;
	private String value;

	public EasyMap() {}
	
	public EasyMap(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Get name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get value
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set value
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
