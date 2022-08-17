<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<div id="Content">
			<div class="holder">

				<div class="steps">
					<h2>Success</h2>
					<div align="right">
						<h3>Security Token : IAFT1-
							<bean:write name="token" scope="session"/>
						</h3>
					</div>
				</div>
				<div class="formwrap">
					<span class="tl"></span>
					<span class="tr"><span></span></span>

					<h3>Appeal to the First&ndash;Tier Tribunal (Immigration and Asylum Chamber) against an in country
					 <logic:present name="frmHeader" scope="session">
					 <bean:write name="frmHeader" scope="session"/> 
					 </logic:present>
					 decision</h3>
					
					
					<div class="formcon">
						<div class="edit">
							<div class="function right">
								<span class="tl"></span>
								<span class="tr"><span></span></span>
								<span class="bl"></span>
								<span class="br"></span>
							</div>
						</div>

						<div>
							<p>Which of the following would you like to do?</p>
							<div class="button"><a href="../options.jsp">Lodge another appeal</a></div><p>
							<div class="button"><a href="http://localhost:8080/IACFees/welcome.do">Pay for the appeal(s) you have already lodged</a></div>
						</div>

						<span class="bl"></span>
						<span class="br"></span>
					</div>
				</div>

			</div>
		</div>
