package com.MOJICT.IACFee.Actions;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowLatestSubmissions extends Action{
	 /**
	   * log4j logging solution
	   */
	  static Logger logger = Logger.getLogger(ShowLatestSubmissions.class);
	  
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws IOException, ServletException, Exception
 {
	 		logger.info("ShowLatestSubmissions.execute");
		  	request.setAttribute("file",fileToString("/opt/moj/IACFees.files/IAC_Submissions/Status_Files/status.log"));
		  	return mapping.findForward("success");
 }

	  
	  
	  public static String fileToString(String file) {
	        String result = null;
	        DataInputStream in = null;

	        try {
	        	//logger.debug();
	            File f = new File(file);
	            logger.debug(f.getAbsolutePath());
	            byte[] buffer = new byte[(int) f.length()];
	            in = new DataInputStream(new FileInputStream(f));
	            in.readFully(buffer);
	            result = new String(buffer);
	        } catch (IOException e) {
	            throw new RuntimeException("IO problem in fileToString", e);
	        } finally {
	            try {
	                in.close();
	            } catch (IOException e) { /* ignore it */
	            }
	        }
	        return result;
	    }
	  
}
