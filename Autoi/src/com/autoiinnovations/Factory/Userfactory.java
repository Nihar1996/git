package com.autoiinnovations.Factory;

import com.autoiinnovations.Interfaces.UserWorker;
import com.autoiinnovations.dao.LoginDAO;
import com.autoiinnovations.dao.RegisterDAO;

public class Userfactory{  
    
	   //use getPlan method to get object of type Plan   
	       public UserWorker getUserWorker(String worker){  
	            if(worker == null){  
	             return null;  
	            }  
	          if(worker.equalsIgnoreCase("Login")) {  
	                 return new LoginDAO();  
	               }   
	           else if(worker.equalsIgnoreCase("Register") || worker.equalsIgnoreCase("Google") || worker.equalsIgnoreCase("updateProfile") || worker.equalsIgnoreCase("getProfile")){  
	                return new RegisterDAO();  
	            }   
	          
	           else if(worker.equalsIgnoreCase("SendTemporaryPassword") || worker.equalsIgnoreCase("ChangePassword")){  
	                return new RegisterDAO();  
	            }
	          
	          
	      return null;  
	   }  
	}