<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="savecustomer" modelAttribute="customerobj">
Enter name:<form:input path="name"/><br>
Enter address:<form:input path="address"/>
Enter mobilenumber:<form:input path="mobilenumber"/>
Enter email:<form:input path="email"/>
Enter password:<form:input path="password"/>
<input type="submit" value="register">
</form:form>



</body>
</html>