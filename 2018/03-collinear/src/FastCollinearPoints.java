import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class FastCollinearPoints {

    private Point[] points;
    private int segmentsCount;
    private LineSegment[] segments;

    /** finds all line segments containing 4 or more points */
    public FastCollinearPoints(Point[] points) {
        this.points = points;
        this.segmentsCount = 0;
        this.segments = this.analyze();
    }

    private LineSegment[] analyze() {
        LineSegment[] tmpSegments = new LineSegment[points.length * 4];

        LineSegment[] segments = new LineSegment[segmentsCount];
        for (int i = 0; i < segmentsCount; i++) {
            segments[i] = tmpSegments[i];
        }
        return segments;
    }

    /** the number of line segments */
    public int numberOfSegments() {
        return segmentsCount;
    }

    /** the line segments */
    public LineSegment[] segments() {
        return segments;
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}