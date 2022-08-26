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
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.AggregatedSubmissionBean;
import com.MOJICT.IACFee.Beans.IAFT1Bean;
import com.MOJICT.IACFee.Beans.IAFT2Bean;
import com.MOJICT.IACFee.Beans.IAFT3Bean;
import com.MOJICT.IACFee.Beans.IAFT5Bean;
import com.MOJICT.IACFee.Beans.IAFT6Bean;
import com.MOJICT.IACFee.Beans.IAFT7Bean;
import com.MOJICT.IACFee.Beans.IAFTBean;
import com.MOJICT.IACFee.Beans.IAFTBeanFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryBuilder.
 */
public class QueryBuilder extends GenericQueryBuilder implements QueryBuilder1Properties {
	
	/** log4j logging solution. */
	static Logger logger = Logger.getLogger(QueryBuilder.class);

	/**
	 * Populate the bean object from the retrieve method ResultSets.
	 * 
	 * @param bean
	 *            the bean
	 * @param req
	 *            the req
	 * @param security_token
	 *            the security_token
	 * @return the populated bean
	 * @throws SQLException
	 *             the sQL exception
	 */
	private IAFT1Bean populateIAFT1Bean(IAFT1Bean bean, HttpServletRequest req, String security_token, Connection conn)
			throws SQLException {
		PreparedStatement stmtR = null, stmt2R = null, stmt3R = null, stmt4R = null, stmt5R = null, stmt6R = null, stmt7R = null, stmt8R = null, stmt9R = null, stmt10R = null;
		ResultSet rsR = null, rs2R = null, rs3R = null, rs4R = null, rs5R = null, rs6R = null, rs7R = null, rs8R = null, rs9R = null, rs10R = null;
//		Connection conn = null;
		stmtR = conn.prepareStatement(sql_retrieve1_1);
		stmtR.setString(1, security_token);
		rsR = stmtR.executeQuery();
		if (rsR.next()) {
			bean.setAppeal_type(rsR.getString("hearing_type"));
			logger.debug("????????????"+rsR.getString("hearing_type"));
			bean.setQa_sponsor(rsR.getString(3));
			bean.setQa_rep(rsR.getString(4));
			bean.setQa_witness(rsR.getString(5));
			bean.setQb_lsc(rsR.getString(6));
			bean.setQb_LAR(rsR.getString(7));
			bean.setFamily_member(rsR.getString(8));
			bean.setName1(rsR.getString(9));
			bean.setRelationship1(rsR.getString(10));
			bean.setPrn1(rsR.getString(11));
			bean.setName2(rsR.getString(12));
			bean.setRelationship2(rsR.getString(13));
			bean.setPrn2(rsR.getString(14));
			bean.setName3(rsR.getString(15));
			bean.setRelationship3(rsR.getString(16));
			bean.setPrn3(rsR.getString(17));
			bean.setName4(rsR.getString(18));
			bean.setRelationship4(rsR.getString(19));
			bean.setPrn4(rsR.getString(20));
			bean.setS1a(rsR.getString(21));
			bean.setS1b(rsR.getString(22));
			bean.setS1c(rsR.getString(23));
			Date theDate;
			if (rsR.getDate(24) != null) {
				theDate = rsR.getDate(24);
				bean.setS1d_dob_day(getTheDay(theDate));
				bean.setS1d_dob_month(getTheMonth(theDate));
				bean.setS1d_dob_year(getTheYear(theDate));
			}
			bean.setS1e(rsR.getString(25));
			bean.setS1f_addr1(rsR.getString(26));
			bean.setS1f_addr2(rsR.getString(27));
			bean.setS1f_addr3(rsR.getString(28));
			bean.setS1f_addr4(rsR.getString(29));
			bean.setS1f_postcode(rsR.getString(30));
			bean.setS1g(rsR.getString(31));
			bean.setS1h(rsR.getString(32));
			bean.setS1i_yourself(rsR.getString(33));
			bean.setS1i_witness(rsR.getString(34));
			bean.setS1i_representative(rsR.getString(35));
			bean.setS1j(rsR.getString(36));
			bean.setS1j_who(rsR.getString(37));
			bean.setS1j_language(rsR.getString(38));
			bean.setS1j_dialect(rsR.getString(39));
			bean.setS1k(rsR.getString(40));
			bean.setS1l(rsR.getString(41));
			bean.setS1m(rsR.getString(42));
			if (rsR.getString(42) != null) {
				bean.setS1m_hour(rsR.getString(42).substring(0, 2));
				bean.setS1m_minutes(rsR.getString(42).substring(3, 5));
				bean.setS1m_ampm(rsR.getString(42).substring(6));
			}

			if (rsR.getDate(43) != null) {
				theDate = rsR.getDate(43);
				bean.setS1n_removal_day(getTheDay(theDate));
				bean.setS1n_removal_month(getTheMonth(theDate));
				bean.setS1n_removal_year(getTheYear(theDate));
			}

			bean.setS1o(rsR.getString(44));
			if (rsR.getDate(45) != null) {
				theDate = rsR.getDate(45);
				bean.setS1p_sentence_day(getTheDay(theDate));
				bean.setS1p_sentence_month(getTheMonth(theDate));
				bean.setS1p_sentence_year(getTheYear(theDate));
			}

			bean.setS1q(rsR.getString(46));
			bean.setS2a(rsR.getString(47));
			bean.setS2b(rsR.getString(48));
			bean.setS2c(rsR.getString(49));
			bean.setS2d(rsR.getString(50));

			bean.setS2d_post(rsR.getString(50));
			bean.setS2d_fax(rsR.getString(51));
			bean.setS2d_courier(rsR.getString(52));
			bean.setS2d_other(rsR.getString(53));
			if (rsR.getDate(54) != null) {
				theDate = rsR.getDate(54);
				bean.setS2e_service_day(getTheDay(theDate));
				bean.setS2e_service_month(getTheMonth(theDate));
				bean.setS2e_service_year(getTheYear(theDate));
			}

			bean.setS2f(rsR.getString(55));
			bean.setS3a(rsR.getString(56));
			bean.setS3b(rsR.getString(57));
			bean.setS3c(rsR.getString(58));
			bean.setS3d_1(rsR.getString(59));
			bean.setS3e(rsR.getString(68));

			if (rsR.getDate(69) != null) {
				theDate = rsR.getDate(69);
				bean.setS3e_date1_day(getTheDay(theDate));
				bean.setS3e_date1_month(getTheMonth(theDate));
				bean.setS3e_date1_year(getTheYear(theDate));
			}


			bean.setS3e_appealno1(rsR.getString(70));
			if (rsR.getDate(71) != null) {
				theDate = rsR.getDate(71);
				bean.setS3e_date2_day(getTheDay(theDate));
				bean.setS3e_date2_month(getTheMonth(theDate));
				bean.setS3e_date2_year(getTheYear(theDate));
			}

			bean.setS3e_appealno2(rsR.getString(72));
			if (rsR.getDate(73) != null) {
				theDate = rsR.getDate(73);
				bean.setS3e_date3_day(getTheDay(theDate));
				bean.setS3e_date3_month(getTheMonth(theDate));
				bean.setS3e_date3_year(getTheYear(theDate));
			}

			bean.setS3e_appealno3(rsR.getString(74));
			bean.setS3f(rsR.getString(75));
			bean.setS4_signature(rsR.getString(76));
			if (rsR.getDate(77) != null) {
				theDate = rsR.getDate(77);
				bean.setS4_signature_day(getTheDay(theDate));
				bean.setS4_signature_month(getTheMonth(theDate));
				bean.setS4_signature_year(getTheYear(theDate));
			}

			if (rsR.getString(78) == null) {
				bean.setHave_rep("No");
			} else {
				bean.setHave_rep("Yes");
			}
			bean.setS5a(rsR.getString(78));
			bean.setS5b(rsR.getString(79));
			bean.setS5c_addr1(rsR.getString(80));
			bean.setS5c_addr2(rsR.getString(81));
			bean.setS5c_addr3(rsR.getString(82));
			bean.setS5c_addr4(rsR.getString(83));
			bean.setS5c_postcode(rsR.getString(84));
			bean.setS5d(rsR.getString(85));
			bean.setS5e(rsR.getString(86));
			bean.setS5f(rsR.getString(87));
			bean.setS5g(rsR.getString(88));
			bean.setS5h(rsR.getString(89));
			bean.setS5i(rsR.getString(90));
			bean.setS5j(rsR.getString(91));

			bean.setSecuritytoken(rsR.getString("securitytoken"));
			bean.setS5b_other(rsR.getString(93));
			bean.setRep_sign(rsR.getString(94));
			bean.setS4_decalaration(rsR.getString(96));
			if (rsR.getDate(97) != null) {
				theDate = rsR.getDate(97);
				bean.setS2i_service_day(getTheDay(theDate));
				bean.setS2i_service_month(getTheMonth(theDate));
				bean.setS2i_service_year(getTheYear(theDate));
			}
			bean.setS1f_email(rsR.getString(98));
			closeResultSet(rsR);
			closePreparedStatement(stmtR);

			stmt2R = conn.prepareStatement(sql_retrieve1_2);
			stmt2R.setString(1, security_token);
			rs2R = stmt2R.executeQuery();
			rs2R.next();
			bean.setS3d_2(rs2R.getString("s3d_2"));
			closeResultSet(rs2R);
			closePreparedStatement(stmt2R);

			stmt3R = conn.prepareStatement(sql_retrieve1_33);
			stmt3R.setString(1, security_token);
			rs3R = stmt3R.executeQuery();
			rs3R.next();
			bean.setS3d_3(rs3R.getString("s3d_3"));
			closeResultSet(rs3R);
			closePreparedStatement(stmt3R);

			stmt4R = conn.prepareStatement(sql_retrieve1_4);
			stmt4R.setString(1, security_token);
			rs4R = stmt4R.executeQuery();
			rs4R.next();
			bean.setS3d_4(rs4R.getString("s3d_4"));
			closeResultSet(rs4R);
			closePreparedStatement(stmt4R);

			stmt5R = conn.prepareStatement(sql_retrieve1_5);
			stmt5R.setString(1, security_token);
			rs5R = stmt5R.executeQuery();
			rs5R.next();
			bean.setS3d_5(rs5R.getString("s3d_5"));
			closeResultSet(rs5R);
			closePreparedStatement(stmt5R);

			stmt6R = conn.prepareStatement(sql_retrieve1_6);
			stmt6R.setString(1, security_token);
			rs6R = stmt6R.executeQuery();
			rs6R.next();
			bean.setS3d_6(rs6R.getString("s3d_6"));
			closeResultSet(rs6R);
			closePreparedStatement(stmt6R);

			stmt7R = conn.prepareStatement(sql_retrieve1_7);
			stmt7R.setString(1, security_token);
			rs7R = stmt7R.executeQuery();
			rs7R.next();
			bean.setS3d_7(rs7R.getString("s3d_7"));
			closeResultSet(rs7R);
			closePreparedStatement(stmt7R);

			stmt8R = conn.prepareStatement(sql_retrieve1_8);
			stmt8R.setString(1, security_token);
			rs8R = stmt8R.executeQuery();
			rs8R.next();
			bean.setS3d_8(rs8R.getString("s3d_8"));
			closeResultSet(rs8R);
			closePreparedStatement(stmt8R);

			stmt9R = conn.prepareStatement(sql_retrieve1_9);
			stmt9R.setString(1, security_token);
			rs9R = stmt9R.executeQuery();
			rs9R.next();
			bean.setS3d_additional(rs9R.getString("s3d_additional"));
			closeResultSet(rs9R);
			closePreparedStatement(stmt9R);

			stmt10R = conn.prepareStatement(sql_retrieve_urn);
			stmt10R.setString(1, security_token);
			rs10R = stmt10R.executeQuery();
			rs10R.next();
			req.getSession().setAttribute("token1", bean.getSecuritytoken());
			req.getSession().setAttribute("token", bean.getSecuritytoken());
			bean.setSubmissionURN(rs10R.getString("submissionURN"));

			bean.setPaymentURN(rs10R.getString("paymentURN"));
			String aggURN = rs10R.getString("AggregatedURN");
			bean.setAggregatedpaymentURN(aggURN);
			logger.debug("**********************Aggregated payment URN : "+aggURN);
			if(null != aggURN){
				req.getSession().setAttribute("aggrtoken", bean.getAggregatedpaymentURN());
			} else {
				req.getSession().setAttribute("aggrtoken", null);
			}
			
			bean.setFormtype(rs10R.getString("formname"));
			// bean.set
			bean.setPaymentvalue(rs10R.getInt("amount"));

			bean.setFormtitle(rs10R.getString("formtitle"));
			req.getSession().setAttribute("frmHeader", bean.getFormtitle());

			closeResultSet(rs10R);
			closePreparedStatement(stmt10R);

			return bean;
		}
		return bean;
	}

