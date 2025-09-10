/*
Problem: Swap Even and Odd Bits
Company: Cisco
Difficulty: Medium
Topic: Bit Manipulation

Description:
Given an unsigned 8-bit integer (0 ≤ n ≤ 255), swap every even-positioned bit
with the adjacent odd-positioned bit.
Bits are counted from the right, starting at position 1.
*/

public class SwapEvenOddBits {

    /**
     * Approach 1: Brute Force Bit-by-Bit Swap
     * Time Complexity: O(1) (constant for 8 bits)
     */
    public static int bruteForceSwap(int n) {
        int result = 0;
        for (int i = 0; i < 8; i += 2) {
            int evenBit = (n >> (i + 1)) & 1;
            int oddBit = (n >> i) & 1;
            result |= (oddBit << (i + 1)) | (evenBit << i);
        }
        return result;
    }

    /**
     * Approach 2: Efficient Bitmasking
     * - Even bit mask: 0xAA (10101010)
     * - Odd bit mask: 0x55 (01010101)
     */
    public static int bitmaskSwap(int n) {
        int evenBits = n & 0xAA; // extract even-positioned bits
        int oddBits = n & 0x55;  // extract odd-positioned bits
        return (evenBits >> 1) | (oddBits << 1);
    }

    /**
     * Bonus: One-liner using bitwise operations
     */
    public static int oneLinerSwap(int n) {
        return ((n & 0xAA) >> 1) | ((n & 0x55) <<
