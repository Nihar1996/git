package com.autoiinnovations.services;

import java.util.HashMap;

import com.autoiinnovations.Factory.Userfactory;
import com.autoiinnovations.Interfaces.UserWorker;

import com.autoiinnovations.beans.WHUserBean;
import com.autoiinnovations.dao.RegisterDAO;

public class RegisterService {

	
	public HashMap<String,String> registerMemberWH(WHUserBean whuserbean) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("Register");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.registerMemberWH(whuserbean);
	}
	
	public HashMap<String, HashMap<String, String>> googleSingInWH(WHUserBean whuserbean) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("Google");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.googleSingInWH(whuserbean);
	}
	
	public HashMap<String, HashMap<String,String>> sendTempPassword(HashMap<String, String> inputDetails) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("SendTemporaryPassword");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.sendTempPassword(inputDetails);
	}
	
	public HashMap<String, String> changePassword(HashMap<String, String> inputDetails) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("ChangePassword");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.changePassword(inputDetails);
	}
	public HashMap<String,  String> updateProfile(WHUserBean whuserbean) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("updateProfile");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.updateProfile(whuserbean);
	}
	public HashMap<String,  String> getProfile(String email) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("getProfile");
		//RegisterDAO rdo=new RegisterDAO();
		return userworker.getProfile(email);
	}
}
