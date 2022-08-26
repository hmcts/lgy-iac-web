<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>

			<div class="formcon">

				<div class="edit"></div>

				<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">Please correct following:</span>
							<div id="fields"><bean:write name="errMsg" filter="false"/></div>
						</div>
					</div>
				</logic:present>

				<html:form action="retrieve.do">
					<fieldset>
						<div id="retrieve" class="qBox">
							<span class="lCellTr">Your reference:</span>
							<span class="rCellTl"><html:text property="securitytoken" size="20" maxlength="20" /></span>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-2" />
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="index.jsp">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Retrieve</html:submit>
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