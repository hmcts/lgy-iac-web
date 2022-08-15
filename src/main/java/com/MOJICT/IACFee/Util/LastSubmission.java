// TODO - Differences between master and production.

package com.MOJICT.IACFee.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.AggregatedSubmissionBean;
import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;
import com.lowagie.text.DocumentException;

/**
 * This action represents the business logic that occurs after an initial
 * connection to BarclayCard to make a payment has been authorised and the
 * payment has been accepted or rejected.
 *
 * This class has to handle the following flows: 1 - Single appeal payment
 * successful - output = PDF and XML, not allow further payment allowed 2 -
 * Single appeal top up payment successful - output = XML, not allow further
 * payments allowed 3 - Single payment unsuccessful (Barclaycard failure) -
 * Check Count 3.1 Count < 5 - retry possible 3.2 Count >= 5 - printable pdf
 * submission not allow further submissions no xml 4 - Top up payment
 * unsuccessful - Check Count 4.1 Count < 5 - retry possible 4.2 Count >= 5 -
 * printable pdf submission not allow further submissions no xml 5 - Multiple
 * appeal payment successful - output = PDF /XML per appeal, no further payment
 * allowed 6 - Multiple appeal top up payment successful - output = XML, no
 * further payments allowed 7 - Multiple appeal payment unsuccessful - Check
 * Count 7.1 Count < 5 - retry possible 7.2 Count >= 5 - printable PDF for each
 * appeal no xml 8 - Multiple Top up payment unsuccessful - Check Count 8.1
 * Count < 5 - retry possible 8.2 Count >= 5 - printable pdf submission not
 * allow further submissions no xml Receives all returns from BarclayCard
 *
 * @author WEBTEAM4
 *
 */
public class LastSubmission {

	public static final String IAFT1 = "IAFT1";
	public static final String IAFT2 = "IAFT2";
	public static final String IAFT3 = "IAFT3";
	public static final String TOP_UP_TYPE = "2";
	public static final String TRANSACTION_SUCCESS = "Success";
	public static final String TRANSACTION_FAILURE = "failure";
	public DataSource datasource = null;
	/**The SQL retrieve for last 10 submissions .*/
	public static String sql_retrieve_10urn = "select * from formsdata order by Id Desc";
	public static String sql_retrieve_24hrsubmissionsIAFT1 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT1 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT2 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT2 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT3 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT3 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT5 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT5 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT6 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT6 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT7 = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT7 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? ";

	public static String sql_retrieve_24hrsubmissionsIAFT1_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT1 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? and y.aggregatedURN=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT2_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT2 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=?  and y.aggregatedURN=?";
	public static String sql_retrieve_24hrsubmissionsIAFT3_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT3 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=?  and y.aggregatedURN=?";
	public static String sql_retrieve_24hrsubmissionsIAFT5_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT5 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=? and y.aggregatedURN=? ";
	public static String sql_retrieve_24hrsubmissionsIAFT6_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT6 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=?  and y.aggregatedURN=?";
	public static String sql_retrieve_24hrsubmissionsIAFT7_notknown = "SELECT  x.[ID],y.[paymentURN],y.[aggregatedURN],y.[submissionURN],y.[securitytoken],y.formname,y.formtitle,y.amount,x.s1a,x.s1b,x.s1c FROM IAFT7 x ,formsdata y  where date_added between  ?   and  ?  and x.securitytoken=y.securitytoken and y.transactionstatus=? and y.status=?  and y.aggregatedURN=?";
	public static String gdprqry1 = "DELETE FROM IAFT1 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String gdprqry2 = "DELETE FROM IAFT2 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String gdprqry3 = "DELETE FROM IAFT3 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String gdprqry5 = "DELETE FROM IAFT5 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String gdprqry6 = "DELETE FROM IAFT6 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String gdprqry7 = "DELETE FROM IAFT7 WHERE date_added < DATE_SUB(NOW(), INTERVAL 3 MONTH)";
	public static String sql_retrieve_24hrtopuppayments = "SELECT * FROM transaction_details  where dateofpayment between  ?   and  ?  and  transactionstatus=? ";


	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(LastSubmission.class);

