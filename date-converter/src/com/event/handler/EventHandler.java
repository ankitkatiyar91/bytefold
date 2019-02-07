package com.event.handler;

import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.option.DateFormatUtil;

public class EventHandler {

	/**
	 * Destination date format combo change
	 */
	public static void destinationDateFormatComboChange(ItemEvent itemEvent,JTextField destinationDateFromat) {
		String selectedFormat=(String)((JComboBox)itemEvent.getSource()).getSelectedItem();
		if(selectedFormat.equalsIgnoreCase("custom")){
			destinationDateFromat.setText("");
			destinationDateFromat.setEditable(true);
		}else{
			destinationDateFromat.setText(DateFormatUtil.getDateFormatMap().get(selectedFormat).toString());
			destinationDateFromat.setEditable(false);
		}
		
	}

	public static void sourceDateFormatComboChange(ItemEvent itemEvent,JTextField sourcDateFromat) {
		String selectedFormat=(String)((JComboBox)itemEvent.getSource()).getSelectedItem();
		if(selectedFormat.equalsIgnoreCase("custom")){
			sourcDateFromat.setText("");
			sourcDateFromat.setEditable(true);
		}else{
			sourcDateFromat.setText(DateFormatUtil.getDateFormatMap().get(selectedFormat).toString());
			sourcDateFromat.setEditable(false);
		}
	
	}
	
	public static void convertDate(String sourceDateFormat, String sourceDateText,String sourceTimeZone, String destinationDateFormat,String destinationTimeZone, JTextField destinationDateText){
		try {
			/**
			 * Create a date formatter for source format and TimeZone
			 */
			DateFormat sourceFormatter=new SimpleDateFormat(sourceDateFormat);
			sourceFormatter.setTimeZone(TimeZone.getTimeZone(sourceTimeZone));
			Date date=sourceFormatter.parse(sourceDateText);
			
			/**
			 * Create destination date formatter with format and TimeZone
			 */
			DateFormat destinationFormatter=new SimpleDateFormat(destinationDateFormat);
			destinationFormatter.setTimeZone(TimeZone.getTimeZone(destinationTimeZone));
			/**
			 * Set destination date to text field
			 */
			destinationDateText.setText(destinationFormatter.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(destinationDateText, "Unable to convert. Make sure you filled all the fields properly");
		}
	}

	public static void calculateDifference(String sourceDateFormat, String sourceDateText,String sourceTimeZone, String destinationDateFormat,String destinationTimeZone,JTextField destinationDateText){
		
		try {
			/**
			 * Create a date formatter for source format and TimeZone
			 */
			DateFormat sourceFormatter=new SimpleDateFormat(sourceDateFormat);
			sourceFormatter.setTimeZone(TimeZone.getTimeZone(sourceTimeZone));
			Calendar sourceCalender=Calendar.getInstance(TimeZone.getTimeZone(sourceTimeZone));
			sourceCalender.setTime(sourceFormatter.parse(sourceDateText));
			
			
			/**
			 * Create destination date formatter with format and TimeZone
			 */
			DateFormat destinationFormatter=new SimpleDateFormat(destinationDateFormat);
			destinationFormatter.setTimeZone(TimeZone.getTimeZone(destinationTimeZone));
			Calendar destinationCalendar=Calendar.getInstance(TimeZone.getTimeZone(destinationTimeZone));
			destinationCalendar.setTime(destinationFormatter.parse(destinationDateText.getText()));
			
			int year=sourceCalender.get(Calendar.YEAR)-destinationCalendar.get(Calendar.YEAR);
			int month=sourceCalender.get(Calendar.MONTH)-destinationCalendar.get(Calendar.MONTH);
			int day=sourceCalender.get(Calendar.DAY_OF_MONTH)-destinationCalendar.get(Calendar.DAY_OF_MONTH);
			int hour=sourceCalender.get(Calendar.HOUR_OF_DAY)-destinationCalendar.get(Calendar.HOUR_OF_DAY);
			int minute=sourceCalender.get(Calendar.MINUTE)-destinationCalendar.get(Calendar.MINUTE);
			int second=sourceCalender.get(Calendar.SECOND)-destinationCalendar.get(Calendar.SECOND);
			int milliSecond=sourceCalender.get(Calendar.MILLISECOND)-destinationCalendar.get(Calendar.MILLISECOND);
			
			String message=year+" Year "+month+" Month"+day+" Day "+hour+" Hour "+minute+" Minute "+second+" Second "+milliSecond+" Milli Second";
			
			
			JOptionPane.showMessageDialog(destinationDateText, "Difference \n"+(message));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

		
	}

}
