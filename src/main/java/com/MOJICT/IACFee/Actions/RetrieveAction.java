// TODO - Differences between master and production.

package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;

public class RetrieveAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(RetrieveAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, Exception {
		logger.info("RetrieveAction.execute");
		logger.debug("**************************************");
		IAFT1Bean frm = (IAFT1Bean) form;
		IAFT1Bean frm1 = (IAFT1Bean) form;
		IAFT2Bean frm2 = new IAFT2Bean();
		IAFT3Bean frm3 = new IAFT3Bean();
		IAFT5Bean frm5 = new IAFT5Bean();
		IAFT6Bean frm6 = new IAFT6Bean();
		IAFT7Bean frm7 = new IAFT7Bean();

		try {
			if (frm.getSecuritytoken() != null)
			{
				frm.setSecuritytoken(frm.getSecuritytoken().trim().substring(6));
				logger.debug(frm.getSecuritytoken().trim());
			}
			else
			{
				frm.setSecuritytoken(request.getSession().getAttribute("token").toString());
				logger.debug(frm.getSecuritytoken());
			}
			request.getSession().setAttribute("token", frm.getSecuritytoken());
			request.getSession().setAttribute("paymenttype", "submission");
			//frm1.setSecuritytoken(frm1.getSecuritytoken().substring(6));
			DataSource datasource = getDataSource(request);
			//frm=QueryBuilder.IAFT1_1(frm,"retrieve",datasource,frm.getSecuritytoken(),request);
			//frm2=QueryBuilder2.IAFT2_1(frm2,"retrieve",datasource,frm.getSecuritytoken(),request);
			//frm=QueryBuilder.IAFT1_1(frm,"retrieve",datasource,frm.getSecuritytoken(),request);
		 if(QueryBuilder.IAFT1_1(frm,"retrieve",datasource,frm.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
		 
				frm = QueryBuilder.IAFT1_1(frm, "retrieve", datasource, frm.getSecuritytoken(), request);
				logger.debug("frm1" + frm.getQb_LAR() + ">>>>>>" + frm.getName1());
				//form=frm;
				request.setAttribute("frmIAFT1", frm);
				//request.set("frmIAFT1",frm);
				return mapping.findForward("IAFT1");
		 }
		 else
		 {
				//frm1.setSecuritytoken(frm1.getSecuritytoken().substring(6));
				//logger.debug(">>>>>>>>>>>>IAFT2"+frm1.getSecuritytoken());
				frm2.setSecuritytoken(frm1.getSecuritytoken());
			}
		 if(QueryBuilder2.IAFT2_1(frm2,"retrieve",datasource,frm2.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
				frm2 = QueryBuilder2.IAFT2_1(frm2, "retrieve", datasource, frm2.getSecuritytoken(), request);

				logger.debug(frm2.getSecuritytoken() + "IAFT2>>>>>>" + frm2.getAppeal_type());
				//form=frm;
				request.setAttribute("frmIAFT2", frm2);
				logger.debug("frm2" + frm2.getSecuritytoken());
				return mapping.findForward("IAFT2");
		 }
		 else
		 {
				frm3.setSecuritytoken(frm1.getSecuritytoken());
			}
		 if(QueryBuilder3.IAFT3_1(frm3,"retrieve",datasource,frm3.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
				frm3 = QueryBuilder3.IAFT3_1(frm3, "retrieve", datasource, frm3.getSecuritytoken(), request);

				//logger.debug(frm3.getSecuritytoken()+"IAFT2>>>>>>"+frm3.getAppeal_type());
				//form=frm;
				request.setAttribute("frmIAFT3", frm3);
				logger.debug("frm3" + frm3.getSecuritytoken());
				return mapping.findForward("IAFT3");
		 }
		 else
		 {
				frm5.setSecuritytoken(frm1.getSecuritytoken());
			}
		 if(QueryBuilder5.IAFT5_1(frm5,"retrieve",datasource,frm5.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
				frm5 = QueryBuilder5.IAFT5_1(frm5, "retrieve", datasource, frm5.getSecuritytoken(), request);

				logger.debug(frm5.getSecuritytoken() + "IAFT5>>>>>>" + frm5.getAppeal_type());
				//form=frm;
				request.setAttribute("frmIAFT5", frm5);
				logger.debug("frm5" + frm5.getSecuritytoken());
				return mapping.findForward("IAFT5");
		 }
		 else
		 {
				frm6.setSecuritytoken(frm1.getSecuritytoken());
			}
		 if(QueryBuilder6.IAFT6_1(frm6,"retrieve",datasource,frm6.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
				frm6 = QueryBuilder6.IAFT6_1(frm6, "retrieve", datasource, frm6.getSecuritytoken(), request);

				logger.debug(frm5.getSecuritytoken() + "IAFT5>>>>>>" + frm6.getAppeal_type());
				//form=frm;
				request.setAttribute("frmIAFT6", frm6);
				logger.debug("frm6" + frm6.getSecuritytoken());
				return mapping.findForward("IAFT6");
		 }
		 else
		 {
				frm7.setSecuritytoken(frm1.getSecuritytoken());
			}
		 if(QueryBuilder7.IAFT7_1(frm7,"retrieve",datasource,frm7.getSecuritytoken(),request).getAppeal_type()!=null)
		 {
				frm7 = QueryBuilder7.IAFT7_1(frm7, "retrieve", datasource, frm7.getSecuritytoken(), request);

				logger.debug(frm7.getSecuritytoken() + "IAFT5>>>>>>" + frm7.getAppeal_type());
				//form=frm;
				request.setAttribute("frmIAFT7", frm7);
				logger.debug("frm7" + frm7.getSecuritytoken());
				return mapping.findForward("IAFT7");
			}

			String errMsg = "Please enter valid security token";
			request.setAttribute("errMsg", errMsg);
			frm.setSecuritytoken("");
			request.setAttribute("frmIAFT1", frm);
			return mapping.findForward("failure");

		  }
		  catch(Exception e)
		  {
			logger.error("RetrieveAction.execute - ", e);
			return mapping.findForward("failure");
		}
		//return mapping.findForward("success");
	}
}
