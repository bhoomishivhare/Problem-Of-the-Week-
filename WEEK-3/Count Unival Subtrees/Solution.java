
// Week 3 - Problem-2: Count number of unival (universal value) subtrees in a binary tree

import java.util.*;

public class CountUnivalSubtrees {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }

    // ---------------------------------------------------
    // Approach 1: Recursive Post-order Traversal (Most common)
    // ---------------------------------------------------
    private int count1 = 0;

    public int countUnivalSubtreesRecursive(TreeNode root) {
        count1 = 0;
        isUnival(root);
        return count1;
    }

    // Returns true if subtree rooted at node is unival, increments count if yes
    private boolean isUnival(TreeNode node) {
        if (node == null) return true;

        boolean leftUni = isUnival(node.left);
        boolean rightUni = isUnival(node.right);

        if (!leftUni || !rightUni) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count1++;
        return true;
    }

    // ---------------------------------------------------
    // Approach 2: Iterative Post-order Traversal
    // ---------------------------------------------------
    // Note: This approach uses two stacks to simulate post-order traversal and 
    // maintains a map from node to Boolean indicating unival status.
    public int countUnivalSubtreesIterative(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Map<TreeNode, Boolean> univalMap = new HashMap<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        int count = 0;
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();

            boolean leftUni = (node.left == null) || univalMap.getOrDefault(node.left, false);
            boolean rightUni = (node.right == null) || univalMap.getOrDefault(node.right, false);

            boolean isUni = false;
            if (leftUni && rightUni) {
                if (node.left != null && node.left.val != node.val) {
                    isUni = false;
                } else if (node.right != null && node.right.val != node.val) {
                    isUni = false;
                } else {
                    isUni = true;
                }
            }

            if (isUni) count++;
            univalMap.put(node, isUni);
        }

        return count;
    }

    // ---------------------------------------------------
    // Approach 3: Bottom-Up DP with Helper Class (Memoization style)
    // ---------------------------------------------------
    private static class Result {
        boolean isUnival;
        int count;

        Result(boolean isUnival, int count) {
            this.isUnival = isUnival;
            this.count = count;
        }
    }

    public int countUnivalSubtreesDP(TreeNode root) {
        return helper(root).count;
    }

    private Result helper(TreeNode node) {
        if (node == null) return new Result(true, 0);

        Result leftRes = helper(node.left);
        Result rightRes = helper(node.right);

        boolean isUni = false;
        if (leftRes.isUnival && rightRes.isUnival) {
            if ((node.left == null || node.left.val == node.val) &&
                (node.right == null || node.right.val == node.val)) {
                isUni = true;
            }
        }

        int totalCount = leftRes.count + rightRes.count + (isUni ? 1 : 0);
        return new Result(isUni, totalCount);
    }
}
