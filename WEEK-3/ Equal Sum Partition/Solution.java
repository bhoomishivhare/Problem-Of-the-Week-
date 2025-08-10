// ⚖️ Equal Sum Partition
// Week X - Problem: Determine if array can be split into two equal sum subsets

import java.util.*;

public class EqualSumPartition {

    // ---------------------------------------------------
    // Approach 1: Recursion + Memoization
    // ---------------------------------------------------
    // public static boolean canPartitionRecursive(int[] nums) {
    //     int totalSum = 0;
    //     for (int num : nums) totalSum += num;
    //     if (totalSum % 2 != 0) return false;

    //     int target = totalSum / 2;
    //     Boolean[][] memo = new Boolean[nums.length][target + 1];
    //     return canPartitionFrom(nums, 0, target, memo);
    // }

    // private static boolean canPartitionFrom(int[] nums, int index, int target, Boolean[][] memo) {
    //     if (target == 0) return true;
    //     if (index >= nums.length || target < 0) return false;

    //     if (memo[index][target] != null) return memo[index][target];

    //     // Choose current number
    //     boolean include = canPartitionFrom(nums, index + 1, target - nums[index], memo);

    //     // Skip current number
    //     boolean exclude = canPartitionFrom(nums, index + 1, target, memo);

    //     memo[index][target] = include || exclude;
    //     return memo[index][target];
    // }

    // ---------------------------------------------------
    // Approach 2: Bottom-Up Dynamic Programming
    // ---------------------------------------------------
    // public static boolean canPartitionDP(int[] nums) {
    //     int totalSum = 0;
    //     for (int num : nums) totalSum += num;
    //     if (totalSum % 2 != 0) return false;

    //     int target = totalSum / 2;
    //     int n = nums.length;
    //     boolean[][] dp = new boolean[n + 1][target + 1];

    //     // Base case: sum 0 is always possible with empty subset
    //     for (int i = 0; i <= n; i++) dp[i][0] = true;

    //     for (int i = 1; i <= n; i++) {
    //         for (int sum = 1; sum <= target; sum++) {
    //             if (nums[i - 1] <= sum) {
    //                 dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
    //             } else {
    //                 dp[i][sum] = dp[i - 1][sum];
    //             }
    //         }
    //     }

    //     return dp[n][target];
    // }

    // ---------------------------------------------------
    // Approach 3: Space Optimized DP
    // ---------------------------------------------------
    public static boolean canPartitionOptimized(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }
}
