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
 * Information : [IMI core]
 * 
 **/
package com.imi.dolphin.sdkwebservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fadhil
 *
 */
public class TicketModel implements Serializable {
	private static final long serialVersionUID = -1224854675381796330L;

	private Long accessHash;
	private String accountId;
	private String accountName;
	private String accountScreen;
	private Boolean answer;
	private Boolean appraised;
	private String assignedAgent;
	private Date assignedDate;
	private String audioLink;
	private Boolean availableAttachment;
	private Boolean bigInfluencer;
	private String channel;
	private String channelKey;
	private String channelType;
	private Date closedDate;
	private Integer closeInterval;
	private String contactId;
	private String correlationId;
//	private Date createdDate;
	private String createdDateStr;
	private transient Map<String, Object> custom;
	private String documentLink;
	private List<String> documents;
	private String embedHtml;
	private String errorCode;
	private String errorMessage;
	private String errorShown;
	private Boolean escalated;
	private Date escalatedDate;
	private String escalatedFrom;
	private String escalatedTo;
	private Long followerCount;
	private Long friendCount;
	private String fromGroup;
	private String id;
	private Boolean incoming;
	private Double latitude;
	private Double longitude;
	private Boolean mention;
	private String message;
	private String messageId;
	private Boolean notified;
	private Date openDate;
	private Integer parent;
	private Date pendingDate;
	private String phone;
	private String pictureLink;
	private Boolean post;
	private String profileLink;
	private Boolean redistribute;
	private String remark;
	private String replyAgent;
	private String replyCc;
	private Long responseTime;
	private Long responseTimeAgent;
	private String status;
	private String subject;
	private String supervisor;
	private String ticketNumber;
	private String toGroup;
	private Date transferDate;
	private Boolean transfered;
	private String transferedFrom;
	private String transferedTo;
	private Long version;
	private String videoLink;
	private String ruleId;
	private String ruleOwner;
	private String ticketOwner;
	private Date unassignedDate;
	private String unassignedDateText;
	private Integer unassignedDuration;
	private Boolean greetingStatus;
	private List<String> ticketTags;
	
	private String clientMessageId;
	private String language;
	private Map<String, List<String>> termsMap;

	/**
	 * Add custom by field name and value
	 * 
	 * @param fieldName
	 * @param value
	 */
	public void addCustom(String fieldName, String value) {
		if (custom == null) {
			custom = new HashMap<>();
		}
		custom.put(fieldName, value);
	}

