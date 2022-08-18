<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<html:xhtml/>
		<div id="Content">
			<div class="holder">
				<div class="steps">
					<h2>Step 2 of 8</h2>
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
						<h3>Section 1 &ndash; Personal Information</h3>
						<html:form action="submission6">
							<fieldset>
								<div id="s1a" class="qBox">
									<span class="lCellTl">A.&nbsp;Family Name or Surname<span class="required">*</span><br />
									(As shown on your passport)</span>
									<span class="rCellTl">
									<html:text property="s1a" size="35" maxlength="35" />
									</span>
								</div>
								<div id="s1b" class="qBox">
									<span class="lCellTl">B.&nbsp;Given or First Name(s)<span class="required">*</span><br />
									(As shown on your passport)</span>
									<span class="rCellTl">
									<html:text property="s1b" size="35" maxlength="35" />
									</span>
								</div>
								<div id="s1c" class="qBox">
									<span class="lCellTl">C.&nbsp;Title (Mr / Mrs / Miss / Ms or Other) <span class="required">*</span></span>
									<span class="rCellTl">
									<html:text property="s1c" size="20" maxlength="20" />
									</span>
								</div>
								</ol>
								<div id="s1d" class="qBox">
									<span class="lCellTl">D.&nbsp;Date of birth <span class="required">*</span></span>
									<span class="rCellTl">
									<html:select property="s1d_dob_day">
										<html:option value="0" >Day</html:option>
										<html:option value="1">01</html:option>
										<html:option value="2">02</html:option>
										<html:option value="3">03</html:option>
										<html:option value="4">04</html:option>
										<html:option value="5">05</html:option>
										<html:option value="6">06</html:option>
										<html:option value="7">07</html:option>
										<html:option value="8">08</html:option>
										<html:option value="9">09</html:option>
										<html:option value="10">10</html:option>
										<html:option value="11">11</html:option>
										<html:option value="12">12</html:option>
										<html:option value="13">13</html:option>
										<html:option value="14">14</html:option>
										<html:option value="15">15</html:option>
										<html:option value="16">16</html:option>
										<html:option value="17">17</html:option>
										<html:option value="18">18</html:option>
										<html:option value="19">19</html:option>
										<html:option value="20">20</html:option>
										<html:option value="21">21</html:option>
										<html:option value="22">22</html:option>
										<html:option value="23">23</html:option>
										<html:option value="24">24</html:option>
										<html:option value="25">25</html:option>
										<html:option value="26">26</html:option>
										<html:option value="27">27</html:option>
										<html:option value="28">28</html:option>
										<html:option value="29">29</html:option>
										<html:option value="30">30</html:option>
										<html:option value="31">31</html:option>
									</html:select>
									&nbsp;/&nbsp;
									<html:select property="s1d_dob_month">
										<html:option value="0" > Month</html:option>
										<html:option value="1">01</html:option>
										<html:option value="2">02</html:option>
										<html:option value="3">03</html:option>
										<html:option value="4">04</html:option>
										<html:option value="5">05</html:option>
										<html:option value="6">06</html:option>
										<html:option value="7">07</html:option>
										<html:option value="8">08</html:option>
										<html:option value="9">09</html:option>
										<html:option value="10">10</html:option>
										<html:option value="11">11</html:option>
										<html:option value="12">12</html:option>
									</html:select>
									&nbsp;/&nbsp;
									<html:select property="s1d_dob_year" >
										<html:option value="0" >Year</html:option>
										<html:option value ="1911">1911</html:option>
										<html:option value ="1912">1912</html:option>
										<html:option value ="1913">1913</html:option>
										<html:option value ="1914">1914</html:option>
										<html:option value ="1915">1915</html:option>
										<html:option value ="1916">1916</html:option>
										<html:option value ="1917">1917</html:option>
										<html:option value ="1918">1918</html:option>
										<html:option value ="1919">1919</html:option>
										<html:option value ="1920">1920</html:option>
										<html:option value ="1921">1921</html:option>
										<html:option value ="1922">1922</html:option>
										<html:option value ="1923">1923</html:option>
										<html:option value ="1924">1924</html:option>
										<html:option value ="1925">1925</html:option>
										<html:option value ="1926">1926</html:option>
										<html:option value ="1927">1927</html:option>
										<html:option value ="1928">1928</html:option>
										<html:option value ="1929">1929</html:option>
										<html:option value ="1930">1930</html:option>
										<html:option value ="1931">1931</html:option>
										<html:option value ="1932">1932</html:option>
										<html:option value ="1933">1933</html:option>
										<html:option value ="1934">1934</html:option>
										<html:option value ="1935">1935</html:option>
										<html:option value ="1936">1936</html:option>
										<html:option value ="1937">1937</html:option>
										<html:option value ="1938">1938</html:option>
										<html:option value ="1939">1939</html:option>
										<html:option value ="1940">1940</html:option>
										<html:option value ="1941">1941</html:option>
										<html:option value ="1942">1942</html:option>
										<html:option value ="1943">1943</html:option>
										<html:option value ="1944">1944</html:option>
										<html:option value ="1945">1945</html:option>
										<html:option value ="1946">1946</html:option>
										<html:option value ="1947">1947</html:option>
										<html:option value ="1948">1948</html:option>
										<html:option value ="1949">1949</html:option>
										<html:option value ="1950">1950</html:option>
										<html:option value ="1951">1951</html:option>
										<html:option value ="1952">1952</html:option>
										<html:option value ="1953">1953</html:option>
										<html:option value ="1954">1954</html:option>
										<html:option value ="1955">1955</html:option>
										<html:option value ="1956">1956</html:option>
										<html:option value ="1957">1957</html:option>
										<html:option value ="1958">1958</html:option>
										<html:option value ="1959">1959</html:option>
										<html:option value ="1960">1960</html:option>
										<html:option value ="1961">1961</html:option>
										<html:option value ="1962">1962</html:option>
										<html:option value ="1963">1963</html:option>
										<html:option value ="1964">1964</html:option>
										<html:option value ="1965">1965</html:option>
										<html:option value ="1966">1966</html:option>
										<html:option value ="1967">1967</html:option>
										<html:option value ="1968">1968</html:option>
										<html:option value ="1969">1969</html:option>
										<html:option value ="1970">1970</html:option>
										<html:option value ="1971">1971</html:option>
										<html:option value ="1972">1972</html:option>
										<html:option value ="1973">1973</html:option>
										<html:option value ="1974">1974</html:option>
										<html:option value ="1975">1975</html:option>
										<html:option value ="1976">1976</html:option>
										<html:option value ="1977">1977</html:option>
										<html:option value ="1978">1978</html:option>
										<html:option value ="1979">1979</html:option>
										<html:option value ="1980">1980</html:option>
										<html:option value ="1981">1981</html:option>
										<html:option value ="1982">1982</html:option>
										<html:option value ="1983">1983</html:option>
										<html:option value ="1984">1984</html:option>
										<html:option value ="1985">1985</html:option>
										<html:option value ="1986">1986</html:option>
										<html:option value ="1987">1987</html:option>
										<html:option value ="1988">1988</html:option>
										<html:option value ="1989">1989</html:option>
										<html:option value ="1990">1990</html:option>
										<html:option value ="1991">1991</html:option>
										<html:option value ="1992">1992</html:option>
										<html:option value ="1993">1993</html:option>
										<html:option value ="1994">1994</html:option>
										<html:option value ="1995">1995</html:option>
										<html:option value ="1996">1996</html:option>
										<html:option value ="1997">1997</html:option>
										<html:option value ="1998">1998</html:option>
										<html:option value ="1999">1999</html:option>
										<html:option value ="2000">2000</html:option>
										<html:option value ="2001">2001</html:option>
										<html:option value ="2002">2002</html:option>
										<html:option value ="2003">2003</html:option>
										<html:option value ="2004">2004</html:option>
										<html:option value ="2005">2005</html:option>
										<html:option value ="2006">2006</html:option>
										<html:option value ="2007">2007</html:option>
										<html:option value ="2008">2008</html:option>
										<html:option value ="2009">2009</html:option>
										<html:option value ="2010">2010</html:option>
										<html:option value ="2011">2011</html:option>
										<html:option value ="2012">2012</html:option>
										<html:option value ="2013">2013</html:option>
										<html:option value ="2014">2014</html:option>
										<html:option value ="2015">2015</html:option>
										<html:option value ="2016">2016</html:option>
										<html:option value ="2017">2017</html:option>
										<html:option value ="2018">2018</html:option>
										<html:option value ="2019">2019</html:option>
										<html:option value ="2020">2020</html:option>
									</html:select>
									</span>
								</div>
								<div id="s1e" class="qBox">
									<span class="lCellTl">E.&nbsp;Gender <span class="required">*</span></span>
									<span class="rCellTl"> Male&nbsp;
									<html:radio property="s1e" value="Male" />
									Female&nbsp;
									<html:radio property="s1e" value="Female" />
									</span>
								</div>
								<div id="s1f" class="qBox">
									<span class="lCellTl" >F.&nbsp;Your address or an address where you can be contacted, including the country. <span class="required">*</span></span>
									<span class="rCellTl" ></span>
									<span class="lCellTr" >Line 1:</span>
									<span class="rCellTl" >
									<html:text property="s1f_addr1" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 2:</span>
									<span class="rCellTl" >
									<html:text property="s1f_addr2" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 3:</span>
									<span class="rCellTl" >
									<html:text property="s1f_addr3" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Country:</span>
									<span class="rCellTl" >
									<html:select property="s1f_addr4">
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
									<span class="rCellTl">
									<html:text property="s1f_postcode" styleId="s1f_pcode" size="9" maxlength="9" />
									</span>
									<span class="lCellTr">Email Address:</span>
									<span class="rCellTl">
									<html:text property="s1f_email" size="35" maxlength="254" />
									</span>


									<p><span class="note">If you change your address, you must notify the Tribunal immediately in writing.</span></p>
								</div>
								<div id="s1g" class="qBox">
									<span class="lCellTl">G.&nbsp;Nationality <span class="required">*</span></span>
									<span class="rCellTl" >
									<html:select  property="s1g" >
										<html:option value="0">Nationality</html:option>
										<html:option value ="1:Afghan">Afghan</html:option>
										<html:option value ="2:Albanian">Albanian</html:option>
										<html:option value ="3:Algerian">Algerian</html:option>
										<html:option value ="4:Andorran">Andorran</html:option>
										<html:option value ="5:Angolan">Angolan</html:option>
										<html:option value ="6:Antiguan and Barbudan">Antiguan and Barbudan</html:option>
										<html:option value ="7:Argentine">Argentine</html:option>
										<html:option value ="8:Armenian">Armenian</html:option>
										<html:option value ="9:Australian">Australian</html:option>
										<html:option value ="10:Austrian">Austrian</html:option>
										<html:option value ="11:Azerbaijani">Azerbaijani</html:option>
										<html:option value ="12:Bahamian">Bahamian</html:option>
										<html:option value ="189:Bahraini">Bahraini</html:option>
										<html:option value ="13:Bangladeshi">Bangladeshi</html:option>
										<html:option value ="14:Barbadian">Barbadian</html:option>
										<html:option value ="16:Belgian">Belgian</html:option>
										<html:option value ="17:Belizean">Belizean</html:option>
										<html:option value ="15:Belorussian">Belorussian</html:option>
										<html:option value ="18:Beninese">Beninese</html:option>
										<html:option value ="19:Bolivian">Bolivian</html:option>
										<html:option value ="20:Bosnia and Herzegovinian">Bosnia and Herzegovinian</html:option>
										<html:option value ="21:Botswanan">Botswanan</html:option>
										<html:option value ="22:Brazilian">Brazilian</html:option>
										<html:option value ="188:British">British</html:option>
										<html:option value ="196:British Overseas Citizen">British Overseas Citizen</html:option>
										<html:option value ="23:Bruneian">Bruneian</html:option>
										<html:option value ="24:Bulgarian">Bulgarian</html:option>
										<html:option value ="25:Burkinan">Burkinan</html:option>
										<html:option value ="26:Burmese">Burmese</html:option>
										<html:option value ="27:Burundi">Burundi</html:option>
										<html:option value ="190:Cambodian">Cambodian</html:option>
										<html:option value ="28:Cameroonian">Cameroonian</html:option>
										<html:option value ="29:Canadian">Canadian</html:option>
										<html:option value ="30:Cape Verdean">Cape Verdean</html:option>
										<html:option value ="31:Citizen of Central African Republic">Central African Republic, Citizen of</html:option>
										<html:option value ="32:Chadian">Chadian</html:option>
										<html:option value ="33:Chilean">Chilean</html:option>
										<html:option value ="34:Chinese">Chinese</html:option>
										<html:option value ="35:Colombian">Colombian</html:option>
										<html:option value ="36:Comoran">Comoran</html:option>
										<html:option value ="37:Congolese">Congolese</html:option>
										<html:option value ="38:Costa Rican">Costa Rican</html:option>
										<html:option value ="40:Croatian">Croatian</html:option>
										<html:option value ="41:Cuban">Cuban</html:option>
										<html:option value ="42:Cypriot">Cypriot</html:option>
										<html:option value ="43:Czech">Czech</html:option>
										<html:option value ="44:Danish">Danish</html:option>
										<html:option value ="45:Djiboutian">Djiboutian</html:option>
										<html:option value ="46:Dominican">Dominican</html:option>
										<html:option value ="47:Citizen of Dominican Republic">Dominican Republic, Citizen of</html:option>
										<html:option value ="199:DRC National">DRC National</html:option>
										<html:option value ="119:Dutch">Dutch</html:option>
										<html:option value ="204:East Timorese">East Timorese</html:option>
										<html:option value ="48:Ecuadorean">Ecuadorean</html:option>
										<html:option value ="49:Egyptian">Egyptian</html:option>
										<html:option value ="51:Equatorial Guinean">Equatorial Guinean</html:option>
										<html:option value ="52:Eritrean">Eritrean</html:option>
										<html:option value ="53:Estonian">Estonian</html:option>
										<html:option value ="54:Ethiopian">Ethiopian</html:option>
										<html:option value ="55:Citizen of Fiji">Fiji, Citizen of</html:option>
										<html:option value ="56:Finnish">Finnish</html:option>
										<html:option value ="57:French">French</html:option>
										<html:option value ="58:Gabonese">Gabonese</html:option>
										<html:option value ="59:Gambian">Gambian</html:option>
										<html:option value ="60:Georgian">Georgian</html:option>
										<html:option value ="61:German">German</html:option>
										<html:option value ="62:Ghanaian">Ghanaian</html:option>
										<html:option value ="63:Greek">Greek</html:option>
										<html:option value ="64:Grenadian">Grenadian</html:option>
										<html:option value ="65:Guatemalan">Guatemalan</html:option>
										<html:option value ="67:Citizen of Guinea Bissau">Guinea Bissau, Citizen of</html:option>
										<html:option value ="66:Guinean">Guinean</html:option>
										<html:option value ="68:Guyanese">Guyanese</html:option>
										<html:option value ="69:Haitian">Haitian</html:option>
										<html:option value ="71:Honduran">Honduran</html:option>
										<html:option value ="72:Hungarian">Hungarian</html:option>
										<html:option value ="73:Icelandic">Icelandic</html:option>
										<html:option value ="74:Indian">Indian</html:option>
										<html:option value ="75:Indonesian">Indonesian</html:option>
										<html:option value ="76:Iranian">Iranian</html:option>
										<html:option value ="191:Iraqi">Iraqi</html:option>
										<html:option value ="78:Israeli">Israeli</html:option>
										<html:option value ="79:Italian">Italian</html:option>
										<html:option value ="187:Ivorian">Ivorian</html:option>
										<html:option value ="80:Jamaican">Jamaican</html:option>
										<html:option value ="81:Japanese">Japanese</html:option>
										<html:option value ="83:Jordanian">Jordanian</html:option>
										<html:option value ="84:Kazakh">Kazakh</html:option>
										<html:option value ="85:Kenyan">Kenyan</html:option>
										<html:option value ="86:Citizen of Kiribati">Kiribati, Citizen of</html:option>
										<html:option value ="213:Kosovan">Kosovan</html:option>
										<html:option value ="88:Kuwaiti">Kuwaiti</html:option>
										<html:option value ="89:Kyrgyz">Kyrgyz</html:option>
										<html:option value ="90:Laotian">Laotian</html:option>
										<html:option value ="91:Latvian">Latvian</html:option>
										<html:option value ="92:Lebanese">Lebanese</html:option>
										<html:option value ="93:Citizen of Lesotho">Lesotho, Citizen of</html:option>
										<html:option value ="94:Liberian">Liberian</html:option>
										<html:option value ="95:Libyan">Libyan</html:option>
										<html:option value ="96:Liechtenstein Citizen">Liechtenstein Citizen</html:option>
										<html:option value ="97:Lithuanian">Lithuanian</html:option>
										<html:option value ="98:Luxambourger">Luxambourger</html:option>
										<html:option value ="99:Macedonian">Macedonian</html:option>
										<html:option value ="100:Citizen of Madagascar">Madagascar, Citizen of</html:option>
										<html:option value ="101:Malawian">Malawian</html:option>
										<html:option value ="102:Malaysian">Malaysian</html:option>
										<html:option value ="103:Maldivian">Maldivian</html:option>
										<html:option value ="104:Malian">Malian</html:option>
										<html:option value ="105:Maltese">Maltese</html:option>
										<html:option value ="106:Marshall Islander">Marshall Islander</html:option>
										<html:option value ="107:Mauritanian">Mauritanian</html:option>
										<html:option value ="108:Mauritian">Mauritian</html:option>
										<html:option value ="109:Mexican">Mexican</html:option>
										<html:option value ="110:Micronesian">Micronesian</html:option>
										<html:option value ="111:Moldovan">Moldovan</html:option>
										<html:option value ="112:Monegasque">Monegasque</html:option>
										<html:option value ="113:Mongolian">Mongolian</html:option>
										<html:option value ="209:Montenegrin">Montenegrin</html:option>
										<html:option value ="114:Moroccan">Moroccan</html:option>
										<html:option value ="115:Mozambican">Mozambican</html:option>
										<html:option value ="116:Namibian">Namibian</html:option>
										<html:option value ="117:Nauruan">Nauruan</html:option>
										<html:option value ="118:Nepalese">Nepalese</html:option>
										<html:option value ="120:New Zealander">New Zealander</html:option>
										<html:option value ="121:Nicaraguan">Nicaraguan</html:option>
										<html:option value ="122:Citizen of Niger">Niger, Citizen of</html:option>
										<html:option value ="123:Nigerian">Nigerian</html:option>
										<html:option value ="206:North Korean">North Korean</html:option>
										<html:option value ="124:Norwegian">Norwegian</html:option>
										<html:option value ="125:Omani">Omani</html:option>
										<html:option value ="126:Pakistani">Pakistani</html:option>
										<html:option value ="127:Palauan">Palauan</html:option>
										<html:option value ="128:Panamanian">Panamanian</html:option>
										<html:option value ="129:Papua New Guinean">Papua New Guinean</html:option>
										<html:option value ="130:Paraguaran">Paraguaran</html:option>
										<html:option value ="131:Peruvian">Peruvian</html:option>
										<html:option value ="132:Philippine">Philippine</html:option>
										<html:option value ="133:Polish">Polish</html:option>
										<html:option value ="134:Portuguese">Portuguese</html:option>
										<html:option value ="135:Qatari">Qatari</html:option>
										<html:option value ="136:Romanian">Romanian</html:option>
										<html:option value ="137:Russian">Russian</html:option>
										<html:option value ="138:Rwandan">Rwandan</html:option>
										<html:option value ="202:Saharan">Saharan</html:option>
										<html:option value ="50:Salvadorean">Salvadorean</html:option>
										<html:option value ="181:Samoan">Samoan</html:option>
										<html:option value ="142:Citizen of San Marino">San Marino, Citizen of</html:option>
										<html:option value ="143:Citizen of Sao Tome and Principe">Sao Tome and Principe, Citizen of</html:option>
										<html:option value ="144:Saudi Arabian">Saudi Arabian</html:option>
										<html:option value ="145:Senegalese">Senegalese</html:option>
										<html:option value ="208:Serb">Serb</html:option>
										<html:option value ="146:Seychelles, Citizen of">Seychelles, Citizen of</html:option>
										<html:option value ="147:Sierra Leonean">Sierra Leonean</html:option>
										<html:option value ="148:Singaporean">Singaporean</html:option>
										<html:option value ="149:Slovak">Slovak</html:option>
										<html:option value ="150:Slovenian">Slovenian</html:option>
										<html:option value ="151:Solomon Islander">Solomon Islander</html:option>
										<html:option value ="152:Somali">Somali</html:option>
										<html:option value ="153:South African">South African</html:option>
										<html:option value ="87:South Korean">South Korean</html:option>
										<html:option value ="154:Spanish">Spanish</html:option>
										<html:option value ="155:Sri Lankan">Sri Lankan</html:option>
										<html:option value ="139:Citizen of St Kitts and Nevis">St Kitts and Nevis, Citizen of</html:option>
										<html:option value ="140:St Lucian">St Lucian</html:option>
										<html:option value ="211:Stateless">Stateless</html:option>
										<html:option value ="156:Sudanese">Sudanese</html:option>
										<html:option value ="157:Surinamese">Surinamese</html:option>
										<html:option value ="158:Swazi">Swazi</html:option>
										<html:option value ="159:Swedish">Swedish</html:option>
										<html:option value ="160:Swiss">Swiss</html:option>
										<html:option value ="161:Syrian">Syrian</html:option>
										<html:option value ="212:Taiwanese">Taiwanese</html:option>
										<html:option value ="162:Tajik">Tajik</html:option>
										<html:option value ="163:Tanzanian">Tanzanian</html:option>
										<html:option value ="164:Thai">Thai</html:option>
										<html:option value ="77:Citizen of The Irish Republic">The Irish Republic, Citizen of</html:option>
										<html:option value ="174:Citizen of The United Arab Emirates">The United Arab Emirates, Citizen of</html:option>
										<html:option value ="165:Togolese">Togolese</html:option>
										<html:option value ="166:Tongan">Tongan</html:option>
										<html:option value ="167:Trinidad and Tobago Citizen">Trinidad and Tobago Citizen</html:option>
										<html:option value ="168:Tunisian">Tunisian</html:option>
										<html:option value ="169:Turkish">Turkish</html:option>
										<html:option value ="170:Turkmen">Turkmen</html:option>
										<html:option value ="171:Tuvaluan">Tuvaluan</html:option>
										<html:option value ="172:Ugandan">Ugandan</html:option>
										<html:option value ="173:Ukrainian">Ukrainian</html:option>
										<html:option value ="175:United States Citizen">United States Citizen</html:option>
										<html:option value ="176:Uruguayan">Uruguayan</html:option>
										<html:option value ="177:Uzbek">Uzbek</html:option>
										<html:option value ="178:Citizen of Vanuatu">Vanuatu, Citizen of</html:option>
										<html:option value ="179:Venezuelan">Venezuelan</html:option>
										<html:option value ="180:Vietnamese">Vietnamese</html:option>
										<html:option value ="141:Vincentian">Vincentian</html:option>
										<html:option value ="182:Yemeni">Yemeni</html:option>
										<html:option value ="185:Zambian">Zambian</html:option>
										<html:option value ="186:Zimbabwean">Zimbabwean</html:option>
									</html:select>
									</span>
								</div>
								<html:hidden property="next" value="page-3"/>
								<html:hidden property="previous" value="page-1"/>
							</fieldset>
							<div class="submitc">
								<div class="function previous">
									<span class="tl"></span>
									<span class="tr"><span></span></span>
									<a href="previous6?page=1">Previous <span class="access">page</span></a>
									<span class="bl"></span>
									<span class="br"></span>
								</div>
								<img id="progress" src="images/progress/02of08.gif" alt="*" />
								<div class="function next right">
									<span class="tl"></span>
									<span class="tr"><span></span></span>
									<html:submit>Save & Next</html:submit>
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
