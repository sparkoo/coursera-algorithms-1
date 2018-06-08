import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Solver {
    private final Comparator<Node> manhattanNodeComparator = new Comparator<Node>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.board.manhattan() - n2.board.manhattan();
        }
    };

    private final Comparator<Board> manhattanComparator = new Comparator<Board>() {
        @Override
        public int compare(Board b1, Board b2) {
            return b1.manhattan() - b2.manhattan();
        }
    };

    private final List<Board> solution = new ArrayList<>();

    /** find a solution to the initial board (using the A* algorithm) */
    public Solver(Board initial) {
        solve(initial);
    }

    private void solve(Board b) {
        MinPQ<Node> pq = new MinPQ<>(manhattanNodeComparator);
        MinPQ<Board> pqTwin = new MinPQ<>(manhattanComparator);

        Node currentNode = new Node(b, null);
        pq.insert(currentNode);

        Board bTwin = b.twin();
        pqTwin.insert(bTwin);

        while (!currentNode.board.isGoal() && !bTwin.isGoal()) {
            currentNode = pq.delMin();
            for (Board bn : currentNode.board.neighbors()) {
                if (!bn.equals(currentNode.board)) {
                    pq.insert(new Node(bn, currentNode));
                }
            }

            bTwin = pqTwin.delMin();
            for (Board bn : bTwin.neighbors()) {
                if (!bn.equals(bTwin)) {
                    pqTwin.insert(bn);
                }
            }
        }

        if (currentNode.board.isGoal() && !bTwin.isGoal()) {
            while (currentNode != null) {
                solution.add(currentNode.board);
                currentNode = currentNode.previous;
            }
            Collections.reverse(solution);
        }
    }

    /** is the initial board solvable? */
    public boolean isSolvable() {
        return solution.size() > 0;
    }

    /** min number of moves to solve initial board; -1 if unsolvable */
    public int moves() {
        return solution.size() - 1;
    }

    /** sequence of boards in a shortest solution; null if unsolvable */
    public Iterable<Board> solution() {
        return solution;
    }

    private static class Node {
        private final Board board;
        private final Node previous;

        private Node(Board board, Node previous) {
            this.board = board;
            this.previous = previous;
        }
    }

    /** solve a slider puzzle (given below) */
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

        // solve the puzzle
        Solver solver = new Solver(initial);

        StdOut.println(initial);

        // print solution to standard output
        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
        } else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
    }
}