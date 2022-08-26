package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Util.Helper;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.IAFT6Bean;
import com.MOJICT.IACFee.Util.QueryBuilder6;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT6;

public class Prev6Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Prev6Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("Prev6Action.execute");
		IAFT6Bean frm = (IAFT6Bean) form;
		// tring errMsg="";
		String errMsg = ValidationServiceIAFT6.IsIAFT6Page1(frm);

		if (request.getParameter("page").toString().equals("1")) {
			// return mapping.findForward("page-1");

			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT6", frm);
					return mapping.findForward("page-1");

				} else {
					frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT6", frm);
					return mapping.findForward("page-1");
				}

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		if (request.getParameter("page").toString().equals("2")) { // return
																	// mapping.findForward("page-2");

			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT6", frm);
					return mapping.findForward("page-2");

				} else {
					frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT6", frm);
					return mapping.findForward("page-2");
				}

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").equals("3")) {
			// return mapping.findForward("page-3");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("CurrentAndTwoFormerYears", Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT6", frm);
				return mapping.findForward("page-3");

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("4")) {
			// return mapping.findForward("page-4");

			try {

				DataSource datasource = getDataSource(request);
				// logger.debug("???????????"+frm.getS2e_service_day());
				frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT6", frm);
				return mapping.findForward("page-4");

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("5")) {
			// return mapping.findForward("page-5");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT6", frm);
				return mapping.findForward("page-5");

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("6")) {
			// return mapping.findForward("page-6");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT6", frm);
				return mapping.findForward("page-6");

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("7")) {
			// return mapping.findForward("page-7");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder6.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT6", frm);
				return mapping.findForward("page-7");

			} catch (Exception e) {
				logger.error("Prev6Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		if (errMsg != "") {
			request.setAttribute("errMsg", errMsg);
			return mapping.findForward("fail");
		} else
			return mapping.findForward("success");
	}

}
