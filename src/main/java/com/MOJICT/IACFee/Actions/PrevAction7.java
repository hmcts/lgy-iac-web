
package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Util.Helper;
import com.MOJICT.IACFee.Util.QueryBuilder7;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.IAFT7Bean;

import com.MOJICT.IACFee.Util.ValidationServiceIAFT7;

public class PrevAction7 extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PrevAction7.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("PrevAction7.execute");

		IAFT7Bean frm = (IAFT7Bean) form;
		String errMsg = ValidationServiceIAFT7.IsIAFT7Page1(frm);
		logger.debug(frm.getNext() + "????" + request.getParameter("token"));

		if (request.getParameter("page").toString().equals("1")) {
			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT7", frm);
					return mapping.findForward("page-1");

				} else {
					frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT7", frm);
					return mapping.findForward("page-1");
				}

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		if (request.getParameter("page").toString().equals("2")) {
			try {

				DataSource datasource = getDataSource(request);
				if (request.getSession().getAttribute("token1") != null) {

					frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT7", frm);
					request.setAttribute("TwoYearsPlusMinus", Helper.getTwoYearsPlusMinus());
					return mapping.findForward("page-2");

				} else {
					frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
							.toString(), request);
					request.setAttribute("frmIAFT7", frm);
					request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
					return mapping.findForward("page-2");
					
				}

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").equals("3")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT7", frm);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				return mapping.findForward("page-3");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("4")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-4");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("5")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-5");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("6")) {
			try {
                
				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-6");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("7")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-7");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("8")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-8");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("9")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-9");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("10")) {
			try {

				DataSource datasource = getDataSource(request);
				frm = QueryBuilder7.retrieve(frm, "save", datasource, request.getSession().getAttribute("token1")
						.toString(), request);

				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("page-10");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
				return mapping.findForward("failure");
			}
		}

		else if (request.getParameter("page").toString().equals("finish")) {
			try {

				DataSource datasource = getDataSource(request);
				QueryBuilder7.IAFT7_10(frm, "save", datasource, request.getSession().getAttribute("token").toString());
				return mapping.findForward("page-1");

			} catch (Exception e) {
				logger.error("PrevAction7.execute - ", e);
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
