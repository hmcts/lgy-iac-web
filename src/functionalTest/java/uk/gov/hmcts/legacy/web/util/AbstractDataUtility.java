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
import org.apache.log4j.PropertyConfigurator;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDataUtility.
 */
public abstract class AbstractDataUtility {

	/** The jdbc connection. */
	static protected Connection jdbcConnection;

	/** The connection. */
	static protected IDatabaseConnection connection;

	/** The user dir. */
	static protected String userDir = System.getProperty("user.dir");

	/** The table list. */
	static protected List <String> tableList = new ArrayList <String> ();

	/** The clean. */
	static protected File clean = new File(userDir + "/src/functionalTest/java/com/data/cleanse.xml");

	/** The dtd. */
	static protected File theDTD = new File(userDir + "/src/functionalTest/java/com/data/IAC.dtd");

	/**
	 * Inits the.
	 */
	protected static void init() {
//		loadLog4j ();
		try {
			Boolean SeleniumDBConnection = true;
			DBConnection db = new DBConnection();
			jdbcConnection = db.getConnectionForSeleniumTesting();
			jdbcConnection.setAutoCommit(false);
			connection = new DatabaseConnection(jdbcConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		}
		DatabaseConfig config = connection.getConfig();
		config.setProperty ( "http://www.dbunit.org/features/qualifiedTableNames", false);
//		config.setProperty ( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MsSqlDataTypeFactory());
		config.setProperty ( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
		config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
	}

	/**
	 * Load log4j.
	 */
	protected static void loadLog4j () {
		String userDir = System.getProperty("user.dir");
		File f = new File(userDir+"/log4j.properties");
		FileInputStream fin = null;
		try {
			Properties props = new Properties();
			fin = new FileInputStream(f);
			props.load(fin);
			fin.close();
			PropertyConfigurator.configure(props);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Populate table names.
	 */
	protected static void populateTableNames() {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = jdbcConnection.createStatement();
			rs = st.executeQuery("select distinct name from sysobjects where xtype='U'");
			while (rs.next()){
				tableList.add(rs.getString("name"));
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
			} catch (Exception e){

			}
		}
	}
}
