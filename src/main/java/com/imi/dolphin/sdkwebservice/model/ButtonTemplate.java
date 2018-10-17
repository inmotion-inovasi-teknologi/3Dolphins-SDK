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
import java.util.List;

/**
 * 
 * @author reja
 *
 */
public class ButtonTemplate implements Serializable {
	private static final long serialVersionUID = 827250754466709640L;

	private String id;
	private String pictureLink;
	private String picturePath;
	private String title;
	private String subTitle;
	private List<EasyMap> buttonValues;
	private String group;

	/**
	 * @return Get the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Get the pictureLink
	 */
	public String getPictureLink() {
		return pictureLink;
	}

	/**
	 * @param pictureLink
	 *            the pictureLink to set
	 */
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	/**
	 * @return Get the picturePath
	 */
	public String getPicturePath() {
		return picturePath;
	}

	/**
	 * @param picturePath
	 *            the picturePath to set
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	/**
	 * @return Get the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return Get the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * @param subTitle
	 *            the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * @return Get the buttonValues
	 */
	public List<EasyMap> getButtonValues() {
		return buttonValues;
	}

	/**
	 * @param buttonValues
	 *            the buttonValues to set
	 */
	public void setButtonValues(List<EasyMap> buttonValues) {
		this.buttonValues = buttonValues;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

}
