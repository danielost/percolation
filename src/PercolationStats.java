import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats {
    private final int T;
    private final double shu = 1.96;
    private final double meanVal;
    private final double stdDev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        T = trials;
        double[] threshold = new double[T];
        for (int i = 0; i < trials; i++) {
            Percolation prc = new Percolation(n);
            while (!prc.percolates()) {
                int r = StdRandom.uniform(n) + 1;
                int c = StdRandom.uniform(n) + 1;
                prc.open(r, c);
            }
            threshold[i] = (double) prc.numberOfOpenSites() / (n * n);
        }
        meanVal = StdStats.mean(threshold);
        stdDev = StdStats.stddev(threshold);
    }

    // sample mean of percolation threshold
    public double mean(){
        return meanVal;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return stdDev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return meanVal - shu * stdDev / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return meanVal + shu * stdDev / Math.sqrt(T);
    }

    // test client
    public static void main(String[] args){
        int n = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats prc = new PercolationStats(n, T);
        System.out.println(prc.mean());
        System.out.println(prc.stddev());
        System.out.println(prc.confidenceLo());
        System.out.println(prc.confidenceHi());
    }
}
