<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 테스트 페이지</title>
</head>
<body>
    <h1>JSP 테스트 페이지</h1>

    <p>현재 시간: <strong><%= new java.util.Date() %></strong></p>

    <%-- 자바 코드 블록 --%>
    <%
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "방문자";
        }
    %>

    <p>안녕하세요, <strong><%= name %></strong>님!</p>

    <form method="get" action="test.jsp">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" placeholder="이름을 입력하세요" />
        <button type="submit">인사하기</button>
    </form>

    <%-- JSP 표현 언어(EL) 예시 --%>
    <p>세션 ID: ${pageContext.session.id}</p>

    <%-- JSTL 예시 (libs가 설정된 경우 사용 가능) --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:choose>
        <c:when test="${not empty param.name}">
            <p>입력된 이름: ${param.name}</p>
        </c:when>
        <c:otherwise>
            <p>이름을 입력하고 제출해보세요.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>