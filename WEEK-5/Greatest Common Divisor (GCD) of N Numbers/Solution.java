import java.util.*;
import java.math.BigInteger;

class Solution {

    // ---------- APPROACH 1: Iterative Euclidean Algorithm ----------
    // public int gcdIterative(int[] arr) {
    //     int result = arr[0];
    //     for (int i = 1; i < arr.length; i++) {
    //         result = gcdTwoNumbersIterative(result, arr[i]);
    //         if (result == 1) break; // Early exit if GCD becomes 1
    //     }
    //     return result;
    // }

    // private int gcdTwoNumbersIterative(int a, int b) {
    //     while (b != 0) {
    //         int temp = b;
    //         b = a % b;
    //         a = temp;
    //     }
    //     return a;
    // }

    // ---------- APPROACH 2: Recursive Euclidean Algorithm ----------
    // public int gcdRecursive(int[] arr) {
    //     int result = arr[0];
    //     for (int i = 1; i < arr.length; i++) {
    //         result = gcdTwoNumbersRecursive(result, arr[i]);
    //         if (result == 1) break;
    //     }
    //     return result;
    // }

    // private int gcdTwoNumbersRecursive(int a, int b) {
    //     if (b == 0) return a;
    //     return gcdTwoNumbersRecursive(b, a % b);
    // }

    // ---------- APPROACH 3: Java's Built-in BigInteger.gcd ----------
    public int gcdUsingLibrary(int[] arr) {
        BigInteger result = BigInteger.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result = result.gcd(BigInteger.valueOf(arr[i]));
            if (result.equals(BigInteger.ONE)) break;
        }
        return result.intValue();
    }

    // ---------- MAIN METHOD FOR TESTING ----------
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);

    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         arr[i] = sc.nextInt();
    //     }

    //     Solution sol = new Solution();

    //     // Example: Run all three approaches
    //     System.out.println("GCD (Iterative): " + sol.gcdIterative(arr));
    //     System.out.println("GCD (Recursive): " + sol.gcdRecursive(arr));
    //     System.out.println("GCD (Library): " + sol.gcdUsingLibrary(arr));

    //     sc.close();
    // }
}
