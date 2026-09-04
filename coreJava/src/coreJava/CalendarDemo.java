package coreJava;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(sdf.format(cal.getTime()));
		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		
	}

}
