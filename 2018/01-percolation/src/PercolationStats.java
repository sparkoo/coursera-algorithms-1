import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_INTERVAL_95P = 1.96;

    private final int n;
    private final int trials;

    private final double[] opens;

    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;


    /* perform trials independent experiments on an n-by-n grid */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("args must be positive");
        }

        this.n = n;
        this.trials = trials;
        this.opens = new double[trials];
        run();

        mean = StdStats.mean(opens);
        stddev = StdStats.stddev(opens);
        confidenceLo = mean - (CONFIDENCE_INTERVAL_95P * stddev / Math.sqrt(trials));
        confidenceHi = mean + (CONFIDENCE_INTERVAL_95P * stddev / Math.sqrt(trials));
    }

    /* sample mean of percolation threshold */
    public double mean() {
        return mean;
    }

    /* sample standard deviation of percolation threshold */
    public double stddev() {
        return stddev;
    }

    /* low  endpoint of 95% confidence interval */
    public double confidenceLo() {
        return confidenceLo;
    }

    /* high endpoint of 95% confidence interval */
    public double confidenceHi() {
        return confidenceHi;
    }

    private void run() {
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int randomRow;
                int randomCol;
                do {
                    randomRow = StdRandom.uniform(1, n + 1);
                    randomCol = StdRandom.uniform(1, n + 1);
                } while (p.isOpen(randomRow, randomCol));
                p.open(randomRow, randomCol);
            }
            // System.out.println("percolates with: " + p.numberOfOpenSites());
            opens[i] = (double) p.numberOfOpenSites() / (n * n);
        }
    }

    private void printResults() {
        System.out.println("mean                    = " + mean);
        System.out.println("stddev                  = " + stddev);
        System.out.println("95% confidence interval = [" + confidenceLo + ", " + confidenceHi + "]");
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("expected exactly 2 arguments");
        }

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("neither of arguments can't be <= 0");
        }

        PercolationStats percolationStats = new PercolationStats(n, trials);
        percolationStats.printResults();
    }
}