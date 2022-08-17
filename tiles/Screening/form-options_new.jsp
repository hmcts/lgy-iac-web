<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">
	<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">This page is missing information.
							<div id="fields"><bean:write name="errMsg" filter="false"/></div> </span>
						</div>
					</div>
	</logic:present>
		<html:form action="IsFormtype">
			<div id="screening">
					<p style="color: red;"><strong>Due to routine maintenance, the IAC Fees Website will be unavailable from 18:30 GMT on Friday 13 March to 15:00 GMT<br/> on Saturday 14 March 2015.  Please note that if your online application is not fully completed before these dates/times,<br/>data may be lost. If you would like to submit an appeal using the paper appeal method, instructions on how to do so can<br/> be found in the form and notes that you have been given with your refusal decision or on line at GOV.UK. </strong></p>
			
		
				<p>Please select from one of the following options</p>
				<p><html:radio property="formtype" value="student1" styleId="section2a" />&nbsp;I am in the UK and I have made an application for a Tier 4 Student (General),(Child) or (Post Doctorate Extension) Visa on <br/>or after 20 October 2014 or any Tier 1, Tier 2 or Tier 5 Application on or after 2nd March 2015</p>
				<p><html:radio property="formtype" value="student2" styleId="section5" />&nbsp;I am in the UK and have made a Points Based System application as the dependant of a Tier 4 Student Visa on or after<br/> 20 October 2014 or as a dependant on any Tier 1, Tier 2 or Tier 5 Application on or after 2nd March 2015 </p>
				<p><html:radio property="formtype" value="student3" styleId="schedule2" />&nbsp;I have been given a deport decision dated on or after 20 October 2014</p>
				<p><html:radio property="formtype" value="student4" styleId="schedule2" />&nbsp;I am an EEA National and have been given a deport decision dated on or after 20 October 2014</p>
				<p><html:radio property="formtype" value="everythingelse" styleId="schedule40" />&nbsp;None of these statements apply to me </p>
			</div>

			<div class="submitc">
				
				<div class="function next right">
					<span class="tl"></span>
					<span class="tr"><span></span></span>
					<html:submit>Next</html:submit>
					<span class="bl"></span>
					<span class="br"></span>
				</div>
			</div>
		</html:form>
	</div>
</div>