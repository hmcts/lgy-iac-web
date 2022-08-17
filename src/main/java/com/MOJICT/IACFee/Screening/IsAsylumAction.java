  package com.MOJICT.IACFee.Screening;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

  public class IsAsylumAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IsAsylumAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {
		
		logger.info("IsAsylumAction.execute");
		DynaActionForm frm = (DynaActionForm) form;
		String findfwd="";
		logger.debug(request.getParameter("xyz").toString()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if(request.getParameter("xyz").toString().equals("iaft5"))
		{
			findfwd="iaft5-failure";
		}
		else if(request.getParameter("xyz").toString().equals("iaft6"))
		{
			findfwd="iaft6-failure";
		}
		else if(request.getParameter("xyz").toString().equals("iaft1"))
		{
			findfwd="iaft1-failure";
		}
		else
		{
			findfwd="iaft7-failure";
		}
		 String msg=""; 
		 String findforward="";
		logger.debug("dyna action form"+frm.get("asylum").toString());
		if (frm.get("asylum") != null || !frm.get("asylum").equals("")) {
			String x = frm.get("asylum").toString();
           
			if (x.equals("yes"))
			{
				request.getSession().setAttribute("frmHeader", "Asylum");
				findforward="success-IAFT1";
			}
			else if (x.equals("no")){	
				request.getSession().setAttribute("frmHeader", "Immigration");
				findforward="success-IAFT1";
			}
			else if (x.equals("protection")){
				request.getSession().setAttribute("frmHeader", "Protection");
				findforward="success-IAFT5";}
			else if (x.equals("protectionrevoke")){
				request.getSession().setAttribute("frmHeader", "Protection Revoke");
				findforward="success-IAFT5";}
			else if (x.equals("humanrights")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT5";}
			else if (x.equals("eea")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT5";}
			else if (x.equals("citizenship")){
				request.getSession().setAttribute("frmHeader", "Citizenship");
				findforward="success-IAFT5";}
			else if (x.equals("eea6")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT6";}
			else if (x.equals("humanrights6")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT6";}
			else if (x.equals("protection7")){
				request.getSession().setAttribute("frmHeader", "Protection");
				findforward="success-IAFT7";}
			else if (x.equals("protectionrevoke7")){
				request.getSession().setAttribute("frmHeader", "Protection Revoke");
				findforward="success-IAFT7";}
			else if (x.equals("humanrights7")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT7";}
			else if (x.equals("eea7")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT7";}
			else if (x.equals("citizenship7")){
				request.getSession().setAttribute("frmHeader", "Citizenship");
				findforward="success-IAFT7";}
			else
			{
				msg="Please select one of the below options.";
				request.setAttribute("errMsg", msg);
			}
		}
		else if(request.getSession().getAttribute("frmHeader")!=null)
		{
			String x = request.getSession().getAttribute("frmHeader").toString();
	           
			if (x.equals("yes"))
			{
				request.getSession().setAttribute("frmHeader", "Asylum");
				findforward="success-IAFT1";
			}
			else if (x.equals("no")){	
				request.getSession().setAttribute("frmHeader", "Immigration");
				findforward="success-IAFT1";
			}
			else if (x.equals("protection")){
				request.getSession().setAttribute("frmHeader", "Protection");
				findforward="success-IAFT5";}
			else if (x.equals("protectionrevoke")){
				request.getSession().setAttribute("frmHeader", "Protection Revoke");
				findforward="success-IAFT5";}
			else if (x.equals("humanrights")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT5";}
			else if (x.equals("eea")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT5";}
			else if (x.equals("citizenship")){
				request.getSession().setAttribute("frmHeader", "Citizenship");
				findforward="success-IAFT5";}
			else if (x.equals("eea6")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT6";}
			else if (x.equals("humanrights6")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT6";}
			else if (x.equals("protection7")){
				request.getSession().setAttribute("frmHeader", "Protection");
				findforward="success-IAFT7";}
			else if (x.equals("protectionrevoke7")){
				request.getSession().setAttribute("frmHeader", "Protection Revoke");
				findforward="success-IAFT7";}
			else if (x.equals("humanrights7")){
				request.getSession().setAttribute("frmHeader", "Human Rights");
				findforward="success-IAFT7";}
			else if (x.equals("eea7")){
				request.getSession().setAttribute("frmHeader", "EEA");
				findforward="success-IAFT7";}
			else if (x.equals("citizenship7")){
				request.getSession().setAttribute("frmHeader", "Citizenship");
				findforward="success-IAFT7";}
			else
			{
				msg="Please select one of the below options.";
				request.setAttribute("errMsg", msg);
			}
		}
		else
		{
			msg="Please select one of the below options.";
			request.setAttribute("errMsg", msg);
			//return mapping.findForward(findfwd);
		}
		if(!msg.equals(""))
		{
		return mapping.findForward(findfwd);
		}
		else{
			return mapping.findForward(findforward);
		}
	}
}
