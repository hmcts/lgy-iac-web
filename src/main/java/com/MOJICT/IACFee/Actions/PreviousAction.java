package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.IAFT1Bean;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Util.QueryBuilder;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT1;

public class PreviousAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PreviousAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("PreviousAction.execute");

		IAFT1Bean frm = (IAFT1Bean) form;
		String errMsg = ValidationServiceIAFT1.IsIAFT1Page1(frm);
		DataSource datasource = getDataSource(request);

		frm.setPrevious(request.getParameter("page").toString());

		if (frm.getPrevious().equals("1")) {
			try {
				frm = QueryBuilder
						.IAFT1_1(frm, "retrieve", datasource, request.getParameter("security_token"), request);
				request.setAttribute("frmIAFT1", frm);
				return mapping.findForward("page-1");

			} catch (Exception e) {
				e.printStackTrace();
				return mapping.findForward("failure");
			}
		} else if (frm.getPrevious().equals("2")) {
			frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, request.getParameter("security_token"), request);
			request.setAttribute("frmIAFT1", frm);
			return mapping.findForward("page-2");
		} else if (frm.getPrevious().equals("3")) {
			frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, request.getParameter("security_token"), request);
			request.setAttribute("frmIAFT1", frm);
			return mapping.findForward("page-3");
		} else if (frm.getPrevious().equals("4"))
			return mapping.findForward("page-4");

		else if (frm.getPrevious().equals("5"))
			return mapping.findForward("page-5");

		else if (frm.getPrevious().equals("6"))
			return mapping.findForward("page-6");

		else if (frm.getPrevious().equals("7"))
			return mapping.findForward("page-7");

		else if (frm.getPrevious().equals("8"))
			return mapping.findForward("page-8");

		else if (frm.getPrevious().equals("9"))
			return mapping.findForward("page-9");

		else
			return mapping.findForward("fail");
	}

}