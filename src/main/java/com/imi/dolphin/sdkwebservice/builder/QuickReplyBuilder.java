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
 * Quick Reply Template 
 * ex : {replies:title=Hello@===@hello world,Java@===@hello java}
 * 
 * @author reja
 *
 */
public class QuickReplyBuilder {
	private StringBuilder quickReply;

	public QuickReplyBuilder() {
		
	}
	
	/**
	 * 
	 * @param builder
	 */
	public QuickReplyBuilder(Builder builder) {
		this.quickReply = builder.quickReply;
	}

	/**
	 * 
	 * @return quick reply string
	 */
	public String string() {
		return quickReply.toString();
	}

	public static class Builder {
		private static final String QUICK_REPLY_SYNTAX = "{replies:title=";
		private static final String QUICK_REPLY_SYNTAX_SUFFIX = "}";
		private static final String COMMA = ",";
		String title;
		StringBuilder quickReply;

		/**
		 * 
		 * @param title
		 */
		public Builder(String title) {
			if (quickReply == null) {
				quickReply = new StringBuilder();
				quickReply.append(QUICK_REPLY_SYNTAX);
				quickReply.append(title).append(COMMA);
			}
		}

		/**
		 * 
		 * @param label
		 * @param payload
		 * @return
		 */
		public Builder add(String label, String payload) {
			if (quickReply != null) {
				quickReply.append(label).append("@===@").append(payload).append(COMMA);
			}
			return this;
		}

		/**
		 * 
		 * @return quick reply builder
		 */
		public QuickReplyBuilder build() {
			quickReply.replace(quickReply.toString().length() - 1, quickReply.toString().length(), "");
			quickReply.append(QUICK_REPLY_SYNTAX_SUFFIX);
			return new QuickReplyBuilder(this);
		}
	}

}
