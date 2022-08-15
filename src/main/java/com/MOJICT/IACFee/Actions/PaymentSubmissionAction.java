package com.MOJICT.IACFee.Actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MOJICT.IACFee.Beans.AggregatedSubmissionBean;
import com.MOJICT.IACFee.Beans.CPIBean;
import com.MOJICT.IACFee.Util.Trans_QueryBuilder;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.AggregatedBean;
import com.MOJICT.IACFee.Util.SecurityToken;
import com.MOJICT.IACFee.Util.Verhoeffs;

public class PaymentSubmissionAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PaymentSubmissionAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {
		int amount = 0;
		int count = 0;

		AggregatedBean frm = (AggregatedBean) form;
		if (request.getSession().getAttribute("paymenttype") != null) {
			if (request.getSession().getAttribute("paymenttype").equals("submission")) {
				//
				ArrayList<AggregatedSubmissionBean> asbean=new ArrayList<AggregatedSubmissionBean>();
				asbean=(ArrayList)(request.getSession().getAttribute("asbean"));
				for (AggregatedSubmissionBean asBean : asbean) {
				if(asBean.getStatus().equals("In Progress"))
				{
				String errMsg = "You have one or more appeals 'in progress'. To move on you must either complete the appeal using the edit button or remove the appeal entirely. If you remove the appeal you will NOT be able to go back to it later and will have to start again.";
				//errMsg="";
				
				request.setAttribute("errMsg", errMsg);
				
				return mapping.findForward("failureappeal");
				}
			}
				
				//
				request.getSession().setAttribute("paymenttype", "submission");
				return mapping.findForward("success");
			}
		}
		// logger.debug(SecurityToken.retrieveamount("111err2345M"));
		// request.getSession().setAttribute("aggramount",null);

		
		/* Two references can not be the same*/
		
		
	
	
		
		request.getSession().setAttribute("email", frm.getEmail());
		
