<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<div id="Content">
	<div class="holder">
		<!-- InstanceBeginEditable name="main" -->
		<div id="screening">
			<P><Strong>Your payment has been declined.</Strong> You can:</P>
			<p>1)Click <Strong>"Yes"</Strong> Try again now (up to 4 times) using another card.</p>
			<p>2)Click <Strong>"No"</Strong> and  Print out a copy of your appeal and send to the Tribunal. The Tribunal will then write to you providing instructions about how to pay your fee.</p>
			Do you want to make the payment with some other card &nbsp;

			<div class="button"><a href="getamount.do">Yes</a></div>
			
			<div class="button"><a href="getreturnxml.do?orderID=<%=request.getParameter("orderID") %>">No.Finish Submission</a></div>
			&nbsp;
		</div>
		<img id="progress" style="margin-left:12%;  margin-bottom:2em;" src="images/progress/90-percent.gif" alt="*" />
	</div>
</div>