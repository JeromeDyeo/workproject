<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Campaign Data</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.default.css">
<link rel="stylesheet" href="/css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="/css/borderlessTable.css">
</head>
<body>
	<!-- navbar #2b90d9 blue color-->
	<header class="header">
	<div role="navigation" class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a href="/" class="navbar-brand"><img src="img/logo.png" alt=""
							class="img-responsive" height="200" width="200"></a>
				<div class="navbar-buttons">
					<button type="button" data-toggle="collapse"
						data-target=".navbar-collapse" class="navbar-toggle navbar-btn">
						Menu<i class="fa fa-align-justify"></i>
					</button>
				</div>
			</div>
			<div id="navigation" class="collapse navbar-collapse navbar-right">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="#">Text page</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown item 1</a></li>
							<li><a href="#">Dropdown item 2</a></li>
							<li><a href="#">Dropdown item 3</a></li>
							<li><a href="#">Dropdown item 4</a></li>
						</ul></li>
				</ul>
				<a href="#" data-toggle="modal" data-target="#login-modal"
					class="btn navbar-btn btn-ghost"><i class="fa fa-sign-in"></i>Log
					in</a>
			</div>
		</div>
	</div>
	</header>
	<!-- End of Nav -->


	<!-- content -->
	<form action="create" method="POST" name="create_row">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="table-responsive">
						<table class="table table-borderless">
							<thead>
								<tr>
									<th><h2>Create Campaign Data</h2></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Application</label></th>
									<th><input type="text" name="application" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Schema</label></th>
									<th><input type="text" name="schemaName" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Table</label></th>
									<th><input type="text" name="tableName" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Table Type</label></th>
									<th><input type="text" name="tableType" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Column</label></th>
									<th><input type="text" name="columnName" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Data Type</label></th>
									<th><input type="text" name="dataType" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Default Value</label></th>
									<th><input type="text" name="defaultValue" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Column Key</label></th>
									<th><input type="text" name="columnKey" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Null Able</label></th>
									<th><input type="text" name="nullAble" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Auto Increment</label></th>
									<th><input type="text" name="autoIncrement" /></th>
								</tr>
								<tr>
									<th><label class="col-md-2">Description</label></th>
									<th><textarea rows="4" name="description" /></textarea></th>
								</tr>
								<tr>
									<th></th>
									<th><input type="submit" class="btn btn-default"
										value="Add Row" /></th>
								</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- End of content -->
	<section></section>
	<!-- Footer -->
	<footer class="footer">
	<div class="footer__copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<p>&copy;NTUC Link</p>
				</div>
			</div>
		</div>
	</div>
	</footer>
	<!-- End of footer -->
	<!-- Javascript files-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery.cookie.js"></script>
	<script src="/js/front.js"></script>
</body>
</html>





<!-- 
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
 -->