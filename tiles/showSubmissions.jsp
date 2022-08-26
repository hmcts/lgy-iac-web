<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:xhtml/>
<head>
	<title>IACFees</title>
</head>

<body>

<h1>Latest Submissions</h1>

<bean:write name="file" filter="false"/>

</body>
</html>