import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] sites;
    private final WeightedQuickUnionUF wqu;
    private int openSites;
    private final int n;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        sites = new boolean[n][n];
        wqu = new WeightedQuickUnionUF(n * n + 2);
        openSites = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = false;
            }
        }
    }

    private int mapTo1d(int row, int col) {
        return n * (row - 1) + (col - 1);
    }

    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        else if (!sites[row - 1][col - 1]) {
            sites[row - 1][col - 1] = true;
            int curr = mapTo1d(row, col);
            if (row == 1) {
                wqu.union(curr, n * n);
            }
            if (row == n) {
                wqu.union(curr, n * n + 1);
            }
            if (col > 1 && sites[row - 1][col - 2]) {
                wqu.union(curr, mapTo1d(row, col - 1));
            }
            if (col < n && sites[row - 1][col]) {
                wqu.union(curr, mapTo1d(row, col + 1));
            }
            if (row > 1 && sites[row - 2][col - 1]) {
                wqu.union(curr, mapTo1d(row - 1, col));
            }
            if (row < n && sites[row][col - 1]) {
                wqu.union(curr, mapTo1d(row + 1, col));
            }
            openSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        else return sites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        else return wqu.find(mapTo1d(row,col)) == wqu.find(n * n);
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return openSites;
    }

    // does the system percolate?
    public boolean percolates(){
        return wqu.find(n * n) == wqu.find(n * n + 1);
    }
}
