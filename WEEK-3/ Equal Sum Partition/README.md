------------------------------------------------------------
 Equal Sum Partition-

## 📝 Problem Statement  
Given a multiset (list) of non-negative integers, determine if it can be partitioned into two subsets such that the sum of elements in both subsets is equal.

---

## 🔹 Approach 1: Check Sum and Recursion with Memoization  
💡 Idea:  
- Calculate total sum of the array.  
- If sum is odd → immediately return false (cannot partition evenly).  
- Otherwise, the problem reduces to finding if there exists a subset with sum = total_sum / 2.  
- Use recursion + memoization to check if subset with target sum exists.

📍 Steps:  
1. Calculate total sum → if odd return false  
2. Use a recursive function `canPartitionFrom(i, target)` that tries to include or exclude the current element  
3. Memoize results for `(i, target)` to avoid recomputation  
4. Return true if subset sum equals target found

⏳ Complexity:  
Time: O(n * sum/2)  
Space: O(n * sum/2)

---

------------------------------------------------------------
## 🔹 Approach 2: Dynamic Programming (Bottom-Up)  
💡 Idea:  
- Similar to subset sum problem.  
- Use a boolean DP table `dp[i][j]` indicating if a subset of first i elements can achieve sum j.  
- Initialize dp with base cases and fill iteratively.

📍 Steps:  
1. Calculate total sum → if odd return false  
2. Create dp table of size (n+1) x (target+1) where target = total_sum/2  
3. dp[0][0] = true (empty subset)  
4. For each element and sum, update dp based on including or excluding current element  
5. Return dp[n][target]

⏳ Complexity:  
Time: O(n * sum/2)  
Space: O(n * sum/2)

---

------------------------------------------------------------
## 🔹 Approach 3: Space Optimized DP  
💡 Idea:  
- Use a 1D boolean array to save space, iterating sums backward for each element.  
- Same logic as bottom-up DP, but space is reduced to O(sum/2).

---

