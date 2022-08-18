<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 6 of 10</h2>
			<div align="right"><h3>Your reference : IAFT7-<bean:write name="token" scope="session"/></h3></div>
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

				<html:form action="submission7.do">
					<fieldset>
						<div class="qBox">
							<p><span class="bold">Revocation of Protection Status Decision</span></p>
							<p class="question"><strong>4.</strong> Please explain why the decision to revoke your protection status breaches the United Kingdom's obligations under the Refugee Convention.</p>
							<div class="tBox"><html:textarea property="s3d_4" styleId="s3d4" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d4_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d4').CharsLeftCounter('s3d4_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>5.</strong> Please explain why the decision to revoke your protection status breaches the United Kingdom's obligations in relation to persons eligible for humanitarian protection.</p>
							<div class="tBox"><html:textarea property="s3d_5" styleId="s3d5" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d5_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d5').CharsLeftCounter('s3d5_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p><span class="bold">EEA Decision</span></p>
							<p class="question"><strong>6.</strong> If you feel that the Home Office decision is restricting your rights under the EEA right to free movement, please explain why</p>
							<div class="tBox"><html:textarea property="s3d_6" styleId="s3d6" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d6_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d6').CharsLeftCounter('s3d6_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p><span class="bold">Deprivation of Citizenship Decision</span></p>
							<p class="question"><strong>7.</strong> If you are unsure which box to complete or if your appeal is against the deprivation of citizenship please provide details in this box.</p>
							<div class="tBox"><html:textarea property="s3d_7" styleId="s3d7" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d7_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d7').CharsLeftCounter('s3d7_counter', 2000);</script>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-7"/>
						<html:hidden property="previous" value="page-5"/>
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous7.do?page=5">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/06of10.gif" alt="*" />
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