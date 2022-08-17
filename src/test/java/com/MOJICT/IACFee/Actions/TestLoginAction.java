/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/

package com.MOJICT.IACFee.Actions;

import servletunit.struts.MockStrutsTestCase;
import org.junit.Ignore;

// TODO: Auto-generated Javadoc
/**
 * The Class TestLoginAction.
 */
@Ignore
public class TestLoginAction extends MockStrutsTestCase {

    /**
	 * Instantiates a new test login action.
	 * 
	 * @param testName
	 *            the test name
	 */
    public TestLoginAction(String testName) {
        super(testName);
    }

    /* (non-Javadoc)
     * @see servletunit.struts.MockStrutsTestCase#setUp()
     */
    public void setUp() throws Exception {
        super.setUp();
        setInitParameter("validating","false");
    }

    /**
	 * Test successful login.
	 */
    public void testSuccessfulLogin() {

        addRequestParameter("username","deryl");
        addRequestParameter("password","radar");
        setRequestPathInfo("/login");
        actionPerform();
        verifyForward("success");
        verifyForwardPath("/main/success.jsp");
        assertEquals("deryl",getSession().getAttribute("authentication"));
        verifyNoActionErrors();
    }

    /**
	 * Test failed login.
	 */
    public void testFailedLogin() {

        addRequestParameter("username","deryl");
        addRequestParameter("password","express");
        setRequestPathInfo("/login");
        actionPerform();
        verifyForward("login");
        verifyForwardPath("/login/login.jsp");
        verifyInputForward();
        verifyActionErrors(new String[] {"error.password.mismatch"});
        assertNull(getSession().getAttribute("authentication"));
    }

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestLoginAction.class);
    }


}

