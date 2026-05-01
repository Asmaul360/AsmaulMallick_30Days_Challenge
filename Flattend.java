import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        int n = sc.nextInt();  // total cities
        int m = sc.nextInt();  // number of stations

        int[] c = new int[m];

        // read station positions
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }

        // sort station positions
        Arrays.sort(c);

        // calculate max distance
        int maxDist = 0;

        // distance from start to first station
        maxDist = c[0];

        // check gaps between stations
        for (int i = 1; i < m; i++) {
            int gap = (c[i] - c[i - 1]) / 2;
            maxDist = Math.max(maxDist, gap);
        }

        // distance from last station to end
        maxDist = Math.max(maxDist, (n - 1) - c[m - 1]);

        // output
        System.out.println(maxDist);

        sc.close();
    }
}
