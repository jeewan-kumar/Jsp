<%@ page import="com.studentmngsys.dob.StudentaDao" %>
<%@ page import="com.studentmngsys.dob.StudentDaoImp" %>
<%@ page import="com.student_view.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find Student By Roll Number</title>
</head>
<body>
    <h2>Find Student By Roll Number</h2>
    <form action="" method="get">
        <label for="rollno">Enter Roll Number:</label><br>
        <input type="text" id="rollno" name="rollno" required><br><br>
        <input type="submit" value="Find">
    </form>

    <%-- Display student information if found --%>
    <% 
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        StudentaDao dao = new StudentDaoImp();
        Student student = dao.findStudentById(rollno); 
        if (student != null) { 
    %>
        <h3>Student Details:</h3>
        <p>Roll Number: <%= student.getRollno() %></p>
        <p>Name: <%= student.getName() %></p>
        <p>Phone: <%= student.getPhone() %></p>
        <p>Email: <%= student.getEmail() %></p>
        <p>Age: <%= student.getAge() %></p>
        <p>Address: <%= student.getAddress() %></p>
    <% } %>

    <%-- Display error message if student is not found --%>
    <% 
        String errorMessage = (String) request.getAttribute("errorMessage"); 
        if (errorMessage != null) { 
    %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>
</body>
</html>
