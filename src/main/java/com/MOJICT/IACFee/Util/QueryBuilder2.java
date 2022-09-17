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

import com.MOJICT.IACFee.Beans.IAFT2Bean;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryBuilder2.
 */
public class QueryBuilder2 extends GenericQueryBuilder implements
		QueryBuilder2Properties {

	/** log4j logging solution. */
	static Logger logger = Logger.getLogger(QueryBuilder2.class);

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
	 * @return the iAF t2 bean
	 */
	@SuppressWarnings("deprecation")
	public static IAFT2Bean retrieve(IAFT2Bean frm, String action,
                                     DataSource datasource, String security_token, HttpServletRequest req) {
		IAFT2Bean bean = new IAFT2Bean();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PreparedStatement stmt2 = null;
		ResultSet rs2 = null;
		PreparedStatement stmt3 = null;
		ResultSet rs3 = null;
		PreparedStatement stmt4 = null;
		ResultSet rs4 = null;
		PreparedStatement stmt5 = null;
		ResultSet rs5 = null;
		PreparedStatement stmt6 = null;
		ResultSet rs6 = null;
		PreparedStatement stmt7 = null;
		ResultSet rs7 = null;
		PreparedStatement stmt8 = null;
		ResultSet rs8 = null;
		PreparedStatement stmt9 = null;
		ResultSet rs9 = null;
		PreparedStatement stmt10 = null;
		ResultSet rs10 = null;

		try {
			DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

			String thissql = sql_retrieve2_1;
			String thissql2 = sql_retrieve2_2;
			String thissql3 = sql_retrieve2_33;
			String thissql4 = sql_retrieve2_4;
			String thissql5 = sql_retrieve2_5;
			String thissql6 = sql_retrieve2_6;
			String thissql7 = sql_retrieve2_7;
			String thissql8 = sql_retrieve2_8;
			String thissql9 = sql_retrieve2_9;
			String thissql10 = sql_retrieve_urn;
			stmt = conn.prepareStatement(thissql);
			stmt.setString(1, security_token);
			rs = stmt.executeQuery();
			stmt2 = conn.prepareStatement(thissql2);
			stmt2.setString(1, security_token);
			rs2 = stmt2.executeQuery();

			stmt3 = conn.prepareStatement(thissql3);
			stmt3.setString(1, security_token);
			rs3 = stmt3.executeQuery();
			stmt4 = conn.prepareStatement(thissql4);
			stmt4.setString(1, security_token);
			rs4 = stmt4.executeQuery();
			stmt5 = conn.prepareStatement(thissql5);
			stmt5.setString(1, security_token);
			rs5 = stmt5.executeQuery();
			stmt6 = conn.prepareStatement(thissql6);
			stmt6.setString(1, security_token);
			rs6 = stmt6.executeQuery();
			stmt7 = conn.prepareStatement(thissql7);
			stmt7.setString(1, security_token);
			rs7 = stmt7.executeQuery();
			stmt8 = conn.prepareStatement(thissql8);
			stmt8.setString(1, security_token);
			rs8 = stmt8.executeQuery();
			stmt9 = conn.prepareStatement(thissql9);
			stmt9.setString(1, security_token);
			rs9 = stmt9.executeQuery();
			stmt10 = conn.prepareStatement(thissql10);
			stmt10.setString(1, security_token);
			rs10 = stmt10.executeQuery();
			if (rs.next()) {

				rs2.next();
				rs3.next();
				rs4.next();
				rs5.next();
				rs6.next();
				rs7.next();
				rs8.next();
				rs9.next();
				rs10.next();
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
				if (rs.getString(42) != null) {
				}

				if (rs.getDate(45) != null) {

				}
				bean.setS3f_who(rs.getString(37));
				bean.setS3f_language(rs.getString(38));
				bean.setS3f_dialect(rs.getString(39));
				bean.setS3g(rs.getString(40));

				bean.setS2a(rs.getString(47));
				bean.setS2b(rs.getString(48));
				bean.setS2c(rs.getString(49));
				bean.setS2d(rs.getString(50));

				bean.setS2d_post(rs.getString(50));
				bean.setS2d_fax(rs.getString(51));
				bean.setS2d_courier(rs.getString(52));
				bean.setS2d_other(rs.getString(53));
				bean.setS2e(rs.getDate(54));
				// dateconverter.convertdate(bean.getS2e());
				if (rs.getDate(54) != null) {
					bean.setS2e_day(rs.getDate(54).getDate());
					bean.setS2e_month(rs.getDate(54).getMonth() + 1);
					bean.setS2e_year(1900 + rs.getDate(54).getYear());
				}


				bean.setS3a(rs.getString(56));
				bean.setS3b(rs.getString(57));
				bean.setS3c(rs.getString(58));
				bean.setS3d_1(rs.getString("s3d_1"));
				bean.setS3d_2(rs2.getString("s3d_2"));
				bean.setS3d_3(rs3.getString("s3d_3"));
				bean.setS3e(rs.getString(68));

				if (rs.getDate(69) != null) {
					bean.setS3e_date1_day(rs.getDate(69).getDate());
					bean.setS3e_date1_month(rs.getDate(69).getMonth() + 1);
					bean.setS3e_date1_year(1900 + rs.getDate(69).getYear());
					bean.setS3e_appealno1(rs.getString(70));

				} else {
					bean.setS3e_appealno1(rs.getString(70));

				}
				if (rs.getDate(71) != null) {
					bean.setS3e_date2_day(rs.getDate(71).getDate());
					bean.setS3e_date2_month(rs.getDate(71).getMonth() + 1);
					bean.setS3e_date2_year(1900 + rs.getDate(71).getYear());
					bean.setS3e_appealno2(rs.getString(72));
				} else {
					bean.setS3e_appealno2(rs.getString(72));

				}

				if (rs.getDate(73) != null) {
					bean.setS3e_date3_day(rs.getDate(73).getDate());
					bean.setS3e_date3_month(rs.getDate(73).getMonth() + 1);
					bean.setS3e_date3_year(1900 + rs.getDate(73).getYear());
					bean.setS3e_appealno3(rs.getString(74));
				} else {
					bean.setS3e_appealno3(rs.getString(74));
				}

				bean.setS3f(rs.getString(75));

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

				req.getSession()
						.setAttribute("token1", bean.getSecuritytoken());
				req.getSession().setAttribute("token", bean.getSecuritytoken());
				bean.setSubmissionURN(rs10.getString("submissionURN"));

				bean.setPaymentURN(rs10.getString("paymentURN"));
				bean.setFormtype(rs10.getString("formname"));
				bean.setPaymentvalue(rs10.getInt("amount"));

				bean.setAggregatedpaymentURN(rs10.getString("AggregatedURN"));
				req.getSession().setAttribute("aggrtoken",
						bean.getAggregatedpaymentURN());

				bean.setS1_tod(rs10.getString("formtitle"));
				bean.setFormtitle(rs10.getString("formtitle"));

				bean.setS6a(rs.getString(95));
				bean.setS6b(rs.getString(96));
				bean.setS6c(rs.getString(97));
				bean.setS6d_addr1(rs.getString(98));
				bean.setS6d_addr2(rs.getString(99));
				bean.setS6d_addr3(rs.getString(100));
				bean.setS6d_addr4(rs.getString(101));
				bean.setS6d_postcode(rs.getString(102));

				bean.setS6e(rs.getString(103));
				bean.setS6f(rs.getString(104));
				bean.setS6_auth(rs.getString(105));
				bean.setHave_rep(rs.getString(107));
				bean.setHave_sponsor(rs.getString(108));
				bean.setS4_decalaration(rs.getString(110));
				bean.setS2i(rs.getDate(111));
				// dateconverter.convertdate(bean.getS2e());
				if (rs.getDate(111) != null) {
					bean.setS2i_day(rs.getDate(111).getDate());
					bean.setS2i_month(rs.getDate(111).getMonth() + 1);
					bean.setS2i_year(1900 + rs.getDate(111).getYear());
				}
				bean.setS1f_email(rs.getString(112));
				/*
				 * s5a s5b s5c_addr1 s5c_addr2 s5c_addr3 s5c_addr4 s5d s5e s5f
				 * s5g s5h s5i s5j securitytoken
				 */

				// }
			}
			return bean;
		}

		catch (Exception e) {
			logger.error("QueryBuilder2.retrieve", e);
			return bean;
		} finally {
			if (rs != null) {
				try {
					DBUtil.closeResultSet(rs);
					DBUtil.closePreparedStatement(stmt);
					DBUtil.closePreparedStatement(stmt2);
					DBUtil.closePreparedStatement(stmt3);
					stmt4.close();
					stmt5.close();
					stmt6.close();
					stmt7.close();
					stmt8.close();
					stmt9.close();
					stmt10.close();
					QueryBuilder.closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.retrieve", sqle);
				}
				rs = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.retrieve", sqle);
				}
				conn = null;
			}
		}
	}

	/**
	 * IAF t2_1.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_1(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {
		IAFT2Bean bean = new IAFT2Bean();
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmturn = null;
		PreparedStatement stmturn_get = null;
		ResultSet rs = null;

		String feepayable = null;
		if (req.getSession().getAttribute("FeePayable") != null) {
			feepayable = req.getSession().getAttribute("FeePayable").toString();
		}
		if (action.equals("retrieve")) {

			return QueryBuilder2.retrieve(frm, action, datasource,
					security_token, req);
		}

		else if (action == "save") {

			try {
				String submission_urn = "";
				String urnsql = sql_urn_update;
				String urnsql1 = sql_urn_get;
				String thissql1 = sql_save_urn;
				String thissql11 = sql_update1_urn;
				DBConnection dbconnection = new DBConnection();
				conn=dbconnection.getConnection();
				String thissql;
				String save;

				if (req.getSession().getAttribute("token1") != null) {

					thissql = sql_update2_1;
					save = "update";

				} else {
					thissql = sql_save2_1;
					save = "save";
				}

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
				stmt.setTimestamp(20, dateconverter.convertdate());
				stmt.setString(21, security_token);

				rs = stmturn_get.executeQuery();
				rs.next();
				submission_urn = rs.getString("Id");
				if (!save.equals("update")){

                	stmturn.setString(1, SecurityToken
							.generateSubmissionURN(submission_urn)
							+ "");
					stmturn.executeUpdate();

				if (frm.getQb_lsc().equals("No")) {

					bean.setSubmissionURN("44"
							+ "88"
							+ SecurityToken
									.generateSubmissionURN(submission_urn));

					bean.setPaymentURN(bean.getSubmissionURN());


				}
				if (req.getSession().getAttribute("aggrtoken") != null) {

					bean.setSubmissionURN("44"
							+ "77"
							+ SecurityToken
									.generateSubmissionURN(submission_urn));

					bean.setPaymentURN(bean.getSubmissionURN());
				}
				if (!frm.getQb_lsc().equals("No")) {
					bean.setSubmissionURN("44"
							+ "99"
							+ SecurityToken
									.generateSubmissionURN(submission_urn));

					bean.setPaymentURN(bean.getSubmissionURN());

				}
                }
                else
                {
                	IAFT2Bean iaf=(IAFT2Bean)QueryBuilder2.retrieve(frm, action, datasource, security_token, req);
                	if (frm.getQb_lsc().equals("No")) {

    					bean.setSubmissionURN("44"
    							+ "88"
    							+ iaf.getSubmissionURN().substring(4));

    					bean.setPaymentURN(bean.getSubmissionURN());

    				}
    				if (req.getSession().getAttribute("aggrtoken") != null) {


    					bean.setSubmissionURN("44"
    							+ "77"
    							+ iaf.getSubmissionURN().substring(4));

    					bean.setPaymentURN(bean.getSubmissionURN());
    				}
    				if (!frm.getQb_lsc().equals("No")) {

    					bean.setSubmissionURN("44"
    							+ "99"
    							+ iaf.getSubmissionURN().substring(4));

    					bean.setPaymentURN(bean.getSubmissionURN());

    				}

                }
				if (save.equals("update")) {

					req.getSession().setAttribute("token",
					req.getSession().getAttribute("token1"));
					stmt.executeUpdate();

					stmt1 = conn.prepareStatement(thissql11);
					stmt1.setString(1, bean.getSubmissionURN());
					stmt1.setString(2, bean.getPaymentURN());

					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(3, req.getSession().getAttribute(
								"aggrtoken").toString());
					} else {
						stmt1.setString(3, bean.getAggregatedpaymentURN());
					}

					// stmt1.setString(5, "IAFT1");
					if (frm.getAppeal_type().equals("Oral")) {

						if (frm.getQb_lsc().equals("No") && feepayable == null) {

							stmt1.setInt(4, 140);

							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						}
						// else for amount 0 if LSC remission is entered.
						else {

							stmt1.setInt(4, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {
							stmt1.setInt(4, 80);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 80;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 80);
							}
						} else {
							stmt1.setInt(4, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}

					}
					stmt1.setString(5, frm.getS1_tod());
					stmt1.setString(6, security_token);
					stmt1.execute();

					return QueryBuilder2.retrieve(frm, action, datasource, req
							.getSession().getAttribute("token1").toString(),
							req);
				} else {

					stmt.execute();
					stmt1 = conn.prepareStatement(thissql1);
					stmt1.setString(1, security_token);
					stmt1.setString(2, bean.getSubmissionURN());
					stmt1.setString(3, bean.getPaymentURN());
					if (req.getSession().getAttribute("aggrtoken") != null) {
						stmt1.setString(4, req.getSession().getAttribute(
								"aggrtoken").toString());
					} else {
						stmt1.setString(4, bean.getAggregatedpaymentURN());
					}
					stmt1.setString(5, "IAFT2");
					if (frm.getAppeal_type().equals("Oral")) {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {

							stmt1.setInt(6, 140);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 140;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 140);
							}

						}
						// else for amount 0 if LSC remission is entered.
						else {
							stmt1.setInt(6, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}
					} else {
						if (frm.getQb_lsc().equals("No") && feepayable == null) {
							stmt1.setInt(6, 80);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 80;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 80);
							}
						} else {
							stmt1.setInt(6, 0);
							if (req.getSession().getAttribute("amount") != null) {
								int amount = Integer.parseInt(req.getSession()
										.getAttribute("amount").toString()) + 0;
								req.getSession().setAttribute("amount", amount);
							} else {
								req.getSession().setAttribute("amount", 0);
							}
						}

					}
					stmt1.setString(7, frm.getS1_tod());
					stmt1.execute();

				}
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_1", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closePreparedStatement(stmt1);
					QueryBuilder.closePreparedStatement(stmturn);
					QueryBuilder.closePreparedStatement(stmturn_get);

					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_1", sqle);
				}
			}


			return bean;
		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_2.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_2(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT2Bean bean = new IAFT2Bean();
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();
				conn=dbconnection.getConnection();
				String thissql = sql_retrieve2_1;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_2", e);
				return bean;
			}
			finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_2", sqle);
				}
			}
		}

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();
				conn=dbconnection.getConnection();

				String thissql = sql_save2_2;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS1a());
				stmt.setString(2, frm.getS1b());
				stmt.setString(3, frm.getS1c());

				stmt.setDate(4, dateconverter.convertdate(frm.getS1d_dob_day(),
						frm.getS1d_dob_month(), frm.getS1d_dob_year()));
				stmt.setString(5, frm.getS1e());
				stmt.setString(6, frm.getS1f_addr1());
				stmt.setString(7, frm.getS1f_addr2());
				stmt.setString(8, frm.getS1f_addr3());
				stmt.setString(9, frm.getS1f_addr4());
				stmt.setString(10, frm.getS1f_postcode());
				stmt.setString(11, frm.getS1g());
				// stmt.setDate(25, frm.getS1p());
				stmt.setString(12, frm.getS1f_email());
				stmt.setString(13, security_token);

				stmt.executeUpdate();
				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_2", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);

					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_2", sqle);
				}
			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_3.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_3(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

        logger.info("Entering IAFT2_3");

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		IAFT2Bean bean = new IAFT2Bean();
		IAFT2Bean bean_amount = new IAFT2Bean();
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();
				conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				String thissql11 = sql_update3_2urn;
				stmt = conn.prepareStatement(thissql);
				stmt1 = conn.prepareStatement(thissql11);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_3", e);
				return bean;
			}
			finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closePreparedStatement(stmt1);

					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_3", sqle);
				}
			}
		}

		if (action == "save") {
            logger.info("the bean appeal_type is : " + bean_amount.getAppeal_type());
            logger.info("the  bean_amount.getQb_lsc is : " + bean_amount.getQb_lsc());
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save2_3;
				// stmt = conn.prepareStatement(thissql);
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



				frm.setS2e(dateconverter.convertdate(frm.getS2e_day(), frm
						.getS2e_month(), frm.getS2e_year()));
				frm.setS2i(dateconverter.convertdate(frm.getS2i_day(), frm.getS2i_month(),
						frm.getS2i_year()));
				stmt.setDate(6, dateconverter.convertdate(frm.getS2e_day(), frm
						.getS2e_month(), frm.getS2e_year()));
				stmt.setDate(7,frm.getS2i());

				stmt.setString(8, security_token);
				bean_amount = QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);
				// stmt1.setString(5, "IAFT1");

                logger.info("The returnStringAmount_paper is : " + Helper.returnStringAmount_paper(frm.getS2e().toString()));
                logger.info("the bean appeal_type is : " + bean_amount.getAppeal_type());

				if (Helper.returnStringAmount_paper(frm.getS2e().toString()) == 0
						|| !bean_amount.getQb_lsc().equals("No")
						) {
					frm.setSubmissionURN(bean_amount.getSubmissionURN()
							.substring(0, 2)
							+ "99"
							+ bean_amount.getSubmissionURN().substring(4));
					stmt1.setString(1, frm.getSubmissionURN());
					stmt1.setString(2, frm.getSubmissionURN());
					stmt1.setInt(3, 0);
					stmt1.setString(4, security_token);
					stmt1.executeUpdate();
				} else {

					if (bean_amount.getAppeal_type().equals("Oral")
							&& bean_amount.getQb_lsc().equals("No")) {

						stmt1.setString(1, bean_amount.getSubmissionURN());
						stmt1.setString(2, bean_amount.getSubmissionURN());
						stmt1.setInt(3, Helper.returnStringAmount_oral(frm
								.getS2e().toString()));
						stmt1.setString(4, security_token);
						stmt1.executeUpdate();
					}
					if (bean_amount.getAppeal_type().equals("Paper")
							&& bean_amount.getQb_lsc().equals("No")) {

						stmt1.setString(1, bean_amount.getSubmissionURN());
						stmt1.setString(2, bean_amount.getSubmissionURN());
						stmt1.setInt(3, Helper.returnStringAmount_paper(frm
								.getS2e().toString()));
						stmt1.setString(4, security_token);
						stmt1.executeUpdate();
					}

				}
				// else for amount 0 if LSC remission is entered.

				stmt.executeUpdate();
				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_3", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closePreparedStatement(stmt1);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_3", sqle);
				}

			}
		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_4.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_4(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT2Bean bean = new IAFT2Bean();
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_4", e);
				return bean;
			}
			finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_4", sqle);
				}
			}
		}

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save2_4;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS3a());
				stmt.setString(2, frm.getS3b());
				stmt.setString(3, frm.getS3c());

				// stmt.setDate(4,
				// dateconverter.convertdate(frm.getS1d_dob_day(),
				// frm.getS1d_dob_month(), frm.getS1d_dob_year()));

				stmt.setString(4, security_token);

				stmt.executeUpdate();
				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_4", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_4", sqle);
				}
			}

		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_5.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_5(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		IAFT2Bean bean = new IAFT2Bean();
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_5", e);
				return bean;
			}
			finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT2_5 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_5", sqle);
				}
			}
		}

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
				String thissql1 = sql_save2_5_1;
				stmt1 = conn.prepareStatement(thissql1);
				stmt1.setString(1, frm.getS3d_1());
				stmt1.setString(2, security_token);
				stmt1.executeUpdate();
				return QueryBuilder2.IAFT2_6(frm, action, datasource,
						security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_5", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT2_5 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_5", sqle);
				}
			}

		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_6.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_6(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		IAFT2Bean bean = new IAFT2Bean();
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_6", e);
				return bean;
			}finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT2_6 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_6", sqle);
				}
			}
		}
		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save2_6;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS3f_who());
				stmt.setString(2, frm.getS3f_language());
				stmt.setString(3, frm.getS3f_dialect());
				stmt.setString(4, frm.getS3g());
				stmt.setString(5, frm.getS3d_1());
				stmt.setString(6, frm.getS3e());
				if (frm.getS3e_date1_day() != 0) {
					stmt.setDate(7, dateconverter.convertdate(frm
							.getS3e_date1_day(), frm.getS3e_date1_month(), frm
							.getS3e_date1_year()));
					stmt.setString(8, frm.getS3e_appealno1());
				} else {
					stmt.setDate(7, null);
					stmt.setString(8, frm.getS3e_appealno1());

				}
				if (frm.getS3e_date2_day() != 0) {
					stmt.setDate(9, dateconverter.convertdate(frm
							.getS3e_date2_day(), frm.getS3e_date2_month(), frm
							.getS3e_date2_year()));
					stmt.setString(10, frm.getS3e_appealno2());
				} else {
					stmt.setDate(9, null);
					stmt.setString(10, frm.getS3e_appealno2());

				}
				if (frm.getS3e_date3_day() != 0) {
					stmt.setDate(11, dateconverter.convertdate(frm
							.getS3e_date3_day(), frm.getS3e_date3_month(), frm
							.getS3e_date3_year()));
					stmt.setString(12, frm.getS3e_appealno3());
				} else {
					stmt.setDate(11, null);
					stmt.setString(12, frm.getS3e_appealno3());
				}
				stmt.setString(13, frm.getS3f());
				stmt.setString(14, security_token);
				stmt.executeUpdate();
				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_6", e);
				return bean;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_6", sqle);
				}
			}

		} else {
			return bean;
		}
	}

	/**
	 * IAF t2_7.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_7(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_7", e);
			}
			finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);
					QueryBuilder.closeConnection(conn);
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_7", sqle);
				}
			}
		}

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_save2_7;
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

				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);

			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_7", e);
				return frm;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_7", sqle);
				}
			}

		} else {
			return frm;
		}
	}

	/**
	 * IAF t2_8.
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
	 * @return the string
	 */
	public static String IAFT2_8(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (action == "retrieve") {
			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();

				String thissql = sql_retrieve2_3;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, security_token);
				rs = stmt.executeQuery();
				while (rs.next()) {
					frm.setAppeal_type(rs.getString("hearing_type"));
					frm.setQb_LAR(rs.getString("qb_LAR"));
				}

			}

			catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_8", e);
				return "failure";
			}finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_8", sqle);
				}
			}
		}

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
				String thissql = sql_save2_8;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getS6a());
				stmt.setString(2, frm.getS6b());
				stmt.setString(3, frm.getS6c());
				stmt.setString(4, frm.getS6d_addr1());
				stmt.setString(5, frm.getS6d_addr2());
				stmt.setString(6, frm.getS6d_addr3());
				stmt.setString(7, frm.getS6d_addr4());
				stmt.setString(8, frm.getS6d_postcode());
				stmt.setString(9, frm.getS6e());
				stmt.setString(10, frm.getS6f());
				stmt.setString(11, frm.getS6_auth());
				stmt.setString(12, security_token);
				stmt.executeUpdate();
			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_8", e);
				return "failure";
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_8", sqle);
				}
			}

			return "success";
		} else {
			return "success";
		}
	}

	/**
	 * IAF t2_9.
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
	 * @return the iAF t2 bean
	 */
	public static IAFT2Bean IAFT2_9(IAFT2Bean frm, String action,
			DataSource datasource, String security_token, HttpServletRequest req) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		if (action == "save") {

			try {
				DBConnection dbconnection = new DBConnection();conn=dbconnection.getConnection();
				String thissql = sql_save2_rep;
				stmt = conn.prepareStatement(thissql);
				stmt.setString(1, frm.getHave_rep());
				stmt.setString(2, frm.getHave_sponsor());
				stmt.setString(3, frm.getS4_decalaration());
				stmt.setString(4, security_token);
				stmt.executeUpdate();
				return QueryBuilder2.retrieve(frm, action, datasource,
						security_token, req);

			} catch (Exception e) {
				logger.error("QueryBuilder2.IAFT2_9", e);
				return frm;
			} finally {
				try {
					QueryBuilder.closeResultSet(rs);
					QueryBuilder.closePreparedStatement(stmt);


					QueryBuilder.closeConnection(conn);
					logger.debug("\t\tMethod: IAFT1_2 Status:Save End");
				} catch (SQLException sqle) {
					logger.error("QueryBuilder2.IAFT2_9", sqle);
				}
			}

		} else {
			return frm;
		}
	}

}
