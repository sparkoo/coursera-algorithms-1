import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.ArrayList;

public class KdTree {

    /** construct an empty set of points */
    public KdTree() {

    }

    /** is the set empty? */
    public boolean isEmpty() {
        return false;
    }

    /** number of points in the set  */
    public int size() {
        return 0;
    }

    /** add the point to the set (if it is not already in the set) */
    public void insert(Point2D p) {

    }

    /** does the set contain point p? */
    public boolean contains(Point2D p) {
        return false;
    }

    /** draw all points to standard draw */
    public void draw() {

    }

    /** all points that are inside the rectangle (or on the boundary) */
    public Iterable<Point2D> range(RectHV rect) {
        return new ArrayList<Point2D>();
    }

    /** a nearest neighbor in the set to point p; null if the set is empty */
    public Point2D nearest(Point2D p) {
        return new Point2D(0, 0);
    }

    /** unit testing of the methods (optional) */
    public static void main(String[] args) {

    }
}
