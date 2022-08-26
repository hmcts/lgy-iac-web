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

import com.MOJICT.IACFee.Beans.IAFT3Bean;
import com.MOJICT.IACFee.Util.QueryBuilder;
import com.MOJICT.IACFee.Util.QueryBuilder3;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT3;

public class Submission3Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Submission3Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("Submission3Action.execute");

		IAFT3Bean frm = (IAFT3Bean) form;

		String errMsg = "";
		String Return = "fail";
		String dberror="Your information is not saved please try again.";

		if (frm.getNext().equals("page-2")) {
			Return = "page-1";
			 errMsg = ValidationServiceIAFT3.IsIAFT3Page1(frm);
			if (errMsg == "") {
				try {

					DataSource datasource = getDataSource(request);

					if (request.getSession().getAttribute("token1") != null) {

					
						frm = QueryBuilder3.IAFT3_1(frm, "save", datasource, request.getSession()
								.getAttribute("token1").toString(), request);
						request.setAttribute("frmIAFT3", frm);
						
						//DB saving validation
						frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT3.IsIAFT3Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("errMsg", dberror);
							request.setAttribute("frmIAFT3", frm);
							return mapping.findForward(Return);
						}
						//end
						Return = "page-2";


					} else {
						frm = QueryBuilder3.IAFT3_1(frm, "save", datasource, request.getSession().getAttribute("token")
								.toString(), request);

						request.setAttribute("frmIAFT3", frm);
						request.getSession().setAttribute("token1", request.getSession().getAttribute("token"));

						
						//DB saving validation
						frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT3.IsIAFT3Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("errMsg", dberror);
							request.setAttribute("frmIAFT3", frm);
							return mapping.findForward(Return);
						}
						//end
						Return = "page-2";

					}

				} catch (Exception e) {
					logger.error("Submission3Action.execute - ", e);
					return mapping.findForward("failure");
				}
			}

			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-3")) {
			errMsg = "";
			Return = "page-2";
			 errMsg=ValidationServiceIAFT3.IsIAFT3Page2(frm);
			
			
					
			 if (errMsg == "") {
				try {
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_2(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("TenYearsBack", Helper.getBackYears(10));
					request.setAttribute("TwoYearsBack",Helper.getBackYears(2));
					request.setAttribute("frmIAFT3", frm);

					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page2(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					
					request.setAttribute("TenYearsBack",Helper.getBackYears(10));
					request.setAttribute("TwoYearsBack",Helper.getBackYears(2));
					Return = "page-3";

				}

				catch (Exception e) {
					
					logger.error("Submission3Action.execute - ", e);
					return mapping.findForward(Return);
				}
			}
			 
				
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} 

		}

		else if (frm.getNext().equals("page-4")) {
			errMsg = "";
			Return = "page-3";
			 errMsg = ValidationServiceIAFT3.IsIAFT3Page3(frm);

			try {
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_3(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					request.setAttribute("TenYearsBack",Helper.getBackYears(10));
					request.setAttribute("TwoYearsBack",Helper.getBackYears(2));
					
					//DB saving validation
					logger.debug("going to retrieve");
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page3(frm);
				
					logger.debug(errMsg);
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("TenYearsBack",Helper.getBackYears(10));
						request.setAttribute("TwoYearsBack",Helper.getBackYears(2));
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					
					Return = "page-4";

				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
				return mapping.findForward(Return);
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				request.setAttribute("TenYearsBack",Helper.getBackYears(10));
				request.setAttribute("TwoYearsBack",Helper.getBackYears(2));
	
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-5")) {
			try {
				frm.setFormtitle(request.getSession().getAttribute("frmHeader").toString());
				errMsg = "";
				Return = "page-4";
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page4(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_4(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);

					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page4(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-5";
				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
				return mapping.findForward(Return);
			}
			logger.debug(Return + ">>>>>>>>" + errMsg);
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
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page5(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_5(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page5(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-6";
				}
			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
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
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page6(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_6(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page6(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-7";
				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-8")) {
			try {
				frm.setFormtitle(request.getSession().getAttribute("frmHeader").toString());
				errMsg = "";
				Return = "page-7";
				errMsg = ValidationServiceIAFT3.IsIAFT3Page7(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_7(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page7(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
				}
			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
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
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page8(frm);
				if (errMsg == "") {
					Return = "page-9";
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_8(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page8(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-9";
				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-10")) {
			try {
				errMsg = "";
				Return = "page-9";
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page9(frm);
				 String have_rep=frm.getHave_rep();
				if (errMsg == "") {
					logger.debug(">>>>>>>>>>>>>>>>>>>>>>>"+frm.getEmail());
					request.getSession().setAttribute("email", frm.getEmail());
					}
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder3.IAFT3_9(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT3", frm);
					
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					frm.setHave_rep(have_rep);
					errMsg = ValidationServiceIAFT3.IsIAFT3Page9(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT3", frm);
						return mapping.findForward(Return);
					}
					//end
					if (have_rep.equals("Yes")) {
						Return = "page-10";
					} else {
						QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
								.toString(), "Completed");
						Return = "success";
					
				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
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
				Return = "page-10";
				 errMsg = ValidationServiceIAFT3.IsIAFT3Page10(frm);
				if (errMsg == "") {
					Return = "success";
					DataSource datasource = getDataSource(request);
					QueryBuilder3.IAFT3_10(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString());
					// request.setAttribute("frmIAFT3",frm);
					
					//DB saving validation
					frm = QueryBuilder3.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT3.IsIAFT3Page10(frm);
					QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
					if(errMsg!="")
					{
						Return="page-10";
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "success";
				}

			} catch (Exception e) {
				logger.error("Submission3Action.execute - ", e);
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
