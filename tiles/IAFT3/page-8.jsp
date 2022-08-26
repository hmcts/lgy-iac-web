<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 8 of 10</h2>
			<div align="right"><h3>Your reference: IAFT3-<bean:write name="token" scope="session"/></h3></div>
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

				<p class="question"><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>

				<h3>Section 3 &ndash; Your Appeal</h3>
				<html:form action="submission3.do">
					<fieldset>
						<div class="qBox">
							<span class="lCellTl">E.&nbsp;Have you appealed against any other immigration decision in the United Kingdom or overseas? <span class="required">*</span></span>
							<span class="rCellTl">
								No&nbsp;<html:radio property="s3e" styleId="s3e_no" value="No" />
								Yes&nbsp;<html:radio property="s3e" styleId="s3e_yes" value="Yes" />
							</span>

							<div id="other_appeal">
								<p class="bold">give details below:</p>
								<span class="lCellTr">
									Date&nbsp;
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
									Appeal number (if known)&nbsp;		<html:text property="s3e_appealno1"  size="30" maxlength="250" ></html:text>
								
								</span>

								<span class="lCellTr">
									Date&nbsp;
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
									Appeal number (if known)&nbsp;		<html:text property="s3e_appealno2"  size="30" maxlength="250" ></html:text>
								
								</span>
	
								<span class="lCellTr">
									Date&nbsp;
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
									Appeal number (if known)&nbsp;
									
									<html:text property="s3e_appealno3"  size="30" maxlength="250" ></html:text>
									
								</span>
							</div>
						</div>

						<html:hidden property="next" value="page-9"/>
						<html:hidden property="previous" value="page-7"/>
					</fieldset>

					<div class="submitc">
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="previous3.do?page=7">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/08of10.gif" alt="*" />
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