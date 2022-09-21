package uk.gov.hmcts.legacy.web.selenium.iaft;

import uk.gov.hmcts.legacy.web.selenium.BaseTest;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;

public class AbstractIAFTPage extends BaseTest implements IaftPage {
    protected String [] fields = null;

    @Override
    public void navigationOption(NavigateEnum navOption) {
    }

    @Override
    public void initialise(String[] theFields) {
        fields = theFields;
    }

    @Override
    public void execute() {

    }
}
