public class Board {
    /**
    construct a board from an n-by-n array of blocks
    (where blocks[i][j] = block in row i, column j)
    */
    public Board(int[][] blocks) {

    } 

    /** board dimension n */
    public int dimension() {
        return 0;
    }

    /** number of blocks out of place */
    public int hamming() {
        return 0;
    }

    /** sum of Manhattan distances between blocks and goal */
    public int manhattan() {
        return 0;
    }

    /** is this board the goal board? */
    public boolean isGoal() {
        return false;
    }

    /** a board that is obtained by exchanging any pair of blocks */
    public Board twin() {
        return null;
    }

    /** does this board equal y? */
    public boolean equals(Object y) {
        return false;
    }

    /** all neighboring boards */
    public Iterable<Board> neighbors() {
        return null;
    }

    /** string representation of this board (in the output format specified below) */
    public String toString() {
        return null;
    }

    /** unit tests (not graded) */
    public static void main(String[] args) {

    }
}