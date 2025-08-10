
// Week 2 - Problem 2: Find smallest positive integer NOT representable by subset sums

import java.util.*;

public class SmallestNonRepresentableSum {

    // ---------------------------------------------------
    // Approach 1: Brute Force (Exponential - For small inputs only)
    // ---------------------------------------------------
    /*
    // Generates all subset sums recursively and stores in a set
    public static long bruteForceSmallestMissing(long[] coins) {
        Set<Long> sums = new HashSet<>();
        generateSums(coins, 0, 0, sums);

        long res = 1;
        while (true) {
            if (!sums.contains(res)) return res;
            res++;
        }
    }

    private static void generateSums(long[] coins, int index, long currentSum, Set<Long> sums) {
        if (index == coins.length) {
            sums.add(currentSum);
            return;
        }
        // Include coins[index]
        generateSums(coins, index + 1, currentSum + coins[index], sums);
        // Exclude coins[index]
        generateSums(coins, index + 1, currentSum, sums);
    }
    */

    // ---------------------------------------------------
    // Approach 2: Greedy Linear-Time Algorithm (Optimal)
    // ---------------------------------------------------
    public static long findSmallestNonRepresentable(long[] coins) {
        long res = 1; // smallest positive integer not yet representable

        for (long coin : coins) {
            if (coin <= res) {
                res += coin;
            } else {
                break;
            }
        }

        return res;
    }
}
