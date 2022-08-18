<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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
				<div id="screening">
					<html:form action="IsAsylum?xyz=iaft6">
					<p>Please select one of the following. Your appeal is <p>
				<p> <html:radio property="asylum" value="humanrights6" styleId="yes" ><span>&nbsp;against a refusal your human rights claim.</span></html:radio></p>
				<p> <html:radio property="asylum" value="eea6" styleId="yes" ><span>&nbsp;against a decision restricting your rights under the EEA right to free movement, EU Settlement Scheme, EEA family permit, </br>EUSS travel permit, Frontier Worker or Healthcare Visitor Permit.</span></html:radio></p>

					<!-- <div class="button"><a href="IsAsylum?xy867=yes">Yes</a></div>&nbsp; -->
					<!-- <div class="button"><a href="IsAsylum?xy867=no">No</a></div> -->
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
