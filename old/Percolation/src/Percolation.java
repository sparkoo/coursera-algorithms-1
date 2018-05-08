/**
 * 
 * @author Michal vala
 * @author michal.vala@gmail.com
 */

public class Percolation {
    private boolean[][] field;
    private int[][] intfield;
    private int size;
    private WeightedQuickUnionUF connectionSolver;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        size = N;
        field = new boolean[N][N];
        intfield = new int[N][N];
        connectionSolver = new WeightedQuickUnionUF((size*size) + 2);
        createField();
    }
    
    private void createField() {
        int index = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                field[i][j] = false;
                intfield[i][j] = index++;
            }
        createVirtualRoots();
    }

    private void createVirtualRoots() {
        for (int i = 0; i < size; i++) {
            connectionSolver.union(intfield[0][i], size*size);
            connectionSolver.union(intfield[size - 1][i], (size*size) + 1);
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (i <= 0 || j <= 0) throw new IndexOutOfBoundsException();
        field[i - 1][j - 1] = true;
        int k = i - 1;
        int l = j - 1;
        if (k - 1 >= 0 && field[k - 1][l])
            connectionSolver.union(intfield[k - 1][l], intfield[k][l]);

        if (k + 1 < size && field[k + 1][l])
            connectionSolver.union(intfield[k + 1][l], intfield[k][l]);

        if (l - 1 >= 0 && field[k][l - 1])
            connectionSolver.union(intfield[k][l - 1], intfield[k][l]);

        if (l + 1 < size && field[k][l + 1])
            connectionSolver.union(intfield[k][l + 1], intfield[k][l]);
    }
    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i <= 0 || j <= 0) throw new IndexOutOfBoundsException();
        return field[i-1][j-1];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i <= 0 || j <= 0) throw new IndexOutOfBoundsException();
        if (connectionSolver.connected(intfield[i-1][j-1], size*size) && isOpen(i, j))
            return true;
        return false;
    }

    public boolean percolates() {
        // does the system percolate?
        if (size == 1)
            return isOpen(1, 1);
        return connectionSolver.connected(size*size, size*size + 1);
    }
}