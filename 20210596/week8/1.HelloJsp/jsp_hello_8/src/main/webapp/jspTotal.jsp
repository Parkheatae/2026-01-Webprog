<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%! int num1 = 20; int calc(int num2) { return num1 + num2; } String[] items = {"Apple", "Banana", "Cherry"}; %>
<% int num2 = (int)(Math.random() * 100); int result = calc(num2); %>
<html>
<head>
    <title>jspTotal.jsp</title>
</head>
<body>
    <%-- JSP 주석: 이 파일은 JSP의 다양한 기능을 보여줍니다. --%>
    <p>num1: <%= num1 %>, num2: <%= num2 %>, result: <%= result %></p>
    <ul>
        <% for(String item : items) { %>
            <li><%= item %></li>
        <% } %>
    </ul>
</body>
</html>