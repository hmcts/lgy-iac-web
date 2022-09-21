/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;

public class Page8 extends AbstractIAFTPage implements IaftPage {

    static Logger logger = Logger.getLogger(Page8.class);

    public static final String APPEALED_NO_XPATH = "//input[@name='s3e' and @value='No']";

    public static final String APPEALED_YES_XPATH = "//input[@name='s3e' and @value='Yes']";

    public static final String APPEAL1_DAY_NAME = "s3e_date1_day";

    public static final String APPEAL1_MONTH_NAME = "s3e_date1_month";

    public static final String APPEAL1_YEAR_NAME = "s3e_date1_year";

    public static final String APPEAL2_DAY_NAME = "s3e_date2_day";

    public static final String APPEAL2_MONTH_NAME = "s3e_date2_month";

    public static final String APPEAL2_YEAR_NAME = "s3e_date2_year";

    public static final String APPEAL3_DAY_NAME = "s3e_date3_day";

    public static final String APPEAL3_MONTH_NAME = "s3e_date3_month";

    public static final String APPEAL3_YEAR_NAME = "s3e_date3_year";

    public static final String APPEAL1_NUMBER_NAME = "s3e_appealno1";

    public static final String APPEAL2_NUMBER_NAME = "s3e_appealno2";

    public static final String APPEAL3_NUMBER_NAME = "s3e_appealno3";

    @Override
    public void execute() {
        logger.info("Executing IAFT1 Step 8");
        int fieldLength = fields.length;
        if (fieldLength == 14) {

            String val = fields[0];
            if (val.equals(APPEALED_NO_XPATH)) {
                findByXPathAndClick(APPEALED_NO_XPATH);
            } else if (val.equals(APPEALED_YES_XPATH)) {
                findByXPathAndClick(APPEALED_YES_XPATH);
            } else {
                logger.info("Val:" + val + " not understood expected one of:" + APPEALED_NO_XPATH + " "
                        + APPEALED_YES_XPATH);
            }

            val = fields[1];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL1_DAY_NAME, val);
            } else {
                for (String day : DAYS) {
                    findSelectByNameAndSelectByValue(APPEAL1_DAY_NAME, day);
                }
            }

            val = fields[2];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL1_MONTH_NAME, val);
            } else {
                for (String month : MONTHS) {
                    findSelectByNameAndSelectByValue(APPEAL1_MONTH_NAME, month);
                }
            }

            val = fields[3];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL1_YEAR_NAME, val);
            } else {
                for (String year : APPEAL_YEARS) {
                    findSelectByNameAndSelectByValue(APPEAL1_YEAR_NAME, year);
                }
            }

            val = fields[4];
            if (null != val) {
                findByNameAndEnterText(APPEAL1_NUMBER_NAME, val);
            }

            val = fields[5];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL2_DAY_NAME, val);
            } else {
                for (String day : DAYS) {
                    findSelectByNameAndSelectByValue(APPEAL2_DAY_NAME, day);
                }
            }

            val = fields[6];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL2_MONTH_NAME, val);
            } else {
                for (String month : MONTHS) {
                    findSelectByNameAndSelectByValue(APPEAL2_MONTH_NAME, month);
                }
            }

            val = fields[7];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL2_YEAR_NAME, val);
            } else {
                for (String year : APPEAL_YEARS) {
                    findSelectByNameAndSelectByValue(APPEAL2_YEAR_NAME, year);
                }
            }

            val = fields[8];
            if (null != val) {
                findByNameAndEnterText(APPEAL2_NUMBER_NAME, val);
            }

            val = fields[9];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL3_DAY_NAME, val);
            } else {
                for (String day : DAYS) {
                    findSelectByNameAndSelectByValue(APPEAL3_DAY_NAME, day);
                }
            }

            val = fields[10];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL3_MONTH_NAME, val);
            } else {
                for (String month : MONTHS) {
                    findSelectByNameAndSelectByValue(APPEAL3_MONTH_NAME, month);
                }
            }

            val = fields[11];
            if (val != null) {
                findSelectByNameAndSelectByValue(APPEAL3_YEAR_NAME, val);
            } else {
                for (String year : APPEAL_YEARS) {
                    findSelectByNameAndSelectByValue(APPEAL3_YEAR_NAME, year);
                }
            }

            val = fields[12];
            if (null != val) {
                findByNameAndEnterText(APPEAL3_NUMBER_NAME, val);
            }

            val = fields[13];
            if (val.equals(NavigateEnum.NEXT.getValue())) {
                clickNextButton();
            } else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
                clickPreviousButton();
            } else {
                logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
                        + " " + NavigateEnum.PREVIOUS.getValue());
            }

        } else {
            logger.info("Page8 not initialised with correct number of fields. Expected 14 was "
                    + fieldLength);
        }

    }
}
