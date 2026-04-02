public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("2000 이하의 완전수 목록:");

        for (int num = 2; num <= 2000; num++) {
            int sum = 1;
            StringBuilder divisors = new StringBuilder("1");

            for (int divisor = 2; divisor <= num / 2; divisor++) {
                if (num % divisor == 0) {
                    sum += divisor;
                    divisors.append(", ").append(divisor);
                }
            }

            if (sum == num) {
                System.out.println(num + " (약수: " + divisors + ")");
            }
        }
    }
}
