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
			
				<p>Please select from one of the following options</p>
				<p><html:radio property="formtype" value="student1" styleId="section2a" />&nbsp;I have received a decision to refuse my asylum, protection or human rights claim</p>
				<p><html:radio property="formtype" value="everythingelse" styleId="section5" />&nbsp;I am in the UK and I received a refusal decision on:<br/>
						- An application made before 20 October 2014 as Tier 4 migrant ; or <br/>
						- An application made before 20 October 2014 as the family member of a Tier 4 migrant ; or <br/>
						- An application made before 2 March 2015 as a Tier 1, Tier 2 or Tier 5 migrant ; or <br/>
						- An application made before 2 March 2015 as the family member of a Tier 1, Tier 2 or Tier 5 migrant </p>

				<p><html:radio property="formtype" value="everythingelse" styleId="schedule2" />&nbsp;I have received a refusal decision dated after 6 April 2015 on: <br/>
				- An application for leave to enter ; or <br/>
				- An application for entry clearance ; or <br/>
				- An application for a certificate of entitlement under section 10 of the Nationality, Immigration and Asylum Act 2002 ; or <br/>
				- An application for a variation of leave to enter or remain with the result that I have no leave to enter or remain</p>
</p>
				<p><html:radio property="formtype" value="everythingelse" styleId="schedule2" />&nbsp;I have received an appealable decision on any other application type (from in or outside of the UK) dated before 6 April 2015 </p>
				<p><html:radio property="formtype" value="student2" styleId="schedule40" />&nbsp;I have received an appealable decision on any other application and the decision is dated on or after 6 April 2015 </p>
			</div>

			<div class="submitc">
				<div class="function previous">
						<span class="tl"></span>
						<span class="tr"><span></span></span>
						<a href="javascript:history.go(-1)">previous<span class="access">page</span></a>
						<span class="bl"></span>
						<span class="br"></span>
					</div>
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