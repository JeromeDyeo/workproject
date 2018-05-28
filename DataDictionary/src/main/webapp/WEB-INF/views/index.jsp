<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.default.css">
<link rel="stylesheet" href="/css/pe-icon-7-stroke.css">
</head>
<body>
	<!-- navbar #2b90d9 blue color-->
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
	<!-- Introduction -->
	<div class="jumbotron main-jumbotron">
		<div class="container">
			<div class="content">
				<h1>Welcome to NTUC Link Campaign Site</h1>
				<p class="margin-bottom">Put introduction Content</p>
			</div>
		</div>
	</div>
	<!-- End of Intro -->

	<!-- Function -->
	<section class="background-gray-lightest">
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="post">
					<div class="image">
						<a href="getAll"><img src="img/blog1.jpg" alt=""
							class="img-responsive"></a>
					</div>
					<h3>
						<a href="getAll">Display Campaign Data</a>
					</h3>
					<p class="post__intro">Retrieve all data that are in the
						database</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="post">
					<div class="image">
						<a href="uploadFile"><img src="img/blog2.jpg" alt=""
							class="img-responsive"></a>
					</div>
					<h3>
						<a href="uploadFile">Upload Campaign Data </a>
					</h3>
					<p class="post__intro">
					<p>Too much data? Place them in Excel and we convert them for
						you.</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="post">
					<div class="image">
						<a href="create"><img src="img/blog2.jpg" alt=""
							class="img-responsive"></a>
					</div>
					<h3>
						<a href="create">Create Campaign Data </a>
					</h3>
					<p class="post__intro">
					<p>Show create campaign data page</p>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- End of Function -->

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

<!-- <div class="container">
		<h1>NTUC Link</h1>
		<a href="getAll" class="btn btn-info" role="button">Display
			Campaign</a>
	<script src="/jquery/jquery-3.2.1.min.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	</div> 
	
	<section>
	<div class="container clearfix">
		<div class="row services">
			<div class="col-md-12">
				<h2 class="h1">Functions</h2>
				<div class="row">
					<div class="col-sm-4">
						<div class="box box-services">
							<div class="icon">
								<i class="pe-7s-monitor"></i>
							</div>
							<h4 class="heading">
								<a href="getAll">Display Campaign Data</a>
							</h4>
							<p>Retrieve all data that are in the database</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="box box-services">
							<div class="icon">
								<i class="pe-7s-signal"></i>
							</div>
							<h4 class="heading">Upload Campaign Data</h4>
							<p>Too much data? Place them in Excel and we convert them for
								you.</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="box box-services">
							<div class="icon">
								<i class="pe-7s-id"></i>
							</div>
							<h4 class="heading">Create Campaign Data</h4>
							<p>Show create campaign data page</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	-->

