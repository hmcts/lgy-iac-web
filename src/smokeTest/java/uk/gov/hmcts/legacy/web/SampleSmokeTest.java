package uk.gov.hmcts.legacy.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-smoke.yaml")
public class SampleSmokeTest {
    //protected static final String CONTENT_TYPE_VALUE = "application/json";

    @Value("${test-url}")
    private String testUrl;

    @Before
    public void before() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void smokeTest() {
        given()
            .accept(ContentType.HTML)
            .when()
            .get(testUrl + "/health/")
            .then()
            .statusCode(200);
    }
}
