package com.autoiinnovations.controller;

import java.util.HashMap;
import java.util.Hashtable;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.autoiinnovations.services.LoginService;

@Path("/login")
public class LoginController {

	
	@Path("/authenticateUserWH")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, HashMap<String, String>> authenticateUserWH(HashMap<String,String> inputDetails) throws Exception {  
		  
		 LoginService loginservice=new LoginService();
		 return loginservice.authenticateUserWH(inputDetails);
	  }
	
	@Path("/getCurrentDetails")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap getCurrentDetails(HashMap<String,String> inputDetails) throws Exception {  
		  
		 LoginService loginservice=new LoginService();
		 HashMap hmap=new HashMap<>();
		 hmap=loginservice.getCurrentDetails(inputDetails);
		 hmap.put("response", "777");
		 
		 return hmap;
		 
	  }
	
	
	@Path("/updatePlayerId")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,String> updatePlayerId(HashMap<String,String> inputDetails) throws Exception {  
		  
		 LoginService loginservice=new LoginService();
		 return loginservice.updatePlayerId(inputDetails);
	  }
	
	
	
}
