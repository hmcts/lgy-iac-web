package com.MOJICT.IACFee.Actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
public class XMLReturnAction extends Action {

	public static final String IAFT1 = "IAFT1";
	public static final String IAFT2 = "IAFT2";
	public static final String IAFT3 = "IAFT3";
	public static final String IAFT5 = "IAFT5";
	public static final String IAFT6 = "IAFT6";
	public static final String IAFT7 = "IAFT7";
	public static final String TOP_UP_TYPE = "2";
	public static final String TRANSACTION_SUCCESS = "Success";
	public static final String TRANSACTION_FAILURE = "failure";
	public DataSource datasource = null;
	public String status=null;

	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(XMLReturnAction.class);

	/**
	 *
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, Exception {
		logger.info("XMLReturnAction.execute - Testing action!");
		datasource = getDataSource(request);
		String transactionStatus = "";
		String orderId = null;
		ActionForward actionForward = null;
		if(SHAUtil.validateresponse(request.getParameter("ACCEPTANCE").toString(), request.getParameter("amount").toString(), request.getParameter("BRAND").toString(), request.getParameter("CARDNO").toString(),request.getParameter("CN").toString(), request.getParameter("currency").toString(),request.getParameter("ED").toString(),request.getParameter("IP").toString(), request.getParameter("NCERROR").toString(), request.getParameter("orderID").toString(), request.getParameter("PAYID").toString(), request.getParameter("PM").toString(), request.getParameter("STATUS").toString(),request.getParameter("TRXDATE").toString(), request.getParameter("SHASIGN").toString()))
		{
		String tstatusrequest=request.getParameter("STATUS").toString();
		String transactionstatusrequest;
		if(tstatusrequest.equals("5")||tstatusrequest.equals("9"))
		{
			transactionstatusrequest="Success";

		}
		else
		{
			transactionstatusrequest="failure";
		}
		if(request.getParameter("orderID")!=null)
		{
			logger.debug("cmg here");
		 orderId = request.getParameter("orderID").toString();
		}
		else
		{
			logger.debug("cmg from seesion");
			orderId=request.getSession().getAttribute("oid").toString();
			setTransactionstatus(orderId, request, "failed");
		}

		if(gettransactionstatus(orderId)!=null)
		{

			transactionStatus = transactionstatusrequest;
			int count=gettransactioncount(orderId);
			 request.getSession().setAttribute("count", count);
			 status=transactionStatus;

		}

		else if(gettransactionstatustopup(orderId)!=null)
		{

			transactionStatus = transactionstatusrequest;
			logger.debug("topup transaction status is top up"+transactionStatus);
			 status=transactionStatus;

		}
		else if(gettransactionstatus(orderId)==null&&gettransactionstatustopup(orderId)==null)
		{
			logger.debug("coming here in null transaction status");
			transactionStatus = transactionstatusrequest;
			logger.debug("topup transaction status is"+transactionStatus);
			 status=transactionStatus;

		}

		transactionStatus = transactionstatusrequest;
		 status=transactionStatus;

		// handleCountingFunctionality(request, transactionStatus);
		if (transactionStatus.equals(TRANSACTION_SUCCESS)) {
			transactionStatus = transactionstatusrequest;
			logger.debug("Going to set order id");
			GenericQueryBuilder.setTransactionstatustopup(orderId, datasource,transactionStatus,request);
			setTransactionstatus(orderId, request, transactionStatus);
			// setTransactionscount(orderId, request);
			request.setAttribute("oid", request.getParameter("orderID").toString());
			actionForward = processTopUpPayments(mapping, orderId, request);
			setSecurityToken(orderId, request);
			logger.debug("Going to set top up  payment");

			if (null == actionForward) {
				logger.debug("Going to set action forward" + transactionStatus);
				actionForward = handleSuccessPaymentForwardProcessing(request,
						response, mapping);
			}
		}
		else if (transactionStatus.equals("Not Known")|| transactionStatus.equals("null")||transactionStatus.equals("NULL")) {

			logger.debug("Going to set order id");
			//setTransactionstatus(orderId, request, transactionStatus);
			// setTransactionscount(orderId, request);
			setSecurityToken(orderId, request);
			logger.debug("Going to set top up  payment");
			request.setAttribute("oid", request.getParameter("orderID").toString());
			actionForward = processTopUpPayments(mapping, orderId, request);
			if (null == actionForward) {
				logger.debug("Going to set action forward" + transactionStatus);
				//Status passed as NULL
				actionForward = handlenullPaymentForwardProcessing(request,
						response, mapping);
			}
		}

		else if (!transactionStatus.equals(TRANSACTION_SUCCESS)&&!transactionStatus.equals("Not Known")&& !transactionStatus.equals("null")&& !transactionStatus.equals("NULL")&& !transactionStatus.equals("failed")) {
			logger.debug("coming to failure payment handling");
			if (request.getParameter("orderID") != null) {
				orderId = request.getParameter("orderID").toString();
				actionForward = processTopUpPayments(mapping, orderId, request);
				if(null==actionForward)
				{
					GenericQueryBuilder.setTransactionstatustopup(orderId, datasource,transactionStatus,request);
				setTransactionstatus(orderId, request, transactionStatus);
				//Status passed as false
				ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder
						.getAggregatedsubmissiontoken(datasource, orderId);
				request.getSession().setAttribute("list", asBeansArrayList);
				setSecurityToken(orderId, request);
				actionForward = handleFailedPaymentForwardProcessing(
						transactionStatus, request, mapping);
				}
				else
				{

					if(actionForward.equals(mapping.findForward("Success_topup")))
					{
						logger.debug("coming to successw");
					actionForward = mapping.findForward("Success_topup");
					}
					else
					{
						logger.debug("coiming to failure ");
						actionForward = mapping.findForward("return_topupfailure");
					}
				}
				request.setAttribute("oid", request.getParameter("orderID")
						.toString());
			} else {
				actionForward = mapping.findForward("return_pdf");
			}
			logger.debug("coming to failure payment handling" + actionForward);
		}


		else {
			orderId = request.getParameter("oid").toString();
			setSecurityToken(orderId, request);
			logger.debug("Invalid transaction status:" + transactionStatus
					+ "and order id is" + orderId);
			logger.debug("Invalid transaction status:" + transactionStatus
					+ "and order id is" + orderId);
			ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder
					.getAggregatedsubmissiontoken(datasource, orderId);
			request.getSession().setAttribute("list", asBeansArrayList);

			logger.debug("Arraylist set in request" + asBeansArrayList.size());



			actionForward = mapping.findForward("return_pdf");


		}
		}else
		{
		orderId = request.getParameter("orderID").toString();
		setSecurityToken(orderId, request);
		logger.debug("Invalid transaction status:" + transactionStatus
				+ "and order id is" + orderId);
		logger.debug("Invalid transaction status:" + transactionStatus
				+ "and order id is" + orderId);
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder
				.getAggregatedsubmissiontoken(datasource, orderId);
		request.getSession().setAttribute("list", asBeansArrayList);

		logger.debug("Arraylist set in request" + asBeansArrayList.size());


			actionForward = mapping.findForward("return_pdf");
		}

		return actionForward;
	}


	//////////////////////////////////////.....................
	/**
	 * The payment has been successful so now the appeal(s) need to have a PDF
	 * output (the appeal) and an XML payment record
	 *
	 * @param request
	 * @param response
	 * @param mapping
	 * @return
	 */
	private ActionForward handleSuccessPaymentForwardProcessing(
			HttpServletRequest request, HttpServletResponse response,
			ActionMapping mapping) {

		ActionForward actionForward = null;
		try {
			IAFTBean iBean = IAFTBeanFactory.getBeanInstance(request
					.getSession().getAttribute("security").toString(),
					datasource, request);
			String AggrURN = iBean.getAggregatedpaymentURN();
			logger.debug("Aggeagted payment is generated" + AggrURN
					+ "Filename is ");
			String path = servlet.getServletContext().getRealPath("/");

			logger.debug("Aggeagted payment is generated" + AggrURN
					+ "Filename is " + path);

			if (AggrURN != null && !AggrURN.equals("")) {
				this.processOutputsForAggregatedAppeals(AggrURN, true, request,
						path, response);
			} else {
				this.processOutputForSingleAppeal(iBean, true, request,
						response, path);
			}
			actionForward = mapping.findForward("success");
		} catch (Exception ex) {
			logger.error("XMLReturnAction.handleSuccessPaymentForwardProcessing - ", ex);
			actionForward = mapping.findForward("failure");
		}
		return actionForward;
	}


