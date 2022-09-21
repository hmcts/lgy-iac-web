/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;

public class VisaTypeAppeal extends AbstractIAFTPage implements IaftPage {

    static Logger logger = Logger.getLogger(EcoDecisionAppeal.class);

    public static final String REFUSAL_HUMAN_RIGHTS_CLAIM_XPATH  = "//input[@name='asylum' and @value='humanrights6']";

    public static final String DECISION_EEA6_XPATH  = "//input[@name='asylum' and @value='eea6']";

    @Override
    public void execute() {
        logger.info("Executing VisaTypeAppealOptions");
        int fieldLength = fields.length;
        if (fieldLength == 2) {
            String val = fields[0];
            if (val.equals(REFUSAL_HUMAN_RIGHTS_CLAIM_XPATH)|| val.equals(DECISION_EEA6_XPATH)) {
                findByXPathAndClick(val);
            }

            val = fields[1];
            if (val.equals(NavigateEnum.NEXT.getValue())) {
                clickNextButton();
            } else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
                clickPreviousButton();
            } else {
                logger.info("Val:" + val + " not understood expected one of:" + REFUSAL_HUMAN_RIGHTS_CLAIM_XPATH + " "
                + DECISION_EEA6_XPATH);
            }

        } else {
            logger.info("VisaTypeAppealOptions not initialised with correct number of fields. Expected 2 was "
                    + fieldLength);
        }

    }
}
