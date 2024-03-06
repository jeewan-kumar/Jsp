<%@page import="java.util.ArrayList"%>
<%@ include file = "index.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page = "index.css"></jsp:include>
</head>
<body>
	<form action="">
	name:<input type = "text" name = "name">
	name:<input type = "password" name = "password">
	name:<input type = "submit" name = "submit">
	
	</form>
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(name!=null && password!=null){
			%>
			<h1>Name:<%=name %></h1>
			<h1>Password:<%=password %></h1>
			<%
		}
	%>
	<h1>JSP</h1>
	<%! int a=10; %>
	<h2><%=a %></h2>
	<%
	ArrayList a = new ArrayList();
	a.add(10);
	a.add(20);
	a.add(30);
	%>
	<h2><%=a %></h2>
</body>
</html>