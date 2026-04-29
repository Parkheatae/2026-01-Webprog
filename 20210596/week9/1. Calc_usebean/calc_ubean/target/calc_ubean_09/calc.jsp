<html>
<body>
    <h2>Calculation Result</h2>
    <%
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String op = request.getParameter("op");
        String result = "";

        if (n1 != null && n2 != null && op != null) {
            try {
                double num1 = Double.parseDouble(n1);
                double num2 = Double.parseDouble(n2);
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
                        if (num2 == 0) {
                            result = "Error: Division by zero";
                        } else {
                            calcResult = num1 / num2;
                        }
                        break;
                    default:
                        result = "Error: Invalid operator";
                        break;
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
    %>

    <p><%= result %></p>
    <p><a href="index.jsp">Back</a></p>
</body>
</html>
