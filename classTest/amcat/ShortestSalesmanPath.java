package classTest.amcat;
import java.util.*;

public class ShortestSalesmanPath {

    static double minDistance = Double.MAX_VALUE;

    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) +
                         (y1 - y2) * (y1 - y2));
    }

    static void permute(List<double[]> points, boolean[] used,
                        double currX, double currY,
                        double currDist, int count) {

        if (count == points.size()) {
            minDistance = Math.min(minDistance, currDist);
            return;
        }

        for (int i = 0; i < points.size(); i++) {
            if (!used[i]) {
                used[i] = true;

                double[] p = points.get(i);
                double d = distance(currX, currY, p[0], p[1]);

                permute(points, used,
                        p[0], p[1],
                        currDist + d, count + 1);

                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int startingSalesMan = sc.nextInt();
        int numberOfRetailers = sc.nextInt();

        int[] retailers = new int[numberOfRetailers];
        for (int i = 0; i < numberOfRetailers; i++) {
            retailers[i] = sc.nextInt();
        }

        int headRetailerX = sc.nextInt();
        int headRetailerY = sc.nextInt();

        // Starting point
        double startX = startingSalesMan;
        double startY = 0;

        // Collect all visit points (retailers + head retailer)
        List<double[]> points = new ArrayList<>();

        for (int x : retailers) {
            points.add(new double[]{x, 0});
        }

        // Head retailer
        points.add(new double[]{headRetailerX, headRetailerY});

        boolean[] used = new boolean[points.size()];

        // Start permutation
        permute(points, used, startX, startY, 0.0, 0);

        // Output
        System.out.printf("%.6f%n", minDistance);

        sc.close();
    }
}
