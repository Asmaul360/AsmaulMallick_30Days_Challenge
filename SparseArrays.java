import java.util.*;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> freq = new HashMap<>();

        // Count frequencies
        for (String s : stringList) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Answer queries
        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            result.add(freq.getOrDefault(q, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of strings
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringList.add(sc.nextLine());
        }

        // Read number of queries
        int q = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }

        // Get results
        List<Integer> result = matchingStrings(stringList, queries);

        // Print output
        for (int count : result) {
            System.out.println(count);
        }

        sc.close();
    }
}