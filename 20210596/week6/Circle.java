import java.util.Random;

public class Circle extends Shape {
    private int radius;
    public static final int MAX_RADIUS = 50;

    public Circle() {
        super();
        Random rand = new Random();
        radius = rand.nextInt(MAX_RADIUS) + 1;
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void rotate() {
        System.out.println("Circle rotation has no visible effect.");
    }

    @Override
    public void show() {
        System.out.println("Circle -> x=" + x + ", y=" + y +
                ", radius=" + radius);
    }
}