package com.MOJICT.IACFee.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import com.MOJICT.IACFee.Beans.IAFT1Bean;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PDFUtilityIAFT1 extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PDFUtilityIAFT1.class);

	// 37749672

	// static String
	// tmp="WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT";

	public static ByteArrayOutputStream GenerateIAFT1PDF(String path, String paymentStatus, IAFT1Bean frm)
			throws IOException, DocumentException {

		try {
			logger.info("PDFUtilityIAFT1.GenerateIAFT1PDF - Security Token: " + frm.getSecuritytoken());
			String template = "";

			if (paymentStatus != "failed")
			
				template = "templates/IAFT1-online.pdf";
			else
				template = "templates/IAFT1-online.pdf";

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfReader reader = new PdfReader(path + template);
			PdfStamper stamper = new PdfStamper(reader, baos);
			AcroFields form = stamper.getAcroFields();

			// Page 1
			try {
			
				
				//status
				if(paymentStatus.equals("Success"))
					form.setField("submission_txt", "Appeal Submitted Online");
				
				
				else if(paymentStatus.equals("failed"))
					form.setField("submission_txt", "Payment Declined");
				else
					form.setField("submission_txt", "Payment Unconfirmed");
				
				
				form.setField("header_title", frm.getFormtitle());
				
	
				// Appeal Type
				if (frm.getAppeal_type().equals("Oral"))
					form.setField("appeal_type_rdo", "1");
				else
					form.setField("appeal_type_rdo", "2");

				// Evidence
				if (frm.getQa_sponsor() != null)
					form.setField("qa_sponsor", "1");
				if (frm.getQa_rep() != null)
					form.setField("qa_rep", "1");
				if (frm.getQa_witness() != null)
					form.setField("qa_witness", "1");

				logger.debug(frm.getQb_lsc());

				// LSC
				if (frm.getQb_lsc().equals("LSC")) {
					form.setField("qb_rdo", "2");
					form.setField("qb_LAR", frm.getQb_LAR());
				}
				if (frm.getQb_lsc().equals("Asylum Support")) {
					form.setField("qb_rdo", "3");
					form.setField("qb_LAR", frm.getQb_LAR());
				}
				if (frm.getQb_lsc().equals("No")) {
					form.setField("qb_rdo", "1");

				}

				if (frm.getQb_lsc().equals("Section 17")) {
					form.setField("qb_rdo", "4");
					form.setField("qb_LAR", frm.getQb_LAR());
				}
				// Family
				if (frm.getFamily_member().equals("Yes"))

				{

					form.setField("qc_rdo", "2");
					form.setField("name1", frm.getName1());
					form.setField("name2", frm.getName2());
					form.setField("name3", frm.getName3());
					form.setField("name4", frm.getName4());

					form.setField("relationship1", frm.getRelationship1());
					form.setField("relationship2", frm.getRelationship2());
					form.setField("relationship3", frm.getRelationship3());
					form.setField("relationship4", frm.getRelationship4());

					form.setField("prn1", frm.getPrn1());
					form.setField("prn2", frm.getPrn2());
					form.setField("prn3", frm.getPrn3());
					form.setField("prn4", frm.getPrn4());

				} else
					form.setField("qc_rdo", "1");

				// Staff use only
				if (paymentStatus != "failed") {
					if(frm.getPaymentvalue()!=0)
					{
					if (frm.getAggregatedpaymentURN() == null) {
						form.setField("payment_urn", frm.getPaymentURN());
					} else {
						form.setField("payment_urn", frm.getAggregatedpaymentURN());
					}
					}
					form.setField("submission_urn", frm.getSubmissionURN());
					form.setField("payment_amount", String.valueOf(frm.getPaymentvalue()));
					form.setField("appeal_lodged", dateconverter.convertdate(new Date()));
				}

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			// Page 2
			try {

				// Ayslum

				if (frm.getFormtitle().equals("Asylum"))
					form.setField("tod_rdo", "1");
				else
					form.setField("tod_rdo", "2");

				// Appeal Type
				if (frm.getAppeal_type().equals("Oral"))
					form.setField("hearing_type2_rdo", "1");
				else
					form.setField("hearing_type2_rdo", "2");

				// detail
				form.setField("s1a", frm.getS1a());
				form.setField("s1b", frm.getS1b());
				form.setField("s1c", frm.getS1c());
				
				// date
				form.setField("s1d", frm.getS1d_dob_day() + "/" + frm.getS1d_dob_month() + "/" + frm.getS1d_dob_year());

				// sex
				if (frm.getS1e().equals("Male"))
					form.setField("s1e_rdo", "1");
				else
					form.setField("s1e_rdo", "2");

				// address
				if (frm.getS1f_addr1() != null)
					form.setField("s1f_addr1", frm.getS1f_addr1());
				if (frm.getS1f_addr2() != null)
					form.setField("s1f_addr2", frm.getS1f_addr2());
				if (frm.getS1f_addr3() != null)
					form.setField("s1f_addr3", frm.getS1f_addr3());
				if (frm.getS1f_addr4() != null)
					form.setField("s1f_addr4", Helper.returnStringValue(frm.getS1f_addr4()));
				if (frm.getS1f_postcode() != null)
					form.setField("s1f_postcode", frm.getS1f_postcode());
				if (frm.getS1f_email() != null)
					form.setField("s1f_email", frm.getS1f_email());

				if (frm.getS1g() != null)
					form.setField("s1g", frm.getS1g());
				if (frm.getS1h() != null)
					form.setField("s1h", Helper.returnStringValue(frm.getS1h()));

				if (frm.getS1i_yourself() != null)
					form.setField("s1i_yourself", "1");
				if (frm.getS1i_representative() != null)
					form.setField("s1i_representative", "1");
				if (frm.getS1i_witness() != null)
					form.setField("s1i_witness", "1");

				if (frm.getS1j().equals("Yes")) {
					form.setField("s1j_rdo", "2");
					form.setField("s1j_who", frm.getS1j_who());
					form.setField("s1j_language", frm.getS1j_language());
					form.setField("s1j_dialect", frm.getS1j_dialect());

				} else
					form.setField("s1j_rdo", "1");

				if (frm.getS1k() != null)
					form.setField("s1k", frm.getS1k());

				if (frm.getS1l().equals("Yes")) {
					form.setField("s1l_rdo", "1");
					form.setField("s1m", frm.getS1m());
					// date
					form.setField(
							"s1n",
							frm.getS1n_removal_day() + "/" + frm.getS1n_removal_month() + "/"
									+ frm.getS1n_removal_year());
				} else
					form.setField("s1l_rdo", "2");

				if (frm.getS1o().equals("Yes")) {
					form.setField("s1o_rdo", "1");
					form.setField(
							"s1p",
							frm.getS1p_sentence_day() + "/" + frm.getS1p_sentence_month() + "/"
									+ frm.getS1p_sentence_year());

					if (frm.getS1q().equals("AA"))
						form.setField("s1q_rdo", "1");
					else if (frm.getS1q().equals("BB"))
						form.setField("s1q_rdo", "2");
					else if (frm.getS1q().equals("CC"))
						form.setField("s1q_rdo", "3");
					else if (frm.getS1q().equals("DD"))
						form.setField("s1q_rdo", "4");

				} else
					form.setField("s1o_rdo", "2");

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			// Page 3
			try {
				// Section 2
				if (frm.getS2a() != null)
					form.setField("s2a", frm.getS2a());
				if (frm.getS2b() != null)
					form.setField("s2b", frm.getS2b());
				if (frm.getS2c() != null)
					form.setField("s2c", frm.getS2c());
				if (frm.getS2d_post() != null) {
					if (frm.getS2d_post().equals("Post"))
						form.setField("s2d_rdo", "1");
					else if (frm.getS2d_post().equals("Fax"))
						form.setField("s2d_rdo", "2");
					else if (frm.getS2d_post().equals("Courier"))
						form.setField("s2d_rdo", "3");

					if (frm.getS2d_other() != null)
						form.setField("s2d_other", frm.getS2d_other());
				}
				
				if (frm.getS2e_service_day() != 0)
					form.setField("s2e",frm.getS2e_service_day() + "/" + frm.getS2e_service_month() + "/"+ frm.getS2e_service_year());

				if (frm.getS2i_service_day() != 0)
					form.setField("s2f",frm.getS2i_service_day() + "/" + frm.getS2i_service_month() + "/"+ frm.getS2i_service_year());

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {
				// Section 3
				if (frm.getS3a() != null)
					form.setField("s3a", frm.getS3a());

				if (frm.getS3b() != null)
					form.setField("s3b", frm.getS3b());

				if (frm.getS3c() != null)
					form.setField("s3c", frm.getS3c());
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {

				// frm.setS3d_1(tmp);
				if (frm.getS3d_1() != null) 
						form.setField("s3d_1", frm.getS3d_1());

				// frm.setS3d_2(tmp);
				if (frm.getS3d_2() != null) 
						form.setField("s3d_2", frm.getS3d_2());
			
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {

				// frm.setS3d_3(tmp);
				if (frm.getS3d_3() != null)
						form.setField("s3d_3", frm.getS3d_3());

				// frm.setS3d_4(tmp);
				if (frm.getS3d_4() != null) 
						form.setField("s3d_4", frm.getS3d_4());
				
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {
				// frm.setS3d_5(tmp);
				if (frm.getS3d_5() != null) 
						form.setField("s3d_5", frm.getS3d_5());
				
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {

				// frm.setS3d_6(tmp);
				if (frm.getS3d_6() != null) 
						form.setField("s3d_6", frm.getS3d_6());

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {

				// frm.setS3d_7(tmp);
				if (frm.getS3d_7() != null) 
						form.setField("s3d_7", frm.getS3d_7());

				// frm.setS3d_8(tmp);
				if (frm.getS3d_8() != null) 
						form.setField("s3d_8", frm.getS3d_8());

				// frm.setS3d_additional(tmp);
				if (frm.getS3d_3() != null) 
						form.setField("S3d_additional", frm.getS3d_additional());
			
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {

				if (frm.getS3e().equals("Yes")) {
					form.setField("s3e_rdo", "2");
					if (frm.getS3e_date1_day() != 0) {
						form.setField("s3e_date1",
								frm.getS3e_date1_day() + "/" + frm.getS3e_date1_month() + "/" + frm.getS3e_date1_year());
						form.setField("s3e_appealno1", frm.getS3e_appealno1());
					}
					if (frm.getS3e_date2_day() != 0) {
						form.setField("s3e_date2",
								frm.getS3e_date2_day() + "/" + frm.getS3e_date2_month() + "/" + frm.getS3e_date2_year());
						form.setField("s3e_appealno2", frm.getS3e_appealno2());
					}
					if (frm.getS3e_date3_day() != 0) {
						form.setField("s3e_date3",
								frm.getS3e_date3_day() + "/" + frm.getS3e_date3_month() + "/" + frm.getS3e_date3_year());
						form.setField("s3e_appealno3", frm.getS3e_appealno3());
					}
				} else
					form.setField("s3e_rdo", "1");

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			try {
				// Duplicate Family

				if (frm.getFamily_member().equals("Yes")) {
					form.setField("s3f_rdo", "2");
					form.setField("s3f_name1", frm.getName1());
					form.setField("s3f_name2", frm.getName2());
					form.setField("s3f_name3", frm.getName3());
					form.setField("s3f_name4", frm.getName4());

					form.setField("s3f_relationship1", frm.getRelationship1());
					form.setField("s3f_relationship2", frm.getRelationship2());
					form.setField("s3f_relationship3", frm.getRelationship3());
					form.setField("s3f_relationship4", frm.getRelationship4());

					form.setField("s3f_appealno1", frm.getPrn1());
					form.setField("s3f_appealno2", frm.getPrn2());
					form.setField("s3f_appealno3", frm.getPrn3());
					form.setField("s3f_appealno4", frm.getPrn4());

				} else
					form.setField("s3f_rdo", "1");

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
			}

			if (frm.getHave_rep().equals("No"))

			{
				try {
					// Section 4
					form.setField("s4_declaration", "1");
					form.setField("s4_date", dateconverter.convertdate(new java.util.Date()));

				} catch (Exception ex) {
					logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
				}

			}

			if (frm.getHave_rep().equals("Yes"))

			{

				try {
					// Section5

					if (frm.getS5a() != null)
						form.setField("s5a", frm.getS5a());
					if (frm.getS5b() != null)
						if (frm.getS5b().equals("00"))
							form.setField("s5b", frm.getS5b_other());
						else
							form.setField("s5b", Helper.returnStringValue(frm.getS5b()));

					if (frm.getS5c_addr1() != null)
						form.setField("s5c_addr1", frm.getS5c_addr1());
					if (frm.getS5c_addr2() != null)
						form.setField("s5c_addr2", frm.getS5c_addr2());
					if (frm.getS5c_addr3() != null)
						form.setField("s5c_addr3", frm.getS5c_addr3());
					if (frm.getS5c_addr4() != null)
						form.setField("s5c_addr4", Helper.returnStringValue(frm.getS5c_addr4()));
					if (frm.getS5c_postcode() != null)
						form.setField("s5c_postcode", frm.getS5c_postcode());
				} catch (Exception ex) {

				}

				try {

					if (frm.getS5d() != null)
						form.setField("s5d", frm.getS5d());
					if (frm.getS5e() != null)
						form.setField("s5e", frm.getS5e());
					if (frm.getS5f() != null)
						form.setField("s5f", frm.getS5f());
					if (frm.getS5g() != null)
						form.setField("s5g", frm.getS5g());
					if (frm.getS5h() != null)
						form.setField("s5h", frm.getS5h());
					if (frm.getS5i() != null || !frm.getS5i().equals("0"))
						form.setField("s5i", frm.getS5i());
					if (frm.getS5j() != null && !frm.getS5j().equals("0"))
						form.setField("s5j", frm.getS5j());

					if (!frm.getS4_decalaration().equals("Appellant_agreed")) {
						form.setField("s5_rep_agreed", "1");
						form.setField("s5_date", dateconverter.convertdate(new java.util.Date()));
					}

					else {
						form.setField("s4_decalaration", "1");
						form.setField("s4_date", dateconverter.convertdate(new java.util.Date()));

					}

					if (!frm.getQb_lsc().equals("No") && frm.getQb_lsc().equals("LSC")) {
						form.setField("s5_legalaid", "1");
						form.setField("s5_legalaid_date", dateconverter.convertdate(new java.util.Date()));
					}

				} catch (Exception ex) {

				}

			}
			stamper.setFormFlattening(true);
			stamper.close();

			return baos;

		} catch (Exception ex) {
			logger.error("PDFUtilityIAFT1.GenerateIAFT1PDF", ex);
		}

		return null;

	}

}