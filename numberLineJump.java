import java.util.*;

public class Kangaroo {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        // If one is behind and slower → never meet
        if (x1 < x2 && v1 <= v2) {
            return "NO";
        }

        if (x2 < x1 && v2 <= v1) {
            return "NO";
        }

        // Check if they meet
        if ((x2 - x1) % (v1 - v2) == 0) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1, v1, x2, v2: ");

        int x1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v2 = sc.nextInt();

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println("Result: " + result);

        sc.close();
    }
}