	/**
	 *
	 */


	public static String process10Appeals() throws IOException, DocumentException {

		ArrayList<AggregatedSubmissionBean> asBeansArrayList = LastSubmission
				.get10submission();
		DataSource datasource = null;
		HttpServletRequest request = null;
		String text = "";
		text = "Submission date is: " + new Date().toGMTString() + "\n";
		for (AggregatedSubmissionBean asBean : asBeansArrayList) {
			String security = asBean.getSecuritytoken();
			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();

			ByteArrayOutputStream baos = null;

			text = text + "Type of Submission: " + type + "\t Submission URN is " + URN + "\n";


		}
		return text;
	}

	public static ArrayList<AggregatedSubmissionBean> get10submission() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;

		String urn = "";
		DataSource datasource = null;

		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {
			logger.info("LastSubmission.get10submission - Retrieving last 10 submissions");
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();
			String thissql = sql_retrieve_10urn;
			stmt = conn.prepareStatement(thissql);

			rs = stmt.executeQuery();
			int count = 0;
			int cnt = 0;
			while (rs.next() && cnt < 10) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				asBean.setPaymenturn(rs.getString("AggregatedURN"));
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));

				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));

				asBeansArrayList.add(asBean);
				++cnt;
			}
			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("LastSubmission.get10submission", e);
		} finally {
			try {
				LastSubmission.closeResultSet(rs);
				LastSubmission.closePreparedStatement(stmt);
				LastSubmission.closeConnection(conn);
				return asBeansArrayList;
			} catch (SQLException sqle) {
				logger.error("LastSubmission.get10submission", sqle);
			}
		}
		return asBeansArrayList;
	}

	private static String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}
	private static String getYesterdayDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMMMMMMM, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}
	private static String getTodayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}
	public static ArrayList<AggregatedSubmissionBean> get24hrsubmission() {

		ResultSet rs = null;
		ResultSet rsmain = null;
		Connection conn = null;
		String urn = "";
		DataSource datasource = null;
		PreparedStatement stmt_main = null;
		PreparedStatement stmt_main2 = null;
		PreparedStatement stmt_main3 = null;
		PreparedStatement stmt_main5 = null;
		PreparedStatement stmt_main6 = null;
		PreparedStatement stmt_main7 = null;
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {
			logger.info("LastSubmission.get24hrsubmission - Retrieving submissions for last 24hrs");
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();

			String thissql = sql_retrieve_24hrsubmissionsIAFT1;
			String thissql1 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			String thissql2 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			String thissql3 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			String thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			String thissql5 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			String thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			stmt_main = conn.prepareStatement(thissql);
			stmt_main.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main.setString(2, LastSubmission.getTodayDateString());
			stmt_main.setString(3, "Success");
			stmt_main.setString(4, "Completed");
			int count = 0;
			int cnt = 0;

			rs = stmt_main.executeQuery();
			while (rs.next()) {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					if(asBean.getUrn().substring(2, 4).equals("99"))
					{
						asBean.setPaymenturn("                    ");
					}
					else
					{
						asBean.setPaymenturn(rs.getString("AggregatedURN"));
					}
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));

				ResultSet rs1 = null;


				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				//closing resultset

				ResultSet rs2 = null;


				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				//closing resultset
				ResultSet rs3 = null;

				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

						}ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
							if(asBean1.getAmount()!=0)
							{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
							if(asBean1.getAmount()!=0)
							{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
							if(asBean1.getAmount()!=0)
							{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				//ResultSet rs3 = null;
				asBeansArrayList.add(asBean);
				++cnt;

				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);

				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);

			}
			thissql = sql_retrieve_24hrsubmissionsIAFT2;
			thissql1 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			thissql2 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			thissql3 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			thissql5 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			//PreparedStatement stmt_main2 = null;
			stmt_main2 = conn.prepareStatement(thissql);
			stmt_main2.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main2.setString(2, LastSubmission.getTodayDateString());
			stmt_main2.setString(3, "Success");
			stmt_main2.setString(4, "Completed");
			rs = stmt_main2.executeQuery();

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					if(asBean.getUrn().substring(2, 4).equals("99"))
					{
						asBean.setPaymenturn("                    ");
					}
					else
					{
						asBean.setPaymenturn(rs.getString("AggregatedURN"));
					}
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));


				//QueryBuilder.closeResultSet(rs2);
				ResultSet rs1 = null;
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs2 = null;
				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs3 = null;
				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				//				ResultSet rs3 = null;
				asBeansArrayList.add(asBean);
				++cnt;
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);
				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);

			}
			thissql = sql_retrieve_24hrsubmissionsIAFT3;
			thissql1 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			thissql2 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			thissql3 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			thissql5 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			//PreparedStatement stmt_main3 = null;
			stmt_main3 = conn.prepareStatement(thissql);
			stmt_main3.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main3.setString(2, LastSubmission.getTodayDateString());
			stmt_main3.setString(3, "Success");
			stmt_main3.setString(4, "Completed");

			rs = stmt_main3.executeQuery();

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					asBean.setPaymenturn(rs.getString("AggregatedURN"));
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));
				logger.debug(asBean.getName());
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				//QueryBuilder.closeResultSet(rs2);
				ResultSet rs1 = null;
				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs2 = null;
				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs3 = null;
				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

					}ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				asBeansArrayList.add(asBean);
				++cnt;
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);

				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);

			}
			//PreparedStatement stmt_main5 = null;
			thissql = sql_retrieve_24hrsubmissionsIAFT5;
			thissql1 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			thissql2 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			thissql3 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			thissql5 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			stmt_main5 = conn.prepareStatement(thissql);
			stmt_main5.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main5.setString(2, LastSubmission.getTodayDateString());
			stmt_main5.setString(3, "Success");
			stmt_main5.setString(4, "Completed");

			rs = stmt_main5.executeQuery();

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					if(asBean.getUrn().substring(2, 4).equals("99"))
					{
						asBean.setPaymenturn("                    ");
					}
					else
					{
						asBean.setPaymenturn(rs.getString("AggregatedURN"));
					}
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));
				logger.debug(asBean.getName());
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				//QueryBuilder.closeResultSet(rs2);
				ResultSet rs1 = null;
				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {

					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs2 = null;
				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs3 = null;
				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

					}ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				asBeansArrayList.add(asBean);
				++cnt;
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);

				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);
			}
			thissql = sql_retrieve_24hrsubmissionsIAFT6;
			thissql1 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			thissql2 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			thissql3 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			thissql5 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			//PreparedStatement stmt_main6 = null;
			stmt_main6 = conn.prepareStatement(thissql);
			stmt_main6.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main6.setString(2, LastSubmission.getTodayDateString());
			stmt_main6.setString(3, "Success");
			stmt_main6.setString(4, "Completed");

			rs = stmt_main6.executeQuery();

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					if(asBean.getUrn().substring(2, 4).equals("99"))
					{
						asBean.setPaymenturn("                    ");
					}
					else
					{
						asBean.setPaymenturn(rs.getString("AggregatedURN"));
					}
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));
				logger.debug(asBean.getName());
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				//QueryBuilder.closeResultSet(rs2);
				ResultSet rs1 = null;
				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs2 = null;
				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs3 = null;
				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

					}ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {

					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				asBeansArrayList.add(asBean);
				++cnt;
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);

				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);
			}
			thissql = sql_retrieve_24hrsubmissionsIAFT7;
			thissql1 = sql_retrieve_24hrsubmissionsIAFT3_notknown;
			thissql2 = sql_retrieve_24hrsubmissionsIAFT2_notknown;
			thissql3 = sql_retrieve_24hrsubmissionsIAFT1_notknown;
			thissql7 = sql_retrieve_24hrsubmissionsIAFT7_notknown;
			thissql5 = sql_retrieve_24hrsubmissionsIAFT5_notknown;
			thissql6 = sql_retrieve_24hrsubmissionsIAFT6_notknown;
			//PreparedStatement stmt_main7 = null;
			stmt_main7 = conn.prepareStatement(thissql);
			stmt_main7.setString(1, LastSubmission.getYesterdayDateString());
			stmt_main7.setString(2, LastSubmission.getTodayDateString());
			stmt_main7.setString(3, "Success");
			stmt_main7.setString(4, "Completed");

			rs = stmt_main7.executeQuery();

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				AggregatedSubmissionBean asBean1 = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				if(null==rs.getString("AggregatedURN"))
				{
					asBean.setPaymenturn("                    ");
				}
				else
				{
					if(asBean.getUrn().substring(2, 4).equals("99"))
					{
						asBean.setPaymenturn("                    ");
					}
					else
					{
						asBean.setPaymenturn(rs.getString("AggregatedURN"));
					}
				}
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				if(asBean.getAmount()!=0)
				{
					count++;
					asBean.setCount(count);
				}
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setName(rs.getString("s1c") + " " + rs.getString("s1b") + " " + rs.getString("s1a"));
				logger.debug(asBean.getName());
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				//QueryBuilder.closeResultSet(rs2);
				ResultSet rs1 = null;
				stmt = conn.prepareStatement(thissql1);
				stmt.setString(1, LastSubmission.getYesterdayDateString());
				stmt.setString(2, LastSubmission.getTodayDateString());
				stmt.setString(3, "Not Known");
				stmt.setString(4, "Completed");
				stmt.setString(5, asBean.getPaymenturn());
				rs1 = stmt.executeQuery();
				while (rs1.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs1.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs1.getString("formname"));
					asBean1.setAmount(rs1.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs1.getString("securitytoken"));
					asBean1.setName(rs1.getString("s1c") + " " + rs1.getString("s1b") + " " + rs1.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs2 = null;
				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, LastSubmission.getYesterdayDateString());
				stmt2.setString(2, LastSubmission.getTodayDateString());
				stmt2.setString(3, "Not Known");
				stmt2.setString(4, "Completed");
				stmt2.setString(5, asBean.getPaymenturn());
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs2.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs2.getString("formname"));
					asBean1.setAmount(rs2.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs2.getString("securitytoken"));
					asBean1.setName(rs2.getString("s1c") + " " + rs2.getString("s1b") + " " + rs2.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				ResultSet rs3 = null;
				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, LastSubmission.getYesterdayDateString());
				stmt3.setString(2, LastSubmission.getTodayDateString());
				stmt3.setString(3, "Not Known");
				stmt3.setString(4, "Completed");
				stmt3.setString(5, asBean.getPaymenturn());
				rs3 = stmt3.executeQuery();
				while (rs3.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs3.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs3.getString("formname"));
					asBean1.setAmount(rs3.getInt("amount"));
					if(asBean1.getAmount()!=0)
					{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs3.getString("securitytoken"));
					asBean1.setName(rs3.getString("s1c") + " " + rs3.getString("s1b") + " " + rs3.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

					}ResultSet rs5 = null;
				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, LastSubmission.getYesterdayDateString());
				stmt5.setString(2, LastSubmission.getTodayDateString());
				stmt5.setString(3, "Not Known");
				stmt5.setString(4, "Completed");
				stmt5.setString(5, asBean.getPaymenturn());
				rs5 = stmt5.executeQuery();
				while (rs5.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs5.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs5.getString("formname"));
					asBean1.setAmount(rs5.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs5.getString("securitytoken"));
					asBean1.setName(rs5.getString("s1c") + " " + rs5.getString("s1b") + " " + rs5.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs6 = null;
				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, LastSubmission.getYesterdayDateString());
				stmt6.setString(2, LastSubmission.getTodayDateString());
				stmt6.setString(3, "Not Known");
				stmt6.setString(4, "Completed");
				stmt6.setString(5, asBean.getPaymenturn());
				rs6 = stmt6.executeQuery();
				while (rs6.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs6.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs6.getString("formname"));
					asBean1.setAmount(rs6.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs6.getString("securitytoken"));
					asBean1.setName(rs6.getString("s1c") + " " + rs6.getString("s1b") + " " + rs6.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}
				ResultSet rs7 = null;
				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, LastSubmission.getYesterdayDateString());
				stmt7.setString(2, LastSubmission.getTodayDateString());
				stmt7.setString(3, "Not Known");
				stmt7.setString(4, "Completed");
				stmt7.setString(5, asBean.getPaymenturn());
				rs7 = stmt7.executeQuery();
				while (rs7.next()) {
					asBean.setUrn(asBean.getUrn().replaceFirst("77", "88"));
					asBean.setPaymenturn("                    ");
					asBean1 = new AggregatedSubmissionBean();
					asBean1.setUrn(rs7.getString("submissionURN"));
					asBean1.setPaymenturn("                    ");
					asBean1.setType(rs7.getString("formname"));
					asBean1.setAmount(rs7.getInt("amount"));
						if(asBean1.getAmount()!=0)
						{
						count++;
						asBean1.setCount(count);
					}
					asBean1.setSecuritytoken(rs7.getString("securitytoken"));
					asBean1.setName(rs7.getString("s1c") + " " + rs7.getString("s1b") + " " + rs7.getString("s1a"));

					asBeansArrayList.add(asBean1);
					++cnt;

				}

				asBeansArrayList.add(asBean);
				++cnt;
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closePreparedStatement(stmt2);
				QueryBuilder.closePreparedStatement(stmt3);
				QueryBuilder.closeResultSet(rs3);

				QueryBuilder.closeResultSet(rs2);
				QueryBuilder.closeResultSet(rs1);
				QueryBuilder.closePreparedStatement(stmt5);
				QueryBuilder.closePreparedStatement(stmt6);
				QueryBuilder.closePreparedStatement(stmt7);
				QueryBuilder.closeResultSet(rs5);
				QueryBuilder.closeResultSet(rs6);
				QueryBuilder.closeResultSet(rs7);
			}
			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("LastSubmission.get24hrsubmission", e);
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closeResultSet(rsmain);
				QueryBuilder.closePreparedStatement(stmt_main);
				QueryBuilder.closePreparedStatement(stmt_main2);
				QueryBuilder.closePreparedStatement(stmt_main3);
				QueryBuilder.closePreparedStatement(stmt_main5);
				QueryBuilder.closePreparedStatement(stmt_main6);
				QueryBuilder.closePreparedStatement(stmt_main7);
				QueryBuilder.closeConnection(conn);
				return asBeansArrayList;
			} catch (SQLException sqle) {
				logger.error("LastSubmission.get24hrsubmission", sqle);
			}
		}
		return asBeansArrayList;
	}


	
	public static ArrayList<AggregatedSubmissionBean> get24hrstopuppayments() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String urn = "";
		DataSource datasource = null;

		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {
			logger.info("LastSubmission.get24hrstopuppayments - Retrieving top up payments for last 24hrs");
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();

			String thissql = sql_retrieve_24hrtopuppayments;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, LastSubmission.getYesterdayDateString());
			stmt.setString(2, LastSubmission.getTodayDateString());
			stmt.setString(3, "Success");

			rs = stmt.executeQuery();
			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("orderid"));
				asBean.setPaymenturn(rs.getString("Aggr_URN"));
				asBean.setType(rs.getString("referencenumber"));
				asBeansArrayList.add(asBean);

			}

			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("LastSubmission.get24hrstopuppayments", e);
		} finally {
			try {

				LastSubmission.closePreparedStatement(stmt);
				LastSubmission.closeResultSet(rs);
				LastSubmission.closeConnection(conn);

				return asBeansArrayList;
			} catch (SQLException sqle) {
				logger.error("LastSubmission.get24hrstopuppayments", sqle);
			}
		}
		return asBeansArrayList;
	}


	
	protected static void closeResultSet(ResultSet aRS) throws SQLException {

		if (null != aRS) {
			aRS.close();
		}
	}
	protected static void closeConnection(Connection aConn) throws SQLException {

		if (null != aConn) {
			aConn.close();
		}
	}

	/**
	 * Code to close a PreapredStatement
	 *
	 * @param aPS
	 * @throws SQLException
	 */
	protected static void closePreparedStatement(PreparedStatement aPS) throws SQLException {
		if (null != aPS) {
			aPS.close();
		}
	}

	public static String processjspdata() throws IOException, DocumentException {
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = LastSubmission
				.get10submission();
		DataSource datasource = null;
		HttpServletRequest request = null;
		//String text = "";
		@SuppressWarnings("deprecation")
		String text = "<strong>Submission date is:</strong> " + new Date().toGMTString() + "</br></br>";
		if(asBeansArrayList.size()==0)
		{
			text = text + "<br/><P><font color=red> <strong>There is some problem in database connectivity.</strong></font></P>";
		}
		for (AggregatedSubmissionBean asBean : asBeansArrayList) {
			String security = asBean.getSecuritytoken();
			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();

			ByteArrayOutputStream baos = null;

			text = text + "****************Type of Submission: " + type + "\t            Submission URN is "
					+ URN + "********** </br>";

		}
		return text.toString();


	}

	public static void deletegdprdata() {
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt5 = null;
		PreparedStatement stmt6 = null;
		PreparedStatement stmt7 = null;
		ResultSet rs = null;
		Connection conn = null;
		String urn = "";

		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getConnection();
			String thissql = gdprqry1;
			stmt1 = conn.prepareStatement(gdprqry1);
			stmt2 = conn.prepareStatement(gdprqry2);
			stmt3 = conn.prepareStatement(gdprqry3);
			stmt5 = conn.prepareStatement(gdprqry5);
			stmt6 = conn.prepareStatement(gdprqry6);
			stmt7 = conn.prepareStatement(gdprqry7);
			stmt1.executeQuery();
			stmt2.executeQuery();
			stmt3.executeQuery();
			stmt5.executeQuery();
			stmt6.executeQuery();
			stmt7.executeQuery();
		} catch (Exception e) {
			logger.error("LastSubmission.deletegdprdata", e);
		} finally {
			try {
				closeResultSet((ResultSet) rs);
				closePreparedStatement(stmt1);
				closePreparedStatement(stmt2);
				closePreparedStatement(stmt3);
				closePreparedStatement(stmt5);
				closePreparedStatement(stmt6);
				closePreparedStatement(stmt7);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("LastSubmission.deletegdprdata", sqle);
			}

		}

	}

	public static String get24hrsubmissions() throws IOException, DocumentException {
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = LastSubmission.get24hrsubmission();
		ArrayList<AggregatedSubmissionBean> asBeansArraytopup = LastSubmission.get24hrstopuppayments();
		//String text = "";
		@SuppressWarnings("deprecation")

		String text = "Date " + LastSubmission.getYesterdayDate() + ".\n Number of Online Submissions   " + asBeansArrayList.size() + ".\n Number of Aggregated Payments (Top-Up Payments)   " + asBeansArraytopup.size() + ". \n\n";
		if(asBeansArrayList.size()==0)
		{
			text = text + "\n There is some problem in database connectivity or there are no submissions made in the last 24hrs.\n";
		}
		text = text + "\n Online Submissions \n\n";
		text = text + "Submission URN \t\t \t Aggregated Payment URN  \t\t \t  Appellant Name \n\n";
		for (AggregatedSubmissionBean asBean : asBeansArrayList) {
			String security = asBean.getSecuritytoken();
			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();
            if(paymentURN==null)
            {
				paymentURN = "                               ";
            }
            else
            {
				paymentURN = "    " + paymentURN + "       ";
			}
			ByteArrayOutputStream baos = null;

			text = text + URN + "\t\t\t\t \t " + paymentURN + "\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + asBean.getName() + "\n";


			
		}
		text = text + "\n\n\n Aggregated Top-Up Payments\n\n";
		text = text + "Payment Reference \t\t\t\t\t         Aggregated URN\n\n";
		for (AggregatedSubmissionBean asBean : asBeansArraytopup) {

			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();
            if(paymentURN==null)
            {
				paymentURN = "                               ";
            }
            else
            {
				paymentURN = "    " + paymentURN + "       ";
			}
			ByteArrayOutputStream baos = null;


			text = text + type + "\t\t \t\t     " + paymentURN + "\n";

		}
		return text.toString();


	}


}