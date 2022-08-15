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

public class NewIsFeePayable7Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(NewIsFeePayable7Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("NewIsFeePayable7Action.execute");
		DynaActionForm frm = (DynaActionForm) form;

		if (frm.get("exemption").toString().length() > 2)
			request.getSession().setAttribute("FeePayable", frm.get("exemption"));
		return mapping.findForward("success-IAFT7");

	}
}
