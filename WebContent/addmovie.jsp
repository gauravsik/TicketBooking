<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Add Movie</title>
</head>
<body>

	<h1>Add movies page</h1>
	
	<form method="post" action="MovieServlet">
	<table>
		<tr><td colspan="3" style="text-align: center;">Add Movie</td></tr>
		<tr>
			<td>Movie Name</td>
			<td><input type="text" name="moviename" required="required"></td>
		</tr>
		<tr>
		<td>Theater Name</td>
				<td><select name="theatername">
						<option value="pvr">PVR</option>
						<option value="cinemax">CINEMAX</option>
						<option value="imax">IMAX</option>
						<option value="inox">INOX</option>
				</select></td>
			
		</tr>
		<tr>
			<td>Total Seats Available</td>
			<td>
				<select name="seatsavailable">
				<c:forEach begin="1" end="100" var="i">
    			<option value="${i}">${i}</option>
				</c:forEach>
				</select>
			</tr>
		<tr>
			<td>Start Time</td>
			<td><input type="time" name="starttime"></td>
		</tr>
		<tr>
			<td>End Time</td>
			<td><input type="time" name="endtime"></td>
		</tr>
		<tr>
		
		<td colspan="3" style="text-align: center;">
		<input type="submit" value="Add" name="submit">
		</td>
		</tr>
	</table>
	</form>
	<h4 style="text-align: center; border-color: maroon;"><a href="desk.html">Desk Page</a></h4>
</body>
</html>