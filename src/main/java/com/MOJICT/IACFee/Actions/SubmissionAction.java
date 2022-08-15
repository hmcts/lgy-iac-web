package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.IAFT1Bean;
import com.MOJICT.IACFee.Util.Helper;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.IAFT2Bean;
import com.MOJICT.IACFee.Beans.IAFT3Bean;
import com.MOJICT.IACFee.Beans.IAFT5Bean;
import com.MOJICT.IACFee.Beans.IAFT6Bean;
import com.MOJICT.IACFee.Beans.IAFT7Bean;
import com.MOJICT.IACFee.Util.QueryBuilder;
import com.MOJICT.IACFee.Util.ValidationServiceIAFT1;

public class SubmissionAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(SubmissionAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("SubmissionAction.execute");

		IAFT1Bean frm = (IAFT1Bean) form;

		String errMsg = "";
		String Return = "fail";
		String dberror="Your information is not saved please try again.";
		
		
     
		if (request.getParameter("next").toString().equals("new")) {
			try {
				errMsg = "";
				Return = "page-9";
				// errMsg = ValidationServiceIAFT1.IsIAFT1Page9(frm);
				if (errMsg == "") {
					Return = "success";
					DataSource datasource = getDataSource(request);
					logger.debug("Its aggregated submission");
					frm = QueryBuilder.IAFT_new(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					
					frm = new IAFT1Bean();
					request.setAttribute("frmIAFT1", frm);
					request.setAttribute("frmIAFT2", new IAFT2Bean());
					request.setAttribute("frmIAFT3", new IAFT3Bean());
					request.setAttribute("frmIAFT5", new IAFT5Bean());
					request.setAttribute("frmIAFT6", new IAFT6Bean());
					request.setAttribute("frmIAFT7", new IAFT7Bean());
					



				}

			} catch (Exception e) {
				logger.error("SubmissionAction.execute - ", e);
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else
				return mapping.findForward(Return);
		}

		if (frm.getNext().equals("page-2")) {
			Return = "page-1";
			
			errMsg = ValidationServiceIAFT1.IsIAFT1Page1(frm);
			
			if (errMsg == "") {
				try {

					DataSource datasource = getDataSource(request);

					if (request.getSession().getAttribute("token1") != null) {

						

						frm = QueryBuilder.IAFT1_1(frm, "save", datasource, request.getSession().getAttribute("token1")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT1.IsIAFT1Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT1", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT1", frm);
						
						request.setAttribute("TwoYearsPlusMinus", Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						

					} else {
						
						frm = QueryBuilder.IAFT1_1(frm, "save", datasource, request.getSession().getAttribute("token")
								.toString(), request);
						
						//DB saving validation
						frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT1.IsIAFT1Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("frmIAFT1", frm);
							request.setAttribute("errMsg", dberror);
							return mapping.findForward(Return);
						}
						//end
						
						Return = "page-2";
						request.setAttribute("frmIAFT1", frm);
						request.getSession().setAttribute("token1", request.getSession().getAttribute("token"));
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						return mapping.findForward(Return);
						
					}

				} catch (Exception e) {
					logger.error("SubmissionAction.execute - ", e);
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
			errMsg = ValidationServiceIAFT1.IsIAFT1Page2(frm);
			if (errMsg == "") {
				try {

					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_2(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 2");
					errMsg = ValidationServiceIAFT1.IsIAFT1Page2(frm);
					logger.debug("After revalidation paeg 2 "+ errMsg);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
				
					Return = "page-3";
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					request.setAttribute("frmIAFT1", frm);
					return mapping.findForward(Return);

				}

				catch (Exception e) {
					
					//DB saving validation
					request.setAttribute("frmIAFT1", frm);
					request.setAttribute("TwoYearsPlusMinus",Helper.getTwoYearsPlusMinus());
					logger.error("SubmissionAction.execute - ", e);
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
			errMsg = ValidationServiceIAFT1.IsIAFT1Page3(frm);

			try {
				if (errMsg == "") {
					DataSource datasource = getDataSource(request);
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					frm = QueryBuilder.IAFT1_3(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					
					logger.debug("Before revalidation paeg 3");
					errMsg = ValidationServiceIAFT1.IsIAFT1Page3(frm);
					logger.debug("After revalidation paeg 3 "+ errMsg);
		
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-4";
					request.setAttribute("frmIAFT1", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT1", frm);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());

				logger.error("SubmissionAction.execute - ", e);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page4(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_4(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT1.IsIAFT1Page4(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-5";
					request.setAttribute("frmIAFT1", frm);

				}
				
				

			} catch (Exception e) {
				logger.error("SubmissionAction.execute - ", e);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				request.setAttribute("frmIAFT1", frm);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page5(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_5(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT1.IsIAFT1Page5(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-6";
					request.setAttribute("frmIAFT1", frm);
				}
			} catch (Exception e) {
				logger.error("SubmissionAction.execute - ", e);
				request.setAttribute("frmIAFT1", frm);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page6(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_6(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					//errMsg = ValidationServiceIAFT1.IsIAFT1Page6(frm);
					logger.debug("Error message is "+errMsg);
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-7";
					request.setAttribute("frmIAFT1", frm);
				}

			} catch (Exception e) {
				logger.error("SubmissionAction.execute - ", e);
				request.setAttribute("frmIAFT1", frm);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page7(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_7(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT1.IsIAFT1Page7(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-8";
					request.setAttribute("frmIAFT1", frm);
				}
			} catch (Exception e) {
				request.setAttribute("frmIAFT1", frm);
				logger.error("SubmissionAction.execute - ", e);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page8(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_8(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT1.IsIAFT1Page8(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-9";
					request.setAttribute("frmIAFT1", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT1", frm);
				logger.error("SubmissionAction.execute - ", e);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page9(frm);
				String have_rep=frm.getHave_rep();
				if (errMsg == "") {
					logger.debug(">>>>>>>>>>>>>>>>>>>>>>>"+frm.getEmail());
					request.getSession().setAttribute("email", frm.getEmail());
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder.IAFT1_9(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					frm.setHave_rep(have_rep);
					errMsg = ValidationServiceIAFT1.IsIAFT1Page9(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end
					if (have_rep.equals("Yes")) {
						Return = "page-10";
					} else {
						logger.debug("Coming here to complketed status");
						QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
						Return = "success";
					}
					request.setAttribute("frmIAFT1", frm);
				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT1", frm);
				logger.error("SubmissionAction.execute - ", e);
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
				errMsg = ValidationServiceIAFT1.IsIAFT1Page10(frm);
				if (errMsg == "") {
					Return = "success";
					DataSource datasource = getDataSource(request);
					QueryBuilder.IAFT1_10(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString());
					//DB saving validation
					frm = QueryBuilder.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT1.IsIAFT1Page10(frm);
					QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
					if(errMsg!="")
					{
						request.setAttribute("frmIAFT1", frm);
						request.setAttribute("errMsg", dberror);
						return mapping.findForward(Return);
					}
					//end

				}

			} catch (Exception e) {
				request.setAttribute("frmIAFT1", frm);
				logger.error("SubmissionAction.execute - ", e);
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
