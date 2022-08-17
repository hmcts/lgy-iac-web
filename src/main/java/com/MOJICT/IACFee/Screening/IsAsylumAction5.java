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

public class IsAsylumAction5 extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IsAsylumAction5.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("IsAsylumAction5.execute");
		DynaActionForm frm = (DynaActionForm) form;
		 String findforward="success-IAFT5";
		logger.debug("dyna action form"+frm.get("asylum").toString());
		if (frm.get("asylum") != null) {
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
		}
		
		return mapping.findForward(findforward);

	}
}
