<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create</title>
</head>
<body>
	<form action="create" method="POST" name="create_row">
		<div class="row form-group">
			<label class="col-md-2">Application</label>
			<div class="col-md-10">
				<input type="text" name="application" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-2">Schema</label>
			<div class="col-md-10">
				<input type="text" name="schemaName" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-2">Table</label>
			<div class="col-md-10">
				<input type="text" name="tableName" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-2">Column</label>
			<div class="col-md-10">
				<input type="text" name="columnName" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-2">Data Type</label>
			<div class="col-md-10">
				<input type="text" name="dataType" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-md-2">Description</label>
			<div class="col-md-10">
				<textarea rows="4" name="description" /></textarea>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<input type="submit" class="btn btn-default" value="Add Row" />
			</div>
		</div>
	</form>
</body>
</html>