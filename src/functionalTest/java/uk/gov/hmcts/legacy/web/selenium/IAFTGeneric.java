package uk.gov.hmcts.legacy.web.selenium;

public interface IAFTGeneric {
    //link

    public static final String LODGE_AN_APPEAL_LINK = "Submit an appeal";

    public static final String MAKE_ANOTHER_LODGEMENT_LINK = "Make another lodgement";

    public static final String YES_LINK = "Yes";

    public static final String NO_LINK = "No";

    //xpaths

    public static final String ORAL_CHECK_XPATH = "//input[@value='Oral']";


    public static final String MALE_CHECK_XPATH = "//input[@value='Male']";


    public static final String APPEALED_ALREADY_NO_XPATH = "//input[@name='s3e' and @value='No']";

    public static final String REPRESENTATIVE_NO_XPATH = "//input[@name='have_rep' and @value='No']";

    public static final String SPONSOR_NO_XPATH = "//input[@name='have_sponsor' and @value='No']";

    //names

    public static final String SPONSOR_NAME = "qa_sponsor";

    public static final String LAST_NAME_NAME = "s1a";

    public static final String FIRST_NAME_NAME = "s1b";

    public static final String TITLE_NAME = "s1c";

    public static final String DOB_DAY_NAME = "s1d_dob_day";

    public static final String DOB_MONTH_NAME = "s1d_dob_month";

    public static final String DOB_YEAR_NAME = "s1d_dob_year";

    public static final String ADDRESS_LINE_1 = "s1f_addr1";

    public static final String POSTCODE_NAME = "s1f_postcode";

    public static final String ADDRESS_COUNTRY_NAME = "s1f_addr4";

    public static final String DECLARATION_NAME = "s4_decalaration";

    //entry text

    public static final String LAST_NAME_TEXT = "Jones";

    public static final String FIRST_NAME_TEXT = "Tom";

    public static final String TITLE_TEXT = "Mr";

    public static final String POSTCODE_TEXT = "AA11AA";

    public static final String ADDRESS_LINE_1_TEXT = "22 Acacia Drive";

    //select values

    public static final String ONE = "1";

    public static final String TWENTY = "20";

    public static final String OCT = "10";

    public static final String NINETEEN_ELEVEN = "1911";

    public static final String ALBANIA = "2:Albania";

    public static final String ALBANIAN = "2:Albanian";

    public static final String TWENTY_O_EIGHT = "2008";

    public static final String TWENTY_O_ELEVAN = "2011";
}
