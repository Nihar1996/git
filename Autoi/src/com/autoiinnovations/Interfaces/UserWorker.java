package com.autoiinnovations.Interfaces;

import java.util.HashMap;

import com.autoiinnovations.beans.WHUserBean;

public interface UserWorker {

	public HashMap<String, HashMap<String, String>> authenticateUserWH(HashMap<String,String> inputDetails) throws Exception;
	public HashMap<String, HashMap<String, String>> getCurrentDetails(HashMap<String,String> inputDetails) throws Exception;
	public HashMap<String,String> registerMemberWH(WHUserBean whuserbean) throws Exception;
	public HashMap<String, HashMap<String, String>> googleSingInWH(WHUserBean whuserbean) throws Exception;
	public HashMap<String, HashMap<String,String>> sendTempPassword(HashMap<String,String> inputDetails) throws Exception;
	public HashMap<String,String> changePassword(HashMap<String,String> inputDetails) throws Exception;
	public HashMap<String,  String> updatePlayerId(String email,String playerId) throws Exception;
	public HashMap<String,  String> updateProfile(WHUserBean whuserbean) throws Exception;
	public HashMap<String,String> getProfile(String email) throws Exception;
	
}
