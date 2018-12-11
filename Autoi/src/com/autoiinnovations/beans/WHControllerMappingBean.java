package com.autoiinnovations.beans;

public class WHControllerMappingBean {

private int id;
private String controllerID;
private String securityToken;
private String topic;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getSecurityToken() {
	return securityToken;
}
public void setSecurityToken(String securityToken) {
	this.securityToken = securityToken;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public String getControllerID() {
	return controllerID;
}
public void setControllerID(String controllerID) {
	this.controllerID = controllerID;
}
}
