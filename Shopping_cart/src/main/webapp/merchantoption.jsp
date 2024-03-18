
<%@page import="com.jsp.shoppingcart_dto.Merchant" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Merchant m=(Merchant)session.getAttribute("merchantinfo"); %>
<%if(m!=null){ %>
<h1 style=color:green> ${msg}</h1>
<h1>
<a href="addproduct">Add product</a>

<a href="viewallproducts.jsp">View all products</a>
</h1>
<% }

else {%>
<h1><a href="merchantloginform.jsp">please login first</a></h1>
<%} %>

</body>
</html>