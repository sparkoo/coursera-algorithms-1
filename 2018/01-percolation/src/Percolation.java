import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// TODO: fix backwash without 2nd WeightedQuickUnionUF `ufTop`
public class Percolation {
    private final int n;
    private final int n2;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufTop;
    private final boolean[] field;
    private final int top;
    private final int bottom;

    private int opens;

    /* create n-by-n grid, with all sites blocked */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.n = n;
        this.n2 = n * n;
        uf = new WeightedQuickUnionUF((n2) + 2);
        ufTop = new WeightedQuickUnionUF((n2) + 1);
        field = new boolean[n2];
        top = n2;
        bottom = n2 + 1;

        this.opens = 0;
    }

    /* open site (row, col) if it is not open already */
    public void open(int row, int col) {
        int i = calculateIndex(row, col);
        // System.out.println(String.format("[%d;%d] => [%d]", row, col, i));
        if (!field[i]) {
            field[i] = true;
            opens++;
        }

        connectFakeTopAndBottom(i);
        connectNeighbours(row, col);
    }

    private void connectFakeTopAndBottom(int i) {
        if (i < n) {
            uf.union(i, top);
            ufTop.union(i, top);
        }
        if (i > n2 - n - 1) {
            uf.union(i, bottom);
        }
    }

    private void connectNeighbours(int row, int col) {
        int i = calculateIndex(row, col);

        // top
        if (row >= 2 && isOpen(row - 1, col)) {
            uf.union(calculateIndex(row - 1, col), i);
            ufTop.union(calculateIndex(row - 1, col), i);
        }

        // bottom
        if (row < n && isOpen(row + 1, col)) {
            uf.union(calculateIndex(row + 1, col), i);
            ufTop.union(calculateIndex(row + 1, col), i);
        }

        // left
        if (col >= 2 && isOpen(row, col - 1)) {
            uf.union(calculateIndex(row, col - 1), i);
            ufTop.union(calculateIndex(row, col - 1), i);
        }

        // right
        if (col < n && isOpen(row, col + 1)) {
            uf.union(calculateIndex(row, col + 1), i);
            ufTop.union(calculateIndex(row, col + 1), i);
        }
    }

    /* is site (row, col) open? */
    public boolean isOpen(int row, int col) {
        return field[calculateIndex(row, col)];
    }

    /* is site (row, col) full? */
    public boolean isFull(int row, int col) {
        int i = calculateIndex(row, col);
        return ufTop.connected(i, top) && isOpen(row, col);
    }

    /* number of open sites */
    public int numberOfOpenSites() {
        return opens;
    }

    /* does the system percolate? */
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    private int calculateIndex(int row, int col) {
        checkArgs(row, col);
        return (((row - 1) * n) + col) - 1;
    }

    private void checkArgs(int row, int col) {
        if (row <= 0 || col <= 0 || row > n || col > n) {
            throw new IllegalArgumentException("out of field");
        }
    }
}