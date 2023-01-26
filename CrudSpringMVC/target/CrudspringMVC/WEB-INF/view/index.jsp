<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
	<h2>Hello World ! ${1+2}</h2>

	<ul>
	
		<li><a href="${pageContext.request.contextPath}/index?lang=en_US">Anglais></a></li>
		<li><a href="${pageContext.request.contextPath}/index?lang=fr_FR">Francais></a></li>

	</ul>

	<a href="emp/save">clique ici</a>
	<div>
		<s:message code="label.content"></s:message>
	</div>

	
	<s:message code="label.welcome"></s:message>
</body>
</html>
