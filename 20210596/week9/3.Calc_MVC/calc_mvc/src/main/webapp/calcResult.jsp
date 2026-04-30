<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
<style>
    body {
        font-family: Arial, sans-serif;
        padding: 20px;
        background-color: #f5f5f5;
    }
    .container {
        max-width: 400px;
        margin: 0 auto;
        background-color: white;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    h2 {
        text-align: center;
        color: #333;
    }
    .result-box {
        background-color: #e8f5e9;
        padding: 20px;
        border-radius: 5px;
        margin: 20px 0;
        border-left: 4px solid #4CAF50;
    }
    .error-box {
        background-color: #ffebee;
        padding: 20px;
        border-radius: 5px;
        margin: 20px 0;
        border-left: 4px solid #f44336;
        color: #c62828;
    }
    .calculation-details {
        margin-top: 20px;
        padding: 15px;
        background-color: #f9f9f9;
        border-radius: 3px;
    }
    .detail-item {
        margin: 10px 0;
        font-size: 14px;
        color: #555;
    }
    .detail-label {
        font-weight: bold;
        color: #333;
        display: inline-block;
        width: 100px;
    }
    .button-group {
        text-align: center;
        margin-top: 20px;
    }
    button {
        padding: 10px 20px;
        margin: 0 5px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 14px;
    }
    .btn-back {
        background-color: #2196F3;
        color: white;
    }
    .btn-back:hover {
        background-color: #0b7dda;
    }
</style>
</head>
<body>
<div class="container">
    <h2>계산 결과</h2>
    
    <%
        Object errorAttr = request.getAttribute("error");
        if (errorAttr != null && !errorAttr.toString().isEmpty()) {
    %>
        <div class="error-box">
            <strong>오류 발생!</strong><br>
            <%= errorAttr %>
        </div>
    <%
        } else {
            Object calculatorAttr = request.getAttribute("calculator");
            Object resultAttr = request.getAttribute("result");
            
            if (calculatorAttr != null && resultAttr != null) {
    %>
        <div class="result-box">
            <h3 style="margin-top: 0; color: #2e7d32;">
                계산이 완료되었습니다!
            </h3>
            <div style="font-size: 28px; font-weight: bold; color: #1b5e20; text-align: center;">
                <%= resultAttr %>
            </div>
        </div>
        
        <div class="calculation-details">
            <div class="detail-item">
                <span class="detail-label">첫 번째 숫자:</span>
                <span><%= ((Calculator)calculatorAttr).getN1() %></span>
            </div>
            <div class="detail-item">
                <span class="detail-label">연산자:</span>
                <span><%= ((Calculator)calculatorAttr).getOp() %></span>
            </div>
            <div class="detail-item">
                <span class="detail-label">두 번째 숫자:</span>
                <span><%= ((Calculator)calculatorAttr).getN2() %></span>
            </div>
            <div class="detail-item" style="border-top: 1px solid #ddd; padding-top: 10px; margin-top: 10px;">
                <span class="detail-label">결과:</span>
                <span style="font-weight: bold; color: #2e7d32;"><%= resultAttr %></span>
            </div>
        </div>
    <%
            }
        }
    %>
    
    <div class="button-group">
        <button class="btn-back" onclick="location.href='index.jsp'">다시 계산하기</button>
    </div>
</div>
</body>
</html>
