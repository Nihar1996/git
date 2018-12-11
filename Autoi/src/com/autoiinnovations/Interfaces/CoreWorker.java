package com.autoiinnovations.Interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.autoiinnovations.beans.WHDeviceLogBean;
import com.autoiinnovations.beans.WHScheduler;

public interface CoreWorker {

	public HashMap<String, HashMap<String, String>> verifyController(HashMap<String,String> inputDetails) throws Exception;
	public int updateController(HashMap<String,HashMap<String,String>> inputDetails) throws Exception;
	public int scheduleDevice(HashMap<String,String> inputDetails) throws Exception;
	public  ArrayList<HashMap<String,String>> viewScheduledDevices(HashMap<String,String> inputDetails) throws Exception;
	public int performActionWH(WHDeviceLogBean deviceLogInfoBean) throws Exception;
	public HashMap<String,String> getMetrics(HashMap<String,String> inputDetails) throws Exception;
}
