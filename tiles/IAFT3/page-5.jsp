<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 5 of 10</h2>
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
							<p class="question">D. Grounds of your appeal</p>
							<p>You <span class="bold">must</span>:</p>
							<ul>
								<li>Let us know the reasons you disagree with the decision on the Notice of Decision document.</li>
								<li>Include any information that has not been mentioned in the Notice of Decision and say whether you have raised these issues before.</li>
								<li>You must give as much detail as possible as you may not be allowed to mention any further grounds at a later date. You should send any additional evidence to the tribunal as soon as possible</li>
							</ul>
							<p>If your appeal relates in whole or in part to an <span class="bold">Asylum decision</span>, complete <span class="bold">boxes 1 to 6</span> as applicable. You should also complete box 7 if you are not sure which boxes apply to you or there are other points in the refusal letter that you disagree with. If your appeal relates to a <span class="bold">immigration</span> decision complete <span class="bold">box 8</span>.</p>
							<p><span class="bold">You should send any additional evidence to the tribunal as soon as possible.</span></p>
							<p><span class="bold">Asylum Decision</span></p>
						</div>

						<div class="qBox">
							<p class="question"><strong>1.</strong>&nbsp;If you disagree with the Home Office's interpretation of <span class="bold">the situation in your country</span>, please explain why in this box, and give reasons to support your point of view.</p>
							<div class="tBox"><html:textarea property="s3d_1" styleId="s3d1" cols="107" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d1_counter"></span>&nbsp;of 8000</p>
							<script type="text/javascript">$('#s3d1').CharsLeftCounter('s3d1_counter', 8000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>2.</strong>&nbsp;If the Home Office has stated that you could <span class="bold">live safely in another part of the country of origin</span>, and you disagree, please explain why in this box.</p>
							<div class="tBox"><html:textarea property="s3d_2" styleId="s3d2" cols="107" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d2_counter"></span>&nbsp;of 8000</p>
							<script type="text/javascript">$('#s3d2').CharsLeftCounter('s3d2_counter', 8000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>3.</strong>&nbsp;If the Home Office has stated that your claim is <span class="bold">not credible</span>, and you disagree, please explain why in this box.</p>
							<div class="tBox"><html:textarea property="s3d_3" styleId="s3d3" cols="107" rows="15" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d3_counter"></span>&nbsp;of 8000</p>
							<script type="text/javascript">$('#s3d3').CharsLeftCounter('s3d3_counter', 8000);</script>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-6"/>
						<html:hidden property="previous" value="page-4"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous3?page=4">Previous <span class="access">page</span></a>
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
