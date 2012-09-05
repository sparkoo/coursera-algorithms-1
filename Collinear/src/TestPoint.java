public class TestPoint {
    public TestPoint() {
        
    }
    
    private void testPointCompare() {
        Point p1 = new Point(5, 7);
        Point p2 = new Point(5, 6);
        
        if (p1.compareTo(p2) < 0)
            StdOut.println("p1 < p2");
    }
}