	/**
	 * @return the accessHash
	 */
	public Long getAccessHash() {
		return accessHash;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @return the accountScreen
	 */
	public String getAccountScreen() {
		return accountScreen;
	}

	/**
	 * @return the assignedAgent
	 */
	public String getAssignedAgent() {
		return assignedAgent;
	}

	/**
	 * @return the assignedDate
	 */
	public Date getAssignedDate() {
		return assignedDate;
	}

	/**
	 * @return the audioLink
	 */
	public String getAudioLink() {
		if (audioLink != null && !audioLink.contains(".ogg") && !audioLink.contains(".aac")
				&& !audioLink.contains(".mp3") && !audioLink.contains(".m4a")) {
			return "";
		}

		return audioLink;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @return the channel key
	 */
	public String getChannelKey() {
		return channelKey;
	}

	/**
	 * @return the channel type
	 */
	public String getChannelType() {
		return channelType;
	}

	/**
	 * @return the closed date
	 */
	public Date getClosedDate() {
		return closedDate;
	}

	/**
	 * @return the closeInterval
	 */
	public Integer getCloseInterval() {
		return closeInterval;
	}

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @return the customerIdentification
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @return the created date
	 */
//	public Date getCreatedDate() {
//		return createdDate;
//	}

	/**
	 * @return Get the createdDateStr
	 */
	public String getCreatedDateStr() {
		return createdDateStr;
	}

	/**
	 * @return array of custom
	 */
	public Map<String, Object> getCustom() {
		return custom;
	}

	/**
	 * @return the documentLink
	 */
	public String getDocumentLink() {
		return documentLink;
	}

	/**
	 * @return the documents
	 */
	public List<String> getDocuments() {
		return documents;
	}

	/**
	 * Get embedded html
	 * 
	 * @return
	 */
	public String getEmbedHtml() {
		return embedHtml;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the errorShown
	 */
	public String getErrorShown() {
		return errorShown;
	}

	/**
	 * Is escalated
	 * 
	 * @return
	 */
	public Boolean getEscalated() {
		return escalated;
	}

	/**
	 * @return the escalatedDate
	 */
	public Date getEscalatedDate() {
		return escalatedDate;
	}

	/**
	 * Get escalated from
	 * 
	 * @return
	 */
	public String getEscalatedFrom() {
		return escalatedFrom;
	}

	/**
	 * Supervisor receiving escalation
	 * 
	 * @return
	 */
	public String getEscalatedTo() {
		return escalatedTo;
	}

	/**
	 * @return the followerCount
	 */
	public Long getFollowerCount() {
		return followerCount;
	}

	/**
	 * @return the friendCount
	 */
	public Long getFriendCount() {
		return friendCount;
	}

	/**
	 * @return the fromGroup
	 */
	public String getFromGroup() {
		return fromGroup;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @return the Longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @return the open date
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * Parent indicator
	 * 
	 * @return
	 */
	public Integer getParent() {
		return parent;
	}

	/**
	 * @return the pending date
	 */
	public Date getPendingDate() {
		return pendingDate;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the pictureLink
	 */
	public String getPictureLink() {
		return pictureLink;
	}

	/**
	 * @return the profileLink
	 */
	public String getProfileLink() {
		return profileLink;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Get reply agent
	 * 
	 * @return
	 */
	public String getReplyAgent() {
		return replyAgent;
	}

	/**
	 * @return the replyEmails
	 */
	public String getReplyCc() {
		return replyCc;
	}

	/**
	 * @return the responseTime
	 */
	public Long getResponseTime() {
		return responseTime;
	}

	/**
	 * @return the responseTimeAgent
	 */
	public Long getResponseTimeAgent() {
		return responseTimeAgent;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @return the ticket number
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * @return the toGroup
	 */
	public String getToGroup() {
		return toGroup;
	}

	/**
	 * @return the transferDate
	 */
	public Date getTransferDate() {
		return transferDate;
	}

	/**
	 * Get transfered status
	 * 
	 * @return
	 */
	public Boolean getTransfered() {
		return transfered;
	}

	/**
	 * Get transfered from
	 * 
	 * @return
	 */
	public String getTransferedFrom() {
		return transferedFrom;
	}

	/**
	 * Get transfered status
	 * 
	 * @return
	 */
	public String getTransferedTo() {
		return transferedTo;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @return the videoLink
	 */
	public String getVideoLink() {
		if (videoLink != null && !videoLink.contains(".mp4")) {
			return "";
		}
		return videoLink;
	}

	/**
	 * @return the answer
	 */
	public Boolean isAnswer() {
		return answer;
	}

	/**
	 * @return appraised
	 */
	public Boolean isAppraised() {
		return appraised;
	}

	/**
	 * @return the availableAttachment
	 */
	public Boolean isAvailableAttachment() {
		return availableAttachment;
	}

	/**
	 * @return the bigInfluencer
	 */
	public Boolean isBigInfluencer() {
		return bigInfluencer;
	}

	/**
	 * @return the incoming
	 */
	public Boolean isIncoming() {
		return incoming;
	}

	/**
	 * @return the mention
	 */
	public Boolean isMention() {
		return mention;
	}

	/**
	 * @return the notified
	 */
	public Boolean isNotified() {
		return notified;
	}

	/**
	 * @return the post
	 */
	public Boolean isPost() {
		return post;
	}

	/**
	 * @return the redistribute
	 */
	public Boolean isRedistribute() {
		return redistribute;
	}

	/**
	 * @param accessHash
	 *            the accessHash to set
	 */
	public void setAccessHash(Long accessHash) {
		this.accessHash = accessHash;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @param accountScreen
	 *            the accountScreen to set
	 */
	public void setAccountScreen(String accountScreen) {
		this.accountScreen = accountScreen;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

	/**
	 * 
	 * @param appraised
	 *            the appraised to set
	 */
	public void setAppraised(Boolean appraised) {
		this.appraised = appraised;
	}

	/**
	 * @param assignedAgent
	 *            the assignedAgent to set
	 */
	public void setAssignedAgent(String assignedAgent) {
		this.assignedAgent = assignedAgent;
	}

	/**
	 * @param assignedDate
	 *            the assignedDate to set
	 */
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	/**
	 * @param audioLink
	 *            the audioLink to set
	 */
	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
	}

	/**
	 * @param availableAttachment
	 *            the availableAttachment to set
	 */
	public void setAvailableAttachment(Boolean availableAttachment) {
		this.availableAttachment = availableAttachment;
	}

	/**
	 * @param bigInfluencer
	 *            the bigInfluencer to set
	 */
	public void setBigInfluencer(Boolean bigInfluencer) {
		this.bigInfluencer = bigInfluencer;
	}

	/**
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @param channelKey
	 *            the channel key to set
	 */
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	/**
	 * @param channelType
	 *            the channel type to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	/**
	 * @param closedDate
	 *            the closed date to set
	 */
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	/**
	 * @param closeInterval
	 *            the closeInterval to set
	 */
	public void setCloseInterval(Integer closeInterval) {
		this.closeInterval = closeInterval;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @param correlationId
	 *            the customerIdentification to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @param createdDate
	 *            the created date to set
	 */
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}

	/**
	 * @param createdDateStr
	 *            the createdDateStr to set
	 */
	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}

	/**
	 * @param custom
	 *            the array od custom to set
	 */
	public void setCustom(Map<String, Object> custom) {
		this.custom = custom;
	}

	/**
	 * @param documentLink
	 *            the documentLink to set
	 */
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}

	/**
	 * @param documents
	 *            the documents to set
	 */
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}

	/**
	 * Set embedded html
	 * 
	 * @param embedHtml
	 */
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @param errorShown
	 *            the errorShown to set
	 */
	public void setErrorShown(String errorShown) {
		this.errorShown = errorShown;
	}

	/**
	 * Set escalated status
	 * 
	 * @param
	 */
	public void setEscalated(Boolean escalated) {
		this.escalated = escalated;
	}

	/**
	 * @param escalatedDate
	 *            the escalatedDate to set
	 */
	public void setEscalatedDate(Date escalatedDate) {
		this.escalatedDate = escalatedDate;
	}

	/**
	 * Set escalated from
	 * 
	 * @param escalatedFrom
	 */
	public void setEscalatedFrom(String escalatedFrom) {
		this.escalatedFrom = escalatedFrom;
	}

	/**
	 * Supervisor receiving escalation
	 * 
	 * @return
	 */
	public void setEscalatedTo(String escalatedTo) {
		this.escalatedTo = escalatedTo;
	}

	/**
	 * @param followerCount
	 *            the followerCount to set
	 */
	public void setFollowerCount(Long followerCount) {
		this.followerCount = followerCount;
	}

	/**
	 * @param friendCount
	 *            the friendCount to set
	 */
	public void setFriendCount(Long friendCount) {
		this.friendCount = friendCount;
	}

	/**
	 * 
	 * @param fromGroup
	 *            the fromGroup to set
	 */
	public void setFromGroup(String fromGroup) {
		this.fromGroup = fromGroup;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param incoming
	 *            the incoming to set
	 */
	public void setIncoming(Boolean incoming) {
		this.incoming = incoming;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param Longitude
	 *            the Longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param mention
	 *            the mention to set
	 */
	public void setMention(Boolean mention) {
		this.mention = mention;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @param notified
	 *            the notified to set
	 */
	public void setNotified(Boolean notified) {
		this.notified = notified;
	}

	/**
	 * @param openDate
	 *            the open date to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * Parent indicator
	 * 
	 * @param parent
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}

	/**
	 * @param pendingDate
	 *            the pending date to set
	 */
	public void setPendingDate(Date pendingDate) {
		this.pendingDate = pendingDate;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param pictureLink
	 *            the pictureLink to set
	 */
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(Boolean post) {
		this.post = post;
	}

	/**
	 * @param profileLink
	 *            the profileLink to set
	 */
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	/**
	 * @param redistribute
	 *            the redistribute to set
	 */
	public void setRedistribute(Boolean redistribute) {
		this.redistribute = redistribute;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Set reply agent
	 * 
	 * @param replyAgent
	 */
	public void setReplyAgent(String replyAgent) {
		this.replyAgent = replyAgent;
	}

	/**
	 * @param replyCc
	 *            the replyEmails to set
	 */
	public void setReplyCc(String replyCc) {
		this.replyCc = replyCc;
	}

	/**
	 * @param responseTime
	 *            the responseTime to set
	 */
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * @param responseTimeAgent
	 *            the responseTimeAgent to set
	 */
	public void setResponseTimeAgent(Long responseTimeAgent) {
		this.responseTimeAgent = responseTimeAgent;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param supervisor
	 *            the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @param ticketNumber
	 *            the ticketNumber to set
	 */
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/**
	 * @param toGroup
	 *            the toGroup to set
	 */
	public void setToGroup(String toGroup) {
		this.toGroup = toGroup;
	}

	/**
	 * @param transferDate
	 *            the transferDate to set
	 */
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * Set transfered status
	 * 
	 * @param transfered
	 */
	public void setTransfered(Boolean transfered) {
		this.transfered = transfered;
	}

	/**
	 * Set transfered from
	 * 
	 * @param transferedFrom
	 */
	public void setTransferedFrom(String transferedFrom) {
		this.transferedFrom = transferedFrom;
	}

	/**
	 * Set transfered status
	 * 
	 * @param transferedTo
	 */
	public void setTransferedTo(String transferedTo) {
		this.transferedTo = transferedTo;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @param videoLink
	 *            the videoLink to set
	 */
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	/**
	 * @return Get the clientMessageId
	 */
	public String getClientMessageId() {
		return clientMessageId;
	}

	/**
	 * @param clientMessageId
	 *            the clientMessageId to set
	 */
	public void setClientMessageId(String clientMessageId) {
		this.clientMessageId = clientMessageId;
	}

	/**
	 * @return Get the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}


	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}

	/**
	 * @param ruleId
	 *            the ruleId to set
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	/**
	 * @return the ruleOwner
	 */
	public String getRuleOwner() {
		return ruleOwner;
	}

	/**
	 * @param ruleOwner
	 *            the ruleOwner to set
	 */
	public void setRuleOwner(String ruleOwner) {
		this.ruleOwner = ruleOwner;
	}

	/**
	 * @return the ticketOwner
	 */
	public String getTicketOwner() {
		return ticketOwner;
	}

	/**
	 * @param ticketOwner
	 *            the ticketOwner to set
	 */
	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}

	/**
	 * @return the unassignedDate
	 */
	public Date getUnassignedDate() {
		return unassignedDate;
	}

	/**
	 * @param unassignedDate
	 *            the unassignedDate to set
	 */
	public void setUnassignedDate(Date unassignedDate) {
		this.unassignedDate = unassignedDate;
	}

	/**
	 * @return the unassignedDateText
	 */
	public String getUnassignedDateText() {
		return unassignedDateText;
	}

	/**
	 * @param unassignedDateText
	 *            the unassignedDateText to set
	 */
	public void setUnassignedDateText(String unassignedDateText) {
		this.unassignedDateText = unassignedDateText;
	}

	/**
	 * @return the unassignedDuration
	 */
	public Integer getUnassignedDuration() {
		return unassignedDuration;
	}

	/**
	 * @param unassignedDuration
	 *            the unassignedDuration to set
	 */
	public void setUnassignedDuration(Integer unassignedDuration) {
		this.unassignedDuration = unassignedDuration;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getGreetingStatus() {
		return greetingStatus;
	}

	/**
	 * @param greetingStatus
	 *            the autoGreeted to set
	 */
	public void setGreetingStatus(Boolean greetingStatus) {
		this.greetingStatus = greetingStatus;
	}
	
	/**
	 * @return Get the ticketTags
	 */
	public List<String> getTicketTags() {
		return ticketTags;
	}

	/**
	 * @param ticketTags the ticketTags to set
	 */
	public void setTicketTags(List<String> ticketTags) {
		this.ticketTags = ticketTags;
	}
	

	/**
	 * @return Get the termsMap
	 */
	public Map<String, List<String>> getTermsMap() {
		return termsMap;
	}

	/**
	 * @param termsMap the termsMap to set
	 */
	public void setTermsMap(Map<String, List<String>> termsMap) {
		this.termsMap = termsMap;
	}

}
