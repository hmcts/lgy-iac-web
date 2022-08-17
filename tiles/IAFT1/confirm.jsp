<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<%@page import="java.net.InetAddress" %>
<%@page import="java.io.*,java.net.*,com.MOJICT.IACFee.Beans.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Payment &ndash; Immigration &amp; Asylum Tribunal</title>
		<!-- InstanceEndEditable -->

		<!-- InstanceBeginEditable name="metadata" -->
		<meta name="DC.title" content="Immigration and Asylum Tribunal" />
		<meta name="revisit-after" content="1 days" />
		<meta name="Author" content="Immigration and Asylum Tribunal" />
		<meta name="Keywords" content="Immigration, Asylum, Tribunal" />
		<meta name="Description" content="" />
		
		<meta name="eGMS.accessibility" scheme="WCAG" content="Double-A" />
		<meta name="eGMS.subject.category" scheme="GCL" content="Immigration, Asylum, Tribunal" />
		
		<meta name="DC.subject.keyword" content="Immigration, Asylum, Tribunal" />
		<meta name="DC.description" content="" />
		<meta name="DC.creator" content="" />
		<meta name="DC.contributor" content="Immigration and Asylum Tribunal" />
		<meta name="DC.identifier" content="/index.jsp" />
		<meta name="DC.date.created" content="2011-04-14" />
		<meta name="DC.date.modified" content="2011-04-19" />
		<meta name="DC.publisher" content="Ministry of Justice, 102 Petty France, London SW1H 9AJ" />
		<meta name="DC.format" content="Text/HTML" />
		<meta name="DC.language" content="ENG" />
		<meta name="DC.coverage" content="England, Wales" />
		<meta name="DC.rights.copyright" content="Crown Copyright" />
		<!-- InstanceEndEditable -->

		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/dg.css" />

		<!--[if lte IE 7]>
			<link href="css/dgie.css" rel="stylesheet" type="text/css" media="screen" />
		<![endif]-->
		<!--[if IE 6]>
			<link href="css/dgie6.css" rel="stylesheet" type="text/css" media="screen" />
		<![endif]-->

		<link rel="alternate stylesheet" type="text/css" href="css/standard.css" title="Standard" />
		<link rel="alternate stylesheet" type="text/css" href="css/larger.css" title="Larger" />
		<link rel="alternate stylesheet" type="text/css" href="css/largest.css" title="Largest" />
		<link rel="stylesheet" type="text/css" href="css/complex_table.css" />
		<link rel="stylesheet" type="text/css" href="css/justice.css" />

		<script language="JavaScript" type="text/javascript" src="common/js/jquery.js"></script>
		<script language="JavaScript" type="text/javascript" src="common/js/dg.js"></script>
		<script language="JavaScript" type="text/javascript" src="common/js/complextable.js"></script>
		<script language="JavaScript" type="text/javascript" src="common/js/print.js"></script>
		<script language="JavaScript" type="text/javascript" src="common/js/general.js"></script>

		<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
		<script>
 			 (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  			 (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
 				 m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
 				 })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

 			 ga('create', 'UA-37377084-11', 'justice.gov.uk');
 			 ga('send', 'pageview');

		</script>
		<%! String ePDQtag=null;String encry=null;String ORDERID=null;int AMOUNT=0;String Email="";String PSPID=null;String SHAIN=null;String EPDQ_URL=null;%>

<%
	try{

AMOUNT=Integer.parseInt(request.getSession().getAttribute("aggramount").toString());
int AMOUNT1=AMOUNT*100;
String CURRENCY="GBP";
String LANGUAGE="en_US";
ORDERID=request.getSession().getAttribute("oid").toString();
PSPID=CPIBean.getPSPID();
SHAIN=CPIBean.getSHAIn();
EPDQ_URL=CPIBean.getEPDQ_URL();

if(null!=request.getSession().getAttribute("email"))
{
Email=request.getSession().getAttribute("email").toString();
}
String tohash="";
if(Email.equals("")||Email.equals("No email address specified"))
{
System.out.println("no email>>>>>>>>>>>>>>>>>>>"+Email);
tohash="AMOUNT="+AMOUNT1+SHAIN+"CURRENCY="+CURRENCY+SHAIN+"LANGUAGE="+LANGUAGE+SHAIN+"ORDERID="+ORDERID+SHAIN+"PSPID="+PSPID+SHAIN+"TITLE=IAC Fees"+SHAIN;
}
else
{
	System.out.println("email>>>>>>>>>>>>>>>>>>>"+Email);
tohash="AMOUNT="+AMOUNT1+SHAIN+"CURRENCY="+CURRENCY+SHAIN+"EMAIL="+Email+SHAIN+"LANGUAGE="+LANGUAGE+SHAIN+"ORDERID="+ORDERID+SHAIN+"PSPID="+PSPID+SHAIN+"TITLE=IAC Fees"+SHAIN;
}

System.out.println("String to hash is --"+tohash);

encry=com.MOJICT.IACFee.Util.SHA1.sha1(tohash);

}

