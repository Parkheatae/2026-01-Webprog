import java.util.Random;

public class InterTriangle implements ShapeAction {
    private int x, y, base, height;
    private static int count = 0;

    public static final int MAX_X = 100;
    public static final int MAX_Y = 100;
    public static final int MAX_BASE = 50;
    public static final int MAX_HEIGHT = 50;

    public InterTriangle() {
        Random rand = new Random();
        x = (int)(Math.random() * MAX_X);
        y = (int)(Math.random() * MAX_Y);
        base = rand.nextInt(MAX_BASE) + 1;
        height = rand.nextInt(MAX_HEIGHT) + 1;
        count++;
    }

    public InterTriangle(int x, int y, int base, int height) {
        this.x = x;
        this.y = y;
        this.base = base;
        this.height = height;
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
        System.out.println("InterTriangle 회전");
    }

    @Override
    public void show() {
        System.out.println("InterTriangle -> x=" + x + ", y=" + y +
                ", base=" + base + ", height=" + height);
    }

    public static int getCount() {
        return count;
    }
}