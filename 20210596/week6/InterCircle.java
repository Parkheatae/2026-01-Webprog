import java.util.Random;

public class InterCircle implements ShapeAction {
    private int x, y, radius;
    private static int count = 0;

    public static final int MAX_X = 100;
    public static final int MAX_Y = 100;
    public static final int MAX_RADIUS = 50;

    public InterCircle() {
        Random rand = new Random();
        x = (int)(Math.random() * MAX_X);
        y = (int)(Math.random() * MAX_Y);
        radius = rand.nextInt(MAX_RADIUS) + 1;
        count++;
    }

    public InterCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        count++;
    }

    @Override
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void rotate() {
        System.out.println("InterCircle 회전은 모양 변화 없음");
    }

    @Override
    public void show() {
        System.out.println("InterCircle -> x=" + x + ", y=" + y +
                ", radius=" + radius);
    }

    public static int getCount() {
        return count;
    }
}