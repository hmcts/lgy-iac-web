package uk.gov.hmcts.legacy.web;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-smoke.yaml")
public class LivenessSmokeTest {

    static Logger logger = Logger.getLogger(LivenessSmokeTest.class);

//    @Value("${TEST_URL:http://localhost:80/IACFees/health/liveness.do}")
//    private String requestUri;
    @Value("${test-url}")
    private String testUrl;

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
        assertEquals(200, getResponse.getStatusLine().getStatusCode());
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
}
