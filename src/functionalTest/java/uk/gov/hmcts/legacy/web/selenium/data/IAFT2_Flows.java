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
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft2.page.*;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.*;

public interface IAFT2_Flows {

    public static String[] welcomeActionsSubmitAppeal = {WelcomeActions.SUBMIT_APPEAL, WelcomeActions.SUBMIT_APPEAL_VALIDATE};
    public static final String[] formOptions = {FormOptions.APPEALABLE_DECISION_BEFORE_APR2015_XPATH};

    public static final String[] lodgementOptions = {NewLodgement.APPEAL_WITHIN_UK_NO_LINK};

    public static final String[] ecoOptions = {EcoDecisionAppeal.ECO_APPEAL_YES_LINK};

    public static final String[] referenceOptions = {NavigateEnum.CONTINUE.getValue()};

    /**
     * ************************************************
     * 'Slow' Flow - auto-fills all drop downs - run infrequently!
     * ************************************************.
     */
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
            Page1.TYPE_SETTLEMENT_XPATH,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage2Options = {
            "Smith",
            "Joe",
            "Mr",
            Page2.DAY_1,//null,
            Page2.MONTH_1,//null
            Page2.YEAR_1911,//null
            Page2.GENDER_MALE_XPATH,
            "1 Beech Close",
            "Borough",
            "City",
            Page2.COUNTRY_Albania,//null,
            "OB1 WAN",
            Page2.Nationality_Albanian,//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage3Options = {
            Page3.POINTS_BASED_YES_XPATH,
            "AREFNo/1234",
            Page3.POST_Abuja,
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage4Options = {
            "a",//null,
            "b",//null,
            "c",//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage5Options = {
            "a",//null,
            Page5.APPEALED_YES_XPATH,
            Page5.DAY_1,
            Page5.MONTH_1,
            Page5.YEAR_2011,
            "A_REF1234",
            Page5.DAY_2,
            Page5.MONTH_2,
            Page5.YEAR_2010,
            "A_REF2345",
            Page5.DAY_3,
            Page5.MONTH_3,
            Page5.YEAR_2009,
            "A_REF4567",
            Page5.INTERPRETOR_NEEDED_YES_XPATH,
            "Claire Jones",
            "English",
            "None",
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage6Options = {
            Page6.REPRESENTATIVE_YES_XPATH,
            Page6.SPONSOR_YES_XPATH,
            Page6.DIGITAL_SIGNATURE,
            NavigateEnum.NEXT.getValue()};

    public static final String[] full_stage7Options = {
            "Joe Bloggs",
            Page10.REPRESENTATIVE_ABajwaCoSolicitors,//null
            "Test Organisation",
            "22 Acacia Avenue",
            "X",
            "Y",
            Page7.COUNTRY_Albania,//null
            "123 ABC",
            "Test Reference",
            "001234567",
            "0978786",
            "test@email.co.uk",
            "REF_123/456",
            Page7.ENGLAND_WALES_VALUE,//null
            Page7.APPELLANT_DECLARATION_XPATH,
            Page7.REPRESENTATIVE_NAME,
            NavigateEnum.NEXT.getValue()
    };

    public static final String[] full_stage8Options = {
            "Jones",
            "Fred",
            "Mrs",
            "Addr1",
            "Addr2",
            "Addr3",
            Page8.COUNTRY_Albania,
            "ABC 123",
            "12345678",
            "you@me.net",
            Page8.REPRESENTATIVE_DECLARATION_YES_XPATH,
            NavigateEnum.NEXT.getValue()};

    /**
     * ************************************************
     * 'Quick' Flow - doesn't auto-fill drop downs
     * ************************************************.
     */
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
            Page1.TYPE_SETTLEMENT_XPATH,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage1Options_legalAid = {
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
            Page1.TYPE_SETTLEMENT_XPATH,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage2Options = {
            "Smith",
            "Joe",
            "Mr",
            Page2.DAY_1,//null,
            Page2.MONTH_1,//null
            Page2.YEAR_1911,//null
            Page2.GENDER_MALE_XPATH,
            "1 Beech Close",
            "Borough",
            "City",
            Page2.COUNTRY_Albania,//null,
            "OB1 WAN",
            Page2.Nationality_Albanian,//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage3Options = {
            Page3.POINTS_BASED_YES_XPATH,
            "AREFNo/1234",
            Page3.POST_Abuja,
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2021,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage3Options_DecisionDate = {
            Page3.POINTS_BASED_YES_XPATH,
            "AREFNo/1234",
            Page3.POST_Abuja,
            Page3.SERVICE_DECSION_METHOD_FAX_XPATH,
            "AnotherName",
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2009,
            Page3.DAY_1,
            Page3.MONTH_11,
            Page3.YEAR_2009,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage4Options = {
            "a",//null,
            "b",//null,
            "c",//null,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage5Options = {
            "a",//null,
            Page5.APPEALED_YES_XPATH,
            Page5.DAY_1,
            Page5.MONTH_1,
            Page5.YEAR_2011,
            "A_REF1234",
            Page5.DAY_2,
            Page5.MONTH_2,
            Page5.YEAR_2010,
            "A_REF2345",
            Page5.DAY_3,
            Page5.MONTH_3,
            Page5.YEAR_2009,
            "A_REF4567",
            Page5.INTERPRETOR_NEEDED_YES_XPATH,
            "Claire Jones",
            "English",
            "None",
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage6Options = {
            Page6.REPRESENTATIVE_YES_XPATH,
            Page6.SPONSOR_YES_XPATH,
            Page6.DIGITAL_SIGNATURE,
            NavigateEnum.NEXT.getValue()};

    public static final String[] quick_stage7Options = {
            "Joe Bloggs",
            Page10.REPRESENTATIVE_ABajwaCoSolicitors,//null
            "Test Organisation",
            "22 Acacia Avenue",
            "X",
            "Y",
            Page7.COUNTRY_Albania,//null
            "123 ABC",
            "Test Reference",
            "001234567",
            "0978786",
            "test@email.co.uk",
            "REF_123/456",
            Page7.ENGLAND_WALES_VALUE,//null
            Page7.APPELLANT_DECLARATION_XPATH,
            Page7.REPRESENTATIVE_NAME,
            NavigateEnum.NEXT.getValue()
    };

    public static final String[] quick_stage8Options = {
            "Jones",
            "Fred",
            "Mrs",
            "Addr1",
            "Addr2",
            "Addr3",
            Page8.COUNTRY_Albania,
            "ABC 123",
            "12345678",
            "you@me.net",
            Page8.REPRESENTATIVE_DECLARATION_YES_XPATH,
            NavigateEnum.NEXT.getValue()};

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

    public static final String[] test_payment_options = {
            "Test Name",
            "4111111111111111",
            MakeTestPayment.PAYMENT_MONTH_1,
            MakeTestPayment.YEAR_2024,
            "123",
            NavigateEnum.CONFIRM_PAYMENT.getValue()};

}
