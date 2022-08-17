/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package com.MOJICT.IACFee.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.IAFT3Bean;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryBuilder3.
 * 
 * @author WEBTEAM4
 */
public class QueryBuilder3 extends GenericQueryBuilder implements QueryBuilder3Properties {

	/** log4j logging solution. */
	static Logger logger = Logger.getLogger(QueryBuilder3.class);

	/**
	 * Retrieve.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	@SuppressWarnings("deprecation")
	public static IAFT3Bean retrieve(IAFT3Bean frm, String action, DataSource datasource, String security_token,
                                     HttpServletRequest req) {
		IAFT3Bean bean = new IAFT3Bean();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
				
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			
			String thissql = sql_retrieve1_1;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, security_token);
			rs = stmt.executeQuery();

			if (rs.next()) {

				bean.setAppeal_type(rs.getString("hearing_type"));
				bean.setQa_sponsor(rs.getString(3));
				bean.setQa_rep(rs.getString(4));
				bean.setQa_witness(rs.getString(5));
				bean.setQb_lsc(rs.getString(6));
				bean.setQb_LAR(rs.getString(7));
				bean.setFamily_member(rs.getString(8));
				bean.setName1(rs.getString(9));
				bean.setRelationship1(rs.getString(10));
				bean.setPrn1(rs.getString(11));
				bean.setName2(rs.getString(12));
				bean.setRelationship2(rs.getString(13));
				bean.setPrn2(rs.getString(14));
				bean.setName3(rs.getString(15));
				bean.setRelationship3(rs.getString(16));
				bean.setPrn3(rs.getString(17));
				bean.setName4(rs.getString(18));
				bean.setRelationship4(rs.getString(19));
				bean.setPrn4(rs.getString(20));
				bean.setS1a(rs.getString(21));
				bean.setS1b(rs.getString(22));
				bean.setS1c(rs.getString(23));
				if (rs.getDate(24) != null) {
					bean.setS1d_dob_day(rs.getDate(24).getDate());
					bean.setS1d_dob_month(rs.getDate(24).getMonth() + 1);
					bean.setS1d_dob_year(1900 + rs.getDate(24).getYear());
				}
				bean.setS1e(rs.getString(25));
				bean.setS1f_addr1(rs.getString(26));
				bean.setS1f_addr2(rs.getString(27));
				bean.setS1f_addr3(rs.getString(28));
				bean.setS1f_addr4(rs.getString(29));
				bean.setS1f_postcode(rs.getString(30));
				bean.setS1g(rs.getString(31));
				bean.setS1h(rs.getString(32));
				bean.setS1i_yourself(rs.getString(33));
				bean.setS1i_witness(rs.getString(34));
				bean.setS1i_representative(rs.getString(35));
				bean.setS1j(rs.getString(36));
				bean.setS1j_who(rs.getString(37));
				bean.setS1j_language(rs.getString(38));
				bean.setS1j_dialect(rs.getString(39));
				bean.setS1k(rs.getString(40));
				bean.setS1l(rs.getString(41));
				bean.setS1m(rs.getString(42));
				if (rs.getString(42) != null) {
					bean.setS1m_hour(rs.getString(42).substring(0, 2));
					bean.setS1m_minutes(rs.getString(42).substring(3, 5));
					bean.setS1m_ampm(rs.getString(42).substring(6));
				}
				logger.debug(bean.getS1m_hour() + "" + bean.getS1m_minutes());
				if (rs.getDate(43) != null) {
					bean.setS1n_removal_day(rs.getDate(43).getDate());
					bean.setS1n_removal_month(rs.getDate(43).getMonth() + 1);
					bean.setS1n_removal_year(1900 + rs.getDate(43).getYear());
				}

				bean.setS1o(rs.getString(44));
				if (rs.getDate(45) != null) {
					bean.setS1p_sentence_day(rs.getDate(45).getDate());
					bean.setS1p_sentence_month(rs.getDate(45).getMonth() + 1);
					bean.setS1p_sentence_year(1900 + rs.getDate(45).getYear());
				}

				bean.setS1q(rs.getString(46));
				bean.setS2a(rs.getString(47));
				bean.setS2b(rs.getString(48));
				bean.setS2c(rs.getString(49));
				bean.setS2d(rs.getString(50));

				bean.setS2d_post(rs.getString(50));
				bean.setS2d_fax(rs.getString(51));
				bean.setS2d_courier(rs.getString(52));
				bean.setS2d_other(rs.getString(53));
				if (rs.getDate(54) != null) {
					bean.setS2e_service_day(rs.getDate(54).getDate());
					bean.setS2e_service_month(rs.getDate(54).getMonth() + 1);
					bean.setS2e_service_year(1900 + rs.getDate(54).getYear());
				}

				bean.setS2f(rs.getString(55));
				logger.debug("The other date is" + bean.getS2f());
				if (rs.getDate(55) != null) {
					bean.setS2g_service_day(rs.getDate(55).getDate());
					bean.setS2g_service_month(rs.getDate(55).getMonth() + 1);
					bean.setS2g_service_year(1900 + rs.getDate(55).getYear());
				}
				
			
				logger.debug("Date is" + bean.getS2g_service_day());

				bean.setS3a(rs.getString(56));
				bean.setS3b(rs.getString(57));
				bean.setS3c(rs.getString(58));
				bean.setS3d_1(rs.getString(59));

				bean = gets3d_2(bean, security_token);
				bean = getS3d_3(bean, security_token);
				bean = getS3d_4(bean, security_token);
				bean = getS3d_5(bean, security_token);
				bean = getS3d_6(bean, security_token);
				bean = getS3d_7(bean, security_token);
				bean = getS3d_8(bean, security_token);

				bean = getS3Additional(bean, security_token);

				bean.setS3e(rs.getString(68));

				if (rs.getDate(69) != null) {
					bean.setS3e_date1_day(rs.getDate(69).getDate());
					bean.setS3e_date1_month(rs.getDate(69).getMonth() + 1);
					bean.setS3e_date1_year(1900 + rs.getDate(69).getYear());

				}

				logger.debug(bean.getS3e_date1_year());
				bean.setS3e_appealno1(rs.getString(70));
				if (rs.getDate(71) != null) {
					bean.setS3e_date2_day(rs.getDate(71).getDate());
					bean.setS3e_date2_month(rs.getDate(71).getMonth() + 1);
					bean.setS3e_date2_year(1900 + rs.getDate(71).getYear());
				}

				bean.setS3e_appealno2(rs.getString(72));
				if (rs.getDate(73) != null) {
					bean.setS3e_date3_day(rs.getDate(73).getDate());
					bean.setS3e_date3_month(rs.getDate(73).getMonth() + 1);
					bean.setS3e_date3_year(1900 + rs.getDate(73).getYear());
				}

				bean.setS3e_appealno3(rs.getString(74));
				bean.setS3f(rs.getString(75));
				bean.setS4_signature(rs.getString(76));
				if (rs.getDate(77) != null) {
					bean.setS4_signature_day(rs.getDate(77).getDate());
					bean.setS4_signature_month(rs.getDate(77).getMonth() + 1);
					bean.setS4_signature_year(1900 + rs.getDate(77).getYear());
				}
				if (rs.getString(78) == null) {
					bean.setHave_rep("No");
				} else {
					bean.setHave_rep("Yes");
				}
				bean.setS5a(rs.getString(78));
				bean.setS5b(rs.getString(79));
				bean.setS5c_addr1(rs.getString(80));
				bean.setS5c_addr2(rs.getString(81));
				bean.setS5c_addr3(rs.getString(82));
				bean.setS5c_addr4(rs.getString(83));
				bean.setS5c_postcode(rs.getString(84));
				bean.setS5d(rs.getString(85));
				bean.setS5e(rs.getString(86));
				bean.setS5f(rs.getString(87));
				bean.setS5g(rs.getString(88));
				bean.setS5h(rs.getString(89));
				bean.setS5i(rs.getString(90));
				bean.setS5j(rs.getString(91));

				bean.setSecuritytoken(rs.getString("securitytoken"));
				bean.setS5b_other(rs.getString(93));
				bean.setRep_sign(rs.getString(94));
				bean.setS4_decalaration(rs.getString(96));
				if (rs.getDate(97) != null) {
					
					bean.setS2i_service_day(rs.getDate(97).getDate());
					bean.setS2i_service_month(rs.getDate(97).getMonth()+1);
					bean.setS2i_service_year(1900+rs.getDate(97).getYear());
				}
				bean.setS1f_email(rs.getString(98));
				req.getSession().setAttribute("token1", bean.getSecuritytoken());
				req.getSession().setAttribute("token", bean.getSecuritytoken());

				bean = loadMetaData(bean, bean.getSecuritytoken(),req);
				req.getSession().setAttribute("frmHeader", bean.getFormtitle());

			}
			logger.debug("Retrieving formtype from the bean : " + bean.getFormtype());
			return bean;
		}catch (Exception e) {
			logger.error("QueryBuilder3.retrieve", e);
			return bean;
		} finally {
			try {
				closeResultSet(rs);
				closePreparedStatement(stmt);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.retrieve", sqle);
			}
	
		}
	}

	/**
	 * Gets the s3d_8.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_8
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_8(IAFT3Bean bean, String securityToken) {
		
		logger.debug("Step 6");
		PreparedStatement stmt8 = null;
		ResultSet rs8 = null;
		Connection conn = null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

		String thissql8 = sql_retrieve1_8;
		stmt8 = conn.prepareStatement(thissql8);
		stmt8.setString(1, securityToken);
		rs8 = stmt8.executeQuery();
		rs8.next();
		bean.setS3d_8(rs8.getString("s3d_8"));
		}catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_8", e);
		}
		finally {
			try {
				closeResultSet(rs8);
				closePreparedStatement(stmt8);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_8", sqle);
			}
			}
		return bean;
	}

	/**
	 * Gets the s3d_7.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_7
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_7(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 6");
		PreparedStatement stmt7 = null;
		ResultSet rs7 = null;
		Connection conn = null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql7 = sql_retrieve1_7;
			stmt7 = conn.prepareStatement(thissql7);
			stmt7.setString(1, securityToken);
			rs7 = stmt7.executeQuery();
			rs7.next();
			bean.setS3d_7(rs7.getString("s3d_7"));
		}
		catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_7", e);
		}
		finally {
			try {
				closeResultSet(rs7);
				closePreparedStatement(stmt7);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_7", sqle);
			}
		}
		return bean;
	}

	/**
	 * Gets the s3d_6.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_6
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_6(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 6");
		PreparedStatement stmt6 = null;
		ResultSet rs6 = null;
		Connection conn = null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql6 = sql_retrieve1_6;
			stmt6 = conn.prepareStatement(thissql6);
			stmt6.setString(1, securityToken);
			rs6 = stmt6.executeQuery();
			rs6.next();
			bean.setS3d_6(rs6.getString("s3d_6"));
		} catch(Exception r)
		{
			logger.error("QueryBuilder3.getS3d_6", r);
		}
		finally {
			try {
				closeResultSet(rs6);
				closePreparedStatement(stmt6);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_6", sqle);
			}
		}
		return bean;
	}

	/**
	 * Gets the s3d_5.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_5
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_5(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 5");
		PreparedStatement stmt5 = null;
		ResultSet rs5 = null;
		Connection conn=null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql5 = sql_retrieve1_5;
			stmt5 = conn.prepareStatement(thissql5);
			stmt5.setString(1, securityToken);
			rs5 = stmt5.executeQuery();
			rs5.next();
			bean.setS3d_5(rs5.getString("s3d_5"));
		}catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_5", e);
		} 
		finally {
			try {
				closeResultSet(rs5);
				closePreparedStatement(stmt5);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_5", sqle);
			}
		}
		return bean;
	}

	/**
	 * Gets the s3d_4.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_4
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_4(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 4");
		PreparedStatement stmt4 = null;
		ResultSet rs4 = null;
		Connection conn=null;
		try {DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql4 = sql_retrieve1_4;
			stmt4 = conn.prepareStatement(thissql4);
			stmt4.setString(1, securityToken);
			rs4 = stmt4.executeQuery();
			rs4.next();
			bean.setS3d_4(rs4.getString("s3d_4"));
		} catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_4", e);
		}finally {
			try {
				closeResultSet(rs4);
				closePreparedStatement(stmt4);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_4", sqle);
			}
		}
		return bean;
	}

	/**
	 * Gets the s3d_3.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_3
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3d_3(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 3");
		PreparedStatement stmt3 = null;
		ResultSet rs3 = null;
		Connection conn=null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql3 = sql_retrieve1_33;
			stmt3 = conn.prepareStatement(thissql3);
			stmt3.setString(1, securityToken);
			rs3 = stmt3.executeQuery();
			rs3.next();
			bean.setS3d_3(rs3.getString("s3d_3"));
		}
		catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_3", e);
			return bean;
		}
		finally {
			try {
				closeResultSet(rs3);
				closePreparedStatement(stmt3);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_3", sqle);
			}
		}
		return bean;
	}

	/**
	 * Retrieve s3d_2.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3d_2
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean gets3d_2(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 2");
		logger.debug("cmg here");

		PreparedStatement stmt2 = null;
		ResultSet rs2 = null;
		Connection conn=null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql2 = sql_retrieve1_2;
			stmt2 = conn.prepareStatement(thissql2);
			stmt2.setString(1, securityToken);
			
			rs2 = stmt2.executeQuery();
			rs2.next();
			bean.setS3d_2(rs2.getString("s3d_2"));
		}catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3d_2", e);
			return bean;
		}
		finally {
			try {
				closeResultSet(rs2);
				closePreparedStatement(stmt2);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3d_2", sqle);
			}}
		return bean;

	}

	/**
	 * Get s3 additional parameter.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the s3 additional
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean getS3Additional(IAFT3Bean bean, String securityToken) {
		logger.debug("Step 9");
		PreparedStatement stmt9 = null;
		ResultSet rs9 = null;
		Connection conn=null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql9 = sql_retrieve1_9;
			stmt9 = conn.prepareStatement(thissql9);
			stmt9.setString(1, securityToken);
			rs9 = stmt9.executeQuery();
			rs9.next();
			bean.setS3d_additional(rs9.getString("s3d_additional"));
		}catch(Exception e)
		{
			logger.error("QueryBuilder3.getS3Additional", e);
		} finally {
			try {
				closeResultSet(rs9);
				closePreparedStatement(stmt9);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getS3Additional", sqle);
			}
		}
		return bean;
	}

	/**
	 * Load Meta data for bean.
	 * 
	 * @param bean
	 *            the bean
	 * @param securityToken
	 *            the security token
	 * @return the iAF t3 bean
	 * @throws SQLException
	 *             the sQL exception
	 */
	private static IAFT3Bean loadMetaData(IAFT3Bean bean, String securityToken,HttpServletRequest req) {
		logger.debug("Step 10");
		PreparedStatement stmt10 = null;
		ResultSet rs10 = null;
		Connection conn=null;
		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql10 = sql_retrieve_urn;
			stmt10 = conn.prepareStatement(thissql10);
			stmt10.setString(1, securityToken);
			rs10 = stmt10.executeQuery();
			rs10.next();
			bean.setSubmissionURN(rs10.getString("submissionURN"));

			bean.setPaymentURN(rs10.getString("paymentURN"));
			bean.setAggregatedpaymentURN(rs10.getString("AggregatedURN"));
			bean.setFormtype(rs10.getString("formname"));
			bean.setPaymentvalue(rs10.getInt("amount"));
            if(bean.getAggregatedpaymentURN()!=null)
			{
			req.getSession().setAttribute("aggrtoken",bean.getAggregatedpaymentURN());
			}
			else
			{
			req.getSession().setAttribute("aggrtoken",null);
			}
			bean.setFormtitle(rs10.getString("formtitle"));
			return bean;
			
		} catch(Exception e)
		{
			logger.error("QueryBuilder3.loadMetaData", e);
			return bean;
		}finally {
			try {
				closeResultSet(rs10);
				closePreparedStatement(stmt10);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.loadMetaData", sqle);
			}
		}
	}

	/**
	 * IAF t3_1.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_1(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		IAFT3Bean bean = new IAFT3Bean();
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmturn = null;
		PreparedStatement stmturn_get = null;
		ResultSet rs = null;
		if (action.equals("retrieve")) {
			logger.debug("Retrieving");
			return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
		}

		else if (action == "save") {

			try {
				String submission_urn = "";
				String urnsql = sql_urn_update;
				String urnsql1 = sql_urn_get;
				String thissql1 = sql_save_urn;
				String thissql11 = sql_update1_urn;
				String thissql111 = sql_update1_urn11;
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
				String thissql;
				String save;
				if (req.getSession().getAttribute("token1") != null) {

					thissql = sql_update1_1;
					save = "update";

				} else {
					thissql = sql_save1_1;
					save = "save";
				}
				logger.debug(thissql);

				stmt = conn.prepareStatement(thissql);
				stmturn = conn.prepareStatement(urnsql);
				stmturn_get = conn.prepareStatement(urnsql1);
				stmt.setString(1, frm.getAppeal_type());
				stmt.setString(2, frm.getQa_sponsor());
				stmt.setString(3, frm.getQa_rep());
				stmt.setString(4, frm.getQa_witness());
				stmt.setString(5, frm.getQb_lsc());
				stmt.setString(6, frm.getQb_LAR());
				stmt.setString(7, frm.getFamily_member());
				stmt.setString(8, frm.getName1());
				stmt.setString(9, frm.getRelationship1());
				stmt.setString(10, frm.getPrn1());
				stmt.setString(11, frm.getName2());
				stmt.setString(12, frm.getRelationship2());
				stmt.setString(13, frm.getPrn2());
				stmt.setString(14, frm.getName3());
				stmt.setString(15, frm.getRelationship3());
				stmt.setString(16, frm.getPrn3());
				stmt.setString(17, frm.getName4());
				stmt.setString(18, frm.getRelationship4());
				stmt.setString(19, frm.getPrn4());
				stmt.setTimestamp(20,  dateconverter.convertdate());
				stmt.setString(21, security_token);
				
				rs = stmturn_get.executeQuery();
				rs.next();
				submission_urn = rs.getString("Id");
				logger.debug("" + submission_urn);

				if (!save.equals("update")) {
					stmturn.setString(1, SecurityToken.generateSubmissionURN(submission_urn) + "");
					stmturn.executeUpdate();

					if (frm.getQb_lsc().equals("No")) {
						if (req.getSession().getAttribute("frmHeader") != null) {
							if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
								bean.setSubmissionURN("44" + "88" + SecurityToken.generateSubmissionURN(submission_urn));
							}
						} else {
							bean.setSubmissionURN("44" + "88" + SecurityToken.generateSubmissionURN(submission_urn));

						}
						bean.setPaymentURN(bean.getSubmissionURN());

					}

					if (req.getSession().getAttribute("aggrtoken") != null) {
						logger.debug("Aggregated IAFT3");
						bean.setSubmissionURN("44" + "77" + SecurityToken.generateSubmissionURN(submission_urn));
						bean.setPaymentURN(bean.getSubmissionURN());

					}
					if (!frm.getQb_lsc().equals("No")) {
						if (true) {
							bean.setSubmissionURN("44" + "99" + SecurityToken.generateSubmissionURN(submission_urn));
						}
						bean.setPaymentURN(bean.getSubmissionURN());

					}
				} else {

					IAFT3Bean iaf = (IAFT3Bean) QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
					if (frm.getQb_lsc().equals("No")) {
					
						bean.setSubmissionURN("44" + "88" + iaf.getSubmissionURN().substring(4));

						bean.setPaymentURN(bean.getSubmissionURN());

					}
					if (req.getSession().getAttribute("aggrtoken") != null) {

						bean.setSubmissionURN("44" + "77" + iaf.getSubmissionURN().substring(4));

						bean.setPaymentURN(bean.getSubmissionURN());

					}
					if (!frm.getQb_lsc().equals("No")) {
						if (true) {
							bean.setSubmissionURN("44" + "99" + iaf.getSubmissionURN().substring(4));
						}
						bean.setPaymentURN(bean.getSubmissionURN());

					}

				}
				if (save.equals("update")) {
					req.getSession().setAttribute("token", req.getSession().getAttribute("token1"));
					stmt.executeUpdate();
					stmt1 = conn.prepareStatement(thissql111);
					

					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(1, req.getSession().getAttribute("aggrtoken").toString());
					} else {
						stmt1.setString(1, bean.getAggregatedpaymentURN());
					}
					if (frm.getAppeal_type().equals("Oral")) {
						if (frm.getQb_lsc().equals("No")) {
							stmt1.setInt(2, 140);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						} else {
							stmt1.setInt(2, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No")) {
							stmt1.setInt(2, 80);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 80;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 80);
							}
						} else {
							stmt1.setInt(2, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					}
					stmt1.setString(3, bean.getSubmissionURN());
					stmt1.setString(4, bean.getPaymentURN());
					stmt1.setString(5, security_token);
					stmt1.executeUpdate();
					return QueryBuilder3.retrieve(frm, action, datasource, req.getSession().getAttribute("token1")
							.toString(), req);
				} else {

					stmt.execute();
					
					stmt1 = conn.prepareStatement(thissql1);
					stmt1.setString(1, security_token);
					stmt1.setString(2, bean.getSubmissionURN());
					stmt1.setString(3, bean.getPaymentURN());
					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(4, req.getSession().getAttribute("aggrtoken").toString());
					} else {
						stmt1.setString(4, bean.getAggregatedpaymentURN());
					}
					stmt1.setString(5, "IAFT3");
					if (frm.getAppeal_type().equals("Oral")) {
						if (frm.getQb_lsc().equals("No")) {
							stmt1.setInt(6, 140);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						} else {
							stmt1.setInt(6, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No")) {
							stmt1.setInt(6, 80);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 80;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 80);
							}
						} else {
							stmt1.setInt(6, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}

					}
					logger.debug("Its coming here in IAFT3 stmt execute");
					stmt1.setString(7, "IAFT3");// form header					
					stmt1.execute();
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_1", e);
				return bean;
			} finally {
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					
					closePreparedStatement(stmt1);
					closePreparedStatement(stmturn);
					closePreparedStatement(stmturn_get);
					//QueryBuilder.closePreparedStatement(stmt);
					closeConnection(conn);
					
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_1", sqle);
				}
				try{
				closeConnection(conn);
				}catch(Exception e)
				{
					logger.error("QueryBuilder3.IAFT3_1", e);
				}
			}

			return bean;
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_2.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_2(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_1;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_2", e);
				return bean;
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_2", sqle);
				}
		}
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save1_2;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS1a());
				stmt.setString(2, frm.getS1b());
				stmt.setString(3, frm.getS1c());
				stmt.setDate(4,
						dateconverter.convertdate(frm.getS1d_dob_day(), frm.getS1d_dob_month(), frm.getS1d_dob_year()));
				stmt.setString(5, frm.getS1e());
				stmt.setString(6, frm.getS1f_addr1());
				stmt.setString(7, frm.getS1f_addr2());
				stmt.setString(8, frm.getS1f_addr3());
				stmt.setString(9, frm.getS1f_addr4());
				stmt.setString(10, frm.getS1f_postcode());
				stmt.setString(11, frm.getS1g());
				stmt.setString(12, frm.getS1h());

				stmt.setString(13, frm.getS1i_yourself());
				stmt.setString(14, frm.getS1i_witness());
				stmt.setString(15, frm.getS1i_representative());
				stmt.setString(16, frm.getS1j());
				// j yes no
				stmt.setString(17, frm.getS1j_who());
				stmt.setString(18, frm.getS1j_language());
				stmt.setString(19, frm.getS1j_dialect());
				stmt.setString(20, frm.getS1k());
				stmt.setString(21, frm.getS1l());
				frm.setS1m(frm.getS1m_hour() + ":" + frm.getS1m_minutes() + "-" + frm.getS1m_ampm());
				stmt.setString(22, frm.getS1m());
				if (frm.getS1n_removal_day() != 0) {
					stmt.setDate(
							23,
							dateconverter.convertdate(frm.getS1n_removal_day(), frm.getS1n_removal_month(),
									frm.getS1n_removal_year()));

				}

				else {
					stmt.setDate(23, null);
				}
				stmt.setString(24, frm.getS1o());

				if (frm.getS1p_sentence_day() != 0) {
					stmt.setDate(
							25,
							dateconverter.convertdate(frm.getS1p_sentence_day(), frm.getS1p_sentence_month(),
									frm.getS1p_sentence_year()));
				} else {
					stmt.setDate(25, null);
				}
				stmt.setString(26, frm.getS1q());
				stmt.setString(27, frm.getS1f_email());
				stmt.setString(28, security_token);

				logger.debug("IAFT3 Step 8");
				stmt.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_2", e);
				return bean;
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_2", sqle);
				}
		}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_3.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_3(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		IAFT3Bean bean_amount = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_3", e);
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					//QueryBuilder.closePreparedStatement(stmt1);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_3", sqle);
				}
		}
			return bean;
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql = sql_save1_3;
				String thissql11 = sql_update3_2urn;
				stmt = conn.prepareStatement(thissql);
				stmt1 = conn.prepareStatement(thissql11);
				stmt.setString(1, frm.getS2a());
				stmt.setString(2, frm.getS2b());
				stmt.setString(3, frm.getS2c());

				// stmt.setDate(4,
				// dateconverter.convertdate(frm.getS1d_dob_day(),
				// frm.getS1d_dob_month(), frm.getS1d_dob_year()));
				stmt.setString(4, frm.getS2d());
				stmt.setString(5, frm.getS2d_other());
				logger.debug(frm.getS2e_service_day());
				stmt.setDate(
						6,
						dateconverter.convertdate(frm.getS2e_service_day(), frm.getS2e_service_month(),
								frm.getS2e_service_year()));
				stmt.setDate(
						7,
						dateconverter.convertdate(frm.getS2g_service_day(), frm.getS2g_service_month(),
								frm.getS2g_service_year()));
				stmt.setDate(
						8,
						dateconverter.convertdate(frm.getS2i_service_day(), frm.getS2i_service_month(),
								frm.getS2i_service_year()));
				frm.setS2e(dateconverter.convertdate(frm.getS2e_service_day(), frm.getS2e_service_month(),
						frm.getS2e_service_year()));
				frm.setS2g(dateconverter.convertdate(frm.getS2g_service_day(), frm.getS2g_service_month(),
						frm.getS2g_service_year()));
				frm.setS2i(dateconverter.convertdate(frm.getS2i_service_day(), frm.getS2i_service_month(),
						frm.getS2i_service_year()));
				
								
				stmt.setString(9, security_token);

				bean_amount = QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
				// stmt1.setString(5, "IAFT1");

				if (Helper.returnStringAmount_paper(frm.getS2e().toString()) == 0
						|| !bean_amount.getQb_lsc().equals("No") || bean_amount.getPaymentvalue() == 0) {
					frm.setSubmissionURN(bean_amount.getSubmissionURN().substring(0, 2) + "99"
							+ bean_amount.getSubmissionURN().substring(4));
					stmt1.setString(1, frm.getSubmissionURN());
					stmt1.setString(2, frm.getSubmissionURN());
					stmt1.setInt(3, 0);

					stmt1.setString(4, security_token);
					stmt1.executeUpdate();
				} else {
					if (bean_amount.getAppeal_type().equals("Oral") && bean_amount.getQb_lsc().equals("No")) {

						stmt1.setString(1, bean_amount.getSubmissionURN());
						stmt1.setString(2, bean_amount.getSubmissionURN());
						stmt1.setInt(3, Helper.returnStringAmount_oral(frm.getS2e().toString()));
						stmt1.setString(4, security_token);
						stmt1.executeUpdate();
					}
					if (bean_amount.getAppeal_type().equals("Paper") && bean_amount.getQb_lsc().equals("No")) {

						stmt1.setString(1, bean_amount.getSubmissionURN());
						stmt1.setString(2, bean_amount.getSubmissionURN());
						stmt1.setInt(3, Helper.returnStringAmount_paper(frm.getS2e().toString()));
						stmt1.setString(4, security_token);
						stmt1.executeUpdate();
					}

				}
				// else for amount 0 if LSC remission is entered.

				stmt.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_3", e);
				
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closePreparedStatement(stmt1);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_3", sqle);
				}
		}
			return bean;

		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_4.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_4(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_4", e);
				
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_4", sqle);
				}
		}
			return bean;
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save1_4;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS3a());
				stmt.setString(2, frm.getS3b());
				stmt.setString(3, frm.getS3c());
				stmt.setString(4, security_token);
				stmt.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_4", e);
				return bean;
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_4", sqle);
				}
		}

		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_5.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_5(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_5", e);
				
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_5", sqle);
				}
		}
			return bean;
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql1 = sql_save1_5_1;
				String thissql2 = sql_save1_5_2;
				String thissql3 = sql_save1_5_3;

				stmt1 = conn.prepareStatement(thissql1);
				stmt2 = conn.prepareStatement(thissql2);
				stmt3 = conn.prepareStatement(thissql3);

				stmt1.setString(1, frm.getS3d_1());
				stmt2.setString(1, frm.getS3d_2());
				stmt3.setString(1, frm.getS3d_3());

				stmt1.setString(2, security_token);
				stmt2.setString(2, security_token);
				stmt3.setString(2, security_token);

				stmt1.executeUpdate();
				stmt2.executeUpdate();
				stmt3.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_5", e);
				
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt1);
					closePreparedStatement(stmt2);
					closePreparedStatement(stmt3);
					
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_5", sqle);
				}
		}
			return bean;
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_6.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_6(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt4 = null;
		PreparedStatement stmt5 = null;
		PreparedStatement stmt6 = null;
		PreparedStatement stmt7 = null;

		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_6", e);
				
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_6", sqle);
				}
		}
			return bean;
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql4 = sql_save1_5_4;
				String thissql5 = sql_save1_5_5;
				String thissql6 = sql_save1_5_6;
				String thissql7 = sql_save1_5_7;
				stmt4 = conn.prepareStatement(thissql4);
				stmt5 = conn.prepareStatement(thissql5);
				stmt6 = conn.prepareStatement(thissql6);
				stmt7 = conn.prepareStatement(thissql7);
				stmt4.setString(1, frm.getS3d_4());
				stmt5.setString(1, frm.getS3d_5());
				stmt6.setString(1, frm.getS3d_6());
				stmt7.setString(1, frm.getS3d_7());

				stmt4.setString(2, security_token);
				stmt5.setString(2, security_token);
				stmt6.setString(2, security_token);
				stmt7.setString(2, security_token);

				logger.debug("IAFT3 Step 4");
				stmt4.executeUpdate();
				stmt5.executeUpdate();
				stmt6.executeUpdate();
				stmt7.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_6", e);
				
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt4);
					closePreparedStatement(stmt5);

					closePreparedStatement(stmt6);
					closePreparedStatement(stmt7);

					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_6", sqle);
				}
			}
			return bean;

		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_7.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_7(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt8 = null;
		PreparedStatement stmt9 = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();

				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_7", e);
				
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_7", sqle);
				}
		}
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
				String thissql8 = sql_save1_5_8;
				String thissql9 = sql_save1_5_9;
				stmt8 = conn.prepareStatement(thissql8);
				stmt9 = conn.prepareStatement(thissql9);
				stmt8.setString(1, frm.getS3d_8());
				stmt9.setString(1, frm.getS3d_additional());
				stmt8.setString(2, security_token);
				stmt9.setString(2, security_token);
				stmt8.executeUpdate();
				stmt9.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_7", e);
				return bean;
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closePreparedStatement(stmt8);
					closePreparedStatement(stmt9);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_7", sqle);
				}
		}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_8.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_8(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();
								conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_8", e);
				
			}finally {
				
					try {
						closeResultSet(rs);
						closePreparedStatement(stmt);
						closeConnection(conn);
					} catch (SQLException sqle) {
						logger.error("QueryBuilder3.IAFT3_8", sqle);
					}
			}
			
			
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save1_8;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS3e());
				if (frm.getS3e_date1_day() != 0) {
					stmt.setDate(
							2,
							dateconverter.convertdate(frm.getS3e_date1_day(), frm.getS3e_date1_month(),
									frm.getS3e_date1_year()));
					stmt.setString(3, frm.getS3e_appealno1());
				} else {
					stmt.setDate(2, null);
					stmt.setString(3, frm.getS3e_appealno1());

				}
				if (frm.getS3e_date2_day() != 0) {
					stmt.setDate(
							4,
							dateconverter.convertdate(frm.getS3e_date2_day(), frm.getS3e_date2_month(),
									frm.getS3e_date2_year()));
					stmt.setString(5, frm.getS3e_appealno2());
				} else {
					stmt.setDate(4, null);
					stmt.setString(5, frm.getS3e_appealno2());

				}
				if (frm.getS3e_date3_day() != 0) {
					stmt.setDate(
							6,
							dateconverter.convertdate(frm.getS3e_date3_day(), frm.getS3e_date3_month(),
									frm.getS3e_date3_year()));
					stmt.setString(7, frm.getS3e_appealno3());
				} else {
					stmt.setDate(6, null);
					stmt.setString(7, frm.getS3e_appealno3());

				}
				stmt.setString(8, security_token);
				stmt.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_8", e);
				return bean;
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_8", sqle);
				}
		}
			
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_9.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT3_9(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT3Bean bean = new IAFT3Bean();
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_9", e);
				
			}finally {
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_9", sqle);
				}
			}
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save1_9;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS4_signature());
				if (frm.getS4_signature_day() != 0) {
					stmt.setDate(
							2,
							dateconverter.convertdate(frm.getS4_signature_day(), frm.getS4_signature_month(),
									frm.getS4_signature_year()));
				} else {
					stmt.setDate(2, null);
				}
				stmt.setString(3, frm.getS4_decalaration());
				stmt.setString(4, security_token);
				stmt.executeUpdate();
				return QueryBuilder3.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_9", e);
				return bean;
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_9", sqle);
				}
		
			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t3_10.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @return the string
	 */
	public static String IAFT3_10(IAFT3Bean frm, String action, DataSource datasource, String security_token) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (action == "retrieve") {
			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve1_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_10", e);
				return "failure";
			}finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_10", sqle);
				}
		}
		}

		if (action == "save") {

			try {
								DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save1_10;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS5a());
				stmt.setString(2, frm.getS5b());
				stmt.setString(3, frm.getS5c_addr1());
				stmt.setString(4, frm.getS5c_addr2());
				stmt.setString(5, frm.getS5c_addr3());
				stmt.setString(6, frm.getS5c_addr4());
				stmt.setString(7, frm.getS5c_postcode());
				stmt.setString(8, frm.getS5d());
				stmt.setString(9, frm.getS5e());
				stmt.setString(10, frm.getS5f());
				stmt.setString(11, frm.getS5g());
				stmt.setString(12, frm.getS5h());
				stmt.setString(13, frm.getS5i());
				stmt.setString(14, frm.getS5j());
				stmt.setString(15, frm.getS5b_other());
				stmt.setString(16, frm.getRep_sign());
				stmt.setString(17, frm.getS5_rep_agreed());

				stmt.setString(18, security_token);
				logger.debug("IAFT3 Step 10");
				stmt.executeUpdate();
			} catch (Exception e) {
				logger.error("QueryBuilder3.IAFT3_10", e);
				return "failure";
			} finally {
				
				try {
					closeResultSet(rs);
					closePreparedStatement(stmt);
					closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT3_10", sqle);
				}
		
			}
			return "success";
		} else {
			return "success";
		}
	}

	/**
	 * Gets the aggregatedsubmission.
	 * 
	 * @param datasource
	 *            the datasource
	 * @param urn
	 *            the urn
	 * @return the aggregatedsubmission
	 */
	public static ResultSet getAggregatedsubmission(DataSource datasource, String urn) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
							DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_retrieve_aggrurn;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, urn);

			rs = stmt.executeQuery();
			return rs;
		} catch (Exception e) {
			logger.error("QueryBuilder3.getAggregatedsubmission", e);
			return rs;
		}finally {
			
			try {
				closeResultSet(rs);
				closePreparedStatement(stmt);
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder3.getAggregatedsubmission", sqle);
			}
	}
	}

	/**
	 * IAF t_new.
	 * 
	 * @param frm
	 *            the frm
	 * @param action
	 *            the action
	 * @param datasource
	 *            the datasource
	 * @param security_token
	 *            the security_token
	 * @param req
	 *            the req
	 * @return the iAF t3 bean
	 */
	public static IAFT3Bean IAFT_new(IAFT3Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		IAFT3Bean bean = new IAFT3Bean();
		Connection conn = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;

		try {
			String thissql1 = sql_update_urn;
							DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
			stmt1 = conn.prepareStatement(thissql1);
			if (req.getSession().getAttribute("aggrtoken") != null) {
				logger.debug(req.getSession().getAttribute("aggrtoken"));
				stmt1.setString(1, req.getSession().getAttribute("aggrtoken").toString());
			} else {
				bean.setAggregatedpaymentURN("77" + SecurityToken.generateAggregatedPaymentURN());
				stmt1.setString(1, bean.getAggregatedpaymentURN());
				req.getSession().setAttribute("aggrtoken", bean.getAggregatedpaymentURN());
				logger.debug(req.getSession().getAttribute("aggrtoken"));
			}
			stmt1.setString(2, security_token);
			stmt1.execute();
		} catch (Exception e) {
			logger.error("QueryBuilder3.IAFT_new", e);
			return bean;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT_new", sqle);
				}
				rs = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					logger.error("QueryBuilder3.IAFT_new", sqle);
				}
				conn = null;
			}
		}
		return bean;
	}
}
