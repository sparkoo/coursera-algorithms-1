import edu.princeton.cs.algs4.In;

public class Board {
    private final int[][] blocks;

    private final int moves;

    private final int dimension;
    private final int hamming;
    private final int manhattan;

    /**
    construct a board from an n-by-n array of blocks
    (where blocks[i][j] = block in row i, column j)
    */
    public Board(int[][] blocks) {
        this(blocks, 0, blocks.length);
    }

    private Board(int[][] blocks, int moves, int dimension) {
        this.moves = moves;
        this.dimension = dimension;
        this.blocks = blocksCopy(blocks);
        this.hamming = calculateHamming(blocks);
        this.manhattan = calculateManhattan(blocks);
    }

    private int[][] blocksCopy(int[][] blocks) {
        int[][] copy = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            System.arraycopy(blocks[i], 0, copy[i], 0, dimension);
        }
        return copy;
    }

    private int calculateHamming(int[][] blocks) {
        int hamming = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] != 0 && blocks[i][j] != ((dimension * i) + j + 1)) {
                    hamming++;
                }
            }
        }
        return hamming + moves;
    }

    private int calculateManhattan(int[][] blocks) {
        int manhattan = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 0) {
                    continue;
                }
                int calcI = (blocks[i][j] - 1) / dimension;
                int calcJ = (blocks[i][j] - 1) % dimension;
                if (i != calcI || j != calcJ) {
                    int distanceI = i - calcI;
                    manhattan += distanceI < 0 ? distanceI * -1 : distanceI;

                    int distanceJ = j - calcJ;
                    manhattan += distanceJ < 0 ? distanceJ * -1 : distanceJ;

                }
            }
        }
        return manhattan + moves;
    }

    /** board dimension n */
    public int dimension() {
        return dimension;
    }

    /** number of blocks out of place */
    public int hamming() {
        return hamming;
    }

    /** sum of Manhattan distances between blocks and goal */
    public int manhattan() {
        return manhattan;
    }

    /** is this board the goal board? */
    public boolean isGoal() {
        return hamming == 0;
    }

    /** a board that is obtained by exchanging any pair of blocks */
    public Board twin() {
        return null;
    }

    /** does this board equal y? */
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (!(y instanceof Board)) {
            return false;
        }
        Board that = (Board) y;

        if (that.dimension != dimension ||
            that.moves != moves ||
            that.manhattan != manhattan ||
            that.hamming != hamming) {
            return false;
        }

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] != that.blocks[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /** all neighboring boards */
    public Iterable<Board> neighbors() {
        return null;
    }

    /** string representation of this board (in the output format specified below) */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                sb.append(blocks[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        };
        return sb.toString();
    }

    /** unit tests (not graded) */
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = in.readInt();
            }
        }
        Board initial = new Board(blocks);
        blocks[n - 1][n - 1] = 3;
        Board initial2 = new Board(blocks);

        System.out.println(initial);
        System.out.println("dimmension: " + initial.dimension);
        System.out.println("hamming: " + initial.hamming);
        System.out.println("manhattan: " + initial.manhattan);
        System.out.println("goal: " + initial.isGoal());
        System.out.println(initial.equals(initial2));
    }
}