<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Calculation Result</title>
</head>
<body>
    <h2>Calculation Result</h2>
    <%
        String result = (String) request.getAttribute("result");
        if (result != null) {
    %>
    <h3><%= result %></h3>
    <%
        } else {
    %>
    <h3>No result available</h3>
    <%
        }
    %>
    <br><br>
    <a href="index.jsp">Back to Calculator</a>
</body>
</html>