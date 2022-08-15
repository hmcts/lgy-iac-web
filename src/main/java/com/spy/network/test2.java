// TODO - Differences between master and production.

package com.spy.network;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;



import org.quartz.*;
import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Util.LastSubmission;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


public class test2 implements Job
{
	static Logger logger = Logger.getLogger(test2.class);


	public static void main(String args[])
	{
		test2 t = new test2();
		t.getinfo();
	}

	public void execute(JobExecutionContext arg0)
			throws JobExecutionException
	{
		LastSubmission.deletegdprdata();
		test2 t = new test2();
		t.getinfo();
	}

    public void getinfo()
    {
		Writer writer = null;

		//logger.debug("================== Fired at 12midnight =================="+new Date());
        try
        {

			//logger.debug("!!!!!!! Job completed !!!!");
			String test = LastSubmission.get24hrsubmissions();
			//String test1=LastSubmission.get24hrsubmissions();
			HttpServletRequest servletRequest;
			//String path = servletRequest.getRealPath("/").toString();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			String text = "This is a text file";
			//new File("/opt/moj/IACFees.files/IAC_Submissions/PDF_Files/"+sdf.format(new Date())+"_Online_Submissions_Audit_Report.pdf");
			OutputStream file = new FileOutputStream(new File("/opt/moj/IACFees.files/IAC_Submissions/PDF_Files/" + sdf.format(new Date()) + "_Online_Submissions_Audit_Report.pdf"));

			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();

			document.add(new Paragraph(test));

			document.close();
			file.close();

			//logger.debug("!!!!! 12AM Job completed"+test);

         }
        catch(Exception ex)
        {
			ex.printStackTrace();
		}
	}

	private Object getServletContext() {
		return null;
	}

}
