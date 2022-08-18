<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 5 of 10</h2>
			<div align="right"><h3>Your reference : IAFT5-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision</h3>

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

				<html:form action="submission5">
					<fieldset>
						<div class="qBox">
							<p class="question"><strong>D. Grounds of your appeal</strong></p>
							<p>You <span class="bold">must</span>:</p>
							<ul>
								<li>Let us know the reasons you disagree with the decision on the Notice of Decision document.</li>
								<li>Include any information that has not been mentioned in the Notice of Decision and say whether you have raised these issues before.</li>
								<li>Give as much detail as possible and should raise all the grounds of appeal you wish to rely on. The Tribunal is not permitted to consider grounds that you raise which have not been the subject of a decision by the Home Office unless the Home
Office agrees to the Tribunal considering those new grounds.</li><br/>

<li>If your appeal relates in whole or in part to a refusal of a <strong>Protection claim</strong>, complete <strong>boxes 1 and/or 2 </strong>that apply to you.</li>
<li>If your appeal relates only to the refusal of a <strong>Human Rights claim</strong>, complete <strong>box 3</strong>.</li>
<li>If your appeal relates only to a <strong>Revocation of Protection Status Decision</strong>, complete all of <strong>boxes 4 and 5</strong> that apply to you.</li>
<li>If your appeal relates in whole or in part to an <strong>EEA Decision</strong>, complete <strong>box 6</strong>.</li>
<li>if your appeal relates to an EU settlement scheme decision, EUSS family permit and travel permit, a frontier worker decision or a healthcare visitor decision or if you believe the decision breaches the withdrawal agreement, EFTA separation agreement or Swiss citizens' rights agreement complete box 6</li>

<li>If you are not sure which boxes apply to you or if your appeal is against the
<strong>Deprivation of Citizenship</strong> write your grounds in <strong>box 7</strong>.</li>
						</div>

						<div class="qBox">
								<p><span class="bold">Protection Decision</span></p>
							<p class="question"><strong>1.</strong>&nbsp;Please explain why your removal from the United Kingdom would breach the United Kingdom's obligations under the Refugee Convention.</p>
							<div class="tBox"><html:textarea property="s3d_1" styleId="s3d1" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d1_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d1').CharsLeftCounter('s3d1_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>2.</strong>&nbsp;Please explain why your removal from the United Kingdom would breach the United Kingdom's obligations in relation to persons eligible for a grant of humanitarian protection.</p>
							<div class="tBox"><html:textarea property="s3d_2" styleId="s3d2" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d2_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d2').CharsLeftCounter('s3d2_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p><span class="bold">Human Rights Decision</span></p>
							<p class="question"><strong>3.</strong>&nbsp;Please explain why the decision to refuse your human rights claim is unlawful under section 6 of the Human Rights Act 1998. You should specify which article of the Human Rights Act you are appealing under.</p>
							<div class="tBox"><html:textarea property="s3d_3" styleId="s3d3" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d3_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d3').CharsLeftCounter('s3d3_counter', 2000);</script>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-6"/>
						<html:hidden property="previous" value="page-4"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous5?page=4">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/05of10.gif" alt="*" />
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
