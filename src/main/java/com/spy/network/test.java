package com.spy.network;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

import com.MOJICT.IACFee.Util.LastSubmission;
import org.quartz.*;
import org.apache.log4j.Logger;


public class test implements Job
{
	
 	  static Logger logger = Logger.getLogger(test.class);
   
    public void execute(JobExecutionContext arg0)
        throws JobExecutionException
    {
    	
    	
        logger.debug("================== Ready to serve 10 min Job ==================");
        try
        {
        	String data = LastSubmission.process10Appeals();
        	//logger.debug(data);
        	saveStatusLog(data);
        	
        	String jspdata = LastSubmission.processjspdata();
        	saveJspFile(jspdata);
        	
        	logger.debug("!!!!!!! Job completed !!!!");
        	
         }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private Object getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveJspFile(String data)
    {
    	try {
    			FileOutputStream fo = new FileOutputStream("/opt/moj/IACFees.files/IAC_Submissions/Status_Files/status.log");
    			PrintStream ps = new PrintStream(fo);
    			ps.println(data);
    			ps.close();
    			fo.close();
    		} 
    	catch (Exception e) {
    		
    		 logger.debug("Error: " + e.getMessage());
    	}
    	
    		}
  
    public void saveStatusLog(String data)
    {
    	 try{

             FileWriter fstream = new FileWriter("/opt/moj/IACFees.files/IAC_Submissions/Status_Files/statusList.log",true);
             BufferedWriter fbw = new BufferedWriter(fstream);
             fbw.write(data);
             fbw.newLine();
             fbw.close();
         }catch (Exception e) {
             logger.debug("Error: " + e.getMessage());
         }
    	
    }

}
