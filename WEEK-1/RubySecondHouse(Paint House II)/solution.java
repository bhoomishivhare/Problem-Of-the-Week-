// 🏠 Ruby Second House (Paint House II)
// Week 1- Problem: Minimize painting cost with no two adjacent houses having same color

import java.util.*;

public class RubySecondHouse {

    // ---------------------------------------------------
    // Brute Force Approach (Exponential) - O(k^n), O(n)
    // ---------------------------------------------------
    public static int paintHouseBrute(int[][] costs) {
        return helper(costs, 0, -1);
    }

    private static int helper(int[][] costs, int house, int prevColor) {
        if (house == costs.length) return 0;

        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < costs[0].length; color++) {
            if (color != prevColor) {
                int cost = costs[house][color] + helper(costs, house + 1, color);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    // ---------------------------------------------------
    // Better DP Approach - O(n * k^2), O(n * k)
    // ---------------------------------------------------
    public static int paintHouseBetter(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];

        // Initialize first house costs
        for (int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
        }

        for (int house = 1; house < n; house++) {
            for (int color = 0; color < k; color++) {
                dp[house][color] = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < k; prevColor++) {
                    if (prevColor != color) {
                        dp[house][color] = Math.min(dp[house][color], dp[house - 1][prevColor] + costs[house][color]);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            minCost = Math.min(minCost, dp[n - 1][color]);
        }
        return minCost;
    }

    // ---------------------------------------------------
    // Optimal DP Approach - O(n * k), O(k)
    // ---------------------------------------------------
    public static int paintHouseOptimal(int[][] costs) {
        int n = costs.length, k = costs[0].length;

        // prevMin and prevSecondMin track smallest and second smallest costs of previous house
        // prevMinColor is the color of the smallest cost
        int prevMin = 0, prevSecondMin = 0, prevMinColor = -1;

        for (int house = 0; house < n; house++) {
            int currMin = Integer.MAX_VALUE, currSecondMin = Integer.MAX_VALUE, currMinColor = -1;

            for (int color = 0; color < k; color++) {
                int cost = costs[house][color];
                // If this color is same as previous house’s min color, use second min
                int totalCost = cost + (color == prevMinColor ? prevSecondMin : prevMin);

                // Track current min and second min for next iteration
                if (totalCost < currMin) {
                    currSecondMin = currMin;
                    currMin = totalCost;
                    currMinColor = color;
                } else if (totalCost < currSecondMin) {
                    currSecondMin = totalCost;
                }
            }

            prevMin = currMin;
            prevSecondMin = currSecondMin;
            prevMinColor = currMinColor;
        }

        return prevMin;
    }

}
