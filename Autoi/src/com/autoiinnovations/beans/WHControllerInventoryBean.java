package com.autoiinnovations.beans;

import java.security.Timestamp;
import java.sql.Date;

public class WHControllerInventoryBean {
	
	private int id;
	private String controllerID;

	private String passKey;
	private String status;
	private String topic;
	private String productCode;
	private Date dateOfPurchase;
	private Date dateOfActivation;
	private Date dateOfShelf;
	private String extraInfo1;
	private String extraInfo2;
	private String extraInfo3;
	private String extraInfo4;
	private String extraInfo5;
	public String getControllerID() {
		return controllerID;
	}
	public void setControllerID(String controllerID) {
		this.controllerID = controllerID;
	}
	public String getPassKey() {
		return passKey;
	}
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Date getDateOfActivation() {
		return dateOfActivation;
	}
	public void setDateOfActivation(Date dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}
	public Date getDateOfShelf() {
		return dateOfShelf;
	}
	public void setDateOfShelf(Date dateOfShelf) {
		this.dateOfShelf = dateOfShelf;
	}
	public String getExtraInfo1() {
		return extraInfo1;
	}
	public void setExtraInfo1(String extraInfo1) {
		this.extraInfo1 = extraInfo1;
	}
	public String getExtraInfo2() {
		return extraInfo2;
	}
	public void setExtraInfo2(String extraInfo2) {
		this.extraInfo2 = extraInfo2;
	}
	public String getExtraInfo3() {
		return extraInfo3;
	}
	public void setExtraInfo3(String extraInfo3) {
		this.extraInfo3 = extraInfo3;
	}
	public String getExtraInfo4() {
		return extraInfo4;
	}
	public void setExtraInfo4(String extraInfo4) {
		this.extraInfo4 = extraInfo4;
	}
	public String getExtraInfo5() {
		return extraInfo5;
	}
	public void setExtraInfo5(String extraInfo5) {
		this.extraInfo5 = extraInfo5;
	}
	

}
