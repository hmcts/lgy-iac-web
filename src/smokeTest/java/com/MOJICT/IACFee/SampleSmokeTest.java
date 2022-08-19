package com.MOJICT.IACFee;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SampleSmokeTest {

    static Logger logger = Logger.getLogger(SampleSmokeTest.class);
    private String testUrl = null;

    @BeforeClass
    public void setup() {
        testUrl = System.getenv("TEST_URL");
        if (testUrl == null) {
            testUrl = "localhost";
        }
    }

    @Test
    public void smokeTestLivenessSuccess() {

        String requestUri = testUrl + "/health/liveness.do";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(requestUri);

        HttpResponse getResponse = null;
        try {
            getResponse = httpClient.execute(getRequest);
        } catch (IOException ex) {
            logger.error("smokeTestHealth exception", ex);
        }
        assertEquals(200, getResponse.getStatusLine().getStatusCode());
    }

   @Test
    public void smokeTestDBLivenessSuccess() {

    String requestUri = testUrl + "/health/dbliveness.do";

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet getRequest = new HttpGet(requestUri);

    HttpResponse getResponse = null;
        try {
        getResponse = httpClient.execute(getRequest);
    } catch (IOException ex) {
        logger.error("smokeTestHealth exception", ex);
    }
    assertEquals(200, getResponse.getStatusLine().getStatusCode());
    }
}
