<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register user</title>
</head>
<body>
	<form action="RegisterController">
		<div>
			<input type="text" name="firstName" placeholder="Enter firstName">
			<br> <input type="text" name="middleName"
				placeholder="Enter middleName"> <br> <input type="text"
				name="lastName" placeholder="Enter lastName"> <br> <input
				type="text" name="gender" placeholder="Enter gender"> <br>
			<input type="date" name="dateOfBirth"
				placeholder="Enter Date of Birth"> <br> <input
				type="text" name="address" placeholder="Enter address"> <br>
			<input type="text" name="city" placeholder="Enter city"> <br>
			<input type="text" name="state" placeholder="Enter state"> <br>
			<input type="text" name="country" placeholder="Enter country">
			<br> <input type="number" name="zipCode"
				placeholder="Enter Zip Code"> <br> <input type="number"
				name="mobNo" placeholder="Enter Mobile No"> <br> <input
				type="text" name="panNo" placeholder="Enter panNo"> <br>
			<input type="text" name="username" placeholder="Enter username">
			<br> <input type="password" name="password"
				placeholder="Enter password"> <br> 
				<input
				type="password" name="confirmPassword"placeholder="Enter comfirmPassword"> <br> 
				<input type="submit" name="submit" value="Register">

		</div>
	</form>

</body>
</html>