📝 Problem Statement
You are managing the painting of n houses, each can be painted with one of k colors. The painting cost for house i with color j is given by costs[i][j].
Constraints:
No two adjacent houses can have the same color.
The goal is to minimize the total painting cost.

🔹 Brute Force Approach
💡 Idea:
Try all possible color combinations for each house, skipping those where adjacent houses share the same color. Choose the minimum total cost from all valid combinations.

📍 Steps:
Step 1: Start from house 0, try painting with each color.
Step 2: For each choice, recurse to house 1, only with colors different from house 0’s color.
Step 3: Continue recursively for all houses.
Step 4: Return the minimum cost found.

⏳ Complexity:
Time: O(k^n) (Exponential) ⚠️
Space: O(n) (Recursion stack)
------------------------------------------------------------------------------------------------------------------------------------------

🔹 Better Approach (Dynamic Programming - O(n * k^2))
💡 Idea:
Use DP to store minimum costs for painting up to house i with color j. For each house, calculate cost by adding the current paint cost to the minimum cost of painting the previous house with a different color.

📍 Steps:
Step 1: Initialize DP array dp[n][k].
Step 2: For house 0, dp[0][j] = costs[0][j].
Step 3: For each house i from 1 to n-1:
  - For each color j:
   - Find min cost from dp[i-1][x] where x != j
   - Add costs[i][j]
Step 4: Result = min value in dp[n-1].

⏳ Complexity:
Time: O(n * k^2) ⏱️
Space: O(n * k) 📦
------------------------------------------------------------------------------------------------------------------------------------------
🔹 Optimal Approach (Dynamic Programming - O(n * k)) ✅
💡 Idea:
Track the minimum and second minimum costs from the previous house. For the current house and color:
If color == color of minimum cost from previous house, add second minimum cost.
Else, add minimum cost.

📍 Steps:
Step 1: Initialize variables for minCost, secondMinCost and their color indices for the previous house.
Step 2: For each house i:
  - For each color j:
   - If j == minCost color index from previous house, cost = secondMinCost + costs[i][j]
   - Else cost = minCost + costs[i][j]
  - Update new minCost and secondMinCost with their indices for house i.
Step 3: After last house, minimum cost is minCost.

⏳ Complexity:
Time: O(n * k) ⚡
Space: O(k) 📦

📌 Example
Input:
2 3
1 5 3
2 9 4
Output:
5
Explanation:
Paint house 0 with color 0 (cost=1), house 1 with color 2 (cost=4) → total 5
Or house 0 with color 2 (cost=3), house 1 with color 0 (cost=2) → total 5
