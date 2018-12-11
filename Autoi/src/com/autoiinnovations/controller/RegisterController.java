package com.autoiinnovations.controller;



import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.autoiinnovations.beans.WHUserBean;
import com.autoiinnovations.services.RegisterService;


@Path("/register")
public class RegisterController {

	   
	 
	  
	  @Path("/registerMemberWH")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,String> registerMemberWH(WHUserBean whuserbean) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.registerMemberWH(whuserbean);
		  
	  }  
	  
	  @Path("/googleSingInWH")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, HashMap<String, String>> googleSingInWH(WHUserBean whuserbean) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.googleSingInWH(whuserbean);
	  }  
	  
	  @Path("/sendTemporaryPassword")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, HashMap<String,String>> sendTemporaryPassword(HashMap<String, String> inputDetails) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.sendTempPassword(inputDetails);
	  }
	  
	  @Path("/changePassword")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String, String> changePassword(HashMap<String, String> inputDetails) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.changePassword(inputDetails);
	  }
	  
	  @Path("/updateProfile")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,  String> updateProfile(WHUserBean whuserbean) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.updateProfile(whuserbean);
		  
	  } 
	  
	  @Path("/getProfile")
	  @POST 
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)  
	  public HashMap<String,  String> getProfile(HashMap<String, String> emailDetails) throws Exception {  
		  
		 RegisterService registerservice=new RegisterService();
		 return registerservice.getProfile(emailDetails.get("email"));
		  
	  } 
	 
	
}
