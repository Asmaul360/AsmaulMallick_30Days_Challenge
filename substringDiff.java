import java.util.*;

public class substringDiff {

    public static int substringDiff(int k, String s1, String s2) {
        int n = s1.length();
        int maxLen = 0;

        for (int d = -n + 1; d < n; d++) {
            int i = Math.max(0, d);
            int j = Math.max(0, -d);

            int left = 0, mismatches = 0;

            for (int right = 0; i + right < n && j + right < n; right++) {

                if (s1.charAt(i + right) != s2.charAt(j + right)) {
                    mismatches++;
                }

                while (mismatches > k) {
                    if (s1.charAt(i + left) != s2.charAt(j + left)) {
                        mismatches--;
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); 
        while (t-- > 0) {
            int k = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(substringDiff(k, s1, s2));
        }

        sc.close();
    }
}