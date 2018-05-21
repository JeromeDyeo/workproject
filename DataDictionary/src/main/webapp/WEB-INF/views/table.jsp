<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Data</title>
</head>

<body>
<h1>All Data</h1><br>
<table border="1">
	<tr>
		<th>Application</th>
		<th>Schema</th>
		<th>Table</th>
		<th>Column</th>
		<th>Data Type</th>
		<th>Description</th>
	</tr>
	<c:forEach var="data" items="${allData}">
		<tr>
			<td>${data.application}</td>
			<td>${data.schemaName}</td>
			<td>${data.tableName}</td>
			<td>${data.columnName}</td>
			<td>${data.dataType}</td>
			<td>${data.description}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>