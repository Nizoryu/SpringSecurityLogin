<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />


      <h1>Message : ${message1}</h1>
    <table>
		<thead>
			<tr style="text-align: center">
				<th>ID</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>roleName</th>
				<th>datecreation</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="l">
				<tr>
					<td>${l.idUser }</td>
					<td>${l.firstName }</td>
					<td>${l.lastName }</td>
					<td>${l.roleName }</td>
					<td>${l.dateCreation}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>