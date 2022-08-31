package uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages;

import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPage;

public class WelcomeActions extends AbstractIAFTPage implements IaftPage {

    static Logger logger = Logger.getLogger(WelcomeActions.class);

    public static final String SUBMIT_APPEAL = "Submit an appeal";
    public static final String MAKE_PAYMENT = "Make a payment";
    public static final String APPEAL_LINK = "Continue submitting an appeal";

    public static final String SUBMIT_APPEAL_VALIDATE = "I have received a decision to refuse my asylum, protection or human rights claim";

    public static final String MAKE_PAYMENT_VALIDATE = "Please enter the payment reference number printed on the letter you have received.";

    public static final String APPEAL_LINK_VALIDATE = "Your reference:";

    @Override
    public void execute() {
        int fieldLength = fields.length;
        if (fieldLength == 2) {
            String action = fields[0];
            String validate = fields[1];
            if (action.equals(SUBMIT_APPEAL) || action.equals(MAKE_PAYMENT) || action.equals(APPEAL_LINK)) {
                findByLinkTextAndClick(action);
                String source = getPageSource();
                if (source.contains(validate)) {
                    logger.info(action + " validated");
                } else {
                    logger.info(action + " Validation Failed");
                }
                clickPreviousButton();
            } else if (null != action) {
                logger.info("Val:" + action + " not understood expected one of:" + SUBMIT_APPEAL + " " + MAKE_PAYMENT + " " + APPEAL_LINK);
            }
        } else {
            logger.info("Screening options not initialised with correct number of fields. Expected 2 was " + fieldLength);
        }
    }
}
