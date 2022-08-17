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

import com.MOJICT.IACFee.Beans.IAFT5Bean;
import com.MOJICT.IACFee.Util.QueryBuilder5;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT5;

public class Submission5Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Submission5Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("Submission5Action.execute");

		IAFT5Bean frm = (IAFT5Bean) form;

		String errMsg = "";
		String Return = "fail";
		String dberror="Your information is not saved please try again.";
		
		

		

		if (frm.getNext().equals("page-2")) {
			Return = "page-1";
			
			errMsg = ValidationServiceIAFT5.IsIAFT5Page1(frm);
			
			if (errMsg == "") {
				try {

					DataSource datasource = getDataSource(request);

					if (request.getSession().getAttribute("token1") != null) {

						

						frm = QueryBuilder5.IAFT5_1(frm, "save", datasource, request.getSession().getAttribute("token1")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT5.IsIAFT5Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT5", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT5", frm);
						
						request.setAttribute("TwoYearsPlusMinus", Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						

					} else {
						
						frm = QueryBuilder5.IAFT5_1(frm, "save", datasource, request.getSession().getAttribute("token")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT5.IsIAFT5Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT5", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT5", frm);
						request.getSession().setAttribute("token1", request.getSession().getAttribute("token"));
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						
					}

				} catch (Exception e) {
					logger.error("Submission5Action.execute - ", e);
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
			errMsg = ValidationServiceIAFT5.IsIAFT5Page2(frm);
			if (errMsg == "") {
				try {

					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_2(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 2");
					errMsg = ValidationServiceIAFT5.IsIAFT5Page2(frm);
					logger.debug("After revalidation paeg 2 "+ errMsg);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
				
					Return = "page-3";
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					request.setAttribute("frmIAFT5", frm);
					return mapping.findForward(Return);

				}

				catch (Exception e) {
					
					//DB saving validation
					request.setAttribute("frmIAFT5", frm);
					request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
					logger.error("Submission5Action.execute - ", e);
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
			errMsg = ValidationServiceIAFT5.IsIAFT5Page3(frm);

			try {
				if (errMsg == "") {
					DataSource datasource = getDataSource(request);
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					frm = QueryBuilder5.IAFT5_3(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 3");
					errMsg = ValidationServiceIAFT5.IsIAFT5Page3(frm);
					logger.debug("After revalidation paeg 3 "+ errMsg);
		
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-4";
					request.setAttribute("frmIAFT5", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT5", frm);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());

				logger.error("Submission5Action.execute - ", e);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page4(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_4(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT5.IsIAFT5Page4(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-5";
					request.setAttribute("frmIAFT5", frm);

				}
				
				

			} catch (Exception e) {
				logger.error("Submission5Action.execute - ", e);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT5", frm);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page5(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_5(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT5.IsIAFT5Page5(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-6";
					request.setAttribute("frmIAFT5", frm);
				}
			} catch (Exception e) {
				logger.error("Submission5Action.execute - ", e);
				request.setAttribute("frmIAFT5", frm);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page6(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_6(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					//errMsg = ValidationServiceIAFT1.IsIAFT1Page6(frm);
					logger.debug("Error message is "+errMsg);
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-7";
					request.setAttribute("frmIAFT5", frm);
				}

			} catch (Exception e) {
				logger.error("Submission5Action.execute - ", e);
				request.setAttribute("frmIAFT5", frm);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page7(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_7(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT5.IsIAFT5Page7(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
					request.setAttribute("frmIAFT5", frm);
				}
			} catch (Exception e) {
				request.setAttribute("frmIAFT5", frm);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page8(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_8(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT5.IsIAFT5Page8(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
					request.setAttribute("frmIAFT5", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT5", frm);
				logger.error("Submission5Action.execute - ", e);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page9(frm);
				String have_rep=frm.getHave_rep();
				if (errMsg == "") {
					logger.debug(">>>>>>>>>>>>>>>>>>>>>>>"+frm.getEmail());
					request.getSession().setAttribute("email", frm.getEmail());
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder5.IAFT5_9(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					frm.setHave_rep(have_rep);
					errMsg = ValidationServiceIAFT5.IsIAFT5Page9(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					if (have_rep.equals("Yes")) {
						Return = "page-9";
					} else {
						logger.debug("Coming here to complketed status");
						QueryBuilder5.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
						Return = "success";
					}
					request.setAttribute("frmIAFT5", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT5", frm);
				logger.error("Submission5Action.execute - ", e);
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
				errMsg = ValidationServiceIAFT5.IsIAFT5Page10(frm);
				if (errMsg == "") {
					Return = "success";
					DataSource datasource = getDataSource(request);
					QueryBuilder5.IAFT5_10(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString());
					//DB saving validation
					frm = QueryBuilder5.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT5.IsIAFT5Page10(frm);
					QueryBuilder5.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT5", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end

				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT5", frm);
				logger.error("Submission5Action.execute - ", e);
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
