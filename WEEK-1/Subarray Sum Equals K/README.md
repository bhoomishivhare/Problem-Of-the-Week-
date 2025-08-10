Problem Statement-
Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals k.

🔹 Brute Force Approach
💡 Idea:
Check all possible subarrays using two nested loops.
For each subarray, calculate the sum and compare with k.

📍 Steps:
Step 1: Loop i from 0 to n-1 (start index)
Step 2: Loop j from i to n-1 (end index)
Step 3: Calculate sum for each subarray
Step 4: If sum == k, increment count

⏳ Complexity:
Time: O(n²)
Space: O(1)
---------------------------------------------------------------------------------------------------------------------------------------------

🔹 Better Approach (Prefix Sum Array)
💡 Idea:
Precompute a prefix sum array where prefix[i] = sum of first i elements.
Sum of subarray (i, j) = prefix[j+1] - prefix[i]

📍 Steps:
Step 1: Build prefix sum array
Step 2: For each (i, j), calculate sum using prefix array
Step 3: If sum == k, increment count

⏳ Complexity:
Time: O(n²)
Space: O(n)
---------------------------------------------------------------------------------------------------------------------------------------------
🔹 Optimal Approach (Prefix Sum + HashMap) ✅
💡 Idea:
Use a running sum while iterating.
Store frequency of each running sum in a HashMap.
If (current_sum - k) exists in the map, we’ve found subarrays ending here with sum = k.

📍 Steps:
Step 1: Initialize count = 0, sum = 0, and map = {0: 1} (base case)
Step 2: For each element in the array:
  - Add it to running sum
  - If (sum - k) exists in map, add its frequency to count
  - Update frequency of sum in map
Step 3: Return count

⏳ Complexity:
Time: O(n)
Space: O(n)
