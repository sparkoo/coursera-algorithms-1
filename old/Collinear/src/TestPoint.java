public class TestPoint {
    public TestPoint() {
        testPointCompare();
    }
    
    private void testPointCompare() {
        Point p1 = new Point(5, 7);
        Point p2 = new Point(5, 6);
        StdOut.println(p1.slopeTo(p2));

        p1 = new Point(1, 1);
        p2 = new Point(3, 2);
        StdOut.println(p1.slopeTo(p2));

        p1 = new Point(5, 5);
        p2 = new Point(5, 6);
        StdOut.println(p1.slopeTo(p2));
    }
}
