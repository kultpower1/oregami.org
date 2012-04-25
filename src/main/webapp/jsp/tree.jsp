<%@ include file="/WEB-INF/taglibs.jspp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${contextPath}/css/style.css" />
<script src="${contextPath}/js/jquery-1.7.1.min.js"></script>

<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<script src="${contextPath}/js/jquery-ui.custom.js"
	type="text/javascript"></script>
<script src="${contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<link href="${contextPath}/skin/ui.dynatree.css" rel="stylesheet"
	type="text/css"></link>
<script src="${contextPath}/js/jquery.dynatree.js"
	type="text/javascript"></script>
	
<script type="text/javascript" src="${contextPath}/js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>	
<link rel="stylesheet" href="${contextPath}/js/fancybox/jquery.fancybox-1.3.4.css" type="text/css" media="screen" />


<title>Treeview of Game: ${actionBean.loadedGame.mainTitle}</title>

<script type="text/javascript">
	
	$(document).ready(function() {
		$("#tree").dynatree({
			onActivate : function(node) {
				//     alert("You activated " + node);
			},
			onClick : function(node, event) {
				if (typeof node.data.pic != 'undefined') {
					alert(node.data.pic);
				}
			}
		});
	});

	function expandAll(val) {
		$("#tree").dynatree("getRoot").visit(function(node) {
			node.expand(val);
		});
	}
	
	
	function showScreenshot(file) {
		//alert(file + ", " + bool);
		$("body").append("<div onclick='javascript:hideScreenshot(" + file + ");' style='z-index:1000; position: fixed; right:10px; top:10px;' id='xx'>"
						+ "<img style='width:500px;' src='" + file + "'></div>");
	}
	function hideScreenshot(file) {
		//alert(file + ", " + bool);
		$("#xx").remove();
	}
</script>


</head>

<body>

	<span class="game_header">${actionBean.loadedGame.mainTitle}</span>
	<span style="font-size: 60%;">${actionBean.loadedGame.description}</span>
	<br />

	<hr />

	<button onclick="expandAll(true);">
		<fmt:message key="expandAll" />
	</button>
	<button onclick="expandAll(false);">
		<fmt:message key="collapseAll" />
	</button>


<%-- 	<div id="tree2">${actionBean.treeString}</div> --%>

	<div id="tree">
		<ul>
			<li>${actionBean.loadedGame.mainTitle}</li>
			<c:if test="${!empty actionBean.loadedGame.releaseGroupList}">
			<li class='folder'>ReleaseGroups (${actionBean.loadedGame.releaseGroupList.size()})
				<ul>		
					<c:forEach items="${actionBean.loadedGame.releaseGroupList}" var="releaseGroup">
						<li>${releaseGroup.system} (${releaseGroup.releaseGroupType})
							<ul>
							<c:if test="${!empty releaseGroup.releaseList}">
							
								<li class='folder'>Releases (${releaseGroup.releaseList.size()})
									<ul>
										<c:forEach items="${releaseGroup.releaseList}" var="release">
											<li>${release.distribution} (${release.description})
												<ul>
												<c:if test="${!empty release.countryReleaseList}">
													<li class='folder'>Countries (${release.countryReleaseList.size()})
														<ul>
															<c:forEach items="${release.countryReleaseList}" var="countryRelease">
																<li>${countryRelease.country}: ${countryRelease.yearOfRelease}</li>
															</c:forEach>
														</ul>
													</li>
												</c:if>
												
												<c:if test="${!empty release.photoList}">
													<li class="folder" data="unselectable: 'true'">Photos (${release.photoList.size()})
														<ul>
														<li data="unselectable: 'true'">
															<c:forEach items="${release.photoList}" var="photo" varStatus="status">
																<c:if test="${(status.index)%6==0  && status.index>0}">
																	<br/>
																</c:if>
				
																<img 
																	onmouseover="showScreenshot('${contextPath}/images/photos/${photo.fileName}')"
																	onmouseout="hideScreenshot('${contextPath}/images/photos/${photo.fileName}')"
																	style="width:100px; padding: 2pt;" 
																	src="${contextPath}/images/photos/${photo.fileName}" 
																	title="${photo.description} (${photo.type}) [${photo.fileName}]"
																>
																
															</c:forEach>
														</li>
														</ul>
													</li>
												
												</c:if>													
												</ul>
											</li>
											
										</c:forEach>
										
									</ul>
								</li>
							</c:if>
							
							<c:if test="${!empty releaseGroup.screenshotList}">
								<li class="folder" data="unselectable: 'true'">Screenshots (${releaseGroup.screenshotList.size()})
									<ul>
										<li data="unselectable: 'true'">
											<c:forEach items="${releaseGroup.screenshotList}" var="screenshot" varStatus="status">
												<c:if test="${(status.index)%6==0  && status.index>0}">
													<br/>
												</c:if>

												<img 
													onmouseover="showScreenshot('${contextPath}/images/screenshots/${screenshot.fileName}')"
													onmouseout="hideScreenshot('${contextPath}/images/screenshots/${screenshot.fileName}')"
													style="width:100px; padding: 2pt;" 
													src="${contextPath}/images/screenshots/${screenshot.fileName}" 
													title="${screenshot.description} (${screenshot.screenshotType}) [${screenshot.fileName}]"
												>
												
											</c:forEach>
																					 	
										</li>
									</ul>
								</li>
							</c:if>								
								
							</ul>						
						</li>
					</c:forEach>
				</ul>
			</li>
			</c:if>
			<c:if test="${!empty actionBean.loadedGame.screenshotList}">
			<li class="folder">Screenshots (${actionBean.loadedGame.screenshotList.size()})
				<ul>
					<li><div style="background-color: #aaaaaa; border: 1px solid green;">
						<c:forEach items="${actionBean.loadedGame.screenshotList}" var="screenshot">
							<img style="padding: 2pt;" src="${contextPath}/images/screenshots/${screenshot.fileName}" title="${screenshot.description} (${screenshot.screenshotType})">
						</c:forEach>
						</div>
					</li>
				</ul>
			</li>
			</c:if>
		</ul>
	</div>


	<%@ include file="/loginbox.jsp"%>


<div id="lightbox" style='background-colot:green;widht:100%;height:100%;position:absolute;top:0px;left:0px;'>
</div>

</body>
</html>
