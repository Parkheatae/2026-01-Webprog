import java.util.Random;

public class InterRectangle implements ShapeAction {
    private int x, y, width, height;
    private static int count = 0;

    public static final int MAX_X = 100;
    public static final int MAX_Y = 100;
    public static final int MAX_WIDTH = 50;
    public static final int MAX_HEIGHT = 50;

    public InterRectangle() {
        Random rand = new Random();
        x = (int)(Math.random() * MAX_X);
        y = (int)(Math.random() * MAX_Y);
        width = rand.nextInt(MAX_WIDTH) + 1;
        height = rand.nextInt(MAX_HEIGHT) + 1;
        count++;
    }

    public InterRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
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
        int temp = width;
        width = height;
        height = temp;
    }

    @Override
    public void show() {
        System.out.println("InterRectangle -> x=" + x + ", y=" + y +
                ", width=" + width + ", height=" + height);
    }

    public static int getCount() {
        return count;
    }
}