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
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mssql.InsertIdentityOperation;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * Used during testing to load the database with a set of dbunit derived test
 * data so restoring the database to a known configuration. ****WARNING******
 * This deletes all data on the database
 *
 * @author WEBTEAM4
 *
 */
public class DataLoader extends AbstractDataUtility {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		DataLoader.load("full.xml");
	}

	/**
	 * Load.
	 *
	 * @param dataSetToLoad
	 *            the data set to load
	 */
	@SuppressWarnings("deprecation")
	public static void load(String dataSetToLoad) {
		try {
			init();
			File theDataSet = new File(userDir + "/src/functionalTest/java/com/data/" + dataSetToLoad);
			FlatXmlDataSet fds = new FlatXmlDataSet(new FileReader(theDataSet), new FileReader(theDTD));
			FlatXmlDataSet cleanfds = new FlatXmlDataSet(new FileReader(clean), new FileReader(theDTD));
			DatabaseOperation.DELETE_ALL.execute(connection, cleanfds);
			jdbcConnection.commit();
			new InsertIdentityOperation(DatabaseOperation.CLEAN_INSERT).execute(connection, fds);
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection) {
					connection.close();
				}
				if (null != jdbcConnection) {
					jdbcConnection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
