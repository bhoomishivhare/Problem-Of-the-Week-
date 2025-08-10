// 🔤 Longest Common Subsequence of Three Strings
// Week 2 - Problem 1

import java.util.Scanner;

public class LongestCommonSubsequence3Strings {

    // ---------------------------------------------------
    // Bottom-Up DP Approach - O(n^3), O(n^3)
    // ---------------------------------------------------
    public static int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // dp[i][j][k] stores LCS length of s1[0..i-1], s2[0..j-1], s3[0..k-1]
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        return dp[n1][n2][n3];
    }
}
