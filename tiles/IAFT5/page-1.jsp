<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 1 of 10</h2>
			<div align="right">
				<logic:present name="token"><h3>Your reference: IAFT5-<bean:write name="token" scope="session"/></h3></logic:present>
			</div>
		</div>

		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>
			<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an In Country <logic:present name="frmHeader" scope="session"><bean:write name="frmHeader" scope="session"/></logic:present> decision or EU Settlement Scheme Decision </h3>


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
				<html:form action="submission5.do">
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
						<p class="note">C.&nbsp;Some appeals do not have to pay a fee. Please tell us if you currently get: </p>
							<span class="lCellTr"><html:radio property="qb_lsc" value="LSC" styleId="qd_no" /></span>
							<span class="rCellTl">Legal Aid<span style="color: #ff0000;"><sup>1</sup></span></span>
							<span class="lCellTr"><html:radio property="qb_lsc" value="Asylum Support" styleId="qd_no" /></span>
							<span class="rCellTl">Asylum Support<span style="color: #ff0000;"><sup>1</sup></span></span>
							<span class="lCellTr"><html:radio property="qb_lsc" value="Section17" styleId="qd_no" /></span>
							<span class="rCellTl">Support or services under section 17* of the Children's Act (a letter from your local council will confirm this)<span style="color: #ff0000;"><sup>1</sup></span></span>
							<span class="lCellTr"><html:radio property="qb_lsc" value="Section20" styleId="qd_no" /></span>
							
							<span class="rCellTl">Accommodation under section 20* of the Children's Act (a letter from your local council will confirm this)<span style="color: #ff0000;"><sup>1</sup></span></span>
							<span class="lCellTr"><p>OR</p></span>
							<span class="rCellTl"></span>
							<span class="lCellTr"><html:radio property="qb_lsc" value="humanrights" styleId="qd_no" /></span>
							<span class="rCellTl">You did not have to pay a fee to the Home Office when you made your Human Rights application as you were exempt under exceptions 4.5 or 9.4 of the 2016 Fee Regulations</span>
							 <span class="lCellTr"><html:radio property="qb_lsc" value="helpwithfees" styleId="qd_no" /></span>
							
							 <span class="rCellTl">You have applied for and received a full remission under Help with Fees</span>
							<span class="lCellTr"><html:radio property="qb_lsc" value="No" styleId="qd_no" /></span>
							<span class="rCellTl">If you DO NOT receive any of the above please click here </span>
							
							<p class="note"><span style="color: #ff0000;"><sup>1</sup></span>You need to provide a reference number (if you have one) and send the tribunal (by email or post) any supporting documents to show that you do not have to pay. If you do not provide these, you may have to pay the fee.</p>
							<div id="laf-receipt">
								<span class="lCellTr">Reference Number(if you have one)</span>
								<span class="rCellTl"><html:text property="qb_LAR" styleId="qc_legalAidRef" size="30" maxlength="30" /></span>
							</div>
							<p> * or equivalent in Scotland, Northern Ireland or Wales </p>
								
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
							<a href="IsAsylum5.do">Previous <span class="access">page</span></a>
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