	/**
	 * todo.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean retrieve(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		IAFT1Bean bean = new IAFT1Bean();
		QueryBuilder qBuilder = new QueryBuilder();
		try {
			
			DBConnection dbconnection = new DBConnection();
			conn=dbconnection.getConnection();
 
			bean = qBuilder.populateIAFT1Bean(bean, req, security_token,conn);
		} catch (Exception e) {
			logger.error("QueryBuilder.retrieve", e);
			return bean;
		}finally {
			try {
				
				QueryBuilder.closeConnection(conn);
				logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.retrieve", sqle);
			}
		}
		return bean;
	}

	/**
	 * IAF t1_1.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_1(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		IAFT1Bean bean = new IAFT1Bean();
		String feepayable = null;
		if (req.getSession().getAttribute("FeePayable") != null) {
			feepayable = req.getSession().getAttribute("FeePayable").toString();
		}
		if (action.equals("retrieve")) {
			return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
		}

		else if (action == "save") {

			try {
				// String submission_urn = "";
				String urnsql = sql_urn_update;
				String urnsql1 = sql_urn_get;
				String thissql1 = sql_save_urn;
				String thissql11 = sql_update1_urn;

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

				PreparedStatement stmturn_get = null;
				stmturn_get = conn.prepareStatement(urnsql1);
				ResultSet rs = stmturn_get.executeQuery();
				rs.next();
				String submission_urn = rs.getString("Id");
				closeResultSet(rs);
				closePreparedStatement(stmturn_get);

				PreparedStatement stmturn = null;
				
				if (!save.equals("update")) {
					logger.debug("Its comiong to save information");
					stmturn = conn.prepareStatement(urnsql);
					stmturn.setString(1, SecurityToken.generateSubmissionURN(submission_urn) + "");
					stmturn.executeUpdate();
					closePreparedStatement(stmturn);

					if (frm.getQb_lsc().equals("No")) {
					logger.debug("LSC is No");
					
					
					if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
						bean.setSubmissionURN("22" + "88" + SecurityToken.generateSubmissionURN(submission_urn));
						logger.debug("Assylum");
					} else {
						bean.setSubmissionURN("33" + "88" + SecurityToken.generateSubmissionURN(submission_urn));
						logger.debug("Non asylum");
					}
					bean.setPaymentURN(bean.getSubmissionURN());

				}

				if (req.getSession().getAttribute("aggrtoken") != null) {
					
					if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
						bean.setSubmissionURN("22" + "77" + SecurityToken.generateSubmissionURN(submission_urn));
					} else {
						bean.setSubmissionURN("33" + "77" + SecurityToken.generateSubmissionURN(submission_urn));

					}
					bean.setPaymentURN(bean.getSubmissionURN());
				}
				if (!frm.getQb_lsc().equals("No") || feepayable != null) {
					logger.debug("LSC is yes and LSC value is"+frm.getQb_lsc());
					if(req.getSession().getAttribute("frmHeader")!=null)
					{
					if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
						logger.debug("Form header is present in the session");

						bean.setSubmissionURN("22" + "99" + SecurityToken.generateSubmissionURN(submission_urn));
					} else {
						bean.setSubmissionURN("33" + "99" + SecurityToken.generateSubmissionURN(submission_urn));

					}
					}
					else
					{
						logger.debug("Form header is not present in the session");
						bean.setSubmissionURN("2299"+SecurityToken.generateSubmissionURN(submission_urn));
					
					}// bean.setSubmissionURN("33"+"99"+SecurityToken.generateSubmissionURN(submission_urn));
					bean.setPaymentURN(bean.getSubmissionURN());

				}
				}
				else
				{
					IAFT1Bean iaf=(IAFT1Bean)QueryBuilder.retrieve(frm, action, datasource, security_token, req);
					if (frm.getQb_lsc().equals("No")) {
						
						
					

						if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
							bean.setSubmissionURN("22" + "88" + iaf.getSubmissionURN().substring(4));
						} else {
							bean.setSubmissionURN("33" + "88" + iaf.getSubmissionURN().substring(4));

						}
						bean.setPaymentURN(bean.getSubmissionURN());

					}

					if (req.getSession().getAttribute("aggrtoken") != null) {
					
						if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
							bean.setSubmissionURN("22" + "77" + iaf.getSubmissionURN().substring(4));
						} else {
							bean.setSubmissionURN("33" + "77" + iaf.getSubmissionURN().substring(4));

						}
						bean.setPaymentURN(bean.getSubmissionURN());
					}
					if (!frm.getQb_lsc().equals("No") || feepayable != null) {
						if (req.getSession().getAttribute("frmHeader").toString().equals("Asylum")) {
							bean.setSubmissionURN("22" + "99" + iaf.getSubmissionURN().substring(4));
						} else {
							bean.setSubmissionURN("33" + "99" + iaf.getSubmissionURN().substring(4));

						}
						// bean.setSubmissionURN("33"+"99"+SecurityToken.generateSubmissionURN(submission_urn));
						bean.setPaymentURN(bean.getSubmissionURN());

					}
					
					
					
				}
				closePreparedStatement(stmturn);

				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(thissql);
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
				stmt.setTimestamp(20, dateconverter.convertdate());
				stmt.setString(21, security_token);
				if (save.equals("update")) {

					req.getSession().setAttribute("token", req.getSession().getAttribute("token1"));
					stmt.executeUpdate();
					closePreparedStatement(stmt);
					// bean = QueryBuilder.retrieve(frm, action, datasource,
					// security_token, req);
					IAFT1Bean iaf=(IAFT1Bean)QueryBuilder.retrieve(frm, action, datasource, security_token, req);
					PreparedStatement stmt1 = null;
					stmt1 = conn.prepareStatement(thissql11);
					stmt1.setString(1, bean.getSubmissionURN());
					stmt1.setString(2, bean.getPaymentURN());
					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(3, req.getSession().getAttribute("aggrtoken").toString());
					} else {
						stmt1.setString(3, bean.getAggregatedpaymentURN());
					}
					// stmt1.setString(5, "IAFT1");
					if (frm.getAppeal_type().equals("Oral")) {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {

							stmt1.setInt(4, 140);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						}
						// else for amount 0 if LSC remission is entered.
						else {
							stmt1.setInt(4, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {
							stmt1.setInt(4, 80);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 80;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 80);
							}
						} else {
							stmt1.setInt(4, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}

					}

					stmt1.setString(5, req.getSession().getAttribute("frmHeader").toString());
					stmt1.setString(6, security_token);
					stmt1.execute();
					logger.debug("\t\tMethod: IAFT1_1 Status:Update End");
					return QueryBuilder.retrieve(frm, action, datasource, req.getSession().getAttribute("token1")
							.toString(), req);
				} else {
					
					logger.debug("statement save");
					stmt.execute();
					closePreparedStatement(stmt);

					PreparedStatement stmt1 = null;
					stmt1 = conn.prepareStatement(thissql1);
					stmt1.setString(1, security_token);
					stmt1.setString(2, bean.getSubmissionURN());
					stmt1.setString(3, bean.getPaymentURN());
					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(4, req.getSession().getAttribute("aggrtoken").toString());
					} else {
						stmt1.setString(4, bean.getAggregatedpaymentURN());
					}
					stmt1.setString(5, "IAFT1");
					if (frm.getAppeal_type().equals("Oral")) {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {

							stmt1.setInt(6, 140);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						}
						// else for amount 0 if LSC remission is entered.
						else {
							stmt1.setInt(6, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession().getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {
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
					stmt1.setString(7, req.getSession().getAttribute("frmHeader").toString());
					logger.debug("Saving general info");
					stmt1.execute();
					closePreparedStatement(stmt1);
				}
			} catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_1", e);
				return bean;
			}finally{
				try{
				QueryBuilder.closeConnection(conn);
				}catch (Exception r) {
					logger.error("QueryBuilder.IAFT1_1", r);
				}
			}
		}
		logger.debug("\t\tMethod: IAFT1_1 Status:Save End");
		return bean;
	}

	/**
	 * IAF t1_2.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_2(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT1Bean bean = new IAFT1Bean();
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
				logger.error("QueryBuilder.IAFT1_2", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_2", sqle);
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
				} else {
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
				stmt.executeUpdate();

				return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_2", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_2", sqle);
				}
			}
		}
		return bean;
	}

	/**
	 * IAF t1_3.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_3(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		logger.debug("\t\tMethod: IAFT1_3 Status: Start");
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		
			IAFT1Bean bean = new IAFT1Bean();
			IAFT1Bean bean_amount = new IAFT1Bean();

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
					logger.error("QueryBuilder.IAFT1_3", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closeConnection(conn);
						logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_3", sqle);
					}
				}
			}

			if (action == "save") {
				try {

					DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

					String thissql = sql_save1_3;
					String thissql11 = sql_update3_urn;
					stmt = conn.prepareStatement(thissql);
					stmt.setString(1, frm.getS2a());
					stmt.setString(2, frm.getS2b());
					stmt.setString(3, frm.getS2c());

					stmt.setString(4, frm.getS2d());
					stmt.setString(5, frm.getS2d_other());
					frm.setS2e(dateconverter.convertdate(frm.getS2e_service_day(), frm.getS2e_service_month(),
							frm.getS2e_service_year()));
					frm.setS2i(dateconverter.convertdate(frm.getS2i_service_day(), frm.getS2i_service_month(),
							frm.getS2i_service_year()));
					stmt.setDate(
							6,
							dateconverter.convertdate(frm.getS2e_service_day(), frm.getS2e_service_month(),
									frm.getS2e_service_year()));

					stmt.setDate(
							7,
							frm.getS2i());

					stmt.setString(8, security_token);

					stmt.executeUpdate();
					bean_amount = QueryBuilder.retrieve(frm, action, datasource, security_token, req);
					closeResultSet(rs);
					closePreparedStatement(stmt);

					stmt1 = conn.prepareStatement(thissql11);
					if (Helper.returnStringAmount_paper(frm.getS2e().toString()) == 0
							|| !bean_amount.getQb_lsc().equals("No") || bean_amount.getPaymentvalue() == 0) {

						frm.setSubmissionURN(bean_amount.getSubmissionURN().substring(0, 2) + "99"
								+ bean_amount.getSubmissionURN().substring(4));
						stmt1.setString(1, frm.getSubmissionURN());
						stmt1.setString(2, frm.getSubmissionURN());
						stmt1.setInt(3, 0);

						stmt1.setString(4, security_token);

						stmt1.executeUpdate();
					} else
					{
						if (bean_amount.getAppeal_type().equals("Oral") && bean_amount.getQb_lsc().equals("No")) {
							stmt1.setString(1, bean_amount.getSubmissionURN());
							stmt1.setString(2, bean_amount.getSubmissionURN());
							stmt1.setInt(3, Helper.returnStringAmount_oral(frm.getS2e().toString()));
							stmt1.setString(4, security_token);
							logger.debug("Query is "+stmt1.toString());
							stmt1.executeUpdate();
						}
						if (bean_amount.getAppeal_type().equals("Paper") && bean_amount.getQb_lsc().equals("No")) {
							stmt1.setString(1, bean_amount.getSubmissionURN());
							stmt1.setString(2, bean_amount.getSubmissionURN());
							stmt1.setInt(3, Helper.returnStringAmount_paper(frm.getS2e().toString()));
							stmt1.setString(4, security_token);
							logger.debug("Query is "+stmt1.toString());
							stmt1.executeUpdate();
						}
					}
					
					return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
				} catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_3", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closePreparedStatement(stmt1);
						QueryBuilder.closeConnection(conn);
						logger.debug("\t\tMethod: IAFT1_3 Status: End");
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_3", sqle);
					}
				}
			} else {
				return bean;
			}
		
		
	}

	/**
	 * IAF t1_4.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_4(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		logger.debug("\t\tMethod: IAFT1_4 Status: Start");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT1Bean bean = new IAFT1Bean();
		
			
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
					logger.error("QueryBuilder.IAFT1_4", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closeConnection(conn);
						logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_4", sqle);
					}
				}
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
					return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
				} catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_4", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closeConnection(conn);
						logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_4", sqle);
					}
				}
			} else {
				return bean;
			}
		
		
	}

	/**
	 * IAF t1_5.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_5(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		logger.debug("\t\tMethod: IAFT1_5 Status: Start");
		IAFT1Bean bean = new IAFT1Bean();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
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
				logger.error("QueryBuilder.IAFT1_5", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_5 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_5", sqle);
				}
			}
		}

		if (action == "save") {
			PreparedStatement stmt1 = null;
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			try {

				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql1 = sql_save1_5_1;
				String thissql2 = sql_save1_5_2;
				String thissql3 = sql_save1_5_3;

				stmt1 = conn.prepareStatement(thissql1);
				stmt1.setString(1, frm.getS3d_1());
				stmt1.setString(2, security_token);
				stmt1.executeUpdate();
				closePreparedStatement(stmt1);

				stmt2 = conn.prepareStatement(thissql2);
				stmt2.setString(1, frm.getS3d_2());
				stmt2.setString(2, security_token);
				stmt2.executeUpdate();
				closePreparedStatement(stmt2);

				stmt3 = conn.prepareStatement(thissql3);
				stmt3.setString(1, frm.getS3d_3());
				stmt3.setString(2, security_token);
				stmt3.executeUpdate();
				closePreparedStatement(stmt3);

				logger.debug("\t\tMethod: IAFT1_5 Status: End");
				return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_5", e);
				return bean;
			}finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt1);
					QueryBuilder.closePreparedStatement(stmt2);
					QueryBuilder.closePreparedStatement(stmt3);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_6 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_5", sqle);
				}
			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t1_6.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_6(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {

		logger.debug("\t\tMethod: IAFT1_6 Status: Start");
		Connection conn = null;
		IAFT1Bean bean = new IAFT1Bean();
		ResultSet rs = null;
		PreparedStatement stmt = null;
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
				logger.error("QueryBuilder.IAFT1_6", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_6 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_6", sqle);
				}
			}
		}

		if (action == "save") {
			PreparedStatement stmt4 = null;
			PreparedStatement stmt5 = null;
			PreparedStatement stmt6 = null;
			PreparedStatement stmt7 = null;
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql4 = sql_save1_5_4;
				String thissql5 = sql_save1_5_5;
				String thissql6 = sql_save1_5_6;
				String thissql7 = sql_save1_5_7;

				stmt4 = conn.prepareStatement(thissql4);
				stmt4.setString(1, frm.getS3d_4());
				stmt4.setString(2, security_token);
				stmt4.executeUpdate();
				closePreparedStatement(stmt4);

				stmt5 = conn.prepareStatement(thissql5);
				stmt5.setString(1, frm.getS3d_5());
				stmt5.setString(2, security_token);
				stmt5.executeUpdate();
				closePreparedStatement(stmt5);

				stmt6 = conn.prepareStatement(thissql6);
				stmt6.setString(1, frm.getS3d_6());
				stmt6.setString(2, security_token);
				stmt6.executeUpdate();
				closePreparedStatement(stmt6);

				stmt7 = conn.prepareStatement(thissql7);
				stmt7.setString(1, frm.getS3d_7());
				stmt7.setString(2, security_token);
				stmt7.executeUpdate();
				closePreparedStatement(stmt7);

				return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_6", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closePreparedStatement(stmt4);
					QueryBuilder.closePreparedStatement(stmt5);
					QueryBuilder.closePreparedStatement(stmt6);
					QueryBuilder.closePreparedStatement(stmt7);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_6 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_6", sqle);
				}
			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t1_7.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_7(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		logger.debug("\t\tMethod: IAFT1_7 Status: Start");

		IAFT1Bean bean = new IAFT1Bean();
		if (action == "retrieve") {
			PreparedStatement stmt = null;
			ResultSet rs = null;
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
			}

			catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_7", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_7 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_7", sqle);
				}
			}
		}

		if (action == "save") {
			PreparedStatement stmt8 = null;
			PreparedStatement stmt9 = null;
			try {

				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql8 = sql_save1_5_8;
				String thissql9 = sql_save1_5_9;

				stmt8 = conn.prepareStatement(thissql8);
				stmt8.setString(1, frm.getS3d_8());
				stmt8.setString(2, security_token);
				stmt8.executeUpdate();
				closePreparedStatement(stmt8);

				stmt9 = conn.prepareStatement(thissql9);
				stmt9.setString(1, frm.getS3d_additional());
				stmt9.setString(2, security_token);
				stmt9.executeUpdate();
				closePreparedStatement(stmt9);

				return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder.IAFT1_7", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closePreparedStatement(stmt8);
					QueryBuilder.closePreparedStatement(stmt9);
					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_7 Status: End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder.IAFT1_7", sqle);
				}
			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t1_8.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_8(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		logger.debug("\t\tMethod: IAFT1_8 Status: Start");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			IAFT1Bean bean = new IAFT1Bean();
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

				}

				catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_8", e);
					return bean;
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

					return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
				} catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_8", e);
					return bean;
				}
			} else {
				return bean;
			}
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				logger.debug("\t\tMethod: IAFT1_8 Status: End");
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.IAFT1_8", sqle);
			}
		}
	}

	/**
	 * IAF t1_9.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT1_9(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		Connection conn = null;
		logger.debug("\t\tMethod: IAFT1_9 Status: Start");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			IAFT1Bean bean = new IAFT1Bean();
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
					logger.error("QueryBuilder.IAFT1_9", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closeConnection(conn);
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_9", sqle);
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
					logger.debug("\t\tMethod: IAFT1_9 Status:Save End");
					return QueryBuilder.retrieve(frm, action, datasource, security_token, req);
				} catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_9", e);
					return bean;
				}finally {
					try {
						QueryBuilder.closeResultSet(rs);
						QueryBuilder.closePreparedStatement(stmt);
						QueryBuilder.closeConnection(conn);
					} catch (SQLException sqle) {
						logger.error("QueryBuilder.IAFT1_9", sqle);
					}
				}
			} else {
				logger.debug("\t\tMethod: IAFT1_9 Status:Retrieve End");
				return bean;
			}
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.IAFT1_9", sqle);
			}
		}
	}

	/**
	 * IAF t1_10.
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
	public static String IAFT1_10(IAFT1Bean frm, String action, DataSource datasource, String security_token) {
		Connection conn = null;
		logger.debug("\t\tMethod: IAFT1_10 Status: Start");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
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
				}

				catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_10", e);
					return "failure";
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
					stmt.executeUpdate();

				} catch (Exception e) {
					logger.error("QueryBuilder.IAFT1_10", e);
					return "failure";
				}
				logger.debug("\t\tMethod: IAFT1_10 Status: Save end");
				return "success";
			} else {
				logger.debug("\t\tMethod: IAFT1_10 Status: retrieve end");
				return "success";
			}
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.IAFT1_10", sqle);
			}
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
	public static ArrayList<AggregatedSubmissionBean> getAggregatedsubmission(DataSource datasource, String urn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_retrieve_aggrurn;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, urn);

			rs = stmt.executeQuery();
			int count=0;
			HttpServletRequest req=null;

			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				asBean.setPaymenturn(rs.getString("AggregatedURN"));
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				
					count++;
					asBean.setCount(count);
				
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBean.setStatus(rs.getString("status"));
				if(asBean.getStatus().equals("Completed"))
				{
				asBeansArrayList.add(asBean);
				}
			}
			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("QueryBuilder.getAggregatedsubmission", e);
			return asBeansArrayList;
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.getAggregatedsubmission", sqle);
			}
		}
	}
	
	
	public static ArrayList<AggregatedSubmissionBean> getAggregatedsubmission(DataSource datasource, String urn,HttpServletRequest req) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_retrieve;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, urn);
			stmt.setString(2, urn);
			logger.debug("Aggregated URN"+urn);
			rs = stmt.executeQuery();
			int count=0;
			boolean flag=false;
			
			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				asBean.setPaymenturn(rs.getString("AggregatedURN"));
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				count++;
				asBean.setCount(count);
				
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				IAFTBean iAggBean = IAFTBeanFactory.getBeanInstance(asBean.getSecuritytoken(),
						datasource,req);
				if(asBean.getType().equals("IAFT1"))
				{
					IAFT1Bean ibean=(IAFT1Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				if(asBean.getType().equals("IAFT2"))
				{
					IAFT2Bean ibean=(IAFT2Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				if(asBean.getType().equals("IAFT3"))
				{
					IAFT3Bean ibean=(IAFT3Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				if(asBean.getType().equals("IAFT5"))
				{
					IAFT5Bean ibean=(IAFT5Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				if(asBean.getType().equals("IAFT6"))
				{
					IAFT6Bean ibean=(IAFT6Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				if(asBean.getType().equals("IAFT7"))
				{
					IAFT7Bean ibean=(IAFT7Bean)iAggBean;
				asBean.setName(ibean.getS1b()+" "+ibean.getS1a());
				}
				
				asBean.setStatus(rs.getString("status"));
				if(asBean.getStatus().equals("In Progress"))
				{
					flag=true;
				}
				if(!asBean.getStatus().equals("Deleted"))
				{
				asBeansArrayList.add(asBean);
				}
			}
			
			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("QueryBuilder.getAggregatedsubmission", e);
			return asBeansArrayList;
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.getAggregatedsubmission", sqle);
			}
		}
	}
	
	
	
	public static String gettoken(int no ,HttpServletRequest request) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String securityToken = request.getSession().getAttribute("token").toString();
		logger.debug("Method:execute - using security token: "+securityToken);
		DataSource datasource = null;

		IAFTBean iBean = IAFTBeanFactory.getBeanInstance(securityToken, datasource, request);
		logger.debug("Coming after retrieval and form type is"+iBean.getType());


		request.getSession().setAttribute("paymenttype", "submission");

		String token="";
		try {
		String AggrURN = iBean.getAggregatedpaymentURN();
		DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
		if (AggrURN != null) {
		//ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();



			

		String thissql = sql_retrieve_aggrurn;
		stmt = conn.prepareStatement(thissql);
		stmt.setString(1, AggrURN);

		rs = stmt.executeQuery();

		int cnt=0;

		while (rs.next()&& cnt<=no-1) {
		if(!rs.getString("status").equals("Deleted"))
		{
		++cnt;

		token=rs.getString("securitytoken");
		}
		}
		}

		else {
		//ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();



			

		String thissql = sql_retrieve_aggrurn1;
		stmt = conn.prepareStatement(thissql);
		stmt.setString(1, iBean.getPaymentURN());
		stmt.setString(2, iBean.getPaymentURN());

		rs = stmt.executeQuery();

		int cnt=0;

		while (rs.next()&& cnt<=no-1) {
		if(!rs.getString("status").equals("Deleted"))
		{
		++cnt;

		token=rs.getString("securitytoken");
		}
		}
		}
		return token;
		} catch (Exception e) {
			logger.error("QueryBuilder.gettoken", e);
		return token;
		
		}finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.gettoken", sqle);
			}
		}
	}
	
	/**
	 * Get all submission by that URN and token.
	 * 
	 * @param datasource
	 *            the datasource
	 * @param urn
	 *            the urn
	 * @return the aggregatedsubmissiontoken
	 */
	
