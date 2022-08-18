<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 8 of 10</h2>
			<div align="right"><h3>Your reference : IAFT5-<bean:write name="token" scope="session"/></h3></div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
				<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision or EU Settlement Scheme Decision</h3>


			<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">This page is missing information.  Please correct following:</span>
							<div id="fields"><bean:write name="errMsg" filter="false"/></div>
						</div>
					</div>
			</logic:present>

			<div class="formcon">
				<div class="edit"></div>

				<h3>Section 3 &ndash; Your Appeal</h3>
				<p><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>
				<html:form action="submission5">
					<fieldset>
						<div class="qBox">
						    <p><span class="bold">E. New Matters</span></p>
							<p class="question">Please describe in this box any new reasons for:</p>
							<ul>
<li> wishing to enter or remain in the UK, or</li>
<li> grounds on which you should be permitted to enter or remain in the UK, or</li>
<li> grounds on which you should not be removed from or required to leave the UK provided that you have already informed the Home Office about these reasons in response to a notice served on you in terms of section 120 of the Nationality, Immigration and Asylum Act 2002</li>
 </ul>
							<div class="tBox"><html:textarea property="s3g" styleId="s3g" cols="118" rows="17" /></div>
							<p class="charCounter">Characters left: <span id="s3d8_counter"></span>&nbsp;of 2000</p>
							<script type="text/javascript"> $('#s3g').CharsLeftCounter('s3d8_counter', 2000);</script>
						</div>
						<div class="qBox">
							<span class="lCellTl">F.&nbsp;Have you appealed against any other immigration decision in the United Kingdom or overseas? <span class="required">*</span></span>
							<span class="rCellTl">
								No&nbsp;<html:radio property="s3e" styleId="s3e_no" value="No" />
								Yes&nbsp;<html:radio property="s3e" styleId="s3e_yes" value="Yes" />
							</span>

							<div id="your_other_appeal">
								<p class="note">give details below: <span class="required">*</span></p>
								<span id="s3e-prevappeal0" class="lCellTr">
									Date
									<html:select property="s3e_date1_day" styleId="s3e_day1">
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
									<html:select property="s3e_date1_month" styleId="s3e_month1">
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
									<html:select property="s3e_date1_year" styleId="s3e_year1">
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
									Appeal number (if known)
									<html:text property="s3e_appealno1" styleId="s3e_appealNo1" size="30" maxlength="250" />
								</span>

								<span id="s3e_prevappeal1" class="lCellTr">
									Date
									<html:select property="s3e_date2_day" styleId="s3e_day2">
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
									<html:select property="s3e_date2_month" styleId="s3e_month2">
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
									<html:select property="s3e_date2_year" styleId="s3e_year2">
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
									Appeal number (if known)
									<html:text property="s3e_appealno2" styleId="s3e_appealNo2" size="30" maxlength="250" />
								</span>

								<span id="s3e_prevappeal2" class="lCellTr">
									Date
									<html:select property="s3e_date3_day" styleId="s3e_day3">
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
									<html:select property="s3e_date3_month" styleId="s3e_month3">
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
									<html:select property="s3e_date3_year" styleId="s3e_year3">
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
									Appeal number (if known)
									<html:text property="s3e_appealno3" styleId="s3e_appealNo3" size="30" maxlength="250" />
								</span>
							</div>
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
						<img id="progress" src="images/progress/08of10.gif" alt="*" />
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
