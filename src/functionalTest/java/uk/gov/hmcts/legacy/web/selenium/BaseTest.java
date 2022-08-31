package uk.gov.hmcts.legacy.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

public class BaseTest implements IAFTGeneric {

    static Logger logger = Logger.getLogger(BaseTest.class);

    static WebDriver driver;

    protected static void init() {
        try {
            String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
            driver = new ChromeDriver();
            String localHostURL = System.getenv("LOCAL_HOST_URL");
            redirect(localHostURL);
        } catch (Exception e) {
            logger.error("BaseTest.init - ", e);
        }
    }

    protected static void redirect(String url) {
        driver.get(url);
    }

}
