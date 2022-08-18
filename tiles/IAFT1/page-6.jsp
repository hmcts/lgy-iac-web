<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 6 of 10</h2>
			<div align="right"><h3>Your reference : IAFT1-<bean:write name="token" scope="session"/></h3></div>
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

				<html:form action="submission">
					<fieldset>
						<div class="qBox">
							<p class="question"><strong>4.</strong>&nbsp;If the Home Office has stated that you do not qualify as a refugee on grounds of race, religion, nationality, membership of a particular social group or political opinion (<span class="bold">under the criteria of the 1951 Geneva Convention</span>), and you disagree, please explain why in this box.</p>
							<div class="tBox"><html:textarea property="s3d_4" styleId="s3d4" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d4_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d4').CharsLeftCounter('s3d4_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>5.</strong>&nbsp;If the Home Office has stated that specific articles of the <span class="bold">European Convention on Human Rights</span> (ECHR) do not apply to your case, and you disagree, please explain why in this box.</p>
							<div class="tBox"><html:textarea property="s3d_5" styleId="s3d5" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d5_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d5').CharsLeftCounter('s3d5_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>6.</strong>&nbsp;If the Home Office has stated that you do not qualify as a person who is eligible for humanitarian protection (under the Refugee or Person in Need of International Protection Regulations 2006), and you disagree, please explain why in this box.</p>
							<div class="tBox"><html:textarea property="s3d_6" styleId="s3d6" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d6_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d6').CharsLeftCounter('s3d6_counter', 2000);</script>
						</div>

						<div class="qBox">
							<p class="question"><strong>7.</strong>&nbsp;If there is anything else that you disagree with in the Home Office letter, please explain why in this box.</p>
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
							<a href="previous?page=5">Previous <span class="access">page</span></a>
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
