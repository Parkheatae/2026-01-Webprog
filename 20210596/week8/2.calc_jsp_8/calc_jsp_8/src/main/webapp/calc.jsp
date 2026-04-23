<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Calculation Result</title>
</head>
<body>
    <h2>Calculation Result</h2>
    <%
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String op = request.getParameter("op");
        
        if (num1Str != null && num2Str != null && op != null) {
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;
                
                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            out.println("Error: Division by zero");
                            return;
                        }
                        break;
                    default:
                        out.println("Error: Invalid operator");
                        return;
                }
                
                out.println("Result: " + num1 + " " + op + " " + num2 + " = " + result);
            } catch (NumberFormatException e) {
                out.println("Error: Invalid number format");
            }
        } else {
            out.println("Error: Missing parameters");
        }
    %>
    <br><br>
    <a href="index.jsp">Back to Calculator</a>
</body>
</html>