<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 1 of 10</h2>
			<div align="right">
				<logic:present name="token"><h3>Your reference: IAFT1-<bean:write name="token" scope="session"/></h3></logic:present>
			</div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision</h3>


			<div class="formcon">

				<div class="edit"></div>

				<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">This page is missing information.  Please correct following:</span>
							<div id="fields"><bean:write name="errMsg" filter="false"/></div>
						</div>
					</div>
				</logic:present>

				<p class="question"><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>
				<html:form action="submission.do">
					<fieldset>
						<div id="qa" class="qBox">
							<div class="lCellTl">
								A.&nbsp;Do you want to have your appeal decided at an oral hearing or on the papers? <span class="required">*</span>
								<p>You should tick the 'oral hearing' box if you want to have an oral hearing that you and/or your representative plan to attend. You will need to pay the appropriate fee for an oral hearing.</p>
								<p>You should tick the 'paper hearing' box if no one will attend and you want to have your case determined on the papers provided. You will need to pay the appropriate fee for a paper hearing.</p>
							</div>
							<span class="rCellTl">
								Oral Hearing&nbsp;<html:radio property="appeal_type" value="Oral" />
								Papers&nbsp;<html:radio property="appeal_type" value="Paper" />
							</span>
						</div>

						<div id="qb" class="qBox">
							<span class="lCellTl">
								B.&nbsp;If you have chosen to have an oral hearing, please mark the box of anyone who will be attending your hearing to <span class="note">give evidence</span> <span class="required">*</span>.
							</span>
							<span class="rCellTl">
								Sponsor&nbsp;<html:checkbox property="qa_sponsor" value="Sponsor" />
								Your representative&nbsp;<html:checkbox property="qa_rep" value="Representative" />
								Witness&nbsp;<html:checkbox property="qa_witness" value="Witness" />
							</span>
						</div>

						<div id="qc" class="qBox">
							<span class="lCellTl">
								C.&nbsp;Are you in receipt of legal aid funding, Asylum Support Funding or support under s.17 of the Children's act 1989? <span class="required">*</span>
								
							</span>
							<span class="rCellTl">
								No&nbsp;<html:radio property="qb_lsc" value="No" />
								Legal Aid&nbsp;<html:radio property="qb_lsc" value="LSC" />
								Asylum Support&nbsp;<html:radio property="qb_lsc" value="Asylum Support" />
								Section 17&nbsp;<html:radio property="qb_lsc" value="Section 17" />
							</span>
							<p class="note">You should provide a reference and any supporting documents. Failure to do so may result in a fee being required.</p>
							<div id="laf-receipt">
								<span class="lCellTr">Reference Number</span>
								<span class="rCellTl"><html:text property="qb_LAR" styleId="qc_legalAidRef" size="30" maxlength="30" /></span>
							</div>
						</div>

						<div id="qd" class="qBox">
							<span class="lCellTl">D.&nbsp;Are you paying for the appeals of any member of your family or anyone planning to appeal against an immigration decision? <span class="required">*</span></span>
							<span class="rCellTl">
								No&nbsp;<html:radio property="family_member" value="No" styleId="qd_no" />
								Yes&nbsp;<html:radio property="family_member" value="Yes"  styleId="qd_yes" />
							</span>

							<div id="multiple-application">
								<p class="bold">Give details below:</p>

								<span class="lCellTr">Name</span>
								<span class="rCellTl"><html:text property="name1" styleId="qd_name1" size="50" maxlength="70" /></span>

								<span class="lCellTr">Relationship</span>
								<span class="rCellTl"><html:text property="relationship1"  styleId="qd_relationship1" size="15" maxlength="15" /></span>

								<span class="lCellTr">Appeal number/Post reference number</span>
								<span class="rCellTl"><html:text property="prn1"  styleId="qd_prn1" size="25" maxlength="25" /></span>

								<span class="lCellTr">Name</span>
								<span class="rCellTl"><html:text property="name2" styleId="qd_name2" size="50" maxlength="70" /></span>

								<span class="lCellTr">Relationship</span>
								<span class="rCellTl"><html:text property="relationship2"  styleId="qd_relationship2" size="15" maxlength="15" /></span>

								<span class="lCellTr">Appeal number/Post reference number</span>
								<span class="rCellTl"><html:text property="prn2"  styleId="qd_prn2" size="25" maxlength="25" /></span>

								<span class="lCellTr">Name</span>
								<span class="rCellTl"><html:text property="name3" styleId="qd_name3"  size="50" maxlength="70" /></span>

								<span class="lCellTr">Relationship</span>
								<span class="rCellTl"><html:text property="relationship3"  styleId="qd_relationship3" size="15" maxlength="15" /></span>

								<span class="lCellTr">Appeal number/Post reference number</span>
								<span class="rCellTl"><html:text property="prn3" styleId="qd_prn3" size="25" maxlength="25" /></span>

								<span class="lCellTr">Name</span>
								<span class="rCellTl"><html:text property="name4" styleId="qd_name4"  size="50" maxlength="70" /></span>

								<span class="lCellTr">Relationship</span>
								<span class="rCellTl"><html:text property="relationship4"  styleId="qd_relationship4"  size="15" maxlength="15" /></span>

								<span class="lCellTr">Appeal number/Post reference number</span>
								<span class="rCellTl"><html:text property="prn4" styleId="qd_prn4" size="25" maxlength="25" /></span>
							</div>
						</div>
					</fieldset>

					<div class="submitc">
						<html:hidden property="next" value="page-2" />
						<div class="function previous">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<a href="IsAsylum.do">Previous <span class="access">page</span></a>
							<span class="bl"></span>
							<span class="br"></span>
						</div>
						<img id="progress" src="images/progress/01of10.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span>
							<span class="tr"><span></span></span>
							<html:submit>Save &amp; Next</html:submit>
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