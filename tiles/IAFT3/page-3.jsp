<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 3 of 10</h2>
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

				<h3>Section 2 &ndash; Your Home Office Decision (refer to your Notice of Decision)</h3>
				<p><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>
				<html:form action="submission3">
					<fieldset>
						<div id="s2a" class="qBox">
							<span class="lCellTl">A.&nbsp;Home Office Reference Number</span>
							<span class="rCellTl"><html:text property="s2a" styleId="s2a_homeoffice" size="16" maxlength="16" /></span>
						</div>

						<div id="s2b" class="qBox">
							<span class="lCellTl">B.&nbsp;Port Reference</span>
							<span class="rCellTl"><html:text property="s2b" styleId="s2b_portref" size="15" maxlength="15" /></span>
						</div>

						<div id="s2c" class="qBox">
							<span class="lCellTl">C.&nbsp;Case Outcome ID</span>
							<span class="rCellTl"><html:text property="s2c" styleId="s2c_cohid" size="20" maxlength="20" /></span>
						</div>

						<div id="s2d" class="qBox">
							<span class="lCellTl">D.&nbsp;Method of service by UKBA.</span>
							<span class="rCellTl">
								Post&nbsp;<html:radio property="s2d" styleId="s2d_post" value="Post" />
								Fax/Personal Service&nbsp;<html:radio property="s2d" styleId="s2d_fax" value="Fax" />
								Courier&nbsp;<html:radio property="s2d" styleId="s2d_courier" value="Courier" />
								Other&nbsp;<html:radio property="s2d" styleId="s2d_other" value="Other" />
							</span>
							<span class="lCellTr">(Please specify other)</span>
							<span class="rCellTl"><html:text property="s2d_other" styleId="s2d_other" size="50" maxlength="50" /></span>
						</div>

						<div id="s1e" class="qBox">
							<span class="lCellTl">E.&nbsp;Date you left the UK following Refusal Decision<span class="required">*</span></span>
							<span class="rCellTl">
								<html:select property="s2g_service_day" styleId="s2e">
									<html:option value="0">Day</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
									<html:option value="13">13</html:option>
									<html:option value="14">14</html:option>
									<html:option value="15">15</html:option>
									<html:option value="16">16</html:option>
									<html:option value="17">17</html:option>
									<html:option value="18">18</html:option>
									<html:option value="19">19</html:option>
									<html:option value="20">20</html:option>
									<html:option value="21">21</html:option>
									<html:option value="22">22</html:option>
									<html:option value="23">23</html:option>
									<html:option value="24">24</html:option>
									<html:option value="25">25</html:option>
									<html:option value="26">26</html:option>
									<html:option value="27">27</html:option>
									<html:option value="28">28</html:option>
									<html:option value="29">29</html:option>
									<html:option value="30">30</html:option>
									<html:option value="31">31</html:option>
								</html:select>
								 /
								<html:select property="s2g_service_month">
									<html:option value="0">Month</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
								</html:select>
								 /

								<html:select property="s2g_service_year">
									<html:optionsCollection  name="TenYearsBack"	value="yearvalue" label="yearlable" />
								</html:select>
							</span>
						</div>

						<div id="s1f" class="qBox">
							<span class="lCellTl">F.&nbsp;Date of Refusal Decision<span class="required">*</span><br />(the date of the decision against which you are appealing)</span>
							<span class="rCellTl">
								<html:select property="s2e_service_day">
									<html:option value="0">Day</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
									<html:option value="13">13</html:option>
									<html:option value="14">14</html:option>
									<html:option value="15">15</html:option>
									<html:option value="16">16</html:option>
									<html:option value="17">17</html:option>
									<html:option value="18">18</html:option>
									<html:option value="19">19</html:option>
									<html:option value="20">20</html:option>
									<html:option value="21">21</html:option>
									<html:option value="22">22</html:option>
									<html:option value="23">23</html:option>
									<html:option value="24">24</html:option>
									<html:option value="25">25</html:option>
									<html:option value="26">26</html:option>
									<html:option value="27">27</html:option>
									<html:option value="28">28</html:option>
									<html:option value="29">29</html:option>
									<html:option value="30">30</html:option>
									<html:option value="31">31</html:option>
								</html:select>
								 /
								<html:select property="s2e_service_month">
									<html:option value="0">Month</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
								</html:select>
								 /
								<html:select property="s2e_service_year">
									<html:optionsCollection   name="TwoYearsBack" value="yearvalue" label="yearlable"  />
								</html:select>
							</span>
						</div>

						<div id="s1g" class="qBox">
							<span class="lCellTl">G.&nbsp;Date you received your Notice of Decision<span class="required">*</span></span>
							<span class="rCellTl">
								<html:select property="s2i_service_day">
									<html:option value="0">Day</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
									<html:option value="13">13</html:option>
									<html:option value="14">14</html:option>
									<html:option value="15">15</html:option>
									<html:option value="16">16</html:option>
									<html:option value="17">17</html:option>
									<html:option value="18">18</html:option>
									<html:option value="19">19</html:option>
									<html:option value="20">20</html:option>
									<html:option value="21">21</html:option>
									<html:option value="22">22</html:option>
									<html:option value="23">23</html:option>
									<html:option value="24">24</html:option>
									<html:option value="25">25</html:option>
									<html:option value="26">26</html:option>
									<html:option value="27">27</html:option>
									<html:option value="28">28</html:option>
									<html:option value="29">29</html:option>
									<html:option value="30">30</html:option>
									<html:option value="31">31</html:option>
								</html:select>
								 /
								<html:select property="s2i_service_month">
									<html:option value="0">Month</html:option>
									<html:option value="1">01</html:option>
									<html:option value="2">02</html:option>
									<html:option value="3">03</html:option>
									<html:option value="4">04</html:option>
									<html:option value="5">05</html:option>
									<html:option value="6">06</html:option>
									<html:option value="7">07</html:option>
									<html:option value="8">08</html:option>
									<html:option value="9">09</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
								</html:select>
								 /
								<html:select property="s2i_service_year">
									<html:optionsCollection   name="TwoYearsBack" value="yearvalue" label="yearlable"  />
								</html:select>
							</span>
						</div>

						<h4 id="subtitle_anonymity">Applying for Anonymity</h4>
						<div id="anonymity" class="qBox">
							<p>The tribunal will publish your name on documents relating to your case which can be viewed publicly. You can apply to the tribunal for anonymity which, when granted, will result in the tribunal removing your name from all published documents.</p>

							<p>
								The Application for Anonymity form can be found online at:<br />
								<a href="http://www.justice.gov.uk/guidance/courts-and-tribunals/tribunals/immigration-and-asylum/first-tier/faq.htm#FAQ21" target="_blank" title="Please note: this link will open in a new browser tab or window.">www.tribunals.gov.uk/ImmigrationAsylum/FormsGuidance/FormsGuidance.htm</a>
							</p>
						</div>

					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-4"/>
						<html:hidden property="previous" value="page-2"/>

						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous3?page=2">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/03of10.gif" alt="*" />
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
