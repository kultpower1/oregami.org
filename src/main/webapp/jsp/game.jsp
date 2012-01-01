<%@ include file="/WEB-INF/taglibs.jspp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${contextPath}/css/style.css" />
<link rel="stylesheet" href="${contextPath}/css/easy-accordion.css" />
<!--  <link rel="stylesheet" href="${contextPath}/css/tabs-accordion-horizontal.css" />-->
<script src="${contextPath}/js/jquery-1.7.1.min.js"></script>
<script src="${contextPath}/js/jquery.easyAccordion.js"></script>
<title>Game: ${actionBean.loadedGame.mainTitle}</title>

<script type="text/javascript">
$(document).ready(function() {
	$('#accordion').easyAccordion({ 
		autoStart: false,
		slideNum: false
	});	
});
</script> 


</head>

<body>
	<span class="game_header">${actionBean.loadedGame.mainTitle}</span>
	<span style="font-size: 60%;">${actionBean.loadedGame.description}</span>
	<br />
	<span class="game_subtitle"> <c:forEach
			items="${actionBean.loadedGame.titleList}" var="title"
			varStatus="status">
				${title.name}<c:if test="${not status.last}">, </c:if>
		</c:forEach> </span>
	<br /><br />
	
	
<table>
<tr><td valign="top">
	<div id="accordion">
	<dl>
		<c:forEach items="${actionBean.loadedGame.systemToReleaseGroupMap}" var="mapEntry" varStatus="status">
			<dt>${mapEntry.key}</dt>
			<dd>
			<!-- <img src="${contextPath}/text/${mapEntry.key}"/>-->
			
		<c:forEach items="${mapEntry.value}" var="releaseGroup">
			<table border="0" cellpadding="0" cellspacing="1" class="releaseGroup">
				<tr>
					<td class="game_subtitle">
						${releaseGroup.name} <span style="font-size: 80%;">${releaseGroup.releaseGroupType}</span>
					</td>
				</tr>
				<tr>
					<td>
						<table class="release" cellpadding="0" cellspacing="1">
							<c:forEach items="${releaseGroup.releaseList}" var="release">
								<tr>
									<td>${release.description}, ${release.distribution}</td>

									<c:forEach items="${release.countryReleaseList}" var="country" varStatus="status">
										<c:if test="${status.first}">
											<td style='padding-left: 10px;'>
										</c:if>
								${country.country}: ${country.yearOfRelease}
								<c:if test="${not status.last}">, </c:if>
										<c:if test="${status.last}">
											</td>
										</c:if>
									</c:forEach>
								</tr>
							</c:forEach>
						</table></td>
				</tr>
			</table>
		</c:forEach>			
			
			
			</dd>
		</c:forEach>
	</dl>
	</div>
</td>
</tr>
<tr>
<td valign="top">

	<span class="screenshots">Screenshots 2: <br/>
		<c:forEach
			items="${actionBean.loadedGame.screenshotList}" var="screenshot"
			varStatus="status">
			<img src="${contextPath}/images/screenshots/${screenshot.fileName}"
				title="${screenshot.description}" />
		</c:forEach>
	</span>

</td>
</tr>
</table>


<%@ include file="/loginbox.jsp"%>

</body>
</html>
