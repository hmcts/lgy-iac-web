<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>
				Payment Failure
			</h2>

		</div>
		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span>
			</span>

			<div class="formcon">
				<div class="edit">
					<div class="function right">
						<span class="tl"></span>
						<span class="tr"><span></span>
						</span>
						<span class="bl"></span>
						<span class="br"></span>
					</div>
				</div>

				<div>
					<p>
						<strong>You are seeing this page as you have failed to
							make successful payment in 5 attempts.You can download and save PDF files from the link below</strong>
					</p>
					<p>
					<logic:present name="list" scope="session">
						<logic:iterate id="bean" name="list" type="com.MOJICT.IACFee.Beans.AggregatedSubmissionBean" scope="session">

							<p>
								Please
								<html:link href="downloadpdf" paramId="token"
									paramName="bean" paramProperty="securitytoken" target="_blank">Click here</html:link>
								to download the pdf file for your submission.
							</p>
						</logic:iterate>
					</logic:present>
					</p>
					<p>
						You must now send your pdf appeal form submission along with your
						<strong>Notice of Decision and all other evidence</strong>, which
						is available to you now, to the Tribunal without delay. Where you
						have noted in your appeal that you have documents which are not
						yet available, you should send these as soon as possible. Any
						delay in sending the tribunal your evidence will delay the
						Tribunal processing and deciding your appeal.
					</p>
					<p>
						<strong>You need to clearly mark all documents with your
							Home Office/Post reference number ,your name and date of birth, so
							that the Tribunal can match these documents to your appeal.</strong>
					</p>
					<p>
						You should send all documents to:
					</p>
					<p class="centered">
						First-tier Tribunal (Immigration and Asylum Chamber)
						<br />
						PO Box 6987
						<br />
						Leicester
						<br />
						United Kingdom
						<br />
						LE1 6ZX
					</p>
					<p>
						Further information regarding the appeal process can be found on
						<a href="http://www.gov.uk/" target="_blank">www.gov.uk</a>
						and on the guidance notes accompanying the appeal form.
					</p>
					<p>Please click on the link below and take a few minutes to complete a short survey</p>

					<p><a href="https://www.surveymonkey.com/s/IAC11">https://www.surveymonkey.com/s/IAC11</a></p>




				</div>

				<span class="bl"></span>
				<span class="br"></span>
			</div>
		</div>

	</div>
</div>
