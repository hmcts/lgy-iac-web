<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<div id="Content">
	<div class="holder">
		<!-- InstanceBeginEditable name="main" -->

		<div class="steps">
			<h2>Step 1 of 10</h2>
			<div align="right"><h3>Security Token : IAFT1-<bean:write name="token" scope="session"/> </h3> </div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an in country [Asylum/Non asylum] decision</h3>

			<logic:present name="errMsg" scope="request">
				<strong>Please correct following:</strong>
				<font color="red"><Strong><bean:write name="errMsg" filter="false"/></Strong></font>
			</logic:present>

			<div class="formcon">
				<div class="edit"></div>
				</div>

				<html:form action="paymentsubmission">

					<p>Please enter the payment reference number printed on the letter you have received.Please enter the payment reference number as it is written on the request we have sent you. If you are making a payment that covers more than one request you must enter each payment reference number separately in the boxes below.</p>
					<div class="row">
						<label for="qc-appeal.number0">1.Payment reference number</label>
						<html:text property="prn1" styleId="qc-appeal-number0" size="40" maxlength="70" />
					</div>


					<div id="topup1">
						<div class="row">
							<label for="qc-appeal-number1">2. Payment reference number</label>
							<html:text property="prn2" styleId="qc-appeal-number1" size="40" maxlength="70" />
							<span class="topup">
								<a href="#" onclick="$('#topup2').show();"><img src="justice/images/arrow-down-blue.gif"  property="family_member" />Another person?</a>
							</span>
						</div>
					</div>

					<div id="topup2">
						<div class="row">
							<label for="qc-appeal-number2">3. Payment reference number</label>
							<html:text property="prn3" styleId="qc-appeal-number2" size="40" maxlength="70" />
							<span class="topup">
								<a href="#" onclick="$('#topup3').show();"><img src="justice/images/arrow-down-blue.gif"  property="family_member" />Another person?</a>
							</span>
						</div>
					</div>

					<div id="topup3">
						<div class="row">
							<label for="qc-appeal-number3">4. Payment reference number</label>
							<html:text property="prn4" styleId="qc-appeal-number3" size="40" maxlength="70" />
							<span class="topup">
								<a href="#" onclick="$('#topup4').show();"><img src="justice/images/arrow-down-blue.gif"  property="family_member" />Another person?</a>
							</span>
						</div>
					</div>

					<div id="topup4">
						<div class="row">
							<label for="qc-appeal-number4">5. Payment reference number</label>
							<html:text property="prn5" styleId="qc-appeal-number4" size="40" maxlength="70" />
						</div>
					</div>

					<div class="submitc">
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="index.jsp">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>

						<html:hidden property="next" value="page-2"/>
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
		<!-- InstanceEndEditable -->
	</div>
</div>