		//
		if (frm.getPrn1() != "" && frm.getPrn1() != null) {
			String errMsg = " ";
			logger.debug(frm.getPrn1());
			
			if(frm.getPrn1().equals(frm.getPrn2())||frm.getPrn1().equals(frm.getPrn3())||frm.getPrn1().equals(frm.getPrn4())||frm.getPrn1().equals(frm.getPrn5()))
			{
				errMsg = "Two reference numbers can not be the same.";
					request.setAttribute("errMsg", errMsg);
					return mapping.findForward("failure");
			}
			if(Verhoeffs.validatereference(frm.getPrn1()).equals("failure"))
			{
				
				errMsg="Please enter valid reference number. First two letters must be characters.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			else
			{
				frm.setPrn1(Verhoeffs.validatereference(frm.getPrn1()));
				logger.debug(frm.getPrn1());
			}
			
			
			
			if (Verhoeffs.validateVerhoeff(frm.getPrn1()) && frm.getPrn1() != "") {
				// ++count;
				amount = SecurityToken.retrieveamount(frm.getPrn1());
				if ((frm.getPrn2() != "" || !frm.getPrn2().equals(""))) {
					//amount=SecurityToken.retrieveamount(urn)
					++count;
					// amount=SecurityToken.retrieveamount(frm.getPrn1());

				} else {

					// logger.debug("Error");
					// request.getSession().setAttribute("amount", 80);
					if (request.getSession().getAttribute("aggramount") != null) {
						++count;
						amount = SecurityToken.retrieveamount(frm.getPrn1());

					} else {
						++count;
						amount = SecurityToken.retrieveamount(frm.getPrn1());
					}
				}
				
				request.setAttribute("errMsg", errMsg);
			}
			

			else {
				 errMsg = "Invalid Reference number format";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
		} else {
			String errMsg = "Payment reference number cannot be blank.";
			request.setAttribute("errMsg", errMsg);
			return mapping.findForward("failure");
		}

		// logger.debug("........................."+frm.getPrn2());
		if ((frm.getPrn2() != "" || !frm.getPrn2().equals(""))) {
			String errMsg="";
			
			if(frm.getPrn1().equals(frm.getPrn2())||frm.getPrn2().equals(frm.getPrn3())||frm.getPrn2().equals(frm.getPrn4())||frm.getPrn2().equals(frm.getPrn5()))
			{
				 errMsg = "Two reference numbers can not be the same.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			if(Verhoeffs.validatereference(frm.getPrn2()).equals("failure"))
			{
				
				errMsg="Please enter valid reference no.First two letters must be characters.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			else
			{
				frm.setPrn2(Verhoeffs.validatereference(frm.getPrn2()));
				logger.debug(frm.getPrn2());
			}
			
			
			if (Verhoeffs.validateVerhoeff(frm.getPrn2())) {
				++count;
				amount = amount + SecurityToken.retrieveamount(frm.getPrn2());

			}

			else {
				 errMsg = "Invalid Reference number format";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
		}
		if ((frm.getPrn3() != "" || !frm.getPrn3().equals(""))) {
			String errMsg = " ";
			logger.debug(frm.getPrn3());
			
			if(frm.getPrn3().equals(frm.getPrn2())||frm.getPrn1().equals(frm.getPrn3())||frm.getPrn3().equals(frm.getPrn4())||frm.getPrn3().equals(frm.getPrn5()))
			{
				errMsg = "Two reference numbers can not be the same.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			if(Verhoeffs.validatereference(frm.getPrn3()).equals("failure"))
			{
				
				errMsg="Please enter valid reference no.First two letters must be characters.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			else
			{
				frm.setPrn3(Verhoeffs.validatereference(frm.getPrn3()));
				logger.debug(frm.getPrn3());
			}
			
			if (Verhoeffs.validateVerhoeff(frm.getPrn3())) {
				++count;
				amount = amount + SecurityToken.retrieveamount(frm.getPrn3());

			}

			else {
				errMsg = "Invalid Reference number format";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
		}
		if ((frm.getPrn4() != "" || !frm.getPrn4().equals(""))) {
			
			
			String errMsg = " ";
			logger.debug(frm.getPrn4());
			
			if(frm.getPrn4().equals(frm.getPrn2())||frm.getPrn4().equals(frm.getPrn3())||frm.getPrn1().equals(frm.getPrn4())||frm.getPrn4().equals(frm.getPrn5()))
			{
				 errMsg = "Two reference numbers can not be the same.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			if(Verhoeffs.validatereference(frm.getPrn4()).equals("failure"))
			{
				
				errMsg="Please enter valid reference no.First two letters must be characters.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			else
			{
				frm.setPrn4(Verhoeffs.validatereference(frm.getPrn4()));
				logger.debug(frm.getPrn4());
			}
			
			if (Verhoeffs.validateVerhoeff(frm.getPrn4())) {
				++count;
				amount = amount + SecurityToken.retrieveamount(frm.getPrn4());

			}

			else {
				errMsg = "Invalid Reference number format";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
		}
		if ((frm.getPrn5() != "" || !frm.getPrn5().equals(""))) {
			
			String errMsg = " ";
			logger.debug(frm.getPrn5());
			if(frm.getPrn5().equals(frm.getPrn2())||frm.getPrn5().equals(frm.getPrn3())||frm.getPrn5().equals(frm.getPrn4())||frm.getPrn1().equals(frm.getPrn5()))
			{
				errMsg = "Two reference numbers can not be the same.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			if(Verhoeffs.validatereference(frm.getPrn5()).equals("failure"))
			{
				
				errMsg="Please enter valid reference no.First two letters must be characters.";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
			else
			{
				frm.setPrn5(Verhoeffs.validatereference(frm.getPrn5()));
				logger.debug(frm.getPrn5());
			}
			
			if (Verhoeffs.validateVerhoeff(frm.getPrn5())) {
				++count;
				amount = amount + SecurityToken.retrieveamount(frm.getPrn5());

			}

			else {
				errMsg = "Invalid Reference number format";
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward("failure");
			}
		}
		frm.setPaymentvalue(amount);

		frm.setCount(count);
		String Return = "success";
		String token = SecurityToken.generateCode();
		if (count == 0) {
			// logger.debug(CPIBean.setOid(request.getSession().getAttribute("token").toString(),"123456"));
			request.getSession().setAttribute("oid", CPIBean.setOid("123456"));
			
		}
		if (count == 1) {
			frm.setAggregatedpaymentURN(null);
			frm.setOid(CPIBean.setOid(frm.getPrn1()));
			request.getSession().setAttribute("oid", frm.getOid());
			Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
			logger.debug("Your order id is"+frm.getOid());
		}
		if (count > 1) {
			String orderid=Trans_QueryBuilder.check(frm, count, getDataSource(request));
			frm.setAggregatedpaymentURN(orderid);
			frm.setOid(CPIBean.setOid(frm.getAggregatedpaymentURN()));
			logger.debug("Your order id is"+frm.getOid());
			for (int i = 1; i <= count; i++) {

				// frm.setAggregatedpaymentURN("77"+SecurityToken.generateAggregatedPaymentURN());
				request.getSession().setAttribute("oid", frm.getOid());
				if (i == 1) {
					Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
				}
				if (i == 2) {
					frm.setPrn1(frm.getPrn2());
					Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
				}
				if (i == 3) {
					frm.setPrn1(frm.getPrn3());
					Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
				}
				if (i == 4) {
					frm.setPrn1(frm.getPrn4());
					Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
				}
				if (i == 5) {
					frm.setPrn1(frm.getPrn5());
					Trans_QueryBuilder.save(frm, frm.getOid(), getDataSource(request));
				}

			}

		}

		request.getSession().setAttribute("frm", frm);
		request.getSession().setAttribute("paymenttype", "2");
		request.getSession().setAttribute("aggramount", amount);

		request.setAttribute("errMsg", "");
		return mapping.findForward(Return);
	}

}
