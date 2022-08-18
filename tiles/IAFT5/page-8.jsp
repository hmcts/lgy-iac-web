<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		initForm('iaft1-pg09')
	});
</script>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 9 of 10</h2>
			<div align="right"><h3>Your reference : IAFT5-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>

		<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision or EU Settlement Scheme Decision</h3>

			<div class="formcon">
				<div class="edit"></div>

				<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">This page is missing information.  Please correct following:</span>
							<div id="fields"><bean:write name="errMsg" filter="false"/></div>
						</div>
					</div>
				</logic:present>

				<html:form action="submission5">
					<fieldset>
						<div class="qBox">
							<span class="lCellTl-noBold">Do you have a representative ?<span class="required">*</span></span>
							<span class="rCellTl">
								No&nbsp;<html:radio property="have_rep" value="No" styleId="rep_no" />
								Yes&nbsp;<html:radio property="have_rep" value="Yes"  styleId="rep_yes" />
							</span>
						</div>
					</fieldset>



					<h3>Section 4 &ndash; Your declaration</h3>
					<fieldset>
						<div id="s4" class="qBox">
							<p>If you are the appellant and are completing this form yourself, you must tick the box below.</p>
							<p>If a fee is payable for my appeal, if I have not provided fee payment or payment card details, I undertake to pay the fee in accordance with the instructions I receive from the tribunal. I therefore apply for a Lord Chancellor's Certificate of Fee Satisfaction.</p>
							<span class="lCellTr"><html:checkbox property="s4_decalaration" styleId="s4_dec" value="Agreed" /></span><span class="rCellTl"><span class="bold">Declaration</span> &ndash; I, the appellant, believe the facts stated in this appeal form are true.</span>
						</div>
					</fieldset>
					<h3>Payment information</h3>
					<fieldset>
						<div class="qBox">
						<p><strong>No personal card details will be stored by HMCTS, your email address (optional) is required for PAYMENT only and is passed to the payment processor.</strong></p>
						<p>It is important to provide a valid email address if you require a receipt for this payment, without a valid email address a receipt cannot be issued.</p>
							<span class="lCellTl-noBold">Please enter your email address </span>
							<span class="rCellTl">
									<html:text property="email"  styleId="email_id" size="50" maxlength="100" />

							</span>
						</div>
					</fieldset>
					<div class="submitc">
						<html:hidden property="next" value="page-9"/>
						<html:hidden property="previous" value="page-7"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous5?page=7">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/10of10.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Save &amp; Next</html:submit>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
					</div>
				</html:form>
				<span class="bl"></span>
				<span class="br"></span>
			</div>
		</div>
	</div>
</div>
