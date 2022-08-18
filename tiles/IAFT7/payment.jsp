<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


							<div id="Content">
								<div class="holder">
									<!-- InstanceBeginEditable name="main" -->

									<div class="steps">
										<h2>Step 1 of 10</h2>
										<div align="right"><h3>Security Token : IAFT1-<bean:write name="token" scope="session"/> </h3> </div>
									</div>

									<div class="formwrap">
										<span class="tl"></span>
										<span class="tr"><span></span></span>
												<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an in country
												 <logic:present name="frmHeader" scope="session">
					 								<bean:write name="frmHeader" scope="session"/>
					 								</logic:present>
					 								sdecision</h3>

								<logic:present name="errMsg" scope="request">
										<strong>Please correct following:</strong>
										<font color="red">
											<Strong><bean:write name="errMsg" filter="false"/></Strong>
										</font>
								</logic:present>

										<div class="formcon">
											<div class="edit">
												<div class="function right">
													<span class="tl"></span>
													<span class="tr"><span></span></span>
													<span class="bl"></span>
													<span class="br"></span>
												</div>
											</div>

											<html:form action="paymentsubmission">


												<div id="">
													<p><strong>C:</strong>&nbsp;Are you paying for the appeals of any member of your family or anyone planning to appeal against an immigration decision?</p>
													<p>

														<html:radio  property="family_member" styleId="qc-no" value="No" ><label for="qc-no">No</label></html:radio>
														<html:radio property="family_member" styleId="qc-yes" value="Yes" ><label for="qc-yes">Yes &ndash; give details in the table below</label></html:radio>
													</p>


													<div class="row">
														<label for="qc-relationship0">Relationship</label>
														<html:text property="relationship1" styleId="qc-relationship0" size="40" maxlength="70" />
													</div>
													<div class="row">
														<label for="qc-appeal.number0">Appeal number/Post reference number</label>
														<html:text property="prn1" styleId="qc-appeal-number0" size="40" maxlength="70" />
													</div>


													<div class="row">
														<label for="qc-relationship1">Relationship</label>
														<html:text property="relationship2" styleId="qc-relationshipr1" size="40" maxlength="70" />
													</div>
													<div class="row">
														<label for="qc-appeal-number1">Appeal number/Post reference number</label>
														<html:text property="prn2" styleId="qc-appeal-number1" size="40" maxlength="70" />
													</div>


													<div class="row">
														<label for="qc-relationship2">Relationship</label>
														<html:text property="relationship3" styleId="qc-relationship2" size="40" maxlength="70" />
													</div>
													<div class="row">
														<label for="qc-appeal-number2">Appeal number/Post reference number</label>
														<html:text property="prn3" styleId="qc-appeal-number2" size="40" maxlength="70" />
													</div>


													<div class="row">
														<label for="qc-relationship3">Relationship</label>
														<html:text property="relationship4" styleId="qc-relationship3" size="40" maxlength="70" />
													</div>
													<div class="row">
														<label for="qc-appeal-number3">Appeal number/Post reference number</label>
														<html:text property="prn4" styleId="qc-appeal-number3" size="40" maxlength="70" />
													</div>



													<div class="row">
														<label for="qc-relationship3">Relationship</label>
														<html:text property="relationship5" styleId="qc-relationship3" size="40" maxlength="70" />
													</div>
													<div class="row">
														<label for="qc-appeal-number3">Appeal number/Post reference number</label>
														<html:text property="prn5" styleId="qc-appeal-number3" size="40" maxlength="70" />
													</div>
												</div>

												<div class="submitc">
													<!--
													<div class="function previous">
														<span class="tl"></span>
														<span class="tr"><span></span></span>
														<a href="#">Previous <span class="access">page</span></a>
														<span class="bl"></span>
														<span class="br"></span>
													</div>
													 -->
<html:hidden property="next" value="page-2"/>
													<div class="function next right">
														<span class="tl"></span>
														<span class="tr"><span></span></span>
														<html:submit>Next</html:submit>
														<span class="bl"></span>
														<span class="br"></span>
													</div>
												</div>

											</html:form>
											<span class="bl"></span>
											<span class="br"></span>
										</div>
									</div>
									<!-- InstanceEndEditable -->
								</div>
							</div>

