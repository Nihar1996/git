package com.autoiinnovations.Factory;

import com.autoiinnovations.Interfaces.CoreWorker;
import com.autoiinnovations.dao.ActionDAO;
import com.autoiinnovations.dao.WHControllerDAO;

public class CoreFactory{  
    
	   //use getPlan method to get object of type Plan   
	       public CoreWorker getCoreWorker(String worker){  
	            if(worker == null){  
	             return null;  
	            }  
	          if(worker.equalsIgnoreCase("Controller")) {  
	                 return new WHControllerDAO();  
	               }   
	           else if(worker.equalsIgnoreCase("Action")){  
	                return new ActionDAO();  
	            }   
	          return null;  
	   }  
	}