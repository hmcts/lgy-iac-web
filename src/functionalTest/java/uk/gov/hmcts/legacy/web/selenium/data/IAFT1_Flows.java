/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.data;

import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page.*;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.*;

public interface IAFT1_Flows {

    public static String[] welcomeActionsSubmitAppeal = {WelcomeActions.SUBMIT_APPEAL, WelcomeActions.SUBMIT_APPEAL_VALIDATE};
    public static final String[] formOptions = {FormOptions.APPEALABLE_DECISION_BEFORE_APR2015_XPATH};

    public static final String[] lodgementOptions = {NewLodgement.APPEAL_WITHIN_UK_YES_LINK};
    public static final String[] asylumOptions = {AsylumRefusalIAFT1.ASYLUM_REFUSAL_YES_LINK_XPATH};
    public static final String[] feeOptions = {FeePayable.FEE_P2_XPATH, NavigateEnum.NEXT.getValue()};

    /***********************STAGE 1 PAGE*************************/
    public static final String[] quick_stage1Options = {
            Page1.ORAL_CHECK_XPATH,
            Page1.SPONSOR_NAME,
            Page1.REPRESENTATIVE_NAME,
            Page1.WITNESS_NAME,
            Page1.NO_FUNDING_XPATH,
            "123456789",
            Page1.FAMILY_MEMBER_YES_XPATH,
            "Joe",
            "Brother",
            "1234-+",
            "Chad",
            "Dad",
            "ABCDabcd",
            "ANN",
            "Grandparent",
            "!^%$",
            "Roxanne",
            "Cousin",
            "ABCD/1234",
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_legalaid_stage1Options = {
            Page1.ORAL_CHECK_XPATH,
            Page1.SPONSOR_NAME,
            Page1.REPRESENTATIVE_NAME,
            Page1.WITNESS_NAME,
            Page1.LEGAL_AID_FUNDING_XPATH,
            "123456789",
            Page1.FAMILY_MEMBER_YES_XPATH,
            "Joe",
            "Brother",
            "1234-+",
            "Chad",
            "Dad",
            "ABCDabcd",
            "ANN",
            "Grandparent",
            "!^%$",
            "Roxanne",
            "Cousin",
            "ABCD/1234",
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage1Options = {
            Page1.ORAL_CHECK_XPATH,
            Page1.SPONSOR_NAME,
            Page1.REPRESENTATIVE_NAME,
            Page1.WITNESS_NAME,
            Page1.NO_FUNDING_XPATH,
            "123456789",
            Page1.FAMILY_MEMBER_YES_XPATH,
            "Joe",
            "Brother",
            "1234-+",
            "Chad",
            "Dad",
            "ABCDabcd",
            "ANN",
            "Grandparent",
            "!^%$",
            "Roxanne",
            "Cousin",
            "ABCD/1234",
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 2 PAGE************************.
     */
    public static final String[] quick_stage2Options = {
            "Smith",
            "Joe",
            "Mr",
            Page2.DAY_1,
            Page2.MONTH_1,//null
            Page2.YEAR_1911,//null
            Page2.GENDER_MALE_XPATH,
            "1 Beech Close",
            "Borough",
            "City",
            Page2.COUNTRY_Albania,//null,
            "OB1 WAN",
            "123456",
            Page2.Nationality_Albanian,//null,
            Page2.REPRESENTING_YOURSELF_NAME,
            Page2.REPRESENTING_REPRESENTATIVE_NAME,
            Page2.REPRESENTING_WITNESS_NAME,
            Page2.INTERPRETOR_NEEDED_YES_XPATH,
            "Claire Jones",
            "English",
            "None",
            "dummyText",//null,
            Page2.REMOVAL_DIRECTIONS_SET_YES_XPATH,
            Page2.HOUR_01,//null,
            Page2.MINUTE_05,//null,
            Page2.AM,//null,
            Page2.DAY_1,//null,
            Page2.MONTH_1,//null,
            Page2.YEAR_2021,//null,
            Page2.CRIMINAL_SENTENCE_YES_XPATH,
            Page2.DAY_1,//null,
            Page2.MONTH_1,//null,
            Page2.YEAR_2011,//null,
            Page2.CRIMINAL_B_TYPE_XPATH,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage2Options = {
            "Smith",
            "Joe",
            "Mr",
            null,
            null,
            null,
            Page2.GENDER_MALE_XPATH,
            "1 Beech Close",
            "Borough",
            "City",
            null,
            "OB1 WAN",
            "123456",
            null,
            Page2.REPRESENTING_YOURSELF_NAME,
            Page2.REPRESENTING_REPRESENTATIVE_NAME,
            Page2.REPRESENTING_WITNESS_NAME,
            Page2.INTERPRETOR_NEEDED_YES_XPATH,
            "Claire Jones",
            "English",
            "None",
            null,
            Page2.REMOVAL_DIRECTIONS_SET_YES_XPATH,
            null,
            null,
            null,
            null,
            null,
            null,
            Page2.CRIMINAL_SENTENCE_YES_XPATH,
            null,
            null,
            null,
            Page2.CRIMINAL_B_TYPE_XPATH,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 3 PAGE************************.
     */
    public static final String[] quick_stage3Options = {
            "H12345",
            "APortRef/1234",
            "ACohidRef\0987",
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_RemissionDate_stage3Options = {
            "H12345",
            "APortRef/1234",
            "ACohidRef\0987",
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2009,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2009,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage3Options = {
            "H12345",
            "APortRef/1234",
            "ACohidRef\0987",
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2011,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2011,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 4 PAGE************************.
     */
    public static final String[] quick_stage4Options = {
            "a",//null,
            "b",//null,
            "c",//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage4Options = {
            null,
            null,
            null,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 5 PAGE************************.
     */
    public static final String[] quick_stage5Options = {
            "a",//null,
            "b",//null,
            "c",//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage5Options = {
            null,
            null,
            null,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 6 PAGE************************.
     */
    public static final String[] quick_stage6Options = {
            "test a",//null,
            "test b",//null,
            "test c",//null,
            "test d",//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage6Options = {
            null,
            null,
            null,
            null,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 7 PAGE************************.
     */
    public static final String[] quick_stage7Options = {
            "test a",//null,
            "test b",//null,,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage7Options = {
            null,
            null,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 8 PAGE************************.
     */
    public static final String[] quick_stage8Options = {
            Page8.APPEALED_YES_XPATH,
            Page8.DAY_1,
            Page8.MONTH_1,
            Page8.YEAR_2011,
            "A_REF1234",
            Page8.DAY_2,
            Page8.MONTH_2,
            Page8.YEAR_2010,
            "A_REF2345",
            Page8.DAY_3,
            Page8.MONTH_3,
            Page8.YEAR_2009,
            "A_REF4567",
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage8Options = {
            Page8.APPEALED_YES_XPATH,
            Page8.DAY_1,
            Page8.MONTH_1,
            Page8.YEAR_2011,
            "A_REF1234",
            Page8.DAY_2,
            Page8.MONTH_2,
            Page8.YEAR_2010,
            "A_REF2345",
            Page8.DAY_3,
            Page8.MONTH_3,
            Page8.YEAR_2009,
            "A_REF4567",
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 9 PAGE************************.
     */
    public static final String[] quick_stage9Options = {
            Page9.REPRESENTATIVE_YES_XPATH,
            Page9.DIGITAL_SIGNATURE,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage9Options = {
            Page9.REPRESENTATIVE_YES_XPATH,
            Page9.DIGITAL_SIGNATURE,
            NavigateEnum.NEXT.getValue()};

    /**
     * ********************STAGE 10 PAGE************************.
     */
    public static final String[] full_stage10Options = {
            "Joe Bloggs",
            null,
            "Test Organisation",
            "22 Acacia Avenue",
            "X",
            "Y",
            null,
            "123 ABC",
            "Test Reference",
            "1234567",
            "001234567",
            "0978786",
            "test@email.co.uk",
            "REF_123/456",
            null,
            Page10.APPELLANT_DECLARATION_XPATH,
            Page10.REPRESENTATIVE_NAME,
            NavigateEnum.NEXT.getValue()
    };

    public static final String[] quick_stage10Options = {
            "Joe Bloggs",
            Page10.REPRESENTATIVE_ABajwaCoSolicitors,//null
            "Test Organisation",
            "22 Acacia Avenue",
            "X",
            "Y",
            Page10.COUNTRY_Albania,//null
            "123 ABC",
            "Test Reference",
            "1234567",
            "001234567",
            "0978786",
            "test@email.co.uk",
            "REF_123/456",
            Page10.ENGLAND_WALES_VALUE,//null
            Page10.APPELLANT_DECLARATION_XPATH,
            Page10.REPRESENTATIVE_NAME,
            NavigateEnum.NEXT.getValue()
    };

    /** *********************OPTIONS PAGE************************. */
    /**
     * Options page (at end of making an appeal)
     * Decide to either pay / finalise or make another lodgement
     */
    public static final String[] remission_FinaliseOptions = {
            SubmissionOptions.FINISH_SUBMISSION_LINK
    };

    public static final String[] paymentSubmission_FinaliseOptions = {
            SubmissionOptions.PAY_FOR_LODGEMENTS_LINK
    };

    public static final String[] makeAdditionalLodgement_FinaliseOptions = {
            SubmissionOptions.MAKE_ADDITIONAL_LODGEMENT_LINK
    };

    public static final String[] empty = {};

}
