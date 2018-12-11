package com.autoiinnovations.supporting;



import com.owlike.genson.ext.jaxrs.GensonJsonConverter;

import org.glassfish.jersey.server.ResourceConfig;
public class GensonRegister extends ResourceConfig{

	
	 public  GensonRegister() {
	        super();
	        ResourceConfig Rc;
	        Rc=register(GensonJsonConverter.class);
	    }

	 
}
