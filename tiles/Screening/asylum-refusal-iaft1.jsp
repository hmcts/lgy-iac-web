<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<html:xhtml/>
		<div id="Content">
			<div class="holder">
				<div id="screening">
					<html:form action="IsAsylum?xyz=iaft1">
					Is your appeal against a refusal to grant you asylum?&nbsp;
					<html:radio property="asylum" value="yes" styleId="yes" ><span class="bigger">Yes</span></html:radio>
					<html:radio property="asylum" value="no" styleId="no" ><span class="bigger">No</span></html:radio>
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
