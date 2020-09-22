<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input type="password"  placeholder="Enter profile password"> <br>
<% String fooParameter = request.getParameter("name");%> 
<input type="text"> <br>
<input type="text"><br>
<input type="text"><br>
<input type="number" placeholder="Enter amt"><br>
<input type="radio" name="radio1">NEFT
<input type="radio" name="radio1">RTGS
<input type="radio" name="radio1">IMPS
<br>
<input type="number" widht=100px placeholder="Enter the OTP send on your number"><br>
<button>Verify OTP</button>
</body>
</html>