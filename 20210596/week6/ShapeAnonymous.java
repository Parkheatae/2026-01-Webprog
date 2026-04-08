public class ShapeAnonymous {
    public static void main(String[] args) {

        Shape s = new Shape(10, 20) {
            private int size = 30;

            @Override
            public void rotate() {
                System.out.println("익명 도형 회전");
            }

            @Override
            public void show() {
                System.out.println("Anonymous Shape -> x=" + x + ", y=" + y + ", size=" + size);
            }
        };

        s.show();
        s.move(50, 60);
        s.show();
        s.translate(5, 10);
        s.show();
        s.rotate();

        System.out.println("전체 도형 수: " + Shape.getCount());
    }
}