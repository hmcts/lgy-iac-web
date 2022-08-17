package com.MOJICT.IACFee.Actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.MOJICT.IACFee.Beans.IAFT1Bean;
import com.MOJICT.IACFee.Beans.IAFTBean;
import com.MOJICT.IACFee.Beans.IAFTBeanFactory;
import com.MOJICT.IACFee.Util.*;
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

public class DownloadPDFAction extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(DownloadPDFAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, Exception {

		IAFT1Bean frm = (IAFT1Bean) form;
		IAFT2Bean frm2 = new IAFT2Bean();
		IAFT3Bean frm3 = new IAFT3Bean();
		IAFT5Bean frm5 = new IAFT5Bean();
		IAFT6Bean frm6 = new IAFT6Bean();
		IAFT7Bean frm7 = new IAFT7Bean();

		ServletContext context = servlet.getServletContext();
		String path = context.getRealPath("/");
		// Assumptions saved in session

		String paymentStatus = "failed";
		String security = request.getParameter("token").toString();
		
		DataSource datasource = getDataSource(request);
		ByteArrayOutputStream baos=null;
		try {
			IAFTBean iBean = IAFTBeanFactory.getBeanInstance(security,
					datasource, request);
			
			
			
			
			if(iBean.getType().equals("IAFT1"))
			{
				frm=(IAFT1Bean)iBean;
				// Generate pdf file
				
			baos = PDFUtilityIAFT1.GenerateIAFT1PDF(path, paymentStatus,
					frm);
			}
			if(iBean.getType().equals("IAFT2"))
			{
				frm2=(IAFT2Bean)iBean;
			// Generate pdf file
			baos = PDFUtilityIAFT2.GenerateIAFT2PDF(path, paymentStatus,
					frm2);
			}
			if(iBean.getType().equals("IAFT3"))
			{
				frm3=(IAFT3Bean)iBean;
			// Generate pdf file
			baos = PDFUtilityIAFT3.GenerateIAFT3PDF(path, paymentStatus,
					frm3);
			}
			if(iBean.getType().equals("IAFT5"))
			{
				frm5=(IAFT5Bean)iBean;
			// Generate pdf file
			baos = PDFUtilityIAFT5.GenerateIAFT5PDF(path, paymentStatus,
					frm5);
			}
			if(iBean.getType().equals("IAFT6"))
			{
				frm6=(IAFT6Bean)iBean;
			// Generate pdf file
			baos = PDFUtilityIAFT6.GenerateIAFT6PDF(path, paymentStatus,
					frm6);
			}
			if(iBean.getType().equals("IAFT7"))
			{
				frm7=(IAFT7Bean)iBean;
			// Generate pdf file
			baos = PDFUtilityIAFT7.GenerateIAFT7PDF(path, paymentStatus,
					frm7);
			}
			// Flusing pdf file
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
			out.close();

			return mapping.findForward("success");

		} catch (Exception ex) {
			ex.getMessage();
			logger.error("DownloadPDFAction.execute - ", ex);
			return mapping.findForward("failure");
		}
	}
}
