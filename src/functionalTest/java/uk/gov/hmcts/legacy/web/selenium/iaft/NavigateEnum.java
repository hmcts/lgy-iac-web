package uk.gov.hmcts.legacy.web.selenium.iaft;

public enum NavigateEnum {

	/** The CONTINUE. */
	CONTINUE ( "continue"),
	/** The PREVIOUS. */
	PREVIOUS ("previous"),
	/** The FINISH. */
	FINISH ("finish"),
	/** The NEXT. */
	NEXT("next"),
	/** The SAVE & NEXT. */
	SAVE_NEXT("Save & Next"),
	/** The CONFIRM_PAYMENT. */
	CONFIRM_PAYMENT("Yes, I confirm my payment");

	/** The navigation. */
	String navigation;

	/**
	 * Instantiates a new navigate enum.
	 *
	 * @param aNavigation
	 *            the a navigation
	 */
	private NavigateEnum(String aNavigation){
		navigation = aNavigation;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue(){
		return navigation;
	}
}
