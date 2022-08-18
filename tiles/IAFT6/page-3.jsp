<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:xhtml />

<div id="Content">
	<div class="holder">

		<div class="steps">
			<h2>Step 3 of 8</h2>
			<div align="right">
				<h3>
					Your reference: IAFT6-
					<bean:write name="token" scope="session" />
				</h3>
			</div>
		</div>

		<div class="formwrap">
			<span class="tl"></span> <span class="tr"><span></span></span>
			<h3>Appeal To The First&ndash;Tier Tribunal (Immigration And
				Asylum Chamber) Against A Decision Of An Entry Clearance Officer</h3>

			<div class="formcon">
				<div class="edit"></div>

				<logic:present name="errMsg" scope="request">
					<div id="error">
						<div id="message">
							<span id="heading">This page is missing information.
								Please correct following:</span>
							<div id="fields">
								<bean:write name="errMsg" filter="false" />
							</div>
						</div>
					</div>
				</logic:present>

				<p class="question">
					<span class="note">Please note:</span> all questions marked <span
						class="required">*</span> are mandatory.
				</p>

				<h3>Section 2 &ndash; Your ECO Decision (refer to your Notice
					of Decision)</h3>
				<html:form action="submission6">
					<fieldset>


						<div id="s2b" class="qBox">
							<span class="lCellTl">A.&nbsp;Post Reference Number <span
								class="required">*</span></span> <span class="rCellTl"><html:text
									property="s2b" size="25" maxlength="25" /></span>
						</div>

						<div id="s2c" class="qBox">
							<span class="lCellTl">B.&nbsp;Name of decision making Post
								<span class="required">*</span>
							</span> <span class="rCellTl"> <html:select property="s2c"
									styleId="s2c">
									<html:option value="0">Post</html:option>
									<html:option value="420:Abu Dhabi">Abu Dhabi</html:option>
									<html:option value="299:Abuja">Abuja</html:option>
									<html:option value="173:Accra">Accra</html:option>
									<html:option value="124:Addis Ababa">Addis Ababa</html:option>
									<html:option value="3:Algiers (UK Visa Section)">Algiers (UK Visa Section)</html:option>
									<html:option value="231:Almaty">Almaty</html:option>
									<html:option value="230:Amman">Amman</html:option>
									<html:option value="290:Amsterdam (UK Visa Section)">Amsterdam (UK Visa Section)</html:option>
									<html:option value="408:Ankara (Istanbul)">Ankara (Istanbul)</html:option>
									<html:option value="251:Antananarivo (Port Louis)">Antananarivo (Port Louis)</html:option>
									<html:option value="416:Ashgabat">Ashgabat</html:option>
									<html:option value="174:Athens (Nicosia)">Athens (Nicosia)</html:option>
									<html:option value="561:Bahrain (Abu Dhabi)">Bahrain (Abu Dhabi)</html:option>
									<html:option value="20:Baku">Baku</html:option>
									<html:option value="45:Bandar Seri Begawan">Bandar Seri Begawan</html:option>
									<html:option value="401:Bangkok">Bangkok</html:option>
									<html:option value="160:Banjul">Banjul</html:option>
									<html:option value="566:Beijing">Beijing</html:option>
									<html:option value="285:Beira (Pretoria)">Beira (Pretoria)</html:option>
									<html:option value="242:Beirut (Lebanon)">Beirut (Lebanon)</html:option>
									<html:option value="577:Belgrade">Belgrade</html:option>
									<html:option value="163:Berlin (UK Visa Section)">Berlin (UK Visa Section)</html:option>
									<html:option value="75:Bogota">Bogota</html:option>
									<html:option value="358:Bratislava (Warsaw)">Bratislava (Warsaw)</html:option>
									<html:option value="23:Bridgetown (New York)">Bridgetown (New York)</html:option>
									<html:option value="25:Brussels (Paris)">Brussels (Paris)</html:option>
									<html:option value="341:Bucharest">Bucharest</html:option>
									<html:option value="195:Budapest (Warsaw)">Budapest (Warsaw)</html:option>
									<html:option value="7:Buenos Aires (New York)">Buenos Aires (New York)</html:option>
									<html:option value="114:Cairo">Cairo</html:option>
									<html:option value="9:Canberra">Canberra</html:option>
									<html:option value="451:Caracas (New York)">Caracas (New York)</html:option>
									<html:option value="347:Castries (New York)">Castries (New York)</html:option>
									<html:option value="201:Chennai (Madras)">Chennai (Madras)</html:option>
									<html:option value="428:Chicago (New York)">Chicago (New York)</html:option>
									<html:option value="576:Chisinau">Chisinau</html:option>
									<html:option value="571:Chongqing">Chongqing</html:option>
									<html:option value="382:Colombo">Colombo</html:option>
									<html:option value="93:Copenhagen (Stockholm)">Copenhagen (Stockholm)</html:option>
									<html:option value="354:Dakar (Accra)">Dakar (Accra)</html:option>
									<html:option value="397:Damascus (Amman)">Damascus (Amman)</html:option>
									<html:option value="400:Dar Es Salaam (Nairobi)">Dar Es Salaam (Nairobi)</html:option>
									<html:option value="22:Dhaka">Dhaka</html:option>
									<html:option value="340:Doha">Doha</html:option>
									<html:option value="421:Dubai (Abu Dhabi)">Dubai (Abu Dhabi)</html:option>
									<html:option value="207:Dublin">Dublin</html:option>
									<html:option value="399:Dushanbe">Dushanbe</html:option>
									<html:option value="164:Dusseldorf (UK Visa Section)">Dusseldorf (UK Visa Section)</html:option>
									<html:option value="573:Ekaterinburg (Moscow)">Ekaterinburg (Moscow)</html:option>
									<html:option value="356:Freetown (Accra)">Freetown (Accra)</html:option>
									<html:option value="31:Gaborone (Pretoria)">Gaborone (Pretoria)</html:option>
									<html:option value="392:Geneva (Paris)">Geneva (Paris)</html:option>
									<html:option value="190:Georgetown (New York)">Georgetown (New York)</html:option>
									<html:option value="565:Guangzhou">Guangzhou</html:option>
									<html:option value="455:Hanoi (Bangkok)">Hanoi (Bangkok)</html:option>
									<html:option value="465:Harare (Pretoria)">Harare (Pretoria)</html:option>
									<html:option value="89:Havana">Havana</html:option>
									<html:option value="126:Helsinki (Stockholm)">Helsinki (Stockholm)</html:option>
									<html:option value="456:Ho Chi Minh City">Ho Chi Minh City</html:option>
									<html:option value="558:Hong Kong (Manila)">Hong Kong (Manila)</html:option>
									<html:option value="314:Islamabad">Islamabad</html:option>
									<html:option value="414:Istanbul">Istanbul</html:option>
									<html:option value="203:Jakarta">Jakarta</html:option>
									<html:option value="352:Jeddah (Riyadh)">Jeddah (Riyadh)</html:option>
									<html:option value="575:Jerusalem (Amman)">Jerusalem (Amman)</html:option>
									<html:option value="366:Johannesburg">Johannesburg</html:option>
									<html:option value="418:Kampala (Nairobi)">Kampala (Nairobi)</html:option>
									<html:option value="288:Kathmandu (New Delhi)">Kathmandu (New Delhi)</html:option>
									<html:option value="383:Khartoum (Cairo)">Khartoum (Cairo)</html:option>
									<html:option value="419:Kiev">Kiev</html:option>
									<html:option value="345:Kigali (Nairobi)">Kigali (Nairobi)</html:option>
									<html:option value="223:Kingston">Kingston</html:option>
									<html:option value="572:Kinshasa (Nairobi)">Kinshasa (Nairobi)</html:option>
									<html:option value="200:Kolkata (New Delhi)">Kolkata (New Delhi)</html:option>
									<html:option value="254:Kuala Lumpur">Kuala Lumpur</html:option>
									<html:option value="238:Kuwait">Kuwait</html:option>
									<html:option value="29:La Paz (New York)">La Paz (New York)</html:option>
									<html:option value="298:Lagos">Lagos</html:option>
									<html:option value="315:Lahore (Abu Dhabi)">Lahore (Abu Dhabi)</html:option>
									<html:option value="253:Lilongwe (Pretoria)">Lilongwe (Pretoria)</html:option>
									<html:option value="321:Lima (New York)">Lima (New York)</html:option>
									<html:option value="334:Lisbon (Madrid)">Lisbon (Madrid)</html:option>
									<html:option value="437:Los Angeles">Los Angeles</html:option>
									<html:option value="5:Luanda (Pretoria)">Luanda (Pretoria)</html:option>
									<html:option value="464:Lusaka (Pretoria)">Lusaka (Pretoria)</html:option>
									<html:option value="368:Madrid">Madrid</html:option>
									<html:option value="327:Manila">Manila</html:option>
									<html:option value="284:Maputo (Pretoria)">Maputo (Pretoria)</html:option>
									<html:option value="244:Maseru (Pretoria)">Maseru (Pretoria)</html:option>
									<html:option value="385:Mbabane (Pretoria)">Mbabane (Pretoria)</html:option>
									<html:option value="266:Mexico City (New York)">Mexico City (New York)</html:option>
									<html:option value="24:Minsk">Minsk</html:option>
									<html:option value="448:Montevideo (New York)">Montevideo (New York)</html:option>
									<html:option value="342:Moscow">Moscow</html:option>
									<html:option value="199:Mumbai">Mumbai</html:option>
									<html:option value="313:Muscat">Muscat</html:option>
									<html:option value="232:Nairobi">Nairobi</html:option>
									<html:option value="198:New Delhi">New Delhi</html:option>
									<html:option value="439:New York">New York</html:option>
									<html:option value="90:Nicosia">Nicosia</html:option>
									<html:option value="304:Oslo (Stockholm)">Oslo (Stockholm)</html:option>
									<html:option value="53:Ottawa">Ottawa</html:option>
									<html:option value="318:Panama City">Panama City</html:option>
									<html:option value="148:Paris">Paris</html:option>
									<html:option value="564:Phnom Penh (Bangkok)">Phnom Penh (Bangkok)</html:option>
									<html:option value="265:Port Louis">Port Louis</html:option>
									<html:option value="319:Port Moresby">Port Moresby</html:option>
									<html:option value="405:Port Of Spain (New York)">Port Of Spain (New York)</html:option>
									<html:option value="92:Prague (Warsaw)">Prague (Warsaw)</html:option>
									<html:option value="363:Pretoria">Pretoria</html:option>
									<html:option value="110:Quito (New York)">Quito (New York)</html:option>
									<html:option value="280:Rabat">Rabat</html:option>
									<html:option value="49:Rangoon (Bangkok)">Rangoon (Bangkok)</html:option>
									<html:option value="196:Reykjavik (Stockholm)">Reykjavik (Stockholm)</html:option>
									<html:option value="241:Riga (Warsaw)">Riga (Warsaw)</html:option>
									<html:option value="35:Rio De Janeiro">Rio De Janeiro</html:option>
									<html:option value="351:Riyadh">Riyadh</html:option>
									<html:option value="210:Rome">Rome</html:option>
									<html:option value="459:Sana'a (Abu Dhabi)">Sana'a (Abu Dhabi)</html:option>
									<html:option value="67:Santiago (New York)">Santiago (New York)</html:option>
									<html:option value="107:Santo Domingo (New York)">Santo Domingo (New York)</html:option>
									<html:option value="30:Sarajevo">Sarajevo</html:option>
									<html:option value="236:Seoul (Manila)">Seoul (Manila)</html:option>
									<html:option value="74:Shanghai">Shanghai</html:option>
									<html:option value="357:Singapore (Kuala Lumpur)">Singapore (Kuala Lumpur)</html:option>
									<html:option value="250:Skopje">Skopje</html:option>
									<html:option value="46:Sofia (Bucharest)">Sofia (Bucharest)</html:option>
									<html:option value="6:St John's (Bridgetown)">St John's (Bridgetown)</html:option>
									<html:option value="343:St Petersburg (Moscow)">St Petersburg (Moscow)</html:option>
									<html:option value="386:Stockholm">Stockholm</html:option>
									<html:option value="125:Suva">Suva</html:option>
									<html:option value="582:Taipei">Taipei</html:option>
									<html:option value="123:Tallinn (Warsaw)">Tallinn (Warsaw)</html:option>
									<html:option value="449:Tashkent">Tashkent</html:option>
									<html:option value="161:Tbilisi">Tbilisi</html:option>
									<html:option value="206:Tehran (Abu Dhabi)">Tehran (Abu Dhabi)</html:option>
									<html:option value="208:Tel Aviv (Istanbul)">Tel Aviv (Istanbul)</html:option>
									<html:option value="2:Tirana">Tirana</html:option>
									<html:option value="224:Tokyo (Manila)">Tokyo (Manila)</html:option>
									<html:option value="246:Tripoli (Libya)">Tripoli (Libya)</html:option>
									<html:option value="406:Tunis">Tunis</html:option>
									<html:option value="584:UK Visa Section">UK Visa Section</html:option>
									<html:option value="585:UKVS Sheffield">UKVS Sheffield</html:option>
									<html:option value="279:Ulaanbaatar (Beijing)">Ulaanbaatar (Beijing)</html:option>
									<html:option value="262:Valletta (Rome)">Valletta (Rome)</html:option>
									<html:option value="355:Victoria">Victoria</html:option>
									<html:option value="15:Vienna (Warsaw)">Vienna (Warsaw)</html:option>
									<html:option value="248:Vilnius (Warsaw)">Vilnius (Warsaw)</html:option>
									<html:option value="329:Warsaw">Warsaw</html:option>
									<html:option value="293:Wellington (Canberra)">Wellington (Canberra)</html:option>
									<html:option value="286:Windhoek  (Pretoria)">Windhoek  (Pretoria)</html:option>
									<html:option value="51:Yaounde (Accra)">Yaounde (Accra)</html:option>
									<html:option value="8:Yerevan">Yerevan</html:option>
									<html:option value="86:Zagreb (Belgrade)">Zagreb (Belgrade)</html:option>
								</html:select>
							</span>
						</div>
						<div id="s2a" class="qBox">
							<span class="lCellTl">C.&nbsp;Home Office A-N Reference
							</span> <span class="rCellTl"> <html:text
									property="s2a" size="18" maxlength="16" />
							</span>
						</div>
						<div id="s2d" class="qBox">
							<span class="lCellTl">D.&nbsp;Method of service by ECO</span>
							<span class="rCellTl">
								Post&nbsp;<html:radio property="s2d" value="Post" />
								Fax/Personal Service&nbsp;<html:radio property="s2d" value="Fax" />
								Courier&nbsp;<html:radio property="s2d" value="Courier" />
								Other&nbsp;<html:radio property="s2d" styleId="s2d_other" value="Other" />
							</span>
							<span class="lCellTr">Other (Please specify)</span>
							<span class="rCellTl"><html:text property="s2d_other" size="50" maxlength="50" /></span>
						</div>

						<div id="s2e" class="qBox">
							<span class="lCellTl">E.&nbsp;Date you received your Notice of Decision<span class="required">*</span><br />(the date of the decision against which you are appealing)</span>
							<span class="rCellTl">
								<html:select property="s2e_day">
									<html:option value="0">Day</html:option>
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
								 /
								<html:select property="s2e_month">
									<html:option value="0">Month</html:option>
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
								 /
								<html:select property="s2e_year">
									<html:optionsCollection name="CurrentAndTwoFormerYears"	value="yearvalue" label="yearlable" />
								</html:select>
							</span>
						</div>

						<div id="s2i" class="qBox">
							<span class="lCellTl">F.&nbsp;Date of application to Home Office <span class="required">*</span></span>
							<span class="rCellTl">
								<html:select property="s2i_day">
									<html:option value="0">Day</html:option>
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
								 /
								<html:select property="s2i_month">
									<html:option value="0">Month</html:option>
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
								 /
								<html:select property="s2i_year">
									<html:optionsCollection name="CurrentAndTwoFormerYears"	value="yearvalue" label="yearlable" />
								</html:select>
							</span>
						</div>
						<div id="s2f" class="qBox">
							<span class="lCellTl">G.&nbsp;Date of ECO Decision <span class="required">*</span></span>
							<span class="rCellTl">
								<html:select property="s2f_day">
									<html:option value="0">Day</html:option>
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
								 /
								<html:select property="s2f_month">
									<html:option value="0">Month</html:option>
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
								 /
								<html:select property="s2f_year">
									<html:optionsCollection name="CurrentAndTwoFormerYears"	value="yearvalue" label="yearlable" />
								</html:select>
							</span>
						</div>

						<h3 id="anonymity">Applying for Anonymity</h3>
						<span id="s2e" class="qBox">
							<p>The tribunal will publish your name on documents relating
								to your case which can be viewed publicly. You can apply to
								the tribunal for anonymity which, when granted, will result in
								the tribunal removing your name from all published documents.</p>
							<p>
								The Application for Anonymity form can be found online at <a
									href="http://www.justice.gov.uk/guidance/courts-and-tribunals/tribunals/immigration-and-asylum/first-tier/faq.htm#FAQ21"
									target="_blank"
									title="Please note: this link will open in a new browser tab or window.">www.tribunals.gov.uk/ImmigrationAsylum/FormsGuidance/FormsGuidance.htm</a>
							</p>
						</span>
					</fieldset>

					<html:hidden property="next" value="page-4" />
					<html:hidden property="previous" value="page-2" />

					<div class="submitc">
						<div class="function previous">
							<span class="tl"></span> <span class="tr"><span></span></span> <a
								href="previous6?page=2">Previous <span class="access">page</span></a>
							<span class="bl"></span> <span class="br"></span>
						</div>
						<img id="progress" src="images/progress/03of08.gif" alt="*" />
						<div class="function next right">
							<span class="tl"></span> <span class="tr"><span></span></span>
							<html:submit>Save & Next</html:submit>
							<span class="bl"></span> <span class="br"></span>
						</div>
					</div>

				</html:form>
				<span class="bl"></span> <span class="br"></span>
			</div>
		</div>
	</div>
</div>
