// TODO - Differences between master and production.

package com.MOJICT.IACFee.Util;

import java.sql.*;
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
			String dbHost = System.getenv("DB_HOST");
			String dbPort = System.getenv("DB_PORT");
			String dbUser = System.getenv("DB_USER");
			String dbPass = System.getenv("DB_PASSWORD");
			String dbName = System.getenv("DB_NAME");
			String dbUrl = String.format("%s://%s:%s/%s?sslmode=require",
					getJdbcUrl(), dbHost, dbPort, dbName);

            logger.info("DB_HOST: " + dbHost);
            logger.info("DB_PORT: " + dbPort);
            logger.info("DB_USER: " + dbUser);
            logger.info("DB_PASSWORD: " + dbPass);
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
			String dbhost = System.getenv("DB_HOST");
			String dbPort = System.getenv("DB_PORT");
			String dbUser = System.getenv("DB_USER");
			String dbPass = System.getenv("DB_PASSWORD");
			String dbName = System.getenv("DB_NAME");
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
