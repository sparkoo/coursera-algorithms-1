import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.ArrayList;

public class KdTree {
    private Node2d root;
    private int size;

    /** construct an empty set of points */
    public KdTree() {
        root = null;
        size = 0;
    }

    /** is the set empty? */
    public boolean isEmpty() {
        return root == null;
    }

    /** number of points in the set  */
    public int size() {
        return size;
    }

    /** add the point to the set (if it is not already in the set) */
    public void insert(Point2D p) {
        size++;
    }

    /** does the set contain point p? */
    public boolean contains(Point2D p) {
        return false;
    }

    /** draw all points to standard draw */
    public void draw() {
        if (!isEmpty()) {
            root.draw();
        }
    }

    /** all points that are inside the rectangle (or on the boundary) */
    public Iterable<Point2D> range(RectHV rect) {
        return new ArrayList<Point2D>();
    }

    /** a nearest neighbor in the set to point p; null if the set is empty */
    public Point2D nearest(Point2D p) {
        return new Point2D(0, 0);
    }

    private static class Node2d {
        private final Point2D point;
        private Node2d left;
        private Node2d right;
        private boolean horizontalSplit;

        private void draw() {
            if (left != null) {
                left.draw();
            }
            point.draw();
            if (right != null) {
                right.draw();
            }
        }
    }

    /** unit testing of the methods (optional) */
    public static void main(String[] args) {

    }
}
