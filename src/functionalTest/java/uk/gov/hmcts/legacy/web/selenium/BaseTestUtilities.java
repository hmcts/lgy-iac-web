/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium;

import uk.gov.hmcts.legacy.web.selenium.iaft.IAFTFlowEnum;
import uk.gov.hmcts.legacy.web.util.DBUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseTestUtilities {
	// pdf
	// singles
	public static Pattern pdf_IAFT1_AsylumRemission_SingleAppeal_Pattern = Pattern.compile("2{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT1_ImmigrationRemission_SingleAppeal_Pattern = Pattern.compile("3{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT2_Remission_SingleAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT3_Remission_SingleAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT1_Asylum_Payment_SingleAppeal_Pattern = Pattern.compile("2{2}8{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT1_Immigration_Payment_SingleAppeal_Pattern = Pattern.compile("3{2}8{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT2_Payment_SingleAppeal_Pattern = Pattern.compile("4{2}8{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT3_Payment_SingleAppeal_Pattern = Pattern.compile("4{2}8{2}\\d{8}.pdf");

	// multis
	// all remissions
	public static Pattern pdf_IAFT1_AsylumRemission_MultiAppeal_Pattern = Pattern.compile("2{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT1_ImmigrationRemission_MultiAppeal_Pattern = Pattern.compile("3{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT2_Remission_MultiAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT3_Remission_MultiAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.pdf");

	// payments
	public static Pattern pdf_IAFT1_Asylum_Payment_MultiAppeal_Pattern = Pattern
			.compile("7{2}\\d{8}_2{2}7{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT1_Immigration_Payment_MultiAppeal_Pattern = Pattern
			.compile("7{2}\\d{8}_3{2}7{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT2_Payment_MultiAppeal_Pattern = Pattern.compile("7{2}\\d{8}_4{2}7{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT3_Payment_MultiAppeal_Pattern = Pattern.compile("7{2}\\d{8}_4{2}7{2}\\d{8}.pdf");

	// remissions with a payment
	public static Pattern pdf_IAFT1_Asylum_Remission_MultiAppealWithPayment_Pattern = Pattern
			.compile("7{2}\\d{8}_2{2}9{2}\\d{8}.pdf");


	public static Pattern pdf_IAFT1_Immigration_Remission_MultiAppealWithPayment_Pattern = Pattern
			.compile("7{2}\\d{8}_3{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT2_Remission_MultiAppealWithPayment_Pattern = Pattern
			.compile("7{2}\\d{8}_4{2}9{2}\\d{8}.pdf");

	public static Pattern pdf_IAFT3_Remission_MultiAppealWithPayment_Pattern = Pattern
			.compile("7{2}\\d{8}_4{2}9{2}\\d{8}.pdf");

	// xmls
	public static Pattern xml_IAFT1_AsylumRemission_SingleAppeal_Pattern = Pattern.compile("2{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_ImmigrationRemission_SingleAppeal_Pattern = Pattern.compile("3{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT2_Remission_SingleAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT3_Remission_SingleAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_Asylum_Payment_SingleAppeal_Pattern = Pattern.compile("2{2}8{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_Immigration_Payment_SingleAppeal_Pattern = Pattern.compile("3{2}8{2}\\d{8}.xml");

	public static Pattern xml_IAFT2_Payment_SingleAppeal_Pattern = Pattern.compile("4{2}8{2}\\d{8}.xml");

	public static Pattern xml_IAFT3_Payment_SingleAppeal_Pattern = Pattern.compile("4{2}8{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_AsylumRemission_MultiAppeal_Pattern = Pattern.compile("2{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_ImmigrationRemission_MultiAppeal_Pattern = Pattern.compile("3{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT2_Remission_MultiAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT3_Remission_MultiAppeal_Pattern = Pattern.compile("4{2}9{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_Asylum_Payment_MultiAppeal_Pattern = Pattern.compile("2{2}7{2}\\d{8}.xml");

	public static Pattern xml_IAFT1_Immigration_Payment_MultiAppeal_Pattern = Pattern.compile("3{2}7{2}\\d{8}.xml");

	public static Pattern xml_IAFT2_Payment_MultiAppeal_Pattern = Pattern.compile("4{2}7{2}\\d{8}.xml");

	public static Pattern xml_IAFT3_Payment_MultiAppeal_Pattern = Pattern.compile("4{2}7{2}\\d{8}.xml");

	public static String pdfFileDir = "C://IAC_Submission//PDF_Files";

	public static String xmlFileDir = "C://IAC_Submission//XML_Files";

	public static String seleniumTestFileDir = System.getProperty("user.dir") + "//test//selenium//results";

	public static File pdfDir = new File(pdfFileDir);

	public static File xmlDir = new File(xmlFileDir);

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	public static ResultSet r = null;

	public static Statement s = null;

	public static Connection conn = null;

	public static void MatcherCheck(String testName, Matcher m, String fileName, File pdfFile, File copyFile) {
		if (m.matches()) {
			System.out.println("Match Found: " + fileName);
			try {
				System.out.println("Copying :" + pdfFile + " to :" + copyFile);
				FileUtils.copyFile(pdfFile, copyFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (testName.toLowerCase().contains("multi")) {
				System.out.println("WARN:\n" + "\t" + testName + "\n" + "\t\t FileName:" + fileName
						+ " does not match pattern : " + m.pattern().pattern());
			} else {
				System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tFileName:" + fileName
						+ " does not match pattern : " + m.pattern().pattern());
			}
		}
	}

	public static void DatabaseCheck(String testName, Date d, String[][] expectedResults) {
		try {
			System.out.println("Checking Details on database - each dot indicates a successful match");
			System.out.println("Checking " + expectedResults.length + " matches");
			conn = DBUtils.getConnection();
			s = conn.createStatement();
			r = s.executeQuery("Select * from IAFT1 where CAST('" + BaseTestUtilities.sdf.format(d)
					+ "' AS smalldatetime) < date_added");
			System.out.println("SQL Query: " + "Select * from IAFT1 where CAST('" + BaseTestUtilities.sdf.format(d)
					+ "' AS smalldatetime) < date_added");
			boolean success = false;
			int count = 0;
			while (r.next()) {
				count++;
				if (count > 1) {
					System.out.println("FAIL:\n" + "\t" + testName + "\n"
							+ "\t\tToo many matching entries on database: ");
				} else {
					String columnName = "";
					String expectedValue = "";
					String actualValue = "";
					for (int column = 0; column < expectedResults.length; column++) {
						columnName = expectedResults[column][0];
						expectedValue = expectedResults[column][1];
						actualValue = r.getString(columnName);
						if (null == actualValue) {
							actualValue = "";
						}
						if (!expectedValue.equals(actualValue)) {
							System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tColumn :" + columnName
									+ " Expected Value: " + expectedValue + " does not match actualValue: "
									+ actualValue);
						} else {
							System.out.print(".");
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pdfTest(String testName, Long currentMillis, Pattern p, String copyFolder) {
		pdfTest(0, testName, currentMillis, p, copyFolder);
	}

	private static void pdfTest(int pos, String testName, Long currentMillis, Pattern p, String copyFolder) {
		if (BaseTestUtilities.pdfDir.exists()) {
			String[] fileList = BaseTestUtilities.pdfDir.list();
			boolean filefound = false;
			File pdfFile = null;
			for (String fileName : fileList) {
				System.out.println("\t\t\t\tChecking file: " + fileName);
				pdfFile = new File(BaseTestUtilities.pdfFileDir + "//" + fileName);
				if (pdfFile.isFile()) {
					if (pdfFile.lastModified() > currentMillis) {
						File copyFile = new File(System.getProperty("user.dir") + "//test//selenium//results//"
								+ copyFolder + "//" + pdfFile.getName());
						filefound = true;
						int finalVal = 0;
						if (pos < 10) {
							finalVal = Integer
									.parseInt(fileName.substring(fileName.length() - 5, fileName.length() - 4));
						} else {
							finalVal = Integer
									.parseInt(fileName.substring(fileName.length() - 6, fileName.length() - 4));
						}
						if (pos == 0 || finalVal == pos) {
							BaseTestUtilities.MatcherCheck(testName, p.matcher(fileName), fileName, pdfFile, copyFile);
						}
					}
				}
			}
			if (!filefound) {
				System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tNo PDF Created");
			}
		} else {
			System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tUnable to locate PDF directory at: "
					+ BaseTestUtilities.pdfDir.getAbsolutePath());
		}
	}

	private static void xmlTest(String testName, Long currentMillis, Pattern p, String copyFolder) {
		xmlTest(0, testName, currentMillis, p, copyFolder);
	}

	private static void xmlTest(int pos, String testName, Long currentMillis, Pattern p, String copyFolder) {
		if (BaseTestUtilities.xmlDir.exists()) {
			String[] fileList = BaseTestUtilities.xmlDir.list();
			boolean filefound = false;
			File xmlFile = null;
			for (String fileName : fileList) {
				System.out.println("\t\t\t\tChecking file: " + fileName);
				xmlFile = new File(BaseTestUtilities.xmlFileDir + "//" + fileName);
				if (xmlFile.isFile()) {
					if (xmlFile.lastModified() > currentMillis) {
						File copyFile = new File(System.getProperty("user.dir") + "//test//selenium//results//"
								+ copyFolder + "//" + xmlFile.getName());
						filefound = true;
						int finalVal = 0;
						if (pos < 10) {
							finalVal = Integer
									.parseInt(fileName.substring(fileName.length() - 5, fileName.length() - 4));
						} else {
							finalVal = Integer
									.parseInt(fileName.substring(fileName.length() - 6, fileName.length() - 4));
						}
						System.out.println("finalInt = " + finalVal);
						if (pos == 0 || finalVal == pos) {
							BaseTestUtilities.MatcherCheck(testName, p.matcher(fileName), fileName, xmlFile, copyFile);
						}
					}
				}
			}
			if (!filefound) {
				System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tNo XML Created");
			}
		} else {
			System.out.println("FAIL:\n" + "\t" + testName + "\n" + "\t\tUnable to locate PDF directory at: "
					+ BaseTestUtilities.pdfDir.getAbsolutePath());
		}
	}

	public static void testResults(boolean finished, String testName, Long currentMillis, Pattern pdfPattern,
			Pattern xmlPattern, String[][] expectedResults, String copyFolder) {

		if (finished) {
			BaseTestUtilities.pdfTest(testName, currentMillis, pdfPattern, copyFolder);
			BaseTestUtilities.xmlTest(testName, currentMillis, xmlPattern, copyFolder);
		}
		BaseTestUtilities.DatabaseCheck(testName, new Date(currentMillis), expectedResults);
	}

	public static void testResults(int pos, boolean finished, String testName, Long currentMillis, Pattern pdfPattern,
			Pattern xmlPattern, String[][] expectedResults, String copyFolder) {
		if (finished) {
			BaseTestUtilities.pdfTest(pos, testName, currentMillis, pdfPattern, copyFolder);
			BaseTestUtilities.xmlTest(pos, testName, currentMillis, xmlPattern, copyFolder);
		}
		BaseTestUtilities.DatabaseCheck(testName, new Date(currentMillis), expectedResults);
	}

	public static void clearOutTestFiles(String filePath) {
		if (filePath == null) {
			filePath = seleniumTestFileDir;
		}
		File f = new File(filePath);
		System.out.println("File path to clear: " + filePath);
		if (f.isDirectory() && isValid(filePath)) {
			String[] files = f.list();
			for (String fileName : files) {
				clearOutTestFiles(filePath + "\\" + fileName);
			}
		} else if (f.isFile() && isValid(filePath)) {
			System.out.println(filePath + " - attempting delete");
			f.delete();
		} else {
			System.out.println(filePath + " not valid for clearing");
		}
	}

	private static boolean isValid(String check) {
		return check.indexOf("svn") == -1;
	}

	public static String getOrderId(long currentMillis, IAFTFlowEnum flow) {
		Date d = new Date(currentMillis);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
		System.out.println("Date calculated is: "+ sdf.format(d));
		String actualValue = "";
		try {
			System.out.println("Retrieveing security token to map to order id");
			conn = null;
			s = null;
			r = null;
			conn = DBUtils.getConnection();
			s = conn.createStatement();
			if (flow.equals(IAFTFlowEnum.IAFT1_FLOW)) {
				System.out.println("SQL Query: " + "Select securitytoken from IAFT1 where CAST('"
						+ BaseTestUtilities.sdf.format(d) + "' AS smalldatetime) < date_added");
				r = s.executeQuery("Select securitytoken from IAFT1 where CAST('" + BaseTestUtilities.sdf.format(d)
						+ "' AS smalldatetime) < date_added");
			}
			if (flow.equals(IAFTFlowEnum.IAFT2_FLOW)) {
				System.out.println("SQL Query: " + "Select securitytoken from IAFT2 where CAST('"
						+ BaseTestUtilities.sdf.format(d) + "' AS smalldatetime) < date_added");
				r = s.executeQuery("Select securitytoken from IAFT2 where CAST('" + BaseTestUtilities.sdf.format(d)
						+ "' AS smalldatetime) < date_added");
			}
			if (flow.equals(IAFTFlowEnum.IAFT3_FLOW)) {
				System.out.println("SQL Query: " + "Select securitytoken from IAFT3 where CAST('"
						+ BaseTestUtilities.sdf.format(d) + "' AS smalldatetime) < date_added");
				r = s.executeQuery("Select securitytoken from IAFT3 where CAST('" + BaseTestUtilities.sdf.format(d)
						+ "' AS smalldatetime) < date_added");
			}
			if(r.next()) {
			actualValue = r.getString("securitytoken");
			} else {
				System.out.println("No results found");
			}
			r = null;
			s = null;
			s = conn.createStatement();
			System.out.println("Select AggregatedURN, submissionURN from formsdata where securitytoken ='"
					+ actualValue + "'");
			r = s.executeQuery("Select AggregatedURN, submissionURN from formsdata where securitytoken ='"
					+ actualValue + "'");
			r.next();
			actualValue = r.getString("submissionURN");
			System.out.println("actualvalue = SubmissionURN: " + actualValue);
			String temp = r.getString("AggregatedURN");
			if (null != temp && !"null".equals(temp)) {
				actualValue = temp;
				System.out.println("actualvalue = AggregatedURN: " + actualValue);
			}
			System.out.println("actualValue : " + actualValue);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// not an issue
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("returning : " + actualValue);
		return actualValue;
	}
}