	public static ArrayList<AggregatedSubmissionBean> getAggregatedsubmissiontoken(DataSource datasource, String urn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = new ArrayList<AggregatedSubmissionBean>();
		try {

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_retrieve_both;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, urn);
			stmt.setString(2, urn);
			stmt.setString(3, urn);
			logger.debug("Aggregated URN"+urn);
			rs = stmt.executeQuery();
            
			while (rs.next()) {
				AggregatedSubmissionBean asBean = new AggregatedSubmissionBean();
				asBean.setUrn(rs.getString("submissionURN"));
				asBean.setPaymenturn(rs.getString("AggregatedURN"));
				asBean.setType(rs.getString("formname"));
				asBean.setAmount(rs.getInt("amount"));
				
				asBean.setSecuritytoken(rs.getString("securitytoken"));
				asBeansArrayList.add(asBean);
			}
			return asBeansArrayList;
		} catch (Exception e) {
			logger.error("QueryBuilder.getAggregatedsubmissiontoken", e);
			return asBeansArrayList;
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.getAggregatedsubmissiontoken", sqle);
			}
		}
	}
	
	
	
	/**
	 * Delete the appeal 
	 * **/
	
	public static String  updateappealstatus(DataSource datasource, String token,String status) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_delete_token;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, status);
			stmt.setString(2, token);
			
			logger.debug("Aggregated URN"+status+"query>>>>>>>>"+stmt);
			stmt.executeUpdate();

			
			return "Success";
		} catch (Exception e) {
			logger.error("QueryBuilder.updateappealstatus", e);
			return "failure";
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.updateappealstatus", sqle);
			}
		}
	}

	/**
	 * This is called when another lodgement is created so represents an
	 * aggregated payment.
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
	 * @return the iAF t1 bean
	 */
	public static IAFT1Bean IAFT_new(IAFT1Bean frm, String action, DataSource datasource, String security_token,
			HttpServletRequest req) {
		IAFT1Bean bean = new IAFT1Bean();
		IAFT2Bean frm2 = new IAFT2Bean();
		IAFT3Bean frm3 = new IAFT3Bean();
		IAFT5Bean frm5 = new IAFT5Bean();
		IAFT6Bean frm6 = new IAFT6Bean();
		IAFT7Bean frm7 = new IAFT7Bean();
		Connection conn = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;

		try {
			logger.debug("coming here in aggregation  new lodgement");
			String thissql1 = sql_update_urn;

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			stmt1 = conn.prepareStatement(thissql1);
			//frm = QueryBuilder.retrieve(frm, "retrieve", datasource, security_token, req);
			if (req.getSession().getAttribute("aggrtoken") != null) {
				bean.setAggregatedpaymentURN(req.getSession().getAttribute("aggrtoken").toString());
				//bean.setSubmissionURN(frm.getSubmissionURN().substring(0,2)+"77"+frm.getSubmissionURN().substring(4));

			} 
			else {

				bean.setAggregatedpaymentURN("77" + SecurityToken.generateAggregatedPaymentURN());
				logger.debug("Its aggregated submission"+bean.getAggregatedpaymentURN());
			}
			logger.debug("statement is Aggreagted URN is"+bean.getAggregatedpaymentURN());
			
			IAFTBean iAggBean = IAFTBeanFactory.getBeanInstance(security_token, datasource, req);
			logger.debug("formtype is"+iAggBean.getType());
			if (iAggBean.getType().equals("IAFT1")) {
				frm = QueryBuilder.retrieve(frm, "retrieve", datasource, security_token, req);
				if (frm.getPaymentvalue() == 0) {
					if (frm.getFormtitle().equals("Asylum")) {
						bean.setSubmissionURN("22" + "99" + frm.getSubmissionURN().substring(4));
					} else {
						bean.setSubmissionURN("33" + "99" + frm.getSubmissionURN().substring(4));

					}

				} else {
					bean.setSubmissionURN(frm.getSubmissionURN().substring(0,2)+"77"+frm.getSubmissionURN().substring(4));
				}
			} if (iAggBean.getType().equals("IAFT2")) {
				frm2 = QueryBuilder2.retrieve(frm2, "retrieve", datasource, security_token, req);

				if (frm2.getPaymentvalue() == 0) {

					bean.setSubmissionURN("44" + "99" + frm2.getSubmissionURN().substring(4));

				} else {
					bean.setSubmissionURN(frm2.getSubmissionURN().substring(0,2)+"77"+frm2.getSubmissionURN().substring(4));
				}
			}
			if (iAggBean.getType().equals("IAFT3")) {
				logger.debug("COming in IAFT3 retrieve");
				frm3 = QueryBuilder3.retrieve(frm3, "retrieve", datasource, security_token, req);
				logger.debug("Submission URN is"+frm3.getSubmissionURN());
				if (frm3.getPaymentvalue() == 0) {

					bean.setSubmissionURN("44" + "99" + frm3.getSubmissionURN().substring(4));

				} else {
					bean.setSubmissionURN(frm3.getSubmissionURN().substring(0,2)+"77"+frm3.getSubmissionURN().substring(4));
				}
				logger.debug("Submission URN is"+bean.getSubmissionURN());
			}
			
			if (iAggBean.getType().equals("IAFT5")) {
				frm5 = QueryBuilder5.retrieve(frm5, "retrieve", datasource, security_token, req);
				if (frm5.getPaymentvalue() == 0) {
					if(req.getSession().getAttribute("frmHeader")!=null)
					{
						
						String submission_urn=frm5.getSubmissionURN().substring(4);
					if (req.getSession().getAttribute("frmHeader").toString().equals("Protection")) {
						bean.setSubmissionURN("51" + "99" + submission_urn);
						logger.debug("Assylum");
					} 
					if (req.getSession().getAttribute("frmHeader").toString().equals("Protection Revoke")) {
						bean.setSubmissionURN("53" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("Human Rights")) {
						bean.setSubmissionURN("52" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("EEA")) {
						bean.setSubmissionURN("54" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("Citizenship")) {
						bean.setSubmissionURN("55" + "99" + submission_urn);
						logger.debug("Assylum");
					}

				}} else {
					bean.setSubmissionURN(frm5.getSubmissionURN().substring(0,2)+"77"+frm5.getSubmissionURN().substring(4));
				}
			} 
			if (iAggBean.getType().equals("IAFT6")) {
				frm6 = QueryBuilder6.retrieve(frm6, "retrieve", datasource, security_token, req);
				if (frm6.getPaymentvalue() == 0) {
					if(req.getSession().getAttribute("frmHeader")!=null)
					{
						
						String submission_urn=frm6.getSubmissionURN().substring(4);
				
					if (req.getSession().getAttribute("frmHeader").toString().equals("Human Rights")) {
						bean.setSubmissionURN("52" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("EEA")) {
						bean.setSubmissionURN("54" + "99" + submission_urn);
						logger.debug("Assylum");
					}
				
				}} else {
					bean.setSubmissionURN(frm6.getSubmissionURN().substring(0,2)+"77"+frm6.getSubmissionURN().substring(4));
				}
			} 
			if (iAggBean.getType().equals("IAFT7")) {
				frm7 = QueryBuilder7.retrieve(frm7, "retrieve", datasource, security_token, req);
				if (frm7.getPaymentvalue() == 0) {
					if(req.getSession().getAttribute("frmHeader")!=null)
					{
						
						String submission_urn=frm7.getSubmissionURN().substring(4);
					if (req.getSession().getAttribute("frmHeader").toString().equals("Protection")) {
						bean.setSubmissionURN("51" + "99" + submission_urn);
						logger.debug("Assylum");
					} 
					if (req.getSession().getAttribute("frmHeader").toString().equals("Protection Revoke")) {
						bean.setSubmissionURN("53" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("Human Rights")) {
						bean.setSubmissionURN("52" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("EEA")) {
						bean.setSubmissionURN("54" + "99" + submission_urn);
						logger.debug("Assylum");
					}
					if (req.getSession().getAttribute("frmHeader").toString().equals("Citizenship")) {
						bean.setSubmissionURN("55" + "99" + submission_urn);
						logger.debug("Assylum");
					}

				}} else {
					bean.setSubmissionURN(frm7.getSubmissionURN().substring(0,2)+"77"+frm7.getSubmissionURN().substring(4));
				}
			} 
			stmt1.setString(1, bean.getSubmissionURN());
			stmt1.setString(2, bean.getSubmissionURN());
			stmt1.setString(3, bean.getAggregatedpaymentURN());
		
			req.getSession().setAttribute("aggrtoken", bean.getAggregatedpaymentURN());

			stmt1.setString(4, security_token);
			stmt1.executeUpdate();
			

		} catch (Exception e) {
			logger.error("QueryBuilder.IAFT_new", e);
			
			bean.setErr(true); // error occured

			return bean;
		} finally {
			try {
				QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt1);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.IAFT_new", sqle);
			}
		}

		return bean;
	}
	
	public static void updateurn(String submissionurn,String paymenturn, DataSource datasource, String security_token,
			HttpServletRequest req)
	{
		
    String thissql = sql_update_suburn;
    Connection conn = null;
    PreparedStatement stmt1=null;
		try{

			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

		stmt1=conn.prepareStatement(thissql);
		stmt1.setString(1, submissionurn);
		stmt1.setString(2, paymenturn);
		
		stmt1.setString(3, security_token);
		stmt1.executeUpdate();
		
	    
		}catch(Exception e)
		{
			logger.error("QueryBuilder.updateurn", e);
		}
		finally {
			try {
				//QueryBuilder.closeResultSet(rs);
				QueryBuilder.closePreparedStatement(stmt1);
				QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("QueryBuilder.updateurn", sqle);
			}
		}
		
	}
	

}
