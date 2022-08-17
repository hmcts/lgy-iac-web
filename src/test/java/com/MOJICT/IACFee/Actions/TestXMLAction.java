/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package com.MOJICT.IACFee.Actions;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import servletunit.struts.MockStrutsTestCase;

// TODO: Auto-generated Javadoc
/**
 * ***REQUIREMENT**********************************************
* 1 - Single appeal payment
* successful - output = PDF and XML, not allow further payment allowed 
* 2 - Single appeal top up payment successful - output = XML, not allow further
* payments allowed 
* 3 - Single payment unsuccessful (Barclaycard failure) -
* 	Check Count 
* 	3.1 Count < 5 - retry possible 
* 	3.2 Count >= 5 - printable pdf
* 		submission not allow further submissions no xml 
* 4 - Top up payment unsuccessful - 
 	Check Count 
* 	4.1 Count < 5 - retry possible 
* 	4.2 Count >= 5 - printable pdf
* 		submission not allow further submissions no xml 
* 5 - Multiple appeal payment
* successful - output = PDF /XML per appeal, no further payment allowed 
* 6 - Multiple appeal top up payment successful - output = XML, no further payments
* allowed 
* 7 - Multiple appeal payment unsuccessful - 
* 	Check Count 
* 	7.1 Count < 5 - retry possible 
*  7.2 Count >= 5 - printable PDF for each appeal no xml
* 8 - Multiple Top up payment unsuccessful - 
 	Check Count 
* 	8.1 Count < 5 - retry possible 
* 	8.2 Count >= 5 - printable pdf
* 		submission not allow further submissions no xml 
********** MAPPING *******************************************
*  <action path="/getxml" type="XMLAction" scope="request">
  <forward name="success" path="finalone.definition"/>
  <forward name="return" path="final.definition"/>
  <forward name="return_pdf" path="final_pdf.definition"/>
  </action>
* */
@Ignore
public class TestXMLAction extends MockStrutsTestCase {
	
	/** The path. */
	private String path = "/getxml";
	
	/** The TRANSACTIO n_ success. */
	public final String TRANSACTION_SUCCESS = "Success";
	
	/** The TRANSACTIO n_ failure. */
	public final String TRANSACTION_FAILURE = "Failure";
	
	/** The FORWAR d_ success. */
	public final String FORWARD_SUCCESS = "success";
	
	/** The FORWAR d_ failure. */
	public final String FORWARD_FAILURE = "failure";
	
	/** The FORWAR d_ retry. */
	public final String FORWARD_RETRY = "return";
	
	/** The FORWAR d_ pdf. */
	public final String FORWARD_PDF = "return_pdf";
	
    
    /**
     * The set of public identifiers, and corresponding resource names, for
     * the versions of the configuration file DTDs that we know about.  There
     * <strong>MUST</strong> be an even number of Strings in this list!
     */
    protected String registrations[] = {
        "-//Sun Microsystems, Inc.//DTD Web Application 2.2//EN",
        "/org/apache/struts/resources/web-app_2_2.dtd",
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN",
        "/org/apache/struts/resources/web-app_2_3.dtd"
    };
    
  
	
	/**
	 * Instantiates a new test xml action.
	 * 
	 * @param testName
	 *            the test name
	 */
	public TestXMLAction(String testName) {
		super(testName);
	}
	
