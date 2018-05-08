import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Ordering();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    private class Ordering implements Comparator<Point> {
        public int compare(Point q1, Point q2) {
            Point p = new Point(x, y);
            double d = p.slopeTo(q1) - p.slopeTo(q2);
            if (d > 0)
                return -1;
            if (d < 0)
                return 1;
            return 0;
        }
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        return ((double) that.y - (double) this.y) / ((double) that.x - (double) this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if(this.y < that.y || (this.y == that.y && this.x < that.x)){
            return -1; 
        } else if(this.y == that.y && this.x == that.x) {
            return 0; 
        } else {
            return 1; 
        }
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}