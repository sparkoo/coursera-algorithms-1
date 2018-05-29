import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class BruteCollinearPoints {

    private final LineSegment[] segments;
    private int segmentsSize = 0;

    /** finds all line segments containing 4 points */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("points can't be null");
        }

        segments = analyzeSegments(points);
    }

    private LineSegment[] analyzeSegments(Point[] points) {
        LineSegment[] tmpSegments = new LineSegment[points.length * 4];
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("point can't be null");
            }
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if (Double.compare(p.slopeTo(q), p.slopeTo(r)) == 0 && Double.compare(p.slopeTo(q), p.slopeTo(s)) == 0) {
                            tmpSegments[segmentsSize++] = new LineSegment(p, s);
                        }
                    }
                }
            }
        }
        LineSegment[] segments = new LineSegment[segmentsSize];
        for (int i = 0; i < segmentsSize; i++) {
            segments[i] = tmpSegments[i];
        }
        return segments;
    }

    /** the number of line segments */
    public int numberOfSegments() {
        return segmentsSize;
    }

    /** the line segments */
    public LineSegment[] segments() {
        LineSegment[] returnSegments = new LineSegment[segments.length];
        System.arraycopy(segments, 0, returnSegments, 0, segments.length);
        return returnSegments;
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
