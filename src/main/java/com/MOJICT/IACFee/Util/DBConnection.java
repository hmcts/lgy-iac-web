// TODO - Differences between master and production.

package com.MOJICT.IACFee.Util;

import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnection {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(DBConnection.class);
	public static int i = 0;

	public synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {

            logger.info("in getConnection with:");
			String dbHost = System.getenv("POSTGRES_HOST");
			String dbPort = System.getenv("POSTGRES_PORT");
			String dbUser = System.getenv("POSTGRES_USER");
			String dbPass = System.getenv("POSTGRES_PASSWORD");
			String dbName = System.getenv("POSTGRES_DATABASE");
			String dbUrl = String.format("%s://%s:%s/%s?sslmode=require",
					getJdbcUrl(), dbHost, dbPort, dbName);

            logger.info("POSTGRES_HOST: " + dbHost);
            logger.info("POSTGRES_PORT: " + dbPort);
            logger.info("POSTGRES_USER: " + dbUser);
            logger.info("POSTGRES_PASSWORD: " + dbPass);
            logger.info("dbUrl: " + dbUrl);

            Class.forName(getJdbcDriver());
			conn = getConnection(dbUrl, dbUser, dbPass);
            logger.info("Connected " + conn.toString());

		} catch (SQLException e) {
			logger.error("DBConnection.getConnection - ", e);
		}
		return conn;
	}

	public synchronized Connection getConnectionForSeleniumTesting() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {
			String dbhost = System.getenv("POSTGRES_HOST");
			String dbPort = System.getenv("POSTGRES_PORT");
			String dbUser = System.getenv("POSTGRES_USER");
			String dbPass = System.getenv("POSTGRES_PASSWORD");
			String dbName = System.getenv("POSTGRES_DATABASE");
			String dbUrl = String.format("%s://%s:%s/%s?sslmode=require",
					getJdbcUrl(), dbhost, dbPort, dbName);

			Class.forName(getJdbcDriver());
			conn = getConnection(dbUrl, dbUser, dbPass);

		} catch (SQLException e) {
			logger.error("DBConnection.getConnection - ", e);
		}
		return conn;
	}

	public boolean checkDBConnection(Connection conn, String dbTableName)  {
		PreparedStatement testQuery = null;
		try {
			testQuery = conn.prepareStatement("SELECT 1 FROM " + dbTableName);
			ResultSet rs = testQuery.executeQuery();

			Boolean valid = rs.next();

			testQuery.close();
			rs.close();
			conn.close();

			return valid;
		} catch (SQLException e) {
			logger.error("DBConnection.checkDBConnection", e);
			return false;
		}
	}

//    public boolean checkDBConnection(Connection conn, String dbTableName)  {
//        PreparedStatement testQuery = null;
//        String date =  LocalDate.now().toString();
//        try {
////           testQuery1  = conn.prepareStatement("SELECT fees_oral FROM " + dbTableName + " LIMIT 1");
//
//            testQuery = conn.prepareStatement("SELECT * FROM " + dbTableName + " WHERE (startdate < to_timestamp('"+ date +"', 'YYYY-MM-DD HH24:MI:SS'))");
//
//            ResultSet rs = testQuery.executeQuery();
//
//            Boolean valid = rs.next();
//
//            logger.info("the check dbConnection method is : " + valid);
//
//            logger.info("the date is : " + date);
//
//            while (rs.next()) {
//                    logger.info("1 startdate is : " + rs.getString("startdate"));
//                    logger.info("1 fees_paper is : " + rs.getString("fees_paper"));
//                }
//
//            testQuery.close();
//            rs.close();
//            conn.close();
//
//            return valid;
//        } catch (SQLException e) {
//            logger.error("DBConnection.checkDBConnection", e);
//            return false;
//        }
//    }

	private String getJdbcDriver() {
		String jdbcDriver = System.getenv("DB_JDBC_DRIVER");
        logger.info("jdbcDriver: " + jdbcDriver);
		if (jdbcDriver == null) {
			jdbcDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		}
		return jdbcDriver;
	}

	private String getJdbcUrl() {
		String jdbcUrl = System.getenv("DB_JDBC_URL");
		if (jdbcUrl == null) {
			jdbcUrl = "jdbc:microsoft:sqlserver";
		}
		return jdbcUrl;
	}

	private Connection getConnection( String dbUrl, String dbUser, String dbPassword) throws SQLException {
		Properties props = new Properties();
		props.setProperty("user", dbUser);
		props.setProperty("password",dbPassword);
		props.setProperty("ssl","true");
		logger.info("dbUrl: " + dbUrl);
		logger.info("dbUser: " + dbUser);
		logger.info("dbPass: " + dbPassword);
		return DriverManager.getConnection(dbUrl, props);
	}
}
