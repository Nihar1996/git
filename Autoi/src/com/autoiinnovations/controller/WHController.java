package com.autoiinnovations.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import com.autoiinnovations.beans.WHControllerBean;
import com.autoiinnovations.beans.WHScheduler;
import com.autoiinnovations.services.ActionService;

import com.autoiinnovations.services.LoginService;
import com.autoiinnovations.services.WHControllerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Path("/controller")
public class WHController {

	@Path("/verifyController")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, HashMap<String, String>> verifyController(HashMap<String,String> inputDetails) throws Exception {  
		  
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		 HashMap<String,Integer> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 
		 // return null;
		  
		 return ws.verifyController(inputDetails);
	  }
	
	
	@Path("/updateController")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,HashMap<String,String>> updateController(HashMap<String,HashMap<String,String>> inputDetails) throws Exception {  
		  
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		 HashMap<String,HashMap<String,String>> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 HashMap<String,String> retTemp=new HashMap<>();
		 // return null;
		int ret= ws.updateController(inputDetails);
		retTemp.put("status",Integer.toString(ret));
		response.put("response",retTemp );
		 return response;
	  }
	
	@Path("/scheduleDevice")
	  @POST
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,Integer> scheduleDevice(HashMap<String,String> inputDetails) throws Exception {  
		  
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		// HashMap<String,HashMap<String,String>> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 HashMap<String,Integer> response=new HashMap<>();
		 // return null;
		int ret= ws.scheduleDevice(inputDetails);
		response.put("status",ret);
		//response.put("response",retTemp );
		 return response;
	  }
	
	/*@Path("/updateSchedule")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,Integer> updateSchedule(HashMap<String,String> inputDetails) throws Exception {  
		  
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		// HashMap<String,HashMap<String,String>> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 HashMap<String,Integer> response=new HashMap<>();
		 // return null;
		int ret= ws.updateSchedule(inputDetails);
		response.put("status",ret);
		//response.put("response",retTemp );
		 return response;
	  }
	
	@Path("/disableScheduledDevice")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,Integer> disableScheduledDevice(HashMap<String,String> inputDetails) throws Exception {  
		  
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		// HashMap<String,HashMap<String,String>> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 HashMap<String,Integer> response=new HashMap<>();
		 // return null;
		int ret= ws.disableScheduledDevice(inputDetails);
		response.put("status",ret);
		//response.put("response",retTemp );
		 return response;
	  }*/
	
	@Path("/viewScheduledDevices")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap viewScheduledDevices(HashMap<String,String> inputDetails) throws Exception {  
		// ArrayList<WHScheduler> response=new ArrayList<>(); 
		HashMap response=new HashMap<>();
		try
		{
		
		 WHControllerService  ws=new WHControllerService();
		 // int ret=as.performAction(deviceLogInfoBean);
		// HashMap<String,HashMap<String,String>> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		
		 // return null;
		 response.put("response", "100");
		 response.put("schedules", ws.viewScheduledDevices(inputDetails));

	
}
catch(Exception e)
{
	e.printStackTrace();//response.put("status",ret);
}
		return response;

//response.put("response",al );
		 //return response;
	  }
}
