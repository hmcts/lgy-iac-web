<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 7 of 10</h2>
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

				<html:form action="submission5">
					<fieldset>
						<h3>Section 3 &ndash; Your Appeal</h3>
						<h4>Non-Asylum Decision</h4>
						<div class="qBox">
							<p class="question">8.&nbsp;If your appeal relates to a non-asylum decision with which you disagree, you must give your reasons below and refer to the paragraphs of the refusal letter.</p>
							<div class="tBox"><html:textarea property="s3d_8" styleId="s3d8" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left: <span id="s3d8_counter"></span>&nbsp;of 3000</p>
							<script type="text/javascript"> $('#s3d8').CharsLeftCounter('s3d8_counter', 3000);</script>
						</div>

						<div class="qBox">
							<p id="s3_subheading3"><span class="bold">Statement of additional grounds</span></p>
							<p>If your notice of decision requires you to make a <strong>Statement of additional grounds</strong>, you should make the statement in this box.  If there are any other reasons why you think:</p>
							<ul>
								<li>you should be allowed to stay in the United Kingdom, including any reasons relating to the European Convention on Human Rights</li>
     							<li> you should not be required to leave.</li>
							</ul>
							<p>Do not repeat any grounds and reasons that you have already given in Section 3D.</p>
							<div class="tBox"><html:textarea property="s3d_additional" styleId="s3d8_additional" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left: <span id="s3d8_additional_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript">$('#s3d8_additional').CharsLeftCounter('s3d8_additional_counter', 2000);</script>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-8"/>
						<html:hidden property="previous" value="page-6"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous5?page=6">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/07of10.gif" alt="*" />
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
