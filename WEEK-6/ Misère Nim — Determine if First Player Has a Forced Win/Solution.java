
import java.util.*;

class Solution {

    // 🎮 Misère Nim Solver
    // Time Complexity: O(1) ⚡, Space Complexity: O(1) 📦
    public boolean misereNim(int[] heaps) {
        boolean allOnes = true;
        for (int h : heaps) {
            if (h != 1) {
                allOnes = false;
                break;
            }
        }

        if (allOnes) {
            // 🪙 If all heaps are size 1 → first player wins iff heap count is even
            return heaps.length % 2 == 0;
        }

        // 🧮 Otherwise same as normal Nim → use nim-sum
        int xor = 0;
        for (int h : heaps) xor ^= h;
        return xor != 0;
    }

    // ▶️ Main Method for Testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {3, 4, 5};
        int[] test2 = {1, 1, 1};
        int[] test3 = {1, 1, 2};

        System.out.println("Input: [3,4,5] → Output: " + sol.misereNim(test1)); // True 
        System.out.println("Input: [1,1,1] → Output: " + sol.misereNim(test2)); // False 
        System.out.println("Input: [1,1,2] → Output: " + sol.misereNim(test3)); // True 
    }
}

