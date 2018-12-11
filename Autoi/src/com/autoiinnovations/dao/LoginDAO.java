package com.autoiinnovations.dao;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
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
import com.autoiinnovations.supporting.JDBCConnection;
import com.autoiinnovations.supporting.RandomTimeGenerator;
import com.autoiinnovations.supporting.SHAUtility;

public class LoginDAO implements UserWorker{

	public HashMap<String, HashMap<String, String>> authenticateUserWH(HashMap<String,String> inputDetails) throws Exception
	{
		
		Session session=null;
		HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> secondaryResponse=new HashMap<>();
		WHUserBean usb=null;
			DBHelper db=new DBHelper();
		try
		{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		//session=cfg.buildSessionFactory().getCurrentSession();
		session=cfg.buildSessionFactory().openSession();
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			Criterion cn1 =null;
			List l=null;
			byte[] salt=SHAUtility.getSalt();
			//SHAUtility.get_SHA_1_SecurePassword(whuserbean.getPassword(), salt));
				cn=Restrictions.eq("email",new String(inputDetails.get("email")));
				cn1=Restrictions.eq("password",new String(SHAUtility.get_SHA_1_SecurePassword(inputDetails.get("password"),salt)));
			crit.add(cn);
			crit.add(cn1);
		l=crit.list();
		
		if(l.size()!=0)
		{	
			String accessLevel="";
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
			  usb =(WHUserBean) it.next();
		//	accessLevel=usb.getAccessLevel();
				//memberbean = (MembersBean) it.next();
			}
			/*usb.setExtraInfo1(inputDetails.get("extraInfo1"));
			session.saveOrUpdate(usb);
*/
			//secondaryResponse.put("access", "P");
			HashMap<String,String> secondaryResponse1=new HashMap<>();
			secondaryResponse1.put("homeId","1");
			//response.put("key", secondaryResponse);
			response.put("homeId",secondaryResponse1);
			HashMap<String,String> profileResponse=new HashMap<>();
			profileResponse.put("email",inputDetails.get("email"));
			profileResponse.put("userName",usb.getName());
			response.put("profile", profileResponse);
			HashMap<String, String> controllerDetails=db.getControllerDetails(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("controllers",controllerDetails);
			HashMap<String, String> topicDeatils=db.getTopic(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("topic",topicDeatils);//	response.put("schedulers",schedulerDetails);
			HashMap<String, String> securityDetails=db.getSecurity(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("security",securityDetails);//	response.put("schedulers",schedulerDetails);
			HashMap<String, String> statusDetails=db.getAllDeviceStatus(session,usb.getUserId());
			response.put("status",statusDetails);
			for ( Map.Entry<String, String> entry : controllerDetails.entrySet()) {
			    HashMap<String,String> deviceDetails=db.getDeviceDetailsFromController(session, entry.getKey());
			    response.put(entry.getKey(), deviceDetails);
			   // HashMap<String,String> deviceStatus=db.getDeviceStatusFromController(session, entry.getKey());
				// response.put("devices", deviceDetails);
				// response.put("deviceStatus", deviceStatus);
			    // do something with key and/or tab
			}
			/*HashMap<String,String> deviceStatusDetails=db.getDeviceStatusDetails(session, usb.getHomeId());
			   response.put("Devices", deviceStatusDetails);*/
			//response.put("key",accessLevel);	
			}
		
		else
		{
			 	secondaryResponse.put("homeId","-999");
				response.put("homeId",secondaryResponse);
			
			
		System.out.println("AFTER");
			
			
		session.close();

		
		
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("ERROR");
			session.close();
			HashMap<String, String> hmap=new HashMap<>();
			hmap.put("homeId","-1");
			response.put("homeId", hmap);
			//return response;
			
		}
		return response;
	}
	
	
	public HashMap<String, HashMap<String, String>> getCurrentDetails(HashMap<String,String> inputDetails) throws Exception
	{
		
		Session session=null;
		HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> secondaryResponse=new HashMap<>();
		WHUserBean usb=null;
			DBHelper db=new DBHelper();
		try
		{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		//session=cfg.buildSessionFactory().getCurrentSession();
		session=cfg.buildSessionFactory().openSession();
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			Criterion cn1 =null;
			List l=null;
			byte[] salt=SHAUtility.getSalt();
			//SHAUtility.get_SHA_1_SecurePassword(whuserbean.getPassword(), salt));
				cn=Restrictions.eq("email",new String(inputDetails.get("email")));
				//cn1=Restrictions.eq("password",new String(SHAUtility.get_SHA_1_SecurePassword(inputDetails.get("password"),salt)));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		
		if(l.size()!=0)
		{	
			String accessLevel="";
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
			  usb =(WHUserBean) it.next();
		//	accessLevel=usb.getAccessLevel();
				//memberbean = (MembersBean) it.next();
			}
			//secondaryResponse.put("access", "P");
			HashMap<String,String> secondaryResponse1=new HashMap<>();
			secondaryResponse1.put("homeId","1");
			//response.put("key", secondaryResponse);
			response.put("homeId",secondaryResponse1);
			HashMap<String,String> profileResponse=new HashMap<>();
			profileResponse.put("email",inputDetails.get("email"));
			profileResponse.put("userName",usb.getName());
			response.put("profile", profileResponse);
			HashMap<String, String> controllerDetails=db.getControllerDetails(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("controllers",controllerDetails);
			HashMap<String, String> topicDeatils=db.getTopic(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("topic",topicDeatils);//	response.put("schedulers",schedulerDetails);
			HashMap<String, String> securityDetails=db.getSecurity(session,usb.getUserId());
			//HashMap<String, String> schedulerDetails=db.getScedulerDetails(session,usb.getUserId());
			response.put("security",securityDetails);//	response.put("schedulers",schedulerDetails);
			HashMap<String, String> statusDetails=db.getAllDeviceStatus(session,usb.getUserId());
			response.put("status",statusDetails);
			for ( Map.Entry<String, String> entry : controllerDetails.entrySet()) {
			    HashMap<String,String> deviceDetails=db.getDeviceDetailsFromController(session, entry.getKey());
			    response.put(entry.getKey(), deviceDetails);
			   // HashMap<String,String> deviceStatus=db.getDeviceStatusFromController(session, entry.getKey());
				// response.put("devices", deviceDetails);
				// response.put("deviceStatus", deviceStatus);
			    // do something with key and/or tab
			}
			/*HashMap<String,String> deviceStatusDetails=db.getDeviceStatusDetails(session, usb.getHomeId());
			   response.put("Devices", deviceStatusDetails);*/
			//response.put("key",accessLevel);	
			}
		
		else
		{
			 	secondaryResponse.put("homeId","-999");
				response.put("homeId",secondaryResponse);
			
			
		System.out.println("AFTER");
			
			
		session.close();

		
		
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("ERROR");
			session.close();
			HashMap<String, String> hmap=new HashMap<>();
			hmap.put("homeId","-1");
			response.put("homeId", hmap);
			//return response;
			
		}
		return response;
	}
	
	public HashMap<String, String> updatePlayerId(String email,String playerId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		Connection con=null;
		try {
			System.out.println("player id"+playerId);
			con = JDBCConnection.getOracleConnection();
			PreparedStatement pstmt = null;
			int count = 0;
			if(con!=null)
			{
				String query="update wh_user set extra_info1='"+playerId+"' where email='"+email+"'";
					System.out.println(query);
					 pstmt=con.prepareStatement(query);
					 int ret=pstmt.executeUpdate();
					 response.put("response","999");
						}
		
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
					return response;
		
	}


	@Override
	public HashMap<String, String> registerMemberWH(WHUserBean whuserbean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, HashMap<String, String>> googleSingInWH(WHUserBean whuserbean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, HashMap<String,String>> sendTempPassword(HashMap<String, String> inputDetails) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> changePassword(HashMap<String, String> inputDetails) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, String> updateProfile(WHUserBean whuserbean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, String> getProfile(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
