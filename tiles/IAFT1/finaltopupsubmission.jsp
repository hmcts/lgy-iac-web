<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<div align="right">
				<h3><logic:present name="oid"><h3>Reference for correspondence: <bean:write name="oid" scope="request"/></h3></logic:present></h3>
			</div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision</h3>
			

			<div class="formcon">

				<div class="edit"></div>
					<h4>Thank You</h4>
					<p>The tribunal will write to you with further information about your appeal. If you have selected and paid for an oral hearing, you will receive a notice of hearing. Please note that for appeals outside the United Kingdom, the tribunal will require evidence to be sent by the respondent to your appeal (usually an Entry Clearance Office) which means that it is likely that it will be around 15 weeks before you receive a date for your hearing.</p>
					<p><strong>VERY IMPORTANT</strong></p>
					<p>If you have not sent it already, you must now send your <strong>Notice of Decision and all other evidence</strong>, which is available to you now, to the Tribunal without delay. Where you have noted in your appeal that you have documents which are not yet available, you should send these as soon as possible. Any delay in sending the tribunal your evidence will delay the Tribunal processing and deciding your appeal.</p>
					<p><strong>You need to clearly mark all documents with your appeal reference number, your name and date of birth, so that the Tribunal can match these documents to your appeal. [If your submission number is not available, you should use the post reference number on your notice of decision].</strong></p>
					<p>You should send all documents to:</p>
					<p><a href="mailto:IACsuppdocs@hmcts.gsi.gov.uk ">IACsuppdocs@hmcts.gsi.gov.uk </a></p>
					<p>If you are unable to e-mail the documents to us, post to:</p>
					<p class="centered">
						First-tier Tribunal (Immigration and Asylum Chamber)<br />
						PO Box 6987<br />
						Leicester<br />
						United Kingdom<br />
						LE1 6ZX
					</p>
					<p>Further information regarding the appeal process can be found on <a href="http://www.gov.uk/" target="_blank">www.gov.uk</a> and on the guidance notes accompanying the appeal form.</p>	
                    <p>Please click on the link below and take a few minutes to complete a short survey</p>
                    <p><a href="https://www.surveymonkey.com/s/IAC11" target="_blank">https://www.surveymonkey.com/s/IAC11</a></p>
					<div class="submitc">
						<html:hidden property="next" value="page-2" />
					
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
									<a href="http://www.justice.gov.uk/guidance/courts-and-tribunals/tribunals/immigration-and-asylum/first-tier/index.htm" >Finish</a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
					</div>

				<span class="bl"></span>
				<span class="br"></span>
			</div>
		</div>
	</div>
</div>