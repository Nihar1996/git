package com.gvn.brings.web.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import com.gvn.brings.dto.TestDto;
import com.gvn.brings.model.BrngRateLkp;
import com.gvn.brings.services.TestService;
import com.gvn.brings.services.UtilityService;

@RestController
public class UtilityController extends AbstractBaseController{
	
	private static final Logger logger = Logger.getLogger(UtilityController.class);

	@Autowired
	private UtilityService utilityservice;
	
	@RequestMapping(value = REST+"getAppVersion", method = RequestMethod.GET,headers="Accept=application/json")
	public HashMap<String,String> getAppVersion()
	{				
		/*TestModel testModel = new TestModel("Sunil", "Kumar");
		return testModel;*/
		HashMap<String,String> versionInfo = utilityservice.getAppVersion();
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		return versionInfo;
	}
	
	
	@RequestMapping(value = REST+"getRateValues", method = RequestMethod.POST,headers="Accept=application/json")
	public HashMap<String,Float> getRateValues(@RequestBody HashMap<String,String> inputDetails)
	{				
		/*TestModel testModel = new TestModel("Sunil", "Kumar");
		return testModel;*/
		float price=utilityservice.getRateValues(inputDetails.get("dist"),inputDetails.get("weight"));
		HashMap<String,Float> response=new HashMap<>();
		response.put("price", price);
		return response;
		//logs debug message
		
	}
	
}
