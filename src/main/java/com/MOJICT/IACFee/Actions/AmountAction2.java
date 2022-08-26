package com.MOJICT.IACFee.Actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.QueryBuilder;
import com.MOJICT.IACFee.Util.Trans_QueryBuilder;
import com.MOJICT.IACFee.Util.dateconverter;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;

public class AmountAction2 extends Action implements BeanProperties {
	
	/**
	* log4j logging solution
	*/
	static Logger logger = Logger.getLogger(AmountAction2.class);
	
	/**
	 * This handles the final step of the IAFT process which calculates the total payment due.
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {
		/*
		String securityToken = request.getSession().getAttribute("token").toString();
		logger.debug("Method:execute - using security token: "+securityToken);
		DataSource datasource = getDataSource(request);
		
		IAFTBean iBean = IAFTBeanFactory.getBeanInstance(securityToken, datasource, request);
		logger.debug("Coming after retrieval and form type is"+iBean.getType());
		String orderID = setOrderID(iBean, request);
		
		setAppealCountForPotentialTopUps(orderID , request);
		
		request.getSession().setAttribute("paymenttype", "submission");
		int amount = 0;
		
		try {
			String AggrURN = iBean.getAggregatedpaymentURN();
			ArrayList<AggregatedSubmissionBean> asBeansArrayList=null;
			boolean flag=false;
			if (AggrURN != null) {
				amount = 0;
				
				//ArrayList<AggregatedSubmissionBean> asBeansArrayList = QueryBuilder.getAggregatedsubmission(datasource,
					//	AggrURN);
				
				asBeansArrayList = QueryBuilder.getAggregatedsubmission(datasource,
						AggrURN,request);
			}
			else
			{
				 asBeansArrayList = QueryBuilder.getAggregatedsubmission(datasource,
						iBean.getPaymentURN(),request);
			}
				
				for (AggregatedSubmissionBean asBean : asBeansArrayList) {
					if(asBean.getStatus().equals("Completed"))
					{
					amount += asBean.getAmount();
					}
					if(asBean.getStatus().equals("In Progress"))
					{
						flag=true;
					}
					
					
				}
				request.getSession().setAttribute("appealstatus", flag);
				request.getSession().setAttribute("aggramount", amount);
				request.getSession().setAttribute("asbean", asBeansArrayList);

			} 
		 catch (Exception ex) {
			ex.printStackTrace();
			return mapping.findForward("failure");
		}
		
		return evaluateNextActionForward(amount,  mapping);
	}*/
		return evaluateNextActionForward(20,  mapping);
	}

	
	/**
	 * Evaluate what next action to perform is
	 * @param amount
	 * @param mapping
	 * @return
	 */
	private ActionForward evaluateNextActionForward(int amount, ActionMapping mapping) {
		if (amount == 0) {
			
			return mapping.findForward("successpdf");
		} else {
			return mapping.findForward("success");
		}
	}
	
	/**
	 * Set the order id. 
	 * The order id is unique number identifying a payment on the IAC database.
	 * It is used to reconcile with the ARIA system who retrieve it from the PDF or XML 
	 * produced by this application. The format of the order id is:
	 * The URN :
	 * 	- paymentURN for a single appeal 
	 *  - aggregatedURN for a multiple appeal
	 * The order id is stored on the session as oid.
	 * @param iBean
	 * @param token
	 * @param request
	 */
	private String setOrderID(IAFTBean iBean, HttpServletRequest request) {
		String urn = "";
		if (iBean.getAggregatedpaymentURN() != null) {
			ArrayList asBeansArrayList = QueryBuilder.getAggregatedsubmission(getDataSource(request),
				iBean.getAggregatedpaymentURN(),request);
			logger.debug("Arraylist size is >>>>>>>>>>>???????????"+asBeansArrayList.size());
			if(asBeansArrayList.size()==2)
			{
				if(((AggregatedSubmissionBean)asBeansArrayList.get(0)).getAmount()==0||((AggregatedSubmissionBean)asBeansArrayList.get(1)).getAmount()==0)
				{
					logger.debug("cmg here in aggregated submission single payment >>>>>>>>>>>???????????"+asBeansArrayList.size());
					if(((AggregatedSubmissionBean)asBeansArrayList.get(0)).getAmount()!=0)
					{
					logger.debug("Single URN"+((AggregatedSubmissionBean)asBeansArrayList.get(0)).getPaymenturn());
					urn = ((AggregatedSubmissionBean)asBeansArrayList.get(0)).getUrn();
					}
					if(((AggregatedSubmissionBean)asBeansArrayList.get(1)).getAmount()!=0)
					{
					logger.debug("Single URN"+((AggregatedSubmissionBean)asBeansArrayList.get(1)).getPaymenturn());
					urn = ((AggregatedSubmissionBean)asBeansArrayList.get(1)).getUrn();
				
					}
					urn=urn.replaceFirst("77", "88");
				}
				else
				{
				logger.debug("Aggr URN ***********"+iBean.getAggregatedpaymentURN());
				urn = iBean.getAggregatedpaymentURN();
				}
			}
			else
			{
			logger.debug("Aggr URN ***********"+iBean.getAggregatedpaymentURN());
			urn = iBean.getAggregatedpaymentURN();
			}
		} else {
			logger.debug("Single URN"+iBean.getPaymentURN());
			urn = iBean.getPaymentURN();
		}
		request.getSession().setAttribute("oid", urn);		
		return urn;
	}
	
	/**
	 * The application needs to keep track of how many appeals 
	 * need to be considered if the user wants to make top up
	 * payments.
	 * @param urn
	 * @param request
	 */
	private void setAppealCountForPotentialTopUps(String urn , HttpServletRequest request){
		request.getSession().setAttribute("count", Trans_QueryBuilder.getcount(urn, getDataSource(request)));
	}
	
	/**
	 * Set the amount on the session
	 * @param iBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private  int setSessionAmount(IAFTBean iBean, HttpServletRequest request) throws Exception {
		int amount = 0;
		
		if(iBean.getType().equals(IAFT1)){
			IAFT1Bean iBean1 = (IAFT1Bean)iBean;
			request.getSession().setAttribute("IAFT1Bean", iBean1);
			logger.debug("IAFT1 set amount action");
			iBean1.setS2e(dateconverter.convertdate(iBean1.getS2e_service_day(), iBean1.getS2e_service_month(),
					iBean1.getS2e_service_year()));
			if (iBean1.getQb_lsc().equals("No")) {
				amount = iBean1.getPaymentvalue();
				
			}
		} else if (iBean.getType().equals(IAFT2)){
			IAFT2Bean iBean2 = (IAFT2Bean)iBean;
			request.getSession().setAttribute("IAFT2Bean", iBean2);
			if (iBean2.getQb_lsc().equals("No") ) {
				amount = iBean2.getPaymentvalue();
			}
		} else if(iBean.getType().equals(IAFT3)){
			IAFT3Bean iBean3 = (IAFT3Bean)iBean;
			request.getSession().setAttribute("IAFT3Bean", iBean3);
			iBean3.setS2e(dateconverter.convertdate(iBean3.getS2e_service_day(), iBean3.getS2e_service_month(),
					iBean3.getS2e_service_year()));
			if (iBean3.getQb_lsc().equals("No")) {
				amount = iBean3.getPaymentvalue();
			}
		}
		request.getSession().setAttribute("aggramount", amount);
		request.getSession().setAttribute("asbean", iBean);
		return amount;
	}
}