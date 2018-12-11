package com.autoiinnovations.services;

import java.util.HashMap;

import com.autoiinnovations.Factory.CoreFactory;
import com.autoiinnovations.Factory.Userfactory;
import com.autoiinnovations.Interfaces.CoreWorker;
import com.autoiinnovations.Interfaces.UserWorker;

import com.autoiinnovations.beans.WHDeviceLogBean;
import com.autoiinnovations.dao.ActionDAO;

import com.autoiinnovations.dao.LoginDAO;
import com.autoiinnovations.dao.RegisterDAO;

public class ActionService {

	
	public int performActionWH(WHDeviceLogBean deviceLogInfoBean) throws Exception
	{
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Action");
		//ActionDAO ado=new ActionDAO();
		return coreworker.performActionWH(deviceLogInfoBean);
	}
	
	public HashMap<String,String> getMetrics(HashMap<String,String> inputDetails) throws Exception
	{
		
		CoreFactory corefactory=new CoreFactory();
		CoreWorker coreworker=corefactory.getCoreWorker("Action");
		//ActionDAO ado=new ActionDAO();
		return coreworker.getMetrics(inputDetails);
	}
	
}
