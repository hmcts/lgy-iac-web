package uk.gov.hmcts.legacy.web.selenium.iaft;

import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.Iaft1PageFactory;

public enum IAFTFlowEnum {
    IAFT1_FLOW("iaft1"),
    IAFT2_FLOW("iaft2"),
    IAFT3_FLOW("iaft3"),
    IAFT5_FLOW("iaft5"),
    IAFT6_FLOW("iaft6"),
    IAFT7_FLOW("iaft7");

    private String type;

    private IAFTFlowEnum(String aType) {
        type = aType;
    }

    public String getType() {
        return type;
    }

    public IaftPageFactory GetPageFactory() {
        switch (this) {
            case IAFT1_FLOW:
                return new Iaft1PageFactory();
//            case IAFT2_FLOW:
//                return new Migration_Iaft2PageFactory();
//            case IAFT3_FLOW:
//                return new Migration_Iaft3PageFactory();
//            case IAFT5_FLOW:
//                return new Migration_Iaft5PageFactory();
//            case IAFT6_FLOW:
//                return new Migration_Iaft6PageFactory();
//            case IAFT7_FLOW:
//                return new Migration_Iaft7PageFactory();
            default:
                return null;
        }
    }

}
