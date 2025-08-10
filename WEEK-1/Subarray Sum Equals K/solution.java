// 📌 Subarray Sum Equals K
// Week 1 - Problem 2
// Contains Brute Force, Better, and Optimal Approaches

import java.util.*;

public class SubarraySumEqualsK {

    // ---------------------------------------------------
    // Brute Force Approach (O(n^2), O(1))
    // ---------------------------------------------------
    public static int subarraySumBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // ---------------------------------------------------
    // Better Approach - Prefix Sum Array (O(n^2), O(n))
    // ---------------------------------------------------
    public static int subarraySumBetter(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefix[j + 1] - prefix[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // ---------------------------------------------------
    // Optimal Approach - Prefix Sum + HashMap (O(n), O(n))
    // ---------------------------------------------------
    public static int subarraySumOptimal(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: sum 0 has frequency 1

        for (int num : nums) {
            sum += num;

            // Check if sum - k exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update frequency of sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
