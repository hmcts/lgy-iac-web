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
import com.MOJICT.IACFee.Util.QueryBuilder;
import com.MOJICT.IACFee.Util.QueryBuilder2;

import com.MOJICT.IACFee.Util.ValidationServiceIAFT2;

public class Submission2Action extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Submission2Action.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		logger.info("Submission2Action.execute");

		IAFT2Bean frm = (IAFT2Bean) form;

		String errMsg = "";
		String Return = "fail";
		String have_sponsor;
		String have_rep;
		String dberror="Your information is not saved please try again.";

		if (frm.getNext().equals("page-2")) {
			// Return = "page-2";

			Return = "page-1";
			errMsg = ValidationServiceIAFT2.IsIAFT2Page1(frm);
			if (errMsg == "") {
				try {

					DataSource datasource = getDataSource(request);

					if (request.getSession().getAttribute("token1") != null) {

						
                        logger.debug("IAFT2 Page 1 save token1 is "+request.getSession().getAttribute("token1").toString());
						frm = QueryBuilder2.IAFT2_1(frm, "save", datasource, request.getSession()
								.getAttribute("token1").toString(), request);
						request.setAttribute("frmIAFT2", frm);

						//DB saving validation
						frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT2.IsIAFT2Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("errMsg", dberror);
							request.setAttribute("frmIAFT2", frm);
							return mapping.findForward(Return);
						}
						//end
						Return = "page-2";
						

					} else {
						
						frm = QueryBuilder2.IAFT2_1(frm, "save", datasource, request.getSession().getAttribute("token")
								.toString(), request);
						logger.debug("IAFT2 Page 1 save token is "+request.getSession().getAttribute("token").toString());
						request.setAttribute("frmIAFT2", frm);
						request.getSession().setAttribute("token1", request.getSession().getAttribute("token"));
						
						//DB saving validation
						frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
						errMsg="";
						errMsg = ValidationServiceIAFT2.IsIAFT2Page1(frm);
						
						if(errMsg!="")
						{
							request.setAttribute("errMsg", dberror);
							request.setAttribute("frmIAFT2", frm);
							return mapping.findForward(Return);
						}
						//end
						Return = "page-2";
	

					}

				} catch (Exception e) {
					e.printStackTrace();
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

			// Return = "page-3";

			errMsg = "";
			Return = "page-2";
			errMsg = ValidationServiceIAFT2.IsIAFT2Page2(frm);
			if (errMsg == "") {
				try {

					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder2.IAFT2_2(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("CurrentAndTwoFormerYears", Helper.getCurrentAndTwoFormerYears());
					request.setAttribute("frmIAFT2", frm);
					
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page2(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-3";


				}

				catch (Exception e) {
					e.printStackTrace();
					return mapping.findForward(Return);
				}
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
				return mapping.findForward(Return);
			} else

				return mapping.findForward(Return);

		}

		else if (frm.getNext().equals("page-4")) {
			// Return = "page-4";

			errMsg = "";
			Return = "page-3";
			errMsg = ValidationServiceIAFT2.IsIAFT2Page3(frm);

			try {
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					logger.debug("We are saving the page 3 data");
					request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
					frm = QueryBuilder2.IAFT2_3(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page3(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						request.setAttribute("CurrentAndTwoFormerYears",Helper.getCurrentAndTwoFormerYears());
						return mapping.findForward(Return);
					}
					//end
					Return = "page-4";

				}

			} catch (Exception e) {
				e.printStackTrace();
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
			// Return = "page-5";

			try {
				errMsg = "";
				
				errMsg = ValidationServiceIAFT2.IsIAFT2Page4(frm);
				if (errMsg == "") {
					Return = "page-5";
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder2.IAFT2_4(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page4(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-5";

				}

			} catch (Exception e) {
				e.printStackTrace();
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
			// Return = "page-6";

			try {
				errMsg = "";
				Return = "page-5";
				errMsg = ValidationServiceIAFT2.IsIAFT2Page5(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder2.IAFT2_6(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page5(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "page-6";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else

				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-7")) {
			Return = "page-7";
			try {
				errMsg = "";
				Return = "page-6";
				errMsg = ValidationServiceIAFT2.IsIAFT2Page6(frm);
				String sponcer=frm.getHave_sponsor();
				String rep=frm.getHave_rep();
				if (errMsg == "") {
					logger.debug(">>>>>>>>>>>>>>>>>>>>>>>"+frm.getEmail());
					request.getSession().setAttribute("email", frm.getEmail());
									// Return = "page-7";
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder2.IAFT2_9(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
	
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page6(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					
					have_sponsor = sponcer;
					have_rep = rep;
					request.getSession().setAttribute("sponsor", have_sponsor);
					if (frm.getHave_rep().equals("Yes")) {
						Return = "page-7";
					} else if (frm.getHave_sponsor().equals("Yes")) {
						Return = "page-8";
					} else {
						QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
								.toString(), "Completed");
						Return = "success";
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			}
			return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("page-8")) {
			// Return = "page-7";

			try {
				errMsg = "";
				Return = "page-7";
				errMsg = ValidationServiceIAFT2.IsIAFT2Page7(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					frm = QueryBuilder2.IAFT2_7(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);
					request.setAttribute("frmIAFT2", frm);
					
					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page7(frm);
					
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					if (request.getSession().getAttribute("sponsor").toString().equals("Yes")) {
						Return = "page-8";
					} else {
						QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
								.toString(), "Completed");
						Return = "success";
					}
					return mapping.findForward(Return);
				}

			} catch (Exception e) {
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else

				return mapping.findForward(Return);
		}

		else if (frm.getNext().equals("finish")) {
			Return = "page-8";

			try {
				errMsg = "";
				Return = "page-8";
				errMsg = ValidationServiceIAFT2.IsIAFT2Page8(frm);
				if (errMsg == "") {
					
					DataSource datasource = getDataSource(request);
					QueryBuilder2.IAFT2_8(frm, "save", datasource, request.getSession().getAttribute("token")
							.toString(), request);

					//DB saving validation
					frm = QueryBuilder2.retrieve(frm, "retrieve", datasource, request.getSession().getAttribute("token1").toString(), request);
					errMsg="";
					errMsg = ValidationServiceIAFT2.IsIAFT2Page8(frm);
					QueryBuilder.updateappealstatus(datasource, request.getSession().getAttribute("token")
							.toString(), "Completed");
					if(errMsg!="")
					{
						request.setAttribute("errMsg", dberror);
						request.setAttribute("frmIAFT2", frm);
						return mapping.findForward(Return);
					}
					//end
					Return = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			if (errMsg != "") {
				request.setAttribute("errMsg", errMsg);
				return mapping.findForward(Return);
			} else

				return mapping.findForward(Return);
		}

		return mapping.findForward(Return);
	}
}
