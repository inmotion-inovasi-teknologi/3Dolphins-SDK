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

/**
 * @author sonny
 *
 */
public class ExtensionDialog implements Serializable {
	private static final long serialVersionUID = 6140264421056884944L;
	private String intention;
	private String integration;
	private String id;
	private String botId;
	private TicketModel ticket;

	public ExtensionDialog() {} 
	
	public ExtensionDialog(String id, String intent, String integration, String botId, TicketModel ticket) {
		this.id = id;
		this.intention = intent;
		this.integration = integration;
		this.botId = botId;
		this.ticket = ticket;
	}

	/**
	 * @return Get the intention
	 */
	public String getIntention() {
		return intention;
	}

	/**
	 * @param intention the intention to set
	 */
	public void setIntention(String intention) {
		this.intention = intention;
	}

	/**
	 * @return Get the integration
	 */
	public String getIntegration() {
		return integration;
	}

	/**
	 * @param integration the integration to set
	 */
	public void setIntegration(String integration) {
		this.integration = integration;
	}

	/**
	 * @return Get the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Get the botId
	 */
	public String getBotId() {
		return botId;
	}

	/**
	 * @param botId the botId to set
	 */
	public void setBotId(String botId) {
		this.botId = botId;
	}

	/**
	 * @return Get the ticket
	 */
	public TicketModel getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(TicketModel ticket) {
		this.ticket = ticket;
	}
}
