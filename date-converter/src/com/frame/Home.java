/*
 * Home.java
 *
 * Created on __DATE__, __TIME__
 */

package com.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;

import com.event.handler.EventHandler;
import com.option.DateFormatUtil;
import com.option.TimeZoneUtil;
import com.thread.CurrentDateThread;

/**
 * 
 * @author Ankit
 */
public class Home extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form Home */
	public Home() {
		initComponents();
		/**
		 * Invoke currentDateThread
		 */
		CurrentDateThread.setCurrentTime(currentDateText);
		CurrentDateThread.setDateFormat("dd-MM-yyyy");
		CurrentDateThread.startCurrentDateThread();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setResizable(false);
		setTitle("Date Converter by Ankit Singh Katiyar");
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		
		setLocation((int)((toolkit.getScreenSize().getWidth()/2)-200), (int)((toolkit.getScreenSize().getHeight()/2)-200));
		jPanel1 = new javax.swing.JPanel();
		dateFormalLabel = new javax.swing.JLabel();
		sourceDateFormatText = new javax.swing.JTextField();
		sourceDateText = new javax.swing.JTextField();
		sourceDateFormatCombo = new javax.swing.JComboBox();
		sourceTimezoneCombo = new javax.swing.JComboBox();
		dateFormalLabel1 = new javax.swing.JLabel();
		destinationDateFormatCombo = new javax.swing.JComboBox();
		destinationDateFormatText = new javax.swing.JTextField();
		destinationTimezoneCombo = new javax.swing.JComboBox();
		destinationDateText = new javax.swing.JTextField();
		convertButton = new javax.swing.JButton();
		differenceButton= new javax.swing.JButton();
		
		currentDateFormatCombo= new javax.swing.JComboBox();
		currentDateText=new javax.swing.JTextField();
		currentDateLabel=new javax.swing.JLabel();

		currentDateLabel.setText("Current Time :");
		currentDateLabel.setBounds(90, 20, 80, 30);
		jPanel1.add(currentDateLabel);
		
		currentDateFormatCombo.setModel(new javax.swing.DefaultComboBoxModel(
				DateFormatUtil.getDateFormatsAsArray()));
		currentDateFormatCombo.setBounds(200, 20, 150, 30);
		jPanel1.add(currentDateFormatCombo);
		
		currentDateFormatCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				CurrentDateThread.setDateFormat(DateFormatUtil.getDateFormatMap().get(currentDateFormatCombo.getSelectedItem().toString()));
			}
		});
		
		currentDateText.setBounds(400, 20, 140, 30);
		currentDateText.setEditable(false);
		jPanel1.add(currentDateText);
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(204, 204, 255));
		jPanel1.setLayout(null);

		dateFormalLabel.setText("Date Format :");
		
		jPanel1.add(dateFormalLabel);
		dateFormalLabel.setBounds(10, 70, 80, 30);

		jPanel1.add(sourceDateFormatText);
		sourceDateFormatText.setBounds(250, 70, 140, 30);
		sourceDateFormatText.setText("dd-MM-yyyy");
		sourceDateFormatText.setEditable(false);
		jPanel1.add(sourceDateText);
		sourceDateText.setBounds(560, 70, 190, 30);

		sourceDateFormatCombo.setModel(new javax.swing.DefaultComboBoxModel(
				DateFormatUtil.getDateFormatsAsArray()));
		jPanel1.add(sourceDateFormatCombo);
		sourceDateFormatCombo.setBounds(90, 70, 150, 30);

		sourceDateFormatCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				EventHandler.sourceDateFormatComboChange(e,
						sourceDateFormatText);
			}
		});

		jPanel1.add(sourceTimezoneCombo);
		sourceTimezoneCombo.setBounds(400, 70, 150, 30);
		sourceTimezoneCombo.setModel(new DefaultComboBoxModel(TimeZoneUtil
				.getTimeZones()));
		dateFormalLabel1.setText("Date Format :");
		jPanel1.add(dateFormalLabel1);
		dateFormalLabel1.setBounds(10, 120, 80, 30);

		destinationDateFormatCombo
				.setModel(new javax.swing.DefaultComboBoxModel(DateFormatUtil
						.getDateFormatsAsArray()));
		jPanel1.add(destinationDateFormatCombo);
		destinationDateFormatCombo.setBounds(90, 120, 150, 30);
		destinationDateFormatCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				EventHandler.destinationDateFormatComboChange(e,
						destinationDateFormatText);
			}
		});
		jPanel1.add(destinationDateFormatText);
		destinationDateFormatText.setBounds(250, 120, 140, 30);
		destinationDateFormatText.setText("dd-MM-yyyy");
		destinationDateFormatText.setEditable(false);
		destinationTimezoneCombo.setModel(new javax.swing.DefaultComboBoxModel(
				TimeZoneUtil.getTimeZones()));
		jPanel1.add(destinationTimezoneCombo);
		destinationTimezoneCombo.setBounds(400, 120, 150, 30);
		jPanel1.add(destinationDateText);
		destinationDateText.setBounds(560, 120, 190, 30);

		jPanel1.add(differenceButton);
		differenceButton.setText("Calculate Difference");
		differenceButton.setBounds(400, 190, 190, 40);
		differenceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventHandler.calculateDifference(sourceDateFormatText.getText(),
						sourceDateText.getText(), sourceTimezoneCombo
								.getSelectedItem().toString(),
						destinationDateFormatText.getText(),
						destinationTimezoneCombo.getSelectedItem().toString(),
						destinationDateText);
			}
		});

		
		
		convertButton.setText("Convert");
		jPanel1.add(convertButton);
		convertButton.setBounds(100, 190, 190, 40);
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventHandler.convertDate(sourceDateFormatText.getText(),
						sourceDateText.getText(), sourceTimezoneCombo
								.getSelectedItem().toString(),
						destinationDateFormatText.getText(),
						destinationTimezoneCombo.getSelectedItem().toString(),
						destinationDateText);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel dateFormalLabel;
	private javax.swing.JLabel dateFormalLabel1;
	private javax.swing.JComboBox destinationDateFormatCombo;
	private javax.swing.JTextField destinationDateFormatText;
	private javax.swing.JTextField sourceDateText;
	private javax.swing.JTextField destinationDateText;
	private javax.swing.JComboBox destinationTimezoneCombo;
	private javax.swing.JButton convertButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JComboBox sourceDateFormatCombo;
	private javax.swing.JTextField sourceDateFormatText;
	private javax.swing.JComboBox sourceTimezoneCombo;
	
	private javax.swing.JLabel currentDateLabel;
	private javax.swing.JComboBox currentDateFormatCombo;
	private javax.swing.JTextField currentDateText;
	
	private javax.swing.JButton differenceButton;
	
	// End of variables declaration//GEN-END:variables

}