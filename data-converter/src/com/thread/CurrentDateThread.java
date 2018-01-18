package com.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;

public class CurrentDateThread {
	
	private static JTextField currentTime;
	private static DateFormat dateFormat=new SimpleDateFormat("dd-MM-yy HH:mm:ss");
	
	public static void startCurrentDateThread(){
		new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true){
					currentTime.setText(dateFormat.format(Calendar.getInstance().getTime()));
					try {
						Thread.sleep(900);
					} catch (Throwable e) {e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
	public static void setCurrentTime(JTextField currentTime) {
		CurrentDateThread.currentTime = currentTime;
	}
	
	public static void setDateFormat(String dateFormatString) {
		try {
			CurrentDateThread.dateFormat = new SimpleDateFormat(dateFormatString);
		} catch (Exception e) {}
	}

}
