package com.MOJICT.IACFee.Util;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public class TestDBConnection {
    //You need to ensure that the required variables are saved as part of the runtime configuration (click the plus and modify runtime config then add env's in there)
    static Logger logger = Logger.getLogger(TestDBConnection.class);

    @Test
    public void testGetConnection() {
        //You need to ensure that the required variables are saved as part of the runtime configuration (right click testGetConnection())
        try {
            DBConnection dbConnection = new DBConnection();

            Connection conn = dbConnection.getConnection();
            assertEquals(false, conn.isClosed());
            conn.close();
            assertEquals(true, conn.isClosed());

        } catch (Exception e) {
            logger.error("TestDBConnection.testGetConnection", e);
            assertTrue(false);
        }
    }

    @Test
    public void testDBTableConnection() {
        //You need to ensure that the required variables are saved as part of the runtime configuration (right click testDBTableConnection())
        DBConnection dbConnection = new DBConnection();
        Boolean result = null;
        try {
            result = dbConnection.checkDBConnection(dbConnection.getConnection(), "IAFT5");
            assertTrue("Should be true otherwise Table has no values in it signalling potentialy DB error", result);
        } catch (Exception e) {
            logger.error("TestDBConnection.testDBTableConnection", e);
            assertTrue(false);
        }
    }

}
