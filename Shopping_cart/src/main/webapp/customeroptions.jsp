<%@page import="com.jsp.shoppingcart_dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Customer c=(Customer)session.getAttribute("customerinfo");
if(c!=null){
%>
<h1>${msg }</h1>
<h1>
<a href="displayproducts">Display All Products</a>
</h1>
<h1><a href="readbrandfromcustomer.jsp">Display products by brand</a></h1>
<% }
else { %>
	<h1><a href="customerloginform.jsp">please login first</a></h1>
	<%} %>
</body>
</html>