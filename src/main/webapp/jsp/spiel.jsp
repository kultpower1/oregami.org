<%@ include file="/WEB-INF/taglibs.jspp" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
<link rel="stylesheet" href="/css/style.css" />
<title>Spiel-Anzeige</title>
</head>

<body>
	<span class="spiel_header">${actionBean.geladenesSpiel.hauptname}</span>
	<br/>
		<span class="spiel_subtitle">
			<c:forEach items="${actionBean.geladenesSpiel.titel}" var="titel" varStatus="status">
				${titel.name}<c:if test="${not status.last}">, </c:if>
			</c:forEach>
		</span>

		<br/><br/>
		<span style="font-size: 8pt;">
		Erschienen für:</span><br/>
		
		<c:forEach items="${actionBean.geladenesSpiel.veroeffentlichungsgruppen}" var="veroeffentlichungsgruppe">
		<div class="">
		<table border="0" cellpadding="0" cellspacing="1" class="veroeffentlichungsgruppe">
			<tr>
				<td>${veroeffentlichungsgruppe.system}</td>
			</tr>
			<tr>
				<td class="spiel_subtitle">
				&nbsp;&nbsp;&nbsp;
				${veroeffentlichungsgruppe.bezeichnung}
				</td>
			</tr>
			<tr>
				<td style="padding-left:20px;">
					<table class="veroeffentlichung" cellpadding="0" cellspacing="1">
						<c:forEach items="${veroeffentlichungsgruppe.veroeffentlichungen}" var="veroeffentlichung">
							<tr>
								<td>${veroeffentlichung.beschreibung},
								${veroeffentlichung.distributionsweg}
								 </td>

							<c:forEach items="${veroeffentlichung.landVeroeffentlichungen}" var="land" varStatus="status">
								<c:if test="${status.first}"><td style='padding-left: 10px;'></c:if>
								${land.land} (${land.erscheinungsjahr})
								<c:if test="${not status.last}">, </c:if>
								<c:if test="${status.last}"></td></c:if>
							</c:forEach>
							</tr>							
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
		</div>
		
		</c:forEach>

<%@ include file="/loginbox.jsp" %> 

</body>
</html>
