<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="WEB-INF/custom.tld"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Movies</title>
</head>
<body>

	<h1>Booking Page</h1>
	<h4 style="text-align: left; border-color: maroon;"> <a href="desk.html">Desk</a></h4>
	<form method="post" action="BookMovie">
	<table>
		<tr>
			<td>Customer name:</td>
			<td><input type="text" name="custname" required="required" /></td>
		</tr>
		<tr>
			<td>Customer Address:</td>
			<td><input type="text" name="custadd"></td>
		</tr>
		<tr>
			<td>Customer Phone:</td>
			<td><input type="tel" name="custphone"></td>
		</tr>
		<tr>
			<td>Movie Show:</td>
			<td><ex:movies /></td>
		</tr>
		<tr>
			<td>Date:</td>
			<td><input type="date" name="date"></td>
		</tr>
		<tr>
			<td>Seats Booked:</td>
			<td><input type="number" name="seatsbooked" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Book" name="submit" /></td>
		</tr>
	</table>
	</form>
</body>
</html>