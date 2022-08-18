<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 6 of 8</h2>
			<div align="right"><h3>Your reference: IAFT6-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal To The First&ndash;Tier Tribunal (Immigration And Asylum Chamber) Against A Decision Of An Entry Clearance Officer</h3>

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

		<p class="question"><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>

				<h3>Section 4 &ndash; Your declaration</h3>

				<html:form action="submission6">
					<fieldset>
						<div class="qBox">
							<span class="lCellTl-noBold">Do you have a representative ?<span class="required">*</span></span>
							<span class="rCellTl">
								<p>
									No&nbsp;<html:radio property="have_rep" value="No" styleId="rep_no" />
									Yes&nbsp;<html:radio property="have_rep" value="Yes"  styleId="rep_yes"  />
								</p>
							</span>
						</div>
							<div class="qBox">
							<span class="lCellTl-noBold">Do you have a sponsor ?<span class="required">*</span></span>
							<span class="rCellTl"><p>
								No&nbsp;<html:radio property="have_sponsor" value="No" styleId="spo_no" />
								Yes&nbsp;<html:radio property="have_sponsor" value="Yes"  styleId="spo_yes" /></p>
							</span>
						</div>



						<div  id="s4" class="qBox">
							<p>If you are the appellant and are completing this form yourself, you must sign and date this declaration.<span class="required">*</span></p>
							<p>
								<span class="bold">Declaration</span>&ndash; I, the appellant, believe the facts stated in this appeal form are true.
								<html:checkbox property="s4_decalaration" styleId="s4_decalaration" value="Agreed" />
							</p>
							<p>If a fee is payable for my appeal, if I have not provided fee payment or payment card details, I undertake to pay the fee in accordance with the instructions I receive from the tribunal. I therefore apply for a Lord Chancellor's Certificate of Fee Satisfaction.</p>
						</div>

						<h3>Data Protection statement</h3>
						<div  id="s4_dps" class="qBox">
							<p>Information, including personal details that you have provided in this form will not be used by the Visa Section, or First-tier Tribunal, for any purpose other than the determination of your application. The information may be disclosed to other government departments and public authorities only, for related immigration or asylum purposes</p>
						</div>

						<html:hidden property="next" value="page-7"/>
						<html:hidden property="previous" value="page-5"/>
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
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous6?page=5">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/06of08.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Save & Next</html:submit>
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
