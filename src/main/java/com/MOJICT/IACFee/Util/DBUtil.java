package com.MOJICT.IACFee.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DBUtil {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(DBUtil.class);
	
	private static Connection conn=null;
	
	public static Connection initialiaseConn(DataSource datasource) throws ClassNotFoundException {
		try {
			if (null == conn) {
				DBConnection dbconnection=new DBConnection();
				conn = dbconnection.getConnection();
				return conn;
			}
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			System.err.println(sqle.getMessage());
			return conn;
		}
		return conn;
	}
	
	
	public static void closeResultSet(ResultSet aRS) throws SQLException {

		if (null != aRS) {
			aRS.close();
		}
	}

	/**
	 * Code to close a PreapredStatement
	 * 
	 * @param aPS
	 * @throws SQLException
	 */
	public static void closePreparedStatement(PreparedStatement aPS)
			throws SQLException {
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
	public static void closeConnection(Connection conn) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.getMessage());
		}
	}


}
