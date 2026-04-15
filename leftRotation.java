
import java.util.*;

public class leftRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
System.out.println("Enter the value of n :");
        int n = sc.nextInt(); 
        
        int[] arr = new int[n];
        System.out.println("Enter the numbers : ");
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of d : ");
        int d = sc.nextInt(); 
     
        rotate(arr, d);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void rotate(int[] arr, int d){
        int n = arr.length;
        if(n == 0) return;

        d = d % n;

        reverse(arr, 0, d - 1);

        reverse(arr, d, n - 1);

        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}