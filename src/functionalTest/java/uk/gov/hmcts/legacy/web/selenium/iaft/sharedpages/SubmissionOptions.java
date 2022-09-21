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

public class SubmissionOptions extends AbstractIAFTPage implements IaftPage {

    static Logger logger = Logger.getLogger(SubmissionOptions.class);

    public static final String MAKE_ADDITIONAL_LODGEMENT_LINK = "Submit another appeal";

    public static final String FINISH_SUBMISSION_LINK = "Finish Submission";

    public static final String PAY_FOR_LODGEMENTS_LINK = "Pay for the appeal(s) just completed";

    @Override
    public void execute() {
        logger.info("Executing Submission Options");
        int fieldLength = fields.length;
        if (fieldLength == 1) {
            String val = fields[0];
            if (val.equals(MAKE_ADDITIONAL_LODGEMENT_LINK)) {
                findByLinkTextAndClick(MAKE_ADDITIONAL_LODGEMENT_LINK);
            } else if (val.equals(FINISH_SUBMISSION_LINK)) {
                findByLinkTextAndClick(FINISH_SUBMISSION_LINK);
            } else if (val.equals(PAY_FOR_LODGEMENTS_LINK)) {
                findByLinkTextAndClick(PAY_FOR_LODGEMENTS_LINK);
            } else {
                logger.info("Val:" + val + " not understood expected one of:" + MAKE_ADDITIONAL_LODGEMENT_LINK +
                        " " + FINISH_SUBMISSION_LINK +
                        " " + PAY_FOR_LODGEMENTS_LINK);
            }
        } else {
            logger.info("Options not initialised with correct number of fields. Expected 1 was "
                    + fieldLength);
        }
    }

}
