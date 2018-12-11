package com.autoiinnovations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.resource.transaction.spi.TransactionStatus;


import com.autoiinnovations.beans.WHControllerBean;
import com.autoiinnovations.beans.WHControllerInventoryBean;
import com.autoiinnovations.beans.WHControllerMappingBean;
import com.autoiinnovations.beans.WHDeviceBean;
import com.autoiinnovations.beans.WHScheduler;
import com.autoiinnovations.beans.WHUserBean;
import com.autoiinnovations.supporting.CommonUtil;
import com.autoiinnovations.supporting.JDBCConnection;
import com.autoiinnovations.supporting.RandomGenerator;


public class DBHelper {
	
	
	public Integer populateController(Session session,String userId,String cid,String cname)
	{
		String emailStatus = "";
		//Session session = null;
		Transaction txt = null;
		int roomId=-999;
		
		HashMap<String, Integer> response = new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			//session = cfg.buildSessionFactory().openSession();
			txt = session.beginTransaction();
			txt.begin();
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("email", new String(userId));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHUserBean usb = (WHUserBean) it.next();
					userId=usb.getUserId();
					//return functionalBean;
			}
			}
			
			CommonUtil cm=new CommonUtil();
		//	System.out.println(cm.getHashCode(cid));
			WHControllerBean wbean=new WHControllerBean();
			wbean.setControllerID(cid);
			wbean.setControllerName(cname);
			wbean.setUserID(userId);
			/*wbean.setSecurityToken(cm.getHashCode(cid));
			wbean.setTopic(cid+"."+RandomGenerator.randomAlphaNumeric(4));*/
			session.save(wbean);
			
			//txt.commit();
			//txt.begin();
			
			//txt.commit();
			//txt.begin();
			txt.commit();
			
			
		
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txt.rollback();
			session.close();
			return -1;
		}
	}

	public  HashMap<String,String>  populateDevices(Session session,String cid,int count,String device1,String device2)
	{
		
		//Session session = null;
		Transaction txt = null;
		 HashMap<String,String> deviceDetails=new HashMap<>();
		
		HashMap<String, Integer> response = new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			//session = cfg.buildSessionFactory().openSession();
			
			txt = session.beginTransaction();
			txt.begin();
			for(int i=0;i<count;i++)
			{
			WHDeviceBean whdbean=new WHDeviceBean();
			whdbean.setControllerID(cid);
			whdbean.setCurrentStatus("0");
			whdbean.setSecondaryDeviceId(i);
			if(i==0)
			{
				whdbean.setDeviceName(device1);
				
			}
			else if(i==1)
			{
				whdbean.setDeviceName(device2);
			}
			//whdbean.setDeviceName("device"+i);
			session.save(whdbean);
			if(i%2==0)
			{
				 session.flush();
				  session.clear();
			}
			
				
			}
			
			
		
			txt.commit();
			
			 deviceDetails=getDeviceDetailsFromController(session,cid );
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txt.rollback();
		//	session.close();
		//	return -1;
		}
		return deviceDetails;
	}

	
	
	
	
	
	
	public HashMap<String,String> getDeviceDetailsFromController(Session session,String controllerId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHDeviceBean.class);
			Criterion cn = null;
			Criterion cn1 = null;
			List l = null;

			cn = Restrictions.eq("controllerID", new String(controllerId));
			//cn1 = Restrictions.eq("roomId", new String(roomId));
			crit.add(cn);
		//	crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHDeviceBean dbm=(WHDeviceBean) it.next();
					
					//response.put(Integer.toString(dbm.getSecondaryDeviceId()),dbm.getDeviceName()+"."+dbm.getCurrentStatus());
					response.put(Integer.toString(dbm.getSecondaryDeviceId()),dbm.getDeviceName());
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	
	public HashMap<String,String> getTopic(Session session,String userId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHControllerBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("userID", new String(userId));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHControllerBean wcb=(WHControllerBean) it.next();
					Criteria crit1 = session.createCriteria(WHControllerMappingBean.class);
					Criterion	cn1 = Restrictions.eq("controllerID", new String(wcb.getControllerID()));
					crit1.add(cn1);
					List l1 = crit1.list();

					if (l1.size() != 0) {
						Iterator it1 = l1.iterator();
						System.out.println("inside if");
						while (it1.hasNext()) {
							WHControllerMappingBean wcib=(WHControllerMappingBean) it1.next();
							//response.put(wcb.getControllerID(),wcb.getControllerName()+"||"+wcib.getTopic());
							response.put(wcb.getControllerID(),wcib.getTopic());
						}
					}
						
					
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	public HashMap<String,String> getTopicByControllerId(Session session,String cid)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHControllerMappingBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("controllerID", new String(cid));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHControllerMappingBean wcb=(WHControllerMappingBean) it.next();
					
					response.put("topic", wcb.getTopic());
					response.put("security", wcb.getSecurityToken());
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	public HashMap<String,String> getSecurity(Session session,String userId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHControllerBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("userID", new String(userId));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHControllerBean wcb=(WHControllerBean) it.next();
					Criteria crit1 = session.createCriteria(WHControllerMappingBean.class);
					Criterion	cn1 = Restrictions.eq("controllerID", new String(wcb.getControllerID()));
					crit1.add(cn1);
					List l1 = crit1.list();

					if (l1.size() != 0) {
						Iterator it1 = l1.iterator();
						System.out.println("inside if");
						while (it1.hasNext()) {
							WHControllerMappingBean wcib=(WHControllerMappingBean) it1.next();
							//response.put(wcb.getControllerID(),wcb.getControllerName()+"||"+wcib.getTopic());
							response.put(wcb.getControllerID(),wcib.getSecurityToken());
						}
					}
						
					
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
		
	public HashMap<String,String> getAllDeviceStatus(Session session,String userId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHControllerBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("userID", new String(userId));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();
			StringBuffer sb=new StringBuffer("");
			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHControllerBean wcb=(WHControllerBean) it.next();
					Criteria crit1 = session.createCriteria(WHDeviceBean.class);
					Criterion	cn1 = Restrictions.eq("controllerID", new String(wcb.getControllerID()));
					crit1.add(cn1);
					List l1 = crit1.list();
						
					if (l1.size() != 0) {
						Iterator it1 = l1.iterator();
						System.out.println("inside if");
						int count=0;
						while (it1.hasNext()) {
							if(count==2)
							{
								break;
							}
							WHDeviceBean wcib=(WHDeviceBean) it1.next();
							sb.append(wcib.getSecondaryDeviceId()+wcib.getCurrentStatus());
							//response.put(wcb.getControllerID(),wcb.getControllerName()+"||"+wcib.getTopic());
							count=count+1;
						}
					}
					response.put(wcb.getControllerID(),sb.toString());	
					sb.setLength(0);
					
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	public HashMap<String,String> getDeviceStatusFromController(Session session,String controllerId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHDeviceBean.class);
			Criterion cn = null;
			Criterion cn1 = null;
			List l = null;

			cn = Restrictions.eq("controllerID", new String(controllerId));
			//cn1 = Restrictions.eq("roomId", new String(roomId));
			crit.add(cn);
		//	crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHDeviceBean dbm=(WHDeviceBean) it.next();
					
					response.put(Integer.toString(dbm.getSecondaryDeviceId()),dbm.getCurrentStatus());
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	
	
	
	
	
	public static void main(String args[])
	{
		DBHelper dbh=new DBHelper();
		//System.out.println(dbh.getListOfUsers("U1"));
	}
	
	
	
	
	public HashMap<String,String> getControllerDetails(Session session,String homeId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHControllerBean.class);
			Criterion cn = null;
		
			List l = null;

			cn = Restrictions.eq("userID", new String(homeId));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHControllerBean wcb=(WHControllerBean) it.next();
					Criteria crit1 = session.createCriteria(WHControllerInventoryBean.class);
					Criterion	cn1 = Restrictions.eq("controllerID", new String(wcb.getControllerID()));
					List l1 = crit1.list();

					if (l1.size() != 0) {
						Iterator it1 = l1.iterator();
						System.out.println("inside if");
						while (it1.hasNext()) {
							WHControllerInventoryBean wcib=(WHControllerInventoryBean) it1.next();
							//response.put(wcb.getControllerID(),wcb.getControllerName()+"||"+wcib.getTopic());
							response.put(wcb.getControllerID(),wcb.getControllerName());
						}
					}
						
					
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	public HashMap<String,String> getScedulerDetails(Session session,String userId)
	{
		//Session session = null;
		HashMap<String, String> response=new HashMap<>();
		try {
		//	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//	session = cfg.buildSessionFactory().openSession();
			// session=cfg.buildSessionFactory().getCurrentSession();
			Criteria crit = session.createCriteria(WHScheduler.class);
			Criterion cn = null,cn1=null;
			
		
			List l = null;

			cn = Restrictions.eq("userID", new String(userId));
			cn1 = Restrictions.eq("mode", new String("E"));
			//cn1 = Restrictions.eq("token", new String(userDetails.get("token")));
			crit.add(cn);
			crit.add(cn1);
			//crit.add(cn1);
			l = crit.list();
			//l = crit.list();

			if (l.size() != 0) {
				Iterator it = l.iterator();
				System.out.println("inside if");
				while (it.hasNext()) {
					WHScheduler whs=(WHScheduler) it.next();
					
					//HashMap<String,String> deviceSchedule=new HashMap<>();
					//deviceSchedule.put(Integer.toString(whs.getDeviceID()), whs.getStartTime());
					response.put(Integer.toString(whs.getDeviceID()), whs.getStartTime());
					
						
					
					//HashMap<String, String> deviceDetails=getDeviceDetails(session,homeId,rm.getRoomId());
					
			}
			}else {
				//response.put("key", -999);
				// send response if not matched
				//return "NA";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			session.close();
		//	response.put("key", 0);

		} finally {
			//session.close();
		}
		return response;
		
	}
	
	public Date getTimeDifference(String startTime) throws SQLException, ClassNotFoundException
	{
		//JDBCConnection connref =new JDBCConnection();
		 Date startDate = null; 
		 // String customprofile =pageContext.getProfile("ICX_DATE_FORMAT_MASK");
    		Date currentDate=new Date();
		   SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		      // SimpleDateFormat dt1 = new SimpleDateFormat("2018-03-06");
		        System.out.println(dt1.format(currentDate));
		        SimpleDateFormat dt2 = new SimpleDateFormat("HH:mm");
		      //  SimpleDateFormat dt2 = new SimpleDateFormat("22:10");
		        System.out.println(dt2.format(currentDate));
		        //String startDate="22:56";
		        String startTimeArr[]=startTime.split(":");
		        String currentDateArr[]=dt2.format(currentDate).split(":");
		        if(Integer.parseInt(startTimeArr[0])< Integer.parseInt(currentDateArr[0]))
		        {
		        	Calendar cal = Calendar.getInstance();
		        	cal.setTime(currentDate);
		        	cal.add(Calendar.DATE, 1); // add 10 days
		        	 
		        	startDate = cal.getTime();
		        	//System.out.println(dt1.format(startDate));
		        }
		        else if(Integer.parseInt(startTimeArr[0]) > Integer.parseInt(currentDateArr[0]))
		        {
		        	startDate=currentDate;
		        //	System.out.println(dt1.format(startDate));
		        }
		        else if(Integer.parseInt(startTimeArr[0]) == Integer.parseInt(currentDateArr[0]))
		        {
		        	if(Integer.parseInt(startTimeArr[1]) < Integer.parseInt(currentDateArr[1]))
		        	{
		        		Calendar cal = Calendar.getInstance();
			        	cal.setTime(currentDate);
			        	cal.add(Calendar.DATE, 1); // add 10 days
			        	 
			        	startDate = cal.getTime();
			        	//System.out.println(dt1.format(currentDateArr));
		        	}
		        	else if(Integer.parseInt(startTimeArr[1]) > Integer.parseInt(currentDateArr[1]))
		        	{
		        		startDate=currentDate;
		        	//	System.out.println(dt1.format(startDate));
		        	}
		        	else
		        	{
		        		startDate=currentDate;
		        	//	System.out.println(dt1.format(startDate));
		        	}
		        }
		        
		return startDate;
		        
		}
	
	public int getDaysDifference(String cid,String did) throws SQLException, ClassNotFoundException
	{
		//JDBCConnection connref =new JDBCConnection();
		Connection con=null;
		con = JDBCConnection.getOracleConnection();
		PreparedStatement pstmt = null;
		int days = 0;
		if(con!=null)
		{
				String query="select DATEDIFF(current_date(),effective_date) from wh_device_log_info where device_id=? and controller_id=? limit 1";
				 pstmt=con.prepareStatement(query);
				 pstmt.setString(2,cid);
				 pstmt.setInt(1, Integer.parseInt(did));
				 ResultSet rs= pstmt.executeQuery();
				 while(rs.next())
				 {
					 days=rs.getInt(1);
				 }
				 
				//populateDeviceLogData(status, con,cid,did,userId,source); 
			   
		}
		return days;
		}
}
