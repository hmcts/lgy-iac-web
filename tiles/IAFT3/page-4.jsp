<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 4 of 10</h2>
			<div align="right"><h3>Your reference : IAFT3-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>

			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against your Home Office <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision</h3>

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

				<h3>Section 3 &ndash; Your Appeal</h3>
				<html:form action="submission3">
					<fieldset>
						<div class="qBox">

							<p>Your appeal must be received at the <strong>Tribunal</strong> not later than <strong>28 Calendar days</strong> after;</p>

							<ul>
								<li>The date of your departure from the United Kingdom when your right of appeal can only be exercised after you have left the United Kingdom; or in all other cases;</li>
								<li>The date you received the notice of decision from the Home Office</li>
							</ul>

							<p class="question"><strong>A.</strong>&nbsp;If you know your appeal is late, or you are not sure if it will be received in time, you must apply for an extension of time. Explain why your appeal is late in the box below.</p>
							<div class="tBox"><html:textarea property="s3a" styleId="s3a" cols="118" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3a_counter"></span>&nbsp;of 1000</p>
							<script type="text/javascript">$('#s3a').CharsLeftCounter('s3a_counter', 1000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>B.</strong>&nbsp;If you are sending any other documents with this form to support your appeal, they must be in English or a certified translation. Please list them here:</p>
							<div class="tBox"><html:textarea property="s3b" styleId="s3b" cols="118" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3b_counter"></span>&nbsp;of 1000</p>
							<script type="text/javascript">$('#s3b').CharsLeftCounter('s3b_counter', 1000);	</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>C.</strong>&nbsp;If you are <span class="bold">intending</span> to send other documents that are not yet available to you. Please list them here:</p>
							<div class="tBox"><html:textarea property="s3c" styleId="s3c" cols="118" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3c_counter"></span>&nbsp;of 1000</p>
							<script type="text/javascript">$('#s3c').CharsLeftCounter('s3c_counter', 1000);</script>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-5"/>
						<html:hidden property="previous" value="page-3"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous3?page=3">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/04of10.gif" alt="*" />
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
