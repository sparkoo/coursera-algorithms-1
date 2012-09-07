
public class Fast {
    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        Point[] points = new Point[in.readInt()];
        
        int x, y, i = 0;
        while (!in.isEmpty()) {
            x = in.readInt();
            y = in.readInt();
            points[i++] = new Point(x, y);
        }
        Merge.sort(points);
        findCollinears(points);
    }
    
    private static void findCollinears(Point[] points) {
        for (int k = 0; k < points.length; k++) {
            Point p = points[k];
            Double[] q = new Double[points.length - (k + 1)];
            for (int i = k + 1; i < points.length; i++) {
                q[i - (k + 1)] = p.slopeTo(points[i]);
            }
            Merge.sort(q);
            int count = 0;
            for (int i = 1; i < q.length; i++) {
                if (q[i].equals(q[i - 1])) {
                    count++;
                } else {
                    if (count >= 2) {
                        for (int j = i - count - 1; j < i; j++) {
                            StdOut.print(q[j] + " -> ");
                        }
                        StdOut.println();
                    }
                    count = 0;
                }
            }
        }
    }
}
