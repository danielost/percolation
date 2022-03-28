public class Main {

    public static void main(String[] args) {
        Percolation prc = new Percolation(4);
        prc.open(1, 3);
        prc.open(2, 1);
        prc.open(2, 2);
        prc.open(2, 4);
        prc.open(3, 2);
        prc.open(3, 3);
        prc.open(4, 3);
        prc.open(4, 4);

        //
        prc.open(2, 3);
        System.out.println(prc.numberOfOpenSites());
        System.out.println(prc.percolates());
    }
}
