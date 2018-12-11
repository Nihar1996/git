package com.autoiinnovations.beans;

import java.sql.Timestamp;

public class WHDeviceLogBean {

	
	private int id;
	private String controllerID;
	private String userID;
	private int deviceID;
	private String status;
	private Timestamp effectiveDate;
	private String source;
	private int onTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getControllerID() {
		return controllerID;
	}
	public void setControllerID(String controllerID) {
		this.controllerID = controllerID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getOnTime() {
		return onTime;
	}
	public void setOnTime(int onTime) {
		this.onTime = onTime;
	}
	
	
	
}
