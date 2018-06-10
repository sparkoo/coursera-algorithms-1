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
        root = insert(root, p, true);
    }


    private Node2d insert(Node2d node, Point2D p, boolean horizontalSplit) {
        if (node == null) {
            return new Node2d(p, null, null, horizontalSplit);
        }

        if (horizontalSplit) {
            if (p.x() < node.point.x()) {
                node.left = insert(node.left, p, !horizontalSplit);
            } else {
                node.right = insert(node.right, p, !horizontalSplit);
            }
        } else {
            if (p.y() < node.point.y()) {
                node.left = insert(node.left, p, !horizontalSplit);
            } else {
                node.right = insert(node.right, p, !horizontalSplit);
            }
        }

        return node;
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
        if (root == null) {
            return null;
        }

        return root.point;
    }

    private static class Node2d {
        private final Point2D point;
        private final boolean horizontalSplit;
        private Node2d left;
        private Node2d right;

        private Node2d(Point2D point, Node2d left, Node2d right, boolean horizontalSplit) {
            this.point = point;
            this.left = left;
            this.right = right;
            this.horizontalSplit = horizontalSplit;
        }

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
