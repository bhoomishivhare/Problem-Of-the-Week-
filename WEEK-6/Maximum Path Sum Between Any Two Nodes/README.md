#  Maximum Path Sum Between Any Two Nodes


**Difficulty:** 🔴 Hard  
**Topic:** Binary Tree, DFS, Recursion  

---

## 📌 Problem Statement
You are given a **binary tree** where each node contains an integer value.  
Your task is to **find the maximum path sum between any two nodes**.

- The path must go through at least one node.  
- The path does **not** need to pass through the root.  
- A path is a sequence of nodes connected by edges, and each node can appear only once.  

---


## 🛠️ Approaches

### 1️⃣ Brute Force (All Paths) ❌
- Generate all possible paths between pairs of nodes.  
- Compute the sum for each path and track the maximum.  
- **Issue:** Exponential complexity `O(n^2)` to `O(n^3)` in worst cases. Not feasible for large trees.

---

### 2️⃣ Simple DFS (Return Only Max Gain) ⚠️
- Perform DFS and for each node return:
  - `node.val + max(dfs(left), dfs(right))`  
- This computes the **maximum root-to-leaf path**, but **misses the case where the path goes through both left and right children**.  
- Example: It would miss `15 → 20 → 7` in the example tree.

---

### 3️⃣ Optimized DFS with Global Max ✅ (Correct Approach)
- Use **post-order traversal**:
  1. Compute max path sum from left child (`leftMax`).
  2. Compute max path sum from right child (`rightMax`).
  3. If a child contributes negatively, ignore it (`max(0, dfs(...))`).  
  4. Update a **global maximum**:  
     ```
     globalMax = max(globalMax, node.val + leftMax + rightMax)
     ```
  5. Return the max **gain to parent**:  
     ```
     node.val + max(leftMax, rightMax)
     ```
- This ensures:
  - Local decisions contribute to global maximum.  
  - Handles both straight paths and paths passing through the node.  

**Complexity:**  
- **Time:** `O(n)` (each node visited once).  
- **Space:** `O(h)` where `h` = height of tree (recursion stack).  

---

## 🧮 Algorithm (Step by Step)
1. Initialize `globalMax = -∞`.  
2. Run DFS:
   - If node is `null`, return `0`.  
   - Get left contribution: `leftMax = max(0, dfs(node.left))`.  
   - Get right contribution: `rightMax = max(0, dfs(node.right))`.  
   - Update global answer: `globalMax = max(globalMax, node.val + leftMax + rightMax)`.  
   - Return to parent: `node.val + max(leftMax, rightMax)`.  
3. Final answer = `globalMax`.  

---
