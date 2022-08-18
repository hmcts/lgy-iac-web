<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>

			<div class="formcon">

				<div class="edit"></div>

				<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">Please correct following:</span>
							<div id="fields"><bean:write name="errMsg" filter="false"/></div>
						</div>
					</div>
				</logic:present>

				<html:form action="paymentsubmission">
					<fieldset>
						<div class="qBox">
							<p>Please enter the payment reference number printed on the letter you have received.Please enter the payment reference number as it is written on the request we have sent you. If you are making a payment that covers more than one request you must enter each payment reference number separately in the boxes below.</p>

							<span class="lCellTr">1.Payment reference number</span>
							<span class="rCellTl"><html:text property="prn1" styleId="qc-appeal-number0" size="40" maxlength="70" /></span>
						</div>



						<div class="qBox" id="topup1">
							<span class="lCellTr">2. Payment reference number</span>
							<span class="rCellTl"><html:text property="prn2" styleId="qc-appeal-number1" size="40" maxlength="70" /></span>
						</div>

						<div class="qBox" id="topup2">
							<span class="lCellTr">3. Payment reference number</span>
							<span class="rCellTl"><html:text property="prn3" styleId="qc-appeal-number2" size="40" maxlength="70" /></span>
						</div>

						<div class="qBox" id="topup3">
							<span class="lCellTr">4. Payment reference number</span>
							<span class="rCellTl"><html:text property="prn4" styleId="qc-appeal-number3" size="40" maxlength="70" /></span>
						</div>

						<div class="qBox" id="topup4">
							<span class="lCellTr">5. Payment reference number</span>
							<span class="rCellTl"><html:text property="prn5" styleId="qc-appeal-number4" size="40" maxlength="70" /></span>
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
						<html:hidden property="next" value="page-2" />
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="index.jsp">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Next</html:submit>
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
