<%@ include file="/WEB-INF/taglibs.jspp" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
<link rel="stylesheet" href="${contextPath}/css/style.css" />
<title><fmt:message key="all_games"/></title>
</head>

<body>
	<h2><fmt:message key="all_games"/></h2>
		<c:forEach items="${actionBean.gameList}" var="game">
			<span>${game.mainTitle}</span> 
				<stripes:link href="/game/${game.id}">Prototyp-View</stripes:link>
				<stripes:link href="/tree/${game.id}">Tree-View</stripes:link>
			<br/>
		</c:forEach>
<%@ include file="/loginbox.jsp" %> 

</body>
</html>
