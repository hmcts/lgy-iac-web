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

import com.MOJICT.IACFee.Beans.IAFT2Bean;
import com.MOJICT.IACFee.Util.QueryBuilder2;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT2;

public class Prev2Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Prev2Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		IAFT2Bean frm = (IAFT2Bean) form;
		// tring errMsg="";
		String errMsg = ValidationServiceIAFT2.IsIAFT2Page1(frm);
		logger.info("Prev2Action.execute");
		if (request.getParameter("page").toString().equals("1")) {
			// return mapping.findForward("page-1");

			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					return mapping.findForward("page-1");

				} else {
					frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					return mapping.findForward("page-1");
				}

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		if (request.getParameter("page").toString().equals("2")) { // return
																	// mapping.findForward("page-2");

			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					return mapping.findForward("page-2");

				} else {
					frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					return mapping.findForward("page-2");
				}

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").equals("3")) {
			// return mapping.findForward("page-3");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("CurrentAndTwoFormerYears", Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT2", frm);
				return mapping.findForward("page-3");

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("4")) {
			// return mapping.findForward("page-4");

			try {

				DataSource datasource = getDataSource(request);
				// logger.debug("???????????"+frm.getS2e_service_day());
				frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT2", frm);
				return mapping.findForward("page-4");

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("5")) {
			// return mapping.findForward("page-5");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT2", frm);
				return mapping.findForward("page-5");

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("6")) {
			// return mapping.findForward("page-6");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT2", frm);
				return mapping.findForward("page-6");

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
				return mapping.findForward("failure");
			}

		}

		else if (request.getParameter("page").toString().equals("7")) {
			// return mapping.findForward("page-7");

			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder2.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT2", frm);
				return mapping.findForward("page-7");

			} catch (Exception e) {
				logger.error("Prev2Action.execute - ", e);
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
