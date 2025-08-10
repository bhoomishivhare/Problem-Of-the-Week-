📝 Problem Statement
Given three strings S1, S2, and S3, compute the length of the longest subsequence common to all three.
A subsequence appears in the same relative order but not necessarily contiguous.

🔹 Approach 1: Brute Force (Exponential)
💡 Idea:
Generate all subsequences of one string and check if they are subsequences of the other two strings. Find the longest such subsequence.

📍 Steps:
Step 1: Generate all subsequences of S1 (2^|S1|).
Step 2: For each subsequence, check if it’s a subsequence of S2 and S3.
Step 3: Track the maximum length of such subsequences.

⏳ Complexity:
Time: O(2^n * n) — too large for n=100
Space: O(n)

⚠️ Note: This approach is impractical for the given constraints.
------------------------------------------------------------------------------------------------------------------------

🔹 Approach 2: Top-Down DP with Memoization
💡 Idea:
Use recursion with memoization to avoid recalculations.
Define a function lcs(i, j, k) returning length of LCS of S1[0..i-1], S2[0..j-1], S3[0..k-1].

📍 Transition:

If S1[i-1] == S2[j-1] == S3[k-1]:
 lcs(i, j, k) = 1 + lcs(i-1, j-1, k-1)

Else:
 lcs(i, j, k) = max(lcs(i-1, j, k), lcs(i, j-1, k), lcs(i, j, k-1))

📍 Steps:
Step 1: Initialize a 3D memo array dp with -1.
Step 2: Recursively compute lcs(i, j, k) using above relations, caching results.
Step 3: Return lcs(len(S1), len(S2), len(S3)).

⏳ Complexity:
Time: O(n³)
Space: O(n³) for memoization table + recursion stack


------------------------------------------------------------------------------------------------------------------------
🔹 Approach 3: Bottom-Up Dynamic Programming (3D DP) ✅
💡 Idea:
Build a 3D DP table iteratively to avoid recursion overhead.

📍 Steps:
Step 1: Create a 3D DP array dp of size (len(S1)+1) x (len(S2)+1) x (len(S3)+1) initialized with 0.
Step 2: Iterate over i, j, k from 1 to lengths of S1, S2, S3 respectively.
Step 3: If S1[i-1] == S2[j-1] == S3[k-1], then
 dp[i][j][k] = 1 + dp[i-1][j-1][k-1]
Else,
 dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1])
Step 4: Return dp[len(S1)][len(S2)][len(S3)].

⏳ Complexity:
Time: O(n³)
Space: O(n³)

📌 Example
Input:
epidemiologist
refrigeration
supercalifragilisticexpialodocious
Output:
5
Explanation:
Longest common subsequence among all three is "eieio".
