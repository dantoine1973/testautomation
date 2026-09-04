package coreJava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declare date format

		// format styles, i.e., YYYY//mm//dd HH:MM:SS
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		
		// declare date class
		
		Date myDate = new Date();

		// set format for myDate
		
		System.out.println(sdf.format(myDate));
		
		// current date/time
		
		System.out.println(myDate.toString());
		

		
	}

}
