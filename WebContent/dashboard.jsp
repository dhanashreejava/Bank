<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	margin: 0;
	font-family: "Lato", sans-serif;
}

.sidebar {
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

.sidebar a {
	display: block;
	color: black;
	padding: 16px;
	text-decoration: none;
}

.sidebar a.active {
	background-color: #4CAF50;
	color: white;
}

.sidebar a:hover:not (.active ) {
	background-color: #555;
	color: white;
}

div.content {
	margin-left: 200px;
	padding: 1px 16px;
	height: 1000px;
}

@media screen and (max-width: 700px) {
	.sidebar {
		width: 100%;
		height: auto;
		position: relative;
	}
	.sidebar a {
		float: left;
	}
	div.content {
		margin-left: 0;
	}
}

@media screen and (max-width: 400px) {
	.sidebar a {
		text-align: center;
		float: none;
	}
}
</style>
</head>
<body>

	<div class="sidebar">
		<a class="active" href="#home">Dashboard</a><a href="ViewBalanceController">View
			Balance</a> <a href="addBeneficiary.jsp">Add Beneficiary</a> 
			 <a href="ExistingController">Existing Benificiary </a>
			<a href="fund.jsp">Fund Transfer</a> 
			<a href="#about">Account Statement </a> <a href="#about">Interest
			Rate </a> <a href="#about">Change Account </a>
			

	</div>

	<div class="content">
		<h2>Dashboard</h2>
		<input type="text" placeholder="Custer name"> 
		<input type="text" placeholder="Custer name">
		 <input type="text" placeholder="Custer name">
	</div>

</body>
</html>