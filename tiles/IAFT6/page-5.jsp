<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 5 of 8</h2>
			<div align="right"><h3>Your reference: IAFT6-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal To The First&ndash;Tier Tribunal (Immigration And Asylum Chamber) Against A Decision Of An Entry Clearance Officer</h3>

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

				<p class="question"><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>

				<h3>Section 3 &ndash; Your Appeal</h3>
				<html:form action="submission6">
					<fieldset>
						<div id="s3d" class="qBox">
							<p class="question"><strong>D.&nbsp;Grounds of your appeal <span class="required">*</span></strong></p>
							<span class="note">You may appeal only if:</span>



<ul>
        <li>you have made a human rights claim and this has been refused,</li>

        <li>your appeal is against the deprivation of citizenship,</li>

                    <li>you think that the Home Office decision is restricting your rights under the EEA right to free movement please explain below why you want to appeal.</li>
                    <li>
                    	your appeal relates to an EU Settlement Scheme decision,  EUSS family permit  and travel permit, a frontier worker decision or a healthcare visitor decision or if you believe the decision breaches the withdrawal agreement, EFTA separation agreement or Swiss citizens' rights agreement please explain why below. </li>



      </ul>

        <span class="note">You must bring your appeal on the grounds that:</span>

							    <ul>
								<li>the decision against which you seek to appeal is unlawful under section 6 of the Human Right Act 1998 or </li>
								<li> that the decision breaches your rights under the European Union treaties in respect of entry to or residence in the United Kingdom or if it breaches the EU withdrawal agreement, EFTA separation agreement or Swiss citizens' rights agreements</li>
								<li>the decision against which you seek to appeal has stated that specific articles of the European Convention on Human Rights (ECHR) do not apply to your case, and you disagree, please explain why.</li>

							</ul>
							<logic:equal name="frmHeader" value="Human Rights">
							<p class="question"><strong>Human Rights Decision</strong></p>
							<p>Please explain which article of the Human rights Act you are appealing under and give reasons to support your claim.</p>
							</logic:equal>
							<logic:equal name="frmHeader" value="EEA">
							<p class="question"><strong>EEA, EU Settlement Scheme, Frontier Worker and Healthcare decision</strong></p>
							<p>If you believe that the Home Office decision is restricting your rights under the EEA right to free movement please explain why.</p><p>If you believe the EU settlement scheme decision, EUSS family permit and travel permit, frontier worker decision or healthcare visitor decision was not in accordance with the relevant legislation/immigration rules please say why or
