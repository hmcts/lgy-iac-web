<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<html:xhtml/>
		<div id="Content">
			<div class="holder">
				<div id="screening">
					<html:form action="IsAsylum.do?xyz=iaft7">
					<p>Please select one of the following. Your appeal is <p>
				<p>	<html:radio property="asylum" value="protection7" styleId="yes" ><span>&nbsp;against a refusal to grant you protection.</span></html:radio></p>
				<p>	<html:radio property="asylum" value="protectionrevoke7" styleId="yes" ><span>&nbsp;against a decision to revoke your protection status.</span></html:radio></p>
				<p> <html:radio property="asylum" value="humanrights7" styleId="yes" ><span>&nbsp;against a refusal your human rights claim.</span></html:radio></p>
				<p> <html:radio property="asylum" value="eea7" styleId="yes" ><span>&nbsp;against a decision restricting your rights under the EEA right to free movement.</span></html:radio></p>
				<p> <html:radio property="asylum" value="citizenship7" styleId="yes" ><span>&nbsp;against a decision depriving you of citizenship.</span></html:radio></p>
					
					
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
