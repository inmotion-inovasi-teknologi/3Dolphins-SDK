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
	private String assignedDate;
	private String audioLink;
	private Boolean availableAttachment;
	private Boolean bigInfluencer;
	private String channel;
	private String channelKey;
	private String channelType;
	private String closedDate;
	private Integer closeInterval;
	private String contactId;
	private String correlationId;
	private String createdDate;
	private String createdDateStr;
	private transient Map<String, Object> custom;
	private String documentLink;
	private List<String> documents;
	private String embedHtml;
	private String errorCode;
	private String errorMessage;
	private String errorShown;
	private Boolean escalated;
	private String escalatedDate;
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
	private String openDate;
	private Integer parent;
	private String pendingDate;
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
	private String transferDate;
	private Boolean transfered;
	private String transferedFrom;
	private String transferedTo;
	private Long version;
	private String videoLink;
	private String ruleId;
	private String ruleOwner;
	private String ticketOwner;
	private String unassignedDate;
	private String unassignedDateText;
	private Integer unassignedDuration;
	private Boolean greetingStatus;
	private List<String> ticketTags;
	
	private String clientMessageId;
	private String language;
	private Map<String, List<String>> termsMap;
	
	private String userMessage;

	/**
	 * @return the accessHash
	 */
	public Long getAccessHash() {
		return accessHash;
	}

	/**
	 * @param accessHash the accessHash to set
	 */
	public void setAccessHash(Long accessHash) {
		this.accessHash = accessHash;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountScreen
	 */
	public String getAccountScreen() {
		return accountScreen;
	}

	/**
	 * @param accountScreen the accountScreen to set
	 */
	public void setAccountScreen(String accountScreen) {
		this.accountScreen = accountScreen;
	}

	/**
	 * @return the answer
	 */
	public Boolean getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

	/**
	 * @return the appraised
	 */
	public Boolean getAppraised() {
		return appraised;
	}

	/**
	 * @param appraised the appraised to set
	 */
	public void setAppraised(Boolean appraised) {
		this.appraised = appraised;
	}

	/**
	 * @return the assignedAgent
	 */
	public String getAssignedAgent() {
		return assignedAgent;
	}

	/**
	 * @param assignedAgent the assignedAgent to set
	 */
	public void setAssignedAgent(String assignedAgent) {
		this.assignedAgent = assignedAgent;
	}

	/**
	 * @return the assignedDate
	 */
	public String getAssignedDate() {
		return assignedDate;
	}

	/**
	 * @param assignedDate the assignedDate to set
	 */
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	/**
	 * @return the audioLink
	 */
	public String getAudioLink() {
		return audioLink;
	}

	/**
	 * @param audioLink the audioLink to set
	 */
	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
	}

	/**
	 * @return the availableAttachment
	 */
	public Boolean getAvailableAttachment() {
		return availableAttachment;
	}

	/**
	 * @param availableAttachment the availableAttachment to set
	 */
	public void setAvailableAttachment(Boolean availableAttachment) {
		this.availableAttachment = availableAttachment;
	}

	/**
	 * @return the bigInfluencer
	 */
	public Boolean getBigInfluencer() {
		return bigInfluencer;
	}

	/**
	 * @param bigInfluencer the bigInfluencer to set
	 */
	public void setBigInfluencer(Boolean bigInfluencer) {
		this.bigInfluencer = bigInfluencer;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the channelKey
	 */
	public String getChannelKey() {
		return channelKey;
	}

	/**
	 * @param channelKey the channelKey to set
	 */
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}

	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	/**
	 * @return the closedDate
	 */
	public String getClosedDate() {
		return closedDate;
	}

	/**
	 * @param closedDate the closedDate to set
	 */
	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	/**
	 * @return the closeInterval
	 */
	public Integer getCloseInterval() {
		return closeInterval;
	}

	/**
	 * @param closeInterval the closeInterval to set
	 */
	public void setCloseInterval(Integer closeInterval) {
		this.closeInterval = closeInterval;
	}

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdDateStr
	 */
	public String getCreatedDateStr() {
		return createdDateStr;
	}

	/**
	 * @param createdDateStr the createdDateStr to set
	 */
	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}

	/**
	 * @return the custom
	 */
	public Map<String, Object> getCustom() {
		return custom;
	}

	/**
	 * @param custom the custom to set
	 */
	public void setCustom(Map<String, Object> custom) {
		this.custom = custom;
	}

	/**
	 * @return the documentLink
	 */
	public String getDocumentLink() {
		return documentLink;
	}

	/**
	 * @param documentLink the documentLink to set
	 */
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}

	/**
	 * @return the documents
	 */
	public List<String> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}

	/**
	 * @return the embedHtml
	 */
	public String getEmbedHtml() {
		return embedHtml;
	}

	/**
	 * @param embedHtml the embedHtml to set
	 */
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorShown
	 */
	public String getErrorShown() {
		return errorShown;
	}

	/**
	 * @param errorShown the errorShown to set
	 */
	public void setErrorShown(String errorShown) {
		this.errorShown = errorShown;
	}

	/**
	 * @return the escalated
	 */
	public Boolean getEscalated() {
		return escalated;
	}

	/**
	 * @param escalated the escalated to set
	 */
	public void setEscalated(Boolean escalated) {
		this.escalated = escalated;
	}

	/**
	 * @return the escalatedDate
	 */
	public String getEscalatedDate() {
		return escalatedDate;
	}

	/**
	 * @param escalatedDate the escalatedDate to set
	 */
	public void setEscalatedDate(String escalatedDate) {
		this.escalatedDate = escalatedDate;
	}

	/**
	 * @return the escalatedFrom
	 */
	public String getEscalatedFrom() {
		return escalatedFrom;
	}

	/**
	 * @param escalatedFrom the escalatedFrom to set
	 */
	public void setEscalatedFrom(String escalatedFrom) {
		this.escalatedFrom = escalatedFrom;
	}

	/**
	 * @return the escalatedTo
	 */
	public String getEscalatedTo() {
		return escalatedTo;
	}

	/**
	 * @param escalatedTo the escalatedTo to set
	 */
	public void setEscalatedTo(String escalatedTo) {
		this.escalatedTo = escalatedTo;
	}

	/**
	 * @return the followerCount
	 */
	public Long getFollowerCount() {
		return followerCount;
	}

	/**
	 * @param followerCount the followerCount to set
	 */
	public void setFollowerCount(Long followerCount) {
		this.followerCount = followerCount;
	}

	/**
	 * @return the friendCount
	 */
	public Long getFriendCount() {
		return friendCount;
	}

	/**
	 * @param friendCount the friendCount to set
	 */
	public void setFriendCount(Long friendCount) {
		this.friendCount = friendCount;
	}

	/**
	 * @return the fromGroup
	 */
	public String getFromGroup() {
		return fromGroup;
	}

	/**
	 * @param fromGroup the fromGroup to set
	 */
	public void setFromGroup(String fromGroup) {
		this.fromGroup = fromGroup;
	}

	/**
	 * @return the id
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
	 * @return the incoming
	 */
	public Boolean getIncoming() {
		return incoming;
	}

	/**
	 * @param incoming the incoming to set
	 */
	public void setIncoming(Boolean incoming) {
		this.incoming = incoming;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the mention
	 */
	public Boolean getMention() {
		return mention;
	}

	/**
	 * @param mention the mention to set
	 */
	public void setMention(Boolean mention) {
		this.mention = mention;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the notified
	 */
	public Boolean getNotified() {
		return notified;
	}

	/**
	 * @param notified the notified to set
	 */
	public void setNotified(Boolean notified) {
		this.notified = notified;
	}

	/**
	 * @return the openDate
	 */
	public String getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the parent
	 */
	public Integer getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}

	/**
	 * @return the pendingDate
	 */
	public String getPendingDate() {
		return pendingDate;
	}

	/**
	 * @param pendingDate the pendingDate to set
	 */
	public void setPendingDate(String pendingDate) {
		this.pendingDate = pendingDate;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the pictureLink
	 */
	public String getPictureLink() {
		return pictureLink;
	}

	/**
	 * @param pictureLink the pictureLink to set
	 */
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	/**
	 * @return the post
	 */
	public Boolean getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Boolean post) {
		this.post = post;
	}

	/**
	 * @return the profileLink
	 */
	public String getProfileLink() {
		return profileLink;
	}

	/**
	 * @param profileLink the profileLink to set
	 */
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	/**
	 * @return the redistribute
	 */
	public Boolean getRedistribute() {
		return redistribute;
	}

	/**
	 * @param redistribute the redistribute to set
	 */
	public void setRedistribute(Boolean redistribute) {
		this.redistribute = redistribute;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the replyAgent
	 */
	public String getReplyAgent() {
		return replyAgent;
	}

	/**
	 * @param replyAgent the replyAgent to set
	 */
	public void setReplyAgent(String replyAgent) {
		this.replyAgent = replyAgent;
	}

	/**
	 * @return the replyCc
	 */
	public String getReplyCc() {
		return replyCc;
	}

	/**
	 * @param replyCc the replyCc to set
	 */
	public void setReplyCc(String replyCc) {
		this.replyCc = replyCc;
	}

	/**
	 * @return the responseTime
	 */
	public Long getResponseTime() {
		return responseTime;
	}

	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * @return the responseTimeAgent
	 */
	public Long getResponseTimeAgent() {
		return responseTimeAgent;
	}

	/**
	 * @param responseTimeAgent the responseTimeAgent to set
	 */
	public void setResponseTimeAgent(Long responseTimeAgent) {
		this.responseTimeAgent = responseTimeAgent;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the ticketNumber
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * @param ticketNumber the ticketNumber to set
	 */
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/**
	 * @return the toGroup
	 */
	public String getToGroup() {
		return toGroup;
	}

	/**
	 * @param toGroup the toGroup to set
	 */
	public void setToGroup(String toGroup) {
		this.toGroup = toGroup;
	}

	/**
	 * @return the transferDate
	 */
	public String getTransferDate() {
		return transferDate;
	}

	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * @return the transfered
	 */
	public Boolean getTransfered() {
		return transfered;
	}

	/**
	 * @param transfered the transfered to set
	 */
	public void setTransfered(Boolean transfered) {
		this.transfered = transfered;
	}

	/**
	 * @return the transferedFrom
	 */
	public String getTransferedFrom() {
		return transferedFrom;
	}

	/**
	 * @param transferedFrom the transferedFrom to set
	 */
	public void setTransferedFrom(String transferedFrom) {
		this.transferedFrom = transferedFrom;
	}

	/**
	 * @return the transferedTo
	 */
	public String getTransferedTo() {
		return transferedTo;
	}

	/**
	 * @param transferedTo the transferedTo to set
	 */
	public void setTransferedTo(String transferedTo) {
		this.transferedTo = transferedTo;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @return the videoLink
	 */
	public String getVideoLink() {
		return videoLink;
	}

	/**
	 * @param videoLink the videoLink to set
	 */
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}

	/**
	 * @param ruleId the ruleId to set
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
	 * @param ruleOwner the ruleOwner to set
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
	 * @param ticketOwner the ticketOwner to set
	 */
	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}

	/**
	 * @return the unassignedDate
	 */
	public String getUnassignedDate() {
		return unassignedDate;
	}

	/**
	 * @param unassignedDate the unassignedDate to set
	 */
	public void setUnassignedDate(String unassignedDate) {
		this.unassignedDate = unassignedDate;
	}

	/**
	 * @return the unassignedDateText
	 */
	public String getUnassignedDateText() {
		return unassignedDateText;
	}

	/**
	 * @param unassignedDateText the unassignedDateText to set
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
	 * @param unassignedDuration the unassignedDuration to set
	 */
	public void setUnassignedDuration(Integer unassignedDuration) {
		this.unassignedDuration = unassignedDuration;
	}

	/**
	 * @return the greetingStatus
	 */
	public Boolean getGreetingStatus() {
		return greetingStatus;
	}

	/**
	 * @param greetingStatus the greetingStatus to set
	 */
	public void setGreetingStatus(Boolean greetingStatus) {
		this.greetingStatus = greetingStatus;
	}

	/**
	 * @return the ticketTags
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
	 * @return the clientMessageId
	 */
	public String getClientMessageId() {
		return clientMessageId;
	}

	/**
	 * @param clientMessageId the clientMessageId to set
	 */
	public void setClientMessageId(String clientMessageId) {
		this.clientMessageId = clientMessageId;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the termsMap
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

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