if you believe the decision breaches the withdrawal agreement, EFTA separation agreement or Swiss citizens' rights agreement then please say why
</p>

							</logic:equal>
							<div class="tBox"><html:textarea styleId="s3d_grounds" property="s3d_1" cols="118" rows="17"></html:textarea></div>
							<p class="charCounter">Characters left:&nbsp;<span id="s3d1_counter"></span>&nbsp;of 4000</p>
							<script type="text/javascript">$('#s3d_grounds').CharsLeftCounter('s3d1_counter', 4000);</script>
						</div>

						<div class="qBox">
							<span class="lCellTl">E.&nbsp;Have you appealed against any other immigration decision in the United Kingdom or overseas? <span class="required">*</span></span>
							<span class="rCellTl">
								No&nbsp;<html:radio styleId="s3e_no" property="s3e" value="No" />
								Yes&nbsp;<html:radio styleId="s3e_yes" property="s3e" value="Yes" />
							</span>

							<div id="other_appeal">
								<p class="bold">Give details below:</p>
								<span class="lCellTr">
									Date
									<html:select property="s3e_date1_day">
										<html:option value="0" >Day</html:option>
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
									<html:select property="s3e_date1_month">
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
									<html:select property="s3e_date1_year">
										<html:option value="0" >Year</html:option>
										<html:option value ="2000">2000</html:option>
										<html:option value ="2001">2001</html:option>
										<html:option value ="2002">2002</html:option>
										<html:option value ="2003">2003</html:option>
										<html:option value ="2004">2004</html:option>
										<html:option value ="2005">2005</html:option>
										<html:option value ="2006">2006</html:option>
										<html:option value ="2007">2007</html:option>
										<html:option value ="2008">2008</html:option>
										<html:option value ="2009">2009</html:option>
										<html:option value ="2010">2010</html:option>
										<html:option value ="2011">2011</html:option>
										<html:option value ="2012">2012</html:option>
										<html:option value ="2013">2013</html:option>
										<html:option value ="2014">2014</html:option>
										<html:option value ="2015">2015</html:option>
										<html:option value ="2016">2016</html:option>
										<html:option value ="2017">2017</html:option>
										<html:option value ="2018">2018</html:option>
										<html:option value ="2019">2019</html:option>
										<html:option value ="2020">2020</html:option>
									</html:select>
								</span>
								<span class="rCellTl">
									Appeal number (if known)&nbsp;	<html:text  property="s3e_appealno1" styleId="s3e_appeal_ref1" size="30" maxlength="250" />
								</span>

								<span class="lCellTr">
									Date
									<html:select property="s3e_date2_day">
										<html:option value="0" >Day</html:option>
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
									<html:select property="s3e_date2_month">
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
									<html:select property="s3e_date2_year">
										<html:option value="0" >Year</html:option>
										<html:option value ="2000">2000</html:option>
										<html:option value ="2001">2001</html:option>
										<html:option value ="2002">2002</html:option>
										<html:option value ="2003">2003</html:option>
										<html:option value ="2004">2004</html:option>
										<html:option value ="2005">2005</html:option>
										<html:option value ="2006">2006</html:option>
										<html:option value ="2007">2007</html:option>
										<html:option value ="2008">2008</html:option>
										<html:option value ="2009">2009</html:option>
										<html:option value ="2010">2010</html:option>
										<html:option value ="2011">2011</html:option>
										<html:option value ="2012">2012</html:option>
										<html:option value ="2013">2013</html:option>
										<html:option value ="2014">2014</html:option>
										<html:option value ="2015">2015</html:option>
										<html:option value ="2016">2016</html:option>
										<html:option value ="2017">2017</html:option>
										<html:option value ="2018">2018</html:option>
										<html:option value ="2019">2019</html:option>
										<html:option value ="2020">2020</html:option>
									</html:select>
								</span>
								<span class="rCellTl">
									Appeal number (if known)&nbsp;	<html:text  property="s3e_appealno2" styleId="s3e_appeal_ref2" size="30" maxlength="250" />
								</span>

								<span class="lCellTr">
									Date
									<html:select property="s3e_date3_day">
										<html:option value="0" >Day</html:option>
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
									<html:select property="s3e_date3_month">
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
									<html:select property="s3e_date3_year">
										<html:option value="0" >Year</html:option>
										<html:option value ="2000">2000</html:option>
										<html:option value ="2001">2001</html:option>
										<html:option value ="2002">2002</html:option>
										<html:option value ="2003">2003</html:option>
										<html:option value ="2004">2004</html:option>
										<html:option value ="2005">2005</html:option>
										<html:option value ="2006">2006</html:option>
										<html:option value ="2007">2007</html:option>
										<html:option value ="2008">2008</html:option>
										<html:option value ="2009">2009</html:option>
										<html:option value ="2010">2010</html:option>
										<html:option value ="2011">2011</html:option>
										<html:option value ="2012">2012</html:option>
										<html:option value ="2013">2013</html:option>
										<html:option value ="2014">2014</html:option>
										<html:option value ="2015">2015</html:option>
										<html:option value ="2016">2016</html:option>
										<html:option value ="2017">2017</html:option>
										<html:option value ="2018">2018</html:option>
										<html:option value ="2019">2019</html:option>
										<html:option value ="2020">2020</html:option>
									</html:select>
								</span>

								<span class="rCellTl">
									Appeal number (if known)&nbsp;<html:text  property="s3e_appealno3" styleId="s3e_appeal_ref3" size="30" maxlength="250" />
								</span>
							</div>
						</div>

						<div  id="s3f" class="qBox">
							<span class="lCellTl">F.&nbsp;Will anyone attending your hearing require an interpreter? <span class="bold">You should only request an interpreter if an individual who cannot speak English will be attending and giving evidence at your hearing.</span> </span>
							<span class="rCellTl">
								No&nbsp;<html:radio styleId="s3f_no" property="s3f"  value="No" />
								Yes&nbsp;<html:radio styleId="s3f_yes" property="s3f" value="Yes" />
							</span>

							<div id="s3f_interpreter">
								<p class="bold">Give details below:</p>
								<span class="lCellTr">Who:</span>
								<span class="rCellTl"><html:text  property="s3f_who" size="35" maxlength="70" /></span>
								<span class="lCellTr">Language:</span>
								<span class="rCellTl"><html:text  property="s3f_language" size="20" maxlength="20" /></span>
								<span class="lCellTr">Dialect:</span>
								<span class="rCellTl"><html:text styleId="s3f_dialect" property="s3f_dialect" size="20" maxlength="20" /></span>
							</div>
						</div>

						<div  id="s3g" class="qBox">
							<span class="lCellTl">G.&nbsp;If anyone attending the hearing has a disability, state any special requirements they have.</span>
							<div class="tBox"><html:textarea property="s3g" cols="118" rows="5"/></div>
						</div>

						<html:hidden property="next" value="page-6"/>
						<html:hidden property="previous" value="page-4"/>
					</fieldset>

					<div class="submitc">
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous6?page=4">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/05of08.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Save & Next</html:submit>
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
