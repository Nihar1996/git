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




import com.autoiinnovations.services.UtilityService;


@Path("/utility")
public class UtilityController {

	@Path("/sendFeedback")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, String> sendFeedback(HashMap<String,String> inputDetails) throws Exception {  
		  
		 UtilityService  ws=new UtilityService();
		 // int ret=as.performAction(deviceLogInfoBean);
		// HashMap<String,Integer> response=new HashMap<>();
		
		 //response.put("response",ws.verifyController(whb));	 
		 
		 // return null;
		  
		 return ws.sendFeedback(inputDetails);
	  }
	
	
	
}
