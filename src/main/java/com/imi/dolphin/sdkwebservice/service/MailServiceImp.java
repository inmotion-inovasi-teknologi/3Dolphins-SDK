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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imi.dolphin.sdkwebservice.model.MailModel;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.util.MailUtil;

/**
 * 
 * @author reja
 *
 */
@Service
public class MailServiceImp implements IMailService {

	@Autowired
	MailUtil mailUtil;
	
	@Autowired
	AppProperties appProperties;
	
	@Override
	public String sendMail(MailModel mailModel) {
		try {
			Message message = new MimeMessage(mailUtil.getMailSession());
			message.setFrom(new InternetAddress(appProperties.getMailUsername()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailModel.getRecipient()));
			message.setSubject(mailModel.getSubject());
			message.setText(mailModel.getText());
			Transport.send(message);

			return "Sent message successfully....";
		} catch (MessagingException e) {

		}
		return "Sent message failed...";
	}

}
