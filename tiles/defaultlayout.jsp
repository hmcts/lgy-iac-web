<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
	    <%! String env_label=null; %>
        <%
           try{
                env_label=System.getenv("ENV_NAME");
                if (env_label == null) {
                    env_label = "";
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        %>
		<title>Immigration &amp; Asylum Tribunal</title>

		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
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
		<meta name="DC.date.modified" content="2011-04-14" />
		<meta name="DC.publisher" content="Ministry of Justice, 102 Petty France, London SW1H 9AJ" />
		<meta name="DC.format" content="Text/HTML" />
		<meta name="DC.language" content="ENG" />
		<meta name="DC.coverage" content="England, Wales" />
		<meta name="DC.rights.copyright" content="Crown Copyright" />
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate, max-age=0, proxy-revalidate, no-transform, pre-check=0, post-check=0, private">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Expires" content="0">

		<link rel="shortcut icon" href="images/favicon.ico" />
		
		<link rel="stylesheet" type="text/css" href="css/dg.css" />

		<!--[if lte IE 7] -->
		<link href="css/dgie.css" rel="stylesheet" type="text/css" media="screen" />
		<!-- [endif] -->

		<!-- [if IE 6] -->
		<link href="css/dgie6.css" rel="stylesheet" type="text/css" media="screen" />
		<!-- [endif] -->

		<link rel="stylesheet" type="text/css" href="css/justice.css" />
		<link rel="alternate stylesheet" type="text/css" href="css/standard.css" title="Standard" />
		<link rel="alternate stylesheet" type="text/css" href="css/larger.css" title="Larger" />
		<link rel="alternate stylesheet" type="text/css" href="css/largest.css" title="Largest" />
		<script type="text/javascript" src="js/iac.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/dg.js"></script>
		<script type="text/javascript" src="js/dg.popup.js"></script>
		<script type="text/javascript" src="js/complextable.js"></script>
		<script type="text/javascript" src="js/corners.js"></script>
		<script type="text/javascript" src="js/CharsLeftCounter.js"></script>
		<script type="text/javascript" src="js/toggleVisibility.js"></script>
		<!-- <script type="text/javascript" src="js/clearFields.js"></script> -->
		<script>
  				(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  				(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
 				 m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  				})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  			  ga('create', 'UA-37377084-11', 'justice.gov.uk');
  			  ga('send', 'pageview');

	</script>

	</head>

	<body>
		<a name="top" id="top"></a>
		<div class="iewrapper">
			<div class="wrapper">
				<a href="#Heading" class="access">Go to main content</a>
				<div class="printlogo"><img src="images/printlogo.gif" alt="Justice UK logo" /></div>
				<div class="innerwrapper">
					<div class="onecolfloat">
						<div class="onecolblock">
							<div id="Section">
								<div id="TextSize">
									<a href="http://www.direct.gov.uk/en/Hl1/Help/Accessibility/index.htm" class="nojs">Resize text help</a>
								</div>
								<div id="Heading"><h1><%=env_label%> Immigration &amp; Asylum Appeal Fees</h1></div>
							</div>

								<!-- Content tiles here  -->
								<tiles:insert attribute="content"/>

							</div>
						</div>
					</div>

					<div id="Footer">
						<div class="holder">
							<ul>
								<li><a href="http://www.justice.gov.uk/about/justice/index.htm" class="first">About Justice</a></li>
								<li><a href="http://www.directgov.gov.uk">Directgov</a></li>
								<li><a href="https://immigrationappealsonline.justice.gov.uk/IACFees/Privacy_Notice_for_IAC.pdf">Your privacy</a></li>
								<li><a href="https://immigrationappealsonline.justice.gov.uk/IACFees/IAC_Cookies_notice.pdf">Cookies</a></li>
								<li><a href="http://www.justice.gov.uk/global/copyright/index.htm">&copy; Crown copyright</a></li>
							</ul>
						</div>
					</div>

					<div id="TopBar">
						<div class="holder">
							<span class="tl"></span><span class="tr"><span></span></span>
							<a href="http://www.justice.gov.uk" tabindex="1"><img src="images/logo.png" alt="Link to the Justice homepage" /></a>
						</div>
					</div>
				</div>
			</div>
	</body>
</html>