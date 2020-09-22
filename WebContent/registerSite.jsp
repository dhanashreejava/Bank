<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bank</title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<div class="container">
			<a href="" class="navbar-brand font-weight">Global Bank</a>
			<button class="navbar-toggler type=" button" data-toggle="collapse"
				data-target="#collapsenavbar"">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse text-center" id="collapsenavbar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="" class="nav-link text-white">Home</a>
					</li>
					<li class="nav-item"><a href="" class="nav-link text-white">Service</a>
					</li>
					<li class="nav-item"><a href="" class="nav-link text-white">Team</a>
					</li>
					<li class="nav-item"><a href="" class="nav-link text-white">About
							us</a></li>
					<li class="nav-item"><a href="" class="nav-link text-white">Contact</a>
					</li>
				</ul>

			</div>
		</div>
	</nav>

	<form action="RegisterSiteController" method="get">

		<input type="number" name="aadhar" placeholder="enter adhar no">
		<br> <input type="text" name="email" placeholder="Enter EmailId">
		<input type="submit" value="send mail">
	</form>

	<form action="Welcome" method="get">
		<input type="text" name="otp"> <input type="submit"
			value="verify">
	</form>

</body>
</html>