catch(Exception e) {
e.printStackTrace();
}
if(ePDQtag==null) {}
%>
		
	</head>

	<body>
		<a name="top" id="top"></a>
				<div class="iewrapper">
			<div class="wrapper">
				<a href="#Heading" class="access">Go to main content</a>
				<div class="printlogo">
					<img src="images/printlogo.gif" alt="Justice logo" />
				</div>
				<div class="innerwrapper">
					<div class="onecolfloat">
						<div class="onecolblock">
							<div id="Section">
								<div id="TextSize">
									<a href="http://www.direct.gov.uk/en/Hl1/Help/Accessibility/index.htm" class="nojs">Resize text help</a>
								</div>
								<header id="Heading">
									<h1>Immigration &amp; Asylum Appeal Fees</h1>
								</header>
							</div>
							<div id="Content">
								<div class="holder">
									<!-- InstanceBeginEditable name="main" -->
									
									<form method="post" action="<%=EPDQ_URL%>" name="postform">
										
										<input type="hidden" name="PSPID" value="<%=PSPID%>">
										<input type="hidden" name="ORDERID" value="<%=ORDERID %>">
										
										<input type="hidden" name="AMOUNT" value="<%=AMOUNT*100 %>">
										<input type="hidden" name="CURRENCY" value="GBP">
										<input type="hidden" name="LANGUAGE" value="en_US">
										 <% if(!Email.equals(" ")&&!Email.equals("No email address specified"))
										 {%>
										<input type="hidden" name="EMAIL" value="<%=Email %>">
										<%} %>
										<input type="hidden" name="SHASIGN" value="<%=encry %>">
										
										<input type="hidden" name="TITLE" value="IAC Fees"/>

									<div id="screening">																	
										<p>The following amount is due &nbsp;&pound;<bean:write name="aggramount" scope="session" /></p>
										<p>Please click on the Make payment button below where you will then be redirected to the Barclaycard website.</p>
										<p>You will need your debit or credit card details.  The following cards are accepted.</p>																				          
										<img src="images/cards.jpg" alt="Cards Accepted - Visa,Visa Electron,MasterCard,Maestro,Solo" />
									</div>

									<div class="submitc">
										<input type="hidden" name="next" value="page-2">
										<div class="function next right">
											<span class="tl"></span>
											<span class="tr"><span></span></span>
											
											<input type="submit" value="Make payment">
											<span class="bl"></span>
											<span class="br"></span>
										</div>
									</div>
										</form>
									<!-- InstanceEndEditable -->
								</div>
							</div>
						</div>
					</div>

				</div>

				<div id="Footer">
					<div class="holder">
						<ul>
							<li><a href="http://www.justice.gov.uk/about/justice/index.htm" class="first">About Justice</a></li>
							<li><a href="http://www.directgov.gov.uk">Directgov</a></li>
							<li><a href="http://www.justice.gov.uk/global/privacy/index.htm">Your privacy</a></li>
							<li><a href="http://www.justice.gov.uk/global/copyright/index.htm">&copy; Crown copyright</a></li>
						</ul>
					</div>
				</div>

				<!-- Include the Top Bar here -->
				<div id="TopBar">
					<div class="holder">
						<span class="tl"></span><span class="tr"><span></span></span>
						<a href="http://www.justice.gov.uk/" tabindex="1"><img src="images/logo.png" alt="Link to the Justice homepage" /></a>
					</div>
				</div>
				<!-- End of Top Bar -->

			</div>
		</div>
		<!--BEGIN_EXCLUDE-->
		<script type="text/javascript" src="/dg_scripts/ProphetInsert.js"></script>
		<noscript>
		<div>
			<img src='http://directgov.stcllctrs.com/OWCPZPDTRUV/noScript.bmp' alt="Scipt is not enabled" />
		</div>
		</noscript>
		<!--END_EXCLUDE-->
	</body>
<!-- InstanceEnd --></html>