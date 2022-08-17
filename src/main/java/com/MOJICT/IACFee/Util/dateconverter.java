package com.MOJICT.IACFee.Util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class dateconverter {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(dateconverter.class);

	public static void main(String args[]) {
		try {
			logger.debug(dateconverter.convertdate());
			logger.debug(dateconverter.convertdate1());
			// logger.debug(new
			// java.util.Date().before(dateconverter.convertdate(22, 9, 2011)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Date convertdate(int day, int month, int year) throws Exception {

		String date_string = day + "/" + month + "/" + year;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = sdf.parse(date_string);
		// logger.debug(date_string);
		java.sql.Date d = new Date(date.getTime());

		// logger.debug(">>>>>>>>"+d);

		return d;
	}

	public static java.sql.Date converttodate(int day, int month, int year) throws Exception {

		String date_string = day + "/" + month + "/" + year;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = sdf.parse(date_string);
		// logger.debug(date_string);
		java.sql.Date d = new Date(date.getTime());

		// logger.debug(">>>>>>>>"+d);

		return d;
	}

	public static java.sql.Timestamp convertdate() throws Exception {

		// String date_string=day+"/"+month+"/"+year;
		Calendar cal = Calendar.getInstance();// logger.debug(date_string);
		java.sql.Time d = new java.sql.Time(cal.getTimeInMillis());

		// logger.debug(dateconverter.convertdate(cal.getTime()));
		logger.debug(">>>>>>>>" + d + "......" + new java.sql.Timestamp(cal.getTime().getTime()));

		return new java.sql.Timestamp(cal.getTime().getTime());
	}

	public static java.sql.Date convertdate1() throws Exception {

		// String date_string=day+"/"+month+"/"+year;
		Calendar cal = Calendar.getInstance();// logger.debug(date_string);
		java.sql.Time d = new java.sql.Time(cal.getTimeInMillis());

		// logger.debug(dateconverter.convertdate(cal.getTime()));
		logger.debug(">>>>>>>>" + d + "......" + new java.sql.Timestamp(cal.getTime().getTime()));
		logger.debug(new java.util.Date());
		return new java.sql.Date(cal.getTime().getTime());
	}

	public static String convertdate(java.util.Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date date_string = date;
		logger.debug(sdf.format(date_string));
		// java.sql.Date d=new Date(new java.util.Date(date_string).getTime());
		// logger.debug(d);

		return sdf.format(date_string);
	}

	public static String convertdate(java.sql.Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date_string = date;
		// logger.debug(sdf.format(date_string));
		// java.sql.Date d=new Date(new java.util.Date(date_string).getTime());
		// logger.debug(d);
		return date.getDate() + "/" + date.getMonth() + 1 + "/" + date.getYear();
	}

}
