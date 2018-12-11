package com.autoiinnovations.services;

import java.util.ArrayList;
import java.util.HashMap;


import com.autoiinnovations.beans.WHControllerBean;
import com.autoiinnovations.beans.WHScheduler;
import com.autoiinnovations.dao.ActionDAO;

import com.autoiinnovations.dao.LoginDAO;
import com.autoiinnovations.dao.RegisterDAO;
import com.autoiinnovations.dao.UtilityDAO;
import com.autoiinnovations.dao.WHControllerDAO;
import com.autoiinnovations.Factory.CoreFactory;
import com.autoiinnovations.Interfaces.CoreWorker;

public class UtilityService {

	public HashMap<String, String> sendFeedback(HashMap<String,String> inputDetails) throws Exception
	{
		UtilityDAO udao=new UtilityDAO();
		return udao.sendFeedback(inputDetails);
	}
	
	
	
	
}
