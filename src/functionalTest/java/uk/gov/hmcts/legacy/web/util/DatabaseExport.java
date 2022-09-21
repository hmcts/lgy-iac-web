/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.util;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mssql.MsSqlDataTypeFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * Class to extract the contents of a database and store in an XML representation that DBUint can consume.
 * @author WEBTEAM4
 *
 */
public class DatabaseExport extends AbstractDataUtility {

	/** The connection. */
	static IDatabaseConnection connection;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			generate("IACFees");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( jdbcConnection != null ) jdbcConnection.close();
				if( connection != null ) connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	/**
	 * Generate.
	 *
	 * @param schema
	 *            the schema
	 * @throws SQLException
	 *             the sQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void generate(String schema) throws SQLException, ClassNotFoundException, DatabaseUnitException, FileNotFoundException, IOException {
		loadLog4j ();
		jdbcConnection = DBUtils.getConnection();
		connection = new DatabaseConnection (jdbcConnection, schema);
		DatabaseConfig config = connection.getConfig();
		config.setProperty ( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MsSqlDataTypeFactory());
		populateTableNames();
		QueryDataSet partialDataSet = new QueryDataSet (connection);
		for (String aTableName : tableList) {
			partialDataSet.addTable( aTableName);
		}
		FlatXmlDataSet.write(partialDataSet,  new FileOutputStream("test/data/full.xml"));
	}



}
