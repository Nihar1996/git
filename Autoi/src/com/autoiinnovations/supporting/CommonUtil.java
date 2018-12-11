package com.autoiinnovations.supporting;

public class CommonUtil {

	public String getMonth(int count)
	{
		if(count==0)
			return "Jan";
		else if(count==1)
			return "Feb";
		else if(count==2)
			return "Mar";
		else if(count==3)
			return "Apr";
		else if(count==4)
			return "May";
		else if(count==5)
			return "Jun";
		else if(count==6)
			return "Jul";
		else if(count==7)
			return "Aug";
		else if(count==8)
			return "Sept";
		else if(count==9)
			return "Oct";
		else if(count==10)
			return "Nov";
		else if(count==11)
			return "Dec";
		else
			return "NA";
	}
	
	
}
