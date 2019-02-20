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
	public Long getAccessHash() {
		return accessHash;
	}
	public void setAccessHash(Long accessHash) {
		this.accessHash = accessHash;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountScreen() {
		return accountScreen;
	}
	public void setAccountScreen(String accountScreen) {
		this.accountScreen = accountScreen;
	}
	public Boolean getAnswer() {
		return answer;
	}
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
	public Boolean getAppraised() {
		return appraised;
	}
	public void setAppraised(Boolean appraised) {
		this.appraised = appraised;
	}
	public String getAssignedAgent() {
		return assignedAgent;
	}
	public void setAssignedAgent(String assignedAgent) {
		this.assignedAgent = assignedAgent;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getAudioLink() {
		return audioLink;
	}
	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
	}
	public Boolean getAvailableAttachment() {
		return availableAttachment;
	}
	public void setAvailableAttachment(Boolean availableAttachment) {
		this.availableAttachment = availableAttachment;
	}
	public Boolean getBigInfluencer() {
		return bigInfluencer;
	}
	public void setBigInfluencer(Boolean bigInfluencer) {
		this.bigInfluencer = bigInfluencer;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getChannelKey() {
		return channelKey;
	}
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	public Integer getCloseInterval() {
		return closeInterval;
	}
	public void setCloseInterval(Integer closeInterval) {
		this.closeInterval = closeInterval;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedDateStr() {
		return createdDateStr;
	}
	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}
	public Map<String, Object> getCustom() {
		return custom;
	}
	public void setCustom(Map<String, Object> custom) {
		this.custom = custom;
	}
	public String getDocumentLink() {
		return documentLink;
	}
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}
	public List<String> getDocuments() {
		return documents;
	}
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	public String getEmbedHtml() {
		return embedHtml;
	}
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorShown() {
		return errorShown;
	}
	public void setErrorShown(String errorShown) {
		this.errorShown = errorShown;
	}
	public Boolean getEscalated() {
		return escalated;
	}
	public void setEscalated(Boolean escalated) {
		this.escalated = escalated;
	}
	public String getEscalatedDate() {
		return escalatedDate;
	}
	public void setEscalatedDate(String escalatedDate) {
		this.escalatedDate = escalatedDate;
	}
	public String getEscalatedFrom() {
		return escalatedFrom;
	}
	public void setEscalatedFrom(String escalatedFrom) {
		this.escalatedFrom = escalatedFrom;
	}
	public String getEscalatedTo() {
		return escalatedTo;
	}
	public void setEscalatedTo(String escalatedTo) {
		this.escalatedTo = escalatedTo;
	}
	public Long getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(Long followerCount) {
		this.followerCount = followerCount;
	}
	public Long getFriendCount() {
		return friendCount;
	}
	public void setFriendCount(Long friendCount) {
		this.friendCount = friendCount;
	}
	public String getFromGroup() {
		return fromGroup;
	}
	public void setFromGroup(String fromGroup) {
		this.fromGroup = fromGroup;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getIncoming() {
		return incoming;
	}
	public void setIncoming(Boolean incoming) {
		this.incoming = incoming;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Boolean getMention() {
		return mention;
	}
	public void setMention(Boolean mention) {
		this.mention = mention;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Boolean getNotified() {
		return notified;
	}
	public void setNotified(Boolean notified) {
		this.notified = notified;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getPendingDate() {
		return pendingDate;
	}
	public void setPendingDate(String pendingDate) {
		this.pendingDate = pendingDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	public Boolean getPost() {
		return post;
	}
	public void setPost(Boolean post) {
		this.post = post;
	}
	public String getProfileLink() {
		return profileLink;
	}
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}
	public Boolean getRedistribute() {
		return redistribute;
	}
	public void setRedistribute(Boolean redistribute) {
		this.redistribute = redistribute;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReplyAgent() {
		return replyAgent;
	}
	public void setReplyAgent(String replyAgent) {
		this.replyAgent = replyAgent;
	}
	public String getReplyCc() {
		return replyCc;
	}
	public void setReplyCc(String replyCc) {
		this.replyCc = replyCc;
	}
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public Long getResponseTimeAgent() {
		return responseTimeAgent;
	}
	public void setResponseTimeAgent(Long responseTimeAgent) {
		this.responseTimeAgent = responseTimeAgent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getToGroup() {
		return toGroup;
	}
	public void setToGroup(String toGroup) {
		this.toGroup = toGroup;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public Boolean getTransfered() {
		return transfered;
	}
	public void setTransfered(Boolean transfered) {
		this.transfered = transfered;
	}
	public String getTransferedFrom() {
		return transferedFrom;
	}
	public void setTransferedFrom(String transferedFrom) {
		this.transferedFrom = transferedFrom;
	}
	public String getTransferedTo() {
		return transferedTo;
	}
	public void setTransferedTo(String transferedTo) {
		this.transferedTo = transferedTo;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleOwner() {
		return ruleOwner;
	}
	public void setRuleOwner(String ruleOwner) {
		this.ruleOwner = ruleOwner;
	}
	public String getTicketOwner() {
		return ticketOwner;
	}
	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}
	public String getUnassignedDate() {
		return unassignedDate;
	}
	public void setUnassignedDate(String unassignedDate) {
		this.unassignedDate = unassignedDate;
	}
	public String getUnassignedDateText() {
		return unassignedDateText;
	}
	public void setUnassignedDateText(String unassignedDateText) {
		this.unassignedDateText = unassignedDateText;
	}
	public Integer getUnassignedDuration() {
		return unassignedDuration;
	}
	public void setUnassignedDuration(Integer unassignedDuration) {
		this.unassignedDuration = unassignedDuration;
	}
	public Boolean getGreetingStatus() {
		return greetingStatus;
	}
	public void setGreetingStatus(Boolean greetingStatus) {
		this.greetingStatus = greetingStatus;
	}
	public List<String> getTicketTags() {
		return ticketTags;
	}
	public void setTicketTags(List<String> ticketTags) {
		this.ticketTags = ticketTags;
	}
	public String getClientMessageId() {
		return clientMessageId;
	}
	public void setClientMessageId(String clientMessageId) {
		this.clientMessageId = clientMessageId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Map<String, List<String>> getTermsMap() {
		return termsMap;
	}
	public void setTermsMap(Map<String, List<String>> termsMap) {
		this.termsMap = termsMap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
