/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.util;

import com.MOJICT.IACFee.Util.DBConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBUtils.
 */
public class DBUtils {

	/** log4j logging solution. */
	static Logger logger = Logger.getLogger(DBConnection.class);

	/** The i. */
	public static int i = 0;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException
	 *             the sQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:microsoft:sqlserver://localhost:1433;user=iac_user;password=iac_user;DatabaseName=IACFees;SelectMethod=cursor");
			//.getConnection("jdbc:microsoft:sqlserver://192.168.17.133:1433;user=iac_user;password=iac_user;DatabaseName=IACFees;SelectMethod=cursor");

			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
