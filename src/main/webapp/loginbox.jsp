<table style="position: fixed; right: 0px; top: 0px; text-align: right; background-color: #eeeeee; font-size: 10pt; ">
<tr>
<td>
<shiro:authenticated>
    logged in as <span style="color: green; font-weight: bold; font-style: italic;"><shiro:principal/></span>. <a href="${contextPath}/Logout">logout</a>
</shiro:authenticated>
<shiro:notAuthenticated>
    <fmt:message key="please"/> <a href="<c:out value="${contextPath}" />/Login"><fmt:message key="login"/></a>
    <fmt:message key="or"/> <a href="<c:out value="${contextPath}" />/Register"><fmt:message key="register"/></a>.
</shiro:notAuthenticated>
</div>
&nbsp;&nbsp;
<stripes:link href=""><stripes:param name="locale" value="de"/>de</stripes:link>

<stripes:link href=""><stripes:param name="locale" value="en"/>en</stripes:link>
</td>
</tr>
</table>
