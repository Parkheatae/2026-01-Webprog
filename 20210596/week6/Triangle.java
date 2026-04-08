import java.util.Random;

public class Triangle extends Shape {
    private int base, height;
    public static final int MAX_BASE = 50;
    public static final int MAX_HEIGHT = 50;

    public Triangle() {
        super();
        Random rand = new Random();
        base = rand.nextInt(MAX_BASE) + 1;
        height = rand.nextInt(MAX_HEIGHT) + 1;
    }

    public Triangle(int x, int y, int base, int height) {
        super(x, y);
        this.base = base;
        this.height = height;
    }

    @Override
    public void rotate() {
        System.out.println("Triangle rotates around its center.");
    }

    @Override
    public void show() {
        System.out.println("Triangle -> x=" + x + ", y=" + y +
                ", base=" + base + ", height=" + height);
    }
}