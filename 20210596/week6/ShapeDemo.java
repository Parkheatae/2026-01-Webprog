public class ShapeDemo {
    public static void main(String[] args) {
        Shape s1 = new Rectangle();
        Shape s2 = new Triangle(10, 20, 30, 40);
        Shape s3 = new Circle();

        s1.show();
        s2.show();
        s3.show();

        s1.move(50, 50);
        s2.translate(5, 10);
        s3.rotate();

        System.out.println("\nAfter move/translate/rotate:");
        s1.show();
        s2.show();
        s3.show();

        System.out.println("\n전체 도형 수: " + Shape.getCount());
    }
}