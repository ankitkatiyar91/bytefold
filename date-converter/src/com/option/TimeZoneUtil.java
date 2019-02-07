package com.option;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneUtil {
	
	private static Object[] timeZone; 
	public static Object[] getTimeZones(){
		if (timeZone==null) {
			timeZone = TimeZone.getAvailableIDs();
			Arrays.sort(timeZone);
		}
		return timeZone;
	}

}
