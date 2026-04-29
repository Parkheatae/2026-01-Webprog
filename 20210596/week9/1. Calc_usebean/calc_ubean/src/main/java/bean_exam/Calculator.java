package bean_exam;

public class Calculator {
    private double n1;
    private double n2;
    private String op;

    public double calc() {
        double result = 0;

        if (op == null) {
            throw new IllegalStateException("Operator is not set");
        }

        switch (op) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = n1 / n2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }

        return result;
    }
}
