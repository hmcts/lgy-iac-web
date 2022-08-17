<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">
		<html:form action="NewIsFeePayableretrieve7">
			<div id="screening">
				<p>Some appeals are exempt from paying a fee.</p>
				<p>You should read the Notice of Decision you received when your application was refused to see if your appeal is one of these types.<br />If you are unsure then you should refer to the person who refused your application to check. Further information is contained in the<br />guidance notes section <a href=" http://hmctsformfinder.justice.gov.uk/HMCTS/GetLeaflet.do?court_leaflets_id=4525">"Immigration and Appeals Tribunal fees guidance"</a>.</p>
				<p><strong>Important: The tribunal will obtain a copy of your notice of decision and will be able to check whether your appeal is exempt. If you claim exemption where the list below does not apply to your appeal, then your appeal will be delayed whilst the tribunal writes to you requesting payment. If you do not pay, your appeal may not proceed.</strong></p>
				<p>If your appeal is against a decision listed below then you should click the appropriate box:</p>
			
				<p><html:radio property="exemption" value="section40" styleId="schedule40" />&nbsp;Section 40 of the British Nationality Act 1981(a) (deprivation of citizenship) or</br> Rule 338A of Immigration Rules (Revocation of Protection Status) if your decision is dated 10 October 2016 or after.</p>
				<p><html:radio property="exemption" value="regulation19" styleId="regulation19" />&nbsp;Regulation 19(3) of the Immigration (European Economic Area) Regulations 2006 (a decision to remove an EEA national<br /> or the family member of such a national)</p>
				<p><html:radio property="exemption" value="No" styleId="part2" />None of the above.</p>
			</div>

			<div class="submitc">
				<div class="function previous">
					<span class="tl"></span>
					<span class="tr"><span></span></span>
					<a href="asylum-refusal-iaft7.do">Previous <span class="access">page</span></a>
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