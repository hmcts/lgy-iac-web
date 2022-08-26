<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@page import="java.io.BufferedWriter,java.io.File,java.io.FileOutputStream,java.io.FileWriter,java.io.IOException,java.io.OutputStream,java.io.PrintStream,java.io.Writer,java.text.SimpleDateFormat,java.util.Date,javax.servlet.ServletContext,javax.servlet.http.HttpServletRequest,org.quartz.*,org.apache.log4j.Logger,org.apache.struts.action.Action,com.MOJICT.IACFee.Actions.RetrieveAction,com.MOJICT.IACFee.Util.Helper,com.MOJICT.IACFee.Util.LastSubmission,com.lowagie.text.Document,com.lowagie.text.Paragraph,com.lowagie.text.pdf.PdfWriter" %>
<%!
private static class NdBadIdea {
  

  public String getFoo() {
    try
        {
        	
        	//logger.debug("!!!!!!! Job completed !!!!");
        	String test=LastSubmission.get24hrsubmissions();
        	//String test1=LastSubmission.get24hrsubmissions();
        	 HttpServletRequest servletRequest;
        	//String path = servletRequest.getRealPath("/").toString();
        	//String test="Audit report wroking";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            
                    String text = "This is a text file";
                    //new File("/opt/moj/IACFees.files/IAC_Submissions/PDF_Files/"+sdf.format(new Date())+"_Online_Submissions_Audit_Report.pdf");
                   OutputStream file = new FileOutputStream(new File("/opt/moj/IACFees.files/IAC_Submissions/PDF_Files/"+sdf.format(new Date())+"_Online_Submissions_Audit_Report.pdf"));
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
        return "Success";
  }
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=new NdBadIdea().getFoo()%>
    </body>
</html>