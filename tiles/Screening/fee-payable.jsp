<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">
		<html:form action="IsFeePayable">
			<div id="screening">
				<p>Some appeals are exempt from paying a fee.</p>
				<p>You should read the Notice of Decision you received when your application was refused to see if your appeal is one of these types.<br />If you are unsure then you should refer to the person who refused your application to check. Further information is contained in the<br />guidance notes section <a href=" http://hmctsformfinder.justice.gov.uk/HMCTS/GetLeaflet.do?court_leaflets_id=4525">"Immigration and Appeals Tribunal fees guidance"</a>.</p>
				<p><strong>Important: The tribunal will obtain a copy of your notice of decision and will be able to check whether your appeal is exempt. If you claim exemption where the list below does not apply to your appeal, then your appeal will be delayed whilst the tribunal writes to you requesting payment. If you do not pay, your appeal may not proceed.</strong></p>
				<p>If your appeal is against a decision listed below then you should click the appropriate box:</p>
			
				<p><html:radio property="exemption" value="section2a" styleId="section2a" />&nbsp;Section 2A of the 1971 Act (deprivation of right of abode)</p>
				<p><html:radio property="exemption" value="section5" styleId="section5" />&nbsp;Section 5(1) of the 1971 Act (a decision to make a deportation order)</p>
				<p><html:radio property="exemption" value="schedule2" styleId="schedule2" />&nbsp;Paragraphs 8, 9,10, 10A or 12(2) of Schedule 2 to the 1971 Act (a decision that an illegal entrant, any family<br /> or seaman and aircrew is or are to be removed from the United Kingdom by way of directions)</p>
				<p><html:radio property="exemption" value="section40" styleId="schedule40" />&nbsp;Section 40 of the British Nationality Act 1981 (deprivation of citizenship)</p>
				<p><html:radio property="exemption" value="section10" styleId="schedule10" />&nbsp;Section 10(1) of the 1999 Act (removal of certain persons unlawfully in the United Kingdom)</p>
				<p><html:radio property="exemption" value="section76" styleId="schedule76" />&nbsp;Section 76 of the 2002 Act (revocation of indefinite leave to enter or remain in the United Kingdom)</p>
				<p><html:radio property="exemption" value="section47" styleId="schedule47" />&nbsp;Section 47 of the Immigration, Asylum and Nationality Act 2006 (removal: persons with statutorily extended leave)</p>
				<p><html:radio property="exemption" value="regulation19" styleId="regulation19" />&nbsp;Regulation 19(3) of the Immigration (European Economic Area) Regulations 2006 (a decision to remove an EEA national<br /> or the family member of such a national)</p>
				<p><html:radio property="exemption" value="part2" styleId="part2" />&nbsp;Part 2 of the Asylum and Immigration Tribunal (Fast Track procedure) Rules 2005 applies to your appeal</p>
			</div>

			<div class="submitc">
				<div class="function previous">
					<span class="tl"></span>
					<span class="tr"><span></span></span>
					<a href="asylum-refusal-iaft1.do">Previous <span class="access">page</span></a>
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