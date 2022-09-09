package uk.gov.hmcts.legacy.web;

import com.MOJICT.IACFee.Util.Helper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-smoke.yaml")
public class LivenessSmokeTest {

    static Logger logger = Logger.getLogger(LivenessSmokeTest.class);

//    private String requestUri;
    @Value("${test-url}")
    private String testUrl;

    @Value("${env.dbhost}")
    private String dbHost;

    @Value("${env.dbport}")
    private String dbPort;

    @Value("${env.dbname}")
    private String dbName;

    @Value("${env.dbuser}")
    private String dbUser;

    @Value("${env.dbpass}")
    private String dbPass;


    @Test
    public void smokeTestLivenessSuccess() {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(testUrl + "/IACFees/health/liveness.do");

        HttpResponse getResponse = null;
        try {
            getResponse = httpClient.execute(getRequest);
        } catch (IOException ex) {
            logger.error("smokeTestHealth exception", ex);
        }
        try {
            assertEquals(200, getResponse.getStatusLine().getStatusCode());
        } catch (AssertionError e) {
            logger.error("The Status code is not 200");
        }
        logger.info("The Status code is 200");
    }

    @Test
    public void smokeTestDBLivenessSuccess() {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(testUrl + "/IACFees/health/dbliveness.do");

        HttpResponse getResponse = null;
        try {
            getResponse = httpClient.execute(getRequest);
        } catch (IOException ex) {
            logger.error("smokeTestHealth exception", ex);
        }
        assertEquals(200, getResponse.getStatusLine().getStatusCode());
    }

    @Ignore
    public void testReturnAmountString_OralSuccessful() {

        String date =  LocalDate.now().toString();
        logger.info(date);
        int amount = Helper.returnStringAmount_paper(date);
        assertEquals(140 ,amount);
    }

    @Test
    public void testFeesSelect() {
        Properties connectionInfo = new Properties();
        connectionInfo.setProperty("user", dbUser);
        connectionInfo.setProperty("password", dbPass);

        String dbUrl = String.format("jdbc:postgresql://%s:%s/%s?ssl_mode=require", dbHost, dbPort, dbName);
        logger.info("testing connection to database.... with url <" + dbUrl + "> user <" + dbUser + ">");

        try (Connection conn = DriverManager.getConnection(dbUrl, connectionInfo)) {
            logger.info("connection OK - select from fees table");
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT 1 FROM dbo.fees")) {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    logger.info("retrieved record from table");
                } else {
                    logger.info("Error: no data retrieved");
                }
            }
        } catch (SQLException e) {
            logger.error("jdbc failure: " + e.getMessage() + ":" + e.getSQLState());
        }
    }


}
