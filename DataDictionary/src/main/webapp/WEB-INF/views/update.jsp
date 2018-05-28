<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.datadictionary.entity.DataRow"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
	<form action="update" method="POST" name="update_row">
		<input type="hidden" name="id" value="${data.id}" />
		<div class="row form-group">
			<label class="col-md-3">Application</label>
			<div class="col-md-9">
				<input type="text" name="application" value="${data.application}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-3">Schema</label>
			<div class="col-md-9">
				<input type="text" name="schemaName" value="${data.schemaName}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-3">Table</label>
			<div class="col-md-9">
				<input type="text" name="tableName" value="${data.tableName}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-3">Column</label>
			<div class="col-md-9">
				<input type="text" name="columnName" value="${data.columnName}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-3">Data Type</label>
			<div class="col-md-9">
				<input type="text" name="dataType" value="${data.dataType}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-3">Description</label>
			<div class="col-md-9">
				<textarea rows="4" name="description" />${data.description}</textarea>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-9 col-md-offset-3">
				<button type="submit" class="btn btn-default">Save Row</button>
			</div>
		</div>
	</form>
	<div class="row form-group">
		<div class="col-md-9 col-md-offset-3">
			<a href="getAll" class="btn btn-cancel">Cancel</a>
		</div>
	</div>
</body>
</html>