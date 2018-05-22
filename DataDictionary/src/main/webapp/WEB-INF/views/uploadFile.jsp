<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload CSV</title>
</head>
<body>
	<h1>Upload CSV</h1>
	<br>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div class="row form-group">
			<label class="col-md-2">Upload Data</label>
			<div class="col-md-10">
				<input type="file" name="file" />
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<input type="submit" class="btn btn-default" value="Add Data" />
			</div>
		</div>
	</form>

	<c:choose>
		<c:when test="${uploadSuccess != null}">
			<div class="alert alert-success">Your data has been
				successfully added!</div>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="${not empty error}">
			<div class="row">
				<table border="1" class="bootstrapErrors">
					<tr>
						<th>Row</th>
						<th>Error</th>
					</tr>
					<c:forEach var="error" items="${error}">

						<tr>
							<td>${error.key}</td>
							<td>${error.value}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</c:when>
	</c:choose>
</body>
</html>