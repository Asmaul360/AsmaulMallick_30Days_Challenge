/*
    Problem: Simple Array Sum

    Given an array of integers, find the sum of its elements.

    Input Format:
    - First line contains an integer n (size of array)
    - Second line contains n space-separated integers

    Output Format:
    - Print the sum of all elements

    Example:
    Input:
    5
    1 2 3 4 5

    Output:
    15

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

import java.util.*;

public class Main {

    // Function to calculate sum of array
    public static int simpleArraySum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call function
        int result = simpleArraySum(arr);

        // Print result
        System.out.println(result);

        sc.close();
    }
}