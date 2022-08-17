package com.MOJICT.IACFee.Actions;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class AmountfrwAction extends Action{
	/**
	* log4j logging solution
	*/
	static Logger logger = Logger.getLogger(AmountfrwAction.class);
	
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException, Exception
  {
	  		logger.info("AmountfrwAction.execute");
			int count=0;
		    request.getSession().setAttribute("count", count);
	    
		  return mapping.findForward("success");
		 
}

		 	 
		 

}