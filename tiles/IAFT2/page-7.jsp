<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<html:xhtml/>
		<div id="Content">
			<div class="holder">
				<div class="steps">
					<h2>Step 7 of 8</h2>
					<div align="right">
						<h3>Your reference: IAFT2-
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
						<h3 id="s5_subtitle">Section 5 &ndash; Representative Details (refer to guidance notes)</h3>
						<html:form action="submission2">
							<fieldset>
								<div  id="s5a" class="qBox">
									<span class="lCellTl">A.&nbsp;Name of Representative <span class="required">*</span></span>
									<span class="rCellTl">
									<html:text property="s5a" styleId="s5a" size="50" maxlength="70" />
									</span>
								</div>
								<div  id="s5b" class="qBox">
									<span class="lCellTl">B.&nbsp;Name of Representative's Organisation (if any) <span class="required">*</span></span>
									<span class="rCellTl">
									<!-- Organisation list updated 021012 -->
									<html:select property="s5b">
										<html:option value ="0">Organisation</html:option>
											<html:option value ="554:A Bajwa and Co Solicitors">A Bajwa &amp; Co Solicitors</html:option>
											<html:option value ="537:A Bajwa And Co">A Bajwa And Co</html:option>
											<html:option value ="1539:A.J. Cram and Co">A.J. Cram &amp; Co</html:option>
											<html:option value ="1499:A.J.A. Solicitors">A.J.A. Solicitors</html:option>
											<html:option value ="5:A.K Action Bureau">A.K Action Bureau</html:option>
											<html:option value ="1503:A.M. Legal Consultants U.K. Ltd">A.M. Legal Consultants U.K. Ltd</html:option>
											<html:option value ="1493:A1 Immigration Services">A1 Immigration Services</html:option>
											<html:option value ="1519:A1 Law Chambers">A1 Law Chambers</html:option>
											<html:option value ="1230:AA Group - Legal Services">AA Group - Legal Services</html:option>
											<html:option value ="1490:AA Immigration Lawyers">AA Immigration Lawyers</html:option>
											<html:option value ="738:Acharyas Solicitors">Acharyas Solicitors</html:option>
											<html:option value ="542:Adams Solicitors">Adams Solicitors</html:option>
											<html:option value ="805:Aden and Co Solicitors">Aden &amp; Co Solicitors</html:option>
											<html:option value ="1186:Advisa Solicitors">Advisa Solicitors</html:option>
											<html:option value ="590:Afrifa And Partners Solicitors">Afrifa And Partners Solicitors</html:option>
											<html:option value ="4:Afro-Asian Advisory Service">Afro-Asian Advisory Service</html:option>
											<html:option value ="1231:AGH Solicitors">AGH Solicitors</html:option>
											<html:option value ="791:Ahmad and Williams">Ahmad &amp; Williams</html:option>
											<html:option value ="1155:AKL Solicitors">AKL Solicitors</html:option>
											<html:option value ="1419:Alam Ahmed Ltd">Alam Ahmed Ltd</html:option>
											<html:option value ="1008:Albany Solicitors">Albany Solicitors</html:option>
											<html:option value ="863:Alfred James Solicitors">Alfred James Solicitors</html:option>
											<html:option value ="1187:Ali Sinclair Solicitors">Ali Sinclair Solicitors</html:option>
											<html:option value ="745:Alsters Kelley Solicitors">Alsters Kelley Solicitors</html:option>
											<html:option value ="1123:Amal Solicitors">Amal Solicitors</html:option>
											<html:option value ="878:Aman Solicitors">Aman Solicitors</html:option>
											<html:option value ="937:Aman Solicitors Advocates">Aman Solicitors Advocates</html:option>
											<html:option value ="1432:Aman Solicitors Advocates (Luton)">Aman Solicitors Advocates (Luton)</html:option>
											<html:option value ="1464:Amirthan and Suresh Solicitors">Amirthan &amp; Suresh Solicitors</html:option>
											<html:option value ="1512:Andrew Williams Solicitors">Andrew Williams Solicitors</html:option>
											<html:option value ="1124:Andrew Williams Solicitors">Andrew Williams Solicitors</html:option>
											<html:option value ="956:Ansari Solicitors">Ansari Solicitors</html:option>
											<html:option value ="2080:Anti Trafficking and Labour">Anti Trafficking and Labour</html:option>
											<html:option value ="679:Antons Solicitors (N8)">Antons Solicitors (N8)</html:option>
											<html:option value ="1403:APP Immigration Advocates LLP">APP Immigration Advocates LLP</html:option>
											<html:option value ="1167:AR Immigration Service (Northampton)">AR Immigration Service (Northampton)</html:option>
											<html:option value ="1045:Arden Solicitors">Arden Solicitors</html:option>
											<html:option value ="1043:Armada Legal Services">Armada Legal Services</html:option>
											<html:option value ="25:Asghar and Co (Southall)">Asghar &amp; Co (Southall)</html:option>
											<html:option value ="2115:ASH Immigration Services">ASH Immigration Services</html:option>
											<html:option value ="929:Ash Norton Solicitors">Ash Norton Solicitors</html:option>
											<html:option value ="1229:Ashfield ILP">Ashfield ILP</html:option>
											<html:option value ="1496:Aston Brooke Solicitors">Aston Brooke Solicitors</html:option>
											<html:option value ="24:Asylum Aid">Asylum Aid</html:option>
											<html:option value ="1190:Atherav and Co Solicitors">Atherav &amp; Co Solicitors</html:option>
											<html:option value ="27:Athuraliyage Solicitors">Athuraliyage Solicitors</html:option>
											<html:option value ="29:Avon and Bristol Community Law Centre">Avon &amp; Bristol Community Law Centre</html:option>
											<html:option value ="1407:B.H.T. Immigration Legal Services">B.H.T. Immigration Legal Services</html:option>
											<html:option value ="1234:Bake and Co Solicitors">Bake &amp; Co Solicitors</html:option>
											<html:option value ="1460:Barar and Associates">Barar &amp; Associates</html:option>
											<html:option value ="1191:Barnes Harrild and Dyer Solicitors">Barnes Harrild &amp; Dyer Solicitors</html:option>
											<html:option value ="187:Barry Clark Solicitors">Barry Clark Solicitors</html:option>
											<html:option value ="436:Bassi Solicitors">Bassi Solicitors</html:option>
											<html:option value ="35:Bates Wells and Braithwate">Bates Wells &amp; Braithwate</html:option>
											<html:option value ="1025:Bedfords Solicitors">Bedfords Solicitors</html:option>
											<html:option value ="1235:Bhattarai and Co Immigration Practice">Bhattarai &amp; Co Immigration Practice</html:option>
											<html:option value ="1085:Bhavsar Patel Solicitors">Bhavsar Patel Solicitors</html:option>
											<html:option value ="1438:Bhogal and Co Solicitors">Bhogal &amp; Co Solicitors</html:option>
											<html:option value ="44:Bhogal Partners Solicitors">Bhogal Partners Solicitors</html:option>
											<html:option value ="850:Binas Solicitors">Binas Solicitors</html:option>
											<html:option value ="50:Bindmans LLP">Bindmans LLP</html:option>
											<html:option value ="751:Birchfields Solicitors">Birchfields Solicitors</html:option>
											<html:option value ="973:Birnberg Peirce and Partners">Birnberg Peirce &amp; Partners</html:option>
											<html:option value ="873:Biscoes Solicitors">Biscoes Solicitors</html:option>
											<html:option value ="1237:Bishop, Lloyd and Jackson Solicitors">Bishop, Lloyd &amp; Jackson Solicitors</html:option>
											<html:option value ="1238:Bison Management UK">Bison Management UK</html:option>
											<html:option value ="845:Blakemores Solicitors">Blakemores Solicitors</html:option>
											<html:option value ="2020:Blackstone Law Associates">Blackstone Law Associates</html:option>
											<html:option value ="1537:Blavo and Co Solicitors (Rivington House)">Blavo &amp; Co Solicitors (Rivington House)</html:option>
											<html:option value ="848:Blavo and Co Solicitors (John Street)">Blavo and Co Solicitors (John Street)</html:option>
											<html:option value ="418:Bradford Law Centre">Bradford Law Centre</html:option>
											<html:option value ="1170:Braitch RB Solicitors">Braitch RB Solicitors</html:option>
											<html:option value ="996:Brar and Co Solicitors">Brar &amp; Co Solicitors</html:option>
											<html:option value ="516:Brighton Housing Trust">Brighton Housing Trust</html:option>
											<html:option value ="1166:British Immigration Advisory Service (Rahman and Hoque)">British Immigration Advisory Service (Rahman &amp; Hoque)</html:option>
											<html:option value ="1177:Bruce Short Solicitors">Bruce Short Solicitors</html:option>
											<html:option value ="1462:Brys Immigration Consultants">Brys Immigration Consultants</html:option>
											<html:option value ="1508:Burney Legal Solicitors">Burney Legal Solicitors</html:option>
											<html:option value ="1347:Burton and Burton Solicitors (Dale Street)">Burton &amp; Burton Solicitors (Dale Street)</html:option>
											<html:option value ="930:Bury Law Centre">Bury Law Centre</html:option>
											<html:option value ="58:Camden Community Law Centre">Camden Community Law Centre</html:option>
											<html:option value ="1479:Cape Hill Solicitors">Cape Hill Solicitors</html:option>
											<html:option value ="1106:Capital Solicitors">Capital Solicitors</html:option>
											<html:option value ="1481:Cardinal Solicitors (Luton)">Cardinal Solicitors (Luton)</html:option>
											<html:option value ="1520:Caroline Mathews Solicitors">Caroline Mathews Solicitors</html:option>
											<html:option value ="55:Central London Law Centre">Central London Law Centre</html:option>
											<html:option value ="1488:Chambers Solicitors (Bradford)">Chambers Solicitors (Bradford)</html:option>
											<html:option value ="14:Charles Annon and Co">Charles Annon &amp; Co</html:option>
											<html:option value ="1158:Charles Hill and Co Solicitors">Charles Hill &amp; Co Solicitors</html:option>
											<html:option value ="673:Charles Simmons Immigration Solicitors">Charles Simmons Immigration Solicitors</html:option>
											<html:option value ="1329:Charles Simmons Solicitors">Charles Simmons Solicitors</html:option>
											<html:option value ="743:Chartwell and Sadlers Solicitors">Chartwell &amp; Sadlers Solicitors</html:option>
											<html:option value ="1465:Chase Legal Services">Chase Legal Services</html:option>
											<html:option value ="1139:Chetna and Co Solicitors">Chetna &amp; Co Solicitors</html:option>
											<html:option value ="667:Chipatiso Associates LLP">Chipatiso Associates LLP</html:option>
											<html:option value ="1090:Chris and Co Solicitors">Chris &amp; Co Solicitors</html:option>
											<html:option value ="808:Christian Gottfried and Co Solicitors">Christian Gottfried &amp; Co Solicitors</html:option>
											<html:option value ="1387:Citizens Advice Bureau (Bolton)">Citizens Advice Bureau (Bolton)</html:option>
											<html:option value ="909:City Legal Partnership">City Legal Partnership</html:option>
											<html:option value ="1367:CK Solicitors">CK Solicitors</html:option>
											<html:option value ="1050:CLC Solicitors">CLC Solicitors</html:option>
											<html:option value ="709:Cleveland and Co Solicitors">Cleveland &amp; Co Solicitors</html:option>
											<html:option value ="932:Clifford Johnston and Co">Clifford Johnston &amp; Co</html:option>
											<html:option value ="1222:Community Law Service (Northampton and County)">Community Law Service (Northampton &amp; County)</html:option>
											<html:option value ="1019:Corban Solicitors">Corban Solicitors</html:option>
											<html:option value ="72:Corbin and Hassan">Corbin &amp; Hassan</html:option>
											<html:option value ="438:Coventry Law Centre">Coventry Law Centre</html:option>
											<html:option value ="1453:Crome Legal Services">Crome Legal Services</html:option>
											<html:option value ="1096:Crowley and Company Solicitors">Crowley &amp; Company Solicitors</html:option>
											<html:option value ="1379:Crown and Mehria Solicitors">Crown &amp; Mehria Solicitors</html:option>
											<html:option value ="79:Crown Legal Advisory Services">Crown Legal Advisory Services</html:option>
											<html:option value ="396:D J Webb and Co">D J Webb &amp; Co</html:option>
											<html:option value ="1174:DandA Solicitors (Formerly Calthorpes)">D&amp;A Solicitors (Formerly Calthorpes)</html:option>
											<html:option value ="1500:Daniel Aramide Solicitors (Upminster Road)">Daniel Aramide Solicitors (Upminster Road)</html:option>
											<html:option value ="910:Danielle Cohen Solicitors">Danielle Cohen Solicitors</html:option>
											<html:option value ="74:Dar and Co Solicitors">Dar &amp; Co Solicitors</html:option>
											<html:option value ="120:David A Grand">David A Grand</html:option>
											<html:option value ="121:David Gray Solicitors">David Gray Solicitors</html:option>
											<html:option value ="367:David Tang and Co">David Tang &amp; Co</html:option>
											<html:option value ="399:David Williams">David Williams</html:option>
											<html:option value ="888:Davies, Blunden and Evans">Davies, Blunden &amp; Evans</html:option>
											<html:option value ="965:Dean Manson Solicitors">Dean Manson Solicitors</html:option>
											<html:option value ="1475:Deccan Prime Solicitors">Deccan Prime Solicitors</html:option>
											<html:option value ="947:Dele Adedeji and Associates Ltd">Dele Adedeji &amp; Associates Ltd</html:option>
											<html:option value ="1518:Denning Solicitors (Barking Road)">Denning Solicitors (Barking Road)</html:option>
											<html:option value ="1342:Diamond Solicitors">Diamond Solicitors</html:option>
											<html:option value ="1192:Dias Solicitors">Dias Solicitors</html:option>
											<html:option value ="623:Dicksons Solicitors">Dicksons Solicitors</html:option>
											<html:option value ="969:Dipak Acharya and Co Solicitors">Dipak Acharya &amp; Co Solicitors</html:option>
											<html:option value ="842:Douglass Simon Solicitors (Brentford)">Douglass Simon Solicitors (Brentford)</html:option>
											<html:option value ="1162:Douglass Simon Solicitors (Earls Court)">Douglass Simon Solicitors (Earls Court)</html:option>
											<html:option value ="632:Drummond Miller (Edinburgh)">Drummond Miller (Edinburgh)</html:option>
											<html:option value ="699:Drummond Miller (Glasgow)">Drummond Miller (Glasgow)</html:option>
											<html:option value ="551:Duncan Lewis and Co Solicitors (Dalston Office)">Duncan Lewis &amp; Co Solicitors (Dalston Office)</html:option>
											<html:option value ="872:Duncan Lewis and Co Solicitors (Harrow Office)">Duncan Lewis &amp; Co Solicitors (Harrow Office)</html:option>
											<html:option value ="1128:Duncan Moghal Solicitors and Advocates (Cardiff)">Duncan Moghal Solicitors &amp; Advocates (Cardiff)</html:option>
											<html:option value ="935:Duncan Moghal Solicitors and Advocates (Newport)">Duncan Moghal Solicitors &amp; Advocates (Newport)</html:option>
											<html:option value ="1502:Duncan Moghal Solicitors (Swansea)">Duncan Moghal Solicitors (Swansea)</html:option>
											<html:option value ="1100:E. Haq and Company">E. Haq &amp; Company</html:option>
											<html:option value ="1449:Eagle Solicitors">Eagle Solicitors</html:option>
											<html:option value ="1022:Ebrahim and Co Solicitors">Ebrahim &amp; Co Solicitors</html:option>
											<html:option value ="757:Elder Rahimi Solicitors (London)">Elder Rahimi Solicitors (London)</html:option>
											<html:option value ="1194:Elizabeth Millar Solicitor">Elizabeth Millar Solicitor</html:option>
											<html:option value ="93:Equalisers Ltd">Equalisers Ltd</html:option>
											<html:option value ="1002:Equity Law Chambers">Equity Law Chambers</html:option>
											<html:option value ="95:Ethnic Minorities Law Centre (Glasgow)">Ethnic Minorities Law Centre (Glasgow)</html:option>
											<html:option value ="1161:Eurasia Legal Services (Birmingham Office)">Eurasia Legal Services (Birmingham Office)</html:option>
											<html:option value ="686:Fadiga and Co">Fadiga &amp; Co</html:option>
											<html:option value ="1443:Farani Taylor Solicitors LLP">Farani Taylor Solicitors LLP</html:option>
											<html:option value ="1470:Farani Taylor Solicitors LLP">Farani Taylor Solicitors LLP</html:option>
											<html:option value ="99:Fisher Meredith">Fisher Meredith</html:option>
											<html:option value ="105:Fletcher Dervish and Co">Fletcher Dervish &amp; Co</html:option>
											<html:option value ="1509:Focus Immigration Services">Focus Immigration Services</html:option>
											<html:option value ="108:Freemans Solicitors">Freemans Solicitors</html:option>
											<html:option value ="862:French and Company">French &amp; Company</html:option>
											<html:option value ="246:Freshlaw Solicitors">Freshlaw Solicitors</html:option>
											<html:option value ="1070:Fursdon Knapper Solicitors (Cambridge)">Fursdon Knapper Solicitors (Cambridge)</html:option>
											<html:option value ="118:G K Associates">G K Associates</html:option>
											<html:option value ="1069:G Singh Solicitors">G Singh Solicitors</html:option>
											<html:option value ="1355:Gans and Co Solicitors LLP">Gans &amp; Co Solicitors LLP</html:option>
											<html:option value ="1051:Geeta Patel and Co Solicitors">Geeta Patel &amp; Co Solicitors</html:option>
											<html:option value ="1451:Genesis Law Associates Ltd">Genesis Law Associates Ltd</html:option>
											<html:option value ="690:Genga and Co Solicitors Ltd">Genga and Co Solicitors Ltd</html:option>
											<html:option value ="110:Gherson and Co">Gherson &amp; Co</html:option>
											<html:option value ="917:Gill Law Chambers">Gill Law Chambers</html:option>
											<html:option value ="683:Gillman-Smith Lee Solicitors">Gillman-Smith Lee Solicitors</html:option>
											<html:option value ="1095:Gills Immigration Law">Gills Immigration Law</html:option>
											<html:option value ="1245:Global Immigration Solutions">Global Immigration Solutions</html:option>
											<html:option value ="433:Gloucester Law Centre">Gloucester Law Centre</html:option>
											<html:option value ="1510:Goldfields Solicitors">Goldfields Solicitors</html:option>
											<html:option value ="1247:Graceland Solicitors (Beresford Square)">Graceland Solicitors (Beresford Square)</html:option>
											<html:option value ="1511:Graceland Solicitors (Lewisham)">Graceland Solicitors (Lewisham)</html:option>
											<html:option value ="126:Gray and Co Solicitors">Gray &amp; Co Solicitors</html:option>
											<html:option value ="1246:Greater London Solicitors">Greater London Solicitors</html:option>
											<html:option value ="127:Greater Manchester Immigration Aid Unit">Greater Manchester Immigration Aid Unit</html:option>
											<html:option value ="762:Greenland Lawyers LLP (London)">Greenland Lawyers LLP (London)</html:option>
											<html:option value ="1053:Gross and Co Solicitors">Gross &amp; Co Solicitors</html:option>
											<html:option value ="128:Gulbenkian Andonian Solicitors">Gulbenkian Andonian Solicitors</html:option>
											<html:option value ="1251:H and M Solicitors">H &amp; M Solicitors</html:option>
											<html:option value ="135:Hackney Law Centre">Hackney Law Centre</html:option>
											<html:option value ="678:Halliday Reeves Law Firm">Halliday Reeves Law Firm</html:option>
											<html:option value ="997:Halliday Reeves Law Firm">Halliday Reeves Law Firm</html:option>
											<html:option value ="755:Hamilton Burns and Co">Hamilton Burns &amp; Co</html:option>
											<html:option value ="137:Hammersmith and Fulham Community Law Centre">Hammersmith &amp; Fulham Community Law Centre</html:option>
											<html:option value ="1532:Hammond Lloyd Legal">Hammond Lloyd Legal</html:option>
											<html:option value ="619:Haq Hamilton Solicitors">Haq Hamilton Solicitors</html:option>
											<html:option value ="1452:Haque and Hausmann Solicitors (Newcastle)">Haque &amp; Hausmann Solicitors (Newcastle)</html:option>
											<html:option value ="1448:Haque and Hausman Solicitors (London)">Haque and Hausman Solicitors (London)</html:option>
											<html:option value ="139:Harbans Singh and Co (Soho Road)">Harbans Singh &amp; Co (Soho Road)</html:option>
											<html:option value ="1521:Harbans Singh and Co Solicitors (391 Soho Road)">Harbans Singh &amp; Co Solicitors (391 Soho Road)</html:option>
											<html:option value ="140:Harehills And Chapeltown Law Centre">Harehills And Chapeltown Law Centre</html:option>
											<html:option value ="1514:Harris Kumar Caleechurn Solicitor">Harris Kumar Caleechurn Solicitor</html:option>
											<html:option value ="141:Harrison Bundey and Co">Harrison Bundey &amp; Co</html:option>
											<html:option value ="605:Harrow Solicitors and Advocates">Harrow Solicitors &amp; Advocates</html:option>
											<html:option value ="833:Hasan Solicitors">Hasan Solicitors</html:option>
											<html:option value ="1337:Heer Manak (Queen Victoria Rd)">Heer Manak (Queen Victoria Rd)</html:option>
											<html:option value ="1250:Heer Manak Solicitors (Foleshill Road)">Heer Manak Solicitors (Foleshill Road)</html:option>
											<html:option value ="149:Henry Hyams and Co">Henry Hyams &amp; Co</html:option>
											<html:option value ="1408:Henshaw Solicitors">Henshaw Solicitors</html:option>
											<html:option value ="1027:Hersi and Co Solicitors">Hersi &amp; Co Solicitors</html:option>
											<html:option value ="1122:Hoole and Co Solicitors (Brighton Street)">Hoole and Co Solicitors (Brighton Street)</html:option>
											<html:option value ="980:Hossain Law Associates">Hossain Law Associates</html:option>
											<html:option value ="485:Howe and Co">Howe &amp; Co</html:option>
											<html:option value ="636:Howells Solicitors LLP">Howells Solicitors LLP</html:option>
											<html:option value ="950:HSBS Law UK Office (Harbans Singh and Balwant Singh)">HSBS Law UK Office (Harbans Singh &amp; Balwant Singh)</html:option>
											<html:option value ="1000:HSK Solicitors (Bolton)">HSK Solicitors (Bolton)</html:option>
											<html:option value ="170:HSK Solicitors (Manchester)">HSK Solicitors (Manchester)</html:option>
											<html:option value ="1516:I E I  Solicitors">I E I  Solicitors</html:option>
											<html:option value ="1111:I I A S (Manchester)">I I A S (Manchester)</html:option>
											<html:option value ="1198:Igor and Co Solicitors">Igor &amp; Co Solicitors</html:option>
											<html:option value ="713:Ikie Solicitors">Ikie Solicitors</html:option>
											<html:option value ="66:Immigration Advice Bureau">Immigration Advice Bureau</html:option>
											<html:option value ="1150:Immigration Advisory Services (Pvt) Ltd">Immigration Advisory Services (Pvt) Ltd</html:option>
											<html:option value ="1253:Immigration Advisory Services (UK) Ltd">Immigration Advisory Services (UK) Ltd</html:option>
											<html:option value ="1065:Immigration Aid">Immigration Aid</html:option>
											<html:option value ="1485:Immigration Chambers">Immigration Chambers</html:option>
											<html:option value ="1450:Immigration Solutions Ltd">Immigration Solutions Ltd</html:option>
											<html:option value ="1373:Immigration Support Agency">Immigration Support Agency</html:option>
											<html:option value ="1200:Immigration4u">Immigration4u</html:option>
											<html:option value ="1201:Imperium Group Immigration Specialists">Imperium Group Immigration Specialists</html:option>
											<html:option value ="990:Indra Sebastian Solicitors">Indra Sebastian Solicitors</html:option>
											<html:option value ="710:Indus Solicitors">Indus Solicitors</html:option>
											<html:option value ="165:International Immigration Advisory Service">International Immigration Advisory Service</html:option>
											<html:option value ="562:Irving And Co">Irving And Co</html:option>
											<html:option value ="179:Ismail and Ghani">Ismail &amp; Ghani</html:option>
											<html:option value ="1471:Issat and Co Solicitors">Issat &amp; Co Solicitors</html:option>
											<html:option value ="1255:Iyama Solicitors">Iyama Solicitors</html:option>
											<html:option value ="807:J D Spicer and Co (87 Kilburn)">J D Spicer &amp; Co (87 Kilburn)</html:option>
											<html:option value ="2071:J McCarthy Solicitors">J McCarthy Solicitors</html:option>
											<html:option value ="449:J M Wilson">J M Wilson</html:option>
											<html:option value ="197:J R Immigration Ltd">J R Immigration Ltd</html:option>
											<html:option value ="707:J R Jones Solicitors (Birmingham)">J R Jones Solicitors (Birmingham)</html:option>
											<html:option value ="1482:J.R. Rahman Solicitors">J.R. Rahman Solicitors</html:option>
											<html:option value ="624:Jackson and Canter Solicitors">Jackson &amp; Canter Solicitors</html:option>
											<html:option value ="1256:Jacobs Solicitors">Jacobs Solicitors</html:option>
											<html:option value ="1369:Jain, Neil and Ruddy Solicitors (Sandyford)">Jain, Neil &amp; Ruddy Solicitors (Sandyford)</html:option>
											<html:option value ="853:Jalalabad Law Associates">Jalalabad Law Associates</html:option>
											<html:option value ="1099:James and Co Solicitors">James &amp; Co Solicitors</html:option>
											<html:option value ="193:Janjua and Associates">Janjua &amp; Associates</html:option>
											<html:option value ="188:Jasvir Jutla and Co">Jasvir Jutla &amp; Co</html:option>
											<html:option value ="1415:JDS Solicitors">JDS Solicitors</html:option>
											<html:option value ="1203:Jein Solicitors">Jein Solicitors</html:option>
											<html:option value ="556:Jeya And Co">Jeya And Co</html:option>
											<html:option value ="1153:Jinnah Solicitors">Jinnah Solicitors</html:option>
											<html:option value ="1257:Joseph Thaliyan Solicitors">Joseph Thaliyan Solicitors</html:option>
											<html:option value ="1224:Joves Solicitors">Joves Solicitors</html:option>
											<html:option value ="1225:Joyya Law Associates">Joyya Law Associates</html:option>
											<html:option value ="1412:K Ravi Solicitors">K Ravi Solicitors</html:option>
											<html:option value ="1445:Kabir Ahmed and Co Solicitors">Kabir Ahmed &amp; Co Solicitors</html:option>
											<html:option value ="1478:Kalam Solicitors">Kalam Solicitors</html:option>
											<html:option value ="1435:Karis Law">Karis Law</html:option>
											<html:option value ="1175:Katani and Co Solicitors">Katani &amp; Co Solicitors</html:option>
											<html:option value ="1068:Kesar and Co Solicitors">Kesar &amp; Co Solicitors</html:option>
											<html:option value ="879:KG Solicitors">KG Solicitors</html:option>
											<html:option value ="1258:Khan and Co Solicitors">Khan &amp; Co Solicitors</html:option>
											<html:option value ="912:Khan Solicitors">Khan Solicitors</html:option>
											<html:option value ="494:Khans Solicitors">Khans Solicitors</html:option>
											<html:option value ="1171:Khirri Solicitors">Khirri Solicitors</html:option>
											<html:option value ="936:Kidd Rapinet Solicitors">Kidd Rapinet Solicitors</html:option>
											<html:option value ="1409:Kingscourt Solicitors">Kingscourt Solicitors</html:option>
											<html:option value ="1207:Kingsley Napley">Kingsley Napley</html:option>
											<html:option value ="1530:Kingswood Solicitors">Kingswood Solicitors</html:option>
											<html:option value ="1102:Kirklees Law Centre">Kirklees Law Centre</html:option>
											<html:option value ="591:Kothala and Co (Harrow Road)">Kothala &amp; Co (Harrow Road)</html:option>
											<html:option value ="1426:Krish Solicitors">Krish Solicitors</html:option>
											<html:option value ="1405:Kuddus Solicitors (Shacklewell Lane)">Kuddus Solicitors (Shacklewell Lane)</html:option>
											<html:option value ="1156:Lambeth Law Centre">Lambeth Law Centre</html:option>
											<html:option value ="1137:Lannex Immigration and Legal Advice Services">Lannex Immigration &amp; Legal Advice Services</html:option>
											<html:option value ="934:Latif Solicitors">Latif Solicitors</html:option>
											<html:option value ="1380:Law and Lawyers Solicitors">Law &amp; Lawyers Solicitors</html:option>
											<html:option value ="1440:Law Centre (NI)">Law Centre (NI)</html:option>
											<html:option value ="1472:Lawmen Solicitors (Station Road)">Lawmen Solicitors (Station Road)</html:option>
											<html:option value ="1120:Lawrence and Associates Solicitors">Lawrence &amp; Associates Solicitors</html:option>
											<html:option value ="858:Lawrence and Co Solicitors">Lawrence &amp; Co Solicitors</html:option>
											<html:option value ="492:Lawrence Lupin Solicitors">Lawrence Lupin Solicitors</html:option>
											<html:option value ="1501:Lee Valley Solicitors">Lee Valley Solicitors</html:option>
											<html:option value ="1473:Legal and Legal Solicitors and Notaries">Legal and Legal Solicitors &amp; Notaries</html:option>
											<html:option value ="1138:Lei Dat and Baig Solicitors">Lei Dat &amp; Baig Solicitors</html:option>
											<html:option value ="694:Leonard and Co Solicitors">Leonard &amp; Co Solicitors</html:option>
											<html:option value ="1389:Leslie Charles Solicitors">Leslie Charles Solicitors</html:option>
											<html:option value ="1513:Liberty and Co  Solicitors">Liberty &amp; Co  Solicitors</html:option>
											<html:option value ="1411:Lin and Co Solicitors">Lin &amp; Co Solicitors</html:option>
											<html:option value ="1431:Lincoln Solicitors">Lincoln Solicitors</html:option>
											<html:option value ="1261:Lincoln's Chambers Solicitors">Lincoln's Chambers Solicitors</html:option>
											<html:option value ="631:Livingstone Brown Solicitors (Carlton Place)">Livingstone Brown Solicitors (Carlton Place)</html:option>
											<html:option value ="1012:London Immigration">London Immigration</html:option>
											<html:option value ="1531:London Law Associates">London Law Associates</html:option>
											<html:option value ="1497:London Law Associates">London Law Associates</html:option>
											<html:option value ="1486:Losanaa and Co">Losanaa &amp; Co</html:option>
											<html:option value ="1456:Loughran and Co">Loughran &amp; Co</html:option>
											<html:option value ="544:Luqmani Thompson and Partners">Luqmani Thompson &amp; Partners</html:option>
											<html:option value ="1315:M A Consultants (Blackburn)">M A Consultants (Blackburn)</html:option>
											<html:option value ="1136:M A Consultants (London)">M A Consultants (London)</html:option>
											<html:option value ="352:M J Solomon and Partners (Commercial Road)">M J Solomon and Partners (Commercial Road)</html:option>
											<html:option value ="1267:M R Laws Solicitors">M R Laws Solicitors</html:option>
											<html:option value ="979:M. Olubi Solicitors">M. Olubi Solicitors</html:option>
											<html:option value ="1505:MAAS">MAAS</html:option>
											<html:option value ="866:Madden and Finucane Solicitors">Madden &amp; Finucane Solicitors</html:option>
											<html:option value ="1526:Maguire Solicitors">Maguire Solicitors</html:option>
											<html:option value ="219:Makanda Bart and Co">Makanda Bart &amp; Co</html:option>
											<html:option value ="1356:Makka Solicitors Ltd">Makka Solicitors Ltd</html:option>
											<html:option value ="660:Malik and Malik">Malik &amp; Malik</html:option>
											<html:option value ="221:Malik Law Chambers Solicitors (Bethnal Green Road)">Malik Law Chambers Solicitors (Bethnal Green Road)</html:option>
											<html:option value ="529:Malik Law Ltd">Malik Law Ltd</html:option>
											<html:option value ="825:Malik Legal Solicitors Ltd">Malik Legal Solicitors Ltd</html:option>
											<html:option value ="1417:Maliks and Khan Solicitors">Maliks and Khan Solicitors</html:option>
											<html:option value ="1210:Manchester Associates">Manchester Associates</html:option>
											<html:option value ="229:Markand and Co">Markand &amp; Co</html:option>
											<html:option value ="941:Marks and Marks Solicitors">Marks &amp; Marks Solicitors</html:option>
											<html:option value ="818:Martin Brennan, LL.B">Martin Brennan, LL.B</html:option>
											<html:option value ="1263:Masud and Co">Masud &amp; Co</html:option>
											<html:option value ="1264:Maya Solicitors">Maya Solicitors</html:option>
											<html:option value ="1316:Mayfair Solicitors">Mayfair Solicitors</html:option>
											<html:option value ="978:McAuley McCarthy and Co">McAuley McCarthy &amp; Co</html:option>
											<html:option value ="1374:McGill and Co (Edinburgh)">McGill &amp; Co (Edinburgh)</html:option>
											<html:option value ="1133:McGill and Co Solicitors (Glasgow)">McGill &amp; Co Solicitors (Glasgow)</html:option>
											<html:option value ="1265:McGrath Immigration Solicitors Partnership">McGrath Immigration Solicitors Partnership</html:option>
											<html:option value ="1433:Melrose Solicitors">Melrose Solicitors</html:option>
											<html:option value ="240:Migrant Advisory and Advocacy Service (MAAS)">Migrant Advisory &amp; Advocacy Service (MAAS)</html:option>
											<html:option value ="1266:Milana Immigration Consultancy">Milana Immigration Consultancy</html:option>
											<html:option value ="783:Miles Hutchinson and Lithgow Solicitors (Middlesborough)">Miles Hutchinson and Lithgow Solicitors (Middlesborough)</html:option>
											<html:option value ="1421:Mitchell Simmonds Solicitors">Mitchell Simmonds Solicitors</html:option>
											<html:option value ="1211:MKM Solicitors">MKM Solicitors</html:option>
											<html:option value ="982:MKS Solicitors">MKS Solicitors</html:option>
											<html:option value ="242:Mohammed and Co">Mohammed &amp; Co</html:option>
											<html:option value ="1428:Monk and Turner Solicitors LLP">Monk &amp; Turner Solicitors LLP</html:option>
											<html:option value ="1423:Moorehouse Solicitors">Moorehouse Solicitors</html:option>
											<html:option value ="1474:Morden Solicitors">Morden Solicitors</html:option>
											<html:option value ="1368:Morgan Dias Immigration Consultants Ltd">Morgan Dias Immigration Consultants Ltd</html:option>
											<html:option value ="592:Morgan Hall Solicitors">Morgan Hall Solicitors</html:option>
											<html:option value ="1468:Morgan Mark Solicitors">Morgan Mark Solicitors</html:option>
											<html:option value ="829:Mountain Partnership Solicitors">Mountain Partnership Solicitors</html:option>
											<html:option value ="854:M-R Solicitors (Larkshall Road)">M-R Solicitors (Larkshall Road)</html:option>
											<html:option value ="1350:Musa Patels Solicitors (Bradford)">Musa Patels Solicitors (Bradford)</html:option>
											<html:option value ="816:Musa Patels Solicitors (Dewsbury)">Musa Patels Solicitors (Dewsbury)</html:option>
											<html:option value ="1553:Mutebuka and Co Immigration Lawyers">Mutebuka &amp; Co Immigration Lawyers</html:option>
											<html:option value ="1130:N.C.Brothers and Co Solicitors">N.C.Brothers &amp; Co Solicitors</html:option>
											<html:option value ="753:Nandy and Co">Nandy &amp; Co</html:option>
											<html:option value ="856:Nasim and Co Solicitors">Nasim &amp; Co Solicitors</html:option>
											<html:option value ="1345:Nationwide Solicitors">Nationwide Solicitors</html:option>
											<html:option value ="1495:Neil Barnes Solicitors">Neil Barnes Solicitors</html:option>
											<html:option value ="864:Newcastle Law Centre">Newcastle Law Centre</html:option>
											<html:option value ="1178:Njomane Immigration Law Practice">Njomane Immigration Law Practice</html:option>
											<html:option value ="1392:Oaks Solicitors (Argo House)">Oaks Solicitors (Argo House)</html:option>
											<html:option value ="986:Oaks Solicitors (Empire Way)">Oaks Solicitors (Empire Way)</html:option>
											<html:option value ="1299:One Immigration (Leicester)">One Immigration (Leicester)</html:option>
											<html:option value ="1146:One Stop Immigration Services">One Stop Immigration Services</html:option>
											<html:option value ="1270:Osmans Solicitors">Osmans Solicitors</html:option>
											<html:option value ="1213:Owoyele Dada and Co Solicitors">Owoyele Dada &amp; Co Solicitors</html:option>
											<html:option value ="383:Ozoran Turkan Solicitors">Ozoran Turkan Solicitors</html:option>
											<html:option value ="712:P. Krama and Co">P. Krama &amp; Co</html:option>
											<html:option value ="789:Palis Solicitors">Palis Solicitors</html:option>
											<html:option value ="273:Pan African Legal Advisory Services">Pan African Legal Advisory Services</html:option>
											<html:option value ="780:Paragon Law">Paragon Law</html:option>
											<html:option value ="756:Parker Rhodes Hickmotts Solicitors">Parker Rhodes Hickmotts Solicitors</html:option>
											<html:option value ="1544:Parker Rhodes Hickmotts Solicitors (Leeds)">Parker Rhodes Hickmotts Solicitors (Leeds)</html:option>
											<html:option value ="1396:Parker Rhodes Hickmotts, (formally Cole and Yousaf Solicitors)">Parker Rhodes Hickmotts, (formally Cole &amp; Yousaf Solicitors)</html:option>
											<html:option value ="744:Patricks Solicitors">Patricks Solicitors</html:option>
											<html:option value ="1524:Paul  K  Nolan and Co">Paul  K  Nolan &amp; Co</html:option>
											<html:option value ="1507:Peer and Co (immigration assist)">Peer and Co (immigration assist)</html:option>
											<html:option value ="281:Perera and Co">Perera &amp; Co</html:option>
											<html:option value ="620:Peter G Farrell Solicitors">Peter G Farrell Solicitors</html:option>
											<html:option value ="781:Peter G Farrell Solicitors">Peter G Farrell Solicitors</html:option>
											<html:option value ="1271:Peter Lock and Company Solicitors">Peter Lock and Company Solicitors</html:option>
											<html:option value ="998:Phoenix Partnership Solicitors">Phoenix Partnership Solicitors</html:option>
											<html:option value ="855:Pickup Scott Solicitors">Pickup Scott Solicitors</html:option>
											<html:option value ="1272:Pillai and Jones Solicitors">Pillai &amp; Jones Solicitors</html:option>
											<html:option value ="1295:Polpitiya and Co Solicitors">Polpitiya &amp; Co Solicitors</html:option>
											<html:option value ="1416:Procol and Candor">Procol &amp; Candor</html:option>
											<html:option value ="1226:Prolegis Solicitors LLP">Prolegis Solicitors LLP</html:option>
											<html:option value ="630:Quinn, Martin and Langan">Quinn, Martin &amp; Langan</html:option>
											<html:option value ="558:R Kiani Solicitors">R Kiani Solicitors</html:option>
											<html:option value ="300:Rafiq Partnership Solicitors">Rafiq Partnership Solicitors</html:option>
											<html:option value ="587:Rahman and Company Solicitors">Rahman &amp; Company Solicitors</html:option>
											<html:option value ="1326:Rai Legal">Rai Legal</html:option>
											<html:option value ="1034:Raj Law Solicitors">Raj Law Solicitors</html:option>
											<html:option value ="301:Raja and Co">Raja &amp; Co</html:option>
											<html:option value ="1476:Rajput Solicitors">Rajput Solicitors</html:option>
											<html:option value ="802:Rashid and Co Solicitors">Rashid &amp; Co Solicitors</html:option>
											<html:option value ="546:Rasiah and Co">Rasiah &amp; Co</html:option>
											<html:option value ="308:Ratna and Co">Ratna &amp; Co</html:option>
											<html:option value ="1484:Ravi Sethi Solicitors">Ravi Sethi Solicitors</html:option>
											<html:option value ="1364:Ravi Solicitors">Ravi Solicitors</html:option>
											<html:option value ="1340:RBM Solicitors">RBM Solicitors</html:option>
											<html:option value ="1397:Regent Associates">Regent Associates</html:option>
											<html:option value ="1115:Regents and Co Solicitors">Regents and Co Solicitors</html:option>
											<html:option value ="1125:Reiss Solicitors">Reiss Solicitors</html:option>
											<html:option value ="1276:Riaz Khan and Co Solicitors">Riaz Khan &amp; Co Solicitors</html:option>
											<html:option value ="1038:Riaz Solicitors">Riaz Solicitors</html:option>
											<html:option value ="1277:Richardson and Co Solicitors">Richardson &amp; Co Solicitors</html:option>
											<html:option value ="1517:Richmond Canter">Richmond Canter</html:option>
											<html:option value ="1334:Riley Hayes and Co Solicitors (Bilston Church St)">Riley Hayes &amp; Co Solicitors (Bilston Church St)</html:option>
											<html:option value ="1349:RKS Solicitors (formerly Rasool and Co)">RKS Solicitors (formerly Rasool &amp; Co)</html:option>
											<html:option value ="1279:Robinson Ravani and Co Solicitors">Robinson Ravani &amp; Co Solicitors</html:option>
											<html:option value ="319:Rochdale Law Centre">Rochdale Law Centre</html:option>
											<html:option value ="1047:Rogerson Galvin Solicitors">Rogerson Galvin Solicitors</html:option>
											<html:option value ="1280:Rozita Hussain Solicitors">Rozita Hussain Solicitors</html:option>
											<html:option value ="285:S C Pelentrides">S C Pelentrides</html:option>
											<html:option value ="754:S J Solicitors">S J Solicitors</html:option>
											<html:option value ="499:S Satha and Co">S Satha &amp; Co</html:option>
											<html:option value ="800:S.S. Basi and Co Solicitors">S.S. Basi &amp; Co Solicitors</html:option>
											<html:option value ="1357:S.Z. Solicitors">S.Z. Solicitors</html:option>
											<html:option value ="1310:Samad and Co Immigration (Witton)">Samad &amp; Co Immigration (Witton)</html:option>
											<html:option value ="1384:Samuel and Co Solicitors (Barking Office)">Samuel &amp; Co Solicitors (Barking Office)</html:option>
											<html:option value ="1282:Samuel Ross Solicitors">Samuel Ross Solicitors</html:option>
											<html:option value ="1494:Sangat Advice Centre">Sangat Advice Centre</html:option>
											<html:option value ="337:Scudamores Solicitors">Scudamores Solicitors</html:option>
											<html:option value ="775:Sehgal and Co">Sehgal &amp; Co</html:option>
											<html:option value ="482:Selva and Co">Selva &amp; Co</html:option>
											<html:option value ="338:Selvarajah and Co">Selvarajah &amp; Co</html:option>
											<html:option value ="1429:Shah Law Chambers">Shah Law Chambers</html:option>
											<html:option value ="340:Shahid Rahman Solicitors">Shahid Rahman Solicitors</html:option>
											<html:option value ="1491:Shahnaz and Partners">Shahnaz &amp; Partners</html:option>
											<html:option value ="335:Shan and Co">Shan &amp; Co</html:option>
											<html:option value ="502:Shanthi and Co">Shanthi &amp; Co</html:option>
											<html:option value ="1413:Sharif and Co Solicitors">Sharif &amp; Co Solicitors</html:option>
											<html:option value ="341:Sheffield Law Centre">Sheffield Law Centre</html:option>
											<html:option value ="1422:Sheirs Solicitors">Sheirs Solicitors</html:option>
											<html:option value ="381:Shoaib Associates">Shoaib Associates</html:option>
											<html:option value ="1360:Silverdale Solicitors">Silverdale Solicitors</html:option>
											<html:option value ="1442:Simman Solicitors">Simman Solicitors</html:option>
											<html:option value ="1037:Singhania and Co Solicitors">Singhania &amp; Co Solicitors</html:option>
											<html:option value ="1283:SMK Solicitors">SMK Solicitors</html:option>
											<html:option value ="521:Soma and Co">Soma &amp; Co</html:option>
											<html:option value ="1489:Sony Sadaf Haroon Solicitors">Sony Sadaf Haroon Solicitors</html:option>
											<html:option value ="943:Souleiman .G.A Solicitors">Souleiman .G.A Solicitors</html:option>
											<html:option value ="355:South Manchester Law Centre">South Manchester Law Centre</html:option>
											<html:option value ="761:South West Law">South West Law</html:option>
											<html:option value ="1391:Southwark Law Centre">Southwark Law Centre</html:option>
											<html:option value ="1284:Sparrow and Trieu Solicitors">Sparrow &amp; Trieu Solicitors</html:option>
											<html:option value ="1498:Springfield Solicitors">Springfield Solicitors</html:option>
											<html:option value ="361:Sri Kanth and Co">Sri Kanth &amp; Co</html:option>
											<html:option value ="362:Sriharans">Sriharans</html:option>
											<html:option value ="1434:St Law Solicitors">St Law Solicitors</html:option>
											<html:option value ="1439:St. Valchikwe Solicitors">St. Valchikwe Solicitors</html:option>
											<html:option value ="994:Steen Bali McSherry">Steen Bali McSherry</html:option>
											<html:option value ="1294:Stephen and Richard Solicitors LLP (Birmingham)">Stephen &amp; Richard Solicitors LLP (Birmingham)</html:option>
											<html:option value ="1223:Stephen and Richard Solicitors LLP (London)">Stephen &amp; Richard Solicitors LLP (London)</html:option>
											<html:option value ="1097:Stephens Scown Solictors LLP">Stephens Scown Solictors LLP</html:option>
											<html:option value ="896:Stevjeme and Co Immigration Law Practice">Stevjeme &amp; Co Immigration Law Practice</html:option>
											<html:option value ="995:Stuart Karatas Solicitors">Stuart Karatas Solicitors</html:option>
											<html:option value ="1333:Stuart Karatas Solicitors (Edmonton)">Stuart Karatas Solicitors (Edmonton)</html:option>
											<html:option value ="247:Stuart Miller and Co">Stuart Miller &amp; Co</html:option>
											<html:option value ="868:Sultan Lloyd Solicitors">Sultan Lloyd Solicitors</html:option>
											<html:option value ="1217:Sunrise Solicitors">Sunrise Solicitors</html:option>
											<html:option value ="881:Suriya and Co Solicitors">Suriya &amp; Co Solicitors</html:option>
											<html:option value ="371:Sutovic and Hartigan">Sutovic &amp; Hartigan</html:option>
											<html:option value ="813:Switalski's Solicitors (Bradford)">Switalski's Solicitors (Bradford)</html:option>
											<html:option value ="1285:Syed Shaheen Solicitors">Syed Shaheen Solicitors</html:option>
											<html:option value ="812:Tahir Solicitors">Tahir Solicitors</html:option>
											<html:option value ="820:Taj Solicitors">Taj Solicitors</html:option>
											<html:option value ="1028:Talat Naveed Solicitors">Talat Naveed Solicitors</html:option>
											<html:option value ="525:Tamil Welfare Association (Romford Road)">Tamil Welfare Association (Romford Road)</html:option>
											<html:option value ="1287:Templeton Legal Services">Templeton Legal Services</html:option>
											<html:option value ="1218:Thakrar and Co Solicitors">Thakrar &amp; Co Solicitors</html:option>
											<html:option value ="793:The Law Partnership Solicitors">The Law Partnership Solicitors</html:option>
											<html:option value ="209:The Legal Resource Partnership">The Legal Resource Partnership</html:option>
											<html:option value ="1148:Theva Solicitors">Theva Solicitors</html:option>
											<html:option value ="810:Thompson and Co Solicitors">Thompson &amp; Co Solicitors</html:option>
											<html:option value ="723:Thornhills Solicitors">Thornhills Solicitors</html:option>
											<html:option value ="1228:Time Solicitors">Time Solicitors</html:option>
											<html:option value ="1319:Times Immigration Consultants Ltd">Times Immigration Consultants Ltd</html:option>
											<html:option value ="1289:TM Legal Services">TM Legal Services</html:option>
											<html:option value ="375:Tower Hamlets Law Centre">Tower Hamlets Law Centre</html:option>
											<html:option value ="1400:Trafford Law Centre">Trafford Law Centre</html:option>
											<html:option value ="677:Trott and Gentry LLP">Trott &amp; Gentry LLP</html:option>
											<html:option value ="1180:TRP Solicitors">TRP Solicitors</html:option>
											<html:option value ="1151:TTS Solicitors">TTS Solicitors</html:option>
											<html:option value ="734:Turpin and Miller Solicitors">Turpin &amp; Miller Solicitors</html:option>
											<html:option value ="1341:Tyndallwoods Solicitors (Priory Queensway)">Tyndallwoods Solicitors (Priory Queensway)</html:option>
											<html:option value ="1469:UK Immigration Law Services Ltd">UK Immigration Law Services Ltd</html:option>
											<html:option value ="1352:UK Migration Lawyers Ltd">UK Migration Lawyers Ltd</html:option>
											<html:option value ="1480:UK Visa and Immigration">UK Visa and Immigration</html:option>
											<html:option value ="1378:Uma Duraisingham Solicitors">Uma Duraisingham Solicitors</html:option>
											<html:option value ="892:Universal Solicitors">Universal Solicitors</html:option>
											<html:option value ="1523:V.M.D. Solicitors">V.M.D. Solicitors</html:option>
											<html:option value ="2019:Vanguard Solicitors">Vanguard Solicitors</html:option>
											<html:option value ="1382:Vasuki Solicitors">Vasuki Solicitors</html:option>
											<html:option value ="1308:Veja and Co Solicitors (Hayes)">Veja &amp; Co Solicitors (Hayes)</html:option>
											<html:option value ="1307:Veja and Co Solicitors (Leics)">Veja &amp; Co Solicitors (Leics)</html:option>
											<html:option value ="1309:Veja and Co Solicitors (Southall)">Veja &amp; Co Solicitors (Southall)</html:option>
											<html:option value ="425:Vincent Buffoni and Co Solicitors">Vincent Buffoni &amp; Co Solicitors</html:option>
											<html:option value ="1168:Vincent Solicitors">Vincent Solicitors</html:option>
											<html:option value ="1540:Virgo Consultancy Services Ltd">Virgo Consultancy Services Ltd</html:option>
											<html:option value ="1504:Visa Direct">Visa Direct</html:option>
											<html:option value ="1467:Visalogic.net">Visalogic.net</html:option>
											<html:option value ="1437:VJ Nathan Solicitors">VJ Nathan Solicitors</html:option>
											<html:option value ="1292:Wai Leung Solicitors">Wai Leung Solicitors</html:option>
											<html:option value ="400:Waran and Co Solicitors (N17)">Waran &amp; Co Solicitors (N17)</html:option>
											<html:option value ="1424:Warnapala and Company">Warnapala &amp; Company</html:option>
											<html:option value ="1377:Watson Ramsbottom Partnership Solicitors">Watson Ramsbottom Partnership Solicitors</html:option>
											<html:option value ="403:Wesley Gryk Solicitors">Wesley Gryk Solicitors</html:option>
											<html:option value ="1535:Whitefield Solicitors Ltd">Whitefield Solicitors Ltd</html:option>
											<html:option value ="749:Wick and Co Solicitors">Wick &amp; Co Solicitors</html:option>
											<html:option value ="406:Wilson Solicitors LLP">Wilson Solicitors LLP</html:option>
											<html:option value ="1381:Wimbledon Solicitors (Balham High Rd)">Wimbledon Solicitors (Balham High Rd)</html:option>
											<html:option value ="1522:Wimbledon Solicitors (Merton Rd)">Wimbledon Solicitors (Merton Rd)</html:option>
											<html:option value ="1414:Wortley Legal Consultants">Wortley Legal Consultants</html:option>
											<html:option value ="1527:Wrightway Solicitors">Wrightway Solicitors</html:option>
											<html:option value ="817:Yaqub and Co Solicitors (Immigration Services)">Yaqub &amp; Co Solicitors (Immigration Services)</html:option>
											<html:option value ="836:YVA Solicitors">YVA Solicitors</html:option>
											<html:option value ="1293:Zacharia and Co Solicitors">Zacharia &amp; Co Solicitors</html:option>
											<html:option value ="1375:Zak Solicitors">Zak Solicitors</html:option>
											<html:option value ="668:Ziadies  Solicitors">Ziadies  Solicitors</html:option>
											<html:option value ="1117:ZSN Immigration Services">ZSN Immigration Services</html:option>
											<html:option value ="00">Other</html:option>
								</html:select>
									</span>
								</div>
								<div class="qBox">
									<span class="lCellTl">B1. If 'Other' please specify</span>
									<span class="rCellTl">
									<html:text property="s5b_other" styleId="s5c" size="50" maxlength="50" />
									</span>
								</div>
								<div  id="s5c" class="qBox">
									<span class="lCellTl">C.&nbsp;Postal address for correspondence <span class="required">*</span></span>
									<span class="rCellTl" ></span>
									<span class="lCellTr" >Line 1:</span>
									<span class="rCellTl">
									<html:text property="s5c_addr1" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 2:</span>
									<span class="rCellTl">
									<html:text property="s5c_addr2" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Line 3:</span>
									<span class="rCellTl">
									<html:text property="s5c_addr3" size="35" maxlength="35" />
									</span>
									<span class="lCellTr" >Country:</span>
									<span class="rCellTl">
									<html:select property="s5c_addr4">
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
									<html:text property="s5c_postcode" size="9" maxlength="9" />
									</span>
								</div>
								<div id="s5d" class="qBox">
									<span class="lCellTl">D.&nbsp;Reference for correspondence</span>
									<span class="rCellTl">
									<html:text property="s5d" styleId="s5d" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s5e" class="qBox">
									<span class="lCellTl">E.&nbsp;Telephone / mobile number</span>
									<span class="rCellTl">
									<html:text property="s5e" styleId="s5e" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s5f" class="qBox">
									<span class="lCellTl">F.&nbsp;Fax number</span>
									<span class="rCellTl">
									<html:text property="s5f" styleId="s5f" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s5g" class="qBox">
									<span class="lCellTl">G.&nbsp;Email address</span>
									<span class="rCellTl">
									<html:text property="s5g" styleId="s5g" size="30" maxlength="50" />
									</span>
								</div>
								<div id="s5h" class="qBox">
									<span class="lCellTl">H.&nbsp;Legal Aid reference number</span>
									<span class="rCellTl">
									<html:text property="s5h" styleId="s5h" size="20" maxlength="20" />
									</span>
								</div>
								<div id="s5i" class="qBox">
									<span class="lCellTl">I.&nbsp;Legal Aid Area</span>
									<span class="rCellTl">
									<html:select property="s5i">
										<html:option value="0">Legal Aid Area</html:option>
										<html:option value="England and Wales">England and Wales</html:option>
										<html:option value="Scotland">Scotland</html:option>
										<html:option value="Northern Ireland">Northern Ireland</html:option>
									</html:select>
									</span>
								</div>
								<div  id="s5_appellant_declaration" class="qBox">
									<h3>Declaration by the appellant</h3>
									<p>If you are the appellant and are completing this form yourself, you must tick the declaration box below.</span><span class="required">*</span></p>
									<p>
										<html:radio property="s5_rep_agreed" styleId="s4_decalaration" value="Appellant_agreed" />
										&nbsp;I, the appellant, believe the facts stated in this appeal form are true.</p>
									<p>If a fee is payable for my appeal, if I have not provided fee payment or payment card details, I undertake to pay the fee in accordance with the instructions I receive from the tribunal. I therefore apply for a Lord Chancellor's Certificate of Fee Satisfaction.</p>
								</div>
								<div  id="s5_declaration"  class="qBox">
									<h3>Declaration by the representative</h3>
									<p>to be completed only when signing on behalf of the person named in Section 1 of this form</span><span class="required">*</span></p>
									<p>
										<html:radio property="s5_rep_agreed" value="Rep_agreed" />
										&nbsp;I, the representative, am giving notice of appeal in accordance with the appellant's instructions and the appellant believes that the facts stated in this appeal form are true.</p>
								</div>
								<h3><strong>Legal Aid</strong></h3>
								<div  id="s5_legalAid" class="qBox">
									<p>I, the representative certify that the appellant is in receipt of Legal Aid and is therefore exempt from paying a fee on this appeal.</p>
									<p>
										<html:checkbox property="rep_sign" value="Agreed" />
										&nbsp;I, the representative, am giving notice of appeal in accordance with the appellant's instructions and the appellant believes that the facts stated in this appeal form are true.</p>
								</div>
								<html:hidden property="next" value="page-8"/>
								<html:hidden property="previous" value="page-6"/>
							</fieldset>
							<div class="submitc">
								<div class="function previous">
									<span class="tl"></span>
									<span class="tr"><span></span></span>
									<a href="previous2?page=6">Previous <span class="access">page</span></a>
									<span class="bl"></span>
									<span class="br"></span>
								</div>
								<img id="progress" src="images/progress/07of08.gif" alt="*" />
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
