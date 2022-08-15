package com.MOJICT.IACFee.Actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;

public class PDFReturnAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PDFReturnAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		IAFT1Bean frm = (IAFT1Bean) form;
		IAFT2Bean frm2 = (IAFT2Bean) form;
		IAFT3Bean frm3 = (IAFT3Bean) form;
		IAFT5Bean frm5 = (IAFT5Bean) form;
		IAFT6Bean frm6 = (IAFT6Bean) form;
		IAFT7Bean frm7 = (IAFT7Bean) form;
		ServletContext context = servlet.getServletContext();
		String path = context.getRealPath("/");
		DataSource datasource = getDataSource(request);
		String stoken = "";
		String payment = "failure";

		logger.info("PDFReturnAction.execute");

		try {
			// datasource = getDataSource(request);
			payment = "Success";
			stoken = request.getSession().getAttribute("token").toString();
			request.getSession().setAttribute("security", stoken);
			if(request.getParameter("oid")!=null)
			{
			//string oid=GenericQueryBuilder.getFormBeanBySecurityToken(stoken, datasource);
			request.setAttribute("oid", request.getParameter("oid").toString());
			logger.debug("Oid value from success is from request"+request.getParameter("oid").toString());
			// logger.debug("The order id from posturl is"+request.getParameter("oid").toString()+"MMMMMMMMMMMMMMMMMMMMM"+stoken);
			}
			else
			{
				logger.debug("Oid value from success is from session"+request.getSession().getAttribute("oid").toString());
				request.setAttribute("oid", request.getSession().getAttribute("oid").toString());
			}
			GenericQueryBuilder.setTransactionstatus(request.getSession().getAttribute("oid").toString(), datasource, payment,
					request);
		} catch (Exception e) {
			// datasource = getDataSource(request);
				
			payment = "Success";
			if(request.getParameter("oid")!=null)
			{
			request.setAttribute("oid", request.getParameter("oid").toString());
			logger.debug("Oid value from exception is from request"+request.getParameter("oid").toString());
			// logger.debug("The order id from posturl is"+request.getParameter("oid").toString()+"MMMMMMMMMMMMMMMMMMMMM"+stoken);
			}
			else
			{
				request.setAttribute("oid", request.getSession().getAttribute("oid").toString());
				logger.debug("Oid value from exception is from session"+request.getSession().getAttribute("oid").toString());
			}
			GenericQueryBuilder.setTransactionstatus(request.getSession().getAttribute("oid").toString(), datasource, payment,
					request);
			// e.printStackTrace();
		}

		// logger.debug(request.getParameter("transactionstatus")+"Trabsaction status [[[[[[[[[[[]]]]]]]]]]]]]]]]]");

		// logger.debug("In class token---->"+token);

		// Assumptions
		String security = request.getSession().getAttribute("token").toString();
		boolean payment1;
		if (payment.equals("Success")) {
			payment1 = true;
		} else {
			payment1 = false;
		}
		// logger.debug("???????????"+payment1);
		

		try {
			GenericQueryBuilder.setTransactionstatus(request.getAttribute("oid").toString(), datasource,"Success",request);
			String URN = "";
			String AggrURN = "";
			if (QueryBuilder.IAFT1_1(frm, "retrieve", datasource, security, request).getAppeal_type() != null) {
				frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, security, request);
				// logger.debug("IAFT1 Aggregated payment URN is"+frm.getAggregatedpaymentURN());
				URN = frm.getSubmissionURN();
				AggrURN = frm.getAggregatedpaymentURN();
			} else if (QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, security, request).getAppeal_type() != null) {
				frm2 = QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, security, request);
				URN = frm2.getSubmissionURN();
				AggrURN = frm2.getAggregatedpaymentURN();
			} else if (QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, security, request).getAppeal_type() != null) {
				
				frm3 = QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, security, request);
				URN = frm3.getSubmissionURN();
				AggrURN = frm3.getAggregatedpaymentURN();
			}
		 else if (QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, security, request).getAppeal_type() != null) {
			 {
				 frm5 = QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, security, request);
					URN = frm5.getSubmissionURN();
					AggrURN = frm5.getAggregatedpaymentURN();
				 }
			 }
		 else if (QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, security, request).getAppeal_type() != null) {
			 {
				 frm6 = QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, security, request);
					URN = frm6.getSubmissionURN();
					AggrURN = frm6.getAggregatedpaymentURN();
				 }
			 }
		 else if (QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, security, request).getAppeal_type() != null) {
			 {
				 frm7 = QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, security, request);
					URN = frm7.getSubmissionURN();
					AggrURN = frm7.getAggregatedpaymentURN();
				 }
			 }

			if (AggrURN != null) {
				// logger.debug(">>>>>>>>>>>>>>>>>>>>"+AggrURN);
				// rs=QueryBuilder.getAggregatedsubmission(datasource, AggrURN);
				// while(rs.next())
				// {
				// security=rs.getString("securitytoken");
				// URN = rs.getString("submissionURN");
				// String type=rs.getString("formname");

				ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder.getAggregatedsubmission(datasource,
						AggrURN);
				for (AggregatedSubmissionBean asBean : asBeansArrayList) {
					security = asBean.getSecuritytoken();
					URN = asBean.getUrn();
					logger.debug("Arraylist size is " + asBeansArrayList.size());
					String type = asBean.getType();
					if (!payment1) {

						logger.debug("payment false" + request.getParameter("transactionstatus").toString());
					}
					
					// Generate pdf file

					if (payment1 == true) {
						GenericQueryBuilder.setTransactionstatus(AggrURN, datasource,"Success",request);
						
						// XML Generation
						if (type.equals("IAFT1")) {

							frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, security, request);
							DocWriteDOM.getxmlnewappeal(frm, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path,
									"true", frm);
							Helper.savePDF(baos, URN, path);
						} else if (type.equals("IAFT2")) {
							logger.debug("2");
							frm2 = QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, security, request);
							// logger.debug(frm2.getS3f());
							DocWriteDOM.getxmlnewappeal(frm2, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path,
									"true", frm2);
							Helper.savePDF(baos, URN, path);
						} else if (type.equals("IAFT3")) {
							logger.debug("3");
							frm3 = QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, security, request);
							// logger.debug(frm2.getS3f());
							DocWriteDOM.getxmlnewappeal(frm3, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path,
									"true", frm3);
							Helper.savePDF(baos, URN, path);
						}
						else if (type.equals("IAFT5")) {

							frm5 = QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, security, request);
							DocWriteDOM.getxmlnewappeal(frm5, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path,
									"true", frm5);
							Helper.savePDF(baos, URN, path);
						} 
						else if (type.equals("IAFT6")) {

							frm6 = QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, security, request);
							DocWriteDOM.getxmlnewappeal(frm6, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path,
									"true", frm6);
							Helper.savePDF(baos, URN, path);
						} 
						else if (type.equals("IAFT7")) {

							frm7 = QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, security, request);
							DocWriteDOM.getxmlnewappeal(frm7, request, URN);

							// Saving pdf file
							ByteArrayOutputStream baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path,
									"true", frm7);
							Helper.savePDF(baos, URN, path);
						} 
					
					}
					
					else {
						ByteArrayOutputStream baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path,
								"false", frm);
						// count=0;
						// request.getSession().setAttribute("count", count);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						// ByteArrayOutputStream baos =
						// com.MOJICT.IACFee.Util.PDFUtility.GenerateIAFT1PDF(path,payment,frm);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();
					}
				}
			} else {
				frm = null;
				frm2 = null;
				// logger.debug("-----------============>"+security+""+QueryBuilder.IAFT1_1(frm,"retrieve",datasource,security,request));
				if (QueryBuilder.IAFT1_1(frm, "retrieve", datasource, security, request).getAppeal_type() != null) {
					frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, security, request);
					URN = frm.getSubmissionURN();
					if (!payment1) {

						logger.debug("payment false" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm, request, URN);

						// Saving pdf file
						ByteArrayOutputStream baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path,
								"Success", frm);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						ByteArrayOutputStream baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path,
								"Success", frm);
						// count=0;
						// request.getSession().setAttribute("count", count);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();

					}

				}
				if (QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, security, request).getAppeal_type() != null) {
					// logger.debug("coming here");
					frm2 = QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, security, request);
					URN = frm2.getSubmissionURN();

					if (!payment1) {

						logger.debug("payment false222" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm2, request, URN);

						// Saving pdf file
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path,
								"Success", frm2);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path,
								"Success", frm2);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						// count=0;
						// request.getSession().setAttribute("count", count);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();
					}
				}
				//IAFT6
				if (QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, security, request).getAppeal_type() != null) {
					// logger.debug("coming here");
					frm6 = QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, security, request);
					URN = frm6.getSubmissionURN();

					if (!payment1) {

						logger.debug("payment false666" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm6, request, URN);

						// Saving pdf file
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path,
								"Success", frm6);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path,
								"Success", frm6);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						// count=0;
						// request.getSession().setAttribute("count", count);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();
					}
				}

				// IAFT3

				if (QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, security, request).getAppeal_type() != null) {
					// logger.debug("coming here");
					frm3 = QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, security, request);
					URN = frm3.getSubmissionURN();

					if (!payment1) {

						logger.debug("payment false222" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm3, request, URN);

						// Saving pdf file
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path,
								"Success", frm3);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						// logger.debug("???????????????"+path+"?????????????"+URN);
						ByteArrayOutputStream baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path,
								"Success", frm3);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						// count=0;
						// request.getSession().setAttribute("count", count);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();
					}
				}
				if (QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, security, request).getAppeal_type() != null) {
					frm5 = QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, security, request);
					URN = frm5.getSubmissionURN();
					if (!payment1) {

						logger.debug("payment false" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm5, request, URN);

						// Saving pdf file
						ByteArrayOutputStream baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path,
								"Success", frm5);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						ByteArrayOutputStream baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path,
								"Success", frm5);
						// count=0;
						// request.getSession().setAttribute("count", count);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();

					}

				}
				if (QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, security, request).getAppeal_type() != null) {
					frm7 = QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, security, request);
					URN = frm7.getSubmissionURN();
					if (!payment1) {

						logger.debug("payment false" + request.getParameter("transactionstatus").toString());
					}
					// Generate pdf file

					if (payment1 == true) {
						// XML Generation
						DocWriteDOM.getxmlnewappeal(frm7, request, URN);

						// Saving pdf file
						ByteArrayOutputStream baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path,
								"Success", frm7);
						// logger.debug(baos.size()+"???????????????"+path+"?????????????"+URN);
						Helper.savePDF(baos, URN, path);

					} else {
						ByteArrayOutputStream baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path,
								"Success", frm7);
						// count=0;
						// request.getSession().setAttribute("count", count);
						// com.MOJICT.IACFee.Util.PDFUtility.savePDF(baos, URN,
						// path);
						response.setContentType("application/pdf");
						response.setContentLength(baos.size());
						ServletOutputStream out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();

					}

				}
			}

			// count=0;
			// request.getSession().setAttribute("count", count);

			return mapping.findForward("success");

		} catch (Exception ex) {
			logger.error("PDFReturnAction.execute - ", ex);
			return mapping.findForward("failure");
		}

	}
}