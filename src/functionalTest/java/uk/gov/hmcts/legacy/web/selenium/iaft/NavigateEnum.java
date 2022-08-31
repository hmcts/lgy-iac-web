package uk.gov.hmcts.legacy.web.selenium.iaft;

public enum NavigateEnum {

    CONTINUE ( "continue"),

    PREVIOUS ("previous"),

    FINISH ("finish"),

    NEXT("next");

    String navigation;

    private NavigateEnum(String aNavigation){
        navigation = aNavigation;
    }

    public String getValue(){
        return navigation;
    }
}