	private ActionForward handlenullPaymentForwardProcessing(
			HttpServletRequest request, HttpServletResponse response,
			ActionMapping mapping) {

		ActionForward actionForward = null;
		try {
			IAFTBean iBean = IAFTBeanFactory.getBeanInstance(request
					.getSession().getAttribute("security").toString(),
					datasource, request);
			String AggrURN = iBean.getAggregatedpaymentURN();
			logger.debug("Aggeagted payment is generated" + AggrURN
					+ "Filename is ");
			String path = servlet.getServletContext().getRealPath("/");

			logger.debug("Aggeagted payment is generated" + AggrURN
					+ "Filename is " + path);
			if (AggrURN != null && !AggrURN.equals("")) {
				this.processOutputsForAggregatedNullAppeals(AggrURN, true, request,
						path, response);
			} else {
				this.processOutputForSingleNullAppeal(iBean, true, request,
						response, path);
			}
			actionForward = mapping.findForward("Statusunknown");

		} catch (Exception ex) {
			logger.error("XMLReturnAction.handlenullPaymentForwardProcessing - ", ex);
			actionForward = mapping.findForward("failure");
		}
		return actionForward;
	}

	private void processOutputsForAggregatedNullAppeals(String AggrURN,
			boolean payment1, HttpServletRequest request, String path,
			HttpServletResponse response) throws IOException, DocumentException {

        logger.info("processOutputsForAggregatedNullAppeals: path <" + path + ">");

		ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder
				.getAggregatedsubmission(datasource, AggrURN);
		for (AggregatedSubmissionBean asBean : asBeansArrayList) {
			String security = asBean.getSecuritytoken();
			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();
			IAFTBean iAggBean = IAFTBeanFactory.getBeanInstance(security,
					datasource, request);
			ByteArrayOutputStream baos = null;
			try {
				if (type.equals("IAFT1")) {
					IAFT1Bean aggBean = (IAFT1Bean) iAggBean;
					logger.debug(aggBean.getPaymentvalue());

					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					logger.debug("Its coming here in IAFT1" + IAFT1);
					baos = PDFUtilityIAFT1
							.GenerateIAFT1PDF(path, status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				} else if (type.equals("IAFT2")) {
					IAFT2Bean aggBean = (IAFT2Bean) iAggBean;

					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					baos = PDFUtilityIAFT2
							.GenerateIAFT2PDF(path, status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				} else if (type.equals("IAFT3")) {
					IAFT3Bean aggBean = (IAFT3Bean) iAggBean;
					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					baos = PDFUtilityIAFT3
							.GenerateIAFT3PDF(path,status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				}
				else if (type.equals("IAFT5")) {
					IAFT5Bean aggBean = (IAFT5Bean) iAggBean;
					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					baos = PDFUtilityIAFT5
							.GenerateIAFT5PDF(path,status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				}
				else if (type.equals("IAFT6")) {
					IAFT6Bean aggBean = (IAFT6Bean) iAggBean;
					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					baos = PDFUtilityIAFT6
							.GenerateIAFT6PDF(path,status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				}
				else if (type.equals("IAFT7")) {
					IAFT7Bean aggBean = (IAFT7Bean) iAggBean;
					DocWriteDOM.getxmlnewappeal(aggBean, request, URN);
					baos = PDFUtilityIAFT7
							.GenerateIAFT7PDF(path,status, aggBean);
					Helper.savePDF(baos, URN, paymentURN, path);
				}
			} finally {
				if (null != baos) {
					baos.close();
				}
			}
		}
	}

	/**
	 * Produce a PDF output and XML payment record for the appeal
	 *
	 * @param iBean
	 * @param payment1
	 * @param request
	 * @param response
	 * @param path
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void processOutputForSingleNullAppeal(IAFTBean iBean, boolean payment1,
			HttpServletRequest request, HttpServletResponse response,
			String path) throws IOException, DocumentException {
		String URN = iBean.getSubmissionURN();
		ByteArrayOutputStream baos = null;

        logger.info("processOutputForSingleNullAppeal: path <" + path + ">");

		try {
			if (iBean.getType().equals(IAFT1)) {
				IAFT1Bean frm = (IAFT1Bean) iBean; //payment1
				baos = PDFUtilityIAFT1.GenerateIAFT1PDF(
						path, status, frm);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			} else if (iBean.getType().equals(IAFT2)) {
				IAFT2Bean frm2 = (IAFT2Bean) iBean;
				baos = PDFUtilityIAFT2.GenerateIAFT2PDF(
						path, status, frm2);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm2, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			} else if (iBean.getType().equals(IAFT3)) {
				IAFT3Bean frm3 = (IAFT3Bean) iBean;
				baos = PDFUtilityIAFT3.GenerateIAFT3PDF(
						path, status, frm3);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm3, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			}
			 else if (iBean.getType().equals(IAFT5)) {
					IAFT5Bean frm5 = (IAFT5Bean) iBean;
					baos = PDFUtilityIAFT5.GenerateIAFT5PDF(
							path, status, frm5);
					if (payment1) {
						DocWriteDOM.getxmlnewappeal(frm5, request, URN);
						Helper.savePDF(baos, URN, path);
						return;
					}
				}
			 else if (iBean.getType().equals(IAFT6)) {
					IAFT6Bean frm6 = (IAFT6Bean) iBean;
					baos = PDFUtilityIAFT6.GenerateIAFT6PDF(
							path, status, frm6);
					if (payment1) {
						DocWriteDOM.getxmlnewappeal(frm6, request, URN);
						Helper.savePDF(baos, URN, path);
						return;
					}
				}
			 else if (iBean.getType().equals(IAFT7)) {
					IAFT7Bean frm7 = (IAFT7Bean) iBean;
					baos = PDFUtilityIAFT7.GenerateIAFT7PDF(
							path, status, frm7);
					if (payment1) {
						DocWriteDOM.getxmlnewappeal(frm7, request, URN);
						Helper.savePDF(baos, URN, path);
						return;
					}
				}
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
		} finally {
			if (null != baos) {
				baos.close();
			}
		}

	}



	/**
	 * If the session contains a count then this needs to be incremented until a
	 * successful payment is reached or a trigger is reached to indicate that a
	 * printable PDF should be offered
	 *
	 * @param request
	 * @param payment
	 * @return
	 */
	private void handleCountingFunctionality(HttpServletRequest request,
			String transactionStatus) {
		int count;
		String payment = "false";
		try {
			// if a count already exists on the session then it needs to be
			// incremented
			count = Integer.parseInt(request.getSession().getAttribute("count")
					.toString()) + 1;
		} catch (NullPointerException e) {
			// assume exception caused by not setting count
			count = 1;
		}
		if (count < 5) {
			if (transactionStatus.equals("Success")) {
				count = 0;
				payment = "true";
			} else {
				payment = "false";
			}
		} else if (count >= 5) {
			payment = "false";
		}
		request.getSession().setAttribute("payment", payment);
		request.getSession().setAttribute("count", count);
	}

	/**
	 * Produce A PDF and xml for each appeal output must now be produced for
	 * each appeal
	 *
	 * @param datasource
	 * @param AggrURN
	 * @param payment1
	 * @param request
	 * @param path
	 * @param response
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void processOutputsForAggregatedAppeals(String AggrURN, boolean payment1, HttpServletRequest request,
			String path, HttpServletResponse response) throws IOException, DocumentException {
		ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder
				.getAggregatedsubmission(datasource, AggrURN);

        logger.info("processOutputsForAggregatedAppeals: path <" + path + ">");

		int count=0,position=0;
		for(int i=0;i<asBeansArrayList.size();i++)
		{
			if(asBeansArrayList.get(i).getAmount()!=0)
			{
				count++;
				position=i;
			}
		}
		for (AggregatedSubmissionBean asBean : asBeansArrayList) {
			String security = asBean.getSecuritytoken();
			String URN = asBean.getUrn();
			String type = asBean.getType();
			String paymentURN = asBean.getPaymenturn();
			IAFTBean iAggBean = IAFTBeanFactory.getBeanInstance(security, datasource, request);
			ByteArrayOutputStream baos = null;
			try {
				String URNaggr=paymentURN+"_"+URN;
				if (type.equals("IAFT1")) {
					IAFT1Bean aggBean = (IAFT1Bean) iAggBean;
					logger.debug(aggBean.getPaymentvalue());

				         if(asBean.getAmount()==0)
				         {
				        	 URN=URN.replaceFirst("77","99");
				        	 baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);

				        	 Helper.savePDF(baos, URN, path);
				        	 aggBean.setSubmissionURN(URN);
				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
				         }
				         else
				         {
				        	 if(count==1)
				        	 {
				        		 aggBean.setAggregatedpaymentURN(null);
				        		 URN=URN.replaceFirst("77","88");
				        		 aggBean.setSubmissionURN(URN);
					        	 aggBean.setPaymentURN(URN);
					        	 baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);

					        	 Helper.savePDF(baos, URN, path);


					        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
				        	 }
				        	 else
				        	 {
				        		 baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
				        		 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
									logger.debug("Its coming here in IAFT1" + IAFT1);
									//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
									Helper.savePDF(baos, URN, paymentURN, path);
				        	 }
				         }
				}
				else if (type.equals("IAFT2")) {
					IAFT2Bean aggBean = (IAFT2Bean) iAggBean;

					 if(asBean.getAmount()==0)
			         {
			        	 URN=URN.replaceFirst("77","99");
			        	 baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path, status, aggBean);
			        	 Helper.savePDF(baos, URN, path);
			        	 aggBean.setSubmissionURN(URN);
			        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
			         }
					 else
			         {
			        	 if(count==1) {
                             aggBean.setAggregatedpaymentURN(null);
                             URN=URN.replaceFirst("77","88");
                             aggBean.setSubmissionURN(URN);
                             aggBean.setPaymentURN(URN);
                             baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path, status, aggBean);
                             Helper.savePDF(baos, URN, path);
                             DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
                         } else {
                             DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
                             logger.debug("Its coming here in IAFT1" + IAFT1);
                             baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path, status, aggBean);
							Helper.savePDF(baos, URN, paymentURN, path);
			        	}
			        }
				 }
				 else if (type.equals("IAFT3")) {
					IAFT3Bean aggBean = (IAFT3Bean) iAggBean;

					 if(asBean.getAmount()==0)
			         {
			        	 URN=URN.replaceFirst("77","99");
			        	 baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
			        	 Helper.savePDF(baos, URN, path);
			        	 aggBean.setSubmissionURN(URN);
			        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
			         }
					 else
					 {
						 if(count==1)
						 {
							 aggBean.setAggregatedpaymentURN(null);
			        		 URN=URN.replaceFirst("77","88");
				        	 aggBean.setSubmissionURN(URN);
				        	 aggBean.setPaymentURN(URN);
				        	 baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
				        	 Helper.savePDF(baos, URN, path);

				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
						 }
						 else
						 {
							 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
								logger.debug("Its coming here in IAFT1" + IAFT1);
								baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
								//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
								Helper.savePDF(baos, URN, paymentURN, path);
						 }
					 }
				 }


				 else if (type.equals("IAFT5")) {
						IAFT5Bean aggBean = (IAFT5Bean) iAggBean;

						 if(asBean.getAmount()==0)
				         {
				        	 URN=URN.replaceFirst("77","99");
				        	 baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path, status, aggBean);
				        	 Helper.savePDF(baos, URN, path);
				        	 aggBean.setSubmissionURN(URN);
				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
				         }
						 else
						 {
							 if(count==1)
							 {
								 aggBean.setAggregatedpaymentURN(null);
				        		 URN=URN.replaceFirst("77","88");
					        	 aggBean.setSubmissionURN(URN);
					        	 aggBean.setPaymentURN(URN);
					        	 baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path, status, aggBean);
					        	 Helper.savePDF(baos, URN, path);

					        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
							 }
							 else
							 {
								 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
									logger.debug("Its coming here in IAFT5" + IAFT5);
									baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path, status, aggBean);
									//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
									Helper.savePDF(baos, URN, paymentURN, path);
							 }
						 }
					 }
				 else if (type.equals("IAFT6")) {
						IAFT6Bean aggBean = (IAFT6Bean) iAggBean;

						 if(asBean.getAmount()==0)
				         {
				        	 URN=URN.replaceFirst("77","99");
				        	 baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path, status, aggBean);
				        	 Helper.savePDF(baos, URN, path);
				        	 aggBean.setSubmissionURN(URN);
				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
				         }
						 else
				         {
				        	 if(count==1)
				        	 {aggBean.setAggregatedpaymentURN(null);
				        	 URN=URN.replaceFirst("77","88");
				        	 aggBean.setSubmissionURN(URN);
				        	 aggBean.setPaymentURN(URN);
				        	 baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path, status, aggBean);
				        	 Helper.savePDF(baos, URN, path);
				        	 //aggBean.setSubmissionURN(URN);
				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);}
				        	 else
				        	 {DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
								logger.debug("Its coming here in IAFT6" + IAFT6);
								baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path, status, aggBean);
								//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
								Helper.savePDF(baos, URN, paymentURN, path);
				        	}
				        }
					 }


			 else if (type.equals("IAFT7")) {
					IAFT7Bean aggBean = (IAFT7Bean) iAggBean;

					 if(asBean.getAmount()==0)
			         {
			        	 URN=URN.replaceFirst("77","99");
			        	 baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path, status, aggBean);
			        	 Helper.savePDF(baos, URN, path);
			        	 aggBean.setSubmissionURN(URN);
			        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
			         }
					 else
			         {
			        	 if(count==1)
			        	 {aggBean.setAggregatedpaymentURN(null);
			        	 URN=URN.replaceFirst("77","88");
			        	 aggBean.setSubmissionURN(URN);
			        	 aggBean.setPaymentURN(URN);
			        	 baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path, status, aggBean);
			        	 Helper.savePDF(baos, URN, path);
			        	 //aggBean.setSubmissionURN(URN);
			        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);}
			        	 else
			        	 {DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
							logger.debug("Its coming here in IAFT6" + IAFT6);
							baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path, status, aggBean);
							//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
							Helper.savePDF(baos, URN, paymentURN, path);
			        	}
			        }
				 }

		     }

					 /*else if(asBeansArrayList.size()>=2&&asBean.getAmount()!=0)
			         {
			        	 if(((AggregatedSubmissionBean)asBeansArrayList.get(0)).getAmount()!=0&&((AggregatedSubmissionBean)asBeansArrayList.get(1)).getAmount()!=0)
			        	 {
			        		 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
								logger.debug("Its coming here in IAFT1" + IAFT1);
								baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
								//baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, status, aggBean);
								Helper.savePDF(baos, URN, paymentURN, path);
			        	 }
			        	 else
			        	 {
			        		 if(asBeansArrayList.size()==2)
			        		 {
			        		 aggBean.setAggregatedpaymentURN(null);
			        		 URN=URN.replaceFirst("77","88");
				        	 aggBean.setSubmissionURN(URN);
				        	 aggBean.setPaymentURN(URN);
				        	 baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
				        	 Helper.savePDF(baos, URN, path);

				        	 DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
			        		 }
			        		 else
			        			 {baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);

							    Helper.savePDF(baos, URN, paymentURN, path);
							    DocWriteDOM.getxmlnewappeal(aggBean, request, paymentURN+"_"+URN);
			        			 }
			        	 }

			         }
			         else
			         {
			        	baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, status, aggBean);
			        	DocWriteDOM.getxmlnewappeal(aggBean, request,  paymentURN+"_"+URN);
					    Helper.savePDF(baos, URN, paymentURN, path);
			         }
				}*/



			 finally {
				if (null != baos) {
					baos.close();
				}
			}
		}
	}


	/**
	 * Produce a PDF output and XML payment record for the appeal
	 *
	 * @param iBean
	 * @param payment1
	 * @param request
	 * @param response
	 * @param path
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void processOutputForSingleAppeal(IAFTBean iBean, boolean payment1,
			HttpServletRequest request, HttpServletResponse response,
			String path) throws IOException, DocumentException {
		String URN = iBean.getSubmissionURN();
		ByteArrayOutputStream baos = null;

        logger.info("processOutputForSingleAppeal: path <" + path + ">");

		try {
			if (iBean.getType().equals(IAFT1)) {
				IAFT1Bean frm = (IAFT1Bean) iBean;  //payment1
				baos = PDFUtilityIAFT1.GenerateIAFT1PDF(
						path,status, frm);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			} else if (iBean.getType().equals(IAFT2)) {
				IAFT2Bean frm2 = (IAFT2Bean) iBean;
				baos = PDFUtilityIAFT2.GenerateIAFT2PDF(
						path, status, frm2);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm2, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			} else if (iBean.getType().equals(IAFT3)) {
				IAFT3Bean frm3 = (IAFT3Bean) iBean;
				baos = PDFUtilityIAFT3.GenerateIAFT3PDF(
						path,status, frm3);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm3, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}

			}
			else if (iBean.getType().equals(IAFT5)) {
				IAFT5Bean frm5 = (IAFT5Bean) iBean;
				baos = PDFUtilityIAFT5.GenerateIAFT5PDF(
						path,status, frm5);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm5, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			}
			else if (iBean.getType().equals(IAFT6)) {
				IAFT6Bean frm6 = (IAFT6Bean) iBean;
				baos = PDFUtilityIAFT6.GenerateIAFT6PDF(
						path,status, frm6);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm6, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			}
			else if (iBean.getType().equals(IAFT7)) {
				IAFT7Bean frm7 = (IAFT7Bean) iBean;
				baos = PDFUtilityIAFT7.GenerateIAFT7PDF(
						path,status, frm7);
				if (payment1) {
					DocWriteDOM.getxmlnewappeal(frm7, request, URN);
					Helper.savePDF(baos, URN, path);
					return;
				}
			}
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
		} finally {
			if (null != baos) {
				baos.close();
			}
		}

	}

	/**
	 * If a payment has been unsuccessfully and less than 5 attempts have been
	 * made then an unsuccessful forward mapping is returned also if a payment
	 * has not been successfully completed in 5 attempts then a pdf to be
	 * printed forward mapping is returned forward mapping is returned
	 *
	 * @param payment
	 * @param request
	 * @param mapping
	 * @return
	 */
	private ActionForward handleFailedPaymentForwardProcessing(
			String transactionStatus, HttpServletRequest request,
			ActionMapping mapping) {
		String forwardMapping = null;
		logger.debug("Its coming in failed payment handling and the count is"
				+ request.getSession().getAttribute("count").toString());

		int count = Integer.parseInt(request.getSession().getAttribute("count")
				.toString());

		if (count < 5) {
			forwardMapping = "return";
		}
		if (count >= 5) {
			forwardMapping = "return_pdf";
		}
		request.setAttribute("oid", request.getParameter("orderID").toString());
		return mapping.findForward(forwardMapping);
	}

	/**
	 * Set the security token on the session bound in two places 'token' and
	 * 'security'
	 *
	 * @param orderId
	 *            the assigned order id from the session
	 * @param datasource
	 * @param request
	 */
	private void setSecurityToken(String orderId, HttpServletRequest request) {
		FormBean bean = GenericQueryBuilder.getFormBeanByOrderId(orderId,
				datasource);
		String securityToken = bean.getSecurityToken();
		request.getSession().setAttribute("token", securityToken);
		request.getSession().setAttribute("security", securityToken);
	}

	private void setTransactionstatus(String orderId,
			HttpServletRequest request, String status) {
		GenericQueryBuilder.setTransactionstatus(orderId, datasource, status,
				request);
		// String securityToken = bean.getSecurityToken();
		// request.getSession().setAttribute("token", securityToken);
		// request.getSession().setAttribute("security", securityToken);
	}

	private void setTransactionstatustopup(String orderId,
			HttpServletRequest request, String status) {
		GenericQueryBuilder.setTransactionstatustopup(orderId, datasource, status,
				request);
		// String securityToken = bean.getSecurityToken();
		// request.getSession().setAttribute("token", securityToken);
		// request.getSession().setAttribute("security", securityToken);
	}
	/**
	 * If this is a top up payment and it is successful only an xml file needs
	 * to be generated.
	 *
	 * @param mapping
	 * @param paymentSucce
	 * @param orderId
	 * @param datasource
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private ActionForward processTopUpPayments(ActionMapping mapping,
			String orderId, HttpServletRequest request) throws IOException {
		ActionForward actionForward = null;

		AggregatedBean frmaggr = (AggregatedBean) Trans_QueryBuilder.gettopup(
				orderId, datasource);
		if (frmaggr.getType().equals(TOP_UP_TYPE)) {
			String status=gettransactionstatustopup(orderId);
			logger.debug("Top up payment XML method"+status);
			if(!status.equals("failure"))
			{
				if (frmaggr.getCount() > 1) {
					DocWriteDOM.getxmlAggregatedpayment(frmaggr, request);
				}
				logger.debug("Top up payment XML method finished");
			}

			if(status.equals("Success"))
			{
			actionForward = mapping.findForward("Success_topup");

			}
			else if(status.equals("Not Known"))
			{
				actionForward = mapping.findForward("Statusunknown");
			}
			else if(status.equals("NULL")||status.equals("null"))
			{
				actionForward = mapping.findForward("Statusunknown");
			}
			else
			{
				actionForward=mapping.findForward("return_topupfailure");
			}
		} else {
			actionForward = null;
		}
		return actionForward;
	}

	private String gettransactionstatus(String orderId) {
		FormBean bean = GenericQueryBuilder.getFormBeanByOrderId(orderId,
				datasource);
		return bean.getTransactionstatus();

	}

	private String gettransactionstatustopup(String orderId) {
		FormBean bean = GenericQueryBuilder.gettopupstatus(orderId,
				datasource);
		return bean.getTransactionstatus();

	}

	private int gettransactioncount(String orderId) {
		FormBean bean = GenericQueryBuilder.getFormBeanByOrderId(orderId,
				datasource);

		return bean.getCount();

	}
}
