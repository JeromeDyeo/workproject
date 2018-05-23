<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload CSV</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.default.css">
<link rel="stylesheet" href="/css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="/css/borderlessTable.css">

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

	<!-- content -->
	<section>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="row">
				<div class="table-responsive">
					<table class="table table-borderless">
						<thead>
							<tr>
								<th>
									<h2>Upload CSV</h2>
								</th>
							</tr>
							<tr>
								<th>Upload Data</th>
								<th><input type="file" name="file" /></th>
							</tr>
							<tr>
								<th></th>
								<th><input type="submit" class="btn btn-default"
									value="Add Data" /></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</form>
	</section>
	<c:choose>
		<c:when test="${uploadSuccess != null}">
			<div class="alert alert-success">Your data has been
				successfully added!</div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty error}">
			<div class="container">
				<div class="row">
					<div class="table-responsive">
						<table class="table table-hover">
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
				</div>
			</div>
		</c:when>
	</c:choose>
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
 -->