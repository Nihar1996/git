package com.autoiinnovations.Factory;

import com.autoiinnovations.Interfaces.MetricsAndDataWorker;
import com.autoiinnovations.dao.ActionDAO;

public class MetricsAndDataFactory{  
    
	   //use getPlan method to get object of type Plan   
	       public MetricsAndDataWorker getPlan(String worker){  
	            if(worker == null){  
	             return null;  
	            }  
	          if(worker.equalsIgnoreCase("Action")) {  
	                 return new ActionDAO();  
	               }   
	          
	      return null;  
	   }  
	}