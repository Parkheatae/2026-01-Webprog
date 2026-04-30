<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        padding: 20px;
    }
    .container {
        max-width: 400px;
        margin: 0 auto;
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 5px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-top: 10px;
        font-weight: bold;
        color: #555;
    }
    input[type="number"], select {
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 3px;
        font-size: 14px;
    }
    button {
        margin-top: 20px;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        font-size: 16px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h2>계산기</h2>
    <form action="calcControl" method="post">
        <label for="n1">첫 번째 숫자:</label>
        <input type="number" id="n1" name="n1" step="any" required>
        
        <label for="operator">연산자 선택:</label>
        <select id="operator" name="operator" required>
            <option value="">-- 선택하세요 --</option>
            <option value="+">+ (더하기)</option>
            <option value="-">- (빼기)</option>
            <option value="*">* (곱하기)</option>
            <option value="/">/ (나누기)</option>
        </select>
        
        <label for="n2">두 번째 숫자:</label>
        <input type="number" id="n2" name="n2" step="any" required>
        
        <button type="submit">계산</button>
    </form>
</div>
</body>
</html>
