<%@page import="com.bitwise.jspassignment.BookingList"%>
<%@page import="com.bitwise.jspassignment.Booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="bx" uri="WEB-INF/custom.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display History</title>
</head>
<body>
<h1>Booking History</h1>
<br>
<bx:bookings/>
<br>
<center><h1><a href="desk.html">Desk</h1></a><center>
</body>
</html>