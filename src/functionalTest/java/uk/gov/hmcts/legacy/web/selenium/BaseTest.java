package uk.gov.hmcts.legacy.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

import org.openqa.selenium.support.ui.Select;

public class BaseTest implements IAFTGeneric {

    static Logger logger = Logger.getLogger(BaseTest.class);

    static WebDriver driver;

    protected static void init() {
        try {
            System.setProperty("webdriver.chrome.driver", "./src/functionalTest/resources/chromedriver-Darwin-105");
            driver = new ChromeDriver();
            String testURL = "https://lgy-iac-web-pr-86.dev.platform.hmcts.net/IACFees";
            redirect(testURL);
        } catch (Exception e) {
            logger.error("BaseTest.init - ", e);
        }
    }

    protected static void redirect(String url) {
        driver.get(url);
    }

    protected static void clickNextButton() {
        driver.findElement(By
                               .xpath("//div[@class='function next right']/input")).click();
    }

    protected static void clickConfirmPaymentButton() {
        driver.findElement(By
                               .xpath("//*[@id=\"submit3\"]")).click();
    }

    protected static void clickSaveAndNextButton() {
        driver.findElement(By
                               .xpath("//*[@id=\"Content\"]/div/div[2]/div/form/div/div[2]/input")).click();
    }

    protected static void clickByLinkTextNext() {
        driver.findElement(By.linkText("Next")).click();
    }

    protected static void clickPreviousButton() {
        driver.findElement(By
                               .xpath("//div[@class='function previous']/a")).click();
    }

    protected static void clickContinueButton() {
        driver.findElement(By
                               .xpath("//div[@class='function next right']/a")).click();
    }

    protected static void findByLinkTextAndClick(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    protected static void findByXPathAndClick(String xPath){
        driver.findElement(By.xpath(xPath)).click();
    }

    protected static void findByNameAndClick(String name) {
        driver.findElement(By.name(name)).click();
    }

    protected static void findByNameAndEnterText(String name, String text){
        driver.findElement(By.name(name)).sendKeys(text);
    }

    protected static void findSelectByNameAndSelectByValue(String name, String value){
        new Select(driver.findElement(By.name(name))).selectByValue(value);
    }

    protected static void findByIdAndClick(String id){
        driver.findElement(By.id(id)).click();
    }

    protected static String getPageSource(){
        String source = driver.getPageSource();
        return source;
    }

}
