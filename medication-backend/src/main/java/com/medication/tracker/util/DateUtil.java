package com.medication.tracker.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
 * Author :Pavana
 * Version :1
 */
public class  DateUtil {

	
	public static Date dayPlusOne(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}

	public static  String getDay(Date dt) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week abbreviated
		return simpleDateformat.format(dt);
	}
	
	public static String getDateToString(Date dt) {
		SimpleDateFormat sdfmt= new SimpleDateFormat("dd-MMM-yyyy");
		String strOutput = sdfmt.format(dt);
		return strOutput;
	}
	
	public static Date getDateWithoutTimeUsingCalendar(Date dt) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dt);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
	    return calendar.getTime();
	}
	
	public static Date getDateWithEndTimeUsingCalendar(Date dt) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dt);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR, 23);
	    return calendar.getTime();
	}
}
