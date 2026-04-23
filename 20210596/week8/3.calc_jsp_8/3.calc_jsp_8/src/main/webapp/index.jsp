<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <%
        String result = "";
        if (request.getMethod().equals("POST")) {
            String num1Str = request.getParameter("num1");
            String num2Str = request.getParameter("num2");
            String op = request.getParameter("op");
            
            if (num1Str != null && num2Str != null && op != null) {
                try {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    double calcResult = 0;
                    
                    switch (op) {
                        case "+":
                            calcResult = num1 + num2;
                            break;
                        case "-":
                            calcResult = num1 - num2;
                            break;
                        case "*":
                            calcResult = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                calcResult = num1 / num2;
                            } else {
                                result = "Error: Division by zero";
                            }
                            break;
                        default:
                            result = "Error: Invalid operator";
                    }
                    
                    if (result.isEmpty()) {
                        result = "Result: " + num1 + " " + op + " " + num2 + " = " + calcResult;
                    }
                } catch (NumberFormatException e) {
                    result = "Error: Invalid number format";
                }
            } else {
                result = "Error: Missing parameters";
            }
        }
    %>
    <form action="" method="post">
        <label for="num1">Number 1:</label>
        <input type="number" id="num1" name="num1" required><br><br>
        
        <label for="op">Operator:</label>
        <select id="op" name="op" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select><br><br>
        
        <label for="num2">Number 2:</label>
        <input type="number" id="num2" name="num2" required><br><br>
        
        <input type="submit" value="Calculate">
    </form>
    <%
        if (!result.isEmpty()) {
    %>
    <h3><%= result %></h3>
    <%
        }
    %>
</body>
</html>
