package com.MOJICT.IACFee.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.QueryBuilder;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;

public class DeleteAction extends Action{
	 /**
	   * log4j logging solution
	   */
	  static Logger logger = Logger.getLogger(DeleteAction.class);
	  
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException, Exception
  {
		  logger.debug("**************************************");


		  IAFT1Bean frm=(IAFT1Bean)form;
		  IAFT1Bean frm1=(IAFT1Bean)form;
		  IAFT2Bean frm2=new IAFT2Bean();
		  IAFT3Bean frm3=new IAFT3Bean();
		  IAFT5Bean frm5=new IAFT5Bean();
		  IAFT6Bean frm6=new IAFT6Bean();
		 
		  try{
			  if(frm.getSecuritytoken()!=null)
			  {
			  frm.setSecuritytoken(frm.getSecuritytoken().trim().substring(6));
			  logger.debug(frm.getSecuritytoken().trim());
			  }
			  else
			  {
				  frm.setSecuritytoken( request.getSession().getAttribute("token").toString());
				  logger.debug(frm.getSecuritytoken());
			  }
			  request.getSession().setAttribute("token", frm.getSecuritytoken());
			  request.getSession().setAttribute("paymenttype","submission");
			  //frm1.setSecuritytoken(frm1.getSecuritytoken().substring(6));
		 DataSource datasource=getDataSource(request);	  
		 //frm=QueryBuilder.IAFT1_1(frm,"retrieve",datasource,frm.getSecuritytoken(),request);
		 //frm2=QueryBuilder2.IAFT2_1(frm2,"retrieve",datasource,frm.getSecuritytoken(),request);
		 //frm=QueryBuilder.IAFT1_1(frm,"retrieve",datasource,frm.getSecuritytoken(),request);
		 String status= QueryBuilder.updateappealstatus(datasource, frm.getSecuritytoken(),"Deleted");
		 return mapping.findForward(status);
		 
		  }
		  catch(Exception e)
		  {
			  logger.error("DeleteAction.execute - ", e);
			  return mapping.findForward("failure");
		  }
		  //return mapping.findForward("success");
  }
}
