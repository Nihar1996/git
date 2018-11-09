package com.gvn.brings.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gvn.brings.dto.TestDto;
import com.gvn.brings.model.BrngAppVersion;
import com.gvn.brings.model.BrngRateLkp;
import com.gvn.brings.model.BrngTest;

@Repository
@Transactional
public class UtilityDAO extends AbstractBaseDao{
	
	public HashMap<String,String> getAppVersion(){
		List<BrngAppVersion> BrngAppVersion = getManager().createQuery("Select a From BrngAppVersion a order by effectiveDate desc",BrngAppVersion.class).getResultList();
		HashMap<String,String> versions=new HashMap<String,String>();
		versions.put("android", BrngAppVersion.get(0).getAndroidVersion());
		versions.put("ios", BrngAppVersion.get(0).getIosVersion());
		return versions;
	}
	
	public float getRateValues(String dist,String weight){
		List<BrngRateLkp> brngTests = getManager().createQuery("Select a From BrngRateLkp a order by effectiveDate desc",BrngRateLkp.class).getResultList();
		
		
		return getWeight(Float.parseFloat(dist.replace(",", "")),Float.parseFloat(weight),brngTests.get(0));
	}
	
	public float getWeight(float dist,float weight,BrngRateLkp brngTests)
	{
		
			float price;
			if (dist <= Float.parseFloat(brngTests.getInitialKms())) {
			if (weight <= Float.parseFloat(brngTests.getInitialWeight())) {
			return price = Float.parseFloat(brngTests.getInitialRate());
			} else {
			weight = weight - Float.parseFloat(brngTests.getInitialWeight());
			return price = Float.parseFloat(brngTests.getInitialRate()) + (weight * Float.parseFloat(brngTests.getRatePerKg()));
			}
			} else {
			if (weight <= Float.parseFloat(brngTests.getInitialWeight())) {
			dist = (dist - Float.parseFloat(brngTests.getInitialKms()));
			return price = Float.parseFloat(brngTests.getInitialRate()) + (dist * Float.parseFloat(brngTests.getRatePerKm()));
			} else {
			dist = dist - Float.parseFloat(brngTests.getInitialKms());
			weight = weight -  Float.parseFloat(brngTests.getInitialWeight());
			return price = Float.parseFloat(brngTests.getInitialRate()) + (dist * Float.parseFloat(brngTests.getRatePerKm())) + (weight * Float.parseFloat(brngTests.getRatePerKg()));
			}
			}
			
	}
	
}
