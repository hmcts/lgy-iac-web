package com.MOJICT.IACFee.Actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.MOJICT.IACFee.Util.PDFUtilityCoverSheet;

public class CoverSheetAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(CoverSheetAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		ServletContext context = servlet.getServletContext();
		String path = context.getRealPath("/");
		// Assumptions saved in session
		
		
		//String ref = request.getAttribute("ref").toString();
	
		ByteArrayOutputStream baos=null;
		try {
			DynaActionForm frm = (DynaActionForm) form;
			String ref=frm.get("exemption").toString();
		
			baos = PDFUtilityCoverSheet.GenerateCoverSheet(path, ref);
			
			// Flusing pdf file
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
			out.close();
			return mapping.findForward("success");

		} catch (Exception ex) {
			logger.error("CoverSheetAction.execute - ", ex);
			return mapping.findForward("failure");
		}
	}
}
