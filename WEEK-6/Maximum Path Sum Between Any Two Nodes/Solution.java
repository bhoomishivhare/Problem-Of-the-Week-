// Maximum Path Sum Between Any Two Nodes


// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {

    // -------------------------------------------------
    // Approach 1: Brute Force (Check All Paths)
    // Time Complexity: Exponential (O(n^2) to O(n^3))
    // Space Complexity: O(h) for recursion
    // Not feasible for large trees
    // -------------------------------------------------
    public int bruteForceMaxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        List<TreeNode> nodes = new ArrayList<>();
        collectNodes(root, nodes);
        int maxSum = Integer.MIN_VALUE;
        for (TreeNode u : nodes) {
            for (TreeNode v : nodes) {
                maxSum = Math.max(maxSum, pathSum(u, v));
            }
        }
        return maxSum;
    }

    private void collectNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        nodes.add(root);
        collectNodes(root.left, nodes);
        collectNodes(root.right, nodes);
    }

    private int pathSum(TreeNode u, TreeNode v) {
        List<TreeNode> path = new ArrayList<>();
        findPath(u, v, new ArrayList<>(), path);
        int sum = 0;
        for (TreeNode node : path) sum += node.val;
        return sum;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> temp, List<TreeNode> path) {
        if (root == null) return false;
        temp.add(root);
        if (root == target) {
            path.addAll(temp);
            return true;
        }
        if (findPath(root.left, target, temp, path) || findPath(root.right, target, temp, path))
            return true;
        temp.remove(temp.size() - 1);
        return false;
    }

    // -------------------------------------------------
    // Approach 2: Simple DFS (Postorder Traversal)
    // For each node, compute maximum path including one child
    // and update global maximum with both children
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    // -------------------------------------------------
    private int maxSum;
    public int simpleDFSMaxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        simpleDFS(root);
        return maxSum;
    }

    private int simpleDFS(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, simpleDFS(node.left));
        int right = Math.max(0, simpleDFS(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    // -------------------------------------------------
    // Approach 3: Optimized DFS (Cleaned & Efficient)
    // Same logic but streamlined for readability
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    // -------------------------------------------------
    public int optimizedMaxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }

    private int globalMax;
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        globalMax = Math.max(globalMax, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    // -------------------------------------------------
    // Main Method for Testing
    // -------------------------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example Tree: -10 / \ 9 20 / \ 15 7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Brute Force: " + sol.bruteForceMaxPathSum(root));  // May be slow
        System.out.println("Simple DFS: " + sol.simpleDFSMaxPathSum(root));    // 42
        System.out.println("Optimized DFS: " + sol.optimizedMaxPathSum(root)); // 42
    }
}
