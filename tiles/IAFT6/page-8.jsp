<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<html:xhtml/>
		<div id="Content">
			<div class="holder">
				<div class="steps">
					<h2>Step 8 of 8</h2>
					<div align="right">
						<h3>Your reference: IAFT6-
							<bean:write name="token" scope="session"/>
						</h3>
					</div>
				</div>
				<div class="formwrap">
					<span class="tl"></span>
					<span class="tr"><span></span></span>
					<h3>Appeal To The First&ndash;Tier Tribunal (Immigration And Asylum Chamber) Against A Decision Of An Entry Clearance Officer</h3>
					<div class="formcon">
						<div class="edit">
						</div>
						<logic:present name="errMsg" scope="request">
							<div id="error">
								<div id="message">
									<span id="heading">This page is missing information.  Please correct following:</span>
									<div id="fields">
										<bean:write name="errMsg" filter="false"/>
									</div>
								</div>
							</div>
						</logic:present>
						<p class="question"><span class="note">Please note:</span> all questions marked <span class="required">*</span> are mandatory.</p>
						<h3 id="s6_subtitle">Section 6 &ndash; Sponsor Details (refer to guidance notes)</h3>
						<html:form action="submission6">
							<fieldset>
								<div id="s6a" class="qBox">
									<span class="lCellTl">A.&nbsp;Family Name or Surname <span class="required">*</span></span>
									<span class="rCellTl" >
									<html:text property="s6a" size="35" maxlength="35" />
									</span>
								</div>
								<div id="s6b" class="qBox">
									<span class="lCellTl">B.&nbsp;Given or First Name(s) <span class="required">*</span></span>
									<span class="rCellTl" >
									<html:text property="s6b" size="35" maxlength="35" />
									</span>
								</div>
								<div id="s6c" class="qBox">
									<span class="lCellTl">C.&nbsp;Title (Mr / Mrs / Miss / Ms or Other) <span class="required">*</span></span>
									<span class="rCellTl" >
									<html:text property="s6c" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s6d" class="qBox">
									<span class="lCellTl">D.&nbsp;Postal Address for correspondence <span class="required">*</span></span>
									<span class="lCellTr" ></span>
									<span class="lCellTr" >Line 1:</span>
									<span class="rCellTl" >
									<html:text property="s6d_addr1" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 2:</span>
									<span class="rCellTl" >
									<html:text property="s6d_addr2" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 3:</span>
									<span class="rCellTl" >
									<html:text property="s6d_addr3" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Country:</span>
									<span class="rCellTl" >
									<html:select property="s6d_addr4">
										<html:option value="0">Country</html:option>
										<html:option value ="1:Afghanistan">Afghanistan</html:option>
										<html:option value ="2:Albania">Albania</html:option>
										<html:option value ="3:Algeria">Algeria</html:option>
										<html:option value ="4:Andorra">Andorra</html:option>
										<html:option value ="5:angola">angola</html:option>
										<html:option value ="6:Antigua & Barbuda">Antigua and Barbuda</html:option>
										<html:option value ="7:Argentina">Argentina</html:option>
										<html:option value ="8:Armenia">Armenia</html:option>
										<html:option value ="9:Australia">Australia</html:option>
										<html:option value ="10:Austria">Austria</html:option>
										<html:option value ="11:Azerbaijan">Azerbaijan</html:option>
										<html:option value ="12:Bahamas">Bahamas</html:option>
										<html:option value ="189:Bahrain">Bahrain</html:option>
										<html:option value ="13:Bangladesh">Bangladesh</html:option>
										<html:option value ="14:Barbados">Barbados</html:option>
										<html:option value ="15:Belarus">Belarus</html:option>
										<html:option value ="16:Belgium">Belgium</html:option>
										<html:option value ="17:Belize">Belize</html:option>
										<html:option value ="18:Benin">Benin</html:option>
										<html:option value ="19:Bolivia">Bolivia</html:option>
										<html:option value ="20:Bosnia and Herzegovina">Bosnia and Herzegovina</html:option>
										<html:option value ="21:Botswana">Botswana</html:option>
										<html:option value ="22:Brazil">Brazil</html:option>
										<html:option value ="23:brunei">brunei</html:option>
										<html:option value ="24:Bulgaria">Bulgaria</html:option>
										<html:option value ="25:Burkina Faso">Burkina Faso</html:option>
										<html:option value ="26:Burma (Union of Myanmar)">Burma (Union of Myanmar)</html:option>
										<html:option value ="27:Burundi">Burundi</html:option>
										<html:option value ="190:Cambodia">Cambodia</html:option>
										<html:option value ="28:Cameroon">Cameroon</html:option>
										<html:option value ="29:Canada">Canada</html:option>
										<html:option value ="30:Cape Verde">Cape Verde</html:option>
										<html:option value ="31:Central Africa">Central Africa</html:option>
										<html:option value ="32:Chad">Chad</html:option>
										<html:option value ="33:Chile">Chile</html:option>
										<html:option value ="34:China">China</html:option>
										<html:option value ="35:Colombia">Colombia</html:option>
										<html:option value ="36:Comoros">Comoros</html:option>
										<html:option value ="37:Congo">Congo</html:option>
										<html:option value ="38:Costa Rica">Costa Rica</html:option>
										<html:option value ="40:Croatia">Croatia</html:option>
										<html:option value ="41:Cuba">Cuba</html:option>
										<html:option value ="42:Cyprus">Cyprus</html:option>
										<html:option value ="43:Czech Republic">Czech Republic</html:option>
										<html:option value ="199:Democratic Republic of Congo">Democratic Republic of Congo</html:option>
										<html:option value ="44:Denmark">Denmark</html:option>
										<html:option value ="45:Djibouti">Djibouti</html:option>
										<html:option value ="46:Dominica, Commonwealth of">Dominica, Commonwealth of</html:option>
										<html:option value ="47:Dominican Republic">Dominican Republic</html:option>
										<html:option value ="204:East Timor">East Timor</html:option>
										<html:option value ="48:Ecuador">Ecuador</html:option>
										<html:option value ="49:Egypt">Egypt</html:option>
										<html:option value ="50:El Salvador">El Salvador</html:option>
										<html:option value ="51:Equatorial Guinea">Equatorial Guinea</html:option>
										<html:option value ="52:Eritrea">Eritrea</html:option>
										<html:option value ="53:Estonia">Estonia</html:option>
										<html:option value ="54:Ethiopia">Ethiopia</html:option>
										<html:option value ="55:Fiji">Fiji</html:option>
										<html:option value ="56:Finland">Finland</html:option>
										<html:option value ="57:France">France</html:option>
										<html:option value ="58:Gabon">Gabon</html:option>
										<html:option value ="59:Gambia, The">Gambia, The</html:option>
										<html:option value ="60:Georgia">Georgia</html:option>
										<html:option value ="61:Germany">Germany</html:option>
										<html:option value ="62:Ghana">Ghana</html:option>
										<html:option value ="63:Greece">Greece</html:option>
										<html:option value ="64:Grenada">Grenada</html:option>
										<html:option value ="65:Guatemala">Guatemala</html:option>
										<html:option value ="66:Guinea">Guinea</html:option>
										<html:option value ="67:Guinea - Bissau">Guinea &ndash; Bissau</html:option>
										<html:option value ="68:Guyana">Guyana</html:option>
										<html:option value ="69:Haiti">Haiti</html:option>
										<html:option value ="71:Honduras">Honduras</html:option>
										<html:option value ="72:Hungary">Hungary</html:option>
										<html:option value ="73:Iceland">Iceland</html:option>
										<html:option value ="74:India">India</html:option>
										<html:option value ="75:Indonesia">Indonesia</html:option>
										<html:option value ="76:Iran">Iran</html:option>
										<html:option value ="191:Iraq">Iraq</html:option>
										<html:option value ="77:Irish Republic">Irish Republic</html:option>
										<html:option value ="78:Israel">Israel</html:option>
										<html:option value ="79:Italy">Italy</html:option>
										<html:option value ="187:Ivory Coast">Ivory Coast</html:option>
										<html:option value ="80:Jamaica">Jamaica</html:option>
										<html:option value ="81:Japan">Japan</html:option>
										<html:option value ="83:Jordan">Jordan</html:option>
										<html:option value ="84:Kazakhstan">Kazakhstan</html:option>
										<html:option value ="85:Kenya">Kenya</html:option>
										<html:option value ="86:Kiribati">Kiribati</html:option>
										<html:option value ="213:Kosovo">Kosovo</html:option>
										<html:option value ="88:Kuwait">Kuwait</html:option>
										<html:option value ="89:Kyrgyzstan">Kyrgyzstan</html:option>
										<html:option value ="90:Laos">Laos</html:option>
										<html:option value ="91:Latvia">Latvia</html:option>
										<html:option value ="92:Lebanon">Lebanon</html:option>
										<html:option value ="93:Lesotho">Lesotho</html:option>
										<html:option value ="94:Liberia">Liberia</html:option>
										<html:option value ="95:Libya">Libya</html:option>
										<html:option value ="96:Liechtenstein">Liechtenstein</html:option>
										<html:option value ="97:Lithuania">Lithuania</html:option>
										<html:option value ="98:Luxembourg">Luxembourg</html:option>
										<html:option value ="100:Madagascar">Madagascar</html:option>
										<html:option value ="101:Malawi">Malawi</html:option>
										<html:option value ="102:Malaysia">Malaysia</html:option>
										<html:option value ="103:Maldives">Maldives</html:option>
										<html:option value ="104:Mali">Mali</html:option>
										<html:option value ="105:Malta">Malta</html:option>
										<html:option value ="106:Marshall Islands">Marshall Islands</html:option>
										<html:option value ="107:Mauritania">Mauritania</html:option>
										<html:option value ="108:Mauritius">Mauritius</html:option>
										<html:option value ="109:Mexico">Mexico</html:option>
										<html:option value ="110:Micronesia">Micronesia</html:option>
										<html:option value ="111:Moldova">Moldova</html:option>
										<html:option value ="112:Monaco">Monaco</html:option>
										<html:option value ="113:Mongolia">Mongolia</html:option>
										<html:option value ="114:Morocco">Morocco</html:option>
										<html:option value ="115:Mozambique">Mozambique</html:option>
										<html:option value ="116:Namibia">Namibia</html:option>
										<html:option value ="117:Nauru">Nauru</html:option>
										<html:option value ="118:Nepal">Nepal</html:option>
										<html:option value ="119:Netherlands">Netherlands</html:option>
										<html:option value ="120:New Zealand">New Zealand</html:option>
										<html:option value ="121:Nicaragua">Nicaragua</html:option>
										<html:option value ="122:Niger">Niger</html:option>
										<html:option value ="123:Nigeria">Nigeria</html:option>
										<html:option value ="206:North Korea ( N Korea)">North Korea ( N Korea)</html:option>
										<html:option value ="124:Norway">Norway</html:option>
										<html:option value ="125:Oman">Oman</html:option>
										<html:option value ="196:Overseas Citizen">Overseas Citizen</html:option>
										<html:option value ="126:Pakistan">Pakistan</html:option>
										<html:option value ="127:Palau">Palau</html:option>
										<html:option value ="128:Panama">Panama</html:option>
										<html:option value ="129:Papua New Guinea">Papua New Guinea</html:option>
										<html:option value ="130:Paraguay">Paraguay</html:option>
										<html:option value ="131:Peru">Peru</html:option>
										<html:option value ="132:Philippines">Philippines</html:option>
										<html:option value ="133:Poland">Poland</html:option>
										<html:option value ="134:Portugal">Portugal</html:option>
										<html:option value ="135:Qatar">Qatar</html:option>
										<html:option value ="99:Republic of Macedonia">Republic of Macedonia</html:option>
										<html:option value ="209:Republic of Montenegro">Republic of Montenegro</html:option>
										<html:option value ="208:Republic of Serbia">Republic of Serbia</html:option>
										<html:option value ="136:Romania">Romania</html:option>
										<html:option value ="137:Russian Federation">Russian Federation</html:option>
										<html:option value ="138:Rwanda">Rwanda</html:option>
										<html:option value ="142:San Marino">San Marino</html:option>
										<html:option value ="143:Sao Tome and Principe">Sao Tome and Principe</html:option>
										<html:option value ="144:Saudi Arabia">Saudi Arabia</html:option>
										<html:option value ="145:Senegal">Senegal</html:option>
										<html:option value ="146:Seychelles">Seychelles</html:option>
										<html:option value ="147:Sierra Leone">Sierra Leone</html:option>
										<html:option value ="148:Singapore">Singapore</html:option>
										<html:option value ="149:Slovakia">Slovakia</html:option>
										<html:option value ="150:Slovenia">Slovenia</html:option>
										<html:option value ="151:Solomon Islands">Solomon Islands</html:option>
										<html:option value ="152:Somalia">Somalia</html:option>
										<html:option value ="153:South Africa">South Africa</html:option>
										<html:option value ="87:South Korea (S Korea)">South Korea (S Korea)</html:option>
										<html:option value ="154:Spain">Spain</html:option>
										<html:option value ="155:Sri Lanka">Sri Lanka</html:option>
										<html:option value ="139:St Kitts and Nevis">St Kitts and Nevis</html:option>
										<html:option value ="140:St Lucia">St Lucia</html:option>
										<html:option value ="141:St Vincent">St Vincent</html:option>
										<html:option value ="156:Sudan">Sudan</html:option>
										<html:option value ="157:Suriname">Suriname</html:option>
										<html:option value ="158:Swaziland">Swaziland</html:option>
										<html:option value ="159:Sweden">Sweden</html:option>
										<html:option value ="160:Switzerland">Switzerland</html:option>
										<html:option value ="161:Syria">Syria</html:option>
										<html:option value ="212:Taiwan">Taiwan</html:option>
										<html:option value ="162:Tajikistan">Tajikistan</html:option>
										<html:option value ="163:Tanzania">Tanzania</html:option>
										<html:option value ="164:Thailand">Thailand</html:option>
										<html:option value ="165:Togo">Togo</html:option>
										<html:option value ="166:Tonga">Tonga</html:option>
										<html:option value ="167:Trinidad and Tobago">Trinidad and Tobago</html:option>
										<html:option value ="168:Tunisia">Tunisia</html:option>
										<html:option value ="169:Turkey">Turkey</html:option>
										<html:option value ="170:Turkmenistan">Turkmenistan</html:option>
										<html:option value ="171:Tuvalu">Tuvalu</html:option>
										<html:option value ="172:Uganda">Uganda</html:option>
										<html:option value ="173:Ukraine">Ukraine</html:option>
										<html:option value ="174:United Arab Emirates">United Arab Emirates</html:option>
										<html:option value ="188:United Kingdom">United Kingdom</html:option>
										<html:option value ="175:United States of America">United States of America</html:option>
										<html:option value ="176:Uruguay">Uruguay</html:option>
										<html:option value ="177:Uzbekistan">Uzbekistan</html:option>
										<html:option value ="178:Vanuatu">Vanuatu</html:option>
										<html:option value ="179:Venezuela">Venezuela</html:option>
										<html:option value ="180:Vietnam">Vietnam</html:option>
										<html:option value ="202:Western Sahara">Western Sahara</html:option>
										<html:option value ="181:Western Samoa">Western Samoa</html:option>
										<html:option value ="182:Yemen">Yemen</html:option>
										<html:option value ="185:Zambia">Zambia</html:option>
										<html:option value ="186:Zimbabwe">Zimbabwe</html:option>
									</html:select>
									</span>
									<span class="lCellTr">Postcode / Zip Code:<span class="required">*</span></span>
									<span class="rCellTl" >
									<html:text property="s6d_postcode" size="9" maxlength="9" />
									</span>
								</div>
								<div id="s6e" class="qBox">
									<span class="lCellTl">E.&nbsp;Telephone / mobile number</span>
									<span class="rCellTl" >
									<html:text property="s6e" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s6f" class="qBox">
									<span class="lCellTl">F.&nbsp;Email address</span>
									<span class="rCellTl" >
									<html:text property="s6f" size="30" maxlength="50" />
									</span>
								</div>
								<div id="s6_auth" class="qBox">
									<p class="bold"><span class="bold">I, the appellant / representative give authorisation for my sponsor to receive information relating to my appeal if enquiring by phone or writing.</span>
									<p class="bold"><span class="bold">I understand that my sponsor will not be sent any Notices or Decisions relating to my appeal other than a Notice of Hearing.</span>
									<span class="required">*</span></p>
									<span class="lCellTl" > </span>
									<span class="rCellTl" > Yes&nbsp;
									<html:radio property="s6_auth" value="Yes" />
									No&nbsp;
									<html:radio property="s6_auth" value="No" />
									</span>
								</div>
								<div id="s6_notice" class="qBox">
									<p class="bold">Please note that if a sponsor is named in this section, the First-tier Tribunal may write to him / her to ask for confirmation of that person's intention to act as a sponsor.</p>
								</div>
								<html:hidden property="next" value="finish"/>
								<html:hidden property="previous" value="page-7"/>
							</fieldset>
							<div class="submitc">
								<div class="function previous">
									<span class="tl"></span>
									<span class="tr"><span></span></span>
									<a href="previous6?page=7">Previous <span class="access">page</span></a>
									<span class="bl"></span>
									<span class="br"></span>
								</div>
								<img id="progress" src="images/progress/08of08.gif" alt="*" />
								<div class="function next right">
									<span class="tl"></span>
									<span class="tr"><span></span></span>
									<html:submit>Finish</html:submit>
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
