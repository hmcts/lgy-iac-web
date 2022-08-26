package com.MOJICT.IACFee.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PDFUtilityCoverSheet extends Action {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(PDFUtilityCoverSheet.class);

	
	public static ByteArrayOutputStream GenerateCoverSheet(String path,String ref)
			throws IOException, DocumentException {

		try {
			String template = "";
			template = "templates/cover-sheet.pdf";
	
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfReader reader = new PdfReader(path + template);
			PdfStamper stamper = new PdfStamper(reader, baos);
			AcroFields form = stamper.getAcroFields();

			// Page 1
			try {
				form.setField("submission_urn", ref);

			} catch (Exception ex) {
				logger.error("PDFUtilityCoverSheet.GenerateCoverSheet", ex);
			}


			
			stamper.setFormFlattening(true);
			stamper.close();

			return baos;

		} catch (Exception ex) {
			logger.error("PDFUtilityCoverSheet.GenerateCoverSheet", ex);
		}

		return null;

	}

}