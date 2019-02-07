package com.option;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
public class DateFormatUtil {

	
	private static Map<String, String> dateFormatMap;
	private static Object[] dateFormats;
	private static final Date defaultDate = new Date(114,11,31,23,59,59);

	public static Object[] getDateFormatsAsArray(){
			System.out.println(getDateFormatMap());
			dateFormats=getDateFormatMap().keySet().toArray();
		return dateFormats;
	}

	public static Map<String, String> getDateFormatMap(){
		if (dateFormatMap == null) {

			dateFormatMap = new HashMap<String, String>();

			dateFormatMap.put("Custom", "Custom");
			try {
				for(String format:getFormatList()){
					try {
						dateFormatMap.put(new SimpleDateFormat(format).format(defaultDate),format);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dateFormatMap;
	}
	
	public static ArrayList<String> getFormatList(){
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("dd-MM-yyyy");
		arrayList.add("dd MM yyyy");
		arrayList.add("dd-MM-yyyy HH:mm:SS");
		arrayList.add("yyyy MM dd");
		arrayList.add("yyyy_MM_dd");
		arrayList.add("yyyy.MM.dd");
		arrayList.add("yyyy.MMMMM.dd");
		arrayList.add("yyyyy.MMMMM.dd");
		arrayList.add("dd MMM yyyy HH:mm:ss");
		
		return arrayList;
	}
}
