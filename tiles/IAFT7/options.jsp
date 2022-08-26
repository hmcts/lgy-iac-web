<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<div id="Content">
			<div class="holder">
				<!-- InstanceBeginEditable name="main" -->
				<div id="screening">
					What would you like to do?&nbsp;
					<div class="button">
						<a href="newlodgement.do?next=new">Submit another appeal</a>
					</div>
					&nbsp;
				<!-- 	<logic:equal value="0" scope="session" name="aggramount">
						<div class="button">
							<a href="pdfreturn.do">Finish Submission</a>
						</div>
						&nbsp;
					</logic:equal>
					<logic:notEqual value="0" scope="session" name="aggramount">
						<div class="button">
							<a href="paymentsubmission.do">Pay for the appeal(s) just completed</a>
						</div>
						&nbsp;
					</logic:notEqual>
				 -->
				      <div class="button">
							<a href="paymentsubmission.do">Proceed</a>
						</div>
						&nbsp;
				 	<br/>
					<br/>
					<p>You can print off a copy of the form you have just submitted. Please note that if you are making several appeals, you need to print each form as you complete it.</p>
					<div class="button">
						<a href="printPDF.do" target="_blank">Print a copy of the appeal before you pay for it</a>
					</div>
					<br/><br/>
					<p><strong>Please note</strong> that you are printing a copy of your appeal for your own records - clicking this button will not submit your appeal. Your appeal will not be submitted until you have paid for it by clicking the 'Pay for the appeal(s) just completed button' above.  When your payment has been approved, you will received confirmation that your appeal has been submitted. If your payment is declined, you will be provided with further instructions on this website. If your appeal does not require a payment you can click the 'Finish submission' above to submit your appeal to the tribunal.</p>
					<p>Please click on the link below and take a few minutes to complete a short survey</p>
					<p>
						<a href="https://www.surveymonkey.com/s/IAC11" target="_blank">https://www.surveymonkey.com/s/IAC11</a>
					</p>
				</div>
				<!-- InstanceEndEditable -->
			</div>
		</div>
