<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
</head>
<body>
    <h2>상품 목록</h2>

    <table border="1">
        <tr>
            <th>상품 ID</th>
            <th>상품명</th>
            <th>제조사</th>
            <th>가격</th>
            <th>등록일</th>
            <th>상세보기</th>
        </tr>

        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.maker}</td>
                <td>${product.price}</td>
                <td>${product.date}</td>
                <td>
                    <a href="products?action=info&id=${product.id}">상세보기</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
