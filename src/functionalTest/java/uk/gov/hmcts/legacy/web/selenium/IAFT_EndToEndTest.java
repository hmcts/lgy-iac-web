package uk.gov.hmcts.legacy.web.selenium;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class IAFT_EndToEndTest extends BaseTest {

	static Logger logger = Logger.getLogger(IAFT_EndToEndTest.class);

	public static void main(String[] args) {
		new IAFT_EndToEndTest().BasicIAFTTests();
	}

	@BeforeClass
	public static void cleanFiles() {
		logger.info("Cleaning test files");
		BaseTestUtilities.clearOutTestFiles(null);
	}

	@Test
	public void BasicIAFTTests() {
		try {
			init();
//			logger.info("Test: IAFT1 User Journey");
//			IAFT1_Tests.loadScenarios_IAFT1();
//			IAFT1_Tests.runPages();
            logger.info("Test: IAFT2 User Journey");
            IAFT2_Tests.loadScenarios_IAFT2();
            IAFT2_Tests.runPages();
		} catch (Exception e) {
			logger.error("IAFT_EndToEndTest.BasicIAFTTests - ", e);
		}
	}
}
