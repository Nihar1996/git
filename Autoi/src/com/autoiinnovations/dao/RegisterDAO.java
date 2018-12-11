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
import com.autoiinnovations.supporting.JDBCConnection;
import com.autoiinnovations.supporting.SHAUtility;
import com.autoiinnovations.supporting.TempPasswordUtil;
import com.autoiinnovations.supporting.MailUtility;


public class RegisterDAO implements UserWorker{
	
	
	public HashMap<String,String> registerMemberWH(WHUserBean whuserbean) throws Exception {
		String emailStatus = "";
		Session session = null;
		Transaction txt = null;
		HashMap<String,String> response = new HashMap<>();
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			session = cfg.buildSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			//Criterion cn1 =null;
			List l=null;
		 	  
				cn=Restrictions.eq("email",new String(whuserbean.getEmail()));
				//cn1=Restrictions.eq("password",new String(inputDetails.get("password")));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		if(l.size()>0)
		{
			response.put("key","-999" );
		}
		else
		{
			String hql = "select count(*) from  WHUserBean whuserbean" ;
		Query query = session.createQuery(hql);
		 int row=0;
		for(Iterator it=query.iterate();it.hasNext();)
		  {
			row= (int) it.next();
		   System.out.print("Count: " + row);
		  }
		//List results=query.list();
		
			txt = session.beginTransaction();
			txt.begin();
			int size=row+1;
			System.out.println("size " +size);
			whuserbean.setUserId("Autoi-US-"+(size));
			byte[] salt=SHAUtility.getSalt();
			whuserbean.setPassword(SHAUtility.get_SHA_1_SecurePassword(whuserbean.getPassword(), salt));
			session.save(whuserbean);
			

			System.out.println("AFTER");

			txt.commit();

			response.put("userName", whuserbean.getName());
			response.put("email", whuserbean.getEmail());
			response.put("key", "1");
		}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			txt.rollback();
			//session.close();
			response.put("key","-1");

		} finally {
			session.close();
		}
		return response;

	}
	
	
	public HashMap<String, HashMap<String, String>> googleSingInWH(WHUserBean whuserbean) throws Exception {
		String emailStatus = "";
		Session session = null;
		Transaction txt = null;
		HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> secondaryResponse=new HashMap<>();
		DBHelper db=new DBHelper();
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			session = cfg.buildSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			//Criterion cn1 =null;
			List l=null;
		 	  
				cn=Restrictions.eq("email",new String(whuserbean.getEmail()));
				//cn1=Restrictions.eq("password",new String(inputDetails.get("password")));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		WHUserBean  usb= null;
		if(l.size()>0)
		{
				
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
			 usb=(WHUserBean) it.next();
			//accessLevel=usb.getAccessLevel();
				//memberbean = (MembersBean) it.next();
			}
			//secondaryResponse.put("access", "P");
			HashMap<String,String> secondaryResponse1=new HashMap<>();
			secondaryResponse1.put("homeId","1");
			//response.put("key", secondaryResponse);
			response.put("homeId",secondaryResponse1);
			HashMap<String,String> profileResponse=new HashMap<>();
			profileResponse.put("email",usb.getEmail());
			profileResponse.put("userName",usb.getName());
			response.put("profile", profileResponse);
			HashMap<String, String> controllerDetails=db.getControllerDetails(session,usb.getUserId());
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
			   
			    // do something with key and/or tab
			}
			
			}
		
		else
		{
			String hql = "select count(*) from  WHUserBean whuserbean" ;
		Query query = session.createQuery(hql);
		//Query query = session.createQuery(hql);
		 int row=0;
		for(Iterator it=query.iterate();it.hasNext();)
		  {
			row= (int) it.next();
		   System.out.print("Count: " + row);
		  }
			int size=row+1;
			txt = session.beginTransaction();
			txt.begin();
			System.out.println("Size "+row+1);
			whuserbean.setUserId("Autoi-US-"+size);
			session.save(whuserbean);

			System.out.println("AFTER");

			txt.commit();
			HashMap<String,String> secondaryResponse1=new HashMap<>();
			secondaryResponse1.put("homeId","1");
			//response.put("key", secondaryResponse);
			response.put("homeId",secondaryResponse1);
			HashMap<String, String> controllerDetails=db.getControllerDetails(session,whuserbean.getUserId());
			response.put("controllers",controllerDetails);
			HashMap<String,String> profileResponse=new HashMap<>();
			profileResponse.put("email",whuserbean.getEmail());
			profileResponse.put("userName",whuserbean.getName());
			response.put("profile", profileResponse);
			for ( Map.Entry<String, String> entry : controllerDetails.entrySet()) {
			    HashMap<String,String> deviceDetails=db.getDeviceDetailsFromController(session, entry.getKey());
			    response.put(entry.getKey(), deviceDetails);
			    // do something with key and/or tab
			}
			//response.put("key", 1);
		}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			txt.rollback();
			HashMap<String, String> hmap=new HashMap<>();
			hmap.put("homeId","-1");
			response.put("homeId", hmap);
		} finally {
			session.close();
		}
		return response;

	}

	@Override
	public HashMap<String, HashMap<String, String>> authenticateUserWH(HashMap<String, String> inputDetails)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, HashMap<String,String>> sendTempPassword(HashMap<String, String> inputDetails) throws Exception {
		//return inputDetails;
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txt = null;
		HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> secondaryResponse=new HashMap<>();
		DBHelper db=new DBHelper();
		WHUserBean whb=null;
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			session = cfg.buildSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			//Criterion cn1 =null;
			List l=null;
		 	  
				cn=Restrictions.eq("email",new String(inputDetails.get("email")));
				//cn1=Restrictions.eq("password",new String(inputDetails.get("password")));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		WHUserBean  usb= null;
		if(l.size()>0)
		{
				
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
				whb=(WHUserBean) it.next();
				TempPasswordUtil gtp=new TempPasswordUtil();
				String password=gtp.getPassword();
				 MailUtility mailutility=new  MailUtility();
				 mailutility.sendEmail(whb.getEmail(), password);
					txt=session.beginTransaction();
				 byte[] salt=SHAUtility.getSalt();
				 whb.setPassword(SHAUtility.get_SHA_1_SecurePassword(password, salt));
					session.save(whb);
					

					System.out.println("AFTER");

					txt.commit();
					secondaryResponse.put("homeId","200");
			//accessLevel=usb.getAccessLevel();
				//memberbean = (MembersBean) it.next();
			}
		}
		else
		{
			secondaryResponse.put("homeId","-777");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.put("homeId", secondaryResponse);
		return response;
	/*	TempPasswordUtil gtp=new TempPasswordUtil();
		 password=gtp.getPassword();*/
	}

	@Override
	public HashMap<String,String> changePassword(HashMap<String, String> inputDetails) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txt = null;
	//	HashMap<String, HashMap<String,String>> response = new HashMap<>();
		HashMap<String,String> response=new HashMap<>();
		DBHelper db=new DBHelper();
		WHUserBean whb=null;
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			session = cfg.buildSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			//Criterion cn1 =null;
			List l=null;
		 	  
				cn=Restrictions.eq("email",new String(inputDetails.get("email")));
				//cn1=Restrictions.eq("password",new String(inputDetails.get("password")));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		WHUserBean  usb= null;
		if(l.size()>0)
		{
				
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
				whb=(WHUserBean) it.next();
				
					txt=session.beginTransaction();
				 byte[] salt=SHAUtility.getSalt();
				 whb.setPassword(SHAUtility.get_SHA_1_SecurePassword(inputDetails.get("password"), salt));
					session.save(whb);
					

					System.out.println("AFTER");

					txt.commit();
					response.put("response","1");
			//accessLevel=usb.getAccessLevel();
				//memberbean = (MembersBean) it.next();
			}
		}
		else
		{
			response.put("response","-999");
		}
		}
		catch(Exception e)
		{
			response.put("response","-1");
			e.printStackTrace();
		}
		//response.put("response", secondaryResponse);
		return response;
	}
	
	@Override
	public HashMap<String,String> getProfile(String email) throws Exception {
		String emailStatus = "";
		Session session = null;
		Transaction txt = null;
		WHUserBean whb=null;
		HashMap<String,String> response = new HashMap<>();
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// session=cfg.buildSessionFactory().getCurrentSession();

			session = cfg.buildSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(WHUserBean.class);
			Criterion cn =null;
			//Criterion cn1 =null;
			List l=null;
		 	  
				cn=Restrictions.eq("email",new String(email));
				//cn1=Restrictions.eq("password",new String(inputDetails.get("password")));
			crit.add(cn);
			//crit.add(cn1);
		l=crit.list();
		if(l.size()<0)
		{
			response.put("key","-777" );
		}
		else
		{
		
			Iterator it = l.iterator();
			System.out.println("inside if");
			while (it.hasNext()) {
				
				whb=(WHUserBean) it.next();
				response.put("key","777" );
				response.put("name",whb.getName() );
				response.put("email",whb.getEmail() );
				response.put("phone",whb.getPhone() );
				
		}
		}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		//	txt.rollback();
			//session.close();
			response.put("key","-1");

		} finally {
			session.close();
		}
		return response;

	}


	public HashMap<String,String> updateProfile(WHUserBean whuserbean) throws Exception {
		String emailStatus = "";
		Session session = null;
		Transaction txt = null;
	HashMap<String,String> response = new HashMap<>();
	Connection con=null;
	con = JDBCConnection.getOracleConnection();
	PreparedStatement pstmt = null,pstmt1=null;
	int count=0;

		try 
		{
			if(con!=null)
			{
				
				String query="select count(*) from wh_user where email=?";
				pstmt1=con.prepareStatement(query);
				 
				pstmt1.setString(1, whuserbean.getEmail());
				 
				ResultSet rs=pstmt1.executeQuery();
				while(rs.next())
				{
				count=rs.getInt(1);	
				}
				if(count==0)
				{
					response.put("response", "-777");
					return response;
				}
				else
				{	
				
			
					String query1="update wh_user set name=?,phone=? where email=?";
					 pstmt=con.prepareStatement(query1);
					 pstmt.setString(2,whuserbean.getPhone());
					 pstmt.setString(1, whuserbean.getName());
					 pstmt.setString(3, whuserbean.getEmail());
					 int ret= pstmt.executeUpdate();
					 
			response.put("userName", whuserbean.getName());
			response.put("email", whuserbean.getEmail());
			response.put("response", "1");
				}
		}
		

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			//txt.rollback();
			//session.close();
			response.put("response","-1");

		} finally {
			con.close();
			//session.close();
		}
		return response;

	}

	
	@Override
	public HashMap<String, HashMap<String, String>> getCurrentDetails(HashMap<String, String> inputDetails)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, String> updatePlayerId(String email, String playerId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
