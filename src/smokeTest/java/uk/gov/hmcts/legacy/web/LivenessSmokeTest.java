//package uk.gov.hmcts.legacy.web;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//
//public class LivenessSmokeTest {
//
//    static Logger logger = Logger.getLogger(LivenessSmokeTest.class);
//
//    @Value("${TEST_URL:http://localhost:80/IACFees/health/liveness.do}")
//    private String requestUri;
//
//    @Test
//    public void smokeTestLivenessSuccess() {
//
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet getRequest = new HttpGet(requestUri);
//
//        HttpResponse getResponse = null;
//        try {
//            getResponse = httpClient.execute(getRequest);
//        } catch (IOException ex) {
//            logger.error("smokeTestHealth exception", ex);
//        }
//        assertEquals(200, getResponse.getStatusLine().getStatusCode());
//    }
//
//    @Test
//    public void smokeTestDBLivenessSuccess() {
//
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet getRequest = new HttpGet(requestUri);
//
//        HttpResponse getResponse = null;
//        try {
//            getResponse = httpClient.execute(getRequest);
//        } catch (IOException ex) {
//            logger.error("smokeTestHealth exception", ex);
//        }
//        assertEquals(200, getResponse.getStatusLine().getStatusCode());
//    }
//}
