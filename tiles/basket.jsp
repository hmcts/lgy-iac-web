<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<div id="Content">
	<div class="holder">
		<div class="formwrap">
			<span class="tl"></span>
			<span class="tr"><span></span></span>

			<logic:present name="errMsg" scope="request">
				<div id="error">
					<div id="message">
						<span id="heading">Please correct following:</span>
						<div id="fields"><bean:write name="errMsg" filter="false"/></div>
					</div>
				</div>
			</logic:present>

			<div id="screening">
			<h3>Summary</h3>
			
				<p><strong>Please note the reference number stated below is not your appeal reference number and is not sent to the tribunal once you have </br> submitted your appeal</strong></p>			
<table cellspacing="10" >
					<tr>
						<th>No</th>
						<th>Appellant name</th>
						<th>Reference</th>
						<th>Fee</th>
						<th>Status</th>
						<th>Review/Print</th>
					</tr>
					<%int ctr=1; %>
					<logic:iterate id="asbean" name="asbean" scope="session" type="com.MOJICT.IACFee.Beans.AggregatedSubmissionBean">
					<tr>
						<td><bean:write name="asbean" property="count" /></td>
						<td><bean:write name="asbean" property="name" /></td>
						<td><strong><bean:write name="asbean" property="type" />-<bean:write name="asbean" property="securitytoken" /></strong></td>
						<td>&pound;<bean:write name="asbean" property="amount" /></td>
						<td><bean:write name="asbean" property="status" /></td>
						<td><a href="basketfunction.do?operation=review<%=ctr%>" target="_blank">Preview</a></td>
						<td><a href="basketfunction.do?operation=edit<%=ctr%>" >Edit</a></td>
						<td><a href="basketfunction.do?operation=delete<%=ctr%>" >Remove</a></td>
					</tr>
					<%ctr++; %>
					</logic:iterate>

 				<%if(ctr==1){%>
				   <tr><p>Your shopping basket is empty</p></tr>
				  <%}%>
				</table>

				<h2>Fee payable:&pound;<bean:write name="aggramount" scope="session"/></h2>
				<h3>Please note: The system will only charge for completed appeals</h3>
			
				
			</div>
		</div>

		<div id="screening">
			<p>You will not be able to move on from this screen while any of the appeals are 'in progress'.</p><p> All appeals must be completed or removed before payment can be taken. Once paid for or removed you will NOT be able to use the reference number to return to the appeal. If you have removed an appeal 'in progress' you will need to start again.</p>
			
			<br/>
			<br/>
			<div class="button"><a href="aggregationoption.do">Submit another appeal</a></div>&nbsp;
			<logic:equal value="false" scope="session" name="appealstatus">
			
			<%if(ctr>1){%>
			<logic:equal value="0" scope="session" name="aggramount">
			
						<div class="button">
							<a href="pdfreturn.do">Finish Submission</a>
						</div>
						&nbsp;
						
					</logic:equal>
	                 <%}%>		
			<logic:notEqual value="0" scope="session" name="aggramount">
						<div class="button">
							<a href="paymentsubmission.do">Pay for the appeal(s) just completed</a>
						</div>
						&nbsp;
					</logic:notEqual>
					
				</logic:equal>	
				
				<logic:equal value="true" scope="session" name="appealstatus">
				
					<div class="button">
							<a href="paymentsubmission.do">Pay for the appeal(s) just completed</a>
						</div>
						&nbsp;
					</logic:equal>
					
					</div>
			<br />
		
		<img id="progress" style="margin-left:12%;  margin-bottom:2em;" src="images/progress/90-percent.gif" alt="*" />
	</div>
</div>