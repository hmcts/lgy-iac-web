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
public class SampleFunctionalTest {
    protected static final String CONTENT_TYPE_VALUE = "application/json";

    @Value("${TEST_URL")
    private String testUrl;

    @Before
    public void before() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void functionalTest() {
        given()
            .accept(ContentType.HTML)
            .when()
            .get(testUrl + "/IACFees")
            .then()
            .statusCode(200);
    }
}
