package com.MOJICT.IACFee.Util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.FormBean;

/**
 * Parent class for QueryBuilders
 * @author WEBTEAM4
 *
 */
public class GenericQueryBuilder implements GenericQueryBuilderProperties {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(GenericQueryBuilder.class);
	
	protected static PreparedStatement getFormDataByTokenPreparedStatement = null;
	protected static PreparedStatement getFormDataByOrderIdPreparedStatement = null;
	protected static PreparedStatement setTransactionstatus = null;
	protected static PreparedStatement getTransactioncount = null;
	/**
	 * Code to initialise a connection
	 * 
	 * @param datasource
	 * @throws ClassNotFoundException
	 */
	
	/**
	 * Retrieve the month from a java.sql.Date instance
	 * 
	 * @param theDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	protected int getTheMonth(Date theDate) {
		return theDate.getMonth() + 1;
	}

	/**
	 * Retrieve the day from a java.sql.Date instance
	 * 
	 * @param theDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	protected int getTheDay(Date theDate) {
		return theDate.getDate();
	}

	/**
	 * Retrieve the year from a java.sql.Date
	 * 
	 * @param theDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	protected int getTheYear(Date theDate) {
		return theDate.getYear() + 1900;
	}

	/**
	 * Code to close a ResultSet
	 * 
	 * @param aRS
	 *            the ResultSet to close (if it is not null and not already
	 *            closed)
	 * @throws SQLException
	 */
	protected static void closeResultSet(ResultSet aRS) throws SQLException {

		if (null != aRS) {
			aRS.close();
		}
	}

	protected static void closeConnection(Connection aConn) throws SQLException {

		if (null != aConn) {
			aConn.close();
		}
	}
	/**
	 * Code to close a PreapredStatement
	 * 
	 * @param aPS
	 * @throws SQLException
	 */
	protected static void closePreparedStatement(PreparedStatement aPS) throws SQLException {
		if (null != aPS) {
			aPS.close();
		}
	}

	/**
	 * Close a connection if it is not null or already closed
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	
	
	/**
	 * 
	 * This method set the transaction status and count in the database
	 */

	public static void setTransactionstatus(String orderid, DataSource datasource,String status,HttpServletRequest req) {
		Connection conn = null;
		ResultSet typeRS = null;
		int count=0;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			logger.debug("Initialise datasource");
			if (setTransactionstatus == null || setTransactionstatus.isClosed()) {
					setTransactionstatus = conn.prepareStatement(setTransactionstatusbyorderid);
			}
			count=getTransactioncount(orderid, datasource, status);
			logger.info("GenericQueryBuilder.setTransactionstatus - Security token from get bean "+orderid+" and count is "+count);
			count=count+1;
			req.getSession().setAttribute("count",count);
			setTransactionstatus.setString(1, status);
			setTransactionstatus.setInt(2, count);
			setTransactionstatus.setString(3,orderid);
			setTransactionstatus.setString(4,orderid);
			
			if(setTransactionstatus.executeUpdate()==0)
			{
				orderid=orderid.replaceFirst("88", "77");
				setTransactionstatus.setString(1, status);
				setTransactionstatus.setInt(2, count);
				setTransactionstatus.setString(3, orderid );
				setTransactionstatus.setString(4,orderid);
				setTransactionstatus.executeUpdate();
				

			}
			
		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.setTransactionstatus", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.setTransactionstatus", e);
		} finally {
			try {
				if (null != typeRS) {
					typeRS.close();
				}
				if (null != setTransactionstatus) {
					setTransactionstatus.close();
					setTransactionstatus=null;
				}
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.setTransactionstatus", sqle);
			}
		}
		//return singleBean;
	}
	
	/**
	 * set transaction status for top up transaction
	 */
	
