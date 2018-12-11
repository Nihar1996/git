package com.autoiinnovations.supporting;

import java.util.ArrayList;

public class RandomGenerator {

	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomAlphaNumeric(int count) {
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	return builder.toString();
	}
	
	public static String getHashCode(String input)
	{
		return input+"."+input.hashCode();
	}
	
	public static void main(String args[])
	{
		ArrayList<String> al=new ArrayList<>();
		
		al.add("C002");
		al.add("C003");
		al.add("C006");
		al.add("C007");
		al.add("C009");
		al.add("C010");al.add("C011");
		al.add("C012");
		al.add("C013");al.add("C014");al.add("J009");al.add("J008");al.add("J005");al.add("J006");
		String result="";
		for(String s:al)
		{
			result="insert into wh_controller_mapping(controller_id,security_token,topic) values('"+s+"','"+getHashCode(s)+"','"+s+"."+randomAlphaNumeric(4)+"');";
			System.out.println(result);
		}
		
	}
}
