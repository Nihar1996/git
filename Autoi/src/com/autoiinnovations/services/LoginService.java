package com.autoiinnovations.services;

import java.util.HashMap;
import java.util.Hashtable;

import com.autoiinnovations.Factory.CoreFactory;
import com.autoiinnovations.Factory.Userfactory;
import com.autoiinnovations.Interfaces.CoreWorker;
import com.autoiinnovations.Interfaces.UserWorker;

import com.autoiinnovations.dao.LoginDAO;
import com.autoiinnovations.dao.RegisterDAO;

public class LoginService {

	
	public HashMap<String, HashMap<String, String>> authenticateUserWH(HashMap<String,String> inputDetails) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("Login");
		//LoginDAO ldo=new LoginDAO();
		return userworker.authenticateUserWH( inputDetails);
	}
	
	public HashMap<String, HashMap<String, String>> getCurrentDetails(HashMap<String,String> inputDetails) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("Login");
		//LoginDAO ldo=new LoginDAO();
		return userworker.getCurrentDetails( inputDetails);
	}
	public HashMap<String,  String> updatePlayerId(HashMap<String,String> inputDetails) throws Exception
	{
		Userfactory userfactory=new Userfactory();
		UserWorker userworker=userfactory.getUserWorker("Login");
		//LoginDAO ldo=new LoginDAO();
		return userworker.updatePlayerId( inputDetails.get("email"),inputDetails.get("playerId"));
	}
	
	
	
}
