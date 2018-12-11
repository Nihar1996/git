package com.autoiinnovations.supporting;

import java.util.ArrayList;

public class QueryUtils {

	ArrayList<String> queryList=new ArrayList<>();
	
	public ArrayList<String> getQueryList()
	{
	queryList.add("SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >=? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");	
	queryList.add(" SELECT on_time FROM wh_device_log_info where  effective_date >= ? and effective_date <=? and status ='0' and controller_id =? and device_id =? order by effective_date desc limit 1");

	return queryList;
	}
	
	public String getYear(int count,String year)
	{
		if(count==0)
			return year+"-01-01&"+year+"-01-31";
		else if(count==1)
			return year+"-02-01&"+year+"-02-28";
		else if(count==2)
			return year+"-03-01&"+year+"-03-31";
		else if(count==3)
			return year+"-04-01&"+year+"-04-30";
		else if(count==4)
			return year+"-05-01&"+year+"-05-31";
		else if(count==5)
			return year+"-06-01&"+year+"-06-30";
		else if(count==6)
			return year+"-07-01&"+year+"-07-31";
		else if(count==7)
			return year+"-08-01&"+year+"-08-31";
		else if(count==8)
			return year+"-09-01&"+year+"-09-30";
		else if(count==9)
			return year+"-10-01&"+year+"-10-31";
		else if(count==10)
			return year+"-11-01&"+year+"-11-30";
		else if(count==11)
			return year+"-12-01&"+year+"-12-31";
		else
			return "NA";
	}
}
