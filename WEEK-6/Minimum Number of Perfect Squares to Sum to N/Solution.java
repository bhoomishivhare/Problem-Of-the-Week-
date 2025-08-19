```java
import java.util.*;

class Solution {

    // ------------------ Approach 1: Brute Force (Recursion) ------------------
    public int numSquaresBruteForce(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minCount = Math.min(minCount, 1 + helper(n - i * i));
        }
        return minCount;
    }

    // ------------------ Approach 2: Recursion + Memoization ------------------
    public int numSquaresMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoHelper(n, dp);
    }

    private int memoHelper(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minCount = Math.min(minCount, 1 + memoHelper(n - i * i, dp));
        }
        return dp[n] = minCount;
    }

    // ------------------ Approach 3: Dynamic Programming ----------------------
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    // ------------------ Approach 4: BFS (Graph-based approach) ---------------
    public int numSquaresBFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int s = 0; s < size; s++) {
                int curr = queue.poll();
                for (int i = 1; i * i <= curr; i++) {
                    int next = curr - i * i;
                    if (next == 0) return level;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return level;
    }

    // ------------------ Approach 5: Mathematical -----------------------------
    public int numSquaresMath(int n) {
        if (isPerfectSquare(n)) return 1;
        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i)) return 2;
        }
        while (n % 4 == 0) n /= 4;
        if (n % 8 != 7) return 3;
        return 4;
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }


