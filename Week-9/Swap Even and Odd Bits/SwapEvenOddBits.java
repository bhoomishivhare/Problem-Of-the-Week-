import java.util.*;

public class SwapEvenOddBits {

    // -------------------------
    // 1. Brute Force Bit-by-Bit Swap
    // -------------------------
    public static int swapBitsBruteForce(int n) {
        for (int i = 0; i < 8; i += 2) {
            // bit at position i (0-based from right)
            int bit1 = (n >> i) & 1;
            // bit at position i+1
            int bit2 = (n >> (i + 1)) & 1;

            // if bits differ, swap them
            if (bit1 != bit2) {
                // toggle both bits
                n ^= (1 << i);
                n ^= (1 << (i + 1));
            }
        }
        return n;
    }

    // -------------------------
    // 2. Efficient Bitmasking Approach (One-Liner)
    // -------------------------
    public static int swapBitsEfficient(int n) {
        return ((n & 0xAA) >> 1) | ((n & 0x55) << 1);
    }

    // -------------------------
    // MAIN
    // -------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Brute Force
        int bruteResult = swapBitsBruteForce(n);
        System.out.println("Brute Force Result: " + bruteResult);

        // Efficient One-Liner
        int efficientResult = swapBitsEfficient(n);
        System.out.println("Efficient Result: " + efficientResult);
    }
}
