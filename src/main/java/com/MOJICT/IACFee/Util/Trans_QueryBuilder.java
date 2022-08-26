package com.MOJICT.IACFee.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.AggregatedBean;

public class Trans_QueryBuilder {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Trans_QueryBuilder.class);
	private static String sql_save="Insert into transaction_details(transactionstatus,orderid,type,referencenumber,sub_count,Aggr_URN,dateofpayment) values (?,?,?,?,?,?,?)";
	private static String sql_update="update transaction_details set hearing_type=?,qa_sponsor=?,qa_rep=?,qa_witness=?,qb_lsc=?,qb_LAR=?,family_member=?,qc_name1=?,qc_relationship1=?,qc_prn1=?,qc_name2=?,qc_relationship2=?,qc_prn2=?,qc_name3=?,qc_relationship3=?,qc_prn3=?,qc_name4=?,qc_relationship4=?,qc_prn4=? where securitytoken=?";
	
	private static String sql_retrieve="select * from transaction_details where orderid=?";
	private static String sql_retrieve_urn="select * from formsdata where AggregatedURN=?";
	private static String sql_retrieve_both="select * from formsdata where AggregatedURN=? or securitytoken=? or paymentURN=?";
	private static String sql_retrieve_ref="select * from transaction_details where referencenumber=?";
	public static String save(AggregatedBean frm,String oid,DataSource datasource)
	{
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
    		
        try
        	{
        	    DBConnection dbcoConnection=new DBConnection();
        		conn = dbcoConnection.getConnection();
        		
        		String thissql = sql_save;
        		stmt = conn.prepareStatement(thissql);
        		stmt.setString(1,"Not Known");
        		stmt.setString(2,oid);
        		stmt.setString(3,"2");
        		stmt.setString(4,frm.getPrn1());
        		stmt.setInt(5,frm.getCount());
        		stmt.setString(6,frm.getAggregatedpaymentURN());
        		stmt.setTimestamp(7, dateconverter.convertdate());
        		
        		
        		
        		
        		stmt.execute();
        		
        	}
        	catch(Exception e)
        	{
				logger.error("Trans_QueryBuilder.save - ", e);
        		return "failure";
        	}
        	 finally
             {
                 if(rs != null)
                 {
                     try
                     {
                         rs.close();
                     }
                     catch(SQLException sqle)
                     {
						 logger.error("Trans_QueryBuilder.save - ", sqle);
                     }
                     rs = null;
                 }
                 if(conn != null)
                 {
                     try
                     {
                         conn.close();
                     }
                     catch(SQLException sqle)
                     {
						 logger.error("Trans_QueryBuilder.save - ", sqle);
                     }
                     conn = null;
                 }
             }
		
		
		
		return "success";
	
	}
	
	
	public static String check(AggregatedBean frm,int counts,DataSource datasource)
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    	int count=1;   
    	String oid="";
        try
        	{
        	
        		DBConnection dbconnection=new DBConnection();
        		conn = dbconnection.getConnection();
        		
        		String thissql = sql_retrieve_ref;
        		stmt = conn.prepareStatement(thissql);
        		stmt.setString(1,frm.getPrn1());
        		        		
        		
        		rs=stmt.executeQuery();
        	
        		while(rs.next())
        		{
        			++count;
        		}
        		
        		logger.debug("\t\tMethod: Count Status:Return");
        		if( count ==counts)
        		{
        			oid=rs.getString("orderid");
        		}
        		else
        		{
        			oid="77" + SecurityToken.generateAggregatedPaymentURN();
        		}
        		return oid;
        	}
        	catch(Exception e)
        	{
				logger.error("Trans_QueryBuilder.check - ", e);
        		return oid;
        	}
        finally {
			try {
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(stmt);
				//DBUtil.closePreparedStatement(stmt1);
				logger.debug("\t\tMethod: Count Status: End");
			} catch (SQLException sqle) {
				logger.error("Trans_QueryBuilder.check - ", sqle);
			}
		}
		
		
		//return rs;
	
	}
	
	
	public static int getcount(String oid,DataSource datasource)
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    	int count=1;       
        try
        	{
        	
        		DBConnection dbconnection=new DBConnection();
        		conn = dbconnection.getConnection();
        		
        		String thissql = sql_retrieve_both;
        		stmt = conn.prepareStatement(thissql);
        		stmt.setString(1,oid.substring(0,7));
        		stmt.setString(2,oid.substring(0,7));
        		stmt.setString(3,oid.substring(0,7));   	
        		
        		
        		rs=stmt.executeQuery();
        	
        		while(rs.next())
        		{
        			++count;
        		}
        		
        		logger.debug("\t\tMethod: Count Status:Return");
        		return count;
        	}
        	catch(Exception e)
        	{
				logger.error("Trans_QueryBuilder.getcount - ", e);
        		return count;
        	}
        finally {
			try {
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(stmt);
				DBUtil.closeConnection(conn);
				logger.debug("\t\tMethod: Count Status: End");
			} catch (SQLException sqle) {
				logger.error("Trans_QueryBuilder.getcount - ", sqle);
			}
		}
		
		
		//return rs;
	
	}
	
	

	public static int getcount_forms(String oid,DataSource datasource)
	{
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    	int count=1;
        
       
        try
        	{
        	DBConnection dbconnection=new DBConnection();
    		conn = dbconnection.getConnection();
    		
        		
        		String thissql = sql_retrieve_urn;
        		stmt = conn.prepareStatement(thissql);
        		stmt.setString(1,oid.substring(0,10));
        		        		
        		
        		rs=stmt.executeQuery();
        	
        		while(rs.next())
        		{
        			++count;
        		}
        		return count;
        	}
        	catch(Exception e)
        	{
				logger.error("Trans_QueryBuilder.getcount_forms - ", e);
        		return count;
        	}
        	 
		
		
		//return rs;
	
	}

	public static AggregatedBean gettopup(String oid,DataSource datasource)
	{
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    	int count=1;
        AggregatedBean bean=new AggregatedBean();
       
        try
        	{
        	DBConnection dbconnection=new DBConnection();
    		conn = dbconnection.getConnection();
    		
        		
        		String thissql = sql_retrieve;
        		stmt = conn.prepareStatement(thissql);
        		stmt.setString(1,oid);
        		        		
        		
        		    rs=stmt.executeQuery();
        	        if(rs.next())
        	        {
        			bean.setCount(rs.getInt("sub_count"));
        			count=bean.getCount();
        			bean.setOid(rs.getString("orderid"));
        			bean.setType(rs.getString("type"));
        			if(count==1)
    				{
    					logger.debug("coming here");
    				    bean.setPrn1(rs.getString("referencenumber"));
    				    bean.setAggregatedpaymentURN(rs.getString("Aggr_URN"));
    				    
    				  
    				  return bean;
    				}
        	        
        			
    				if (count==2)
    			    {
    					logger.debug("coming here too");
    					bean.setPrn1(rs.getString("referencenumber"));
    					bean.setAggregatedpaymentURN(rs.getString("Aggr_URN"));
    					
    					rs.next();
    					bean.setPrn2(rs.getString("referencenumber"));
    					return bean;
    			    }
    			    if(count==3)
    			    {
    			    	logger.debug("coming here three");
    					bean.setPrn1(rs.getString("referencenumber"));
    					bean.setAggregatedpaymentURN(rs.getString("Aggr_URN"));
    					
    					rs.next();
    					bean.setPrn2(rs.getString("referencenumber"));
    					rs.next();
    			    	bean.setPrn3(rs.getString("referencenumber"));
    			    	return bean;
    			    	
    			    }
    			    if (count==4)
    			    {
    			    	logger.debug("coming here four");
    					bean.setPrn1(rs.getString("referencenumber"));
    					bean.setAggregatedpaymentURN(rs.getString("Aggr_URN"));
    					
    					rs.next();
    					bean.setPrn2(rs.getString("referencenumber"));
    					rs.next();
    			    	bean.setPrn3(rs.getString("referencenumber"));
    			    	rs.next();
    			    	bean.setPrn4(rs.getString("referencenumber"));
    			    	return bean;
    			    }
    			    if(count==5)
    			    {
    			    	logger.debug("coming here five");
    					bean.setPrn1(rs.getString("referencenumber"));
    					bean.setAggregatedpaymentURN(rs.getString("Aggr_URN"));
    					
    					rs.next();
    					bean.setPrn2(rs.getString("referencenumber"));
    					rs.next();
    			    	bean.setPrn3(rs.getString("referencenumber"));
    			    	rs.next();
    			    	bean.setPrn4(rs.getString("referencenumber"));
    			    	rs.next();
    			    	bean.setPrn5(rs.getString("referencenumber"));
    			    	return bean;
            	    //rs.next();
    			    }	
    			  
        				
        	        }
        			    
        			  
        			   
        			
        		
        		return bean;
        	}
        	catch(Exception e)
        	{
        		logger.error("Trans_QueryBuilder.gettopup - ", e);
        		return bean;
        	}
        	 finally
        	 {
        		 try{
        		 rs.close();
        		 stmt.close();
        		 conn.close();
        		 }catch(Exception e)
        		 {
        			 logger.error("Trans_QueryBuilder.gettopup - ", e);
        			 
        		 }
        	 }
        	 
		
		
		//return rs;
	
	}
	
	
      
	
	
	
}	
