package uk.gov.hmcts.legacy.web.selenium.iaft;

public enum IaftPageEnum {

	IPE_CONFIRM_REPAYMENT("confirm_repayment", true, false, false),

	IPE_CONFIRM("confirm", true, false, false),

	IPE_CONFIRM_ONE("confirrm1",true, false, false),

	IPE_CONTINUE("continue",true, false, false),

	IPE_FINAL("final",true, false, false),

	IPE_FINAL_SUBMISSION_FAILURE("finalsubmission_failure",true, false, false),

	IPE_FINAL_SUBMISSION("finalsubmission",true, false, false),

	IPE_FINAL_TOP_UP_SUBMISSION("finaltopupsubmission",true, false, false),

	IPE_OPTIONS("options",true, true, true),

	IPE_PAGE_ONE("page-1",true, true, true),

	IPE_PAGE_TWO("page-2",true, true, true),

	IPE_PAGE_THREE("page-3",true, true, true),

	IPE_PAGE_FOUR("page-4",true, true, true),

	IPE_PAGE_FIVE("page-5",true, true, true),

	IPE_PAGE_SIX("page-6",true, true, true),

	IPE_PAGE_SEVEN("page-7",true, true, true),

	IPE_PAGE_EIGHT("page-8",true, true, true),

	IPE_PAGE_NINE("page-9",true, false, true),

	IPE_PAGE_TEN("page-10",true, false, true),

	IPE_PAYMENT("payment",true, true, true),

	IPE_RETURN_CONFIRM("return_confirm",true, false, false),

	IPE_SUCCESS_PAYMENT("successpayment",true, false, false),

	IPE_TOP_UP_REPAYMENT("topup_repayment",true, false, false),

	IPE_TOP_UP("topup",true, true, true),

	IPE_DEFAULT_LAYOUT("defaultlayout",false,true,true),

	IPE_REFERENCE("reference", false, true, true),

	IPE_RETRIEVAL("retrieval", false, true, true),

	IPE_ASYLUM_REFUSAL_IAFT1("asylum-refusal-iaft1", true, false, false),

	IPE_ASYLUM_REFUSAL_IAFT3("asylum-refusal-iaft3", false,false,true),

	IPE_ECO_DECISION_APPEAL("eco-decision-appeal", false, false, false),

	IPE_EXTERNAL_APPEAL("external-appeal", false, false, false),

	IPE_FEE_PAYABLE ("fee-payable",false,false,false),

	IPE_NEW_LODGEMENT("new-lodgement", false, false, false)
	;

	private String pageName;

	public String getPage;

	boolean isUsedinIAFT1;

	boolean isUsedinIAFT2;

	boolean isUsedinIAFT3;

	/**
	 * Instantiates a new iaft page enum.
	 *
	 * @param aPageName
	 *            the a page name
	 * @param is1
	 *            the is1
	 * @param is2
	 *            the is2
	 * @param is3
	 *            the is3
	 */
	private IaftPageEnum(String aPageName, boolean is1, boolean is2, boolean is3){
		pageName = aPageName;
		isUsedinIAFT1 = is1;
		isUsedinIAFT2 = is2;
		isUsedinIAFT3 = is3;

	}

	public String getPageName(){
		return pageName;
	}

	public boolean isUsedInIAFT1() {
		return isUsedinIAFT1;
	}

	public boolean isUsedInIAFT2() {
		return isUsedinIAFT2;
	}

	public boolean isUsedInIAFT3() {
		return isUsedinIAFT3;
	}
}
