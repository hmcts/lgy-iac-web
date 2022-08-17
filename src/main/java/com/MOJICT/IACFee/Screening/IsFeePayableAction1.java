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

public class IsFeePayableAction1 extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IsFeePayableAction1.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("IsFeePayableAction1.execute");
		DynaActionForm frm = (DynaActionForm) form;
		logger.debug(request.getParameter("frmIAFT1"));
		request.setAttribute("frmIAFT1",  request.getParameter("frmIAFT1"));
		request.getSession().setAttribute("frmIAFT1",  request.getParameter("frmIAFT1"));
		if (frm.get("exemption").toString().length() > 2)
			request.getSession().setAttribute("FeePayable", frm.get("exemption"));
			
		return mapping.findForward("success");

	}
}