public static void setTransactionstatustopup(String orderid, DataSource datasource,String status,HttpServletRequest req) {
		Connection conn=null;
		ResultSet typeRS = null;
		int count=0;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			logger.debug("Initialise datasource");
			if (setTransactionstatus == null || setTransactionstatus.isClosed()) {
					setTransactionstatus = conn.prepareStatement(setTransactionstatusbyorderidtopup);
			}
			
			req.getSession().setAttribute("count",count);
			setTransactionstatus.setString(1, status);
			setTransactionstatus.setString(2, orderid );
			setTransactionstatus.setString(3,orderid);
			
			setTransactionstatus.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.setTransactionstatustopup", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.setTransactionstatustopup", e);
		} finally {
			try {
				if (null != typeRS) {
					typeRS.close();
				}
				if (null != setTransactionstatus) {
					setTransactionstatus.close();
					setTransactionstatus=null;
				}
				
				
				//QueryBuilder.closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.setTransactionstatustopup", sqle);
			}
		}
		//return singleBean;
	}
	
	
	/**
	 * Get transaction count
	 * 
	 */
	public static int getTransactioncount(String orderid, DataSource datasource,String status) {
		Connection conn = null;
		ResultSet countRS = null;
		int count=0;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			logger.debug("Initialise datasource");
			if (getTransactioncount == null || getTransactioncount.isClosed()) {
					getTransactioncount = conn.prepareStatement(getTransactioncountbyorderid);
			}
			
			getTransactioncount.setString(1, orderid );
			getTransactioncount.setString(2,orderid);
			logger.debug("Security token from get bean"+orderid);
			countRS=getTransactioncount.executeQuery();
			
			if(countRS.next())
			{
				
			count=countRS.getInt("count");
			
			return count;
			}
			return count;
		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.getTransactioncount", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.getTransactioncount", e);
		} finally {
			try {
				if (null != countRS) {
					countRS.close();
				}
				if (null != getTransactioncount) {
				getTransactioncount.close();
				getTransactioncount=null;
				}
                closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.getTransactioncount", sqle);
			}
		}
		return count;
		
	}
	
	
	/**
	 * Retrieve the submission type from the database. This is held on
	 * along with the security token.
	 */
	public static FormBean getFormBeanBySecurityToken(String securityToken, DataSource datasource) {
		Connection conn = null;
		FormBean singleBean = new FormBean();
		ResultSet typeRS = null;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			logger.debug("Initialise datasource");
			if (getFormDataByTokenPreparedStatement == null || getFormDataByTokenPreparedStatement.isClosed()) {
				getFormDataByTokenPreparedStatement = conn.prepareStatement(getSingleFormDataBySecurityToken);
			}
			getFormDataByTokenPreparedStatement.setString(1, securityToken);
			typeRS = getFormDataByTokenPreparedStatement.executeQuery();
			if (typeRS != null) {
				typeRS.next();
				logger.debug("Its coming here and the form name "+typeRS.getString("formname"));
				singleBean.setFormName(typeRS.getString("formname"));
				singleBean.setSecurityToken(securityToken);
			
			}
			else
			{
				logger.debug("Resultset is null");
			}
		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.getFormBeanBySecurityToken", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.getFormBeanBySecurityToken", e);
		} finally {
			try {
				if (null != typeRS) {
					typeRS.close();
				}
				if (null != getFormDataByTokenPreparedStatement) {
					getFormDataByTokenPreparedStatement.close();
					getFormDataByTokenPreparedStatement=null;
				}
				
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.getFormBeanBySecurityToken", sqle);
			}
		}
		return singleBean;
	}
	
	/**
	 * Retrieve the submission type from the database. This is held on
	 * along with the security token.
	 */
	public static FormBean gettopupstatus(String orderId, DataSource datasource) {
		Connection conn = null;
		FormBean singleBean = new FormBean();
		ResultSet typeRS = null;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if (getFormDataByOrderIdPreparedStatement == null || getFormDataByOrderIdPreparedStatement.isClosed()) {
				getFormDataByOrderIdPreparedStatement = conn.prepareStatement(getSingletopupstatus);
			}
			getFormDataByOrderIdPreparedStatement.setString(1, orderId);
			getFormDataByOrderIdPreparedStatement.setString(2, orderId);
			typeRS = getFormDataByOrderIdPreparedStatement.executeQuery();
			if (typeRS != null) {
				typeRS.next();
				singleBean.setTransactionstatus(typeRS.getString("transactionstatus"));
			}

		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.gettopupstatus", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.gettopupstatus", e);
		} finally {
			try {
				if (null != typeRS) {
					typeRS.close();
				}
				if (null != getFormDataByOrderIdPreparedStatement) {
					getFormDataByOrderIdPreparedStatement.close();
					getFormDataByOrderIdPreparedStatement=null;
				}
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.gettopupstatus", sqle);
			}
		}
		return singleBean;
	}

	/**
	 * 
	 * 
	 */
	
	public static FormBean getFormBeanByOrderId(String orderId, DataSource datasource) {
		Connection conn = null;
		FormBean singleBean = new FormBean();
		ResultSet typeRS = null;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if (getFormDataByOrderIdPreparedStatement == null || getFormDataByOrderIdPreparedStatement.isClosed()) {
				getFormDataByOrderIdPreparedStatement = conn.prepareStatement(getSingleFormDataByOrderId);
			}
			getFormDataByOrderIdPreparedStatement.setString(1, orderId);
			getFormDataByOrderIdPreparedStatement.setString(2, orderId);
			typeRS = getFormDataByOrderIdPreparedStatement.executeQuery();
			if(typeRS.next())
			{
				//typeRS.next();
				singleBean.setFormName(typeRS.getString("formname"));
				singleBean.setSecurityToken(typeRS.getString("securitytoken"));
				singleBean.setTransactionstatus(typeRS.getString("transactionstatus"));
				singleBean.setCount(typeRS.getInt("count"));
			}
			else
			{
				orderId=orderId.replaceFirst("88", "77");
				logger.debug("Coming to null result set.");
				getFormDataByOrderIdPreparedStatement.setString(1, orderId);
				getFormDataByOrderIdPreparedStatement.setString(2, orderId);
				typeRS = getFormDataByOrderIdPreparedStatement.executeQuery();
				if(typeRS.next())
				{
				singleBean.setFormName(typeRS.getString("formname"));
				singleBean.setSecurityToken(typeRS.getString("securitytoken"));
				singleBean.setTransactionstatus(typeRS.getString("transactionstatus"));
				singleBean.setCount(typeRS.getInt("count"));
				}
			}
			
			

		} catch (ClassNotFoundException e) {
			logger.error("GenericQueryBuilder.getFormBeanByOrderId", e);
		} catch (SQLException e) {
			logger.error("GenericQueryBuilder.getFormBeanByOrderId", e);
		} finally {
			try {
				if (null != typeRS) {
					typeRS.close();
				}
				if (null != getFormDataByOrderIdPreparedStatement) {
					getFormDataByOrderIdPreparedStatement.close();
					getFormDataByOrderIdPreparedStatement=null;
				}
				closeConnection(conn);
			} catch (SQLException sqle) {
				logger.error("GenericQueryBuilder.getFormBeanByOrderId", sqle);
			}
		}
		return singleBean;
	}

	
	
}
