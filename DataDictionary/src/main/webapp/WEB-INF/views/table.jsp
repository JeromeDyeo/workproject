<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ntuc Link - Campaign</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.default.css">
<link rel="stylesheet" href="/css/pe-icon-7-stroke.css">
</head>

<body>
	<!-- navbar-->
	<header class="header">
		<div role="navigation" class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a href="/" class="navbar-brand">NTUC Link.</a>
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
	<!-- Content -->
	<div class="container clearfix ">
		<div class="btn-toolbar">
			<a href="#" class="btn btn-primary" role="button">Create Entry</a> <a
				href="uploadFile" class="btn btn-info" role="button">Upload Data</a>
		</div>
	</div>
	<section>
		<div class="container clearfix">
			<div class="row services">
				<div class="col-md-12">
					<h2 class="h1">Campaign Data</h2>
					<div class="row">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Application</th>
										<th>Schema</th>
										<th>Table</th>
										<th>Column</th>
										<th>Data Type</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="data" items="${allData}">
										<tr>
											<!-- <th scope="row"></th>  -->
											<td>${data.application}</td>
											<td>${data.schemaName}</td>
											<td>${data.tableName}</td>
											<td>${data.columnName}</td>
											<td>${data.dataType}</td>
											<td>${data.description}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section></section>
	<!-- End of content -->
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

<!-- <table border="1">
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
		 -->