public class InterfaceDemo {
    public static void main(String[] args) {
        ShapeAction s1 = new InterRectangle();
        ShapeAction s2 = new InterTriangle(10, 20, 30, 40);
        ShapeAction s3 = new InterCircle();

        s1.show();
        s2.show();
        s3.show();

        s1.move(50, 50);
        s2.translate(5, 10);
        s3.rotate();

        System.out.println("\n변경 후");
        s1.show();
        s2.show();
        s3.show();

        int totalCount = InterRectangle.getCount()
                + InterTriangle.getCount()
                + InterCircle.getCount();

        System.out.println("\n전체 도형 수: " + totalCount);
    }
}