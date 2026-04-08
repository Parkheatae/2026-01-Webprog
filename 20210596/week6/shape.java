import java.util.Random;

public abstract class Shape {
    protected int x, y;
    protected static int count = 0;

    public static final int MAX_X = 100;
    public static final int MAX_Y = 100;

    public Shape() {
        this.x = (int)(Math.random() * MAX_X);
        this.y = (int)(Math.random() * MAX_Y);
        count++;
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void rotate();
    public abstract void show();
    public static int getCount() {
        return count;
    }
}