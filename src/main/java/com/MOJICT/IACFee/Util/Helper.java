package com.MOJICT.IACFee.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.http.entity.ByteArrayEntity;
import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.Years;

import com.MOJICT.IACFee.Beans.CPIBean;
import com.MOJICT.IACFee.Util.*;

public class Helper {

	private static Properties properties = null;
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Helper.class);

	/**
	 * Checks that the String is not null or zero length when trimmed
	 *
	 * @param data
	 *            the String to be checked
	 * @return true if data is not null or empty
	 */
	public static boolean isValidMandatoryString(String data) {
		if (data != null) {
			if (data.trim().length() < 1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks that the String is not null and is longer than 1 character in
	 * length when trimmed.
	 *
	 * @param data
	 *            the String to be checked
	 * @return true if the data is not null and is longer than 1 character
	 */
	public static boolean isValidMandatoryRadio(String data) {
		if (data != null) {
			if (data.trim().length() < 2)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * Checks that the String is not null or greater than the max parameter or
	 * shorter than the min parameter when trimmed.
	 *
	 * @param data
	 *            String to be checked for length and state
	 * @param min
	 *            the minimum length the trimmed String can be
	 * @param max
	 *            the maximum length the trimmed String can be
	 * @return boolean
	 */
	public static boolean isValidData(String data, int min, int max) {
		if (data != null) {
			if (data.trim().length() < min && data.trim().length() > max)
				return false;
			else
				return true;
		}
		return false;
	}

	/**
	 * Checks that the incoming String can be formatted as a date. See the
	 * StringToDate function for specifics on the formatting required.
	 *
	 * @param str
	 *            the String to be formatted as a date
	 * @return true if the date can be formatted
	 */
	public static boolean isValidDate(String str) {

		if (Helper.StringToDate(str) != null)
			return true;
		return false;
	}

	/**
	 * Formats the incoming String using the format dd/MM/yyyy and returns it or
	 * in when unsuccessful returns null
	 *
	 * @param str
	 *            the String to be formatted
	 * @return The formatted String or null if the String cannot be formatted.
	 */
	public static Date StringToDate(String str) {
		Date today = null;
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			today = df.parse(str);
			return today;
		} catch (Exception ex) {
			return today;
		}
	}

	/**
	 * Checks that the postcode is shorter than 9 characters and greater than 2
	 *
	 * @param postcode
	 *            String to be checked for length
	 * @return true if the postcode is a valid length
	 */
	public static boolean isValidPostCodeIAFT1(String postcode) {

		if (postcode.length() <= 8 && postcode.length() >= 2)
			return true;
		else
			return false;

	}
	public static boolean isValidPostCodeIAFT5(String postcode) {

		if (postcode.length() <= 8 && postcode.length() >= 2)
			return true;
		else
			return false;

	}

	/**
	 * Checks that the postcode is shorter than 9 characters and greater than 2
	 *
	 * @param postcode
	 *            String to be checked for length
	 * @return true if the postcode is a valid length
	 */
	public static boolean isValidPostCodeIAFT2(String postcode) {

		if (postcode.length() <= 8 && postcode.length() >= 2)
			return true;
		else
			return false;

	}

	/**
	 * Checks that the postcode is shorter than 9 characters and greater than 2
	 *
	 * @param postcode
	 *            String to be checked for length
	 * @return true if the postcode is a valid length
	 */
	public static boolean isValidPostCodeIAFT7(String postcode) {

		if (postcode.length() <= 8 && postcode.length() >= 2)
			return true;
		else
			return false;

	}


	/**
	 * Checks that the postcode is shorter than 9 characters and greater than 2
	 *
	 * @param postcode
	 *            String to be checked for length
	 * @return true if the postcode is a valid length
	 */
	public static boolean isValidPostCodeIAFT6(String postcode) {

		if (postcode.length() <= 8 && postcode.length() >= 2)
			return true;
		else
			return false;

	}

	/**
	 * Checks that the String meets the phone / fax validation criteria: Must be
	 * numeric , may contain +- must contain up to 20 characetrs
	 *
	 * @param str
	 * @return
	 */
	public static boolean isValidphonefax(String str) {
		if (str.length() > 20)
			return false;
		String pattern = "[0-9 \\-+()]{0,20}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 *
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {

		String pattern = "[0-9A-Za-z\\.\\-_]{1,127}@[0-9A-Za-z\\.\\-_]{1,127}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 *
	 * @param hours
	 * @param minutes
	 * @return
	 */
	public static boolean isValidTime(String hours, String minutes) {

		if (!hours.equals("0") && !minutes.equals("0"))
			return true;
		return false;
	}

	/**
	 *
	 * @param ref
	 * @return
	 */
	public static boolean isValidHomeOfficeRef(String ref) {

		if (ref.length() > 8 && ref.length() < 14)
			return true;

		return false;
	}

	/**
	 *
	 * @param data
	 * @param max
	 * @return
	 */
	public static boolean isValidMaxLen(String data, int max) {

		if (data.length() <= max)
			return true;
		return false;
	}


	public static boolean isValidMinLen(String data, int min) {
        if(null!=data)
        {
		if (data.length() >= min)
			return true;
		else
			return false;
        }
        else
		return false;
	}

	/**
	 *
	 * @param data
	 * @param max
	 * @param min
	 * @return
	 */
	public static boolean isValidMaxMinLen(String data, int max, int min) {

		if (data.length() >= min && data.length() <= max)
			return true;
		return false;
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static String returnIntegerValue(String data) {
		if (data.contains(":")) {
			String tmp[] = data.split(":");
			return tmp[0];
		} else
			return "0";
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static String returnStringValue(String data) {
		if (data.contains(":")) {
			String tmp[] = data.split(":");
			return tmp[1];
		} else
			return data;
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public static int returnStringAmount_paper(String date) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt1 = null;
		String amount = "0";
		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();

            logger.info("returnStringAmount_paper: date passed in <" + date + ">");

            // Replace MSSQL syntax with PostgreSQL syntax for timestamp query
			//stmt1 = conn.prepareStatement("SELECT * FROM Fees WHERE (startdate < CAST('" + date + "' AS DATETIME))");
			stmt1 = conn.prepareStatement("SELECT * FROM Fees WHERE (startdate < to_timestamp('"
							+ date + "','YYYY-MM-DD HH24:mi:ss'))");
			rs = stmt1.executeQuery();
			while (rs.next()) {
				amount = rs.getString("fees_paper");
                logger.info("retrieved row: amount <" + amount + "> date <" + rs.getTimestamp("startdate").toString() + ">");
			}
			return Integer.parseInt(amount);
		} catch (Exception e) {
			logger.error("Helper.returnStringAmount_paper", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				stmt1.close();
				conn.close();
			} catch (Exception e) {
				logger.error("Helper.returnStringAmount_paper", e);
			}
		}
		return Integer.parseInt(amount);
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public static int returnStringAmount_oral(String date) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt1 = null;
		String amount = "0";
		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();

            logger.info("returnStringAmount_oral: date passed in <" + date + ">");

            // Replace MSSQL syntax with PostgreSQL syntax for timestamp query
            //stmt1 = conn.prepareStatement("SELECT * FROM Fees WHERE (startdate < CAST('" + date + "' AS DATETIME))");
            stmt1 = conn.prepareStatement("SELECT * FROM Fees WHERE (startdate < to_timestamp('"
                                              + date + "','YYYY-MM-DD HH24:mi:ss'))");
            rs = stmt1.executeQuery();
            while (rs.next()) {
                amount = rs.getString("fees_oral");
                logger.info("retrieved row: amount <" + amount + "> date <" + rs.getTimestamp("startdate").toString() + ">");
            }
			return Integer.parseInt(amount);
		} catch (Exception e) {
			logger.error("Helper.returnStringAmount_oral", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				stmt1.close();
				conn.close();
			} catch (Exception e) {
				logger.error("Helper.returnStringAmount_oral", e);
			}
		}
		return Integer.parseInt(amount);
	}

	/**
	 *
	 * @param baos
	 * @param URN
	 * @param paymentURN
	 * @param path
	 * @return
	 */
	public static boolean savePDF(ByteArrayOutputStream baos, String URN, String paymentURN, String path) {

		String fileName = paymentURN + "_" + URN + ".pdf";

		if (CPIBean.getSTORAGE_METHOD().equals("S3")) {
			try {
				String bucketName = CPIBean.getBUCKET_NAME();
				S3Storage S3Storage = new S3Storage();
				return S3Storage.uploadToS3(new ByteArrayEntity(baos.toByteArray()), fileName, bucketName);
			} catch (Exception ex) {
				logger.error("Helper.savePDF - S3 Upload", ex);
				return false;
			}
		} else {
			try {
				LocalFileStorage LocalFileStorage = new LocalFileStorage();
				LocalFileStorage.savePDFToLocalStorage(baos, path, fileName);
				return true;
			} catch (Exception ex) {
				logger.error("Helper.savePDF - Local Storage Creation", ex);
				return false;
			}
		}


	}

	/**
	 *
	 * @param baos
	 * @param URN
	 * @param path
	 * @return
	 */
	public static boolean savePDF(ByteArrayOutputStream baos, String URN, String path) {

		String fileName = URN + ".pdf";

		if (CPIBean.getSTORAGE_METHOD().equals("S3")) {
			try {
				String bucketName = CPIBean.getBUCKET_NAME();
				S3Storage S3Storage = new S3Storage();
				return S3Storage.uploadToS3(new ByteArrayEntity(baos.toByteArray()), fileName, bucketName);
			} catch (Exception ex) {
				logger.error("Helper.savePDF", ex);
				return false;
			}
		} else {
			try {
                // TODO - Mark 14/9/22
                // String path = this.servlet.getServletContext().getRealPath("/"); - need this in calling method
				LocalFileStorage LocalFileStorage = new LocalFileStorage();
				LocalFileStorage.savePDFToLocalStorage(baos, path, fileName);
				return true;
			} catch (Exception ex) {
				logger.error("Helper.savePDF - Local Storage Creation", ex);
				return false;
			}
		}

	}

	public static String getKeyValue(String path,String key) {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(path + "WEB-INF/classes/com/MOJICT/IACFee/config/"
					+ "config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Helper.getKeyValue", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Helper.getKeyValue", e);
		}
		return (String) properties.get(key);

	}


	/**
	 * Utility method to provide three years in an ArrayList , current year and the two former years.
	 * years
	 *
	 * @return
	 */
	public static ArrayList getCurrentAndTwoFormerYears() {
		ArrayList  arr = new ArrayList ();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Years yrs = new Years();

		yrs.setYearlable("Year");
		yrs.setYearvalue("0");
		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year - 2));
		yrs.setYearvalue(String.valueOf(year - 2));
		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year - 1));
		yrs.setYearvalue(String.valueOf(year - 1));
		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year));
		yrs.setYearvalue(String.valueOf(year));
		arr.add(yrs);
		return arr;
	}

	public static ArrayList getBackYears(int backYears) {

		ArrayList arr = new ArrayList();
		Years yrs = new Years();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);



		yrs.setYearlable("Year");
		yrs.setYearvalue("0");
		arr.add(yrs);


	for(int ctr=0;ctr<=backYears;ctr++)

	{
		yrs = new Years();
		yrs.setYearlable(String.valueOf(year - ctr));
		yrs.setYearvalue(String.valueOf(year - ctr));

		arr.add(yrs);

	}

		return arr;
	}



	public static ArrayList getTwoYearsPlusMinus() {

		ArrayList arr = new ArrayList();
		Years yrs = new Years();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		yrs.setYearlable("Year");
		yrs.setYearvalue("0");
		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year - 2));
		yrs.setYearvalue(String.valueOf(year - 2));

		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year - 1));
		yrs.setYearvalue(String.valueOf(year - 1));

		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year));
		yrs.setYearvalue(String.valueOf(year));

		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year + 1));
		yrs.setYearvalue(String.valueOf(year + 1));

		arr.add(yrs);

		yrs = new Years();
		yrs.setYearlable(String.valueOf(year + 2));
		yrs.setYearvalue(String.valueOf(year + 2));

		arr.add(yrs);

		return arr;
	}


	public static boolean isValidPastDate(String str) {

		if (Helper.StringToDate(str) != null)
		{
			Date d = new Date();
			return	d.after(Helper.StringToDate(str));
		}
		else
			return false;
	}
}
