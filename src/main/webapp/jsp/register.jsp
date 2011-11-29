<%@ include file="/WEB-INF/taglibs.jspp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<span style="font-size:8pt; color: red;">
(funktioniert noch nicht, schickt erstmal nur eine Mail, aber dafür muss die Datei MailConfig.java gepflegt sein!)<br/>
</span>

<stripes:form action="${contextPath}/Register">
	Username:<stripes:text name="username"></stripes:text>
	<br/>
	E-Mail:<stripes:text name="email"></stripes:text>
	<br/>
	<stripes:submit name="register" value="Registrieren"></stripes:submit>

</stripes:form>

</body>
</html>