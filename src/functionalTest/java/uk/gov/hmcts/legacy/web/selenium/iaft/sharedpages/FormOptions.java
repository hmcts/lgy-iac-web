package uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import org.apache.log4j.Logger;

public class FormOptions extends AbstractIAFTPage implements IaftPage {

    static Logger logger = Logger.getLogger(FormOptions.class);

    public static final String RECEIVED_A_DECISION_XPATH = "//*[@id=\"section2a\"]";
    public static final String UK_REFUSAL_DECISION_XPATH = "//*[@id=\"section5\"]";
    public static final String REFUSAL_DECISION_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[4]/input";
    public static final String APPEALABLE_DECISION_BEFORE_APR2015_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[6]/input";
    public static final String APPEALABLE_DECISION_AFTER_APR2015_XPATH = "//*[@id=\"schedule40\"]";

    @Override
    public void execute() {
        logger.info("Executing FormOptions");
        int fieldLength = fields.length;
        if (fieldLength == 1) {

            String action = fields[0];
            if (action.equals(RECEIVED_A_DECISION_XPATH) || action.equals(UK_REFUSAL_DECISION_XPATH) || action.equals(REFUSAL_DECISION_XPATH) || action.equals(APPEALABLE_DECISION_BEFORE_APR2015_XPATH) || action.equals(APPEALABLE_DECISION_AFTER_APR2015_XPATH)) {
                findByXPathAndClick(action);
                clickNextButton();
                String source = getPageSource();
                if (source.contains("Are you appealing from within the United Kingdom?")) {
                    logger.info("FormOptions validated");
                } else {
                    logger.info("FormOptions Validation Failed");
                }
            } else if (null != action) {
                logger.info("Action:" + action + " not understood expected one of:" + RECEIVED_A_DECISION_XPATH + " " + UK_REFUSAL_DECISION_XPATH + " " + REFUSAL_DECISION_XPATH + " " + APPEALABLE_DECISION_BEFORE_APR2015_XPATH + " " + APPEALABLE_DECISION_AFTER_APR2015_XPATH);
            }
        } else {
            logger.info("Form options not initialised with correct number of fields. Expected 1 was " + fieldLength);
        }
    }

}

