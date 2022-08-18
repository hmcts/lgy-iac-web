package com.MOJICT.IACFee;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SampleSmokeTest {

    static Logger logger = Logger.getLogger(SampleSmokeTest.class);

    @Test
    public void smokeTestLivenessSuccess() {


        String requestUri = "http://localhost:80/IACFees/health/liveness"; // get from system env

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

    String requestUri = "http://localhost:80/IACFees/health/dbliveness"; // get from system env

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
