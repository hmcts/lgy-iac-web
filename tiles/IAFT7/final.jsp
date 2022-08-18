<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

		<div id="Content">
			<div class="holder">

				<div class="steps">
					<h2>Success</h2>
					<div align="right">
						
					</div>
				</div>
				<div class="formwrap">
					<span class="tl"></span>
					<span class="tr"><span></span></span>

					<h3></h3>
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
							<p><strong>Submission successful</strong></p>
							<form action="getxml.do">
							<p><strong>Amount Payable : £</strong><bean:write name="aggramount" scope="session" /><br/></p>
							Payment successful.<input type="radio" value="Success" id="transactionstatus" name="transactionstatus"/>
							Payment unsuccessful.<input type="radio"  value="failure" id="transactionstatus" name="transactionstatus"/>
							<input type="submit" value="submit" onclick="this.form.submit()"/>
							</form>
							
							
						</div>

						<span class="bl"></span>
						<span class="br"></span>
					</div>
				</div>

			</div>
		</div>
