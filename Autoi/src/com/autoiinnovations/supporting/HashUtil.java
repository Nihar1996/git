package com.autoiinnovations.supporting;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	public String convertToHash(String controllerId) throws NoSuchAlgorithmException
	{
		//String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(controllerId.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
         
        }
        return sb.toString();
	}
}
