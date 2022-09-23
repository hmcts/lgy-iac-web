package com.MOJICT.IACFee.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import com.MOJICT.IACFee.Beans.IAFT2Bean;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PDFUtilityIAFT2 extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PDFUtilityIAFT2.class);

	// 37749672

	// static String
	// tmp="WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
	// +"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT";

	public static ByteArrayOutputStream GenerateIAFT2PDF(String path, String paymentStatus, IAFT2Bean frm)
			throws IOException, DocumentException {

		try {
			logger.info("PDFUtilityIAFT2.GenerateIAFT2PDF - Security Token: " + frm.getSecuritytoken() + " path: " + path);
			String template = "";

			if (paymentStatus != "failed")
				template = "templates/IAFT2-online.pdf";
			else
				template = "templates/IAFT2-online.pdf";

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

				// Appeal Type
				if (frm.getAppeal_type().equals("Oral"))
					form.setField("qa_rdo", "1");
				else
					form.setField("qa_rdo", "2");

				// Evidence
				if (frm.getQa_sponsor() != null)
					form.setField("qb_sponsor", "1");
				if (frm.getQa_rep() != null)
					form.setField("qb_rep", "1");
				if (frm.getQa_witness() != null)
					form.setField("qb_witness", "1");

				if (frm.getQb_lsc().equals("Yes")) {
					form.setField("qc_rdo", "1");
					form.setField("qc_LAR", frm.getQb_LAR());

				}
				if (frm.getQb_lsc().equals("No"))
					form.setField("qc_rdo", "2");

				// Family
				if (frm.getFamily_member().equals("Yes"))

				{

					form.setField("qd_rdo", "2");
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
					form.setField("qd_rdo", "1");

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
					form.setField("payment_amount",  String.valueOf(frm.getPaymentvalue()));
					form.setField("appeal_lodged", dateconverter.convertdate(new Date()));
				}

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			// Page 2
			try {

				// Type of decision

				if (frm.getS1_tod().equals("Settlement"))
					form.setField("tod_rdo", "1");

				if (frm.getS1_tod().equals("Non Settlement"))
					form.setField("tod_rdo", "2");

				if (frm.getS1_tod().equals("Family Visit"))
					form.setField("tod_rdo", "3");

				// Detail
				form.setField("s1a", frm.getS1a());
				form.setField("s1b", frm.getS1b());
				form.setField("s1c", frm.getS1c());
				// date
				if (frm.getS1d_dob_day() != 0)
					form.setField("s1d",
							frm.getS1d_dob_day() + "/" + frm.getS1d_dob_month() + "/" + frm.getS1d_dob_year());

				// Sex
				if (frm.getS1e().equals("Male"))
					form.setField("s1e_rdo", "1");
				else
					form.setField("s1e_rdo", "2");

				// Address
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
					form.setField("s1g", Helper.returnStringValue(frm.getS1g()));

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			// Page 3
			try {

				// Section 2
				if (frm.getS2a().equals("Yes")) {
					form.setField("s2a_rdo", "2");
					logger.debug(frm.getS2a());
				} else if (frm.getS2a().equals("No"))
					form.setField("s2a_rdo", "1");

				if (frm.getS2b() != null)
					form.setField("s2b", frm.getS2b());
				if (frm.getS2c() != null)
					form.setField("s2c", Helper.returnStringValue(frm.getS2c()));
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
				if (frm.getS2e_day() != 0)
					form.setField("s2e", frm.getS2e_day() + "/" + frm.getS2e_month() + "/" + frm.getS2e_year());

				if (frm.getS2i_day() != 0)
					form.setField("s2f",frm.getS2i_day() + "/" + frm.getS2i_month() + "/"+ frm.getS2i_year());

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			// Page 4
			try {
				// Section 3
				if (frm.getS3a() != null)
					form.setField("s3a", frm.getS3a());

				if (frm.getS3b() != null)
					form.setField("s3b", frm.getS3b());

				if (frm.getS3c() != null)
					form.setField("s3c", frm.getS3c());
			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			// Page 5

			try {

				if (frm.getS3d_1() != null) {
					if (frm.getS3d_1().length() <= 3038)
						form.setField("s3d", frm.getS3d_1());
					else {
						form.setField("s3d", frm.getS3d_1().substring(0, 3038));
						// split the data here
						String t = frm.getS3d_1().substring(3038, frm.getS3d_1().length());
						form.setField("s3d_cont", t);

					}
				}

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

				if (frm.getS3f().equals("Yes")) {

					form.setField("s3f_rdo", "2");
					form.setField("s3f_who", frm.getS3f_who());
					form.setField("s3f_language", frm.getS3f_language());
					form.setField("s3f_dialect", frm.getS3f_dialect());

				} else
					form.setField("s3f_rdo", "1");

				if (frm.getS3g() != null)
					form.setField("s3g", frm.getS3g()); // Rohan to look at

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			// Page 6
			try {

			} catch (Exception ex) {
				logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
			}

			if (frm.getHave_rep().equals("No")) {
				try {
					// Section 4
					form.setField("s4_agreed", "1");
					form.setField("s4_date", dateconverter.convertdate(new java.util.Date()));

				} catch (Exception ex) {
					logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
				}

			}

			if (frm.getHave_rep().equals("Yes")) {

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
					logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
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
					if (frm.getS5i() != null) {
						if (!frm.getS5i().equals("0"))
							form.setField("s5i", frm.getS5i());
					}
					if (frm.getS5j() != null) {
						form.setField("s5j", frm.getS5j());
					}

					if (!frm.getS4_decalaration().equals("Appellant_agreed")) {
						form.setField("s5_rep_agreed", "1");
						form.setField("s5_rep_date", dateconverter.convertdate(new java.util.Date()));
					} else {
						// Section 4
						form.setField("s4_agreed", "1");
						form.setField("s4_date", dateconverter.convertdate(new java.util.Date()));
					}

					if (!frm.getQb_lsc().equals("No")) {
						form.setField("s5_la_rep_agreed", "1");
						form.setField("s5_la_rep_date", dateconverter.convertdate(new java.util.Date()));
					}

				} catch (Exception ex) {
					logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
				}

			}

			if (frm.getHave_sponsor().equals("Yes")) {

				try {
					// Section6

					// form.setField("s6b","Adi");

					if (frm.getS6a() != null)
						form.setField("s6a", frm.getS6a());
					if (frm.getS6b() != null)
						form.setField("s6b", frm.getS6b());
					if (frm.getS6c() != null)
						form.setField("s6c", frm.getS6c());

					if (frm.getS6d_addr1() != null)
						form.setField("s6d_addr1", frm.getS6d_addr1());
					if (frm.getS6d_addr2() != null)
						form.setField("s6d_addr2", frm.getS6d_addr2());
					if (frm.getS6d_addr3() != null)
						form.setField("s6d_addr3", frm.getS6d_addr3());
					if (frm.getS6d_addr4() != null)
						form.setField("s6d_addr4", Helper.returnStringValue(frm.getS6d_addr4()));
					if (frm.getS6d_postcode() != null)
						form.setField("s6d_postcode", frm.getS6d_postcode());

					if (frm.getS6e() != null)
						form.setField("s6e", frm.getS6e());
					if (frm.getS6f() != null)
						form.setField("s6f", frm.getS6f());
					if (frm.getS6_auth() != null) {
						if (frm.getS6_auth().equals("Yes")) {
							form.setField("s6_auth_rdo", "1");
							form.setField("s6_agreed", "1"); // on
							form.setField("s6_date", dateconverter.convertdate(new java.util.Date()));
						} else if (frm.getS6_auth().equals("No"))
							form.setField("s6_auth_rdo", "2");
					}

				} catch (Exception ex) {
					logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
				}

			}

			stamper.setFormFlattening(true);
			stamper.close();

			return baos;

		} catch (Exception ex) {
			logger.error("PDFUtilityIAFT2.GenerateIAFT2PDF", ex);
		}

		return null;

	}

}
