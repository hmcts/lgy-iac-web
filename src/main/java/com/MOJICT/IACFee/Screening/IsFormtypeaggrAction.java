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

public class IsFormtypeaggrAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IsFormtypeaggrAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("IsFormtypeaggrAction.execute");
		DynaActionForm frm = (DynaActionForm) form;
       
		String errMsg="";
        logger.info("form type value"+frm.get("formtype").toString());
		if(!(frm.get("formtype").toString().equals("")))
        {
		if (frm.get("formtype").toString().length() > 2)
			if(frm.get("formtype").equals("everythingelse"))
			{
				return mapping.findForward("current");
			}
			else
			{
				
	        	return mapping.findForward("new");
			}
        }
        else
        {
        	errMsg="You are unable to submit this type of appeal online. If you wish to pay for the appeals you have already completed, or submit another online appeal, please click the <strong>Previous</strong> button to return to the previous screen.";
        	request.setAttribute("errMsg", errMsg);
        	return mapping.findForward("failure");
        }

		return mapping.findForward("failure");

	}
}
