package com.autoiinnovations.services;

import java.util.ArrayList;
import java.util.HashMap;


import com.autoiinnovations.beans.WHControllerBean;
import com.autoiinnovations.beans.WHScheduler;
import com.autoiinnovations.dao.ActionDAO;

import com.autoiinnovations.dao.LoginDAO;
import com.autoiinnovations.dao.RegisterDAO;
import com.autoiinnovations.dao.WHControllerDAO;
import com.autoiinnovations.Factory.CoreFactory;
import com.autoiinnovations.Interfaces.CoreWorker;

public class WHControllerService {

	public HashMap<String, HashMap<String, String>> verifyController(HashMap<String,String> inputDetails) throws Exception
	{
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Controller");
		//WHControllerDAO wdo=new WHControllerDAO();
		return coreworker.verifyController(inputDetails);
	}
	
	public int updateController(HashMap<String,HashMap<String,String>> inputDetails) throws Exception
	{
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Controller");
		//WHControllerDAO wdo=new WHControllerDAO();
		return coreworker.updateController(inputDetails);
		/*WHControllerDAO wdo=new WHControllerDAO();
		return wdo.updateController(inputDetails);*/
	}
	
	public int scheduleDevice(HashMap<String,String> inputDetails) throws Exception
	{
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Controller");
	//	WHControllerDAO wdo=new WHControllerDAO();
		return coreworker.scheduleDevice(inputDetails);
	}
	
	/*public int disableScheduledDevice(HashMap<String,String> inputDetails) throws Exception
	{
		WHControllerDAO wdo=new WHControllerDAO();
		return wdo.disableScheduledDevice(inputDetails);
	}
	
	public int updateSchedule(HashMap<String,String> inputDetails) throws Exception
	{
		WHControllerDAO wdo=new WHControllerDAO();
		return wdo.updateSchedule(inputDetails);
	}*/
	
	public ArrayList<HashMap<String,String>> viewScheduledDevices(HashMap<String,String> inputDetails) throws Exception
	{
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Controller");
		//WHControllerDAO wdo=new WHControllerDAO();
		return coreworker.viewScheduledDevices(inputDetails);
	}
	
	
	
	
}
