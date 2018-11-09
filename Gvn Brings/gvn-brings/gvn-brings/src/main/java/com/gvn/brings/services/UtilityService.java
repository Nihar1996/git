package com.gvn.brings.services;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvn.brings.dao.TestDao;
import com.gvn.brings.dao.UtilityDAO;
import com.gvn.brings.dto.TestDto;
import com.gvn.brings.model.BrngRateLkp;

@Service("utilityservice")
public class UtilityService extends AbstractBaseService{
	
	@Autowired
	private UtilityDAO utilitydao;
	
	public HashMap<String,String> getAppVersion(){
		return utilitydao.getAppVersion();
	}
	
	public float getRateValues(String dist,String weight){
		return utilitydao.getRateValues( dist, weight);
	}
}
