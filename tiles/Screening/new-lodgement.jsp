<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<div id="Content">
	<div class="holder">

		<div id="screening">
			Are you appealing from within the United Kingdom?&nbsp;
			<div class="button"><a href="asylum-refusal-iaft1.do?xyz=iaft1">Yes</a></div>&nbsp;
			<div class="button"><a href="eco-decision-appeal.do">No</a></div>
			
			<!-- 
			<div class="button2"><a href="asylum-refusal-iaft1.do">Yes</a></div>&nbsp;
			<div class="button2"><a href="eco-decision-appeal.do">No</a></div>
			-->
		</div>

		<div class="submitc">
			<div class="function previous">
				<span class="tl"></span>
				<span class="tr"><span></span></span>
				
				<a href="javascript:history.go(-1)">previous<span class="access">page</span></a>
				<span class="bl"></span>
				<span class="br"></span>
			</div>
		</div>

	</div>
</div>