<%@page import="com.jsp.shoppingcart_dto.Item"%>
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
	<%
	List<Item> items=(List<Item>)request.getAttribute("itemlist");
	double totalprice =(double)request.getAttribute("totalprice");
	
	%>
	<table>
	<th>Brand</th>
	<th>Model</th>
	<th>category</th>
	<th>price</th>
	<th>quantity</th>
	
	
	<%
	for(Item i:items){
	%>
	<tr>
	<td><%=i.getBrand() %></td>
	<td><%=i.getModel() %></td>
	<td><%=i.getCategory() %></td>
	<td><%=i.getPrice() %></td>
	<td><%=i.getQuantity() %></td>
	
	</tr>
	
	<%
	}%>
	<tr>
	<td><a href="addorder">Buy now</a></td>
	<td colspan="4">Total price : <%=totalprice %></td>
	
	</table>
	

</body>
</html>