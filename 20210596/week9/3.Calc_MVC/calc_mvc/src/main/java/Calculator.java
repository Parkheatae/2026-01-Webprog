public class Calculator {
    private double n1;
    private double n2;
    private String op;
    
    // 기본 생성자
    public Calculator() {
    }
    
    // 매개변수가 있는 생성자
    public Calculator(double n1, double n2, String op) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
    }
    
    // Getter/Setter
    public double getN1() {
        return n1;
    }
    
    public void setN1(double n1) {
        this.n1 = n1;
    }
    
    public double getN2() {
        return n2;
    }
    
    public void setN2(double n2) {
        this.n2 = n2;
    }
    
    public String getOp() {
        return op;
    }
    
    public void setOp(String op) {
        this.op = op;
    }
    
    // 사칙연산 계산 메소드
    public double calc() {
        switch(op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return n1 / n2;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자: " + op);
        }
    }
}
