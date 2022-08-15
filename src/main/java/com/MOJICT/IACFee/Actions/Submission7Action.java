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

public class Submission7Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Submission7Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("Submission7Action.execute");

		IAFT7Bean frm = (IAFT7Bean) form;

		String errMsg = "";
		String Return = "fail";
		String dberror="Your information is not saved please try again.";
		
		

		

		if (frm.getNext().equals("page-2")) {
			Return = "page-1";
			
			errMsg = ValidationServiceIAFT7.IsIAFT7Page1(frm);
			
			if (errMsg == "") {
				try {

					DataSource datasource = getDataSource(request);

					if (request.getSession().getAttribute("token1") != null) {

						

						frm = QueryBuilder7.IAFT7_1(frm, "save", datasource, request.getSession().getAttribute("token1")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT7.IsIAFT7Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT7", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT7", frm);
						
						request.setAttribute("TwoYearsPlusMinus", Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						

					} else {
						
						frm = QueryBuilder7.IAFT7_1(frm, "save", datasource, request.getSession().getAttribute("token")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT7.IsIAFT7Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT7", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT7", frm);
						request.getSession().setAttribute("token1", request.getSession().getAttribute("token"));
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						
					}

				} catch (Exception e) {
					logger.error("Submission7Action.execute - ", e);
					return mapping.findForward("failure");
				}
			}

			if (errMsg != "") {
				request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-3")) {
			errMsg = "";
			Return = "page-2";
			errMsg = ValidationServiceIAFT7.IsIAFT7Page2(frm);
			if (errMsg == "") {
				try {

					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_2(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 2");
					errMsg = ValidationServiceIAFT7.IsIAFT7Page2(frm);
					logger.debug("After revalidation paeg 2 "+ errMsg);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
				
					Return = "page-3";
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					request.setAttribute("frmIAFT7", frm);
					return mapping.findForward(Return);

				}

				catch (Exception e) {
					
					//DB saving validation
					request.setAttribute("frmIAFT7", frm);
					request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
					logger.error("Submission7Action.execute - ", e);
					return mapping.findForward(Return);
				}
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				
				request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-4")) {
			errMsg = "";
			Return = "page-3";
			errMsg = ValidationServiceIAFT7.IsIAFT7Page3(frm);

			try {
				if (errMsg == "") {
					DataSource datasource = getDataSource(request);
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					frm = QueryBuilder7.IAFT7_3(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 3");
					errMsg = ValidationServiceIAFT7.IsIAFT7Page3(frm);
					logger.debug("After revalidation paeg 3 "+ errMsg);
		
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-4";
					request.setAttribute("frmIAFT7", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT7", frm);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());

				logger.error("Submission7Action.execute - ", e);
				return mapping.findForward(Return);
			}
			if (errMsg != "") {
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-5")) {
			try {
				errMsg = "";
				Return = "page-4";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page4(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_4(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT7.IsIAFT7Page4(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-5";
					request.setAttribute("frmIAFT7", frm);

				}
				
				

			} catch (Exception e) {
				logger.error("Submission7Action.execute - ", e);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward(Return);
			}
			// logger.debug(Return+">>>>>>>>"+errMsg);
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-6")) {
			try {
				
				frm.setFormtitle(request.getSession().getAttribute("frmHeader").toString());
				errMsg = "";
				Return = "page-5";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page5(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_5(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT7.IsIAFT7Page5(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-6";
					request.setAttribute("frmIAFT7", frm);
				}
			} catch (Exception e) {
				logger.error("Submission7Action.execute - ", e);
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-7")) {
			try {
				frm.setFormtitle(request.getSession().getAttribute("frmHeader").toString());
				errMsg = "";
				Return = "page-6";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page6(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_6(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					//errMsg = ValidationServiceIAFT1.IsIAFT1Page6(frm);
					logger.debug("Error message is "+errMsg);
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-7";
					request.setAttribute("frmIAFT7", frm);
				}

			} catch (Exception e) {
				logger.error("Submission7Action.execute - ", e);
				request.setAttribute("frmIAFT7", frm);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

	/*	else if (frm.getNext().equals("page-8")) {
			try {
				
				frm.setFormtitle(request.getSession().getAttribute("frmHeader").toString());
				errMsg = "";
				Return = "page-7";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page7(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_7(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT7.IsIAFT7Page7(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
					request.setAttribute("frmIAFT7", frm);
				}
			} catch (Exception e) {
				request.setAttribute("frmIAFT7", frm);
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}
*/
		else if (frm.getNext().equals("page-8")) {
			try {
				errMsg = "";
				Return = "page-7";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page8(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_8(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT7.IsIAFT7Page8(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
					request.setAttribute("frmIAFT7", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT7", frm);
				logger.error("Submission7Action.execute - ", e);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-9")) {
			try {
				errMsg = "";
				Return = "page-8";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page9(frm);
				String have_rep=frm.getHave_rep();
				if (errMsg == "") {
					logger.debug(">>>>>>>>>>>>>>>>>>>>>>>"+frm.getEmail());
					request.getSession().setAttribute("email", frm.getEmail());
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder7.IAFT7_9(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					frm.setHave_rep(have_rep);
					errMsg = ValidationServiceIAFT7.IsIAFT7Page9(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					if (have_rep.equals("Yes")) {
						Return = "page-9";
					} else {
						logger.debug("Coming here to complketed status");
						QueryBuilder7.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
						Return = "success";
					}
					request.setAttribute("frmIAFT7", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT7", frm);
				logger.error("Submission7Action.execute - ", e);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("finish")) {
			try {
				errMsg = "";
				Return = "page-9";
				errMsg = ValidationServiceIAFT7.IsIAFT7Page10(frm);
				if (errMsg == "") {
					Return = "success";
					DataSource datasource = getDataSource(request);
					QueryBuilder7.IAFT7_10(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString());
					//DB saving validation
					frm = QueryBuilder7.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT7.IsIAFT7Page10(frm);
					QueryBuilder7.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT7", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end

				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT7", frm);
				logger.error("Submission7Action.execute - ", e);
				return mapping.findForward("failure");
			}

			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		if (errMsg != "") {
			request.setAttribute("errMsg", errMsg);
			return mapping.findForward(Return);
		} else
			return mapping.findForward(Return);
	}

}
