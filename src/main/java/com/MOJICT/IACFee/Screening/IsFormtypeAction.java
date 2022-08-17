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

public class IsFormtypeAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IsFormtypeAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("IsFormtypeAction.execute");
		DynaActionForm frm = (DynaActionForm) form;
        String errMsg="";
        logger.info("form type value"+frm.get("formtype").toString());
		if(!(frm.get("formtype").toString().equals(""))&& null!=frm.get("formtype"))
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
        	errMsg="Please select one of the following options.";
        	request.setAttribute("errMsg", errMsg);
        	return mapping.findForward("failure");
        }

		return mapping.findForward("new");

	}
}
