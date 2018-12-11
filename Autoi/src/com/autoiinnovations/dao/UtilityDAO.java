package com.autoiinnovations.dao;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.autoiinnovations.Interfaces.UserWorker;

import com.autoiinnovations.beans.WHUserBean;
import com.autoiinnovations.supporting.EncryptDecrypt;
import com.autoiinnovations.supporting.SHAUtility;
import com.autoiinnovations.supporting.TempPasswordUtil;
import com.autoiinnovations.supporting.MailUtility;


public class UtilityDAO {
	
	
	
	
	

	
	public HashMap<String, String> sendFeedback(HashMap<String, String> inputDetails) throws Exception {
		//return inputDetails;
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txt = null;
		HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> secondaryResponse=new HashMap<>();
		DBHelper db=new DBHelper();
		WHUserBean whb=null;
		try {
				 MailUtility mailutility=new  MailUtility();
				 mailutility.sendFeebbackEmail("support@autoiinnovations.com", inputDetails.get("email"),inputDetails.get("name"),inputDetails.get("subject"),inputDetails.get("message"));
		}
		catch(Exception e)
		{
			secondaryResponse.put("response", "-1");
			e.printStackTrace();
		}
		secondaryResponse.put("response", "1");
		return secondaryResponse;
	/*	TempPasswordUtil gtp=new TempPasswordUtil();
		 password=gtp.getPassword();*/
	}

	

}
