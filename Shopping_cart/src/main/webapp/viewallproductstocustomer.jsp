<%@page import="com.jsp.shoppingcart_dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> product =(List<Product>)request.getAttribute("productlist"); %>
<h1><a href="fetchitemfromcart">view cart</a></h1>

table<table cellpadding="20px" border="2px">

<th>brand</th>
<th>model</th>
<th>category</th>
<th>price</th>
<th>Add to cart</th>

<% for(Product p:product){ %>
<tr>
<td> <%=p.getBrand() %></td>
<td> <%= p.getModel() %></td>
<td> <%= p.getCategory() %></td>
<td> <%= p.getPrice()%></td>
<td><a href="additem?id=<%= p.getId() %>">add</a></td>
</tr>
<% } %>
</table>
</body>
</html>