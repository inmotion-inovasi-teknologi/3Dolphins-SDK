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
package com.imi.dolphin.sdkwebservice.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author reja
 *
 */

@JsonInclude(Include.NON_NULL)
public class ExtensionResult implements Serializable {
	private static final long serialVersionUID = 1768303005374821099L;
	private Map<String, String> value;
	private boolean next;
	private boolean success;
	private boolean repeat;
	private boolean agent;
	private Map<String, String> entities;
	
	private Map<String, EasyMap> parameters;


	/**
	 * @return Get the value
	 */
	public Map<String, String> getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Map<String, String> value) {
		this.value = value;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return Get the repeat
	 */
	public boolean isRepeat() {
		return repeat;
	}

	/**
	 * @param repeat
	 *            the repeat to set
	 */
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	/**
	 * @return Get the cont
	 */
	public boolean isNext() {
		return next;
	}

	/**
	 * @param cont
	 *            the cont to set
	 */
	public void setNext(boolean next) {
		this.next = next;
	}

	/**
	 * @return Get the agent
	 */
	public boolean isAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setAgent(boolean agent) {
		this.agent = agent;
	}

	/**
	 * @return the entities
	 */
	public Map<String, String> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(Map<String, String> entities) {
		this.entities = entities;
	}
	
	/**
	 * @return Get the parameters
	 */
	public Map<String, EasyMap> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(Map<String, EasyMap> parameters) {
		this.parameters = parameters;
	}
}

