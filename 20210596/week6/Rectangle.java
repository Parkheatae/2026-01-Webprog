import java.util.Random;

class Rectangle {
    // 전체 사각형 개수
    static int count = 0;

    // 좌표와 크기 한계 상수
    static final int MAX_X = 100;
    static final int MAX_Y = 100;
    static final int MAX_WIDTH = 50;
    static final int MAX_HEIGHT = 50;

    int x, y, width, height;

    // 좌표와 크기를 직접 받는 생성자
    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        count++;
    }

    // 기본 생성자: 좌표와 크기를 랜덤 생성
    Rectangle() {
        Random rand = new Random();

        // 좌표는 Math.random() 사용
        this.x = (int)(Math.random() * MAX_X);
        this.y = (int)(Math.random() * MAX_Y);

        // 크기는 Random 클래스 사용
        this.width = rand.nextInt(MAX_WIDTH) + 1;
        this.height = rand.nextInt(MAX_HEIGHT) + 1;

        count++;
    }

    // 사각형 정보 출력
    void printInfo() {
        System.out.println("사각형 정보 -> x: " + x + ", y: " + y
                + ", width: " + width + ", height: " + height);
    }

    // 전체 사각형 수 출력용
    static int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10, 20, 30, 40);
        Rectangle r3 = new Rectangle();

        r1.printInfo();
        r2.printInfo();
        r3.printInfo();

        System.out.println("전체 생성된 사각형 수: " + Rectangle.getCount());
    }
}