	/* (non-Javadoc)
	 * @see servletunit.struts.MockStrutsTestCase#setUp()
	 */
	public void setUp() {
		 try {
			super.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Prepare.
	 */
	@Before
	public void prepare() {        
        File f = new File(System.getProperty("user.dir"));
        this.setContextDirectory(f);
        //this.setInitParameter(key, value);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 1 - Single appeal payment successful - output = PDF and XML, not allow
	 * further payment allowed.
	 */
	@Test
	public void testSingleAppealPaymentSuccess() {
		prepare();
		//request.addParameter("oid","asinglepaymentoid");
		//request.addParameter("transactionstatus",TRANSACTION_SUCCESS);
        getSession().setAttribute("count", 1);
        getSession().setAttribute("paymenttype", 1);
		actionPerform();
		verifyForward(FORWARD_SUCCESS);
		
	}
	
	/**
	 *  3 - Single payment unsuccessful (Barclaycard failure) -
	 * 	Check Count 
	 * 	3.1 Count < 5 - retry possible 
	 */
	//@Test
	//public void testSingleAppealPaymentFaillt5() {
	//	addRequestParameter("oid", "asinglepaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 3);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();
	//	verifyForward(FORWARD_RETRY);
	//	
	//}
	
	/**
	 *  3 - Single payment unsuccessful (Barclaycard failure) -
	 * 	Check Count 
	 * 	3.1 Count > 5 - retry possible 
	 */
	//@Test
	//public void testSingleAppealPaymentFailgt5() {
	//	addRequestParameter("oid", "asinglepaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 5);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();	
	///	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 *  3 - Single payment unsuccessful (Barclaycard failure) -
	 * 	Check Count 
	 * 	3.1 Count = 5 - retry possible 
	 */
	//@Test
	//public void testSingleAppealPaymentFailEqual5() {
	//	addRequestParameter("oid", "asinglepaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 4);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();
	//	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 * 5 - Multiple appeal payment
	 * successful - output = PDF /XML per appeal, no further payment allowed
	 */
	//@Test
	//public void testMultipleAppealPaymentSuccess() {
	//	addRequestParameter("oid", "amultipaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_SUCCESS);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();	
	//	verifyForward(FORWARD_SUCCESS);
	//}	
	
	/**
	 * 7 - Multiple appeal payment unsuccessful - 
	 * 	Check Count 
	 * 	7.1 Count < 5 - retry possible 
	 */
	//@Test
	//public void testMultipleAppealPaymentFaillt5() {
	//	addRequestParameter("oid", "amultipaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();		
	//	verifyForward(FORWARD_RETRY);
	//}
	/**
	 * 7 - Multiple appeal payment unsuccessful - 
	 * 	Check Count 
	 *  7.2 Count > 5 - printable PDF for each appeal no xml
	 */
	//@Test
	//public void testMultipleAppealPaymentFailgt5() {
	//	addRequestParameter("oid", "amultipaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 5);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();		
	//	verifyForward(FORWARD_PDF);
	//}
	/**
	 * 7 - Multiple appeal payment unsuccessful - 
	 * 	Check Count 
	 *  7.2 Count = 5 - printable PDF for each appeal no xml
	 */
	//@Test
	//public void testMultipleAppealPaymentFailEquals5() {
	//	addRequestParameter("oid", "amultipaymentoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 4);
	//	getSession().setAttribute("paymenttype", 1);
	//	actionPerform();	
	//	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 * 2 - Single appeal top up payment successful - output = XML, not allow further
	 * payments allowed 
	 */
	//@Test
	//public void testSingleTopUpPaymentSuccess() {
	//	addRequestParameter("oid", "validverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_SUCCESS);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();		
	//	verifyForward(FORWARD_SUCCESS);
	//}
	
	/**
	 * 4 - Top up payment unsuccessful - Check Count 
	 * 	4.1 Count < 5 - retry possible 
	 * 		submission not allow further submissions no xml
	 */
	//@Test
	//public void testSingleTopUpPaymentFaillt5() {
	//	addRequestParameter("oid", "validverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();		
	//	verifyForward(FORWARD_RETRY);
	//}
	/**
	 * 4 - Top up payment unsuccessful - Check Count 
	 * 	4.2 Count > 5 - printable pdf
	 * 		submission not allow further submissions no xml
	 */
	//@Test
	//public void testSingleTopUpPaymentFailgt5() {
	//	addRequestParameter("oid", "validverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 5);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();
	//	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 * 4 - Top up payment unsuccessful - Check Count 
	 * 	4.2 Count = 5 - printable pdf
	 * 		submission not allow further submissions no xml
	 */
	//@Test	
	//public void testSingleTopUpPaymentFailEquals5() {
	//	addRequestParameter("oid", "validverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 4);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();	
	//	verifyForward(FORWARD_PDF);
	//}
	/**
	 * 6 - Multiple appeal top up payment successful - output = XML, no further payments
	 * allowed 
	 */
	//@Test
	//public void testMultipleTopUpPaymentSuccess() {
	//	addRequestParameter("oid", "multivalidverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_SUCCESS);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();	
	//	verifyForward(FORWARD_SUCCESS);
	//}
	/**
	 * 8 - Multiple Top up payment unsuccessful - 	Check Count 
	 * 	8.1 Count < 5 - retry possible 
	 * 		submission not allow further submissions no xml
	 */
	//@Test
	//public void testMultipleTopUpPaymentFaillt5() {
	//	addRequestParameter("oid", "multivalidverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 1);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();		
	//	verifyForward(FORWARD_RETRY);
	//}
	
	/**
	 * 8 - Multiple Top up payment unsuccessful - 	Check Count 
	 * 	8.2 Count > 5 - printable pdf
	 * 		submission not allow further submissions no xml
	 */
	//@Test
	//public void testMultipleTopUpPaymentFailgt5() {
	//	addRequestParameter("oid", "multivalidverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 5);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();		
	//	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 * 8 - Multiple Top up payment unsuccessful - 	Check Count 
	 * 	8.2 Count = 5 - printable pdf
	 * 		submission not allow further submissions no xml
	 */
	//@Test
	//public void testMultipleTopUpPaymentFailEquals5() {
	//	addRequestParameter("oid", "multivalidverhoefftopupid");
	//	addRequestParameter("transactionstatus", TRANSACTION_FAILURE);
	//	getSession().setAttribute("count", 4);
	//	getSession().setAttribute("paymenttype", 2);
	//	actionPerform();
	//	verifyForward(FORWARD_PDF);
	//}
	
	/**
	 * Happy flow without correct oid and so no security token - should fail
	 */
	//@Test
	//public void testFailureByNotSettingSecurityToken() {
	//	addRequestParameter("oid", "invalidnonexistantoid");
	//	addRequestParameter("transactionstatus", TRANSACTION_SUCCESS);
    //    getSession().setAttribute("count", 1);
   //     getSession().setAttribute("paymenttype", 1);
	//	actionPerform();
	//	verifyForward(FORWARD_FAILURE);
	//}
	
	
}
