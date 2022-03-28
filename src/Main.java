public class Main {

    public static void main(String[] args) {
        PercolationStats m = new PercolationStats(200, 100);
        System.out.println(m.mean());
        System.out.println(m.stddev());
        System.out.println(m.confidenceLo());
        System.out.println(m.confidenceHi());
    }
}
