import java.util.Scanner;

public class Multiples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        if (!scanner.hasNextInt()) {
            System.out.println("유효한 정수를 입력하세요.");
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.close();

        if (n <= 2) {
            System.out.println("2보다 큰 숫자를 입력하세요.");
            return;
        }

        System.out.println("입력값 " + n + " 보다 작은 2부터 9까지 배수 목록:");

        for (int d = 2; d <= 9; d++) {
            System.out.print(d + "의 배수: ");
            boolean first = true;
            for (int multiple = d; multiple < n; multiple += d) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(multiple);
                first = false;
            }
            if (first) {
                System.out.print("없음");
            }
            System.out.println();
        }
    }
}
