package uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import org.apache.log4j.Logger;

public class AsylumRefusalIAFT1 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(AsylumRefusalIAFT1.class);

	public static final String ASYLUM_REFUSAL_NO_LINK_XPATH  = "//*[@id=\"no\"]";

	public static final String ASYLUM_REFUSAL_YES_LINK_XPATH  = "//*[@id=\"yes\"]";

	public static final String PREVIOUS_LINK  = "previous";

	@Override
	public void execute() {
		logger.info("Executing AsylumRefusalIAFT1");
		int fieldLength = fields.length;
		if (fieldLength == 1) {
			String action = fields[0];
			if (action.equals(ASYLUM_REFUSAL_NO_LINK_XPATH)|| action.equals(ASYLUM_REFUSAL_YES_LINK_XPATH)||action.equals(PREVIOUS_LINK)) {
				findByXPathAndClick(action);
				clickNextButton();
				String source = getPageSource();
				if (source.contains("Some appeals are exempt from paying a fee.")) {
					logger.info("AsylumRefusalIAFT1 validated");
				} else {
					logger.info("AsylumRefusalIAFT1 Validation Failed");
				}
			}  else {
				logger.info("Val:" + action + " not understood expected one of:" + ASYLUM_REFUSAL_NO_LINK_XPATH + " "
						+ ASYLUM_REFUSAL_YES_LINK_XPATH + " " + PREVIOUS_LINK);
			}
		} else {
			logger.info("AsylumRefusal Screening not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}
	}
}
