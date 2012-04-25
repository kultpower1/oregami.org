<%@ include file="/WEB-INF/taglibs.jspp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${contextPath}/css/style.css" />
<title>Administration</title>
</head>
<body>

<!-- 
<stripes:link beanclass="org.oregami.action.AdminActionBean" event="deleteGames">Spiele-Daten leeren</stripes:link>
<br/>
 -->
<stripes:link beanclass="org.oregami.action.AdminActionBean" event="resetDatabase">Database-Reset</stripes:link>

<br/><br/>
${actionBean.gameCount}
<%@ include file="/loginbox.jsp" %> 
</body>
</html>