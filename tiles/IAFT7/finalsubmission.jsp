<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<div align="right">
				<logic:present name="oid"><h3>Reference for correspondence: <bean:write name="oid" scope="request"/></h3></logic:present>
			</div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision</h3>


			<div class="formcon">

				<div class="edit"></div>
				<p>Your appeal(s) have been successfully submitted and paid for.</p>
				<p>Please make a note of the payment information below and keep for your records.
				</p><p>You can expect to receive notification of receipt of your appeal in 10 days if you are appealing from within the UK or 28 days
					if you are appealing from overseas.</p>
				<p>If you need to contact the Tribunal you can do so via e mail at <a href="mailto:Customer.Service@hmcts.gsi.gov.uk">Customer.Service@hmcts.gsi.gov.uk </a></p>

				<p><strong>VERY IMPORTANT</strong></p>
					<p>You must now send your <strong>Notice of Decision and all other evidence</strong>, which is available to you now, to the Tribunal without delay. Where you have noted in your appeal that you have documents which are not yet available, you should send these as soon as possible. Any delay in sending the tribunal your evidence will delay the Tribunal processing and deciding your appeal.</p>

					<p>Please print a cover sheet to send with your appeal documentation.</p>


					<logic:present name="oid" scope="request">
								<html:form action="coversheet">
									<div class="button">
									<html:hidden property="exemption" value='<%=request.getAttribute("oid").toString()%>'/>
										<span class="tl"></span>
										<span class="tr"><span></span></span>
										<html:submit>Cover Sheet</html:submit>
										<span class="bl"></span>
										<span class="br"></span>
									</div>
						       </html:form>
					</logic:present>

					<p>Attaching this sheet to the documents which you are sending to the tribunal will help the tribunal link these to your appeal. Please complete details of your Home Office/Post reference number, your name (as it appears on your refusal decision) and your date of birth. Please also note on the cover sheet details of any other appeals which you have submitted and which you would want linked to yours.</p>
					<p>Important: Where you have submitted more than one appeal, please print a separate cover sheet for each appeal and attach to the documents for that appeal.</p>

					<p><strong>You need to clearly mark all documents with your Reference for correspondence, your name and date of birth, so that the Tribunal can match these documents to your appeal. [If your submission number is not available, you should use the post reference number on your notice of decision].</strong></p>
					<p>You should send all documents to:</p>
					<p class="centered">
						First-tier Tribunal (Immigration and Asylum Chamber)<br />
						PO Box 6987<br />
						Leicester<br />
						United Kingdom<br />
						LE1 6ZX
					</p>
					<p>Further information regarding the appeal process can be found on <a href="http://www.justice.gov.uk/" target="_blank">www.justice.gov.uk</a> and on the guidance notes accompanying the appeal form.</p>
                    <p>Please click on the link below and take a few minutes to complete a short survey</p>
                    <p><a href="https://www.surveymonkey.com/s/IAC11" target="_blank">https://www.surveymonkey.com/s/IAC11</a></p>
					<div class="submitc">
						<html:hidden property="next" value="page-2" />
						<img style="margin-left:12%;" id="progress" src="images/progress/100-percent.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="http://www.justice.gov.uk/guidance/courts-and-tribunals/tribunals/immigration-and-asylum/first-tier/index.htm" >Finish</a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
					</div>

				<span class="bl"></span>
				<span class="br"></span>
			</div>
		</div>
	</div>
</div>
