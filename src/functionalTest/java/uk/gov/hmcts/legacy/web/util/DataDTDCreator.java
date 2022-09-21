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
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * Creates a DTD file for a MSSql schema - should only be run for a new version
 * of the code.
 *
 * @author WEBTEAM4
 */
public class DataDTDCreator extends AbstractDataUtility {

	/**
	 * Run standalone to generate a DTD.
	 *
	 * @param args
	 *            - none required
	 * @throws SQLException
	 *             the sQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, DatabaseUnitException,
			IOException {
		try {
			init();
			populateTableNames();
			QueryDataSet partialDataSet = new QueryDataSet(connection);
			for (String aTableName : tableList) {
				partialDataSet.addTable(aTableName);
			}
			if (!theDTD.exists()) {
				theDTD.createNewFile();
			}
			FlatDtdDataSet.write(partialDataSet, new FileOutputStream(theDTD));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
